<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	<title></title>
	<link href="${ctx }/mui/css/mui.min.css" rel="stylesheet"/>
    <link href="${ctx }/mui/css/iconfont.css" rel="stylesheet"/>
</head>
<body>
<header class="mui-bar mui-bar-nav">
    <a class="mui-icon mui-icon-bars mui-pull-left mui-plus-visible"></a>
    <h1 class="mui-title">订单管理</h1>
</header>
<div class="mui-content">
    <ul class="mui-table-view mui-grid-view mui-grid-9">
        <shiro:hasPermission name="mobile:purchase:list">
            <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-6"><a href="${ctx }/mobile/purchase/list">
                <span class="mui-icon iconfont icon-zhengchangcaigoudingdan icon-color-F0AD4E"></span>
                <div class="mui-media-body">采购订单</div>
            </a></li>
        </shiro:hasPermission>
        <shiro:hasPermission name="mobile:CAM:list">
            <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-6"><a href="${ctx }/mobile/CAM/list">
                <span class="mui-icon iconfont icon-request-consult icon-color-F0AD4E"></span>
                <div class="mui-media-body">合同内请款</div>
            </a></li>
        </shiro:hasPermission>
        <shiro:hasPermission name="mobile:UCAM:list">
            <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-6"><a href="${ctx }/mobile/UCAM/list">
                <span class="mui-icon iconfont icon-kuanxiangguanli icon-color-F0AD4E"></span>
                <div class="mui-media-body">合同外请款</div>
            </a></li>
        </shiro:hasPermission>
        <shiro:hasPermission name="mobile:paymentOrder:list">
            <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-6"><a href="${ctx }/mobile/paymentOrder/list">
                <span class="mui-icon iconfont icon-zuocedaohang_shoufukuanxiang icon-color-F0AD4E"></span>
                <div class="mui-media-body">付款</div>
            </a></li>
        </shiro:hasPermission>
        <shiro:hasPermission name="mobile:programmeAcceptance:list">
            <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-6"><a href="${ctx }/mobile/programmeAcceptance/list">
                <span class="mui-icon iconfont icon-yanshou icon-color-F0AD4E"></span>
                <div class="mui-media-body">工程验收</div>
            </a></li>
        </shiro:hasPermission>
        <shiro:hasPermission name="mobile:biddingManagement:list">
            <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-6"><a href="#">
                <span class="mui-icon iconfont icon-toubiaoguanli1 icon-color-F0AD4E"></span>
                <div class="mui-media-body">投标管理</div>
            </a></li>
        </shiro:hasPermission>
        <%--<li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-6"><a href="#">
            <span class="mui-icon mui-icon-more"></span>
            <div class="mui-media-body">more</div>
        </a></li>--%>
    </ul>
</div>
<script src="${ctx }/js/jquery-1.11.1.js"></script>
<script src="${ctx }/mui/js/mui.min.js"></script>
<script type="text/javascript" charset="utf-8">
    mui.init({
        swipeBack:true //启用右滑关闭功能
    });
</script>
</body>
</html>