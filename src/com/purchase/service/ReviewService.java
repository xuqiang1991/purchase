package com.purchase.service;

import com.purchase.util.ResultUtil;

public interface ReviewService {

    void reviewOrderSendMessage(String url, boolean auditResults, Long createUser, Long applyUser, Long applyRole, String orderNo);

    ResultUtil reviewOrder(int type, String id, boolean auditResults, Long LoginUser,String loginUserFullname,  Long applyUser, Long applyRole, String auditOpinion);
}
