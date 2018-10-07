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
        <h1 class="mui-center mui-title">工程验收单详情</h1>
    </div>

    <!-- 采购单项 start -->
    <div id="refreshContainer" class="mui-content mui-scroll-wrapper" style="margin-top: 0px;width: 100%;">
        <div class="mui-scroll">
            <!-- 主界面具体展示内容 -->


            <div class="mui-content" style="margin-left: 5px; margin-right: 5px; font-size: 14px;">
                <ul class="mui-table-view">
                    <li class="mui-table-view-cell mui-collapse">
                        <a class="mui-navigate-right" href="#">工程验收单详情:${detailsVo.paoVo.orderNo}</a>
                        <div class="mui-collapse-content">
                            <input type="hidden" name="orderNo" id="orderNo" value="${detailsVo.paoVo.orderNo}">
                            <input type="hidden" name="id" id="id" value="${detailsVo.paoVo.id}">
                            <div class="mui-input-row">
                                <label>请款单号</label>
                                <label style="width: 65%;padding-left: 0px;">${detailsVo.paoVo.orderNo}</label>
                            </div>
                            <div class="mui-input-row">
                                <label>请款人</label>
                                <label style="width: 65%;padding-left: 0px;">${detailsVo.paoVo.admin.fullname}</label>
                            </div>
                            <div class="mui-input-row">
                                <label>供应商</label>
                                <label style="width: 65%;padding-left: 0px;">${detailsVo.paoVo.supplier.name}</label>
                            </div>
                            <div class="mui-input-row">
                                <label>所属项目</label>
                                <label style="width: 65%;padding-left: 0px;">${detailsVo.paoVo.tpm.name}</label>
                            </div>
                            <div>
                                <textarea name="summary" id="summary" rows="5" class="mui-input-clear" readonly="readonly">${detailsVo.paoVo.summary}</textarea>
                            </div>
                        </div>
                    </li>
                    <li class="mui-table-view-cell mui-collapse">
                        <a class="mui-navigate-right" href="#">订单记录</a>
                        <c:forEach items="${detailsVo.paoVo.historyList}" var="history">
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
                                </p>
                                <p>
                                    <label>意见:
                                        <c:choose>
                                            <c:when test="${history.opinion == ''}">无</c:when>
                                            <c:otherwise>${history.opinion}</c:otherwise>
                                        </c:choose>
                                    </label>
                                </p>
                            </div>
                        </c:forEach>
                    </li>
                    <li class="mui-table-view-cell mui-collapse mui-active">
                        <a class="mui-navigate-right" href="#">工程验收单单项</a>
                        <div class="mui-collapse-content">
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
                                                        <label>备注：${item.remark}</label>
                                                    </p>
                                                </div>
                                            </div>
                                            <div class="mui-card-footer">
                                                <c:if test="${detailsVo.paoVo.status == 0}">
                                                    <div>
                                                        <button type="button" class="mui-btn mui-btn-primary deleteItem" value="${item.id}">刪除</button>
                                                    </div>
                                                </c:if>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <div class="mui-input-row">
                                        <label>工程验收单单项</label>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </li>
                </ul>
            </div>



            <div class="mui-content-padded">
                <c:choose>
                    <c:when test="${detailsVo.paoVo.status == 0}">
                        <a href="#fromPAOItem">
                            <button type="button" class="mui-btn mui-btn-primary mui-btn-block">增加工程验收单项</button>
                        </a>
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="PAODetails">提交</button>
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="deletePAOOrder" value="${detailsVo.paoVo.id}">删除</button>
                    </c:when>
                    <c:when test="${detailsVo.paoVo.status == 1 && empty detailsVo.paoVo.costDepartUser && empty detailsVo.reviewUserId}">
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="submitReviewPAO">选择审核人</button>
                    </c:when>
                    <c:when test="${!empty detailsVo.reviewUserId}">
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="reviewPAO">审核</button>
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
        <h1 class="mui-center mui-title">增加工程验收单项</h1>
    </div>
    <div class="mui-page-content">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll"  style="height: 100%;">
                <form class="mui-input-group" id="addFromPAOItem">
                    <input type="hidden" name="orderNo" value="${detailsVo.paoVo.orderNo}">
                    <div class="mui-input-row">
                        <label>整改内容</label>
                        <input type="text" name="rectifyContent" class="mui-input-clear" mui-verify="required" placeholder="请输入整改内容">
                    </div>
                    <div class="mui-input-row">
                        <label>整改措施</label>
                        <input type="text" name="rectifyMeasure" class="mui-input-clear" mui-verify="required" placeholder="请输入整改措施">
                    </div>
                    <div class="mui-input-row">
                        <label>计划完成日期</label>
                        <input type="text" id="playOverDate" name="playOverDate" class="mui-input-clear" readonly data-options='{"type":"date","beginYear":2018,"endYear":2028}' placeholder="请选择计划完成日期" mui-verify="required">
                    </div>
                    <div class="mui-input-row">
                        <label>是否已整改</label>
                        <input type="text" id="rectifyFlagName" name="rectifyFlagName" class="mui-input-clear" readonly value="已整改">
                        <input type="hidden" id="rectifyFlag" name="rectifyFlag" class="mui-input-clear" mui-verify="required" value="1">
                    </div>
                    <div class="mui-input-row">
                        <label>实际完成日期</label>
                        <input type="text" id="actualOverDate" name="actualOverDate" class="mui-input-clear" readonly data-options='{"type":"date","beginYear":2018,"endYear":2028}' placeholder="请选择实际完成日期" mui-verify="required">
                    </div>
                    <div>
                        <textarea name="remark" id="remark" rows="5" class="mui-input-clear" placeholder="备注"></textarea>
                    </div>
                    <div class="mui-button-row" style="padding-bottom: 20px;">
                        <button type="button" class="mui-btn mui-btn-primary" id="submitFromPAOItem">添加</button>
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
            <form class="mui-input-group" id="reviewPAOForm">
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
                    <button type="button" class="mui-btn mui-btn-primary" id="reviewPAOButton">审核</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="${ctx }/js/jquery-1.11.1.js"></script>
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

    var rectifyFlagJson = '[{"value":0,"text":"未整改"},{"value":1,"text":"已整改"}]';
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

    /** 提交项 **/
    mui(document.body).on('tap', '#submitFromPAOItem', function(e) {
        var check = true;
        mui("#addFromPAOItem input").each(function() {
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
            var id = $('#id').val();
            var url = '${ctx}/mobile/programmeAcceptance/addProgrammeAcceptanceItem';
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
                        mui.alert('添加成功！', function() {
                            document.location.href='${ctx }/mobile/programmeAcceptance/toDetails/${detailsVo.paoVo.id}';
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
                                document.location.href='${ctx }/mobile/programmeAcceptance/toDetails/${detailsVo.paoVo.id}';
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

    /** 提交审核 **/
    mui(document.body).on('tap', '#PAODetails', function(e) {
        var btnArray = ['是', '否'];
        mui.confirm('确认提交？', '提交工程验收单', btnArray, function(e) {
            if (e.index == 0) {
                var url = '${ctx}/mobile/programmeAcceptance/submitProgrammeAcceptanceOrder?id=${detailsVo.paoVo.id}';
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
                                document.location.href='${ctx }/mobile/programmeAcceptance/toDetails/${detailsVo.paoVo.id}';
                            });
                        }
                    }
                });
            }
        })
    });

    /** 选择审核人 **/
    mui(document.body).on('tap', '#submitReviewPAO', function(e) {
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
                                document.location.href='${ctx }/mobile/programmeAcceptance/toDetails/${detailsVo.paoVo.id}';
                            });
                        }
                    }
                });
            });

        });
    });

    /** 审核 **/
    mui(document.body).on('tap', '#reviewPAO', function(e) {
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

    mui(document.body).on('tap', '#reviewPAOButton', function(e) {

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
            var url = '${ctx}/mobile/programmeAcceptance/reviewProgrammeAcceptanceOrder/${detailsVo.paoVo.id}';
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
                            document.location.href='${ctx }/mobile/programmeAcceptance/toDetails/${detailsVo.paoVo.id}';
                        });
                    }
                }
            });
        });
    });

</script>
</body>
</html>