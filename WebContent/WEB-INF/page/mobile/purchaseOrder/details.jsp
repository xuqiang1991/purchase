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
        /*移除底部或顶部三角,需要在删除此代码*/
        .mui-popover .mui-popover-arrow:after {
            width: 0px;
        }
        .mui-input-row label{
            width: 40%;
        }
        .mui-input-row label~input{
            width: 60%;
        }
        .mui-input-row label~label{
            width: 60%;
            padding: 11px 0px;
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

    <!-- 采购明细 start -->
    <div id="refreshContainer" class="mui-content mui-scroll-wrapper" style="margin-top: 0px;width: 100%;">
        <div class="mui-scroll">
            <div class="mui-content" style="margin-left: 5px; margin-right: 5px; font-size: 14px;">
                <ul class="mui-table-view">
                    <li class="mui-table-view-cell mui-collapse">
                        <a class="mui-navigate-right" href="#">采购单详情:${detailsVo.purchaseOrder.purchaseNo}</a>
                        <div class="mui-collapse-content">
                            <!-- 主界面具体展示内容 -->
                                <input type="hidden" name="purchaseNo" id="purchaseNo" value="${detailsVo.purchaseOrder.purchaseNo}">
                                <div class="mui-input-row">
                                    <label>合同编号</label>
                                    <label>${detailsVo.purchaseOrder.purchaseNo}</label>
                                </div>
                                <div class="mui-input-row">
                                    <label>订单类型</label>
                                    <label>${detailsVo.type}</label>
                                </div>
                                <div class="mui-input-row">
                                    <label>供应商</label>
                                    <label>${detailsVo.purchaseOrder.supplier.name}</label>
                                </div>
                                <div class="mui-input-row">
                                    <label>所属项目</label>
                                    <label>${detailsVo.purchaseOrder.projectManger.name}</label>
                                </div>
                                <div class="mui-input-row">
                                    <label>合同号</label>
                                    <label>${detailsVo.purchaseOrder.contractNo}</label>
                                </div>
                                <div class="mui-input-row">
                                    <label>合同总金额</label>
                                    <label>${detailsVo.purchaseOrder.contractMoney}</label>
                                </div>
                                <div class="mui-input-row">
                                    <label>已请款金额</label>
                                    <label>${detailsVo.purchaseOrder.requestAmount}</label>
                                </div>
                                <div class="mui-input-row">
                                    <label>已付款金额</label>
                                    <label>${detailsVo.purchaseOrder.paymentAmount}</label>
                                </div>
                                <div class="mui-input-row mui-input-range">
                                    <label>付款比例(%)</label>
                                    <label>${detailsVo.purchaseOrder.paymentRatio}%</label>
                                </div>
                                <div>
                                    <textarea name="summary" id="summary" rows="5" class="mui-input-clear" readonly="readonly">${detailsVo.purchaseOrder.summary}</textarea>
                                </div>
                        </div>
                    </li>

                    <!-- 审核状态 -->
                    <c:set value="${detailsVo.purchaseOrder.historyList}" var="historyList"/>
                    <%@ include file="/WEB-INF/page/mobile/common/reviewHistory.jsp"%>

                    <li class="mui-table-view-cell mui-collapse mui-active">
                        <a class="mui-navigate-right" href="#">采购单明细</a>
                        <div class="mui-collapse-content">
                            <c:choose>
                                <c:when test="${fn:length(detailsVo.details) > 0}">
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
                                                        <label>规格：${item.model}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <label>单位：${item.unit}</label>
                                                    </p>
                                                    <p>
                                                        <label>单价:${item.price}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <label>数量：${item.amount}</label>
                                                    </p>
                                                    <p>
                                                        <c:if test="${detailsVo.purchaseOrder.type == 1}">
                                                            <label>质保期（月）：${item.warrantyDate}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                                                        </c:if>
                                                        <c:if test="${detailsVo.purchaseOrder.type == 2}">
                                                        <label>日期：<fmt:formatDate value="${item.date}" pattern="yyyy-MM-dd"/></label>
                                                        </c:if>
                                                    </p>
                                                    <p>
                                                        <label>金额：${item.totalPrice}</label>&nbsp;&nbsp;
                                                        <label>已結算数量：${item.settleAmout}</label>
                                                    </p>
                                                </div>
                                            </div>
                                            <div class="mui-card-footer">
                                                <c:if test="${detailsVo.purchaseOrder.status == 0 && detailsVo.purchaseOrder.createUser == admin.id}">
                                                    <div>
                                                        <a href="#fromPurchaseOrderItem" name="app-a" data-id="${item.id}">
                                                            <button type="button" class="mui-btn mui-btn-primary" value="${item.id}">修改</button>
                                                        </a>
                                                    </div>
                                                    <div>
                                                        <button type="button" class="mui-btn mui-btn-primary" id="deleteItem" value="${item.id}">刪除</button>
                                                    </div>
                                                </c:if>
                                            </div>
                                        </div>
                                    </c:forEach>
                                 </c:when>
                                 <c:otherwise>
                                    <div class="mui-input-row">
                                        <label>无采购单明细</label>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="mui-content-padded">
                <c:choose>
                    <c:when test="${detailsVo.purchaseOrder.status == 0 && detailsVo.purchaseOrder.createUser == admin.id}">
                        <a href="#fromPurchaseOrderItem">
                            <button type="button" class="mui-btn mui-btn-primary mui-btn-block">增加采购明细</button>
                        </a>
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="purchaseOrderDetails">提交</button>
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="deletePurchaseOrder" value="${detailsVo.purchaseOrder.id}">删除</button>
                    </c:when>
                    <%--<c:when test="${detailsVo.purchaseOrder.status == 1 && empty detailsVo.purchaseOrder.costDepartUser && empty detailsVo.reviewUserId}">--%>
                        <%--<button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="submitReviewPurchaseOrder">选择审核人</button>--%>
                    <%--</c:when>--%>
                    <c:when test="${detailsVo.reviewUserId == admin.id}">
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="reviewPurchaseOrder">审核</button>
                    </c:when>
                </c:choose>
                <c:if test="${!empty admin.roleNames && fn:contains(admin.roleNames,'资料员')}">
                    <button type="button" class="mui-btn mui-btn-primary mui-btn-block" id="purchaseOrderContractNo" value="${detailsVo.purchaseOrder.id}">填写合同号</button>
                </c:if>
            </div>
        </div>
    </div>
    <!-- 采购明细 end -->
</div>


<div id="fromPurchaseOrderItem" class="mui-page">
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <button type="button" class="mui-left mui-action-back mui-btn  mui-btn-link mui-btn-nav mui-pull-left">
            <span class="mui-icon mui-icon-left-nav"></span>返回
        </button>
        <h1 class="mui-center mui-title">增加采购明细</h1>
    </div>
    <div class="mui-page-content">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll"  style="height: 100%;">
                <form class="mui-input-group" id="addFromPurchaseOrderItem">
                    <%--<input type="hidden" id="purchaseNo" name="purchaseNo" value="${detailsVo.purchaseOrder.purchaseNo}">--%>
                    <input type="hidden" id="id" name="id" value="">
                    <div class="mui-input-row">
                        <label>材料/项目内容</label>
                        <input type="text" name="content" class="mui-input-clear" mui-verify="required" placeholder="请输入材料/项目内容">
                    </div>
                    <div class="mui-input-row">
                        <label>规格型号</label>
                        <input type="text" name="model" class="mui-input-clear" mui-verify="required" placeholder="请输入规格型号">
                    </div>
                    <div class="mui-input-row">
                        <label>单位</label>
                        <input type="text" name="unit" class="mui-input-clear" mui-verify="required" placeholder="请输入单位">
                    </div>
                    <div class="mui-input-row">
                        <label>单价</label>
                        <input type="number" id="price" name="price" class="mui-input-clear" mui-verify="required" placeholder="请输入单价">
                    </div>
                    <div class="mui-input-row">
                        <label>数量</label>
                        <input type="number" id="amount" name="amount" class="mui-input-clear" mui-verify="required" placeholder="请输入数量">
                    </div>
                    <div class="mui-input-row">
                        <label>金额</label>
                        <input type="number" id="totalPrice" name="totalPrice" class="mui-input-clear" mui-verify="required" readonly value="0">
                    </div>
                    <c:if test="${detailsVo.purchaseOrder.type == 1}">
                        <div class="mui-input-row">
                            <label>质保期（月）</label>
                            <input type="number" name="warrantyDate" class="mui-input-clear" mui-verify="required" placeholder="请输入质保期（月）">
                        </div>
                    </c:if>
                    <c:if test="${detailsVo.purchaseOrder.type == 2}">
                        <div class="mui-input-row">
                            <label>日期</label>
                            <input id="dateText" type="text" name="date" class="mui-input-clear" mui-verify="required" data-options='{"type":"date","beginYear":2014}' placeholder="请选择日期">
                        </div>
                    </c:if>
                    <div>
                        <textarea name="remark" id="remark" rows="5" class="mui-input-clear" placeholder="备注"></textarea>
                    </div>
                    <div class="mui-button-row" style="padding-bottom: 20px;">
                        <button type="button" class="mui-btn mui-btn-primary" id="submitFromPurchaseOrderItem">保存</button>
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

    mui('.mui-scroll-wrapper').scroll();

    /** 提交项 **/
    var isSubmit = false;
    mui(document.body).on('tap', '#submitFromPurchaseOrderItem', function(e) {
        if(isSubmit){
            return false;
        }

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
            isSubmit = true
            var purchaseNo = $('#purchaseNo').val();
            var itemId = $('#addFromPurchaseOrderItem').find('#id').val();
            var url = '${ctx}/mobile/purchase/addPurchaseOrderItem/'+ purchaseNo;
            if(itemId && itemId != ''){
                url = '${ctx}/mobile/purchase/editPurchaseOrderItem/'+ purchaseNo;
            }
            $.ajax({
                url: url,
                data: $('#addFromPurchaseOrderItem').serialize(),
                dataType: 'json',
                contentType : "application/x-www-form-urlencoded",
                type: 'post',
                timeout: 10000,
                success: function(result) {
                    if(result.code!=0){
                        isSubmit = false;
                        mui.alert(result.msg);
                    }else {
                        mui.alert('保存成功！', function() {
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

    /** 选择审核人 **/
    mui(document.body).on('tap', '#purchaseOrderDetails', function(e) {
        <c:if test="${fn:length(detailsVo.details) == 0}">
            mui.alert("请先添加明细！");
            return false;
        </c:if>

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


        var appA = document.getElementsByName('app-a');
        if(appA.length > 0){
            for(var i = 0; i < appA.length; i++){
                appA[i].addEventListener('tap', function(event) {
                    var itemId = $(this).attr("data-id");
                    var url = '${ctx}/mobile/purchase/getPurchaseOrderItem/' + itemId;
                    $.ajax({
                        url: url,
                        contentType : "application/x-www-form-urlencoded",
                        type: 'post',
                        timeout: 10000,
                        success: function(result) {
                            if(result.code!=0){
                                alert(result.msg);
                            }else {
                                var data = result.data;
                                $("#addFromPurchaseOrderItem").find("#id").val(data.id);
                                $("#addFromPurchaseOrderItem").find("input[name='purchaseNo']").val(data.purchaseNo);
                                $("#addFromPurchaseOrderItem").find("input[name='content']").val(data.content);
                                $("#addFromPurchaseOrderItem").find("input[name='model']").val(data.model);
                                $("#addFromPurchaseOrderItem").find("input[name='unit']").val(data.unit);
                                $("#addFromPurchaseOrderItem").find("input[name='price']").val(data.price);
                                $("#addFromPurchaseOrderItem").find("input[name='amount']").val(data.amount);
                                $("#addFromPurchaseOrderItem").find("input[name='totalPrice']").val(data.totalPrice);
                                $("#remark").val(data.remark);

                               /* $("#model").val(data.model);
                                $("#applyCompletionRate").val(data.applyCompletionRate);
                                $("#unit").val(data.unit);
                                $("#price").val(data.price);
                                $("#applyPrice").val(data.applyPrice);
                                $("#remark").val(data.remark);
                                if(ucamVoOrderType == 1){
                                    $("#warrantyDate").val(data.warrantyDate);
                                }
                                if(ucamVoOrderType == 2){
                                    $("#date").val(data.date);
                                }
                                $("#approvalCompletionRate").val(data.approvalCompletionRate);
                                $("#approvalPrice").val(data.approvalPrice);*/
                            }
                        }
                    });
                },false);
            }
        }


        //计算金额
        document.getElementById("amount").addEventListener("change", totalPriceReckon, false);
        document.getElementById("price").addEventListener("change", totalPriceReckon, false);
        function totalPriceReckon(){
            var amount = document.getElementById("amount");
            var price = document.getElementById("price");
            if(price.value != "" && amount.value != ""){
                var applyPrice = price.value * amount.value;
                document.getElementById("totalPrice").value = applyPrice;
            }
        }
    });



    (function($) {
        $.init();
        //var result = $('#dateText');
        var btns =  $('#dateText');
        btns.each(function(i, btn) {
            btn.addEventListener('tap', function() {
                var optionsJson = this.getAttribute('data-options') || '{}';
                var options = JSON.parse(optionsJson);
                var id = this.getAttribute('id');
                var picker = new $.DtPicker(options);
                picker.show(function(rs) {
                    dateText.value = rs.text;
                    picker.dispose();
                });
            }, false);
        });

    })(mui);
    var view = viewApi.view;
    (function($) {
        //处理view的后退与webview后退
        var oldBack = $.back;
        $.back = function() {
            if (viewApi.canBack()) { //如果view可以后退，则执行view的后退
                document.getElementById('addFromPurchaseOrderItem').reset();
                viewApi.back();
            } else { //执行webview后退
                history.go(-1);
            }
        };
        //监听页面切换事件方案1,通过view元素监听所有页面切换事件，目前提供pageBeforeShow|pageShow|pageBeforeBack|pageBack四种事件(before事件为动画开始前触发)
        //第一个参数为事件名称，第二个参数为事件回调，其中e.detail.page为当前页面的html对象
        view.addEventListener('pageBeforeShow', function(e) {
            //				console.log(e.detail.page.id + ' beforeShow');
        });
        view.addEventListener('pageShow', function(e) {
            //				console.log(e.detail.page.id + ' show');
        });
        view.addEventListener('pageBeforeBack', function(e) {
            //				console.log(e.detail.page.id + ' beforeBack');
        });
        view.addEventListener('pageBack', function(e) {
            //				console.log(e.detail.page.id + ' back');
        });
    })(mui);
</script>

<!-- 审核 -->
<c:set value="${ctx}/mobile/purchase/toDetails/${detailsVo.purchaseOrder.id}" var="reviewRefreshUrl"/>
<c:set value="${ctx}/mobile/purchase/reviewPurchaseOrder/${detailsVo.purchaseOrder.id}" var="reviewSaveUrl"/>
<c:set value="${detailsVo.purchaseOrder.status}" var="reviewStatus"/>
<%@ include file="/WEB-INF/page/mobile/common/review.jsp"%>
<!-- 审核 -->

</body>
</html>