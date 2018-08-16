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
    <link href="${ctx }/mui/css/iconfont.css" rel="stylesheet"/>
</head>
<body>

<header class="mui-bar mui-bar-nav">
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
    <h1 class="mui-title">采购订单</h1>
</header>

<div class="mui-content" style="margin: 5px;">
    <!--<div class="mui-input-row mui-search">
        <input type="search" class="mui-input-clear" placeholder="" data-input-clear="1" data-input-search="1">
        <span class="mui-icon mui-icon-clear mui-hidden"></span>
        <span class="mui-placeholder">
            <span class="mui-icon mui-icon-search"></span>
            <span>
                fdsafdsa
            </span>
        </span>
    </div>-->
    <div class="mui-input-row mui-search">
        <input type="search" class="mui-input-clear" placeholder="">
    </div>
    <ul class="mui-table-view mui-table-view-striped mui-table-view-condensed">
        <li class="mui-table-view-cell">
            <a href="${ctx }/mobile/details">
                <div class="mui-table">
                    <div class="mui-table-cell mui-col-xs-10">
                        <h4 class="mui-ellipsis">采购订单采购订单采购订单采购订单采购订单采购订单采购订单</h4>
                        <h5>申请人：申请人</h5>
                        <p class="mui-h6 mui-ellipsis">详细内容</p>
                    </div>
                    <div class="mui-table-cell mui-col-xs-5 mui-text-right">
                        <span class="mui-h5">2018/08/16 23:50</span>
                    </div>
                </div>
                <span class="mui-badge mui-badge-primary">申请中</span>
            </a>
        </li>
        <li class="mui-table-view-cell">
            <a href="${ctx }/mobile/details">
                <div class="mui-table">
                    <div class="mui-table-cell mui-col-xs-10">
                        <h4 class="mui-ellipsis">采购订单采购订单采购订单采购订单采购订单采购订单采购订单</h4>
                        <h5>申请人：申请人</h5>
                        <p class="mui-h6 mui-ellipsis">详细内容</p>
                    </div>
                    <div class="mui-table-cell mui-col-xs-5 mui-text-right">
                        <span class="mui-h5">2018/08/16 23:50</span>
                    </div>
                </div>
                <span class="mui-badge mui-badge-success">已通过</span>
            </a>
        </li>
        <li class="mui-table-view-cell">
            <a href="${ctx }/mobile/details">
                <div class="mui-table">
                    <div class="mui-table-cell mui-col-xs-10">
                        <h4 class="mui-ellipsis">采购订单采购订单采购订单采购订单采购订单采购订单采购订单</h4>
                        <h5>申请人：申请人</h5>
                        <p class="mui-h6 mui-ellipsis">详细内容</p>
                    </div>
                    <div class="mui-table-cell mui-col-xs-5 mui-text-right">
                        <span class="mui-h5">2018/08/16 23:50</span>
                    </div>
                </div>
                <span class="mui-badge">失败</span>
            </a>
        </li>
    </ul>
</div>
<script src="${ctx }/mui/js/mui.min.js"></script>
<script type="text/javascript" charset="utf-8">
    mui.init({
        swipeBack:true //启用右滑关闭功能
    });
</script>
</body>
</html>