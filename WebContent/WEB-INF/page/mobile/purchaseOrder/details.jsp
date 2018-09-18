<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title></title>
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
        <button type="button" class="mui-left mui-action-back mui-btn  mui-btn-link mui-btn-nav mui-pull-left">
            <span class="mui-icon mui-icon-left-nav"></span>
        </button>
        <h1 class="mui-center mui-title">采购订单详情</h1>
    </div>

    <!-- 主界面具体展示内容 -->
    <div class="mui-content-padded mui-card" style="margin: 5px;">
        <div class="mui-input-row">
            <label>合同编号</label>
            <label style="width: 65%;padding-left: 0px;">${detailsVo.purchaseOrder.purchaseNo}</label>
        </div>
        <div class="mui-input-row">
            <label>订单类型</label>
            <label style="width: 65%;padding-left: 0px;">${detailsVo.purchaseOrder.type}</label>
        </div>
        <div class="mui-input-row">
            <label>供应商</label>
            <label style="width: 65%;padding-left: 0px;">${detailsVo.purchaseOrder.supplier.name}</label>
        </div>
        <div class="mui-input-row">
            <label>所属项目</label>
            <label style="width: 65%;padding-left: 0px;">${detailsVo.purchaseOrder.projectId}</label>
        </div>
        <div class="mui-input-row">
            <label>合同总金额</label>
            <label style="width: 65%;padding-left: 0px;">${detailsVo.purchaseOrder.contractMoney}</label>
        </div>
        <div class="mui-input-row mui-input-range">
            <label>付款比例(%)</label>
            <label style="width: 65%;padding-left: 0px;">${detailsVo.purchaseOrder.paymentRatio}%</label>
        </div>
        <div>
            <textarea name="summary" id="summary" rows="5" class="mui-input-clear" readonly="readonly">${detailsVo.purchaseOrder.summary}</textarea>
        </div>
        <div class="mui-button-row" style="padding-bottom: 20px;">
            <a href="#fromPurchaseOrderItem">
                <label id="selectProjectText" style="width: 65%;padding-left: 0px;">增加采购单项</label>
            </a>
        </div>
    </div>

</div>


<div id="fromPurchaseOrderItem" class="mui-page">
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <button type="button" class="mui-left mui-action-back mui-btn  mui-btn-link mui-btn-nav mui-pull-left">
            <span class="mui-icon mui-icon-left-nav"></span>返回
        </button>
        <h1 class="mui-center mui-title">增加采购单项</h1>
    </div>
    <div class="mui-page-content">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll"  style="height: 100%;">
                <form class="mui-input-group" id="addFromPurchaseOrderItem">
                    <div class="mui-input-row">
                        <label>规格</label>
                        <input type="text" name="model" class="mui-input-clear" mui-verify="required">
                    </div>
                    <div class="mui-input-row">
                        <label>单位</label>
                        <input type="text" name="unit" class="mui-input-clear" mui-verify="required">
                    </div>
                    <div class="mui-input-row">
                        <label>单价</label>
                        <input type="text" name="price" class="mui-input-clear" mui-verify="required">
                    </div>
                    <div class="mui-input-row">
                        <label>数量</label>
                        <input type="text" name="amount" class="mui-input-clear" mui-verify="required">
                    </div>
                    <div>
                        <textarea name="remark" id="remark" rows="5" class="mui-input-clear" placeholder="备注"></textarea>
                    </div>
                    <div class="mui-button-row" style="padding-bottom: 20px;">
                        <button type="button" class="mui-btn mui-btn-primary" onclick="submitPurchaseOrder()">提交</button>
                    </div>
                </form>
        </div>

    </div>
</div>


<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/mui/js/mui.min.js"></script>
<script src="${ctx }/mui/js/mui.picker.min.js"></script>
<script src="${ctx }/mui/js/mui.view.js"></script>
<script type="text/javascript" src="http://apps.bdimg.com/libs/handlebars.js/2.0.0-alpha.4/handlebars.js"></script>
<script type="text/javascript" charset="utf-8">
    mui.init();
    //初始化单页view
    var viewApi = mui('#app').view({
        defaultPage: '#setting'
    });

    function addfromPurchaseOrderItem(flag,callText,callValue){
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

</script>
</body>
</html>