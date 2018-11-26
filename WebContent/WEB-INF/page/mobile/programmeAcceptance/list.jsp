<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	<title>工程验收单</title>
	<link href="${ctx }/mui/css/mui.min.css" rel="stylesheet"/>
    <link href="${ctx }/mui/css/mui.picker.min.css" rel="stylesheet" />
</head>
<body>
<header class="mui-bar mui-bar-nav">
    <%--<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>--%>
    <h1 class="mui-title">工程验收单</h1>
</header>

<div class="mui-content">
    <div class="mui-card" style="margin: 0px; margin-top: 5px; margin-bottom: 5px; padding-bottom: 5px; text-align: center;">
        <div class="mui-button-row">
            <button type="button" id="add-btn" class="mui-btn mui-btn-primary">新建工程验收单</button>
        </div>
    </div>

    <!-- 单号、供应商、所属项目、合同号、开单人、开单日期、单据状态 -->
    <ul class="mui-table-view" style="z-index: 100">
        <li class="mui-table-view-cell mui-collapse" id="searchLi">
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
                        <label>供应商</label>
                        <input type="text" id="supplierIdName" readonly class="mui-input-clear" placeholder="请选择供应商"  value="">
                        <input type="hidden" id="supplierId" name="supplierId">
                    </div>
                    <div class="mui-input-row">
                        <label>所属项目</label>
                        <input type="text" id="selectProjectName" class="mui-input-clear" placeholder="请选择所属项目" >
                        <input type="hidden" id="projectId" name="projectId">
                    </div>
                    <div class="mui-input-row">
                        <label>合同号</label>
                        <input type="text" name="contractNo" placeholder="请输入合同号">
                    </div>
                    <div class="mui-input-row">
                        <label>开单人</label>
                        <input type="text" id="selectCreateUser" class="mui-input-clear" placeholder="请选择开单人" >
                        <input type="hidden" id="createUser" name="createUser">
                    </div>
                    <div class="mui-input-row">
                        <label>开单日期</label>
                        <input id="createTime" name="createTime" type="text" data-options='{"type":"date","beginYear":2014,"endYear":2016}' placeholder="请选择日期">
                    </div>
                    <div class="mui-input-row">
                        <label>单据状态</label>
                        <input type="text" id="statusName" readonly class="mui-input-clear" placeholder="请选择单据状态"  value="">
                        <input type="hidden" id="status" name="status" value="">
                    </div>
                    <div class="mui-button-row">
                        <button class="mui-btn mui-btn-primary" type="button" id="search-btn">确认</button>&nbsp;&nbsp;
                        <button class="mui-btn mui-btn-danger" type="button" id="reset-btn">重置</button>
                    </div>
                </form>
            </div>
        </li>
    </ul>

    <!--下拉刷新容器-->
    <div id="refreshContainer" class="mui-content mui-scroll-wrapper" style="margin-top: 135px;width: 100%;">
        <div class="mui-scroll">
            <!--数据列表-->
            <ul class="mui-table-view mui-table-view-chevron">
            </ul>
        </div>
    </div>
</div>
<script src="${ctx }/js/jquery-1.11.1.js"></script>
<script src="${ctx}/mui/js/mui.min.js"></script>
<script type="text/javascript" src="http://apps.bdimg.com/libs/handlebars.js/2.0.0-alpha.4/handlebars.js"></script>
<script type="text/javascript" src="${ctx}/js/pb-handlebarsHelps.js"></script>
<%--<script type="text/javascript" src="${ctx}/js/mobile/ucam/ucamUtils.js"></script>--%>
<script src="${ctx }/mui/js/mui.picker.min.js"></script>
<script type="text/javascript" charset="utf-8">
    var ctx = '${ctx }';
    var page = 1; //当前页
    var limit = 6; //每页显示条数
    var enablePullUp = true; //是否加载
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
        $('#searchLi').removeClass('mui-active');
    });

    mui(document.body).on('tap', '#add-btn', function(e) {
        document.location.href = ctx + '/mobile/programmeAcceptance/toEdit';
    });

    mui(document.body).on('tap', '.detail-card', function(e) {
        var id = $(this).attr("data-id");
        document.location.href = ctx + '/mobile/programmeAcceptance/toDetails/' + id;
    });
    mui(document.body).on('tap', '.details-edit', function(e) {
        var id = $(this).attr("data-id");
        document.location.href = ctx + '/mobile/programmeAcceptance/toEdit?id=' + id;

    });

    mui(document.body).on('tap','#reset-btn',function(e){
        $('#searchForm').find('input').val('');
    })


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
        $('.mui-table-view-chevron').empty();
        enablePullUp = true;
        page = 1;
        getBill();
        mui('#refreshContainer').pullRefresh().endPulldownToRefresh();
    }

    function getBill() {
        var params = $('#searchForm').serialize();
        console.log(JSON.stringify(params));
        var url = '${ctx}/mobile/programmeAcceptance/getProgrammeAcceptanceOrderList?' + 'limit=' + limit + '&page=' + page;
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
                    var listTargt = $('.mui-table-view-chevron')

                    var tpl = $("#listTpl").html();
                    //预编译模板
                    var template = Handlebars.compile(tpl);

                    //数据转换
                    prorammeAcceptanceOrder.statusConversion(Handlebars)
                    prorammeAcceptanceOrder.departUser(Handlebars)
                    prorammeAcceptanceOrder.departDate(Handlebars)
                    /*ucamOrder.instructOrder(Handlebars);*/
                    //匹配json内容
                    var html = template({data});//data
                    //输入模板
                    listTargt.append(html);

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

        var projectsJson = '${projects}';
        var projectsPicker = new mui.PopPicker({
            layer: 1
        });
        projectsPicker.setData(JSON.parse(projectsJson));
        var selectProjectName = document.getElementById('selectProjectName');
        var projectId = document.getElementById('projectId');
        selectProjectName.addEventListener('tap', function(event) {
            projectsPicker.show(function(items) {
                selectProjectName.value = items[0].text;
                projectId.value = items[0].value;
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);



        var statusJson = '[{"value": "", "text": "全部"},{"value": "0", "text": "未提交"}, {"value": "1", "text": "已提交"}, {"value": "2", "text": "成本部已审核"}, {"value": "3", "text": "工程部已审核"},{"value": "4", "text": "总经理已审核"}]';
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
        }, false);

    });


</script>

<!-- 合同内请款单 start -->
<%--单号、供应商、所属项目、合同号、开单人、开单日期、审核人、审核日期、单号状态--%>
<script type="text/template" id="listTpl">
    {{#each data}}
    <div class="mui-card" style="margin: 0px; margin-top: 5px;">
        <div class="mui-card-header mui-card-media detail-card" data-id="{{id}}">
            <!-- 订单类型 用图标展示 -->
            <img src="${ctx }/images/icon/uncontract_apply_money.png">
            <div class="mui-media-body">
                <label>单号:{{orderNo}}</label>
                <p>
                    <label>开单人:{{admin.fullname}}</label>&nbsp;
                    <label>开单日期：{{createTime}}</label>
                    <span class="mui-badge mui-badge-primary mui-pull-right">{{prorammeAcceptanceOrder_statusConversion status}}</span>
                </p>
            </div>
        </div>
        <div class="mui-card-content detail-card" data-id="{{id}}">
            <div class="mui-card-content-inner">
                <p>
                    <label>供应商：{{supplier.name}}</label>
                    <label>所属项目：{{tpm.name}}</label>
                </p>
            </div>
        </div>
        <div class="mui-card-footer">
            <div class="mui-pull-left">
                <label>{{prorammeAcceptanceOrder_departUser status}}</label>
                <label>{{prorammeAcceptanceOrder_departDate status}}</label>
            </div>
            <%--<div>
                <shiro:hasPermission name="mobile:programmeAcceptance:update">
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