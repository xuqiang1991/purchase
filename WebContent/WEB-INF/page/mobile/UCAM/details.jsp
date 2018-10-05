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
        <button type="button" class="mui-left mui-action-back mui-btn  mui-btn-link mui-btn-nav mui-pull-left">
            <span class="mui-icon mui-icon-left-nav"></span>
        </button>
        <h1 class="mui-center mui-title">合同外请款单详情</h1>
    </div>

    <!-- 采购单项 start -->
    <div id="refreshContainer" class="mui-content mui-scroll-wrapper" style="margin-top: 0px;width: 100%;">
        <div class="mui-scroll">
            <!-- 主界面具体展示内容 -->
            <div class="mui-content-padded mui-card" style="margin: 5px;">
                <input type="hidden" name="orderNo" id="orderNo" value="${detailsVo.ucamVo.orderNo}">
                <input type="hidden" name="id" id="id" value="${detailsVo.ucamVo.id}">
                <div class="mui-input-row">
                    <label>请款单号</label>
                    <label style="width: 65%;padding-left: 0px;">${detailsVo.ucamVo.orderNo}</label>
                </div>
                <div class="mui-input-row">
                    <label>请款人</label>
                    <label style="width: 65%;padding-left: 0px;">${detailsVo.ucamVo.admin.fullname}</label>
                </div>
                <div class="mui-input-row">
                    <label>供应商</label>
                    <label style="width: 65%;padding-left: 0px;">${detailsVo.ucamVo.supplier.name}</label>
                </div>
                <div class="mui-input-row">
                    <label>所属项目</label>
                    <label style="width: 65%;padding-left: 0px;">${detailsVo.ucamVo.tpm.name}</label>
                </div>
                <div class="mui-input-row">
                    <label>单据类型</label>
                    <label style="width: 65%;padding-left: 0px;">
                        <c:choose>
                            <c:when test="${detailsVo.ucamVo.orderType == 0}">
                                绿化苗木
                            </c:when>
                            <c:when test="${detailsVo.ucamVo.orderType == 1}">
                                园建水电
                            </c:when>
                            <c:when test="${detailsVo.ucamVo.orderType == 2}">
                                机械租赁
                            </c:when>
                            <c:when test="${detailsVo.ucamVo.orderType == 3}">
                                工程分包
                            </c:when>
                            <c:otherwise>无</c:otherwise>
                        </c:choose>
                    </label>
                </div>
                <div class="mui-input-row">
                    <label>指令单号</label>
                    <label style="width: 65%;padding-left: 0px;">
                        <c:choose>
                            <c:when test="${detailsVo.ucamVo.instructOrderFlag == 1}">
                                ${detailsVo.ucamVo.instructOrderNo}
                            </c:when>
                            <c:otherwise>无</c:otherwise>
                        </c:choose>
                    </label>
                </div>
                <div class="mui-input-row">
                    <label>请款总金额</label>
                    <label style="width: 65%;padding-left: 0px;">${detailsVo.ucamVo.applyPrice}</label>
                </div>
                <div>
                    <textarea name="summary" id="summary" rows="5" class="mui-input-clear" readonly="readonly">${detailsVo.ucamVo.summary}</textarea>
                </div>
                <c:if test="${detailsVo.ucamVo.status == 0}">
                    <div class="mui-button-row" style="padding-bottom: 20px;">
                        <a href="#fromUCAMItem">
                            <label id="selectProjectText" style="width: 65%;padding-left: 0px;">增加请款单项</label>
                        </a>
                    </div>
                </c:if>
            </div>

            <div class="mui-content" style="margin-left: 5px; margin-right: 5px; font-size: 14px;">
                <ul class="mui-table-view">
                    <li class="mui-table-view-cell mui-collapse">
                        <a class="mui-navigate-right" href="#">订单历史</a>
                        <c:forEach items="${detailsVo.ucamVo.historyList}" var="history">
                            <div class="mui-collapse-content">
                                <p>
                                    <strong>
                                        <c:choose>
                                            <c:when test="${history.sort == 0}">创建</c:when>
                                            <c:when test="${history.sort == 1}">提交</c:when>
                                            <c:otherwise>
                                                <c:choose>
                                                    <c:when test="${history.approval == true}">审核通过</c:when>
                                                    <c:otherwise>审核未通过</c:otherwise>
                                                </c:choose>
                                            </c:otherwise>
                                        </c:choose>
                                    </strong>
                                    <label>操作人:${history.name}</label>
                                    <label>操作时间:<fmt:formatDate value="${history.date}" pattern="yyyy-MM-dd"/></label>
                                    <label>意见:${history.opinion}</label>
                                </p>
                            </div>
                        </c:forEach>
                    </li>
                </ul>
            </div>


            <c:forEach items="${detailsVo.ucamDetail}" var="item">
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
                                <label>工程量:${item.quantities}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                                <label>单位:${item.unit}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                                <label>单价：${item.price}</label>
                            </p>
                            <p>
                                <label>申报完成率:${item.applyCompletionRate}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                                <label>申报金额：${item.applyPrice}</label>
                            </p>
                            <p>
                                <label>审核完成率：${item.approvalCompletionRate}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                                <label>审批金额：${item.approvalPrice}</label>
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
                        <c:if test="${detailsVo.ucamVo.status == 0}">
                            <div>
                                <button type="button" class="mui-btn mui-btn-primary deleteItem" value="${item.id}">刪除</button>
                            </div>
                        </c:if>
                    </div>
                </div>
            </c:forEach>
            <div class="mui-content-padded">
                <c:choose>
                    <c:when test="${detailsVo.ucamVo.status == 0}">
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="UCAMDetails">提交</button>
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="deleteUCAMOrder" value="${detailsVo.ucamVo.id}">删除</button>
                    </c:when>
                    <c:when test="${detailsVo.ucamVo.status == 1 && empty detailsVo.ucamVo.costDepartUser && empty detailsVo.reviewUserId}">
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="submitReviewUCAM">选择审核人</button>
                    </c:when>
                    <c:when test="${!empty detailsVo.reviewUserId}">
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="reviewUCAM">审核</button>
                    </c:when>
                </c:choose>
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
        <h1 class="mui-center mui-title">增加请款单项</h1>
    </div>
    <div class="mui-page-content">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll"  style="height: 100%;">
                <form class="mui-input-group" id="addFromUCAMItem">
                    <div class="mui-input-row">
                        <label>材料/项目内容</label>
                        <input type="text" name="projectContent" class="mui-input-clear" mui-verify="required">
                    </div>
                    <div class="mui-input-row">
                        <label>工程量</label>
                        <input type="text" name="quantities" class="mui-input-clear" mui-verify="required">
                    </div>
                    <div class="mui-input-row">
                        <label>申报完成率</label>
                        <input type="text" name="applyCompletionRate" class="mui-input-clear" mui-verify="required">
                    </div>
                    <div class="mui-input-row">
                        <label>审核完成率</label>
                        <input type="text" name="approvalCompletionRate" class="mui-input-clear" mui-verify="required">
                    </div>
                    <div class="mui-input-row">
                        <label>单位</label>
                        <input type="text" name="unit" class="mui-input-clear" mui-verify="required">
                    </div>
                    <div class="mui-input-row">
                        <label>单价</label>
                        <input type="text" name="price" class="mui-input-clear" mui-verify="required">
                    </div>
                    <div class="mui-input-row">
                        <label>申报金额</label>
                        <input type="text" name="applyPrice" class="mui-input-clear" mui-verify="required">
                    </div>
                    <div class="mui-input-row">
                        <label>审批金额</label>
                        <input type="text" name="approvalPrice" class="mui-input-clear" mui-verify="required">
                    </div>
                    <c:if test="${detailsVo.ucamVo.orderType == 1}">
                        <div class="mui-input-row">
                            <label>质保期（月）</label>
                            <input type="text" name="warrantyDate" class="mui-input-clear" mui-verify="required">
                        </div>
                    </c:if>
                    <c:if test="${detailsVo.ucamVo.orderType == 2}">
                        <div class="mui-input-row">
                            <label>日期</label>
                            <input type="text" name="date" class="mui-input-clear" mui-verify="required">
                        </div>
                    </c:if>
                    <%--<div class="mui-input-row">
                        <label>已支付金额</label>
                        <input type="text" name="amount" class="mui-input-clear" mui-verify="required">
                    </div>--%>
                    <div>
                        <textarea name="remark" id="remark" rows="5" class="mui-input-clear" placeholder="备注"></textarea>
                    </div>
                    <div class="mui-button-row" style="padding-bottom: 20px;">
                        <button type="button" class="mui-btn mui-btn-primary" id="submitFromUCAMItem">添加</button>
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
            <form class="mui-input-group" id="reviewUCAMForm">
                <div class="mui-input-row">
                    <label style="width: 120px;">审核结果</label>
                    <input type="text" id="selectAuditResults" placeholder="请选择审核结果" readonly style="float: left;width: 150px;" value="审核通过">
                    <input type="hidden" id="auditResults" name="auditResults" value="1">
                </div>
                <div class="mui-input-row">
                    <label style="width: 120px;">上级审核人</label>
                    <input type="text" id="selectApplyUser" placeholder="上级审核人" readonly style="float: left;width: 150px;">
                    <input type="hidden" id="applyUser" name="applyUser">
                </div>
                <div class="mui-input-row" style="height: auto">
                    <textarea name="auditOpinion" id="auditOpinion" rows="5" class="mui-input-clear" placeholder="审核意见"></textarea>
                </div>
                <div class="mui-button-row" style="padding-bottom: 20px;">
                    <button type="button" class="mui-btn mui-btn-primary" id="reviewUCAMButton">审核</button>
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
            var url = '${ctx}/mobile/UCAM/addUCAMItem/'+ orderNo
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
                        mui.alert('添加成功！', function() {
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

    /** 提交审核 **/
    mui(document.body).on('tap', '#UCAMDetails', function(e) {
        var btnArray = ['是', '否'];
        mui.confirm('确认提交？', '提交合同外请款单', btnArray, function(e) {
            if (e.index == 0) {
                var url = '${ctx}/mobile/UCAM/submitUCAMOrder?id=${detailsVo.ucamVo.id}';
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
                            mui.alert('提交成功！', function() {
                                document.location.href='${ctx }/mobile/UCAM/toDetails/${detailsVo.ucamVo.id}';
                            });
                        }
                    }
                });
            }
        })
    });

    /** 选择审核人 **/
    mui(document.body).on('tap', '#submitReviewUCAM', function(e) {
        var adminsJson = '${detailsVo.departs}'
        var json =JSON.parse(adminsJson)
        var userPicker = new mui.PopPicker();
        userPicker.setData(json);
        userPicker.show(function (selectItems) {
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

    /** 审核 **/
    mui(document.body).on('tap', '#reviewUCAM', function(e) {
        mui("#popover").popover('toggle', document.getElementById("div"));
    });

    mui(document.body).on('tap', '#selectApplyUser', function(e) {
        var adminsJson = '${detailsVo.departs}'
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
        var adminsJson = '[{"text":"审核通过","value":"1"},{"text":"审核不通过","value":"0"}]';
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

    mui(document.body).on('tap', '#reviewUCAMButton', function(e) {

        var auditResults = document.getElementById("auditResults");
        var applyUser = document.getElementById("applyUser");
        console.log(applyUser.value);
        if(!applyUser.value || applyUser.value.trim() == "") {
            mui.alert("请选择上级审核人");
            return false;
        }

        var auditOpinion = document.getElementById("auditOpinion");
        if(!auditOpinion.value || auditOpinion.value.trim() == "") {
            mui.alert("审核意见不允许为空");
            return false;
        }

        mui.alert('确定提交审核？' , function() {
            var url = '${ctx}/mobile/UCAM/reviewUCAMOrder/${detailsVo.ucamVo.id}';
            $.ajax({
                url: url,
                data:{'auditResults':auditResults.value,'applyUser':applyUser.value,'auditOpinion': auditOpinion.value},
                dataType: 'json',
                contentType : "application/x-www-form-urlencoded",
                type: 'post',
                timeout: 10000,
                success: function(result) {
                    if(result.code!=0){
                        mui.alert(result.msg);
                    }else {
                        mui.alert('审核成功！', function() {
                            document.location.href='${ctx }/mobile/UCAM/toDetails/${detailsVo.ucamVo.id}';
                        });
                    }
                }
            });
        });
    });

</script>
</body>
</html>