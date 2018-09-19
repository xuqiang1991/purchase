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
        <input type="hidden" name="purchaseNo" id="purchaseNo" value="${detailsVo.purchaseOrder.purchaseNo}">
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

    <!-- 采购单项 start -->
    <div id="refreshContainer" class="mui-content" style="margin-top: 20px;width: 100%;">
        <div class="mui-scroll">
            <c:forEach items="${detailsVo.details}" var="item">
            <div class="mui-card">
                <div class="mui-card-header mui-card-media">
                    <!-- 订单类型 用图标展示 -->
                    <img src="${ctx }/images/icon/contract_apply_money.png">
                    <div class="mui-media-body">
                        <label>材料/项目内容</label>
                        <p>
                                ${item.content}
                        </p>
                    </div>
                </div>
                <div class="mui-card-content">
                    <div class="mui-card-content-inner">
                        <p>
                            <label>单价:${item.price}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <label>规格：${item.model}</label>
                        </p>
                        <p>
                            <label>单位：${item.unit}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <label>数量：${item.amount}</label>
                        </p>
                        <p>
                            <label>质保期（月）：${item.warrantyDate}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <label>日期：<fmt:formatDate value="${item.date}" pattern="yyyy-MM-dd"/></label>
                        </p>
                    </div>
                </div>
                <div class="mui-card-footer">
                    <div class="mui-pull-left">
                        <label>总金额：${item.totalPrice}</label>&nbsp;&nbsp;
                        <label>已結算数量：${item.settleAmout}</label>
                    </div>
                    <div>
                        <button type="button" class="mui-btn mui-btn-primary" onclick="details()">刪除</button>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
    <!-- 采购单项 end -->

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
                        <label>材料/项目内容</label>
                        <input type="text" name="content" class="mui-input-clear" mui-verify="required">
                    </div>
                    <div class="mui-input-row">
                        <label>规格型号</label>
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
                    <div class="mui-input-row">
                        <label>质保期（月）</label>
                        <input type="text" name="warrantyDate" class="mui-input-clear" mui-verify="required">
                    </div>
                    <div class="mui-input-row">
                        <label>日期</label>
                        <input type="text" name="date" class="mui-input-clear" mui-verify="required">
                    </div>
                    <div>
                        <textarea name="remark" id="remark" rows="5" class="mui-input-clear" placeholder="备注"></textarea>
                    </div>
                    <div class="mui-button-row" style="padding-bottom: 20px;">
                        <button type="button" class="mui-btn mui-btn-primary" onclick="addfromPurchaseOrderItem()">添加</button>
                    </div>
                </form>
            </div>
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

    function addfromPurchaseOrderItem(){
        var check = true;
        mui("#addFromPurchaseOrderItem input").each(function() {
            //若当前input为空，则alert提醒
            var verify = $(this).attr("mui-verify")
            if(verify == 'required'){
                if(!this.value || this.value.trim() == "") {
                    var label = this.previousElementSibling;
                    mui.alert(label.innerText + "不允许为空");
                    check = false;
                    return false;
                }
            }
        });

        //校验通过，继续执行业务逻辑
        if(check){
            var purchaseNo = $('#purchaseNo').val();
            var url = '${ctx}/mobile/purchase/addPurchaseOrderItem/'+ purchaseNo
            $.ajax({
                url: url,
                data: $('#addFromPurchaseOrderItem').serialize(),
                dataType: 'json',
                contentType : "application/x-www-form-urlencoded",
                type: 'post',
                timeout: 10000,
                success: function(result) {
                    if(result.code!=0){
                        mui.alert(data.msg);
                    }else {
                        mui.alert("添加成功！");
                        document.location.href='${ctx }/mobile/purchase/toDetails/' + ${detailsVo.purchaseOrder.id};
                    }
                }
            });
        }else{
            mui.toast('检验不通过，请重新填写！',{ duration:'long', type:'div' })
        }
    }

</script>
</body>
</html>