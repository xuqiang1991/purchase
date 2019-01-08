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
        #div {
            width: 0px;
            height: 0px;
            background: red;
            position: fixed;
            top: 70%;
            left: 50%;
        }
        /*移除底部或顶部三角,需要在删除此代码*/
        .mui-popover .mui-popover-arrow:after {
            width: 0px;
        }

        .mui-input-row label{
            width: 40%;
        }
        .mui-input-row label~input{
            width: 60%;
        }
        .mui-input-row label~label{
            width: 60%;
            padding: 11px 0px;
        }
        .appClassForA{
            color: #0C0C0C;
            font-size: 17px;
        }
    </style>
    <script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/mui/js/mui.min.js"></script>
    <script src="${ctx }/mui/js/mui.picker.min.js"></script>
    <script src="${ctx }/mui/js/mui.view.js"></script>
    <script type="text/javascript" src="${ctx}/js/handlebars.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/handlebarsHelps.js"></script>
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
        <h1 class="mui-center mui-title">合同订单详情</h1>
    </div>

    <!-- 合同订单明细 start -->
    <div id="refreshContainer" class="mui-content mui-scroll-wrapper" style="margin-top: 0px;width: 100%;">
        <div class="mui-scroll">

            <!-- 主界面具体展示内容 -->
            <div class="mui-content" style="margin-left: 5px; margin-right: 5px; font-size: 14px;">
                <ul id="ul_mui_table_view" class="mui-table-view">
                    <li class="mui-table-view-cell mui-collapse mui-active">
                        <a class="mui-navigate-right" href="#">合同订单详情:
                            <c:choose>
                                <c:when test="${detailsVo.purchaseOrder.id == null}">
                                    请先添加合同订单
                                </c:when>
                                <c:otherwise>
                                    ${detailsVo.purchaseOrder.purchaseNo}
                                </c:otherwise>
                            </c:choose>
                        </a>
                        <div class="mui-collapse-content">
                            <form class="mui-input-group" id="ucamForm">
                                <input type="hidden" name="id" id="id" value="${detailsVo.purchaseOrder.id}">
                                <input type="hidden" name="isApproval" id="isApproval" value="${detailsVo.purchaseOrder.isApproval}">
                                <div class="mui-input-row">
                                    <label>合同订单号</label>
                                    <input type="text" name="purchaseNo" id="purchaseNo" readonly disabled="disabled" value="${detailsVo.purchaseOrder.purchaseNo}" placeholder="合同订单号由系统自动生成">
                                </div>
                                <div class="mui-input-row">
                                    <label>申请人</label>
                                    <c:choose>
                                        <c:when test="${detailsVo.purchaseOrder.id == null}">
                                            <input type="text" id="selectApplyUserEdit" placeholder="请选择开单人" value="${admin.fullname}">
                                            <input type="hidden" id="applyUserEdit" name="applyUser" value="${admin.id}" mui-verify="required">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="text" id="selectApplyUserEdit" placeholder="请选择开单人" value="${detailsVo.purchaseOrder.admin.fullname}">
                                            <input type="hidden" id="applyUserEdit" name="applyUser" value="${detailsVo.purchaseOrder.admin.id}" mui-verify="required">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mui-input-row">
                                    <label>供应商</label>
                                    <c:choose>
                                        <c:when test="${detailsVo.purchaseOrder.id == null}">
                                            <c:choose>
                                                <c:when test="${admin.supplierId == null}">
                                                    <input type="text" id="supplierName" readonly value="" placeholder="请选择申请人">
                                                    <input type="hidden" id="supplierId" name="supplierId" value="" mui-verify="required">
                                                </c:when>
                                                <c:otherwise>
                                                    <input type="text" id="supplierName" readonly value="${admin.supplierName}" placeholder="请选择申请人">
                                                    <input type="hidden" id="supplierId" name="supplierId" value="${admin.supplierId}" mui-verify="required">
                                                </c:otherwise>
                                            </c:choose>
                                        </c:when>
                                        <c:otherwise>
                                            <input type="text" id="supplierName" readonly value="${detailsVo.purchaseOrder.supplier.name}" placeholder="请选择申请人">
                                            <input type="hidden" id="supplierId" name="supplierId" value="${detailsVo.purchaseOrder.supplier.id}" mui-verify="required">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mui-input-row">
                                    <label>所属项目</label>
                                    <c:choose>
                                        <c:when test="${detailsVo.purchaseOrder.id == null || (detailsVo.purchaseOrder.id != null && detailsVo.purchaseOrder.isSaveSubmit == 0)}">
                                            <a href="#selectProject" id="app-selectProject" class="appClassForA">
                                                <label id="selectProjectText" style="padding-left: 0px;">
                                                    <c:choose>
                                                        <c:when test="${detailsVo.purchaseOrder.id == null}">
                                                            请选择所属项目
                                                        </c:when>
                                                        <c:otherwise>
                                                            ${detailsVo.purchaseOrder.tpm.name}
                                                        </c:otherwise>
                                                    </c:choose>
                                                </label>
                                                <input type="hidden" id="selectProjectHidden" name="projectId" value="${detailsVo.purchaseOrder.tpm.id}" mui-verify="required">
                                            </a>
                                        </c:when>
                                        <c:otherwise>
                                            <input type="text" readonly value="${detailsVo.purchaseOrder.tpm.name}">
                                            <input type="hidden" id="selectProjectHidden" name="projectId" value="${detailsVo.purchaseOrder.tpm.id}" mui-verify="required">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mui-input-row">
                                    <label>单据类型</label>
                                    <input type="text" id="typeName" readonly class="mui-input-clear" placeholder="请选择单据类型" value="">
                                    <input type="hidden" id="type" name="type" value="${detailsVo.purchaseOrder.type}"  mui-verify="required">
                                </div>
                                <c:if test="${detailsVo.purchaseOrder.contractNo != null}">
                                    <div class="mui-input-row">
                                        <label>合同号</label>
                                        <label>${detailsVo.purchaseOrder.contractNo}</label>
                                    </div>
                                </c:if>
                                <c:if test="${detailsVo.purchaseOrder.applyDate != null}">
                                    <div class="mui-input-row">
                                        <label>申请时间</label>
                                        <input type="text" value="<fmt:formatDate value="${detailsVo.purchaseOrder.applyDate}" pattern="yyyy-MM-dd"/>" disabled="disabled">
                                    </div>
                                </c:if>
                                <c:if test="${admin.isAmountVisible == 0}">
                                    <div class="mui-input-row">
                                        <label>合同总金额</label>
                                        <input type="text" name="contractMoney" value="${detailsVo.purchaseOrder.contractMoney}" class="mui-input-clear" readonly disabled="disabled" placeholder="合同总金额由详情系统自动生成">
                                    </div>
                                    <div class="mui-input-row">
                                        <label>已请款金额</label>
                                        <input type="text" name="requestAmount" value="${detailsVo.purchaseOrder.requestAmount}" readonly disabled="disabled" placeholder="已请款金额由请款单回写">
                                    </div>
                                    <div class="mui-input-row">
                                        <label>已付款金额</label>
                                        <input type="text" name="paymentAmount" value="${detailsVo.purchaseOrder.paymentAmount}" readonly disabled="disabled" placeholder="已付款金额由付款单回写">
                                    </div>
                                </c:if>
                                <div class="mui-input-row mui-input-range">
                                    <label>付款比例(%)</label>
                                    <c:choose>
                                        <c:when test="${detailsVo.purchaseOrder.id == null}">
                                            <input type="number" name="paymentRatio" class="mui-input-clear" mui-verify="required|min=0|max=100" placeholder="请输入付款比例" value="100" onkeyup="checknum(this);">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="number" name="paymentRatio" class="mui-input-clear" mui-verify="required|min=0|max=100" placeholder="请输入付款比例" value="${detailsVo.purchaseOrder.paymentRatio}" onkeyup="checknum(this);">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div>
                                    <textarea name="summary" id="summary" rows="5" class="mui-input-clear">${detailsVo.purchaseOrder.summary}</textarea>
                                </div>
                                <div class="mui-button-row" style="padding-bottom: 20px;">
                                    <c:if test="${detailsVo.purchaseOrder.id == null || (detailsVo.purchaseOrder.id != null && detailsVo.purchaseOrder.isSaveSubmit == 0)}">
                                        <button type="button" class="mui-btn mui-btn-primary" id="ucamSave">保存</button>
                                    </c:if>
                                </div>
                            </form>
                        </div>
                    </li>

                    <!-- 审核状态 -->
                    <c:set value="${detailsVo.purchaseOrder.historyList}" var="historyList"/>
                    <%@ include file="/WEB-INF/page/mobile/common/reviewHistory.jsp"%>

                    <li class="mui-table-view-cell mui-collapse">
                        <a class="mui-navigate-right" href="#">合同订单明细</a>
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
                                                            ${item.content}
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
                                                        <c:if test="${admin.isAmountVisible == 0}">
                                                            <label>单价:${item.price}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                                                        </c:if>
                                                        <label>数量：${item.amount}</label>
                                                    </p>
                                                    <p>
                                                        <c:if test="${detailsVo.purchaseOrder.type == 1}">
                                                            <label>质保期（月）：${item.warrantyDate}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                                                        </c:if>
                                                        <c:if test="${detailsVo.purchaseOrder.type == 2}">
                                                        <label>日期：<fmt:formatDate value="${item.date}" pattern="yyyy-MM-dd"/></label>
                                                        </c:if>
                                                    </p>
                                                    <c:if test="${admin.isAmountVisible == 0}">
                                                        <p>
                                                            <label>金额：${item.totalPrice}</label>&nbsp;&nbsp;
                                                            <label>已結算数量：${item.settleAmout}</label>
                                                        </p>
                                                    </c:if>
                                                </div>
                                            </div>
                                            <div class="mui-card-footer">
                                                <c:if test="${detailsVo.purchaseOrder.id == null || (detailsVo.purchaseOrder.id != null && detailsVo.purchaseOrder.isSaveSubmit == 0)}">
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
                                        <label>无合同订单明细</label>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="mui-content-padded">
                <c:choose>
                    <c:when test="${detailsVo.purchaseOrder.isApproval == 0 && detailsVo.purchaseOrder.createUser == admin.id}">
                        <a href="#fromPurchaseOrderItem">
                            <button type="button" class="mui-btn mui-btn-primary mui-btn-block">增加明细</button>
                        </a>
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="purchaseOrderDetails">提交</button>
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="deletePurchaseOrder" value="${detailsVo.purchaseOrder.id}">删除</button>
                    </c:when>
                    <%--<c:when test="${detailsVo.purchaseOrder.status == 1 && empty detailsVo.purchaseOrder.costDepartUser && empty detailsVo.reviewUserId}">--%>
                        <%--<button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="submitReviewPurchaseOrder">选择审核人</button>--%>
                    <%--</c:when>--%>
                    <c:when test="${detailsVo.purchaseOrder.nextReviewUser == admin.id && detailsVo.purchaseOrder.isSaveSubmit == 1}">
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="reviewPurchaseOrder">审核</button>
                    </c:when>
                </c:choose>
                <%--<c:if test="${!empty admin.roleNames && fn:contains(admin.roleNames,'资料员')}">--%>
                <c:if test="${detailsVo.purchaseOrder.id != null}">
                    <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="purchaseOrderContractNo" value="${detailsVo.purchaseOrder.id}">填写合同号</button>
                </c:if>
            </div>
        </div>
    </div>
    <!-- 合同订单明细 end -->
</div>


<div id="fromPurchaseOrderItem" class="mui-page">
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <button type="button" class="mui-left mui-action-back mui-btn  mui-btn-link mui-btn-nav mui-pull-left">
            <span class="mui-icon mui-icon-left-nav"></span>返回
        </button>
        <h1 class="mui-center mui-title">增加合同订单明细</h1>
    </div>
    <div class="mui-page-content">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll"  style="height: 100%;">
                <form class="mui-input-group" id="addFromPurchaseOrderItem">
                    <%--<input type="hidden" id="purchaseNo" name="purchaseNo" value="${detailsVo.purchaseOrder.purchaseNo}">--%>
                    <input type="hidden" id="id" name="id" value="">
                    <div class="mui-input-row">
                        <label>材料/项目内容</label>
                        <input type="text" name="content" class="mui-input-clear" mui-verify="required|length=100" placeholder="请输入材料/项目内容">
                    </div>
                    <div class="mui-input-row">
                        <label>规格型号</label>
                        <input type="text" name="model" class="mui-input-clear" mui-verify="required|length=100" placeholder="请输入规格型号">
                    </div>
                    <div class="mui-input-row">
                        <label>单位</label>
                        <input type="text" name="unit" class="mui-input-clear" mui-verify="required|length=10" placeholder="请输入单位">
                    </div>
                    <c:if test="${admin.isAmountVisible == 0}">
                        <div class="mui-input-row">
                            <label>单价</label>
                            <input type="number" id="price" name="price" class="mui-input-clear" mui-verify="required|min=0|max=1000000" onkeyup="checknum(this);" placeholder="请输入单价">
                        </div>
                    </c:if>
                    <div class="mui-input-row">
                        <label>数量</label>
                        <input type="number" id="amount" name="amount" class="mui-input-clear" mui-verify="required|digits|min=0|max=1000000" placeholder="请输入数量">
                    </div>
                    <c:if test="${admin.isAmountVisible == 0}">
                        <div class="mui-input-row">
                            <label>金额</label>
                            <input type="number" id="totalPrice" name="totalPrice" class="mui-input-clear" mui-verify="required|min=0|max=1000000" readonly value="0">
                        </div>
                    </c:if>
                    <c:if test="${detailsVo.purchaseOrder.type == 1}">
                        <div class="mui-input-row">
                            <label>质保期（月）</label>
                            <input type="number" name="warrantyDate" class="mui-input-clear" mui-verify="required|digits|min=0|max=100" placeholder="请输入质保期（月）">
                        </div>
                    </c:if>
                    <c:if test="${detailsVo.purchaseOrder.type == 2}">
                        <div class="mui-input-row">
                            <label>日期</label>
                            <input id="dateText" type="text" name="date" class="mui-input-clear" mui-verify="required" data-options='{"type":"date","beginYear":2014}' placeholder="请选择日期">
                        </div>
                    </c:if>
                    <div>
                        <textarea name="remark" id="remark" rows="5" class="mui-input-clear" placeholder="备注"></textarea>
                    </div>
                    <div class="mui-button-row" style="padding-bottom: 20px;">
                        <button type="button" class="mui-btn mui-btn-primary" id="submitFromPurchaseOrderItem">保存</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/page/mobile/common/selectProject.jsp"%>

<script type="text/javascript" charset="utf-8">
    mui.init();
    //初始化单页view
    var viewApi = mui('#app').view({
        defaultPage: '#setting'
    });

    mui('.mui-scroll-wrapper').scroll();
    var orderType = '[{"text":"绿化苗木","value":"0"},{"text":"园建水电","value":"1"},{"text":"机械租赁","value":"2"},{"text":"工程分包","value":"3"}]';
    var ucamVoOrderType = '${detailsVo.purchaseOrder.type}';
    var isApproval = '${detailsVo.purchaseOrder.isApproval}';
    var isSaveSubmit = '${detailsVo.purchaseOrder.isSaveSubmit}';
    var orderId = '${detailsVo.purchaseOrder.id}';
    var adminId = '${detailsVo.purchaseOrder.admin.id}';
    var createId = '${admin.id}';
    /** 订单类型 **/
    function initOrderType(){
        var json = JSON.parse(orderType);
        var userPicker = new mui.PopPicker();
        userPicker.setData(json);
        var typeName = document.getElementById('typeName');
        var type = document.getElementById('type');
        var typeValue = type.value;
        if(typeValue){
            $.each(json,function (idx,obj) {
                if(obj.value == typeValue){
                    typeName.value = obj.text;
                }
            })
        }
        typeName.addEventListener('tap', function(event) {
            userPicker.show(function(items) {
                typeName.value = items[0].text;
                type.value = items[0].value;
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);
    }

    /** 提交项 **/
    var isSubmit = false;
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
            var purchaseNo = $('#purchaseNo').val();
            var itemId = $('#addFromPurchaseOrderItem').find('#id').val();
            var url = '${ctx}/mobile/purchase/addPurchaseOrderItem/'+ purchaseNo;
            if(itemId && itemId != ''){
                url = '${ctx}/mobile/purchase/editPurchaseOrderItem/'+ purchaseNo;
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
                            document.location.href='${ctx }/mobile/purchase/toDetails?id=${detailsVo.purchaseOrder.id}';
                        });
                    }
                }
            });
        }
    });

    /** 删除合同订单 **/
    mui(document.body).on('tap', '#deletePurchaseOrder', function(e) {
        var id = this.value;
        var btnArray = ['是', '否'];
        mui.confirm('确认删除此合同订单？', '删除合同订单', btnArray, function(e) {
            if (e.index == 0) {
                var url = '${ctx}/mobile/purchase/delPurchaseOrder?id='+ id
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
                                document.location.href='${ctx }/mobile/purchase/list';
                            });
                        }
                    }
                });
            }
        })
    });

    /** 选择审核人 **/
    mui(document.body).on('tap', '#purchaseOrderDetails', function(e) {
        <c:if test="${fn:length(detailsVo.details) == 0}">
            mui.alert("请先添加明细！");
            return false;
        </c:if>

        var adminsJson = '${reviewAdmins}'
        var json =JSON.parse(adminsJson)
        var userPicker = new mui.PopPicker({ layer: 2 });
        userPicker.setData(json);
        userPicker.show(function (selectItems) {
            var text = selectItems[1].text;
            mui.alert('确定提审核人为：' + text + "？" , function() {
                var roleId = selectItems[0].value;
                var userId = selectItems[1].value;
                var url = '${ctx}/mobile/purchase/submitReviewPurchaseOrder?id=${detailsVo.purchaseOrder.id}&userId=' + userId + '&roleId=' + roleId;
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
                                document.location.href='${ctx }/mobile/purchase/toDetails?id=${detailsVo.purchaseOrder.id}';
                            });
                        }
                    }
                });
            });

        });
    });

    /** 填写合同号 **/
    mui(document.body).on('tap', '#purchaseOrderContractNo', function(e) {
        var btnArray = ['取消', '确定'];
        var id = this.value;
        mui.prompt('请输入合同订单合同号', '请输入合同号', '合同订单合同号', btnArray, function(e1) {
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
                                    document.location.href='${ctx }/mobile/purchase/toDetails?id=${detailsVo.purchaseOrder.id}';
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
                var url = '${ctx}/mobile/purchase/deletePurchaseOrderItem/'+ itemId
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
                                document.location.href='${ctx }/mobile/purchase/toDetails?id=${detailsVo.purchaseOrder.id}';
                            });
                        }
                    }
                });
            }
        })
    });

    /** 保存主表 **/
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
            var url = '${ctx}/mobile/purchase/addPurchaseOrder'
            var purchaseId = $('#ucamForm').find('#id').val();
            if(purchaseId != null && purchaseId != ""){
                url = '${ctx}/mobile/purchase/editPurchaseOrder';
            }
            $.ajax({
                url: url,
                data: $('#ucamForm').serialize(),
                dataType: 'json',
                contentType : "application/x-www-form-urlencoded",
                type: 'post',
                timeout: 10000,
                success: function(result) {
                    if(result.code!=0){
                        mui.alert(result.msg);
                        isSubmit = false;
                    }else {
                        var btnArray = ['确认'];
                        mui.confirm('保存成功！', btnArray, function(e) {
                            document.location.href='${ctx }/mobile/purchase/toDetails?id=' + result.msg;
                        })

                    }
                }
            });
        }
    })
    /** 保存主表 **/


    //初始化数据
    mui.ready(function() {

        //订单类型
        initOrderType();

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
                    var url = '${ctx}/mobile/purchase/getPurchaseOrderItem/' + itemId;
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
                                $("#addFromPurchaseOrderItem").find("input[name='purchaseNo']").val(data.purchaseNo);
                                $("#addFromPurchaseOrderItem").find("input[name='content']").val(data.content);
                                $("#addFromPurchaseOrderItem").find("input[name='model']").val(data.model);
                                $("#addFromPurchaseOrderItem").find("input[name='unit']").val(data.unit);
                                $("#addFromPurchaseOrderItem").find("input[name='price']").val(data.price);
                                $("#addFromPurchaseOrderItem").find("input[name='amount']").val(data.amount);
                                $("#addFromPurchaseOrderItem").find("input[name='totalPrice']").val(data.totalPrice);
                                $("#addFromPurchaseOrderItem").find("input[name='date']").val(data.date);
                                $("#addFromPurchaseOrderItem").find("input[name='warrantyDate']").val(data.warrantyDate);
                                $("#remark").val(data.remark);
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

        if(document.getElementById('app-selectProject')){
            document.getElementById('app-selectProject').addEventListener('tap', function (event) {
                $project.projectList();
            }, false);
        }

        //计算金额
        document.getElementById("amount").addEventListener("change", totalPriceReckon, false);
        document.getElementById("price").addEventListener("change", totalPriceReckon, false);
        function totalPriceReckon(){
            var amount = document.getElementById("amount");
            var price = document.getElementById("price");
            if(price.value != "" && amount.value != ""){
                var applyPrice = price.value * amount.value;
                document.getElementById("totalPrice").value = applyPrice;
            }
        }
        console.log("isApproval:" + isApproval);
        //可编辑条件1：订单不存在；2：订单存在、用户等于创建用户、操作状态未未提交
        if(!orderId || (orderId && isSaveSubmit == 0)){
            $("#ucamForm").find("input[type='text']").attr("disabled",false);
        }else{
            $("#ucamForm").find("input[type='text']").attr("disabled",true);
        }
    });



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
            if (viewApi.canBack()) { //如果view可以后退，则执行view的后退
                document.getElementById('addFromPurchaseOrderItem').reset();
                viewApi.back();
            } else { //执行webview后退
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

<!-- 审核 -->
<c:set value="${ctx}/mobile/purchase/toDetails?id=${detailsVo.purchaseOrder.id}" var="reviewRefreshUrl"/>
<c:set value="${ctx}/mobile/purchase/reviewPurchaseOrder/${detailsVo.purchaseOrder.id}" var="reviewSaveUrl"/>
<%@ include file="/WEB-INF/page/mobile/common/review.jsp"%>
<!-- 审核 -->

</body>
</html>