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
    <style type="text/css">
        #div {
            width: 0px;
            height: 0px;
            background: red;
            position: fixed;
            top: 70%;
            left: 50%;
        }
        /*移除底部或顶部三角,需要在删除此代码*/
        .mui-popover .mui-popover-arrow:after {
            width: 0px;
        }
    </style>
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
            <label>合同号</label>
            <label style="width: 65%;padding-left: 0px;">${detailsVo.purchaseOrder.contractNo}</label>
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
        <c:if test="${detailsVo.purchaseOrder.status == 0}">
            <div class="mui-button-row" style="padding-bottom: 20px;">
                <a href="#fromPurchaseOrderItem">
                    <label id="selectProjectText" style="width: 65%;padding-left: 0px;">增加采购单项</label>
                </a>
            </div>
        </c:if>
    </div>

    <!-- 采购单项 start -->
    <div id="refreshContainer" class="mui-content mui-scroll-wrapper" style="margin-top: 380px;width: 100%;">
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
                        <c:if test="${detailsVo.purchaseOrder.status == 0}">
                            <div>
                                <button type="button" class="mui-btn mui-btn-primary" id="deleteItem" value="${item.id}">刪除</button>
                            </div>
                        </c:if>
                    </div>
                </div>
            </c:forEach>
            <div class="mui-content-padded">
                <c:choose>
                    <c:when test="${detailsVo.purchaseOrder.status == 0}">
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="purchaseOrderDetails">提交</button>
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="deletePurchaseOrder" value="${detailsVo.purchaseOrder.id}">删除</button>
                    </c:when>
                    <c:when test="${detailsVo.purchaseOrder.status == 1 && empty detailsVo.purchaseOrder.costDepartUser && empty detailsVo.reviewUserId}">
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="submitReviewPurchaseOrder">选择审核人</button>
                    </c:when>
                    <c:when test="${!empty detailsVo.reviewUserId}">
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="reviewPurchaseOrder">审核</button>
                    </c:when>
                </c:choose>
                <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="purchaseOrderContractNo" value="${detailsVo.purchaseOrder.id}">填写合同号</button>
            </div>
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
                        <button type="button" class="mui-btn mui-btn-primary" id="submitFromPurchaseOrderItem">添加</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div id="div"></div>
<div id="popover" class="mui-popover" style="height: 270px;">
    <div class="mui-popover-arrow"></div>
    <div class="mui-scroll-wrapper">
        <div class="mui-scroll"  style="height: 100%;">
            <form class="mui-input-group" id="reviewPurchaseOrderForm">
                <div class="mui-input-row">
                    <label style="width: 120px;">审核结果</label>
                    <input type="text" id="selectAuditResults" placeholder="请选择审核结果" style="float: left;width: 150px;">
                    <input type="hidden" id="auditResults" name="auditResults">
                </div>
                <div class="mui-input-row">
                    <label style="width: 120px;">上级审核人</label>
                    <input type="text" id="selectApplyUser" placeholder="请选择请款人" style="float: left;width: 150px;">
                    <input type="hidden" id="applyUser" name="applyUser">
                </div>
                <div class="mui-input-row" style="height: auto">
                    <textarea name="auditOpinion" id="auditOpinion" rows="5" class="mui-input-clear" placeholder="审核意见"></textarea>
                </div>
                <div class="mui-button-row" style="padding-bottom: 20px;">
                    <button type="button" class="mui-btn mui-btn-primary" id="reviewPurchaseOrderButton">审核</button>
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

    mui('.mui-scroll-wrapper').scroll();

    /** 提交项 **/
    mui(document.body).on('tap', '#submitFromPurchaseOrderItem', function(e) {
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
                        mui.alert(result.msg);
                    }else {
                        mui.alert('添加成功！', function() {
                            document.location.href='${ctx }/mobile/purchase/toDetails/${detailsVo.purchaseOrder.id}';
                        });
                    }
                }
            });
        }else{
            mui.toast('检验不通过，请重新填写！',{ duration:'long', type:'div' })
        }
    });

    /** 删除采购单 **/
    mui(document.body).on('tap', '#deletePurchaseOrder', function(e) {
        var id = this.value;
        var btnArray = ['是', '否'];
        mui.confirm('确认删除此采购单？', '删除采购单', btnArray, function(e) {
            if (e.index == 0) {
                var url = '${ctx}/mobile/purchase/delPurchaseOrder?id='+ id
                $.ajax({
                    url: url,
                    dataType: 'json',
                    contentType : "application/x-www-form-urlencoded",
                    type: 'post',
                    timeout: 10000,
                    success: function(result) {
                        if(result.code!=0){
                            mui.alert(result.msg);
                        }else {
                            mui.alert('删除成功！', function() {
                                document.location.href='${ctx }/mobile/purchase/list';
                            });
                        }
                    }
                });
            }
        })
    });

    /** 填写合同号 **/
    mui(document.body).on('tap', '#purchaseOrderContractNo', function(e) {
        var btnArray = ['取消', '确定'];
        var id = this.value;
        mui.prompt('请输入采购单合同号', '请输入合同号', '采购单合同号', btnArray, function(e1) {
            if (e1.index == 1) {
                var contractNo = e1.value;
                if(contractNo == '' || contractNo.trim() == ''){
                    mui.alert('请填写合同号！');
                    return false
                }else {
                    var url = '${ctx}/mobile/purchase/purchaseOrderContractNo/'+ id + '?contractNo=' + contractNo;
                    $.ajax({
                        url: url,
                        dataType: 'json',
                        contentType : "application/x-www-form-urlencoded",
                        type: 'post',
                        timeout: 10000,
                        success: function(result) {
                            if(result.code!=0){
                                mui.alert(result.msg);
                            }else {
                                mui.alert('添加成功！', function() {
                                    document.location.href='${ctx }/mobile/purchase/toDetails/${detailsVo.purchaseOrder.id}';
                                });
                            }
                        }
                    });
                }
            }
        })
    });

    /** 删除项 **/
    mui(document.body).on('tap', '#deleteItem', function(e) {
        var itemId = this.value;
        var btnArray = ['是', '否'];
        mui.confirm('确认删除此项？', '删除项', btnArray, function(e) {
            if (e.index == 0) {
                var url = '${ctx}/mobile/purchase/deletePurchaseOrderItem/'+ itemId
                $.ajax({
                    url: url,
                    dataType: 'json',
                    contentType : "application/x-www-form-urlencoded",
                    type: 'post',
                    timeout: 10000,
                    success: function(result) {
                        if(result.code!=0){
                            mui.alert(result.msg);
                        }else {
                            mui.alert('删除成功！', function() {
                                document.location.href='${ctx }/mobile/purchase/toDetails/${detailsVo.purchaseOrder.id}';
                            });
                        }
                    }
                });
            }
        })
    });

    /** 提交审核 **/
    mui(document.body).on('tap', '#purchaseOrderDetails', function(e) {
        var btnArray = ['是', '否'];
        mui.confirm('确认提交？', '提交采购单', btnArray, function(e) {
            if (e.index == 0) {
                var url = '${ctx}/mobile/purchase/submitPurchaseOrder?id=${detailsVo.purchaseOrder.id}';
                $.ajax({
                    url: url,
                    dataType: 'json',
                    contentType : "application/x-www-form-urlencoded",
                    type: 'post',
                    timeout: 10000,
                    success: function(result) {
                        if(result.code!=0){
                            mui.alert(result.msg);
                        }else {
                            mui.alert('提交成功！', function() {
                                document.location.href='${ctx }/mobile/purchase/toDetails/${detailsVo.purchaseOrder.id}';
                            });
                        }
                    }
                });
            }
        })
    });

    /** 选择审核人 **/
    mui(document.body).on('tap', '#submitReviewPurchaseOrder', function(e) {
        var adminsJson = '${detailsVo.departs}'
        var json =JSON.parse(adminsJson)
        var userPicker = new mui.PopPicker();
        userPicker.setData(json);
        userPicker.show(function (selectItems) {
            var text = selectItems[0].text;
            mui.alert('确定提审核人为：' + text + "？" , function() {
                var userId = selectItems[0].value;
                var url = '${ctx}/mobile/purchase/submitReviewPurchaseOrder?id=${detailsVo.purchaseOrder.id}&userId=' + userId;
                $.ajax({
                    url: url,
                    dataType: 'json',
                    contentType : "application/x-www-form-urlencoded",
                    type: 'post',
                    timeout: 10000,
                    success: function(result) {
                        if(result.code!=0){
                            mui.alert(result.msg);
                        }else {
                            mui.alert('提交审核成功！', function() {
                                document.location.href='${ctx }/mobile/purchase/toDetails/${detailsVo.purchaseOrder.id}';
                            });
                        }
                    }
                });
            });

        });
    });


    /** 审核 **/
    mui(document.body).on('tap', '#reviewPurchaseOrder', function(e) {
        mui("#popover").popover('toggle', document.getElementById("div"));
    });

    mui(document.body).on('tap', '#selectApplyUser', function(e) {
        var adminsJson = '${detailsVo.departs}'
        var json =JSON.parse(adminsJson)
        var userPicker = new mui.PopPicker();
        userPicker.setData(json);
        var selectApplyUser = document.getElementById('selectApplyUser');
        var applyUser = document.getElementById('applyUser');
        userPicker.show(function (items) {
            selectApplyUser.value = items[0].text;
            applyUser.value = items[0].value;
        });
    });
    mui(document.body).on('tap', '#selectAuditResults', function(e) {
        var adminsJson = '[{"text":"审核不通过","value":"0"},{"text":"审核通过","value":"1"}]';
        var json =JSON.parse(adminsJson)
        var userPicker = new mui.PopPicker();
        userPicker.setData(json);
        var selectAuditResults = document.getElementById('selectAuditResults');
        var auditResults = document.getElementById('auditResults');
        userPicker.show(function (items) {
            selectAuditResults.value = items[0].text;
            auditResults.value = items[0].value;
        });
    });

    mui(document.body).on('tap', '#reviewPurchaseOrderButton', function(e) {

        var auditResults =  mui("#auditResults");
        if(!auditResults.value || auditResults.value.trim() == "") {
            var label = auditResults.previousElementSibling;
            mui.alert(label.innerText + "不允许为空");
            return false;
        }

        var applyUser =  mui("#auditResults");
        if(!applyUser.value || applyUser.value.trim() == "") {
            var label = applyUser.previousElementSibling;
            mui.alert(label.innerText + "不允许为空");
            return false;
        }

        var auditOpinion =  mui("#auditOpinion");
        if(!auditOpinion.value || auditOpinion.value.trim() == "") {
            var label = auditOpinion.previousElementSibling;
            mui.alert(label.innerText + "不允许为空");
            return false;
        }

        mui.alert('确定提交审核？' , function() {
            var url = '${ctx}/mobile/purchase/reviewPurchaseOrder/${detailsVo.purchaseOrder.id}';
            $.ajax({
                url: url,
                data:{'auditResults':auditResults,'applyUser':applyUser,'auditOpinion': auditOpinion},
                dataType: 'json',
                contentType : "application/x-www-form-urlencoded",
                type: 'post',
                timeout: 10000,
                success: function(result) {
                    if(result.code!=0){
                        mui.alert(result.msg);
                    }else {
                        mui.alert('审核成功！', function() {
                            document.location.href='${ctx }/mobile/purchase/toDetails/${detailsVo.purchaseOrder.id}';
                        });
                    }
                }
            });
        });
    });





    //初始化数据
    mui.ready(function() {
        //供应商
        var url = '${ctx}/supplier/findSuppliersAll';
        $.ajax({
            url: url, dataType: 'json',   contentType : "application/x-www-form-urlencoded",  type: 'post', timeout: 10000,
            success: function(result) {
                if(result != null && result.length != 0){

                }
            }
        });
    });

    function submitPurchaseOrderReview(json){
        var userPicker = new mui.PopPicker();
        userPicker.setData(json);
        var supplierName = document.getElementById('supplierName');
        var supplierId = document.getElementById('supplierId');
        supplierName.addEventListener('tap', function(event) {
            userPicker.show(function(items) {
                supplierName.value = items[0].text;
                supplierId.value = items[0].value;
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);
    }

</script>
</body>
</html>