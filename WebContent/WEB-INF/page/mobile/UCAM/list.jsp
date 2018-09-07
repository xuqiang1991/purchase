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
    <h1 class="mui-title">合同外请款单</h1>
</header>

<div class="mui-content">
    <div class="mui-card" style="margin: 0px; margin-top: 5px; margin-bottom: 5px; padding-bottom: 5px; text-align: center;">
        <div class="mui-button-row">
            <button type="button" id="add-btn" class="mui-btn mui-btn-primary">新建合同外请款单</button>
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
    <!-- 合同内请款单 start -->
    <div class="mui-card" style="margin: 0px; margin-top: 5px;">
        <div class="mui-card-header mui-card-media">
            <!-- 订单类型 用图标展示 -->
            <img src="${ctx }/images/icon/uncontract_apply_money.png">un
            <div class="mui-media-body">
                <label>单号:1234567890019847</label>
                <p>
                    <label>开单人:张三</label>&nbsp;
                    <label>开单日期：2018-08-21</label>
                    <span class="mui-badge mui-badge-primary mui-pull-right">申请中</span>
                </p>
            </div>
        </div>
        <div class="mui-card-content">
            <div class="mui-card-content-inner">
                <p>
                    <label>合同号：1234567890019847</label>
                    <label>供应商：xxxxXXXXXX</label>
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
                <button type="button" class="mui-btn mui-btn-primary" onclick="details()">详情</button>
                <button type="button" class="mui-btn mui-btn-primary">审核</button>
            </div>
        </div>
    </div>
    <!-- 合同内请款单 end -->
</div>
<script src="${ctx}/mui/js/mui.min.js"></script>
<script type="text/javascript" charset="utf-8">
    mui.init({
        swipeBack: true //启用右滑关闭功能
    });
    var ctx = '${ctx }';

    mui(document.body).on('tap', '#add-btn', function(e) {
        document.location.href = ctx + '/mobile/UCAM/ucamDetails';
    });
</script>
</body>
</html>