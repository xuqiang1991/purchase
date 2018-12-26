package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.purchase.mapper.admin.TbAdminMapper;
import com.purchase.mapper.admin.TbProjectMangerMapper;
import com.purchase.mapper.admin.TbRolesMapper;
import com.purchase.mapper.admin.TbSupplierMapper;
import com.purchase.mapper.order.BizHistoryMapper;
import com.purchase.mapper.order.BizPurchaseOrderDetailMapper;
import com.purchase.mapper.order.BizPurchaseOrderMapper;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbProjectManger;
import com.purchase.pojo.admin.TbRoles;
import com.purchase.pojo.admin.TbSupplier;
import com.purchase.pojo.order.*;
import com.purchase.service.PurchaseOrderService;
import com.purchase.util.*;
import com.purchase.vo.admin.ChoseAdminVO;
import com.purchase.vo.admin.ChosePurchaseOrderVO;
import com.purchase.vo.order.BizPurchaseOrderDetailsVo;
import com.purchase.vo.order.BizPurchaseOrderSearch;
import com.purchase.vo.order.BizPurchaseOrderVo;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	private static Logger logger = LoggerFactory.getLogger(PurchaseOrderServiceImpl.class);

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

	@Autowired
	private BizHistoryMapper historyMapper;

	@Autowired
	private TbRolesMapper rolesMapper;


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
			if(search.getStatus()!= null){
				criteria.andStatusEqualTo(search.getStatus());
			}
			if(search.getSupplierId()!= null){
				criteria.andSupplierIdEqualTo(search.getSupplierId());
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

			//生成合同订单号
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
		return ResultUtil.ok(order.getId());
	}

	/**
	 *
	 * 查询合同订单号详情
	 * @param id
	 * @return
	 */
	@Override
	public BizPurchaseOrderDetailsVo selPurchaseOrder(String id) {
		BizPurchaseOrderDetailsVo detailsVo = new BizPurchaseOrderDetailsVo();

		//获取合同订单
        BizPurchaseOrderVo vo =  getBizPurchaseOrderVo(id);
        Long userId = vo.getCreateUser();
		detailsVo.setPurchaseOrder(vo);

		//获取合同订单详情
		String purchaseNo = vo.getPurchaseNo();
		BizPurchaseOrderDetailExample example = new BizPurchaseOrderDetailExample();
		BizPurchaseOrderDetailExample.Criteria criteria = example.createCriteria();
		criteria.andPurchaseNoEqualTo(purchaseNo);
		List<BizPurchaseOrderDetail> detailList = purchaseOrderDetailMapper.selectByExample(example);
		detailsVo.setDetails(detailList);

		//选择审核人
		String roleName = "成本部";
		Long reviewUserId = null;
		detailsVo.setReviewUserId(reviewUserId);

		if(roleName != null){
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
			return ResultUtil.error("非未提交状态的合同订单不能删除！");
		}
		purchaseOrderMapper.deleteByPrimaryKey(id);

		BizPurchaseOrderDetailExample example = new BizPurchaseOrderDetailExample();
		example.createCriteria().andPurchaseNoEqualTo(order.getPurchaseNo());
		purchaseOrderDetailMapper.deleteByExample(example);
		return ResultUtil.ok();
	}

	/**
	 * 合同订单提交
	 * @param id
	 * @return
	 */
	@Override
	public ResultUtil submitPurchaseOrder(String id, Long userId, Long roleId) {
		TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
		BizPurchaseOrder order = purchaseOrderMapper.selectByPrimaryKey(id);


		BizPurchaseOrder tmp = new BizPurchaseOrder();
		tmp.setId(order.getId());
		tmp.setIsApproval(OrderUtils.IS_APPROVAL_YES);
		tmp.setLastReviewDate(new Date());
		tmp.setLastReviewUser(admin.getId());
		tmp.setNextReviewRole(roleId);
		tmp.setNextReviewUser(userId);
		tmp.setUpdateDate(new Date());
		tmp.setApplyDate(new Date());
		tmp.setUserItem(OrderUtils.getUserItem(order.getUserItem(),String.valueOf(userId)));
		tmp.setIsSaveSubmit(1);
		purchaseOrderMapper.updateByPrimaryKeySelective(tmp);


		BizHistory history = new BizHistory();
		history.setId(WebUtils.generateUUID());
		history.setIsApproval(OrderUtils.IS_APPROVAL_YES);
		history.setOrderId(order.getId());
		history.setApprovalDate(new Date());
		history.setApprovalUser(admin.getId());
		history.setApprovalUserName(admin.getFullname());
		TbRoles roles = rolesMapper.selectByPrimaryKey(order.getLastReviewRole());
		if(roles != null){
			history.setApprovalRoleName(roles.getRoleName());
		}
		history.setOpinion("提交审核");
		historyMapper.insert(history);
		return ResultUtil.ok(order);
	}


	/**
	 * 合同订单审核
	 * @param admin
	 * @param id
	 * @param auditResults
	 * @param applyUser
	 * @param auditOpinion
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public ResultUtil reviewPurchaseOrder(TbAdmin admin, String id, Boolean auditResults, Long applyUser, String auditOpinion, Long applyRole) {
		Long loginUser = admin.getId();
		String loginUserFullname = admin.getFullname();

		Date date = new Date();
		BizPurchaseOrder order = purchaseOrderMapper.selectByPrimaryKey(id);
		BizHistory history = new BizHistory();
		history.setId(WebUtils.generateUUID());
		//审核不通过
		if(!auditResults){
			order.setIsSaveSubmit(OrderUtils.IS_SAVE_SUBMIT_0);
			order.setIsApproval(OrderUtils.IS_APPROVAL_NO);
			order.setLastReviewRole(null);
			order.setLastReviewUser(null);
			order.setNextReviewUser(order.getCreateUser());//驳回则还原到创建人
			history.setIsApproval(OrderUtils.IS_APPROVAL_NO);
		}else{
			order.setIsSaveSubmit(OrderUtils.IS_SAVE_SUBMIT_1);
			order.setIsApproval(OrderUtils.IS_APPROVAL_YES);
			order.setLastReviewRole(order.getNextReviewRole());
			order.setLastReviewUser(loginUser);
			order.setNextReviewUser(applyUser);
			order.setNextReviewRole(applyRole);
			history.setIsApproval(OrderUtils.IS_APPROVAL_YES);
		}
		order.setLastReviewDate(date);
		order.setUserItem(OrderUtils.getUserItem(order.getUserItem(),String.valueOf(applyUser)));
		order.setUpdateDate(date);

		history.setOrderId(order.getId());
		history.setApprovalDate(date);
		history.setApprovalUser(loginUser);
		history.setApprovalUserName(loginUserFullname);
		Long lastReviewRole = order.getLastReviewRole();

		TbRoles roles = rolesMapper.selectByPrimaryKey(lastReviewRole);
		if(roles != null){
			history.setApprovalRoleName(roles.getRoleName());
		}
		history.setOpinion(auditOpinion);

		purchaseOrderMapper.updateByPrimaryKeySelective(order);
		historyMapper.insert(history);
		return ResultUtil.ok(order);
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
		purchaseOrderDetailMapper.insertSelective(order);

		BigDecimal price = order.getPrice();
		Double amount = order.getAmount();
		BigDecimal totalPrice = null;
		if(price != null && amount != null){
			BigDecimal amountBig = new BigDecimal(amount);
			totalPrice = price.multiply(amountBig);
		}

		//如有金额更新合同订单
		if(totalPrice != null){
			String purchaseNo = order.getPurchaseNo();
			BizPurchaseOrder purchaseOrder = purchaseOrderMapper.selectByPurchaseNo(purchaseNo);
			BigDecimal contractMoney = purchaseOrder.getContractMoney();
			if(contractMoney == null){
				contractMoney = totalPrice;
			}else {
				contractMoney = contractMoney.add(totalPrice);
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
    public ResultUtil editPurchaseOrderItem(BizPurchaseOrderDetail order) {
        purchaseOrderDetailMapper.updateByPrimaryKey(order);
        BigDecimal price = order.getPrice();
        Double amount = order.getAmount();
        BigDecimal totalPrice = null;
        if(price != null && amount != null){
            BigDecimal amountBig = new BigDecimal(amount);
            totalPrice = price.multiply(amountBig);
        }

        //如有金额更新合同订单
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
		BizPurchaseOrderDetail order = purchaseOrderDetailMapper.selectByPrimaryKey(itemId);
		BigDecimal price = order.getPrice();
		Double amount = order.getAmount();
		BigDecimal totalPrice = null;
		if(price != null && amount != null){
			BigDecimal amountBig = new BigDecimal(amount);
			totalPrice = price.multiply(amountBig);
		}

		//如有金额更新合同订单
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
	public ResultUtil purchaseOrderContractNo(String id, String contractNo) {
		BizPurchaseOrder tmp = new BizPurchaseOrder();
		tmp.setId(id);
		tmp.setContractNo(contractNo);
		tmp.setUpdateDate(new Date());
		purchaseOrderMapper.updateByPrimaryKeySelective(tmp);
		return ResultUtil.ok();
	}

	private BizPurchaseOrderVo getBizPurchaseOrderVo(String id){
        //获取合同订单
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
