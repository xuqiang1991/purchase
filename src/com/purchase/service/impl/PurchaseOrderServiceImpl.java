package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.purchase.mapper.admin.TbAdminMapper;
import com.purchase.mapper.admin.TbProjectMangerMapper;
import com.purchase.mapper.admin.TbSupplierMapper;
import com.purchase.mapper.order.BizPurchaseOrderDetailMapper;
import com.purchase.mapper.order.BizPurchaseOrderMapper;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbProjectManger;
import com.purchase.pojo.admin.TbSupplier;
import com.purchase.pojo.order.*;
import com.purchase.service.PurchaseOrderService;
import com.purchase.util.*;
import com.purchase.vo.OrderHistory;
import com.purchase.vo.admin.ChoseAdminVO;
import com.purchase.vo.admin.ChosePurchaseOrderVO;
import com.purchase.vo.order.BizPurchaseOrderDetailsVo;
import com.purchase.vo.order.BizPurchaseOrderSearch;
import com.purchase.vo.order.BizPurchaseOrderVo;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	private BizPurchaseOrderDetailMapper purchaseOrderDetailMapper;

	@Autowired
	private BizPurchaseOrderMapper purchaseOrderMapper;

	@Autowired
	private TbSupplierMapper supplierMapper;

    @Autowired
    private TbProjectMangerMapper projectMangerMapper;

	@Autowired
	private TbAdminMapper adminMapper;

	@Override
	public ResultUtil getOrderList(Integer page, Integer limit, BizPurchaseOrderSearch search) {
			PageHelper.startPage(page, limit);

			BizPurchaseOrderExample example=new BizPurchaseOrderExample();
			//设置按创建时间降序排序
			example.setOrderByClause("update_date DESC");
			BizPurchaseOrderExample.Criteria criteria = example.createCriteria();

			if(StringUtils.isNotEmpty(search.getPurchaseNo())){
				//注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
				criteria.andPurchaseNoLike("%"+search.getPurchaseNo()+"%");
			}
			if(search.getType() != null){
				criteria.andTypeEqualTo(String.valueOf(search.getType()));
			}
			if(search.getSupplierId() != null){
				criteria.andSupplierIdEqualTo(search.getSupplierId());
			}
			if(StringUtils.isNotBlank(search.getProjectId())){
				criteria.andProjectIdEqualTo(search.getProjectId());
			}
			if(StringUtils.isNotBlank(search.getContractNo())){
				criteria.andContractNoLike("%"+search.getContractNo()+"%");
			}
			if(search.getCreateUser() != null){
				criteria.andCreateUserEqualTo(search.getCreateUser());
			}
			if(search.getCreateTime() != null){
				criteria.andCreateTimeEqualTo(search.getCreateTime());
			}
			if(search.getDepartUser() != null){
				BizPurchaseOrderExample.Criteria criteria1 = example.createCriteria();
				criteria1.andCostDepartUserEqualTo(search.getDepartUser());
				BizPurchaseOrderExample.Criteria criteria2 = example.createCriteria();
				criteria2.andProjectDepartUserEqualTo(search.getDepartUser());
				BizPurchaseOrderExample.Criteria criteria3 = example.createCriteria();
				criteria3.andManagerDepartUserEqualTo(search.getDepartUser());
				example.or(criteria3);
			}
			if(search.getDepartDate() != null){
				BizPurchaseOrderExample.Criteria criteria1 = example.createCriteria();
				criteria1.andCostDepartDateEqualTo(search.getDepartDate());
				BizPurchaseOrderExample.Criteria criteria2 = example.createCriteria();
				criteria2.andProjectDepartDateEqualTo(search.getDepartDate());
				BizPurchaseOrderExample.Criteria criteria3 = example.createCriteria();
				criteria3.andManagerDepartDateEqualTo(search.getDepartDate());
				example.or(criteria3);
			}

			List<BizPurchaseOrderVo> users = purchaseOrderMapper.selectByExampleExt(example, search);
			PageInfo<BizPurchaseOrderVo> pageInfo = new PageInfo<>(users);
			ResultUtil resultUtil = new ResultUtil();
			resultUtil.setCode(0);
			resultUtil.setCount(pageInfo.getTotal());
			resultUtil.setData(pageInfo.getList());
			return resultUtil;
	}

	@Override
	public ResultUtil addPurchaseOrder(BizPurchaseOrder order) {

		Date date = new Date();
		String id = null;
		if(StringUtils.isBlank(order.getId())){
			id = WebUtils.generateUUID();
			order.setId(id);

			//生成采购单号
			String yyddmm = DateUtil.formatDate(date,DateUtil.DateFormat3);
			String prefix = PurchaseUtil.prefix + yyddmm;
			String pn = purchaseOrderMapper.selMaxPurchaseNo(prefix);
			String purchaseNo = PurchaseUtil.generatePurchaseNo(pn);
			order.setPurchaseNo(purchaseNo);

			//参数补充
			order.setCreateTime(date);
			order.setUpdateDate(date);

			purchaseOrderMapper.insertSelective(order);
		}else {
			id = order.getId();
			order.setUpdateDate(date);
			purchaseOrderMapper.updateByPrimaryKeySelective(order);
		}
		return ResultUtil.ok(id);
	}

	@Override
	public ResultUtil editPurchaseOrder(BizPurchaseOrder order) {
		Date date = new Date();
		order.setUpdateDate(date);
		purchaseOrderMapper.updateByPrimaryKeySelective(order);
		return null;
	}

	/**
	 *
	 * 查询采购单号详情
	 * @param id
	 * @return
	 */
	@Override
	public BizPurchaseOrderDetailsVo selPurchaseOrder(String id) {
		BizPurchaseOrderDetailsVo detailsVo = new BizPurchaseOrderDetailsVo();

		//获取采购单
        BizPurchaseOrderVo vo =  getBizPurchaseOrderVo(id);
        Long userId = vo.getCreateUser();
		detailsVo.setPurchaseOrder(vo);

		//获取采购单详情
		String purchaseNo = vo.getPurchaseNo();
		BizPurchaseOrderDetailExample example = new BizPurchaseOrderDetailExample();
		BizPurchaseOrderDetailExample.Criteria criteria = example.createCriteria();
		criteria.andPurchaseNoEqualTo(purchaseNo);
		List<BizPurchaseOrderDetail> detailList = purchaseOrderDetailMapper.selectByExample(example);
		detailsVo.setDetails(detailList);

		//审核历史
		List<OrderHistory> historyList = new ArrayList<OrderHistory>();
		int status = vo.getStatus();
		if(PurchaseUtil.STATUS_0 == status){
			historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,PurchaseUtil.STATUS_0));
		}else if(PurchaseUtil.STATUS_1 == status){
			historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,PurchaseUtil.STATUS_0));
			historyList.add(new OrderHistory(vo.getAuAdmin().getFullname(),vo.getApplyDate(),"",true,PurchaseUtil.STATUS_1));
		}else if(PurchaseUtil.STATUS_2 == status){
			historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,PurchaseUtil.STATUS_0));
			historyList.add(new OrderHistory(vo.getAuAdmin().getFullname(),vo.getApplyDate(),"",true,PurchaseUtil.STATUS_1));
			historyList.add(new OrderHistory(vo.getCostAdmin().getFullname(),vo.getCostDepartDate(),vo.getCostDepartOpinion(),vo.getCostDepartApproval(),PurchaseUtil.STATUS_2));
		}else if(PurchaseUtil.STATUS_3 == status){
			historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,PurchaseUtil.STATUS_0));
			historyList.add(new OrderHistory(vo.getAuAdmin().getFullname(),vo.getApplyDate(),"",true,PurchaseUtil.STATUS_1));
			historyList.add(new OrderHistory(vo.getCostAdmin().getFullname(),vo.getCostDepartDate(),vo.getCostDepartOpinion(),vo.getCostDepartApproval(),PurchaseUtil.STATUS_2));
			historyList.add(new OrderHistory(vo.getProjectAdmin().getFullname(),vo.getProjectDepartDate(),vo.getProjectDepartOpinion(),vo.getProjectDepartApproval(),PurchaseUtil.STATUS_3));
		}else if(PurchaseUtil.STATUS_4 == status){
			historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,PurchaseUtil.STATUS_0));
			historyList.add(new OrderHistory(vo.getAuAdmin().getFullname(),vo.getApplyDate(),"",true,PurchaseUtil.STATUS_1));
			historyList.add(new OrderHistory(vo.getCostAdmin().getFullname(),vo.getCostDepartDate(),vo.getCostDepartOpinion(),vo.getCostDepartApproval(),PurchaseUtil.STATUS_2));
			historyList.add(new OrderHistory(vo.getProjectAdmin().getFullname(),vo.getProjectDepartDate(),vo.getProjectDepartOpinion(),vo.getProjectDepartApproval(),PurchaseUtil.STATUS_3));
			historyList.add(new OrderHistory(vo.getManagerAdmin().getFullname(),vo.getManagerDepartDate(),vo.getManagerDepartOpinion(),vo.getManagerDepartApproval(),PurchaseUtil.STATUS_4));
		}
		Collections.reverse(historyList);
		vo.setHistoryList(historyList);

		//选择审核人
		String roleName = "成本部";
		Long reviewUserId = null;
		if(PurchaseUtil.STATUS_1 == status){
			Long cId = vo.getCostDepartUser();
			if(cId != null){
				reviewUserId = vo.getCostDepartUser();
				roleName = "工程部";
			}
		}else if(PurchaseUtil.STATUS_2 == status){
			roleName = "总经理";
			reviewUserId = vo.getProjectDepartUser();
		}else if(PurchaseUtil.STATUS_3 == status){
			reviewUserId = vo.getManagerDepartUser();
		}
		if(roleName != null){
			TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
			long loginId = admin.getId();
			if(reviewUserId != null && reviewUserId == loginId){
				detailsVo.setReviewUserId(userId);
			}
			List<ChoseAdminVO> data = adminMapper.selectByRoleName(roleName);
			if(!CollectionUtils.isEmpty(data)){
				Gson gson = new Gson();
				String json = gson.toJson(data);
				detailsVo.setDeparts(json);
			}
		}

		return detailsVo;
	}


	@Override
	@Transactional
	public ResultUtil delPurchaseOrder(String id) {
		BizPurchaseOrder order = purchaseOrderMapper.selectByPrimaryKey(id);
		if(!(PurchaseUtil.STATUS_0 == order.getStatus())){
			return ResultUtil.error("非未提交状态的采购单不能删除！");
		}
		purchaseOrderMapper.deleteByPrimaryKey(id);

		BizPurchaseOrderDetailExample example = new BizPurchaseOrderDetailExample();
		example.createCriteria().andPurchaseNoEqualTo(id);
		purchaseOrderDetailMapper.deleteByExample(example);
		return ResultUtil.ok();
	}

	/**
	 * 采购单提交
	 * @param id
	 * @return
	 */
	@Override
	public ResultUtil submitPurchaseOrder(String id) {
		BizPurchaseOrder order = purchaseOrderMapper.selectByPrimaryKey(id);

		int status = order.getStatus();
		if(!(PurchaseUtil.STATUS_0 == status)){
			return ResultUtil.error("非未提交状态的采购单不能提交！");
		}

		BizPurchaseOrder tmp = new BizPurchaseOrder();
		tmp.setId(order.getId());
		tmp.setStatus(PurchaseUtil.STATUS_1);
		tmp.setApplyDate(new Date());
		purchaseOrderMapper.updateByPrimaryKeySelective(tmp);
		return ResultUtil.ok();
	}


	/**
	 * 采购单审核
	 * @param admin
	 * @param id
	 * @param auditResults
	 * @param applyUser
	 * @param auditOpinion
	 * @return
	 */
	@Override
	public ResultUtil reviewPurchaseOrder(TbAdmin admin, String id, Boolean auditResults, Long applyUser, String auditOpinion) {
		Date date = new Date();
		BizPurchaseOrder order = purchaseOrderMapper.selectByPrimaryKey(id);
		Long userId = admin.getId();
		int status = order.getStatus();

		//判断审核人
		Long reviewer = null;
		Boolean reviewerResults = null;
		if(PurchaseUtil.STATUS_1 == status){
			reviewer = order.getCostDepartUser();
			reviewerResults = order.getCostDepartApproval();
		}else if (PurchaseUtil.STATUS_2 == status){
			reviewer = order.getProjectDepartUser();
			reviewerResults = order.getProjectDepartApproval();
		}else if (PurchaseUtil.STATUS_3 == status){
			reviewer = order.getManagerDepartUser();
			reviewerResults = order.getManagerDepartApproval();
		}
		if(reviewer == null){
			return ResultUtil.error("审核人不存在");
		}
		if(reviewer.compareTo(userId) != 0){
			return ResultUtil.error("没有审核权限！");
		}
		if(reviewerResults != null && reviewerResults){
			return ResultUtil.error("请不要重新审核！");
		}

		//审核状态
		BizPurchaseOrder tmp = new BizPurchaseOrder();
		tmp.setId(id);
		if(PurchaseUtil.STATUS_1 == status){
			tmp.setStatus(PurchaseUtil.STATUS_2);
			tmp.setCostDepartApproval(auditResults);
			tmp.setCostDepartDate(date);
			tmp.setCostDepartOpinion(auditOpinion);
			tmp.setProjectDepartUser(applyUser);
		}else if (PurchaseUtil.STATUS_2 == status){
			tmp.setStatus(PurchaseUtil.STATUS_3);
			tmp.setProjectDepartApproval(auditResults);
			tmp.setProjectDepartDate(date);
			tmp.setProjectDepartOpinion(auditOpinion);
			tmp.setManagerDepartUser(applyUser);
		}else if (PurchaseUtil.STATUS_3 == status){
			tmp.setStatus(PurchaseUtil.STATUS_4);
			tmp.setManagerDepartApproval(auditResults);
			tmp.setManagerDepartDate(date);
			tmp.setManagerDepartOpinion(auditOpinion);
		}else if (PurchaseUtil.STATUS_4 == status){
			tmp.setStatus(PurchaseUtil.STATUS_5);
		}
		//审核不通过
		if(!auditResults){
			tmp.setStatus(0);
		}
		tmp.setUpdateDate(date);

		purchaseOrderMapper.updateByPrimaryKeySelective(tmp);

		return ResultUtil.ok();
	}

    @Override
    public List<BizPurchaseOrder> selectPurchaseOrder(Integer status, Long supplier) {
        BizPurchaseOrderExample example=new BizPurchaseOrderExample();
        //设置按创建时间降序排序
        example.setOrderByClause("update_date DESC");
        BizPurchaseOrderExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(status);
        criteria.andSupplierIdEqualTo(supplier);
        List<BizPurchaseOrder> list = purchaseOrderMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<BizPurchaseOrderVo> selectPurchaseOrderExample(Integer status, Long supplier){
        BizPurchaseOrderExample example=new BizPurchaseOrderExample();
        //设置按创建时间降序排序
        example.setOrderByClause("update_date DESC");
        BizPurchaseOrderExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(status);
        criteria.andSupplierIdEqualTo(supplier);
        BizPurchaseOrderSearch search = new BizPurchaseOrderSearch();
        search.setStatus(status);
        search.setSupplierId(supplier);
        List<BizPurchaseOrderVo> povList = purchaseOrderMapper.selectByExampleExt(example,search);
        return povList;
    }

	@Override
	public ResultUtil addPurchaseOrderItem(BizPurchaseOrderDetail order) {

		String id = MyUtil.getStrUUID();
		order.setId(id);
		purchaseOrderDetailMapper.insert(order);

		BigDecimal price = order.getPrice();
		Double amount = order.getAmount();
		BigDecimal totalPrice = null;
		if(price != null && amount != null){
			BigDecimal amountBig = new BigDecimal(amount);
			totalPrice = price.multiply(amountBig);
		}

		//如有金额更新采购单
		if(totalPrice != null){
			String purchaseNo = order.getPurchaseNo();
			BizPurchaseOrder purchaseOrder = purchaseOrderMapper.selectByPurchaseNo(purchaseNo);
			BigDecimal contractMoney = purchaseOrder.getContractMoney();
			if(contractMoney == null){
				contractMoney = totalPrice;
			}else {
				contractMoney.add(totalPrice);
			}

			BizPurchaseOrder tmp = new BizPurchaseOrder();
			tmp.setId(purchaseOrder.getId());
			tmp.setContractMoney(contractMoney);
			tmp.setUpdateDate(order.getUpdateDate());
			purchaseOrderMapper.updateByPrimaryKeySelective(tmp);
		}

		return ResultUtil.ok(id);
	}

	@Override
	public ResultUtil deletePurchaseOrderItem(String itemId) {
		BizPurchaseOrderDetail order = purchaseOrderDetailMapper.selectByPrimaryKey(itemId);
		BigDecimal price = order.getPrice();
		Double amount = order.getAmount();
		BigDecimal totalPrice = null;
		if(price != null && amount != null){
			BigDecimal amountBig = new BigDecimal(amount);
			totalPrice = price.multiply(amountBig);
		}

		//如有金额更新采购单
		if(totalPrice != null){
			String purchaseNo = order.getPurchaseNo();
			BizPurchaseOrder purchaseOrder = purchaseOrderMapper.selectByPurchaseNo(purchaseNo);
			BigDecimal contractMoney = purchaseOrder.getContractMoney();
			BigDecimal tmpMoney = contractMoney.subtract(totalPrice);

			BizPurchaseOrder tmp = new BizPurchaseOrder();
			tmp.setId(purchaseOrder.getId());
			tmp.setContractMoney(tmpMoney);
			tmp.setUpdateDate(order.getUpdateDate());
			purchaseOrderMapper.updateByPrimaryKeySelective(tmp);
		}


		purchaseOrderDetailMapper.deleteByPrimaryKey(itemId);
		return ResultUtil.ok();
	}

    @Override
    public ResultUtil getPurchaseOrderItem(String itemId) {
        BizPurchaseOrderDetail order = purchaseOrderDetailMapper.selectByPrimaryKey(itemId);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setData(order);
        return resultUtil;
    }

    @Override
	public ResultUtil submitReviewPurchaseOrder(TbAdmin admin, String id, Long userId) {

		BizPurchaseOrder order = purchaseOrderMapper.selectByPrimaryKey(id);

		int status = order.getStatus();
		if(PurchaseUtil.STATUS_1 != status){
			return ResultUtil.error("非未提交状态的采购单不能选择成本部审核！");
		}
		Date date = new Date();
		BizPurchaseOrder tmp = new BizPurchaseOrder();
		tmp.setId(order.getId());
		tmp.setCostDepartUser(userId);
		tmp.setUpdateDate(date);

		purchaseOrderMapper.updateByPrimaryKeySelective(tmp);
		return ResultUtil.ok();
	}

	@Override
	public ResultUtil purchaseOrderContractNo(String id, String contractNo) {
		BizPurchaseOrder tmp = new BizPurchaseOrder();
		tmp.setId(id);
		tmp.setContractNo(contractNo);
		tmp.setUpdateDate(new Date());
		purchaseOrderMapper.updateByPrimaryKeySelective(tmp);
		return ResultUtil.ok();
	}

	private BizPurchaseOrderVo getBizPurchaseOrderVo(String id){
        //获取采购单
        BizPurchaseOrder order = purchaseOrderMapper.selectByPrimaryKey(id);
        BizPurchaseOrderVo vo = new BizPurchaseOrderVo();

        //所属项目
        String projectId = order.getProjectId();
        if(StringUtils.isNotBlank(projectId)){
            TbProjectManger projectManger = projectMangerMapper.selectByPrimaryKey(projectId);
			vo.setProjectManger(projectManger);
        }


        BeanUtils.copyProperties(order, vo);

        Long userId = order.getCreateUser();
        TbAdmin tbAdmin = adminMapper.selectByPrimaryKey(userId);
        vo.setAdmin(tbAdmin);

        Long costUserId = order.getCostDepartUser();
        if(costUserId != null){
            TbAdmin costAdmin = adminMapper.selectByPrimaryKey(costUserId);
            vo.setCostAdmin(costAdmin);
        }

        Long projectUserId = order.getProjectDepartUser();
        if(projectUserId != null){
            TbAdmin projectAdmin = adminMapper.selectByPrimaryKey(projectUserId);
            vo.setProjectAdmin(projectAdmin);
        }

        Long managerUserId = order.getManagerDepartUser();
        if(managerUserId != null){
            TbAdmin managerAdmin = adminMapper.selectByPrimaryKey(managerUserId);
            vo.setManagerAdmin(managerAdmin);
        }

        Long supplierId = order.getSupplierId();
        if(supplierId != null){
            TbSupplier supplier = supplierMapper.selectByPrimaryKey(supplierId);
            vo.setSupplier(supplier);
        }

		Long applyUserId = order.getApplyUser();
		if(applyUserId != null){
			TbAdmin auAdmin = adminMapper.selectByPrimaryKey(applyUserId);
			vo.setAuAdmin(auAdmin);
		}


		return vo;
    }

    @Override
    public BizPurchaseOrderVo selPurchaseOrderById(String id) {
        return getBizPurchaseOrderVo(id);
    }

	@Override
	public List<ChosePurchaseOrderVO> selectChosePurchaseOrder() {
		List<ChosePurchaseOrderVO> item = new ArrayList<>();
		BizPurchaseOrderExample example=new BizPurchaseOrderExample();
		List<BizPurchaseOrder> depts = purchaseOrderMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(depts)){
			for (BizPurchaseOrder d: depts) {
				ChosePurchaseOrderVO dept = new ChosePurchaseOrderVO(d.getId(),d.getPurchaseNo());
				item.add(dept);
			}
		}
		return item;
	}
}
