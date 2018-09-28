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
import com.purchase.pojo.order.BizPurchaseOrder;
import com.purchase.pojo.order.BizPurchaseOrderDetail;
import com.purchase.pojo.order.BizPurchaseOrderDetailExample;
import com.purchase.pojo.order.BizPurchaseOrderExample;
import com.purchase.service.PurchaseOrderService;
import com.purchase.util.*;
import com.purchase.vo.admin.ChoseAdminVO;
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

			if(search.getStartCreateTime() != null){
				criteria.andCreateTimeGreaterThanOrEqualTo(search.getStartCreateTime());
			}
			if(search.getEndCreateTime() != null){
				criteria.andCreateTimeLessThanOrEqualTo(search.getEndCreateTime());
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

		String id = WebUtils.generateUUID();
		order.setId(id);

		//生成采购单号
		String yyddmm = DateUtil.formatDate(date,DateUtil.DateFormat3);
		String prefix = PurchaseUtil.prefix + yyddmm;
		String pn = purchaseOrderMapper.selMaxPurchaseNo(prefix);
		String purchaseNo = PurchaseUtil.generatePurchaseNo(pn);
		order.setPurchaseNo(purchaseNo);

		//参数补充
		order.setUpdateDate(date);
		order.setCreateTime(date);

        purchaseOrderMapper.insertSelective(order);

		return ResultUtil.ok();
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
		BizPurchaseOrder order = purchaseOrderMapper.selectByPrimaryKey(id);
		BizPurchaseOrderVo vo = new BizPurchaseOrderVo();

		//所属项目
        String projectId = order.getProjectId();
        if(StringUtils.isNotBlank(projectId)){
            TbProjectManger projectManger = projectMangerMapper.selectByPrimaryKey(projectId);
            order.setProjectId(projectManger.getName());
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
			vo.setCostAdmin(projectAdmin);
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




		detailsVo.setPurchaseOrder(vo);

		//获取采购单详情
		String purchaseNo = vo.getPurchaseNo();
		BizPurchaseOrderDetailExample example = new BizPurchaseOrderDetailExample();
		BizPurchaseOrderDetailExample.Criteria criteria = example.createCriteria();
		criteria.andPurchaseNoEqualTo(purchaseNo);
		List<BizPurchaseOrderDetail> detailList = purchaseOrderDetailMapper.selectByExample(example);
		detailsVo.setDetails(detailList);


		//选择审核人
		int status = vo.getStatus();
		String depart = null;
		Long reviewUserId = null;
		if(PurchaseUtil.STATUS_1 == status){
			Long cId = vo.getCostDepartUser();
			if(cId != null){
				reviewUserId = vo.getCostDepartUser();
				depart = "工程部";
			}else {
				depart = "成本部";
			}
		}else if(PurchaseUtil.STATUS_2 == status){
			depart = "工程部";
			reviewUserId = vo.getProjectDepartUser();
		}else if(PurchaseUtil.STATUS_3 == status){
			depart = "总经理";
			reviewUserId = vo.getManagerDepartUser();
		}
		if(depart != null){
			TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
			long loginId = admin.getId();
			if(reviewUserId != null && reviewUserId == loginId){
				detailsVo.setReviewUserId(userId);
				List<ChoseAdminVO> data = adminMapper.selectByDeptName(depart);
				if(!CollectionUtils.isEmpty(data)){
					Gson gson = new Gson();
					String json = gson.toJson(data);
					detailsVo.setDeparts(json);
				}
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
			tmp.setProjectDepartDate(date);
			tmp.setProjectDepartOpinion(auditOpinion);
			tmp.setManagerDepartUser(applyUser);
		}else if (PurchaseUtil.STATUS_3 == status){
			tmp.setStatus(PurchaseUtil.STATUS_4);
			tmp.setManagerDepartDate(date);
			tmp.setManagerDepartOpinion(auditOpinion);
		}else if (PurchaseUtil.STATUS_4 == status){
			tmp.setStatus(PurchaseUtil.STATUS_5);
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

		return ResultUtil.ok();
	}

	@Override
	public ResultUtil deletePurchaseOrderItem(String itemId) {
		purchaseOrderDetailMapper.deleteByPrimaryKey(itemId);
		return ResultUtil.ok();
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
}
