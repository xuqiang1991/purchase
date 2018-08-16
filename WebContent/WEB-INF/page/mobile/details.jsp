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
<div class="mui-content">
    <div class="mui-content-padded" style="margin: 5px;">

        <!--<div class="mui-input-row mui-search">
            <input type="search" class="mui-input-clear" placeholder="" data-input-clear="1" data-input-search="1"><span class="mui-icon mui-icon-clear mui-hidden"></span><span class="mui-placeholder"><span class="mui-icon mui-icon-search"></span><span></span></span>
        </div>-->
        <!--<h5 class="mui-plus-visible">语音输入搜索框：</h5>
        <div class="mui-input-row mui-search mui-plus-visible">
            <input id="search" type="search" class="mui-input-speech mui-input-clear" placeholder="" data-input-clear="2" data-input-speech="2" data-input-search="2"><span class="mui-icon mui-icon-clear mui-hidden"></span><span class="mui-icon mui-icon-speech"></span><span class="mui-placeholder"><span class="mui-icon mui-icon-search"></span><span>带语音输入的搜索框</span></span>
        </div>-->
        <!--<h5>密码框：</h5>
        <div class="mui-input-row mui-password">
            <input type="password" class="mui-input-password" data-input-password="3"><span class="mui-icon mui-icon-eye"></span>
        </div>-->
        <form class="mui-input-group">
            <div class="mui-input-row">
                <label>采购订单号</label>
                <input type="text" readonly="readonly" placeholder="PC20180817001">
            </div>
            <div class="mui-input-row">
                <label>采购内容</label>
                <input type="text" placeholder="请输入">
            </div>
            <div class="mui-input-row">
                <label>采购数量</label>
                <input type="number" placeholder="请输入数字">
            </div>
            <div class="mui-input-row">
                <label>单价(元)</label>
                <input type="number" style="color: red;" placeholder="请输入金额">
            </div>
            <div class="mui-input-row">
                <label>我可以清除</label>
                <input type="text" class="mui-input-clear" placeholder="带清除按钮的输入框" data-input-clear="5"><span class="mui-icon mui-icon-clear mui-hidden"></span>
            </div>
            <!--<div class="mui-input-row">
                <label>备注意见</label>
                <textarea id="textarea" rows="5" placeholder="备注意见"></textarea>
            </div>-->
            <!--<div class="mui-input-row" data-numbox-step='1' data-numbox-min='0' data-numbox-max='100'>
                <label>数量</label>
                <div class="mui-numbox">
                  <button class="mui-btn mui-numbox-btn-minus" type="button">-</button>
                  <input class="mui-numbox-input" type="number" />
                  <button class="mui-btn mui-numbox-btn-plus" type="button">+</button>
                </div>
            </div>-->


            <!--<div class="mui-input-row mui-plus-visible">
                <label>Input</label>
                <input type="text" class="mui-input-speech mui-input-clear" placeholder="语音输入" data-input-clear="6" data-input-speech="6"><span class="mui-icon mui-icon-clear mui-hidden"></span><span class="mui-icon mui-icon-speech"></span>
            </div>-->

        </form>
        <div class="mui-input-row" style="margin: 10px 5px;">
            <textarea id="textarea" rows="5" placeholder="备注意见"></textarea>
        </div>
        <div class="mui-button-row">
            <button type="button" class="mui-btn mui-btn-primary" onclick="return false;">同意</button>&nbsp;&nbsp;
            <button type="button" class="mui-btn mui-btn-danger" onclick="return false;">驳回</button>
        </div>
    </div>
</div>
<script src="${ctx }/mui/js/mui.min.js"></script>
<script type="text/javascript" charset="utf-8">
    mui.init({
        swipeBack:true //启用右滑关闭功能
    });
</script>
</body>
</html>