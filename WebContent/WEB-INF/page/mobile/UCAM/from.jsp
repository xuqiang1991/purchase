<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>
        <c:choose>
            <c:when test="${empty ucamVo.id}">新建合同外请款单</c:when>
            <c:otherwise>修改合同外请款单</c:otherwise>
        </c:choose>
    </title>
    <link href="${ctx }/mui/css/mui.min.css" rel="stylesheet"/>
    <link href="${ctx }/mui/css/iconfont.css" rel="stylesheet"/>
    <link href="${ctx }/mui/css/mui.picker.min.css" rel="stylesheet" />
    <link href="${ctx }/mui/css/feedback-page.css" rel="stylesheet" />
    <link href="${ctx }/mui/css/mui-page.css" rel="stylesheet" />
    <script src="${ctx }/mui/js/mui.min.js"></script>
    <script src="${ctx }/js/jquery-1.11.1.js"></script>
    <script src="${ctx }/mui/js/mui.picker.min.js"></script>
    <script src="${ctx }/mui/js/mui.view.js"></script>
    <script type="text/javascript" src="http://apps.bdimg.com/libs/handlebars.js/2.0.0-alpha.4/handlebars.js"></script>
    <script type="text/javascript">
        mui.init();
    </script>
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
        <h1 class="mui-center mui-title">
            <c:choose>
                <c:when test="${empty ucamVo.id}">新建合同外请款单</c:when>
                <c:otherwise>修改合同外请款单</c:otherwise>
            </c:choose>
        </h1>
    </div>

    <div class="mui-content-padded mui-card" style="margin: 5px;">
        <form class="mui-input-group" id="ucamForm">
            <%--<div class="mui-input-row">
                <label>单号</label>
                <input type="text" readonly="readonly" class="mui-input-clear" placeholder="PC20180817001">
            </div>--%>
            <input type="hidden" id="id" name="id" value="${ucamVo.id}" />

            <div class="mui-input-row">
                <label>请款人</label>
                <c:choose>
                    <c:when test="${ucamVo.id == null}">
                        <input type="text" id="selectApplyUser" placeholder="请选择开单人" value="${admin.fullname}">
                        <input type="hidden" id="applyUser" name="applyUser" value="${admin.id}" mui-verify="required">
                    </c:when>
                    <c:otherwise>
                        <input type="text" id="selectApplyUser" placeholder="请选择开单人" value="${ucamVo.auAdmin.fullname}">
                        <input type="hidden" id="applyUser" name="applyUser" value="${ucamVo.auAdmin.id}" mui-verify="required">
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="mui-input-row">
                <label>供应商</label>
                <c:choose>
                    <c:when test="${ucamVo.id == null}">
                        <input type="text" id="supplierName" readonly value="${admin.supplierName}">
                        <input type="hidden" id="supplierId" name="supplierId" value="${admin.supplierId}" mui-verify="required">
                    </c:when>
                    <c:otherwise>
                        <input type="text" id="supplierName" readonly value="${ucamVo.supplier.name}">
                        <input type="hidden" id="supplierId" name="supplierId" value="${ucamVo.supplier.id}" mui-verify="required">
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="mui-input-row">
                <label>所属项目</label>
                <a href="#selectProject" id="app-selectProject">
                    <label id="selectProjectText" style="width: 65%;padding-left: 0px;">
                        <c:choose>
                            <c:when test="${ucamVo.id == null}">
                                请选择所属项目
                            </c:when>
                            <c:otherwise>
                                ${ucamVo.tpm.name}
                            </c:otherwise>
                        </c:choose>
                    </label>
                    <input type="hidden" id="selectProjectHidden" name="projectId" value="${ucamVo.tpm.id}" mui-verify="required">
                </a>
            </div>

            <div class="mui-input-row">
                <label>单据类型</label>
                <input type="text" id="orderTypeName" readonly class="mui-input-clear" placeholder="请选择单据类型" value="" >
                <input type="hidden" id="orderTypeId" name="orderType" value="${ucamVo.orderType}"  mui-verify="required">
            </div>

            <div class="mui-input-row">
                <label>指令单已到</label>
                <c:choose>
                    <c:when test="${ucamVo.instructOrderFlag == 1}">
                        <input type="text" id="instructOrderFlagName" readonly class="mui-input-clear"  value="已到">
                        <input type="hidden" id="instructOrderFlag" name="instructOrderFlag" value="1">
                    </c:when>
                    <c:otherwise>
                        <input type="text" id="instructOrderFlagName" readonly class="mui-input-clear"  value="未到">
                        <input type="hidden" id="instructOrderFlag" name="instructOrderFlag" value="0">
                    </c:otherwise>
                </c:choose>
            </div>
            <c:choose>
                <c:when test="${ucamVo.instructOrderFlag == 1}">
                    <div class="mui-input-row" id="instrucoOrderNoDiv" style="display: block">
                </c:when>
                <c:otherwise>
                    <div class="mui-input-row" id="instrucoOrderNoDiv" style="display: none;" >
                </c:otherwise>
            </c:choose>
                    <label>指令单号</label>
                    <input type="text" class="mui-input-clear" name="instructOrderNo" placeholder="${ucamVo.instructOrderNo}">
                    </div>
            <div>
                <textarea id="textarea" name="summary" rows="5" class="mui-input-clear" placeholder="摘要">${ucamVo.summary}</textarea>
            </div>
        </form>
        <div class="mui-button-row" style="padding-bottom: 20px;">
            <c:choose>
                <c:when test="${empty ucamVo.id}">
                    <button type="button" class="mui-btn mui-btn-primary" onclick="ucamSave();">保存</button>
                </c:when>
                <c:otherwise>
                    <c:if test="${ucamVo.status == 0}">
                        <button type="button" class="mui-btn mui-btn-primary" onclick="ucamSave();">保存</button>
                    </c:if>
                </c:otherwise>
            </c:choose>
            <%--<button type="button" class="mui-btn mui-btn-danger" onclick="return false;">取消</button>--%>
        </div>
    </div>

</div>


<%@ include file="/WEB-INF/page/mobile/common/selectProject.jsp"%>
<script type="text/javascript" charset="utf-8">
    //初始化单页view
    var viewApi = mui('#app').view({
        defaultPage: '#setting'
    });

    var orderTypeJosn = '[{"text":"绿化苗木","value":"0"},{"text":"园建水电","value":"1"},{"text":"机械租赁","value":"2"},{"text":"工程分包","value":"3"}]';
    var instrutOrderJson = '[{"value":0,"text":"未到"},{"value":1,"text":"已到"}]';

    mui.ready(function() {
        var adminsJson = '${admins}';
        console.log(adminsJson);
        var userPicker = new mui.PopPicker();
        userPicker.setData(JSON.parse(adminsJson));
        var selectApplyUser = document.getElementById('selectApplyUser');
        var applyUser = document.getElementById('applyUser');
        selectApplyUser.addEventListener('tap', function(event) {
            userPicker.show(function(items) {
                selectApplyUser.value = items[0].text;
                applyUser.value = items[0].value;
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


        var instructOrderFlagPicker = new mui.PopPicker();
        instructOrderFlagPicker.setData(JSON.parse(instrutOrderJson));
        var instructOrderFlagName = document.getElementById('instructOrderFlagName');
        var instructOrderFlag = document.getElementById('instructOrderFlag');
        instructOrderFlagName.addEventListener('tap', function(event) {
            instructOrderFlagPicker.show(function(items) {
                instructOrderFlagName.value = items[0].text;
                instructOrderFlag.value = items[0].value;
                console.log(items[0].value);
                if(items[0].value == 1){
                    $("#instrucoOrderNoDiv").show();
                }else{
                    $("#instrucoOrderNoDiv").hide();
                }
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);

        var orderType = '${ucamVo.orderType}';
        if(orderType != null){
            var ot = JSON.parse(orderTypeJosn);
            console.log(orderType);
            for(var i = 0; i < ot.length; i++){
                if(ot[i].value == orderType){
                    $("#orderTypeName").val(ot[i].text);
                }
            }
        }

        //var appSelectProject = document.getElementById('app-selectProject');
        document.getElementById('app-selectProject').addEventListener('tap', function(event) {
            $project.projectList();
        },false);

    });

    /** start 选择所属项目 **/
    mui(document.body).on('tap', '#search-btn', function(e) {
        $('#searchCollapse').removeClass('mui-active')
        $project.projectList();
    });

    mui(document.body).on('tap', '#cancel-btn', function(e) {
        $('#searchCollapse').removeClass('mui-active')
    });

    function ucamSave(){
        var check = true;
        mui("input").each(function() {
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
                        document.location.href = '${ctx }/mobile/UCAM/toDetails/' + result.msg;
                    }
                }
            });
        }

    }
    /*(function($) {
        //处理view的后退与webview后退
        var oldBack = $.back;
        $.back = function() {
            if (viewApi.canBack()) { //如果view可以后退，则执行view的后退
                viewApi.back();
            } else { //执行webview后退
                oldBack();
            }
        };
    })(mui);*/
</script>
</body>
</html>