package com.purchase.weixin.service;

import com.purchase.pojo.admin.TbAdmin;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuqiang
 * 2018/8/10.
 */
@Service
public class WeixinService{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WxMpService wxMpService;


    /**
     * 发送客服图文消息
     * @param openId 用户openID
     * @param url 跳转链接
     * @param desc 详情
     * @param title 标题
     * @param picUrl 图片地址（可为空）
     * @return 是否发送
     */
    public boolean sendKefuMessage(String openId, String url, String desc, String title, String picUrl){
        boolean isSend = false;
        WxMpKefuMessage.WxArticle article = new WxMpKefuMessage.WxArticle();
        article.setUrl(url);
        article.setDescription(desc);
        article.setTitle(title);
        if(StringUtils.isNotBlank(picUrl)){
            article.setPicUrl(picUrl);
        }
        WxMpKefuMessage wxMpKefuMessage = WxMpKefuMessage.NEWS().addArticle(article).toUser(openId).build();
        try {
            isSend = wxMpService.getKefuService().sendKefuMessage(wxMpKefuMessage);
        } catch (WxErrorException e) {
            logger.error("发送消息失败",e);
        }
        return isSend;
    }

    /**
     * 发送客服图文消息
     * @param openIds 用户openIds,数组
     * @param url 跳转链接
     * @param desc 详情
     * @param title 标题
     * @param picUrl 图片地址（可为空）
     * @return 发送成功条数
     */
    public int sendKefuMessages(List<String> openIds, String url, String desc, String title, String picUrl){
        int sendCount = 0;
        for (String openId : openIds){
           boolean isSend = sendKefuMessage(openId,url,desc,title,picUrl);
           if(isSend){
               sendCount++;
           }
        }
        return sendCount;
    }

    public boolean sendMSGUtils(TbAdmin tbAdmin,boolean isOverRole, String url, Boolean auditResults, String orderNo){
        boolean isSend = false;
        String title = "订单状态提醒";// 标题
        String desc = "";//"您好，".concat(tbAdmin.getFullname()).concat("。您有订单需要审核");//详情
        if(!auditResults){
            desc = "您好，".concat(tbAdmin.getFullname()).concat("。您的订单：【").concat(orderNo).concat("】被驳回，请查询详细信息！");
        }else{
            if(isOverRole){
                desc = "您好，".concat(tbAdmin.getFullname()).concat("。订单：【").concat(orderNo).concat("】审核通过，请查询详细信息！");
            }else{
                desc = "您好，".concat(tbAdmin.getFullname()).concat("。订单：【").concat(orderNo).concat("】需要您审核，请查询详细信息！");
            }
        }
        if(!org.springframework.util.StringUtils.isEmpty(tbAdmin.getOpenId())){
            isSend = sendKefuMessage(tbAdmin.getOpenId(),url,desc,title,null);
        }else{
            logger.info("审核人未绑定帐号，不能发送消息!");
        }
        return isSend;
    }

}
