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
                <a href="#selectProject" id="app-a">
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



<div id="selectProject" class="mui-page">
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <button type="button" class="mui-left mui-action-back mui-btn  mui-btn-link mui-btn-nav mui-pull-left">
            <span class="mui-icon mui-icon-left-nav"></span>返回
        </button>
        <h1 class="mui-center mui-title">选择所属项目</h1>
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
                                        <label>名称</label>
                                        <input type="text" placeholder="项目名称" name="name">
                                    </div>
                                    <div class="mui-input-row">
                                        <label>项目简称</label>
                                        <input type="text" placeholder="项目简称" name="shortName">
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
                            <button type="button" class="mui-btn mui-btn-danger account-ensure" onclick="projectEnsure('selectProject','selectProjectText','selectProjectHidden');">确定</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<script src="${ctx }/mui/js/mui.min.js"></script>
<script src="${ctx }/js/jquery-1.11.1.js"></script>
<script src="${ctx }/mui/js/mui.picker.min.js"></script>
<script src="${ctx }/mui/js/mui.view.js"></script>
<script type="text/javascript" src="http://apps.bdimg.com/libs/handlebars.js/2.0.0-alpha.4/handlebars.js"></script>
<script type="text/javascript" charset="utf-8">
    mui.init();
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

        var appA = document.getElementById('app-a');
        appA.addEventListener('tap', function(event) {
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

    //选择项目
    var $project = {
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
            if (!$project.enablePullUp) {
                $project.list.pullRefresh().endPullupToRefresh(false);
                mui.toast("没有更多数据了");
                return;
            }
            $project.page++;
            $project.getBill();
            $project.list.pullRefresh().endPullupToRefresh(false);
        },
        billRefresh : function() {
            $('.projectRefreshContainerData').empty();
            $project.enablePullUp = true;
            $project.page = 1;
            $project.getBill();

            $project.list.pullRefresh().endPulldownToRefresh();
        },
        getBill: function () {
            var url = '${ctx}/projectManger/findProjectMangerList?' + 'limit=' + $project.limit + '&page=' + $project.page;
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
                            $project.enablePullUp = false;
                        }
                    }
                },
                error: function () {
                    $project.list.pullRefresh().endPullupToRefresh(false); //参数为true代表没有更多数据了。
                    $project.list.pullRefresh().endPulldownToRefresh(); //refresh completed
                    $project.enablePullUp = false;
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
    function projectEnsure(flag,callText,callValue){
        var accountSelected = $("#" + flag).find("li").hasClass("mui-selected");
        if(accountSelected){
            var li = $("#" + flag).find("li.mui-selected");
            var value = $(li).attr("data-id");
            var text = $(li).attr("data-text");
            console.log(value + "/n" +text);
            $("#" + callText).text(text);
            $("#" + callValue).val(value);
            cancel();
        }else{
            mui.toast('您尚未选择，请选择后确定',{ duration:'long', type:'div' })
        }
    }

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
    var view = viewApi.view;
    (function($) {
        //处理view的后退与webview后退
        var oldBack = $.back;
        $.back = function() {
            if (viewApi.canBack()) { //如果view可以后退，则执行view的后退
                viewApi.back();
            } else { //执行webview后退
                oldBack();
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
<script type="text/template" id="listTpl">
    {{#each data}}
    <li class="mui-table-view-cell" data-id="{{id}}" data-text="{{name}}">
        <a class="mui-navigate-right">{{name}}</a>
    </li>
    {{/each}}
</script>
</body>
</html>