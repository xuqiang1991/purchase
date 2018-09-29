<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	<title></title>
	<link href="${ctx }/mui/css/mui.min.css" rel="stylesheet"/>
</head>
<body>
<header class="mui-bar mui-bar-nav">
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
    <h1 class="mui-title">合同内请款单</h1>
</header>

<div class="mui-content">
    <div class="mui-card" style="margin: 0px; margin-top: 5px; margin-bottom: 5px; padding-bottom: 5px; text-align: center;">
        <div class="mui-button-row">
            <button type="button" id="add-btn" class="mui-btn mui-btn-primary">新建合同内请款单</button>
        </div>
    </div>
    <!-- 单号、订单类型、来源订单、供应商、所属项目、请款人、开单人、开单日期、单据状态 -->
    <ul class="mui-table-view">
        <li class="mui-table-view-cell mui-collapse">
            <a class="mui-navigate-right" href="#">搜索</a>
            <div class="mui-collapse-content">
                <div class="mui-collapse-content">
                    <form class="mui-input-group">
                        <div class="mui-input-row">
                            <label>单号</label>
                            <input type="text" placeholder="普通输入框">
                        </div>
                        <div class="mui-input-row">
                            <label>订单类型</label>
                            <select name="type">
                                <option value="">全部</option>
                                <option value="0">绿化苗木</option>
                                <option value="1">园建水电</option>
                                <option value="2">机械租赁</option>
                                <option value="3">工程分包</option>
                            </select>
                        </div>
                        <div class="mui-button-row">
                            <button class="mui-btn mui-btn-primary" type="button" onclick="return false;">确认</button>&nbsp;&nbsp;
                            <button class="mui-btn mui-btn-danger" type="button" onclick="return false;">取消</button>
                        </div>
                    </form>
                </div>
            </div>
        </li>
    </ul>
    <!-- 合同内请款单 start -->
    <div id="refreshContainer" class="mui-content mui-scroll-wrapper" style="margin-top: 135px;width: 100%;">
        <div class="mui-scroll">
            <!--数据列表-->
            <ul class="mui-table-view mui-table-view-chevron">
            </ul>
        </div>
    </div>
    <!-- 合同内请款单 end -->
</div>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/mui/js/mui.min.js"></script>
<script type="text/javascript" src="http://apps.bdimg.com/libs/handlebars.js/2.0.0-alpha.4/handlebars.js"></script>
<script type="text/javascript" src="${ctx}/js/handlebarsHelps.js"></script>
<script type="text/javascript" charset="utf-8">
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

    mui(document.body).on('tap', '.toDetails', function(e) {
        var id = $(this).attr('value');
        toDetails(id)
    });

    mui(document.body).on('tap', '#search-btn', function(e) {
        $('#searchCollapse').removeClass('mui-active')
        billRefresh();
    });

    mui(document.body).on('tap', '#cancel-btn', function(e) {
        $('#searchCollapse').removeClass('mui-active')
    });

    mui(document.body).on('tap', '#add-btn', function(e) {
        document.location.href='${ctx }/mobile/CAM/toSave';
    });

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
        var url = '${ctx}/mobile/CAM/getCAMList?' + 'limit=' + limit + '&page=' + page;
        mui.toast("加载中...",1000);
        $.ajax({
            url: url,
            data: $('#searchForm').serialize(),
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
                    purchaseOrder.statusConversion(Handlebars)
                    purchaseOrder.departUser(Handlebars)
                    purchaseOrder.departDate(Handlebars)

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


    function toDetails(id) {
        document.location.href='${ctx }/mobile/CAM/toDetails/' + id;
    }
</script>
<!-- 采购订单 start -->
<script type="text/template" id="listTpl">
    {{#each data}}
    <div class="mui-card" style="margin: 0px; margin-top: 5px;">
        <div class="mui-card-header mui-card-media toDetails" value="{{id}}">
            <!-- 订单类型 用图标展示 -->
            <img src="${ctx }/images/icon/contract_apply_money.png">
            <div class="mui-media-body">
                <label>单号:{{orderNo}}</label>
                <p>
                <p>
                    <label>开单人:{{admin.fullname}}</label>&nbsp;
                    <label>开单日期：{{createTime}}</label>
                    <span class="mui-badge mui-badge-primary mui-pull-right">{{purchaseOrder_statusConversion status}}</span>
                </p>
                </p>
            </div>
        </div>
        <div class="mui-card-content toDetails" value="{{id}}">
            <div class="mui-card-content-inner">
                <p>
                    <label>来源订单：{{admin.fullname}}</label>
                    <label>供应商：{{supplier.name}}</label>
                </p>
                <p>
                    <label>所属项目：所属项目</label>
                    <label>单据类型：单据类型</label>
                </p>
                <p>
                    <label>请款金额合计：{{applyPrice}}</label>
                </p>
            </div>
        </div>
        <div class="mui-card-footer">
            <div class="mui-pull-left">
                <label>{{purchaseOrder_departUser}}</label>
                <label>{{purchaseOrder_departDate}}</label>
            </div>
            <div>
                <button type="button" class="mui-btn mui-btn-primary toDetails" value="{{id}}">详情</button>
            </div>
        </div>
    </div>
    {{/each}}
</script>
</body>
</html>