<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>合同外请款单</title>
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
        <%--<button type="button" class="mui-left mui-action-back mui-btn  mui-btn-link mui-btn-nav mui-pull-left">
            <span class="mui-icon mui-icon-left-nav"></span>
        </button>--%>
        <h1 class="mui-center mui-title">合同外请款单详情</h1>
    </div>

    <!-- 采购单项 start -->
    <div id="refreshContainer" class="mui-content mui-scroll-wrapper" style="margin-top: 0px;width: 100%;">
        <div class="mui-scroll">
            <!-- 主界面具体展示内容 -->

            <div class="mui-content" style="margin-left: 5px; margin-right: 5px; font-size: 14px;">
                <ul id="ul_mui_table_view" class="mui-table-view">
                    <li class="mui-table-view-cell mui-collapse mui-active">
                        <a class="mui-navigate-right" href="#">
                            请款单详情:
                            <c:choose>
                                <c:when test="${detailsVo.ucamVo.id == null}">
                                    请先添加请款单
                                </c:when>
                                <c:otherwise>
                                    ${detailsVo.ucamVo.orderNo}
                                </c:otherwise>
                            </c:choose>
                        </a>
                        <div class="mui-collapse-content">
                            <form class="mui-input-group" id="ucamForm">
                                <input type="hidden" name="id" id="id" value="${detailsVo.ucamVo.id}">
                                <div class="mui-input-row">
                                    <label>请款单号</label>
                                    <input type="text" name="orderNo" id="orderNo" readonly disabled="disabled" value="${detailsVo.ucamVo.orderNo}">
                                </div>
                                <div class="mui-input-row">
                                    <label>请款人</label>
                                    <c:choose>
                                        <c:when test="${detailsVo.ucamVo.id == null}">
                                            <input type="text" id="selectApplyUserEdit" placeholder="请选择开单人" value="${admin.fullname}">
                                            <input type="hidden" id="applyUserEdit" name="applyUser" value="${admin.id}" mui-verify="required">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="text" id="selectApplyUserEdit" placeholder="请选择开单人" value="${detailsVo.ucamVo.admin.fullname}">
                                            <input type="hidden" id="applyUserEdit" name="applyUser" value="${detailsVo.ucamVo.admin.id}" mui-verify="required">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mui-input-row">
                                    <label>供应商</label>
                                    <c:choose>
                                        <c:when test="${detailsVo.ucamVo.id == null}">
                                            <input type="text" id="supplierName" readonly value="${admin.supplierName}">
                                            <input type="hidden" id="supplierId" name="supplierId" value="${admin.supplierId}" mui-verify="required">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="text" id="supplierName" readonly value="${detailsVo.ucamVo.supplier.name}">
                                            <input type="hidden" id="supplierId" name="supplierId" value="${detailsVo.ucamVo.supplier.id}" mui-verify="required">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mui-input-row">
                                    <label>所属项目</label>
                                    <%--<label style="width: 65%;padding-left: 0px;">${detailsVo.ucamVo.tpm.name}</label>--%>
                                    <a href="#selectProject" id="app-selectProject">
                                        <label id="selectProjectText" style="width: 65%;padding-left: 0px;">
                                            <c:choose>
                                                <c:when test="${detailsVo.ucamVo.id == null}">
                                                    请选择所属项目
                                                </c:when>
                                                <c:otherwise>
                                                    ${detailsVo.ucamVo.tpm.name}
                                                </c:otherwise>
                                            </c:choose>
                                        </label>
                                        <input type="hidden" id="selectProjectHidden" name="projectId" value="${detailsVo.ucamVo.tpm.id}" mui-verify="required">
                                    </a>
                                </div>
                                <div class="mui-input-row">
                                    <label>单据类型</label>
                                    <input type="text" id="orderTypeName" readonly class="mui-input-clear" placeholder="请选择单据类型" value="" >
                                    <input type="hidden" id="orderTypeId" name="orderType" value="${detailsVo.ucamVo.orderType}"  mui-verify="required">
                                </div>
                                <div class="mui-input-row">
                                    <label>指令单号</label>
                                    <input type="text" name="instructOrderNo" value="${detailsVo.ucamVo.instructOrderNo}" placeholder="请输入指令单号">
                                </div>
                                <div class="mui-input-row">
                                    <label>请款总金额</label>
                                    <c:choose>
                                        <c:when test="${detailsVo.ucamVo.applyPrice == null || detailsVo.ucamVo.applyPrice == ''}">
                                            <input type="text" name="applyPrice" readonly value="0.00"  mui-verify="required">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="text" name="applyPrice" readonly value="${detailsVo.ucamVo.applyPrice}"  mui-verify="required">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div>
                                    <textarea name="summary" id="summary" rows="5" class="mui-input-clear">${detailsVo.ucamVo.summary}</textarea>
                                </div>
                                <div class="mui-button-row" style="padding-bottom: 20px;">
                                    <c:if test="${detailsVo.ucamVo.status == 0}">
                                        <button type="button" class="mui-btn mui-btn-primary" id="ucamSave">保存</button>
                                    </c:if>
                                </div>
                            </form>

                        </div>
                    </li>

                    <!-- 审核状态 -->
                    <c:set value="${detailsVo.ucamVo.historyList}" var="historyList"/>
                    <%@ include file="/WEB-INF/page/mobile/common/reviewHistory.jsp"%>

                    <li class="mui-table-view-cell mui-collapse">
                        <a class="mui-navigate-right" href="#">合同外请款单明细</a>
                        <div class="mui-collapse-content" id="detailDiv">
                            <c:choose>
                                <c:when test="${fn:length(detailsVo.ucamDetail) > 0}">
                                    <c:forEach items="${detailsVo.ucamDetail}" var="item">
                                        <div class="mui-card">
                                            <div class="mui-card-header mui-card-media">
                                                <!-- 订单类型 用图标展示 -->
                                                <img src="${ctx }/images/icon/contract_apply_money.png">
                                                <div class="mui-media-body">
                                                    <label>材料/项目内容</label>
                                                    <p>${item.projectContent}</p>
                                                </div>
                                            </div>
                                            <div class="mui-card-content">
                                                <div class="mui-card-content-inner">
                                                    <p>
                                                        <label>工程量:${item.quantities}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <label>单位:${item.unit}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <label>单价：${item.price}</label>
                                                    </p>
                                                    <p>
                                                        <label>申报完成率:${item.applyCompletionRate}%</label>&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <label>申报金额：${item.applyPrice}</label>
                                                    </p>
                                                    <p>
                                                        <label>审核完成率：
                                                            <c:choose>
                                                                <c:when test="${item.approvalCompletionRate == null}">未审核</c:when>
                                                                <c:otherwise>${item.approvalCompletionRate}%</c:otherwise>
                                                            </c:choose>
                                                        </label>&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <label>审批金额：
                                                            <c:choose>
                                                                <c:when test="${item.approvalPrice == null}">未审核</c:when>
                                                                <c:otherwise>${item.approvalPrice}</c:otherwise>
                                                            </c:choose>
                                                        </label>
                                                    </p>
                                                    <p>
                                                        <c:if test="${detailsVo.ucamVo.orderType == 1}">
                                                            <label>质保期（月）：${item.applyPrice}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                                                        </c:if>
                                                        <c:if test="${detailsVo.ucamVo.orderType == 2}">
                                                            <label>日期：<fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/></label>&nbsp;&nbsp;&nbsp;&nbsp;
                                                        </c:if>
                                                            <%--<label>已支付金额：${item.applyPrice}</label>--%>
                                                    </p>
                                                </div>
                                            </div>
                                            <div class="mui-card-footer">
                                                    <%--<div class="mui-pull-left">
                                                        <label>总金额：${item.totalPrice}</label>&nbsp;&nbsp;
                                                        <label>已結算数量：${item.settleAmout}</label>
                                                    </div>--%>
                                                <c:if test="${detailsVo.ucamVo.status == 0 && detailsVo.ucamVo.createUser == admin.id}">
                                                    <div>
                                                        <a href="#fromUCAMItem" name="app-a" data-id="${item.id}">
                                                            <button type="button" class="mui-btn mui-btn-primary" value="${item.id}">修改</button>
                                                        </a>
                                                    </div>
                                                    <div>
                                                        <button type="button" class="mui-btn mui-btn-primary deleteItem" value="${item.id}">刪除</button>
                                                    </div>
                                                </c:if>
                                                <c:if test="${detailsVo.ucamVo.status != 0 && detailsVo.ucamVo.status != 4}">
                                                    <div>
                                                        <a href="#fromUCAMItem" name="app-a" data-id="${item.id}">
                                                            <button type="button" class="mui-btn mui-btn-primary" value="${item.id}">审核</button>
                                                        </a>
                                                    </div>
                                                </c:if>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <div class="mui-input-row">
                                        <label>无请款单单项</label>
                                    </div>
                                </c:otherwise>
                            </c:choose>

                        </div>

                    </li>

                </ul>
            </div>


            <div class="mui-content-padded">
                <c:choose>
                    <c:when test="${detailsVo.ucamVo.status == 0 && detailsVo.ucamVo.createUser == admin.id}">
                        <a href="#fromUCAMItem">
                            <button type="button" class="mui-btn mui-btn-primary mui-btn-block">增加请款单项</button>
                        </a>
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="UCAMDetails">提交</button>
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="deleteUCAMOrder" value="${detailsVo.ucamVo.id}">删除</button>
                    </c:when>
                    <%--<c:when test="${detailsVo.ucamVo.status == 1 && empty detailsVo.ucamVo.costDepartUser && empty detailsVo.reviewUserId}">
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="submitReviewUCAM">选择审核人</button>
                    </c:when>--%>
                    <c:when test="${detailsVo.reviewUserId == admin.id}">
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="reviewUCAM">审核</button>
                    </c:when>
                </c:choose>
                <c:if test="${detailsVo.ucamVo.id != null && detailsVo.ucamVo.status != 0}">
                    <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="UCAMInstructOrderNo" value="${detailsVo.ucamVo.id}">填写指令单号</button>
                </c:if>

            </div>

        </div>
    </div>
    <!-- 采购单项 end -->
</div>


<div id="fromUCAMItem" class="mui-page">
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <button type="button" class="mui-left mui-action-back mui-btn  mui-btn-link mui-btn-nav mui-pull-left">
            <span class="mui-icon mui-icon-left-nav"></span>返回
        </button>
        <h1 class="mui-center mui-title"><c:if test="${detailsVo.ucamVo.status != 0}">审批</c:if><c:if test="${detailsVo.ucamVo.status == 0}">增加</c:if>请款单项</h1>
    </div>
    <div class="mui-page-content">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll"  style="height: 100%;">
                <form class="mui-input-group" id="addFromUCAMItem">
                    <input type="hidden" id="orderNo" name="orderNo" value="${detailsVo.ucamVo.orderNo}">
                    <input type="hidden" id="id" name="id" value="">
                    <div class="mui-input-row">
                        <label>材料/项目内容</label>
                        <input type="text" id="projectContent" name="projectContent" class="mui-input-clear" mui-verify="required" <c:if test="${detailsVo.ucamVo.status != 0}">disabled="disabled"</c:if> placeholder="请输入材料/项目内容">
                    </div>
                    <div class="mui-input-row">
                        <label>工程量</label>
                        <input type="number" id="quantities" name="quantities" class="mui-input-clear" mui-verify="required" <c:if test="${detailsVo.ucamVo.status != 0}">disabled="disabled"</c:if> placeholder="请输入工程量">
                    </div>
                    <div class="mui-input-row">
                        <label>申报完成率</label>
                        <input type="number" min="0" max="100" value="" id="applyCompletionRate" name="applyCompletionRate" mui-verify="required" <c:if test="${detailsVo.ucamVo.status != 0}">disabled="disabled"</c:if> placeholder="请输入申报完成率">
                    </div>
                    <div class="mui-input-row">
                        <label>单位</label>
                        <input type="text" id="unit" name="unit" class="mui-input-clear" mui-verify="required" <c:if test="${detailsVo.ucamVo.status != 0}">disabled="disabled"</c:if> placeholder="请输入单位">
                    </div>
                    <div class="mui-input-row">
                        <label>单价</label>
                        <input type="number" id="price" name="price" class="mui-input-clear" mui-verify="required" <c:if test="${detailsVo.ucamVo.status != 0}">disabled="disabled"</c:if> placeholder="请输入单价">
                    </div>
                    <div class="mui-input-row">
                        <label>申报金额</label>
                        <input type="number" id="applyPrice" name="applyPrice" class="mui-input-clear" mui-verify="required" readonly value="0" placeholder="请输入申报金额">
                    </div>

                    <c:if test="${detailsVo.ucamVo.orderType == 1}">
                        <div class="mui-input-row">
                            <label>质保期（月）</label>
                            <input type="number" id="warrantyDate" name="warrantyDate" class="mui-input-clear" mui-verify="required" <c:if test="${detailsVo.ucamVo.status != 0}">disabled="disabled"</c:if> placeholder="请输入质保期（月）">
                        </div>
                    </c:if>
                    <c:if test="${detailsVo.ucamVo.orderType == 2}">
                        <div class="mui-input-row">
                            <label>日期</label>
                            <input type="text" id="date" name="date" class="mui-input-clear" mui-verify="required" readonly  <c:if test="${detailsVo.ucamVo.status != 0}">disabled="disabled"</c:if> data-options='{"type":"date","beginYear":2018,"endYear":2028}' placeholder="请选择日期">
                        </div>
                    </c:if>
                    <c:if test="${detailsVo.ucamVo.status != 0}">
                        <div class="mui-input-row">
                            <label>审核完成率</label>
                            <input type="number" min="0" max="100"  id="approvalCompletionRate" name="approvalCompletionRate" mui-verify="required" placeholder="请输入审核完成率">
                        </div>
                        <div class="mui-input-row">
                            <label>审批金额</label>
                            <input type="number" id="approvalPrice" name="approvalPrice"  mui-verify="required" readonly value="0" placeholder="请输入审批金额" >
                        </div>
                    </c:if>
                    <%--<div class="mui-input-row">
                        <label>已支付金额</label>
                        <input type="text" name="amount" class="mui-input-clear" mui-verify="required">
                    </div>--%>
                    <div>
                        <textarea name="remark" id="remark" rows="5" class="mui-input-clear"  <c:if test="${detailsVo.ucamVo.status != 0}">disabled="disabled"</c:if> placeholder="备注"></textarea>
                    </div>
                    <div class="mui-button-row" style="padding-bottom: 20px;">
                        <button type="button" class="mui-btn mui-btn-primary" id="submitFromUCAMItem">保存</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/page/mobile/common/selectProject.jsp"%>

<script type="text/javascript" charset="utf-8">
    //初始化单页view
    var viewApi = mui('#app').view({
        defaultPage: '#setting'
    });

    mui('.mui-scroll-wrapper').scroll();
    var orderTypeJosn = '[{"text":"绿化苗木","value":"0"},{"text":"园建水电","value":"1"},{"text":"机械租赁","value":"2"},{"text":"工程分包","value":"3"}]';
    var ucamVoOrderType = '${detailsVo.ucamVo.orderType}';
    var status = '${detailsVo.ucamVo.status}';

    mui.ready(function() {
        if(ucamVoOrderType != null){
            var ot = JSON.parse(orderTypeJosn);
            console.log(ucamVoOrderType);
            for(var i = 0; i < ot.length; i++){
                if(ot[i].value == ucamVoOrderType){
                    $("#orderTypeName").val(ot[i].text);
                }
            }
            if(ucamVoOrderType == 2){
                initDate();
            }
        }

        //if(status != 0) {
            var appA = document.getElementsByName('app-a');
            if(appA.length > 0){
                for(var i = 0; i < appA.length; i++){
                    appA[i].addEventListener('tap', function(event) {
                        var itemId = $(this).attr("data-id");
                        console.log(itemId);
                        var url = '${ctx}/mobile/UCAM/getUCAMItem/' + itemId;
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
                                    $("#addFromUCAMItem").find("#id").val(data.id);
                                    $("#orderNo").val(data.orderNo);
                                    $("#projectContent").val(data.projectContent);
                                    $("#quantities").val(data.quantities);
                                    $("#applyCompletionRate").val(data.applyCompletionRate);
                                    $("#unit").val(data.unit);
                                    $("#price").val(data.price);
                                    $("#applyPrice").val(data.applyPrice);
                                    $("#remark").val(data.remark);
                                    if(ucamVoOrderType == 1){
                                        $("#warrantyDate").val(data.warrantyDate);
                                    }
                                    if(ucamVoOrderType == 2){
                                        $("#date").val(data.date);
                                    }
                                    $("#approvalCompletionRate").val(data.approvalCompletionRate);
                                    $("#approvalPrice").val(data.approvalPrice);
                                }
                            }
                        });
                    },false);
                }
            }
        //}

        var adminsJson = '${admins}';
        console.log(adminsJson);
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



        document.getElementById('app-selectProject').addEventListener('tap', function(event) {
            $project.projectList();
        },false);
    });

    /*var applyCompletionRate = document.getElementById("applyCompletionRate");*/
   /* applyCompletionRate.addEventListener("change", function () {
        console.log(this.value);
        applyPriceReckon();
    }, false);*/
    if(status == 0) {
        document.getElementById("applyCompletionRate").addEventListener("change", applyPriceReckon, false);
        document.getElementById("price").addEventListener("change", applyPriceReckon, false);
        function applyPriceReckon(){
            var applyCompletionRate = document.getElementById("applyCompletionRate");
            var price = document.getElementById("price");
            console.log(applyCompletionRate + " " + price);
            if(applyCompletionRate.value != "" && price.value != ""){
                var applyPrice = applyCompletionRate.value * price.value;
                console.log(applyPrice);
                document.getElementById("applyPrice").value = applyPrice;
            }
        }
    }else{
        document.getElementById("approvalCompletionRate").addEventListener("change", approvalPriceReckon, false);
        function approvalPriceReckon(){
            var approvalCompletionRate = document.getElementById("approvalCompletionRate");
            var price = document.getElementById("price");
            console.log(approvalCompletionRate + " " + price);
            if(approvalCompletionRate.value != "" && price.value != ""){
                var applyPrice = approvalCompletionRate.value * price.value;
                console.log(applyPrice);
                document.getElementById("approvalPrice").value = applyPrice;
            }
        }
    }

    var orderTypeNamePicker = new mui.PopPicker();
    orderTypeNamePicker.setData(JSON.parse(orderTypeJosn));
    var orderTypeName = document.getElementById('orderTypeName');
    var orderTypeId = document.getElementById('orderTypeId');
    orderTypeName.addEventListener('tap', function(event) {
        orderTypeNamePicker.show(function(items) {
            orderTypeName.value = items[0].text;
            orderTypeId.value = items[0].value;
            //返回 false 可以阻止选择框的关闭
            //return false;
        });
    }, false);




    function initDate(){
        var btns_date =  mui('#date');
        btns_date.each(function(i, btn) {
            btn.addEventListener('tap', function() {
                var optionsJson = this.getAttribute('data-options') || '{}';
                var options = JSON.parse(optionsJson);
                var picker = new mui.DtPicker(options);
                picker.show(function(rs) {
                    date.value = rs.text;
                    picker.dispose();
                });
            }, false);
        });
    }



    /** 保存主表 **/
    mui(document.body).on('tap', '#ucamSave', function(e) {
        var check = true;
        mui("#ucamForm input").each(function() {
            //若当前input为空，则alert提醒
            var verify = $(this).attr("mui-verify");
            if(verify == 'required'){
                if(!this.value || this.value.trim() == "") {
                    var label = this.previousElementSibling;
                    mui.alert(label.innerText + "不允许为空");
                    check = false;
                    return false;
                }
            }
        });
        if(check){
            var url = '${ctx}/mobile/UCAM/addUCAMOrder';
            if($('#ucamForm').find('#id').val() != null){
                url = '${ctx}/mobile/UCAM/editUCAMOrder';
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
                    }else {
                        mui.alert("保存成功！");
                        document.location.href = '${ctx }/mobile/UCAM/toDetails/?id=' + result.msg;
                    }
                }
            });
        }
    });


    /** 提交项 **/
    mui(document.body).on('tap', '#submitFromUCAMItem', function(e) {
        var check = true;
        mui("#addFromUCAMItem input").each(function() {
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
            var orderNo = $('#orderNo').val();
            var itemId = $('#addFromUCAMItem').find('#id').val();
            var url = '${ctx}/mobile/UCAM/addUCAMItem/'+ orderNo;
            if(itemId && itemId != '') {
                url = '${ctx}/mobile/UCAM/editUCAMItem';
            }
            $.ajax({
                url: url,
                data: $('#addFromUCAMItem').serialize(),
                dataType: 'json',
                contentType : "application/x-www-form-urlencoded",
                type: 'post',
                timeout: 10000,
                success: function(result) {
                    if(result.code!=0){
                        mui.alert(result.msg);
                    }else {
                        mui.alert('保存成功！', function() {
                            document.location.href='${ctx }/mobile/UCAM/toDetails/${detailsVo.ucamVo.id}';
                        });
                    }
                }
            });
        }else{
            mui.toast('检验不通过，请重新填写！',{ duration:'long', type:'div' })
        }
    });

    /** 删除项 **/
    mui(document.body).on('tap', '.deleteItem', function(e) {
        var itemId = this.value;
        var btnArray = ['是', '否'];
        mui.confirm('确认删除此项？', '删除项', btnArray, function(e) {
            if (e.index == 0) {
                var url = '${ctx}/mobile/UCAM/deleteUCAMItem/'+ itemId
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
                                document.location.href='${ctx }/mobile/UCAM/toDetails/${detailsVo.ucamVo.id}';
                            });
                        }
                    }
                });
            }
        })
    });

    /** 编辑项 **/
    mui(document.body).on('tap', '.editItem', function(e) {
        var itemId = this.value;
        var btnArray = ['是', '否'];
        mui.confirm('确认删除此项？', '删除项', btnArray, function(e) {
            if (e.index == 0) {
                var url = '${ctx}/mobile/UCAM/deleteUCAMItem/'+ itemId
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
                                document.location.href='${ctx }/mobile/UCAM/toDetails/${detailsVo.ucamVo.id}';
                            });
                        }
                    }
                });
            }
        })
    });

    /** 设置指令单号 **/
    mui(document.body).on('tap', '#UCAMInstructOrderNo', function(e) {
        var btnArray = ['取消', '确定'];
        var id = this.value;
        mui.prompt('', '请输入指令单号', '合同外请款单指令单号', btnArray, function(e1) {
            if (e1.index == 1) {
                var instructOrderNo = e1.value;
                if(instructOrderNo == '' || instructOrderNo.trim() == ''){
                    mui.alert('请填写指令单号！');
                    return false
                }else {
                    var url = '${ctx}/mobile/UCAM/UCAMInstructOrderNo/'+ id + '?instructOrderNo=' + instructOrderNo;
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
                                mui.alert('保存成功！', function() {
                                    document.location.href='${ctx }/mobile/UCAM/toDetails/${detailsVo.ucamVo.id}';
                                });
                            }
                        }
                    });
                }
            }
        })
    });

    /** 删除合同外请款单 **/
    mui(document.body).on('tap', '#deleteUCAMOrder', function(e) {
        var id = this.value;
        var btnArray = ['是', '否'];
        mui.confirm('确认删除此合同外请款单？', '删除合同外请款单', btnArray, function(e) {
            if (e.index == 0) {
                var url = '${ctx}/mobile/UCAM/delUCAMOrder?id='+ id
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
                                document.location.href='${ctx }/mobile/UCAM/list';
                            });
                        }
                    }
                });
            }
        })
    });


    /** 选择审核人 **/
    mui(document.body).on('tap', '#UCAMDetails', function(e) {
        var detailCard = $("#detailDiv").find("div.mui-card");
        console.log(detailCard.length);
        if(detailCard == null || detailCard.length <= 0){
            mui.alert("请先添加明细");
            return false;
        }
        var adminsJson = '${detailsVo.departs}';
        console.log(adminsJson);
        var json =JSON.parse(adminsJson)
        var userPickerReview = new mui.PopPicker();
        userPickerReview.setData(json);
        userPickerReview.show(function (selectItems) {
            var text = selectItems[0].text;
            mui.alert('确定提审核人为：' + text + "？" , function() {
                var userId = selectItems[0].value;
                var url = '${ctx}/mobile/UCAM/submitReviewUCAMOrder?id=${detailsVo.ucamVo.id}&userId=' + userId;
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
                                document.location.href='${ctx }/mobile/UCAM/toDetails/${detailsVo.ucamVo.id}';
                            });
                        }
                    }
                });
            });

        });
    });


    var view = viewApi.view;
    (function($) {
        //处理view的后退与webview后退
        var oldBack = $.back;
        $.back = function() {
            if (viewApi.canBack()) { //如果view可以后退，则执行view的
                document.getElementById('addFromUCAMItem').reset();
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



    /*if(ucamVoOrderType != null && ucamVoOrderType != 0){
        $("#ul_mui_table_view").find("li").eq(2).addClass("mui-active");
    }else{
        $("#ul_mui_table_view").find("li").eq(0).addClass("mui-active");
    }*/
</script>
<!-- 审核 -->
<c:set value="${ctx }/mobile/UCAM/toDetails/${detailsVo.ucamVo.id}" var="reviewRefreshUrl"/>
<c:set value="${ctx}/mobile/UCAM/reviewUCAMOrder/${detailsVo.ucamVo.id}" var="reviewSaveUrl"/>
<c:set value="${detailsVo.ucamVo.status}" var="reviewStatus"/>
<%@ include file="/WEB-INF/page/mobile/common/review.jsp"%>
<!-- 审核 -->

</body>
</html>