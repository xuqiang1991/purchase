<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
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
    <h1 class="mui-title">采购订单列表</h1>
</header>

<div class="mui-content">
    <div class="mui-card" style="margin: 0px; margin-top: 5px; margin-bottom: 5px; padding-bottom: 5px; text-align: center;">
        <div class="mui-button-row">
            <button type="button" class="mui-btn mui-btn-primary">新建采购订单</button>
        </div>
    </div>
    <!-- 单号、订单类型、供应商、所属项目、合同号、开单人、开单日期、单据状态 -->
    <ul class="mui-table-view" style="z-index: 100">
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
                            <input type="text" placeholder="普通输入框">
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
    <!--下拉刷新容器-->
    <div id="refreshContainer" class="mui-content mui-scroll-wrapper" style="margin-top: 135px;">
        <div class="mui-scroll">
            <!--数据列表-->
            <ul class="mui-table-view mui-table-view-chevron">

            </ul>
        </div>
    </div>
</div>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/mui/js/mui.min.js"></script>
<script type="text/javascript" src="http://apps.bdimg.com/libs/handlebars.js/2.0.0-alpha.4/handlebars.js"></script>
<script type="text/javascript" charset="utf-8">
    var page = 1; //当前页
    var limit = 10; //每页显示条数
    var isOver = false; //是否加载完
    mui.init({
        swipeBack: true, //启用右滑关闭功能
        pullRefresh : {
            container:"#refreshContainer",//下拉刷新容器标识，querySelector能定位的css选择器均可，比如：id、.class等
            down : {
                style:'circle',//必选，下拉刷新样式，目前支持原生5+ ‘circle’ 样式
                color:'#2BD009', //可选，默认“#2BD009” 下拉刷新控件颜色
                height:'50px',//可选,默认50px.下拉刷新控件的高度,
                range:'100px', //可选 默认100px,控件可下拉拖拽的范围
                offset:'0px', //可选 默认0px,下拉刷新控件的起始位置
                auto: true,//可选,默认false.首次加载自动上拉刷新一次
                callback :function () {//必选，刷新函数，根据具体业务来编写，比如通过ajax从服务器获取新数据；
                    var url = '${ctx}/mobile/purchase/getPurchaseList?' + 'limit=' + limit + '&page=' + page;
                    mui.ajax({
                        url: url,
                        data: {},
                        dataType: 'json',
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
                                //匹配json内容
                                var html = template({data});//data
                                //输入模板
                                listTargt.append(html);


                                //判断是否还有数据,若小于每次加载条数,结束
                                if (data.length < limit) {
                                    isOver = true;
                                    refreshContainer.pullRefresh().endPullupToRefresh(true); //停止下拉显示暂无数据
                                }
                                //每次加载结束之后，如果还有数据则++
                                if (isOver == false) {
                                    page++;
                                    refreshContainer.pullRefresh().endPullupToRefresh(true); //停止正在加载
                                    refreshContainer.pullRefresh().enablePullupToRefresh(); //显示上拉加载文字
                                }else {
                                    refreshContainer.pullRefresh().endPullupToRefresh(true); //停止下拉显示暂无数据
                                }
                            }

                        }
                    });
                }
            }
        }
    });
    

</script>
<!-- 采购订单 start -->
<script type="text/template" id="listTpl">
    {{#each data}}
    <div class="mui-card">
        <div class="mui-card-header mui-card-media">
            <img src="${ctx}/images/icon/purchase_order.png">
            <div class="mui-media-body">
                <label>单号:{{purchaseNo}}</label>
                <p>
                    <label>开单人:{{admin.fullname}}</label>&nbsp;
                    <label>开单日期：{{createTime}}</label>
                    <span class="mui-badge mui-badge-primary mui-pull-right">申请中</span>
                </p>
            </div>
        </div>
        <div class="mui-card-content">
            <div class="mui-card-content-inner">
                <p>
                    <label>合同号：{{admin.fullname}}</label>
                    <label>供应商：{{supplier.fullname}}</label>
                </p>
                <p>
                    <label>所属项目：所属项目</label>
                </p>
            </div>
        </div>
        <div class="mui-card-footer">
            <div class="mui-pull-left">
                <label>审核人：张三</label>
                <label>审核日期：2018-08-21</label>
            </div>
            <div>
                <button type="button" class="mui-btn mui-btn-primary">详情</button>
                <button type="button" class="mui-btn mui-btn-primary">审核</button>
            </div>
        </div>
    </div>
    {{/each}}
</script>
<!-- 采购订单 end -->
</body>
</html>