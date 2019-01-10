<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	<title></title>
	<link href="${ctx }/mui/css/mui.min.css" rel="stylesheet"/>
    <link href="${ctx }/mui/css/mui.picker.min.css" rel="stylesheet" />
    <style>
        .mui-content>.mui-table-view:first-child{
            margin-top: 10px;
        }
    </style>
    <script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/mui/js/mui.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/handlebars.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/handlebarsHelps1.js"></script>
    <script src="${ctx }/mui/js/mui.picker.min.js"></script>
</head>
<body>
<header class="mui-bar mui-bar-nav">
    <%--<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>--%>
    <h1 class="mui-title">合同外请款单</h1>
</header>

<div class="mui-content">
    <c:set value="0" var="addPermission"/>
    <shiro:hasPermission name="mobile:UCAM:save">
        <c:set value="1" var="addPermission"/>
        <div class="mui-card" style="margin: 0px; margin-top: 5px; margin-bottom: 5px; padding-bottom: 5px; text-align: center;">
            <div class="mui-button-row">
                <button type="button" id="add-btn" class="mui-btn mui-btn-primary">新建合同外请款单</button>
            </div>
        </div>
    </shiro:hasPermission>

    <ul id="searchUl" class="mui-table-view" style="z-index: 100">
        <li class="mui-table-view-cell mui-collapse" id="searchCollapse">
            <a class="" href="#">
                搜索 <span style="float: right;" class="mui-icon mui-icon mui-icon-search"></span>
            </a>
            <div class="mui-collapse-content">
                <form class="mui-input-group" id="searchForm">
                    <div class="mui-input-row">
                        <label>单号</label>
                        <input type="text" name="orderNo" placeholder="请输入单号">
                    </div>
                    <div class="mui-input-row">
                        <label>单据类型</label>
                        <input type="text" id="orderTypeName" readonly class="mui-input-clear" placeholder="请选择单据类型" value="" >
                        <input type="hidden" id="orderType" name="orderType" value="" >
                    </div>
                    <div class="mui-input-row">
                        <label>供应商</label>
                        <input type="text" id="supplierIdName" readonly class="mui-input-clear" placeholder="请选择供应商"  value="">
                        <input type="hidden" id="supplierId" name="supplierId">
                    </div>
                    <div class="mui-input-row">
                        <label>所属项目</label>
                        <input type="text" name="projectId" placeholder="普通输入框">
                    </div>
                    <div class="mui-input-row">
                        <label>有无指令</label>
                        <input type="text" id="instructOrderFlagName" readonly class="mui-input-clear" placeholder="全部" value="">
                        <input type="hidden" id="instructOrderFlag" name="instructOrderFlag" value="">
                    </div>
                    <div class="mui-input-row">
                        <label>指令单号</label>
                        <input type="text" name="instructOrderNo" placeholder="普通输入框">
                    </div>
                    <div class="mui-input-row">
                        <label>请款人</label>
                        <input type="text" id="selectApplyUser" class="mui-input-clear" placeholder="请选择请款人" >
                        <input type="hidden" id="applyUser" name="applyUser">
                    </div>
                    <div class="mui-input-row">
                        <label>开单人</label>
                        <input type="text" id="selectCreateUser" class="mui-input-clear" placeholder="请选择开单人" >
                        <input type="hidden" id="createUser" name="createUser">
                    </div>
                    <div class="mui-input-row">
                        <label>开单日期</label>
                        <input id="createTime" name="createTime" type="text" data-options='{"type":"date","beginYear":2014}' placeholder="请选择日期">
                    </div>
                    <%--<div class="mui-input-row">
                        <label>单据状态</label>
                        <input type="text" id="statusName" readonly class="mui-input-clear" placeholder="请选择单据状态"  value="">
                        <input type="hidden" id="status" name="status" value="">
                    </div>--%>
                    <div class="mui-button-row">
                        <button class="mui-btn mui-btn-primary" type="button" id="search-btn">确认</button>&nbsp;&nbsp;
                        <button class="mui-btn mui-btn-danger" type="button" id="reset-btn">重置</button>
                    </div>
                </form>
            </div>
        </li>
    </ul>

    <!--下拉刷新容器-->
    <div id="refreshContainer" class="mui-content mui-scroll-wrapper" style="margin-top: 100px;width: 100%;">
        <div class="mui-scroll">
            <!--数据列表-->
            <div id="datascrollDiv" class="mui-content"></div>
        </div>
    </div>
</div>
<script type="text/javascript" charset="utf-8">
    var ctx = '${ctx }';
    var page = 1; //当前页
    var limit = 6; //每页显示条数
    var enablePullUp = true; //是否加载
    var addPermission = '${addPermission}';
    if(addPermission == 1){
        $('#refreshContainer').css("margin-top","142px");
    }else{
        $('#searchUl').css("margin-top","10px");
        $('#refreshContainer').css("margin-top","100px");
    }

    mui.init({
        swipeBack: true, //启用右滑关闭功能
        pullRefresh : {
            container:"#refreshContainer",//下拉刷新容器标识，querySelector能定位的css选择器均可，比如：id、.class等
            down : {
                style:'circle',//必选，下拉刷新样式，目前支持原生5+ ‘circle’ 样式
                auto: true,//可选,默认false.首次加载自动上拉刷新一次
                callback :billRefresh
            },
            up: {
                auto:false,
                contentrefresh: '正在加载...',
                contentnomore:'',
                callback: billLoad
            }
        }
    });

    mui(document.body).on('tap', '#search-btn', function(e) {
        $('#searchCollapse').removeClass('mui-active')
        billRefresh();
    });

    mui(document.body).on('tap', '#cancel-btn', function(e) {
        $('#searchCollapse').removeClass('mui-active');
        //$('#searchLi').removeClass('mui-active');
    });

    mui(document.body).on('tap', '#add-btn', function(e) {
        //document.location.href = ctx + '/mobile/UCAM/toEdit';
        document.location.href = ctx + '/mobile/UCAM/toDetails/';
    });

    mui(document.body).on('tap', '.detail-card', function(e) {
        var id = $(this).attr("data-id");
        document.location.href = ctx + '/mobile/UCAM/toDetails/?id=' + id;
    });
    mui(document.body).on('tap', '.details-edit', function(e) {
        var id = $(this).attr("data-id");
        document.location.href = ctx + '/mobile/UCAM/toEdit?id=' + id;

    });

    mui(document.body).on('tap','#reset-btn',function(e){
        $('#searchForm').find('input').val('');
    })


    /*mui(document.body).on('tap', '#search-btn', function(e) {
        alert("1232");
        getBill();
    });*/

    function billLoad() {
        if (!enablePullUp) {
            mui('#refreshContainer').pullRefresh().endPullupToRefresh(false);
            mui.toast("没有更多数据了");
            return;
        }
        page++;
        getBill();
        mui('#refreshContainer').pullRefresh().endPullupToRefresh(false);
    }

    function billRefresh() {
        $('#datascrollDiv').empty();
        enablePullUp = true;
        page = 1;
        getBill();
        mui('#refreshContainer').pullRefresh().endPulldownToRefresh();
    }

    function getBill() {
        var params = $('#searchForm').serialize();
        console.log(JSON.stringify(params));
        var url = '${ctx}/mobile/UCAM/getUCAMList?' + 'limit=' + limit + '&page=' + page;
        mui.toast("加载中...",1000);
        $.ajax({
            url: url,
            data: params,
            dataType: 'json',
            contentType : "application/x-www-form-urlencoded",
            type: 'post',
            timeout: 10000,
            success: function(result) {
                var refreshContainer = mui('#refreshContainer');
                if(result.data != null && result.data.length != 0){
                    var data = result.data;
                    // 请求成功
                    var listTargt = $('#datascrollDiv');

                    var tpl = $("#listTpl").html();
                    //预编译模板
                    var template = Handlebars.compile(tpl);

                    //数据转换
                    utilsOrder.approvalConversion(Handlebars);
                    /*prorammeAcceptanceOrder.departUser(Handlebars)
                    prorammeAcceptanceOrder.departDate(Handlebars)*/
                    /*ucamOrder.instructOrder(Handlebars);*/
                    //匹配json内容
                    var html = template({data});//data
                    //输入模板
                    listTargt.append(html);
                    $(".mui-toast-container").remove();
                    if (data.length < limit) {
                        enablePullUp = false;
                    }
                }
            },
            error: function () {
                mui('#refreshContainer').pullRefresh().endPullupToRefresh(false); //参数为true代表没有更多数据了。
                mui('#refreshContainer').pullRefresh().endPulldownToRefresh(); //refresh completed
                enablePullUp = false;
            }
        });
    }

    var btns =  mui('#createTime');
    btns.each(function(i, btn) {
        btn.addEventListener('tap', function() {
            var optionsJson = this.getAttribute('data-options') || '{}';
            var options = JSON.parse(optionsJson);
            var id = this.getAttribute('id');
            var picker = new mui.DtPicker(options);
            picker.show(function(rs) {
                createTime.value = rs.text;
                picker.dispose();
            });
        }, false);
    });


    mui.ready(function() {

        var adminsJson = '${admins}';
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
            });
        }, false);


        var selectCreateUser = document.getElementById('selectCreateUser');
        var createUser = document.getElementById('createUser');
        selectCreateUser.addEventListener('tap', function(event) {
            userPicker.show(function(items) {
                selectCreateUser.value = items[0].text;
                createUser.value = items[0].value;
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);

        var suppliersJson = '${suppliers}';
        var suppliersPicker = new mui.PopPicker({
            layer: 1
        });
        suppliersPicker.setData(JSON.parse(suppliersJson));
        var supplierIdName = document.getElementById('supplierIdName');
        var supplierId = document.getElementById('supplierId');
        supplierIdName.addEventListener('tap', function(event) {
            suppliersPicker.show(function(items) {
                supplierIdName.value = items[0].text;
                supplierId.value = items[0].value;
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);

        //二级下拉
        /*var suppliersJson = '';
        var suppliersPicker = new mui.PopPicker({
            layer: 2
        });
        suppliersPicker.setData(JSON.parse(suppliersJson));
        var supplierIdName = document.getElementById('supplierIdName');
        var supplierId = document.getElementById('supplierId');
        supplierIdName.addEventListener('tap', function(event) {
            suppliersPicker.show(function(items) {
                supplierIdName.value = items[0].text;
                supplierId.value = items[0].value;
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);*/

        var orderTypeJosn = '[{"text":"全部","value":""},{"text":"绿化苗木","value":"0"},{"text":"园建水电","value":"1"},{"text":"机械租赁","value":"2"},{"text":"工程分包","value":"3"}]';
        var orderTypeNamePicker = new mui.PopPicker();
        orderTypeNamePicker.setData(JSON.parse(orderTypeJosn));
        var orderTypeName = document.getElementById('orderTypeName');
        var orderType = document.getElementById('orderType');
        orderTypeName.addEventListener('tap', function(event) {
            orderTypeNamePicker.show(function(items) {
                orderTypeName.value = items[0].text;
                orderType.value = items[0].value;
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);

        /*var statusJson = '[{"value": "", "text": "全部"},{"value": "0", "text": "未提交"}, {"value": "1", "text": "已提交"}, {"value": "2", "text": "成本部已审核"}, {"value": "3", "text": "工程部已审核"},{"value": "4", "text": "总经理已审核"}]';
        var statusNamePicker = new mui.PopPicker();
        statusNamePicker.setData(JSON.parse(statusJson));
        var statusName = document.getElementById('statusName');
        var status = document.getElementById('status');
        statusName.addEventListener('tap', function(event) {
            statusNamePicker.show(function(items) {
                statusName.value = items[0].text;
                status.value = items[0].value;
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);*/

        var instrutOrderJson = '[{"value": "", "text": "全部"},{"value":0,"text":"未到"},{"value":1,"text":"已到"}]';
        var instructOrderFlagPicker = new mui.PopPicker();
        instructOrderFlagPicker.setData(JSON.parse(instrutOrderJson));
        var instructOrderFlagName = document.getElementById('instructOrderFlagName');
        var instructOrderFlag = document.getElementById('instructOrderFlag');
        instructOrderFlagName.addEventListener('tap', function(event) {
            instructOrderFlagPicker.show(function(items) {
                instructOrderFlagName.value = items[0].text;
                instructOrderFlag.value = items[0].value;
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);
    });


</script>

<!-- 合同内请款单 start -->
<%--单号、单据类型、供应商、所属项目、有无指令、指令单号、请款人、开单人、开单日期、审核人、审核日期、单号状态--%>
<script type="text/template" id="listTpl">
    {{#each data}}
    <div class="mui-card" style="margin: 0px; margin-top: 5px;">
        <div class="mui-card-header mui-card-media detail-card" data-id="{{id}}">
            <!-- 订单类型 用图标展示 -->
            <img src="${ctx }/images/icon/uncontract_apply_money.png">
            <div class="mui-media-body">
                {{#if instructOrderNo}}
                    <label>单号:{{orderNo}}</label>
                {{else}}
                    <label style="color: red;">单号:{{orderNo}}</label>
                {{/if}}
                <p>
                    <label>开单人:{{admin.fullname}}</label>&nbsp;
                    <label>开单日期：{{createTime}}</label>
                </p>
            </div>
        </div>
        <div class="mui-card-content detail-card" data-id="{{id}}">
            <div class="mui-card-content-inner">
                <p>
                    <label>供应商：{{supplier.name}}</label>
                    <label>所属项目：{{tpm.name}}</label>
                </p>
                <p>
                    {{#if instructOrderNo}}
                    <label>指令单已到</label>
                    <label>指令单号：{{instructOrderNo}}</label>
                    {{else}}
                    <label>指令单未到</label>
                    {{/if}}
                </p>
                <p>
                    <label>请款人：{{auAdmin.fullname}}</label>
                 </p>
            </div>
        </div>
        <div class="mui-card-footer">
            <div class="mui-pull-left">
                <label>操作人:{{lastUser.fullname}}</label>
                <label>时间:{{lastReviewDate}}</label>
            </div>
            <span class="mui-badge mui-badge-primary mui-pull-right">{{lastRole.roleName}} {{isApproval_Conversion isApproval}}</span>
            <%--<div>
                <shiro:hasPermission name="mobile:UCAM:update">
                    {{#compare status 0}}
                        <button type="button" class="mui-btn mui-btn-primary details-edit"  data-id="{{id}}" >修改</button>
                    {{/compare}}
                </shiro:hasPermission>
                &lt;%&ndash;<button type="button" class="mui-btn mui-btn-primary">审核</button>&ndash;%&gt;
            </div>--%>
        </div>
    </div>

    {{/each}}
</script>
<!-- 合同内请款单 end -->
</body>
</html>