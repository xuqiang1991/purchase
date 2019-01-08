<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title></title>
    <link href="${ctx }/mui/css/mui.min.css" rel="stylesheet"/>
    <link href="${ctx }/mui/css/iconfont.css" rel="stylesheet"/>
    <link href="${ctx }/mui/css/mui.picker.min.css" rel="stylesheet" />
    <link href="${ctx }/mui/css/feedback-page.css" rel="stylesheet" />
    <link href="${ctx }/mui/css/mui-page.css" rel="stylesheet" />
    <style type="text/css">
        /*移除底部或顶部三角,需要在删除此代码*/
        .mui-popover .mui-popover-arrow:after {
            width: 0px;
        }
    </style>
    <script src="${ctx }/mui/js/mui.min.js"></script>
    <script src="${ctx }/js/jquery-1.11.1.js"></script>
    <script src="${ctx }/mui/js/mui.picker.min.js"></script>
    <script src="${ctx }/mui/js/mui.view.js"></script>
    <script type="text/javascript" src="${ctx }/js/handlebars.min.js"></script>
    <script type="text/javascript" src="${ctx}/mui/js/base.js"></script>
</head>
<body class="mui-fullscreen">

<div id="app" class="mui-views">
    <div class="mui-view">
        <div class="mui-navbar"></div>
        <div class="mui-pages"></div>
    </div>
</div>

<div id="setting" class="mui-content mui-page">
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <%--<button type="button" class="mui-left mui-action-back mui-btn  mui-btn-link mui-btn-nav mui-pull-left">
            <span class="mui-icon mui-icon-left-nav"></span>
        </button>--%>
        <h1 class="mui-center mui-title">合同内请款单详情</h1>
    </div>

    <!-- 合同内请款详情 start -->
    <div id="refreshContainer" class="mui-content mui-scroll-wrapper" style="margin-top: 0px;width: 100%;">
        <div class="mui-scroll">
            <!-- 主界面具体展示内容 -->
                <div class="mui-content" style="margin-left: 5px; margin-right: 5px; font-size: 14px;">
                    <ul id="ul_mui_table_view" class="mui-table-view">
                        <li class="mui-table-view-cell mui-collapse mui-active">
                            <a class="mui-navigate-right" href="#">合同内请款单详情:
                                <c:choose>
                                    <c:when test="${detailsVo.order.id == null}">
                                        请先添加合同内请款单
                                    </c:when>
                                    <c:otherwise>
                                        ${detailsVo.order.orderNo}
                                    </c:otherwise>
                                </c:choose>
                            </a>
                        <div class="mui-collapse-content">
                            <form class="mui-input-group" id="ucamForm">
                                <input type="hidden" name="id" id="id" value="${detailsVo.order.id}">
                                <!-- 主界面具体展示内容 -->
                                <c:if test="${detailsVo.order.id == null}">
                                <div class="mui-input-row">
                                    <label>请款单号</label>
                                    <input type="text" name="purchaseNo" id="purchaseNo" readonly disabled="disabled" value="${detailsVo.order.orderNo}" placeholder="请款单号由系统自动生成">
                                </div>
                                </c:if>
                                <div class="mui-input-row">
                                    <label>请款人</label>
                                    <c:choose>
                                        <c:when test="${detailsVo.order.id == null}">
                                            <input type="text" id="selectApplyUserEdit" placeholder="请选择请款人" value="${admin.fullname}">
                                            <input type="hidden" id="applyUserEdit" name="applyUser" value="${admin.id}" mui-verify="required">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="text" id="selectApplyUserEdit" placeholder="请选择请款人${detailsVo.order.status}" value="${detailsVo.order.admin.fullname}" <c:if test="${detailsVo.order.status != 0}">disabled="disabled"</c:if> >
                                            <input type="hidden" id="applyUserEdit" name="applyUser" value="${detailsVo.order.admin.id}" mui-verify="required">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mui-input-row">
                                    <label>来源合同</label>
                                    <a <c:if test="${detailsVo.order.id == null || detailsVo.order.status == 0}">href="#selectProject" id="app-b"</c:if>>
                                        <label id="selectProjectText" style="width: 65%;padding-left: 0px;">
                                            <c:choose>
                                                <c:when test="${detailsVo.order.purchaseOrderVo.id == null}">
                                                    请选择来源合同
                                                </c:when>
                                                <c:otherwise>
                                                    ${detailsVo.order.purchaseOrderVo.purchaseNo}
                                                </c:otherwise>
                                            </c:choose>
                                        </label>
                                        <input type="hidden" id="selectProjectHidden" name="sourceOrderId" value="${detailsVo.order.sourceOrderId}" mui-verify="required">
                                    </a>
                                </div>
                                <div class="mui-input-row">
                                    <label>供应商</label>
                                    <c:choose>
                                        <c:when test="${detailsVo.order.id == null}">
                                            <c:choose>
                                                <c:when test="${admin.supplierId == null}">
                                                    <input type="text" id="supplierName" readonly value="">
                                                    <input type="hidden" id="supplierId" name="supplierId" value="" mui-verify="required">
                                                </c:when>
                                                <c:otherwise>
                                                    <input type="text" id="supplierName" readonly value="${admin.supplierName}">
                                                    <input type="hidden" id="supplierId" name="supplierId" value="${admin.supplierId}" mui-verify="required">
                                                </c:otherwise>
                                            </c:choose>
                                        </c:when>
                                        <c:otherwise>
                                            <input type="text" id="supplierName" readonly value="${detailsVo.order.supplier.name}" <c:if test="${detailsVo.order.status != 0}">disabled="disabled"</c:if>>
                                            <input type="hidden" id="supplierId" name="supplierId" value="${detailsVo.order.supplier.id}" mui-verify="required">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <c:if test="${detailsVo.order.id != null}">
                                    <div class="mui-input-row">
                                        <label>订单类型</label>
                                        <label style="width: 65%;padding-left: 0px;">${detailsVo.orderType}</label>
                                    </div>
                                    <div class="mui-input-row">
                                        <label>所属项目</label>
                                        <label style="width: 65%;padding-left: 0px;">${detailsVo.order.purchaseOrderVo.tpm.name}</label>
                                    </div>
                                    <div class="mui-input-row mui-input-range">
                                        <label>开单日期</label>
                                        <label style="width: 65%;padding-left: 0px;"><fmt:formatDate value="${detailsVo.order.createTime}" pattern="yyyy-MM-dd"/></label>
                                    </div>
                                    <div class="mui-input-row mui-input-range">
                                        <label>请款金额</label>
                                        <label style="width: 65%;padding-left: 0px;">${detailsVo.order.applyPrice}</label>
                                    </div>
                                    <div class="mui-input-row mui-input-range">
                                        <label>支付金额</label>
                                        <label style="width: 65%;padding-left: 0px;">${detailsVo.order.actualPrice}</label>
                                    </div>
                                </c:if>
                                <div>
                                    <textarea name="summary" id="summary" rows="5" class="mui-input-clear" <c:if test="${detailsVo.order.status > 0}">disabled="disabled"</c:if> placeholder="备注">${detailsVo.order.summary}</textarea>
                                </div>
                                <c:if test="${detailsVo.order.id == null || (detailsVo.order.id != null && detailsVo.order.isSaveSubmit == 0)}">
                                    <div class="mui-button-row" style="padding-bottom: 20px;">
                                        <button type="button" class="mui-btn mui-btn-primary" id="ucamSave">保存</button>
                                    </div>
                                </c:if>
                            </form>
                        </div>
                    </li>

                    <!-- 审核状态 -->
                    <c:set value="${detailsVo.order.historyList}" var="historyList"/>
                    <%@ include file="/WEB-INF/page/mobile/common/reviewHistory.jsp"%>

                    <li class="mui-table-view-cell mui-collapse">
                        <a class="mui-navigate-right" href="#">合同内请款单明细</a>
                        <div class="mui-collapse-content" id="detailDiv">
                            <c:choose>
                                <c:when test="${fn:length(detailsVo.details) > 0}">
                                    <c:forEach items="${detailsVo.details}" var="item">
                                        <div class="mui-card">
                                            <div class="mui-card-header mui-card-media">
                                                <!-- 订单类型 用图标展示 -->
                                                <img src="${ctx }/images/icon/contract_apply_money.png">
                                                <div class="mui-media-body">
                                                    <label>材料/项目内容</label>
                                                    <p>
                                                            ${item.projectContent}
                                                    </p>
                                                </div>
                                            </div>
                                            <div class="mui-card-content">
                                                <div class="mui-card-content-inner">
                                                    <p>
                                                        <label>规格：${item.model}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <label>单位：${item.unit}</label>
                                                    </p>
                                                    <p>
                                                        <label>单价:${item.price}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <label>数量：${item.contractCount}</label>
                                                    </p>
                                                        <%--<p>--%>
                                                        <%--<label>质保期（月）：${item.warrantyDate}</label>&nbsp;&nbsp;&nbsp;&nbsp;--%>
                                                        <%--<label>日期：<fmt:formatDate value="${item.date}" pattern="yyyy-MM-dd"/></label>--%>
                                                        <%--</p>--%>
                                                    <p>
                                                        <label>結算金额：${item.settlePrice}</label>&nbsp;&nbsp;
                                                        <label>結算数量：${item.settleAmout}</label>
                                                    </p>
                                                </div>
                                            </div>
                                            <div class="mui-card-footer">
                                                <c:if test="${detailsVo.order.status == 0 && detailsVo.order.createUser == admin.id}">
                                                    <div>
                                                        <a href="#fromPurchaseOrderItem" name="app-a" data-id="${item.id}">
                                                            <button type="button" class="mui-btn mui-btn-primary" value="${item.id}">修改</button>
                                                        </a>
                                                    </div>
                                                    <div>
                                                        <button type="button" class="mui-btn mui-btn-primary" id="deleteItem" value="${item.id}">刪除</button>
                                                    </div>
                                                </c:if>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <div class="mui-input-row">
                                        <label  style="width: auto;">无合同内请款单明细</label>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="mui-content-padded">
                <c:choose>
                    <c:when test="${detailsVo.order.isApproval == 0 && detailsVo.order.createUser == admin.id}">
                        <a href="#fromPurchaseOrderDetailsItem">
                            <button type="button" class="mui-btn mui-btn-primary mui-btn-block">增加明细</button>
                        </a>
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="orderDetails">提交</button>
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="deletePurchaseOrder" value="${detailsVo.order.id}">删除</button>
                    </c:when>
                    <c:when test="${detailsVo.order.nextReviewUser == admin.id && detailsVo.order.isSaveSubmit == 1}">
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="reviewPurchaseOrder">审核</button>
                    </c:when>
                </c:choose>
            </div>
        </div>
    </div>
    <!-- 合同内请款明细 end -->
</div>


<div id="fromPurchaseOrderItem" class="mui-page">
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <button type="button" class="mui-left mui-action-back mui-btn  mui-btn-link mui-btn-nav mui-pull-left">
            <span class="mui-icon mui-icon-left-nav"></span>返回
        </button>
        <h1 class="mui-center mui-title">增加合同内请款明细</h1>
    </div>
    <div class="mui-page-content">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll"  style="height: 100%;">
                <form class="mui-input-group" id="addFromPurchaseOrderItem">
                    <c:if test="${detailsVo.order.purchaseOrderVo.type == 3}">
                        <div class="mui-input-row">
                            <label>施工部位</label>
                            <input type="text" name="constructionSite" class="mui-input-clear" mui-verify="required|max=100" placeholder="请施工部位">
                        </div>
                    </c:if>
                    <div class="mui-input-row">
                        <label>项目内容</label>
                        <input type="text" name="projectContent" class="mui-input-clear" mui-verify="required|max=100" placeholder="请输入项目内容">
                    </div>
                    <div class="mui-input-row">
                        <label>规格型号</label>
                        <input type="text" name="model" class="mui-input-clear" mui-verify="required|max=50" placeholder="请输入规格型号">
                    </div>
                    <div class="mui-input-row">
                        <label>单位</label>
                        <input type="text" name="unit" class="mui-input-clear" mui-verify="required|max=10" placeholder="请输入单位">
                    </div>
                    <div class="mui-input-row">
                        <label>单价</label>
                        <input type="price" id="price" name="price" class="mui-input-clear" mui-verify="required" readonly unselectable="no">
                    </div>
                    <div class="mui-input-row">
                        <label>合同数量</label>
                        <input type="number" name="contractCount" class="mui-input-clear" mui-verify="required" readonly unselectable="no">
                    </div>
                    <div class="mui-input-row">
                        <label>结算数量</label>
                        <input type="number" id="settleAmout" name="settleAmout" class="mui-input-clear" mui-verify="required|digits|min=0" placeholder="请输入结算数量">
                    </div>
                    <div class="mui-input-row">
                        <label>结算金额</label>
                        <input type="number" id="settlePrice" name="settlePrice" class="mui-input-clear" mui-verify="required" readonly  unselectable="no">
                    </div>
                    <c:if test="${detailsVo.order.orderType == 1}">
                        <div class="mui-input-row">
                            <label>质保期（月）</label>
                            <input type="number" name="warrantyDate" class="mui-input-clear" mui-verify="required"  mui-verify="required|digits|min=0|max=100" placeholder="请输入质保期（月）">
                        </div>
                    </c:if>
                    <c:if test="${detailsVo.order.orderType == 2}">
                        <div class="mui-input-row">
                            <label>日期</label>
                            <input id="dateText" type="text" name="date" class="mui-input-clear" mui-verify="required" data-options='{"type":"date","beginYear":2014}' placeholder="请选择日期">
                        </div>
                    </c:if>
                    <div>
                        <textarea name="remark" id="remark" rows="3" class="mui-input-clear" placeholder="备注"></textarea>
                    </div>
                    <div class="mui-button-row" style="padding-bottom: 20px;">
                        <input type="hidden" name="orderNo" id="orderNo" value="${detailsVo.order.orderNo}">
                        <input type="hidden" name="purchaseDetailId" id="purchaseDetailId">
                        <input type="hidden" name="id" id="id">
                        <button type="button" class="mui-btn mui-btn-primary" id="submitFromPurchaseOrderItem">添加</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div id="fromPurchaseOrderDetailsItem" class="mui-page">
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <button type="button" class="mui-left mui-action-back mui-btn  mui-btn-link mui-btn-nav mui-pull-left">
            <span class="mui-icon mui-icon-left-nav"></span>返回
        </button>
        <h1 class="mui-center mui-title">选择合同订单明细</h1>
    </div>
    <div class="mui-page-content">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll"  style="height: 100%;">
                <form class="mui-input-group" id="addFromPurchaseOrderDetailsItem">
                    <c:choose>
                        <c:when test="${fn:length(detailsVo.order.details) > 0}">
                            <ul class="mui-table-view mui-table-view-radio">
                                <c:forEach items="${detailsVo.order.details}" var="item">
                                    <li class="mui-table-view-cell li-checkbox" style="position: static;" v="${item.id}">
                                        <a class="mui-navigate-right">
                                            <div class="mui-card" style="margin: 0px;">
                                                <div class="mui-card-header mui-card-media">
                                                    <!-- 订单类型 用图标展示 -->
                                                    <img src="${ctx }/images/icon/contract_apply_money.png">
                                                    <div class="mui-media-body">
                                                        <label>材料/项目内容</label>
                                                        <p name="purchaseOrderContent" v="${item.content}">
                                                                ${item.content}
                                                        </p>
                                                    </div>
                                                </div>
                                                <div class="mui-card-content">
                                                    <div class="mui-card-content-inner">
                                                        <p>
                                                            <label name="purchaseOrderModel" v="${item.model}">规格：${item.model}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <label name="purchaseOrderUnit" v="${item.unit}">单位：${item.unit}</label>
                                                        </p>
                                                        <p>
                                                            <label name="purchaseOrderPrice" v="${item.price}">单价:${item.price}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <label name="purchaseOrderAmount" v="${item.amount}">数量：${item.amount}</label>
                                                        </p>
                                                        <p>
                                                            <c:if test="${detailsVo.order.purchaseOrderVo.type == 1}">
                                                                <label name="purchaseOrderWarrantyDate" v="${item.warrantyDate}">质保期（月）：${item.warrantyDate}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                                                            </c:if>
                                                            <c:if test="${detailsVo.order.purchaseOrderVo.type == 2}">
                                                                <label name="purchaseOrderDate"  v="${item.date}">日期：<fmt:formatDate value="${item.date}" pattern="yyyy-MM-dd"/></label>
                                                            </c:if>
                                                        </p>
                                                        <p>
                                                            <label>金额：${item.totalPrice}</label>&nbsp;&nbsp;
                                                            <label  name="purchaseOrderSettleAmout"  v="${item.settleAmout}">已結算数量：${item.settleAmout}</label>
                                                        </p>
                                                    </div>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </c:when>
                        <c:otherwise>
                            <ul class="mui-table-view mui-table-view-radio" style="text-align:center;">没有数据</ul>
                        </c:otherwise>
                    </c:choose>

                    <div class="mui-button-row" style="padding-bottom: 20px;">
                        <button type="button" class="mui-btn mui-btn-primary account-cancel" onclick="cancel();">取消</button>&nbsp;&nbsp;
                        <button type="button" class="mui-btn mui-btn-danger account-ensure" onclick="projectEnsure();">确定</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div id="selectProject" class="mui-page">
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <button type="button" class="mui-left mui-action-back mui-btn  mui-btn-link mui-btn-nav mui-pull-left">
            <span class="mui-icon mui-icon-left-nav"></span>返回
        </button>
        <h1 class="mui-center mui-title">选择来源合同</h1>
    </div>
    <div class="mui-page-content">
        <div class="mui-scroll-wrapper">
            <div class="mui-input-row mui-search">
                <ul class="mui-table-view" style="margin: 5px 15px 10px;z-index: 100">
                    <li class="mui-table-view-cell mui-collapse" id="searchCollapse">
                        <a class="mui-navigate-right" href="#">搜索</a>
                        <div class="mui-collapse-content">
                            <div class="mui-collapse-content">
                                <form class="mui-input-group" id="searchForm">
                                    <div class="mui-input-row">
                                        <label>订单号</label>
                                        <input type="text" placeholder="项目名称" name="name">
                                    </div>
                                    <div class="mui-input-row">
                                        <label>订单类型</label>
                                        <select name="type">
                                            <option value="">全部</option>
                                            <option value="0">绿化苗木</option>
                                            <option value="1">园建水电</option>
                                            <option value="2">机械租赁</option>
                                            <option value="3">工程分包</option>
                                        </select>
                                    </div>
                                    <div class="mui-button-row">
                                        <button class="mui-btn mui-btn-primary" id="search-btn" type="button">确认</button>&nbsp;&nbsp;
                                        <button class="mui-btn mui-btn-danger"  id="cancel-btn" type="button">取消</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="mui-scroll"  style="height: 100%;">
                <!--下拉刷新容器-->
                <div id="projectRefreshContainer" class="mui-content mui-scroll-wrapper">
                    <div class="mui-scroll">
                        <!--数据列表-->
                        <ul id="selectProjectUl" class="mui-table-view mui-table-view-radio projectRefreshContainerData">

                        </ul>
                        <div class="mui-button-row" style="padding-bottom: 20px;">
                            <button type="button" class="mui-btn mui-btn-primary account-cancel" onclick="cancel();">取消</button>&nbsp;&nbsp;
                            <button type="button" class="mui-btn mui-btn-danger account-ensure" onclick="orderTypeEnsure('selectProject','selectProjectText','selectProjectHidden');">确定</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<script type="text/javascript" charset="utf-8">
    mui.init();
    //初始化单页view
    var viewApi = mui('#app').view({
        defaultPage: '#setting'
    });

    mui('.mui-scroll-wrapper').scroll();

    /** 提交详情 **/
    var isSubmit = false;
    mui(document.body).on('tap', '#ucamSave', function(e) {
        if(isSubmit){
            return false;
        }

        var check = true;
        mui("#ucamForm input").each(function() {
            //若当前input为空，则alert提醒
            check = inputVerify(this);
            if(!check){
                return check;
            }
        });
        //校验通过，继续执行业务逻辑
        if(check){
            isSubmit = true
            var url = '${ctx}/mobile/CAM/addCAMOrder'
            $.ajax({
                url: url,
                data: $('#ucamForm').serialize(),
                dataType: 'json',
                contentType : "application/x-www-form-urlencoded",
                type: 'post',
                timeout: 10000,
                success: function(result) {
                    if(result.code!=0){
                        isSubmit = false;
                        mui.alert(data.msg);
                    }else {
                        mui.alert("保存成功！");
                        document.location.href='${ctx }/mobile/CAM/toDetails?id=' + result.msg;
                    }
                }
            });
        }
    })

    /** 提交项 **/
    mui(document.body).on('tap', '#submitFromPurchaseOrderItem', function(e) {
        if(isSubmit){
            return false;
        }

        var check = true;
        mui("#addFromPurchaseOrderItem input").each(function() {
            //若当前input为空，则alert提醒
            check = inputVerify(this);
            if(!check){
                return check;
            }
        });

        //校验通过，继续执行业务逻辑
        if(check){
            isSubmit = true
            submitItem()
        }
    });

    function submitItem(){
        //保存或编辑
        var orderNo = $('#orderNo').val();
        var itemId = $('#addFromPurchaseOrderItem').find('#id').val();
        var url = '${ctx}/mobile/CAM/addCAMItem/'+ orderNo
        if(itemId && itemId != ''){
            url = '${ctx}/mobile/CAM/editCAMItem/';
        }

        $.ajax({
            url: url,
            data: $('#addFromPurchaseOrderItem').serialize(),
            dataType: 'json',
            contentType : "application/x-www-form-urlencoded",
            type: 'post',
            timeout: 10000,
            success: function(result) {
                if(result.code!=0){
                    isSubmit = false;
                    mui.alert(result.msg);
                }else {
                    mui.alert('保存成功！', function() {
                        document.location.href='${ctx }/mobile/CAM/toDetails?id=${detailsVo.order.id}';
                    });
                }
            }
        });
    }

    /** 删除合同内请款单 **/
    mui(document.body).on('tap', '#deletePurchaseOrder', function(e) {
        var id = this.value;
        var btnArray = ['是', '否'];
        mui.confirm('确认删除此合同内请款单？', '删除合同内请款单', btnArray, function(e) {
            if (e.index == 0) {
                var url = '${ctx}/mobile/CAM/delCAM?id='+ id
                $.ajax({
                    url: url,
                    dataType: 'json',
                    contentType : "application/x-www-form-urlencoded",
                    type: 'post',
                    timeout: 10000,
                    success: function(result) {
                        if(result.code!=0){
                            mui.alert(result.msg);
                        }else {
                            mui.alert('删除成功！', function() {
                                document.location.href='${ctx }/mobile/CAM/list';
                            });
                        }
                    }
                });
            }
        })
    });

    /** 填写合同号 **/
    mui(document.body).on('tap', '#purchaseOrderContractNo', function(e) {
        var btnArray = ['取消', '确定'];
        var id = this.value;
        mui.prompt('请输入合同内请款单合同号', '请输入合同号', '合同内请款单合同号', btnArray, function(e1) {
            if (e1.index == 1) {
                var contractNo = e1.value;
                if(contractNo == '' || contractNo.trim() == ''){
                    mui.alert('请填写合同号！');
                    return false
                }else {
                    var url = '${ctx}/mobile/purchase/purchaseOrderContractNo/'+ id + '?contractNo=' + contractNo;
                    $.ajax({
                        url: url,
                        dataType: 'json',
                        contentType : "application/x-www-form-urlencoded",
                        type: 'post',
                        timeout: 10000,
                        success: function(result) {
                            if(result.code!=0){
                                mui.alert(result.msg);
                            }else {
                                mui.alert('添加成功！', function() {
                                    document.location.href='${ctx }/mobile/purchase/toDetails?id=${detailsVo.order.id}';
                                });
                            }
                        }
                    });
                }
            }
        })
    });

    /** 删除项 **/
    mui(document.body).on('tap', '#deleteItem', function(e) {
        var itemId = this.value;
        var btnArray = ['是', '否'];
        mui.confirm('确认删除此项？', '删除项', btnArray, function(e) {
            if (e.index == 0) {
                var url = '${ctx}/mobile/CAM/delCAMItem/'+ itemId
                $.ajax({
                    url: url,
                    dataType: 'json',
                    contentType : "application/x-www-form-urlencoded",
                    type: 'post',
                    timeout: 10000,
                    success: function(result) {
                        if(result.code!=0){
                            mui.alert(result.msg);
                        }else {
                            mui.alert('删除成功！', function() {
                                document.location.href='${ctx }/mobile/CAM/toDetails?id=${detailsVo.order.id}';
                            });
                        }
                    }
                });
            }
        })
    });


    /** 选择审核人 **/
    mui(document.body).on('tap', '#orderDetails', function(e) {
        <c:if test="${fn:length(detailsVo.details) == 0}">
            mui.alert("请先添加明细！");
            return false;
        </c:if>
        submitOrder();
    });
    
    function submitOrder() {
        var adminsJson = '${reviewAdmins}'
        var json =JSON.parse(adminsJson)
        var userPicker = new mui.PopPicker({
            layer: 2
        });
        userPicker.setData(json);
        userPicker.show(function (selectItems) {
            var text = selectItems[0].text;
            mui.alert('确定提审核人为：' + text + "？" , function() {
                var roleId = selectItems[0].value;
                var userId = selectItems[1].value;
                var url = '${ctx}/mobile/CAM/submitReviewCAMOrder?id=${detailsVo.order.id}&userId=' + userId + '&roleId=' + roleId;
                $.ajax({
                    url: url,
                    dataType: 'json',
                    contentType : "application/x-www-form-urlencoded",
                    type: 'post',
                    timeout: 10000,
                    success: function(result) {
                        if(result.code!=0){
                            mui.alert(result.msg);
                        }else {
                            mui.alert('提交审核成功！', function() {
                                document.location.href='${ctx }/mobile/CAM/toDetails?id=${detailsVo.order.id}';
                            });
                        }
                    }
                });
            });
        });
    }


    //选择合同订单明细
    var oldBack = mui.back;
    function cancel(){
        if (viewApi.canBack()) { //如果view可以后退，则执行view的后退
            viewApi.back();
        } else { //执行webview后退
            oldBack();
        }
    }
    function projectEnsure(){
        var accountSelected = $("#fromPurchaseOrderDetailsItem").find("li").hasClass("mui-selected");
        if(accountSelected){
            //获取合同订单参数
            var lis = $("#fromPurchaseOrderDetailsItem").find("li.mui-selected");

            //引用ID
            var ids = "";
            $(lis).each(function(index,obj){
                ids += $(obj).attr("v") + ",";
            });
            ids.substring(0,ids.length-1);

            var url = '${ctx}/mobile/CAM/addCAMItems/${detailsVo.order.orderNo}'
            $.ajax({
                url: url,
                data: {ids:ids},
                dataType: 'json',
                contentType : "application/x-www-form-urlencoded",
                type: 'post',
                timeout: 10000,
                success: function(result) {
                    if(result.code!=0){
                        isSubmit = false;
                        mui.alert(result.msg);
                    }else {
                        mui.alert('保存成功！', function() {
                            document.location.href='${ctx }/mobile/CAM/toDetails?id=${detailsVo.order.id}';
                        });
                    }
                }
            });
        }else{
            mui.toast('您尚未选择，请选择后确定',{ duration:'long', type:'div' })
        }
    }


    var camVoOrderType = '${detailsVo.order.orderType}';
    //初始化数据
    mui.ready(function() {
        //供应商
        var url = '${ctx}/supplier/findSuppliersAll';
        $.ajax({
            url: url, dataType: 'json',   contentType : "application/x-www-form-urlencoded",  type: 'post', timeout: 10000,
            success: function(result) {
                if(result != null && result.length != 0){

                }
            }
        });

        var appB = document.getElementById('app-b');
        appB.addEventListener('tap', function(event) {
            $purchaseOrder.projectList();
        },false);


        var appA = document.getElementsByName('app-a');
        if(appA.length > 0){
            for(var i = 0; i < appA.length; i++){
                appA[i].addEventListener('tap', function(event) {
                    var itemId = $(this).attr("data-id");
                    var url = '${ctx}/mobile/CAM/getCAMItem/' + itemId;
                    $.ajax({
                        url: url,
                        contentType : "application/x-www-form-urlencoded",
                        type: 'post',
                        timeout: 10000,
                        success: function(result) {
                            if(result.code!=0){
                                alert(result.msg);
                            }else {
                                var data = result.data;
                                $("#addFromPurchaseOrderItem").find("#id").val(data.id);
                                $("#addFromPurchaseOrderItem").find("input[name='constructionSite']").val(data.constructionSite);
                                $("#addFromPurchaseOrderItem").find("input[name='projectContent']").val(data.projectContent);
                                $("#addFromPurchaseOrderItem").find("input[name='model']").val(data.model);
                                $("#addFromPurchaseOrderItem").find("input[name='price']").val(data.price);
                                $("#addFromPurchaseOrderItem").find("input[name='contractCount']").val(data.contractCount);
                                $("#addFromPurchaseOrderItem").find("input[name='unit']").val(data.unit);

                                //设置结算数量最大值
                                var settleAmout =  $("#addFromPurchaseOrderItem").find("input[name='settleAmout']");
                                var mui_verify = settleAmout.attr('mui-verify');
                                settleAmout.attr('mui-verify',mui_verify + "|max=" + data.settleAmout);
                                settleAmout.val(data.settleAmout);

                                $("#addFromPurchaseOrderItem").find("input[name='settlePrice']").val(data.settlePrice);
                                $("#remark").val(data.remark);

                                if(camVoOrderType == 1){
                                    $("#warrantyDate").val(data.warrantyDate);
                                }
                                if(camVoOrderType == 2){
                                    $("#date").val(data.date);
                                }
                            }
                        }
                    });
                },false);
            }
        }

        var userType = '${admin.userType}';
        console.log(userType);
        var adminsJson = '${admins}';
        console.log(adminsJson);

        if(userType == 1){
            var userPicker = new mui.PopPicker();
            userPicker.setData(JSON.parse(adminsJson));
            var selectApplyUserEdit = document.getElementById('selectApplyUserEdit');
            var applyUserEdit = document.getElementById('applyUserEdit');
            selectApplyUserEdit.addEventListener('tap', function(event) {
                userPicker.show(function(items) {
                    selectApplyUserEdit.value = items[0].text;
                    applyUserEdit.value = items[0].value;
                    //返回 false 可以阻止选择框的关闭
                    //return false;
                    var url = '${ctx}/sys/getAdmin?id=' + items[0].value;
                    $.ajax({
                        url: url,
                        type: 'get',
                        timeout: 10000,
                        success: function(result) {
                            if(result.code == 0){
                                $("#supplierId").val(result.data.supplierId);
                                $("#supplierName").val(result.data.supplierName);
                            }
                        }
                    });
                });
            }, false);
        }else{
            var userPicker = new mui.PopPicker({
                layer: 2
            });
            userPicker.setData(JSON.parse(adminsJson));
            var selectApplyUserEdit = document.getElementById('selectApplyUserEdit');
            var applyUserEdit = document.getElementById('applyUserEdit');
            var supplierId = document.getElementById('supplierId');
            var supplierName = document.getElementById('supplierName');
            selectApplyUserEdit.addEventListener('tap', function(event) {
                userPicker.show(function(items) {
                    supplierName.value = items[0].text;
                    supplierId.value = items[0].value;
                    selectApplyUserEdit.value = items[1].text;
                    applyUserEdit.value = items[1].value;
                });
            }, false);
        }

        //计算金额
        document.getElementById("settleAmout").addEventListener("change", totalPriceReckon, false);
        function totalPriceReckon(){
            var amount = document.getElementById("settleAmout");
            var price = document.getElementById("price");
            if(price.value != "" && amount.value != ""){
                var applyPrice = price.value * amount.value;
                document.getElementById("settlePrice").value = applyPrice;
            }
        }
    });

    /** start 选择来源合同 **/
    mui(document.body).on('tap', '#search-btn', function(e) {
        $('#searchCollapse').removeClass('mui-active')
        $purchaseOrder.projectList();
    });

    mui(document.body).on('tap', '#cancel-btn', function(e) {
        $('#searchCollapse').removeClass('mui-active')
    });

    //选择项目
    var $purchaseOrder = {
        list : mui('#projectRefreshContainer'),
        page : 1, //当前页
        limit :  10, //每页显示条数
        enablePullUp : true, //是否加载
        projectList:function () {
            this.list.pullRefresh({
                down : {
                    style:'circle',//必选，下拉刷新样式，目前支持原生5+ ‘circle’ 样式
                    auto: true,//可选,默认false.首次加载自动上拉刷新一次
                    callback :this.billRefresh
                },
                up: {
                    auto:false,
                    contentrefresh: '正在加载...',
                    contentnomore:'',
                    callback: this.billLoad
                }
            })
        },
        billLoad : function() {
            if (!$purchaseOrder.enablePullUp) {
                $purchaseOrder.list.pullRefresh().endPullupToRefresh(false);
                mui.toast("没有更多数据了");
                return;
            }
            $purchaseOrder.page++;
            $purchaseOrder.getBill();
            $purchaseOrder.list.pullRefresh().endPullupToRefresh(false);
        },
        billRefresh : function() {
            $('.projectRefreshContainerData').empty();
            $purchaseOrder.enablePullUp = true;
            $purchaseOrder.page = 1;
            $purchaseOrder.getBill();

            $purchaseOrder.list.pullRefresh().endPulldownToRefresh();
        },
        getBill: function () {
            var url = '${ctx}/mobile/purchase/findPurchaseOrderList?' + 'limit=' + $purchaseOrder.limit + '&page=' + $purchaseOrder.page;
            mui.toast("加载中...",1000);
            $.ajax({
                url: url,
                data: $('#searchForm').serialize(),
                dataType: 'json',
                contentType : "application/x-www-form-urlencoded",
                type: 'post',
                timeout: 10000,
                success: function(result) {
                    if(result.data != null && result.data.length != 0){
                        var data = result.data;
                        // 请求成功
                        var listTargt = $('.projectRefreshContainerData')

                        var tpl = $("#listTpl").html();
                        //预编译模板
                        var template = Handlebars.compile(tpl);

                        //匹配json内容
                        var html = template({data});//data
                        //输入模板
                        listTargt.append(html);

                        if (data.length < this.limit) {
                            $purchaseOrder.enablePullUp = false;
                        }
                    }
                },
                error: function () {
                    $purchaseOrder.list.pullRefresh().endPullupToRefresh(false); //参数为true代表没有更多数据了。
                    $purchaseOrder.list.pullRefresh().endPulldownToRefresh(); //refresh completed
                    $purchaseOrder.enablePullUp = false;
                }
            });
        }
    }

    var oldBack = mui.back;
    function cancel(){
        if (viewApi.canBack()) { //如果view可以后退，则执行view的后退
            viewApi.back();
        } else { //执行webview后退
            oldBack();
        }
    }
    function orderTypeEnsure(flag,callText,callValue){
        var accountSelected = $("#" + flag).find("li").hasClass("mui-selected");
        if(accountSelected){
            var id ='${detailsVo.order.id}';
            var selectProjectHidden = $('#selectProjectHidden').val();

            var li = $("#" + flag).find("li.mui-selected");
            var value = $(li).attr("data-id");
            var text = $(li).attr("data-text");
            console.log(value + "/n" +text);
            if(!(selectProjectHidden == '' && selectProjectHidden == null) && id != '' && value != selectProjectHidden){
                mui.alert('修改订单来源会清空请款单明细，确认操作？' , function() {
                    $("#" + callText).text(text);
                    $("#" + callValue).val(value);
                    cancel();
                });
            }else {
                $("#" + callText).text(text);
                $("#" + callValue).val(value);
                cancel();
            }
        }else{
            mui.toast('您尚未选择，请选择后确定',{ duration:'long', type:'div' })
        }
    }

    (function($) {
        $.init();
        //var result = $('#dateText');
        var btns =  $('#dateText');
        btns.each(function(i, btn) {
            btn.addEventListener('tap', function() {
                var optionsJson = this.getAttribute('data-options') || '{}';
                var options = JSON.parse(optionsJson);
                var id = this.getAttribute('id');
                var picker = new $.DtPicker(options);
                picker.show(function(rs) {
                    dateText.value = rs.text;
                    picker.dispose();
                });
            }, false);
        });

    })(mui);

    var view = viewApi.view;
    (function($) {
        //处理view的后退与webview后退
        var oldBack = $.back;
        $.back = function() {
            if (viewApi.canBack()) { //如果view可以后退，则执行view的
                document.getElementById('addFromPurchaseOrderItem').reset();
                viewApi.back();
            } else { //执行webview后退
                //oldBack();
                history.go(-1);
            }
        };
        //监听页面切换事件方案1,通过view元素监听所有页面切换事件，目前提供pageBeforeShow|pageShow|pageBeforeBack|pageBack四种事件(before事件为动画开始前触发)
        //第一个参数为事件名称，第二个参数为事件回调，其中e.detail.page为当前页面的html对象
        view.addEventListener('pageBeforeShow', function(e) {
            //				console.log(e.detail.page.id + ' beforeShow');
        });
        view.addEventListener('pageShow', function(e) {
            //				console.log(e.detail.page.id + ' show');
        });
        view.addEventListener('pageBeforeBack', function(e) {
            //				console.log(e.detail.page.id + ' beforeBack');
        });
        view.addEventListener('pageBack', function(e) {
            //				console.log(e.detail.page.id + ' back');
        });
    })(mui);

    var dcLength = $("#detailDiv").find("div.mui-card").length;
    if(dcLength > 0){
        $("#ul_mui_table_view").find("li").removeClass("mui-active");
        $("#ul_mui_table_view").find("li").eq(2).addClass("mui-active");
    }
</script>
<script type="text/template" id="listTpl">
    {{#each data}}
    <li class="mui-table-view-cell" data-id="{{id}}" data-text="{{purchaseNo}}">
        <a class="mui-navigate-right">{{purchaseNo}}</a>
    </li>
    {{/each}}
</script>

<!-- 审核 -->
<c:set value="${ctx}/mobile/CAM/toDetails?id=${detailsVo.order.id}" var="reviewRefreshUrl"/>
<c:set value="${ctx}/mobile/CAM/reviewCAMOrder/${detailsVo.order.id}" var="reviewSaveUrl"/>
<c:set value="${detailsVo.order.status}" var="reviewStatus"/>
<%@ include file="/WEB-INF/page/mobile/common/review.jsp"%>
<!-- 审核 -->

</body>
</html>