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
        <h1 class="mui-center mui-title">付款订单详情</h1>
    </div>

    <!-- 采购单项 start -->
    <div id="refreshContainer" class="mui-content mui-scroll-wrapper" style="margin-top: 0px;width: 100%;">
        <div class="mui-scroll">
            <div class="mui-card">
                <!-- 主界面具体展示内容 -->
                <div class="mui-input-row">
                    <label>订单号</label>
                    <label style="width: 50%;padding-left: 0px;">${order.orderNo}</label>
                </div>
                <div class="mui-input-row">
                    <label>请款类型</label>
                    <label style="width: 50%;padding-left: 0px;">${order.applyTypeName}</label>
                </div>
                <c:if test="${!empty order.purchaseNo}">
                    <div class="mui-input-row">
                        <label>请款性质</label>
                        <label style="width: 50%;padding-left: 0px;">${order.applyNatureName}</label>
                    </div>
                </c:if>
                <div class="mui-input-row">
                    <label>开单人</label>
                    <label style="width: 50%;padding-left: 0px;">${order.admin.fullname}</label>
                </div>
                <div class="mui-input-row">
                    <label>开单日期</label>
                    <label style="width: 50%;padding-left: 0px;"><fmt:formatDate value="${order.createTime}" pattern="yyyy-MM-dd"/></label>
                </div>
                <div class="mui-input-row">
                    <label>供应商</label>
                    <label style="width: 50%;padding-left: 0px;">${order.supplier.name}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>申请人</label>
                    <label style="width: 50%;padding-left: 0px;">${order.applyAdmin.fullname}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>请款人电话</label>
                    <label style="width: 50%;padding-left: 0px;">${order.applyUserPhone}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>所属项目</label>
                    <label style="width: 50%;padding-left: 0px;">${order.projectManger.name}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>所属合同</label>
                    <label style="width: 50%;padding-left: 0px;">${order.contractId}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>申请金额</label>
                    <label style="width: 50%;padding-left: 0px;">${order.applyPrice}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>审定金额</label>
                    <label style="width: 50%;padding-left: 0px;">${order.approvalPrice}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>扣质保金</label>
                    <label style="width: 50%;padding-left: 0px;">${order.guaranteePrice}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>扣预付款</label>
                    <label style="width: 50%;padding-left: 0px;">${order.advancePrice}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>其它扣款</label>
                    <label style="width: 50%;padding-left: 0px;">${order.otherPrice}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>实付金额</label>
                    <label style="width: 50%;padding-left: 0px;">${order.actualPrice}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>付款方式</label>
                    <label style="width: 50%;padding-left: 0px;">${order.paymentTypeName}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>商票期限</label>
                    <label style="width: 50%;padding-left: 0px;">${order.spqxTerm}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>保理期限</label>
                    <label style="width: 50%;padding-left: 0px;">${order.blqxTerm}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>付款凭证号</label>
                    <label style="width: 50%;padding-left: 0px;">${order.paymentVoucherNo}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>垫付比</label>
                    <label style="width: 50%;padding-left: 0px;">${order.advanceRate}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>成本率</label>
                    <label style="width: 50%;padding-left: 0px;">${order.costRate}%</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>收支比</label>
                    <label style="width: 50%;padding-left: 0px;">${order.financialRate}%</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>税率</label>
                    <label style="width: 50%;padding-left: 0px;">${order.taxRate}%</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>合同量</label>
                    <label style="width: 50%;padding-left: 0px;">${order.contractVolume}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>完成量(供货量)</label>
                    <label style="width: 50%;padding-left: 0px;">${order.finishMeasure}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>已付金额</label>
                    <label style="width: 50%;padding-left: 0px;">${order.amountPaid}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>已付比例</label>
                    <label style="width: 50%;padding-left: 0px;">${order.paidProportion}%</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>支付比例</label>
                    <label style="width: 50%;padding-left: 0px;">${order.paymentProportion}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>发票类型</label>
                    <label style="width: 50%;padding-left: 0px;">${order.invoiceType}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>专票税率</label>
                    <label style="width: 50%;padding-left: 0px;">${order.specialTaxRate}%</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>质量验收</label>
                    <label style="width: 50%;padding-left: 0px;">${order.qualityGradeName}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>质量评定人</label>
                    <label style="width: 50%;padding-left: 0px;">${order.qualityAssessor}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>单据状态</label>
                    <label style="width: 50%;padding-left: 0px;">${order.statusName}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>摘要</label>
                    <label style="width: 50%;padding-left: 0px;">${order.summary}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>总经理审批状态</label>
                    <label style="width: 50%;padding-left: 0px;">${order.managerDepartApprovalName}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>总经理审批人</label>
                    <label style="width: 50%;padding-left: 0px;">${order.managerAdmin.fullname}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>总经理审批时间</label>
                    <label style="width: 50%;padding-left: 0px;"><fmt:formatDate value="${order.managerDepartDate}" pattern="yyyy-MM-dd"/></label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>总经理审批意见</label>
                    <label style="width: 50%;padding-left: 0px;">${order.managerDepartOpinion}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>财务付款状态</label>
                    <label style="width: 50%;padding-left: 0px;">${order.financePaymentApprovalName}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>财务付款人</label>
                    <label style="width: 50%;padding-left: 0px;">${order.financeAdmin.fullname}</label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>财务付款时间</label>
                    <label style="width: 50%;padding-left: 0px;"><fmt:formatDate value="${order.financePaymentDate}" pattern="yyyy-MM-dd"/></label>
                </div>
                <div class="mui-input-row mui-input-range">
                    <label>财务付款意见</label>
                    <label style="width: 50%;padding-left: 0px;">${order.financePaymentOpinion}</label>
                </div>
                <c:if test="${order.status != 2}">
                    <div class="mui-content-padded">
                        <c:if test="${order.financePayment != 1}">
                            <a href="#fromPurchaseOrderItem" name="app-a" data-id="${order.id}">
                                <button type="button" class="mui-btn mui-btn-primary mui-btn-block" value="${detailsVo.id}">修改</button>
                            </a>
                        </c:if>
                        <c:if test="${!empty order.reviewUserId}">
                            <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="reviewPurchaseOrder">审核</button>
                        </c:if>
                        <c:if test="${!empty order.financeUserId}">
                            <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="reviewPurchaseOrder">提交</button>
                        </c:if>
                    </div>
                </c:if>
        </div>
    </div>
    <!-- 采购单项 end -->
</div>
</div>


<div id="fromPurchaseOrderItem" class="mui-page">
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <button type="button" class="mui-left mui-action-back mui-btn  mui-btn-link mui-btn-nav mui-pull-left">
            <span class="mui-icon mui-icon-left-nav"></span>返回
        </button>
        <h1 class="mui-center mui-title">编辑付款单</h1>
    </div>
    <div class="mui-page-content">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll">
                <form class="mui-input-group" id="editPaymentOrder">
                    <input type="hidden" id="id" name="id" value="${order.id}">
                    <div class="mui-input-row">
                        <label>请款类型</label>
                        <input type="text" id="applyTypeName" class="mui-input-clear" placeholder="请选择请款类型" mui-verify="required">
                        <input type="hidden" id="applyType" name="applyType" value="${order.applyType}">
                    </div>
                    <div class="mui-input-row">
                        <label>请款性质</label>
                        <input type="text" id="applyNatureName" class="mui-input-clear" placeholder="请选择请款性质" mui-verify="required">
                        <input type="hidden" id="applyNature" name="applyNature" value="${order.applyNature}">
                    </div>
                    <div class="mui-input-row">
                        <label>扣质保金</label>
                        <input type="number" id="guaranteePrice" name="guaranteePrice" value="${order.guaranteePrice}" placeholder="请输入扣质保金">
                    </div>
                    <div class="mui-input-row">
                        <label>扣预付款</label>
                        <input type="number" id="advancePrice" name="advancePrice" value="${order.advancePrice}" placeholder="请输入扣预付款">
                    </div>
                    <div class="mui-input-row">
                        <label>其它扣款</label>
                        <input type="number" id="otherPrice" name="otherPrice" value="${order.otherPrice}" placeholder="请输入其它扣款">
                    </div>
                    <div class="mui-input-row">
                        <label>付款方式</label>
                        <input type="text" id="paymentTypeName" class="mui-input-clear" placeholder="请选择付款方式" mui-verify="required">
                        <input type="hidden" id="paymentType" name="paymentType" value="${order.applyNature}">
                    </div>
                    <div class="mui-input-row">
                        <label>商票期限(月)</label>
                        <input type="number" id="spqxTerm" name="spqxTerm" value="${order.spqxTerm}" placeholder="请输入商票期限(月)">
                    </div>
                    <div class="mui-input-row">
                        <label>保理期限(月)</label>
                        <input type="number" id="blqxTerm" name="blqxTerm" value="${order.blqxTerm}" placeholder="请输入保理期限(月)">
                    </div>
                    <div class="mui-input-row">
                        <label>付款凭证号</label>
                        <input type="number" id="paymentVoucherNo" name="paymentVoucherNo" value="${order.paymentVoucherNo}" placeholder="请输入付款凭证号">
                    </div>
                    <div class="mui-input-row">
                        <label>垫付比</label>
                        <input type="number" id="advanceRate" name="advanceRate" value="${order.advanceRate}" placeholder="请输入垫付比">
                    </div>
                    <div class="mui-input-row">
                        <label>成本率</label>
                        <input type="number" id="costRate" name="costRate" value="${order.costRate}" placeholder="请输入成本率">
                    </div>
                    <div class="mui-input-row">
                        <label>收支比</label>
                        <input type="number" id="financialRate" name="financialRate" value="${order.financialRate}" placeholder="请输入收支比">
                    </div>
                    <div class="mui-input-row">
                        <label>税率</label>
                        <input type="number" id="taxRate" name="taxRate" value="${order.taxRate}" placeholder="请输入税率">
                    </div>
                    <div class="mui-input-row">
                        <label>合同量</label>
                        <input type="number" id="contractVolume" name="contractVolume" value="${order.contractVolume}" placeholder="请输入合同量">
                    </div>
                    <div class="mui-input-row">
                        <label>完成量(供货量)</label>
                        <input type="number" id="finishMeasure" name="finishMeasure" value="${order.finishMeasure}" placeholder="请输入完成量(供货量)">
                    </div>
                    <div class="mui-input-row">
                        <label>已付金额</label>
                        <input type="number" id="amountPaid" name="amountPaid" value="${order.amountPaid}" placeholder="请输入已付金额">
                    </div>
                    <div class="mui-input-row">
                        <label>发票类型</label>
                        <input type="text" id="invoiceTypeName" class="mui-input-clear" placeholder="请选择发票类型" mui-verify="required" >
                        <input type="hidden" id="invoiceType" name="invoiceType" value="${order.invoiceType}">
                    </div>
                    <div class="mui-input-row">
                        <label>专票税率</label>
                        <input type="number" id="specialTaxRate" name="specialTaxRate" value="${order.specialTaxRate}" placeholder="请输入专票税率">
                    </div>
                    <div class="mui-input-row">
                        <label>质量验收</label>
                        <input type="text" id="qualityGradeName" class="mui-input-clear" placeholder="请选择质量验收" mui-verify="required" >
                        <input type="hidden" id="qualityGrade" name="qualityGrade" value="${order.invoiceType}">
                    </div>
                    <div class="mui-input-row">
                        <label>质量评定人</label>
                        <input type="number" id="qualityAssessor" name="qualityAssessor" value="${order.qualityAssessor}" placeholder="请输入质量评定人">
                    </div>
                    <div>
                        <textarea name="summary" id="summary" rows="5" class="mui-input-clear" placeholder="摘要">${order.summary}</textarea>
                    </div>
                    <div class="mui-button-row" style="padding-bottom: 20px;">
                        <button type="button" class="mui-btn mui-btn-primary" id="submitFromPurchaseOrderItem">保存</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div id="div"></div>
<div id="popover" class="mui-popover" style="height: 270px;">
    <div class="mui-popover-arrow"></div>
    <div class="mui-scroll-wrapper">
        <div class="mui-scroll"  style="height: 100%;">
            <form class="mui-input-group" id="reviewPurchaseOrderForm">
                <div class="mui-input-row">
                    <label style="width: 120px;">审核结果</label>
                    <input type="text" id="selectAuditResults" placeholder="请选择审核结果" style="float: left;width: 150px;">
                    <input type="hidden" id="auditResults" name="auditResults">
                </div>
                <c:if test="${order.status == 0}">
                    <div class="mui-input-row">
                        <label style="width: 120px;">财务付款人</label>
                        <input type="text" id="selectApplyUser" placeholder="请选择付款的财务人员" style="float: left;width: 150px;">
                        <input type="hidden" id="applyUser" name="applyUser">
                    </div>
                </c:if>
                <div class="mui-input-row" style="height: auto">
                    <textarea name="auditOpinion" id="auditOpinion" rows="5" class="mui-input-clear" placeholder="审核意见"></textarea>
                </div>
                <div class="mui-button-row" style="padding-bottom: 20px;">
                    <button type="button" class="mui-btn mui-btn-primary" id="reviewPurchaseOrderButton">审核</button>
                </div>
            </form>
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
        mui("#editPaymentOrder input").each(function() {
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
            var url = '${ctx}/mobile/paymentOrder/editPaymentOrder'
            $.ajax({
                url: url,
                data: $('#editPaymentOrder').serialize(),
                dataType: 'json',
                contentType : "application/x-www-form-urlencoded",
                type: 'post',
                timeout: 10000,
                success: function(result) {
                    if(result.code!=0){
                        mui.alert(result.msg);
                    }else {
                        mui.alert('编辑成功！', function() {
                            document.location.href='${ctx }/mobile/paymentOrder/toDetails/${order.id}';
                        });
                    }
                }
            });
        }else{
            mui.toast('检验不通过，请重新填写！',{ duration:'long', type:'div' })
        }
    });

    /** 审核 **/
    mui(document.body).on('tap', '#reviewPurchaseOrder', function(e) {
        mui("#popover").popover('toggle', document.getElementById("div"));
    });

    mui(document.body).on('tap', '#selectApplyUser', function(e) {
        var adminsJson = '${order.departs}'
        var json =JSON.parse(adminsJson)
        var userPicker = new mui.PopPicker();
        userPicker.setData(json);
        var selectApplyUser = document.getElementById('selectApplyUser');
        var applyUser = document.getElementById('applyUser');
        userPicker.show(function (items) {
            selectApplyUser.value = items[0].text;
            applyUser.value = items[0].value;
        });
    });

    mui(document.body).on('tap', '#selectAuditResults', function(e) {
        var adminsJson = '[{"text":"审核不通过","value":"0"},{"text":"审核通过","value":"1"}]';
        var json =JSON.parse(adminsJson)
        var userPicker = new mui.PopPicker();
        userPicker.setData(json);
        var selectAuditResults = document.getElementById('selectAuditResults');
        var auditResults = document.getElementById('auditResults');
        userPicker.show(function (items) {
            selectAuditResults.value = items[0].text;
            auditResults.value = items[0].value;
        });
    });

    mui(document.body).on('tap', '#reviewPurchaseOrderButton', function(e) {

        var auditResults = document.getElementById('auditResults');
        if(!auditResults.value || auditResults.value.trim() == "") {
            mui.alert("审核结果不允许为空");
            return false;
        }
        auditResults = auditResults.value;

        var applyUser = document.getElementById('applyUser');
        if(applyUser == null){
            applyUser = '0'
        }else {
            if(!applyUser.value || applyUser.value.trim() == "") {
                mui.alert("上级审核人不允许为空");
                return false;
            }
            applyUser = applyUser.value;
        }

        var auditOpinion = document.getElementById('auditOpinion');
        if(!auditOpinion.value || auditOpinion.value.trim() == "") {
            mui.alert("审核意见不允许为空");
            return false;
        }
        auditOpinion = auditOpinion.value;

        mui.alert('确定提交审核？' , function() {
            var url = '${ctx}/mobile/paymentOrder/reviewOrder/${order.id}';
            $.ajax({
                url: url,
                data:{'auditResults':auditResults,'applyUser':applyUser,'auditOpinion': auditOpinion},
                dataType: 'json',
                contentType : "application/x-www-form-urlencoded",
                type: 'post',
                timeout: 10000,
                success: function(result) {
                    if(result.code!=0){
                        mui.alert(result.msg);
                    }else {
                        mui.alert('审核成功！', function() {
                            document.location.href='${ctx }/mobile/purchase/toDetails/${order.id}';
                        });
                    }
                }
            });
        });
    });


    //初始化数据
    mui.ready(function() {

        //编辑初始化
        var userPicker = new mui.PopPicker();
        var applyTypeJson = '[{"text":"合同内请款","value":"0"},{"text":"合同外请款","value":"1"}]';
        var json =JSON.parse(applyTypeJson)
        userPicker.setData(json);
        var applyTypeName = document.getElementById('applyTypeName');
        var applyType = document.getElementById('applyType');
        var applyTypeValue = applyType.value;
        if(applyTypeValue){
            $.each(json,function (idx,obj) {
                if(obj.value == applyTypeValue){
                    applyTypeName.value = obj.text;
                }
            })
        }
        applyTypeName.addEventListener('tap', function(e) {
            userPicker.show(function (items) {
                applyTypeName.value = items[0].text;
                applyType.value = items[0].value;
            })
        });


        var applyNatureJson = '[{"text":"材料采购","value":"0"},{"text":"工程分包","value":"1"}]';
        var json1 =JSON.parse(applyNatureJson)
        var applyNatureName = document.getElementById('applyNatureName');
        var applyNature = document.getElementById('applyNature');
        var applyNatureValue = applyNature.value;
        if(applyNatureValue){
            $.each(json1,function (idx,obj) {
                if(obj.value == applyNatureValue){
                    applyNatureName.value = obj.text;
                }
            })
        }
        applyNatureName.addEventListener('tap',  function(e) {
            userPicker.setData(json1);
            userPicker.show(function (items) {
                applyNatureName.value = items[0].text;
                applyNature.value = items[0].value;
            });
        });

        var paymentTypeJson = '[{"text":"汇款","value":"0"},{"text":"支票","value":"1"},{"text":"现金","value":"2"},{"text":"商票","value":"3"},{"text":"保理","value":"4"}]';
        var json2 =JSON.parse(paymentTypeJson)
        var paymentTypeName = document.getElementById('paymentTypeName');
        var paymentType = document.getElementById('paymentType');
        var paymentTypeValue = paymentType.value;
        if(paymentTypeValue){
            $.each(json2,function (idx,obj) {
                if(obj.value == paymentTypeValue){
                    paymentTypeName.value = obj.text;
                }
            })
        }
        paymentTypeName.addEventListener('tap',  function(e) {
            userPicker.setData(json2);
            userPicker.show(function (items) {
                paymentTypeName.value = items[0].text;
                paymentType.value = items[0].value;
            });
        });


        var invoiceTypeJson = '[{"text":"普票","value":"0"},{"text":"专票","value":"1"} ]';
        var json3 =JSON.parse(invoiceTypeJson)
        var invoiceTypeName = document.getElementById('invoiceTypeName');
        var invoiceType = document.getElementById('invoiceType');
        var invoiceTypeValue = invoiceType.value;
        if(invoiceTypeValue){
            $.each(json3,function (idx,obj) {
                if(obj.value == invoiceTypeValue){
                    invoiceTypeName.value = obj.text;
                }
            })
        }
        invoiceTypeName.addEventListener('tap',  function(e) {
            userPicker.setData(json3);
            userPicker.show(function (items) {
                invoiceTypeName.value = items[0].text;
                invoiceType.value = items[0].value;
            });
        });

        var qualityGradeJson = '[{"text":"优","value":"0"},{"text":"良","value":"1"},{"text":"中","value":"2"},{"text":"差","value":"3"}]';
        var json4 =JSON.parse(qualityGradeJson)
        var qualityGradeName = document.getElementById('qualityGradeName');
        var qualityGrade = document.getElementById('qualityGrade');
        var qualityGradeValue = qualityGrade.value;
        if(qualityGradeValue){
            $.each(json4,function (idx,obj) {
                if(obj.value == qualityGradeValue){
                    qualityGradeName.value = obj.text;
                }
            })
        }
        qualityGradeName.addEventListener('tap', function(e) {
            userPicker.setData(json4);
            userPicker.show(function (items) {
                qualityGradeName.value = items[0].text;
                qualityGrade.value = items[0].value;
            });
        });
    });

</script>
</body>
</html>