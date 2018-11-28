<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>工程验收单详情</title>
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
    <script src="${ctx }/mui/js/mui.min.js"></script>
    <script src="${ctx }/js/jquery-1.11.1.js"></script>
    <script src="${ctx }/mui/js/mui.picker.min.js"></script>
    <script src="${ctx }/mui/js/mui.view.js"></script>
    <script type="text/javascript" src="${ctx }/js/handlebars.min.js"></script>
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
        <h1 class="mui-center mui-title">工程验收单详情</h1>
    </div>

    <!-- 采购单项 start -->
    <div id="refreshContainer" class="mui-content mui-scroll-wrapper" style="margin-top: 0px;width: 100%;">
        <div class="mui-scroll">
            <!-- 主界面具体展示内容 -->

            <div class="mui-content" style="margin-left: 5px; margin-right: 5px; font-size: 14px;">
                <ul id="ul_mui_table_view" class="mui-table-view">
                    <li class="mui-table-view-cell mui-collapse">
                        <a class="mui-navigate-right" href="#">
                            工程验收单详情:
                            <c:choose>
                                <c:when test="${detailsVo.paoVo.id == null}">
                                    请先添加工程验收单
                                </c:when>
                                <c:otherwise>
                                    ${detailsVo.paoVo.orderNo}
                                </c:otherwise>
                            </c:choose>

                        </a>
                        <div class="mui-collapse-content">
                            <form class="mui-input-group" id="programmeAcceptanceForm">
                                <input type="hidden" name="id" id="id" value="${detailsVo.paoVo.id}">
                                <div class="mui-input-row">
                                    <label>工程验收单号</label>
                                    <%--<label style="width: 65%;padding-left: 0px;">${detailsVo.paoVo.orderNo}</label>--%>
                                    <input type="text" name="orderNo" id="orderNo" readonly disabled="disabled" value="${detailsVo.paoVo.orderNo}" placeholder="工程验收单号由系统自动生成">
                                </div>
                                <div class="mui-input-row">
                                    <label>申请人</label>
                                    <%--<label style="width: 65%;padding-left: 0px;">${detailsVo.paoVo.admin.fullname}</label>--%>
                                    <c:choose>
                                        <c:when test="${detailsVo.paoVo.id == null}">
                                            <input type="text" id="selectApplyUserEdit" placeholder="请选择申请人" value="${admin.fullname}">
                                            <input type="hidden" id="applyUserEdit" name="applyUser" value="${admin.id}" mui-verify="required">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="text" id="selectApplyUserEdit" placeholder="请选择申请人" value="${detailsVo.paoVo.admin.fullname}" <c:if test="${detailsVo.paoVo.status != 0}">disabled="disabled"</c:if> >
                                            <input type="hidden" id="applyUserEdit" name="applyUser" value="${detailsVo.paoVo.admin.id}" mui-verify="required">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mui-input-row">
                                    <label>供应商</label>
                                    <%--<label style="width: 65%;padding-left: 0px;">${detailsVo.paoVo.supplier.name}</label>--%>
                                    <c:choose>
                                        <c:when test="${detailsVo.paoVo.id == null}">
                                            <c:choose>
                                                <c:when test="${admin.supplierId == null}">
                                                    <input type="text" id="supplierName" readonly value="" placeholder="请选择请款人">
                                                    <input type="hidden" id="supplierId" name="supplierId" value="" mui-verify="required">
                                                </c:when>
                                                <c:otherwise>
                                                    <input type="text" id="supplierName" readonly value="${admin.supplierName}" placeholder="请选择请款人">
                                                    <input type="hidden" id="supplierId" name="supplierId" value="${admin.supplierId}" mui-verify="required">
                                                </c:otherwise>
                                            </c:choose>
                                        </c:when>
                                        <c:otherwise>
                                            <input type="text" id="supplierName" readonly value="${detailsVo.paoVo.supplier.name}" <c:if test="${detailsVo.paoVo.status != 0}">disabled="disabled"</c:if>>
                                            <input type="hidden" id="supplierId" name="supplierId" value="${detailsVo.paoVo.supplier.id}" mui-verify="required">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mui-input-row">
                                    <label>所属项目</label>
                                    <%--<label style="width: 65%;padding-left: 0px;">${detailsVo.paoVo.tpm.name}</label>--%>
                                    <a <c:if test="${detailsVo.paoVo.id == null || detailsVo.paoVo.status == 0}">href="#selectProject" id="app-selectProject"</c:if>>
                                        <label id="selectProjectText" style="width: 65%;padding-left: 0px;">
                                            <c:choose>
                                                <c:when test="${detailsVo.paoVo.id == null}">
                                                    请选择所属项目
                                                </c:when>
                                                <c:otherwise>
                                                    ${detailsVo.paoVo.tpm.name}
                                                </c:otherwise>
                                            </c:choose>
                                        </label>
                                        <input type="hidden" id="selectProjectHidden" name="projectId" value="${detailsVo.paoVo.tpm.id}" mui-verify="required">
                                    </a>
                                </div>
                                <div>
                                    <textarea name="summary" id="summary" rows="5" class="mui-input-clear" readonly="readonly">${detailsVo.paoVo.summary}</textarea>
                                </div>
                                <div class="mui-button-row" style="padding-bottom: 20px;">
                                    <c:if test="${detailsVo.paoVo.status == 0 || detailsVo.paoVo.status == null}">
                                        <button type="button" class="mui-btn mui-btn-primary" id="programmeAcceptanceSave">保存</button>
                                    </c:if>
                                </div>
                            </form>
                        </div>
                    </li>

                    <!-- 审核状态 -->
                    <c:set value="${detailsVo.paoVo.historyList}" var="historyList"/>
                    <%@ include file="/WEB-INF/page/mobile/common/reviewHistory.jsp"%>

                    <li class="mui-table-view-cell mui-collapse mui-active">
                        <a class="mui-navigate-right" href="#">工程验收单明细</a>
                        <div class="mui-collapse-content" id="detailDiv">
                            <c:choose>
                                <c:when test="${fn:length(detailsVo.paoDetail) > 0}">
                                    <c:forEach items="${detailsVo.paoDetail}" var="item">
                                        <div class="mui-card">
                                            <div class="mui-card-header mui-card-media">
                                                <!-- 订单类型 用图标展示 -->
                                                <img src="${ctx }/images/icon/programme_acceptance_order.png">
                                                <div class="mui-media-body">
                                                    <label>整改内容</label>
                                                    <p>
                                                        ${item.rectifyContent}
                                                        <c:choose>
                                                            <c:when test="${item.rectifyFlag == 1}">
                                                                <span class="mui-badge mui-badge-success mui-pull-right" style="color: white;">已整改</span>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <span class="mui-badge mui-badge-danger mui-pull-right" style="color: white;">未整改</span>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </p>
                                                </div>
                                            </div>
                                            <div class="mui-card-content">
                                                <div class="mui-card-content-inner">
                                                    <p>
                                                        <label>整改措施:${item.rectifyMeasure}</label>
                                                    </p>
                                                    <p>
                                                        <label>计划完成日期：<fmt:formatDate value="${item.playOverDate}" pattern="yyyy-MM-dd"/></label>
                                                    </p>
                                                    <p>
                                                        <label>实际完成日期：<fmt:formatDate value="${item.actualOverDate}" pattern="yyyy-MM-dd"/></label>
                                                    </p>
                                                    <p>
                                                        <label>备注：${item.remark}${detailsVo.paoVo.status}</label>
                                                    </p>
                                                </div>
                                            </div>
                                            <div class="mui-card-footer">
                                                <c:if test="${detailsVo.paoVo.status == 0 && detailsVo.paoVo.createUser == admin.id}">
                                                    <div>
                                                        <a href="#fromPAOItem" name="app-a" data-id="${item.id}">
                                                            <button type="button" class="mui-btn mui-btn-primary" value="${item.id}">修改</button>
                                                        </a>
                                                    </div>
                                                    <div>
                                                        <button type="button" class="mui-btn mui-btn-primary deleteItem" value="${item.id}">刪除</button>
                                                    </div>
                                                </c:if>
                                                <c:if test="${detailsVo.paoVo.status == 1 && detailsVo.reviewUserId == admin.id}">
                                                    <div>
                                                        <a href="#fromPAOItem" name="app-a" data-id="${item.id}">
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
                                        <label>暂无明细</label>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </li>
                </ul>
            </div>



            <div class="mui-content-padded">
                <c:choose>
                    <c:when test="${detailsVo.paoVo.status == 0 && detailsVo.paoVo.createUser == admin.id}">
                        <a href="#fromPAOItem">
                            <button type="button" class="mui-btn mui-btn-primary mui-btn-block">增加明细</button>
                        </a>
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="PAODetails">提交</button>
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="deletePAOOrder" value="${detailsVo.paoVo.id}">删除</button>
                    </c:when>
                    <%--<c:when test="${detailsVo.paoVo.status == 1 && empty detailsVo.paoVo.costDepartUser && empty detailsVo.reviewUserId}">
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="submitReviewPAO">选择审核人</button>
                    </c:when>--%>
                    <c:when test="${detailsVo.paoVo.id != null && detailsVo.reviewUserId == admin.id}">
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="reviewPurchaseOrder">审核</button>
                    </c:when>
                </c:choose>
            </div>

        </div>
    </div>
    <!-- 采购单项 end -->
</div>


<div id="fromPAOItem" class="mui-page">
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <button type="button" class="mui-left mui-action-back mui-btn  mui-btn-link mui-btn-nav mui-pull-left">
            <span class="mui-icon mui-icon-left-nav"></span>返回
        </button>
        <h1 class="mui-center mui-title"><c:if test="${detailsVo.paoVo.status != 0}">审批</c:if><c:if test="${detailsVo.paoVo.status == 0}">增加</c:if>工程验收单项</h1>
    </div>
    <div class="mui-page-content">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll"  style="height: 100%;">
                <form class="mui-input-group" id="addFromPAOItem">
                    <input type="hidden" id="orderNo" name="orderNo" value="${detailsVo.paoVo.orderNo}">
                    <input type="hidden" id="id" name="id" value="">
                    <div class="mui-input-row">
                        <label>整改内容</label>
                        <input type="text" id="rectifyContent" name="rectifyContent" class="mui-input-clear" mui-verify="required" <c:if test="${detailsVo.paoVo.status != 0}">disabled="disabled"</c:if> placeholder="请输入整改内容">
                    </div>
                    <div class="mui-input-row">
                        <label>整改措施</label>
                        <input type="text" id="rectifyMeasure" name="rectifyMeasure" class="mui-input-clear" mui-verify="required" <c:if test="${detailsVo.paoVo.status != 0}">disabled="disabled"</c:if> placeholder="请输入整改措施">
                    </div>
                    <div class="mui-input-row">
                        <label>计划完成日期</label>
                        <input type="text" id="playOverDate" name="playOverDate" readonly data-options='{"type":"date","beginYear":2018,"endYear":2028}' <c:if test="${detailsVo.paoVo.status != 0}">disabled="disabled"</c:if> placeholder="请选择计划完成日期" mui-verify="required">
                    </div>
                    <c:if test="${detailsVo.paoVo.status == 1 && detailsVo.reviewUserId == admin.id}">
                        <div class="mui-input-row">
                            <label>是否已整改</label>
                            <input type="text" id="rectifyFlagName" name="rectifyFlagName" readonly value="已整改">
                            <input type="hidden" id="rectifyFlag" name="rectifyFlag" mui-verify="required" value="1">
                        </div>
                        <div class="mui-input-row">
                            <label>实际完成日期</label>
                            <input type="text" id="actualOverDate" name="actualOverDate" readonly data-options='{"type":"date","beginYear":2018,"endYear":2028}' placeholder="请选择实际完成日期" mui-verify="required">
                        </div>
                    </c:if>
                    <div>
                        <textarea name="remark" id="remark" rows="5" class="mui-input-clear"　<c:if test="${detailsVo.paoVo.status != 0}">disabled="disabled"</c:if> placeholder="备注"></textarea>
                    </div>
                    <div class="mui-button-row" style="padding-bottom: 20px;">
                        <button type="button" class="mui-btn mui-btn-primary" id="submitFromPAOItem">保存</button>
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
    var status = '${detailsVo.paoVo.status}';
    var rectifyFlagJson = '[{"value":0,"text":"未整改"},{"value":1,"text":"已整改"}]';
    //初始化数据
    mui.ready(function() {
        initplayOverDate();

        if(status == 1) {
            initactualOverDate();

            inirectifyFlagName();
        }
        var appA = document.getElementsByName('app-a');
        if(appA.length > 0){
            for(var i = 0; i < appA.length; i++){
                appA[i].addEventListener('tap', function(event) {
                    var itemId = $(this).attr("data-id");
                    var url = '${ctx}/mobile/programmeAcceptance/getProgrammeAcceptanceItem/' + itemId;
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
                                $("#rectifyContent").val(data.rectifyContent);
                                $("#orderNo").val(data.orderNo);
                                $("#addFromPAOItem").find("#id").val(data.id);
                                $("#playOverDate").val(data.playOverDate);
                                $("#remark").val(data.remark);
                                $("#rectifyMeasure").val(data.rectifyMeasure);
                                $("#actualOverDate").val(data.actualOverDate);
                                var rectifyFlagName = "未整改";
                                if(data.rectifyFlag == 1){
                                    rectifyFlagName = "已整改";
                                }
                                $("#rectifyFlag").val(data.rectifyFlag == 1 ? 1:0);
                                $("#rectifyFlagName").val(rectifyFlagName);
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



        if(status == null || status == 0) {
            document.getElementById('app-selectProject').addEventListener('tap', function (event) {
                $project.projectList();
            }, false);
        }
    });

    function initplayOverDate(){
        var btns =  mui('#playOverDate');
        btns.each(function(i, btn) {
            btn.addEventListener('tap', function() {
                var optionsJson = this.getAttribute('data-options') || '{}';
                var options = JSON.parse(optionsJson);
                var picker = new mui.DtPicker(options);
                picker.show(function(rs) {
                    playOverDate.value = rs.text;
                    picker.dispose();
                });
            }, false);
        });
    }

    function initactualOverDate(){
        var btns_actualOverDate =  mui('#actualOverDate');
        btns_actualOverDate.each(function(i, btn) {
            btn.addEventListener('tap', function() {
                var optionsJson = this.getAttribute('data-options') || '{}';
                var options = JSON.parse(optionsJson);
                var picker = new mui.DtPicker(options);
                picker.show(function(rs) {
                    actualOverDate.value = rs.text;
                    picker.dispose();
                });
            }, false);
        });
    }

    function inirectifyFlagName(){

        var rectifyFlagPicker = new mui.PopPicker();
        rectifyFlagPicker.setData(JSON.parse(rectifyFlagJson));
        var rectifyFlagName = document.getElementById('rectifyFlagName');
        var rectifyFlag = document.getElementById('rectifyFlag');
        rectifyFlagName.addEventListener('tap', function(event) {
            rectifyFlagPicker.show(function(items) {
                rectifyFlagName.value = items[0].text;
                rectifyFlag.value = items[0].value;
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);
    }

    /** 保存主表 **/
    mui(document.body).on('tap', '#programmeAcceptanceSave', function(e) {
        var check = true;
        mui("#programmeAcceptanceForm input").each(function() {
            //若当前input为空，则alert提醒
            var verify = $(this).attr("mui-verify");
            if(verify == 'required'){
                console.log($(this).attr("name"));
                if(!this.value || this.value.trim() == "") {
                    var label = this.previousElementSibling;
                    var tipText = "";
                    if(label.innerText == ""){
                        tipText = $(this).parent().find("label").html();
                    }else{
                        tipText = label.innerText;
                    }
                    mui.alert(tipText + "不允许为空");
                    check = false;
                    return false;
                }
            }
        });

        if(check){
            var url = '${ctx}/mobile/programmeAcceptance/addProgrammeAcceptanceOrder';
            $.ajax({
                url: url,
                data: $('#programmeAcceptanceForm').serialize(),
                dataType: 'json',
                contentType : "application/x-www-form-urlencoded",
                type: 'post',
                timeout: 10000,
                success: function(result) {
                    if(result.code!=0){
                        mui.alert(result.msg);
                    }else {
                        mui.alert('保存成功！', function() {
                            document.location.href='${ctx }/mobile/programmeAcceptance/toDetails/?id=' + result.msg;
                        });

                    }
                }
            });
        }
    });



    /** 提交明细 **/
    mui(document.body).on('tap', '#submitFromPAOItem', function(e) {
        var check = true;
        mui("#addFromPAOItem input").each(function() {
            //若当前input为空，则alert提醒
            var verify = $(this).attr("mui-verify")
            if(verify == 'required'){
                if(!this.value || this.value.trim() == "") {
                    console.log($(this).attr("name"));
                    var label = this.previousElementSibling;
                    mui.alert(label.innerText + "不允许为空");
                    check = false;
                    return false;
                }
            }
        });
        var rectifyContent = $('#rectifyContent').val().trim();
        if(check && rectifyContent.length > 200){
            mui.alert("整改内容格式错误，长度不能超过200！");
            check = false;
            return false;
        }
        var rectifyMeasure = $('#rectifyMeasure').val().trim();
        if(check && rectifyMeasure.length > 200){
            mui.alert("整改措施格式错误，长度不能超过200！");
            check = false;
            return false;
        }

        var remark = $('#remark').val().trim();
        if(check && remark.length > 200){
            mui.alert("备注格式错误，长度不能超过200！");
            check = false;
            return false;
        }

        //校验通过，继续执行业务逻辑
        if(check){
            var itemId = $('#addFromPAOItem').find('#id').val();
            var url = '${ctx}/mobile/programmeAcceptance/addProgrammeAcceptanceItem';
            if(itemId && itemId != '') {
                url = '${ctx}/mobile/programmeAcceptance/editProgrammeAcceptanceItem';
            }
            $.ajax({
                url: url,
                data: $('#addFromPAOItem').serialize(),
                dataType: 'json',
                contentType : "application/x-www-form-urlencoded",
                type: 'post',
                timeout: 10000,
                success: function(result) {
                    if(result.code!=0){
                        mui.alert(result.msg);
                    }else {
                        mui.alert('保存成功！', function() {
                            document.location.href='${ctx }/mobile/programmeAcceptance/toDetails/?id=${detailsVo.paoVo.id}';
                        });
                    }
                }
            });
        }else{
            mui.toast('检验不通过，请重新填写！',{ duration:'long', type:'div' })
        }
    });

    /** 删除明细 **/
    mui(document.body).on('tap', '.deleteItem', function(e) {
        var itemId = this.value;
        var btnArray = ['是', '否'];
        mui.confirm('确认删除此项？', '删除项', btnArray, function(e) {
            if (e.index == 0) {
                var url = '${ctx}/mobile/programmeAcceptance/deleteProgrammeAcceptanceItem/'+ itemId
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
                                document.location.href='${ctx }/mobile/programmeAcceptance/toDetails/?id=${detailsVo.paoVo.id}';
                            });
                        }
                    }
                });
            }
        })
    });

    /** 删除工程验收单 **/
    mui(document.body).on('tap', '#deletePAOOrder', function(e) {
        var id = this.value;
        var btnArray = ['是', '否'];
        mui.confirm('确认删除此工程验收单？', '删除工程验收单', btnArray, function(e) {
            if (e.index == 0) {
                var url = '${ctx}/mobile/programmeAcceptance/delProgrammeAcceptanceOrder?id='+ id
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
                                document.location.href='${ctx }/mobile/programmeAcceptance/list';
                            });
                        }
                    }
                });
            }
        })
    });

    /** 选择审核人 **/
    mui(document.body).on('tap', '#PAODetails', function(e) {
        var detailCard = $("#detailDiv").find("div.mui-card");
        console.log(detailCard.length);
        if(detailCard == null || detailCard.length <= 0){
            mui.alert("请先添加明细");
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
                var url = '${ctx}/mobile/programmeAcceptance/submitReviewprogrammeAcceptanceOrder?id=${detailsVo.paoVo.id}&userId=' + userId;
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
                                document.location.href='${ctx }/mobile/programmeAcceptance/toDetails/?id=${detailsVo.paoVo.id}';
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
            if (viewApi.canBack()) { //如果view可以后退，则执行view的后退
                document.getElementById('addFromPAOItem').reset();
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
<!-- 审核 -->
<c:set value="${ctx }/mobile/programmeAcceptance/toDetails/?id=${detailsVo.paoVo.id}" var="reviewRefreshUrl"/>
<c:set value="${ctx}/mobile/programmeAcceptance/reviewProgrammeAcceptanceOrder/${detailsVo.paoVo.id}" var="reviewSaveUrl"/>
<c:set value="${detailsVo.paoVo.status}" var="reviewStatus"/>
<%@ include file="/WEB-INF/page/mobile/common/review.jsp"%>
<!-- 审核 -->

</body>
</html>