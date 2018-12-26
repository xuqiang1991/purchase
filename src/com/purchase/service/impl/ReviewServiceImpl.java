package com.purchase.service.impl;

import com.purchase.mapper.admin.TbAdminMapper;
import com.purchase.mapper.admin.TbRolesMapper;
import com.purchase.mapper.order.BizContractApplyMoneyMapper;
import com.purchase.mapper.order.BizHistoryMapper;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbRoles;
import com.purchase.pojo.order.BizContractApplyMoney;
import com.purchase.pojo.order.BizHistory;
import com.purchase.service.ReviewService;
import com.purchase.util.OrderUtils;
import com.purchase.util.ResultUtil;
import com.purchase.util.WebUtils;
import com.purchase.weixin.service.WeixinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

/**
 * @Description:审核
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbAdminMapper tbAdminMapper;

    @Autowired
    private TbRolesMapper rolesMapper;

    @Autowired
    private BizHistoryMapper historyMapper;

    @Autowired
    private BizContractApplyMoneyMapper camMapper;


    /**
     * 订单审核
     * @param type（1.合同单，2.合同内请款单）
     * @param id
     * @param auditResults 审核结果
     * @param LoginUser 登陆用户
     * @param loginUserFullname 登陆用户全称
     * @param applyUser 审核人
     * @param applyRole 审核角色
     * @param auditOpinion 审核意见
     * @return
     */
    @Override
    public ResultUtil reviewOrder(int type, String id, boolean auditResults, Long LoginUser,String loginUserFullname,  Long applyUser, Long applyRole, String auditOpinion) {
        Date date = new Date();
        BizContractApplyMoney order = camMapper.selectByPrimaryKey(id);
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
            order.setLastReviewUser(LoginUser);
            order.setNextReviewUser(applyUser);
            order.setNextReviewRole(applyRole);
            history.setIsApproval(OrderUtils.IS_APPROVAL_YES);
        }
        order.setLastReviewDate(date);
        order.setUserItem(OrderUtils.getUserItem(order.getUserItem(),String.valueOf(applyUser)));
        order.setUpdateDate(date);

        history.setOrderId(order.getId());
        history.setApprovalDate(new Date());
        history.setApprovalUser(LoginUser);
        history.setApprovalUserName(loginUserFullname);
        TbRoles roles = rolesMapper.selectByPrimaryKey(order.getLastReviewRole());
        if(roles != null){
            history.setApprovalRoleName(roles.getRoleName());
        }
        history.setOpinion(auditOpinion);

        camMapper.updateByPrimaryKeySelective(order);
        historyMapper.insert(history);

        switch (type){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                logger.info("不在处理流程内");
                break;
        }
        return ResultUtil.ok(order);
    }


    /**
     * 发送微信消息
     * @param url
     * @param auditResults
     * @param createUser
     * @param applyUser
     * @param applyRole
     * @param orderNo
     */
    @Override
    public void reviewOrderSendMessage(String url, boolean auditResults, Long createUser, Long applyUser, Long applyRole, String orderNo) {
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        WeixinService weixinService = (WeixinService)wac.getBean("weixinService");

        TbAdmin tbAdmin = null;
        String openId = "";
        String title = "订单状态提醒";// 标题
        String desc = "";//"您好，".concat(tbAdmin.getFullname()).concat("。您有订单需要审核");//详情
        if(!auditResults){
            tbAdmin = tbAdminMapper.selectByPrimaryKey(createUser);
            openId = tbAdmin.getOpenId();
            desc = "您好，".concat(tbAdmin.getFullname()).concat("。您的订单：【").concat(orderNo).concat("】被驳回，请查询详细信息！");
        }else{
            boolean isOverRole = checkRoleIsOverRole(applyRole);
            if(isOverRole){
                tbAdmin = tbAdminMapper.selectByPrimaryKey(createUser);
                openId = tbAdmin.getOpenId();
                desc = "您好，".concat(tbAdmin.getFullname()).concat("。订单：【").concat(orderNo).concat("】审核通过，请查询详细信息！");
            }else{
                tbAdmin = tbAdminMapper.selectByPrimaryKey(applyUser);
                openId = tbAdmin.getOpenId();
                desc = "您好，".concat(tbAdmin.getFullname()).concat("。订单：【").concat(orderNo).concat("】需要您审核，请查询详细信息！");
            }
        }
        if(!StringUtils.isEmpty(openId)){
            weixinService.sendKefuMessage(tbAdmin.getOpenId(),url,desc,title,null);
        }else{
            logger.info("审核人未绑定帐号，不能发送消息!");
        }
    }


    private boolean checkRoleIsOverRole(Long roleId) {
        if(roleId == null){
            return false;
        }
        TbRoles role = rolesMapper.selectByPrimaryKey(roleId);
        if(role != null && role.getIsOverRole() == 1){
            return true;
        }else{
            return false;
        }
    }

}

