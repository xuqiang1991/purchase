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
        <button type="button" class="mui-left mui-action-back mui-btn  mui-btn-link mui-btn-nav mui-pull-left">
            <span class="mui-icon mui-icon-left-nav"></span>
        </button>
        <h1 class="mui-center mui-title">合同内请款单详情</h1>
    </div>

    <!-- 合同内请款明细 start -->
    <div id="refreshContainer" class="mui-content mui-scroll-wrapper" style="margin-top: 0px;width: 100%;">
        <div class="mui-scroll">
            <!-- 主界面具体展示内容 -->
                <div class="mui-content" style="margin-left: 5px; margin-right: 5px; font-size: 14px;">
                    <ul class="mui-table-view">
                        <li class="mui-table-view-cell mui-collapse">
                        <a class="mui-navigate-right" href="#">合同内请款单详情</a>
                        <div class="mui-collapse-content">
                            <!-- 主界面具体展示内容 -->
                            <div class="mui-input-row">
                                <label>订单号</label>
                                <label style="width: 65%;padding-left: 0px;">${detailsVo.order.orderNo}</label>
                            </div>
                            <div class="mui-input-row">
                                <label>订单类型</label>
                                <label style="width: 65%;padding-left: 0px;">${detailsVo.orderType}</label>
                            </div>
                            <div class="mui-input-row">
                                <label>来源订单</label>
                                <label style="width: 65%;padding-left: 0px;">${detailsVo.order.purchaseOrderVo.purchaseNo}</label>
                            </div>
                            <div class="mui-input-row">
                                <label>供应商</label>
                                <label style="width: 65%;padding-left: 0px;">${detailsVo.order.supplier.name}</label>
                            </div>
                            <div class="mui-input-row">
                                <label>所属项目</label>
                                <label style="width: 65%;padding-left: 0px;">${detailsVo.order.purchaseOrderVo.projectManger.name}</label>
                            </div>
                            <div class="mui-input-row">
                                <label>请款人</label>
                                <label style="width: 65%;padding-left: 0px;">${detailsVo.order.applyAdmin.fullname}</label>
                            </div>
                            <div class="mui-input-row mui-input-range">
                                <label>开单人</label>
                                <label style="width: 65%;padding-left: 0px;">${detailsVo.order.admin.fullname}</label>
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
                            <div>
                                <textarea name="summary" id="summary" rows="5" class="mui-input-clear" readonly="readonly">${detailsVo.order.summary}</textarea>
                            </div>
                        </div>
                    </li>

                    <!-- 审核状态 -->
                    <c:set value="${detailsVo.order.historyList}" var="historyList"/>
                    <%@ include file="/WEB-INF/page/mobile/common/reviewHistory.jsp"%>

                    <li class="mui-table-view-cell mui-collapse mui-active">
                        <a class="mui-navigate-right" href="#">合同内请款单明细</a>
                        <div class="mui-collapse-content">
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
                                                <c:if test="${detailsVo.order.status == 0}">
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
                    <c:when test="${detailsVo.order.status == 0}">
                        <a href="#fromPurchaseOrderDetailsItem">
                            <button type="button" class="mui-btn mui-btn-primary mui-btn-block">增加合同内请款明细</button>
                        </a>
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="orderDetails">提交</button>
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="deletePurchaseOrder" value="${detailsVo.order.id}">删除</button>
                    </c:when>
                    <%--<c:when test="${detailsVo.order.status == 1 && empty detailsVo.order.costDepartUser && empty detailsVo.reviewUserId}">--%>
                        <%--<button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="submitReviewPurchaseOrder">选择审核人</button>--%>
                    <%--</c:when>--%>
                    <c:when test="${detailsVo.reviewUserId == admin.id}">
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
                    <div class="mui-input-row">
                        <label>施工部位</label>
                        <input type="text" name="constructionSite" class="mui-input-clear" mui-verify="required" placeholder="请施工部位">
                    </div>
                    <div class="mui-input-row">
                        <label>项目内容</label>
                        <input type="text" name="projectContent" class="mui-input-clear" mui-verify="required" placeholder="请输入项目内容">
                    </div>
                    <div class="mui-input-row">
                        <label>规格型号</label>
                        <input type="text" name="model" class="mui-input-clear" mui-verify="required" placeholder="请输入规格型号">
                    </div>
                    <div class="mui-input-row">
                        <label>单位</label>
                        <input type="text" name="unit" class="mui-input-clear" mui-verify="required" placeholder="请输入单位">
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
                        <input type="number" id="settleAmout" name="settleAmout" class="mui-input-clear" mui-verify="required" placeholder="请输入结算数量">
                    </div>
                    <div class="mui-input-row">
                        <label>结算金额</label>
                        <input type="number" id="settlePrice" name="settlePrice" class="mui-input-clear" mui-verify="required" readonly  unselectable="no">
                    </div>
                    <c:if test="${detailsVo.order.orderType == 1}">
                        <div class="mui-input-row">
                            <label>质保期（月）</label>
                            <input type="number" name="warrantyDate" class="mui-input-clear" mui-verify="required" placeholder="请输入质保期（月）">
                        </div>
                    </c:if>
                    <c:if test="${detailsVo.order.orderType == 2}">
                        <div class="mui-input-row">
                            <label>日期</label>
                            <input id="dateText" type="text" name="date" class="mui-input-clear" mui-verify="required" data-options='{"type":"date","beginYear":2014}' placeholder="请选择日期">
                        </div>
                    </c:if>
                    <div>
                        <textarea name="remark" id="remark" rows="5" class="mui-input-clear" placeholder="备注"></textarea>
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
        <h1 class="mui-center mui-title">选择采购单明细</h1>
    </div>
    <div class="mui-page-content">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll"  style="height: 100%;">
                <form class="mui-input-group" id="addFromPurchaseOrderDetailsItem">
                    <ul class="mui-table-view mui-table-view-radio">
                        <c:forEach items="${detailsVo.order.details}" var="item">
                            <li class="mui-table-view-cell" style="position: static;" v="${item.id}">
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
                    <div class="mui-button-row" style="padding-bottom: 20px;">
                        <button type="button" class="mui-btn mui-btn-primary account-cancel" onclick="cancel();">取消</button>&nbsp;&nbsp;
                        <button type="button" class="mui-btn mui-btn-danger account-ensure" onclick="projectEnsure();">确定</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/mui/js/mui.min.js"></script>
<script src="${ctx }/mui/js/mui.picker.min.js"></script>
<script src="${ctx }/mui/js/mui.view.js"></script>
<script type="text/javascript" src="http://apps.bdimg.com/libs/handlebars.js/2.0.0-alpha.4/handlebars.js"></script>
<script type="text/javascript" charset="utf-8">
    mui.init();
    //初始化单页view
    var viewApi = mui('#app').view({
        defaultPage: '#setting'
    });

    mui('.mui-scroll-wrapper').scroll();

    /** 提交项 **/
    mui(document.body).on('tap', '#submitFromPurchaseOrderItem', function(e) {
        var check = true;
        mui("#addFromPurchaseOrderItem input").each(function() {
            //若当前input为空，则alert提醒
            var verify = $(this).attr("mui-verify")
            if(verify == 'required'){
                if(!this.value || this.value.trim() == "") {
                    var label = this.previousElementSibling;
                    mui.alert(label.innerText + "不允许为空");
                    check = false;
                    return false;
                }
            }
        });


        //校验通过，继续执行业务逻辑
        if(check){

            //检查是否有多条请款单
            var checkCAMItemData = {};
            var purchaseDetailId = $('#addFromPurchaseOrderItem').find('#purchaseDetailId').val();
            var ajaxUrl = '${ctx}/mobile/CAM/checkCAMItem/'+ purchaseDetailId
            $.ajax({
                url: ajaxUrl,
                dataType: 'json',
                contentType : "application/x-www-form-urlencoded",
                type: 'post',
                timeout: 10000,
                async: false,
                success: function(result) {
                    checkCAMItemData = result.data;
                }
            });

            var settleAmount = $("#addFromPurchaseOrderItem").find("input[name='settleAmout']").val();
            if(checkCAMItemData != null){
                checkCAMItemData.amount =  checkCAMItemData.amount - settleAmount;
            }

            //检查提示
            if(checkCAMItemData != null && (checkCAMItemData.amount < 0 || checkCAMItemData.count > 0)){
                var msg;
                if(checkCAMItemData.amount < 0 && checkCAMItemData.count > 0){
                    msg = "采购单明细有多条，且结算数量超过采购单未到货数量，是否提交？"
                }else if(checkCAMItemData.amount < 0){
                    msg = "采购单明细结算数量超过采购单未到货数量，是否提交？"
                }else if(checkCAMItemData.count < 0){
                    msg = "采购单明细有多条，是否提交？"
                }

                var btnArray = ['是', '否'];
                mui.confirm(msg,"提示",btnArray, function(e) {
                    if (e.index == 0) {
                        submitItem();
                    }
                })
            }else {
                submitItem()
            }
        }else{
            mui.toast('检验不通过，请重新填写！',{ duration:'long', type:'div' })
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
                    mui.alert(result.msg);
                }else {
                    mui.alert('保存成功！', function() {
                        document.location.href='${ctx }/mobile/CAM/toDetails/${detailsVo.order.id}';
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
                                    document.location.href='${ctx }/mobile/purchase/toDetails/${detailsVo.order.id}';
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
                                document.location.href='${ctx }/mobile/CAM/toDetails/${detailsVo.order.id}';
                            });
                        }
                    }
                });
            }
        })
    });

    /** 提交审核 **/
    <%--mui(document.body).on('tap', '#purchaseOrderDetails', function(e) {--%>
        <%--var btnArray = ['是', '否'];--%>
        <%--mui.confirm('确认提交？', '提交合同内请款单', btnArray, function(e) {--%>
            <%--if (e.index == 0) {--%>
                <%--var url = '${ctx}/mobile/CAM/submitCAMOrder?id=${detailsVo.order.id}';--%>
                <%--$.ajax({--%>
                    <%--url: url,--%>
                    <%--dataType: 'json',--%>
                    <%--contentType : "application/x-www-form-urlencoded",--%>
                    <%--type: 'post',--%>
                    <%--timeout: 10000,--%>
                    <%--success: function(result) {--%>
                        <%--if(result.code!=0){--%>
                            <%--mui.alert(result.msg);--%>
                        <%--}else {--%>
                            <%--mui.alert('提交成功！', function() {--%>
                                <%--document.location.href='${ctx }/mobile/CAM/toDetails/${detailsVo.order.id}';--%>
                            <%--});--%>
                        <%--}--%>
                    <%--}--%>
                <%--});--%>
            <%--}--%>
        <%--})--%>
    <%--});--%>

    /** 选择审核人 **/
    mui(document.body).on('tap', '#orderDetails', function(e) {

        <c:if test="${fn:length(detailsVo.details) == 0}">
            mui.alert("请先添加明细！");
            return false;
        </c:if>

        var checkC = checkCAM("提交");
        if(!checkC){
            return false;
        }

        var adminsJson = '${detailsVo.departs}'
        var json =JSON.parse(adminsJson)
        var userPicker = new mui.PopPicker();
        userPicker.setData(json);
        userPicker.show(function (selectItems) {
            var text = selectItems[0].text;
            mui.alert('确定提审核人为：' + text + "？" , function() {
                var userId = selectItems[0].value;
                var url = '${ctx}/mobile/CAM/submitReviewCAMOrder?id=${detailsVo.order.id}&userId=' + userId;
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
                                document.location.href='${ctx }/mobile/CAM/toDetails/${detailsVo.order.id}';
                            });
                        }
                    }
                });
            });

        });
    });


    //选择采购单明细
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
            //获取采购单参数
            var li = $("#fromPurchaseOrderDetailsItem").find("li.mui-selected");

            var purchaseOrderDetailsId = $(li).attr("v");
            var purchaseOrderContent = $(li).find('p[name="purchaseOrderContent"]').attr("v");
            var purchaseOrderModel = $(li).find('label[name="purchaseOrderModel"]').attr("v");
            var purchaseOrderUnit = $(li).find('label[name="purchaseOrderUnit"]').attr("v");
            var purchaseOrderPrice = $(li).find('label[name="purchaseOrderPrice"]').attr("v");
            var purchaseOrderAmount = $(li).find('label[name="purchaseOrderAmount"]').attr("v");
            var purchaseOrderWarrantyDate = $(li).find('label[name="purchaseOrderWarrantyDate"]').attr("v");
            var purchaseOrderDate = $(li).find('label[name="purchaseOrderDate"]').attr("v");
            var purchaseOrderSettleAmout = $(li).find('label[name="purchaseOrderSettleAmout"]').attr("v");


            //请款数量
            var settleAmount = (purchaseOrderAmount - purchaseOrderSettleAmout);
            if(settleAmount < 0){//请款数量小于0的时候，设置为0
                settleAmount = 0;
            }
            //请款金额
            var settlePrice = purchaseOrderPrice * settleAmount;

            //赋值到请款单
            $("#addFromPurchaseOrderItem").find("input[name='purchaseDetailId']").val(purchaseOrderDetailsId);
            $("#addFromPurchaseOrderItem").find("input[name='projectContent']").val(purchaseOrderContent);
            $("#addFromPurchaseOrderItem").find("input[name='model']").val(purchaseOrderModel);
            $("#addFromPurchaseOrderItem").find("input[name='unit']").val(purchaseOrderUnit);
            $("#addFromPurchaseOrderItem").find("input[name='price']").val(purchaseOrderPrice);
            $("#addFromPurchaseOrderItem").find("input[name='settleAmout']").val(settleAmount);
            $("#addFromPurchaseOrderItem").find("input[name='settlePrice']").val(settlePrice);
            $("#addFromPurchaseOrderItem").find("input[name='contractCount']").val(purchaseOrderAmount);
            if(purchaseOrderWarrantyDate != undefined){
                $("#addFromPurchaseOrderItem").find("input[name='warrantyDate']").val(purchaseOrderWarrantyDate);
            }
            if(purchaseOrderDate != undefined){
                $("#addFromPurchaseOrderItem").find("input[name='date']").val(purchaseOrderDate);
            }
            viewApi.go("#fromPurchaseOrderItem");
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
                                $("#addFromPurchaseOrderItem").find("input[name='settleAmout']").val(data.settleAmout);
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
    
    
    function checkCAM(type) {
        //检查是否有多条请款单
        var checkCAMItemData = {};
        var ajaxUrl = '${ctx}/mobile/CAM/checkCAM/${detailsVo.order.id}'
        $.ajax({
            url: ajaxUrl,
            dataType: 'json',
            contentType : "application/x-www-form-urlencoded",
            type: 'post',
            timeout: 10000,
            async: false,
            success: function(result) {
                checkCAMItemData = result.data;
            }
        });

        //检查提示
        if(checkCAMItemData != null && (checkCAMItemData.amount < 0 || checkCAMItemData.count > 0)){
            var msg = "采购单明细结算数量超过采购单未到货数量，是否"+type+"？"
            if(checkCAMItemData.amount < 0 && checkCAMItemData.count > 0){
                msg = "采购单明细有多条，且结算数量超过采购单未到货数量，是否"+type+"？"
            }else if(checkCAMItemData.amount < 0){
                msg = "采购单明细结算数量超过采购单未到货数量，是否"+type+"？"
            }else if(checkCAMItemData.count < 0){
                msg = "采购单明细有多条，是否"+type+"？"
            }

            var btnArray = ['是', '否'];
            mui.confirm(msg,"提示",btnArray, function(e) {
                if (e.index == 0) {
                    return true;
                }
            })
        }else {
            return false;
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
</script>

<!-- 审核 -->
<c:set value="${ctx}/mobile/CAM/toDetails/${detailsVo.order.id}" var="reviewRefreshUrl"/>
<c:set value="${ctx}/mobile/CAM/reviewCAMOrder/${detailsVo.order.id}" var="reviewSaveUrl"/>
<c:set value="${detailsVo.order.status}" var="reviewStatus"/>
<c:set value="true" var="reviewCheckCAM"/>
<%@ include file="/WEB-INF/page/mobile/common/review.jsp"%>
<!-- 审核 -->

</body>
</html>