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
    <link href="${ctx }/mui/css/mui.picker.min.css" rel="stylesheet" />
    <script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/mui/js/mui.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/handlebars.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/handlebarsHelps1.js"></script>
    <script src="${ctx }/mui/js/mui.picker.min.js"></script>
</head>
<body>
<header class="mui-bar mui-bar-nav">
    <%--<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>--%>
    <h1 class="mui-title">合同订单列表</h1>
</header>

<div class="mui-content">
    <%--<c:if test="${!empty admin.supplierId}">
        <div class="mui-card" style="margin: 0px; margin-top: 5px; margin-bottom: 5px; padding-bottom: 5px; text-align: center;">
            <div class="mui-button-row">
                <button type="button" id="add-btn" class="mui-btn mui-btn-primary">新建合同订单</button>
            </div>
        </div>
    </c:if>--%>
    <c:set value="0" var="addPermission"/>
    <shiro:hasPermission name="mobile:purchase:save">
        <c:set value="1" var="addPermission"/>
        <div class="mui-card" style="margin: 0px; margin-top: 5px; margin-bottom: 5px; padding-bottom: 5px; text-align: center;">
            <div class="mui-button-row">
                <button type="button" id="add-btn" class="mui-btn mui-btn-primary">新建合同订单</button>
            </div>
        </div>
    </shiro:hasPermission>
    <!-- 单号、订单类型、供应商、所属项目、合同号、开单人、开单日期、单据状态 -->
    <ul class="mui-table-view" style="z-index: 100">
        <li class="mui-table-view-cell mui-collapse" id="searchCollapse">
            <a class="" href="#">
                搜索 <span style="float: right;" class="mui-icon mui-icon mui-icon-search"></span>
            </a>
            <div class="mui-collapse-content">
                <div class="mui-collapse-content">
                    <form class="mui-input-group" id="searchForm">
                        <div class="mui-input-row">
                            <label>单号</label>
                            <input type="text" name="purchaseNo" placeholder="请输入单号">
                        </div>
                        <div class="mui-input-row">
                            <label>订单类型</label>
                            <input type="text" id="typeName" readonly class="mui-input-clear" placeholder="请选择单据类型" value="" >
                            <input type="hidden" id="type" name="type" value="" >
                        </div>
                        <div class="mui-input-row">
                            <label>供应商</label>
                            <input type="text" id="supplierIdName" readonly class="mui-input-clear"  value="请选择供应商">
                            <input type="hidden" id="supplierId" name="supplierId">
                        </div>
                        <div class="mui-input-row">
                            <label>所属项目</label>
                            <input type="text" id="selectProjectName" class="mui-input-clear" placeholder="请选择所属项目" >
                            <input type="hidden" id="projectId" name="projectId">
                        </div>
                        <div class="mui-input-row">
                            <label>合同号</label>
                            <input type="text" name="contractNo" placeholder="普通输入框">
                        </div>
                        <div class="mui-input-row">
                            <label>开单人</label>
                            <input type="text" id="selectCreateUser" class="mui-input-clear" placeholder="请选择开单人" >
                            <input type="hidden" id="createUser" name="createUser">
                        </div>
                        <div class="mui-input-row">
                            <label>开单日期</label>
                            <input id="createTime" name="createTime" type="text" data-options='{"type":"date","beginYear":2014}' placeholder="请选择日期">
                        </div>
                        <div class="mui-input-row">
                            <label>审核人</label>
                            <input type="text" id="selectDepartUser" class="mui-input-clear" placeholder="请选择审核人" >
                            <input type="hidden" id="departUser" name="departUser">
                        </div>
                        <div class="mui-input-row">
                            <label>审核日期</label>
                            <input id="departDate" name="departDate" type="text" data-options='{"type":"date","beginYear":2014}' placeholder="请选择日期">
                        </div>
                        <div class="mui-button-row">
                            <button class="mui-btn mui-btn-primary" type="button" id="search-btn">确认</button>&nbsp;&nbsp;
                            <button class="mui-btn mui-btn-danger" type="button" id="reset-btn">重置</button>
                        </div>
                    </form>
                </div>
            </div>
        </li>
    </ul>
    <!--下拉刷新容器-->
    <div id="refreshContainer" class="mui-content mui-scroll-wrapper" style="margin-top: 135px;width: 100%;">
        <div class="mui-scroll">
            <!--数据列表-->
            <div id="datascrollDiv" class="mui-content"></div>
        </div>
    </div>
</div>
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

    var addPermission = '${addPermission}';
    if(addPermission == 1){
        $('#refreshContainer').css("margin-top","142px");
    }else{
        $('#searchUl').css("margin-top","10px");
        $('#refreshContainer').css("margin-top","100px");
    }
    mui(document.body).on('tap', '#search-btn', function(e) {
        $('#searchCollapse').removeClass('mui-active')
        billRefresh();
    });

    mui(document.body).on('tap', '#cancel-btn', function(e) {
        $('#searchCollapse').removeClass('mui-active')
    });

    mui(document.body).on('tap', '#add-btn', function(e) {
        //document.location.href='${ctx }/mobile/purchase/toSave';
        document.location.href='${ctx }/mobile/purchase/toDetails/';
    });

    mui(document.body).on('tap', '.toDetails', function(e) {
        var id = $(this).attr('value');
        toDetails(id)
    });

    mui(document.body).on('tap', '.toUpdate', function(e) {
        var id = $(this).attr('value');
        document.location.href='${ctx }/mobile/purchase/toEdit?id=' + id;
    });

    mui(document.body).on('tap','#reset-btn',function(e){
        $('#searchForm').find('input').val('');
    })

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
        $('#datascrollDiv').empty();
        enablePullUp = true;
        page = 1;
        getBill();
        mui('#refreshContainer').pullRefresh().endPulldownToRefresh();
    }

    function getBill() {
        var url = '${ctx}/mobile/purchase/getPurchaseList?' + 'limit=' + limit + '&page=' + page;
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
                    var listTargt = $('#datascrollDiv');

                    var tpl = $("#listTpl").html();
                    //预编译模板
                    var template = Handlebars.compile(tpl);

                    //数据转换
                    utilsOrder.approvalConversion(Handlebars);

                    //匹配json内容
                    var html = template({data});//data
                    //输入模板
                    listTargt.append(html);
                    $(".mui-toast-container").remove();
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
        document.location.href='${ctx }/mobile/purchase/toDetails/?id=' + id;
    }

    var btns =  mui('#createTime');
    btns.each(function(i, btn) {
        btn.addEventListener('tap', function() {
            var optionsJson = this.getAttribute('data-options') || '{}';
            var options = JSON.parse(optionsJson);
            var id = this.getAttribute('id');
            var picker = new mui.DtPicker(options);
            picker.show(function(rs) {
                createTime.value = rs.text;
                picker.dispose();
            });
        }, false);
    });

    var btnsDepart =  mui('#departDate');
    btnsDepart.each(function(i, btn) {
        btn.addEventListener('tap', function() {
            var optionsJson = this.getAttribute('data-options') || '{}';
            var options = JSON.parse(optionsJson);
            var id = this.getAttribute('id');
            var picker = new mui.DtPicker(options);
            picker.show(function(rs) {
                departDate.value = rs.text;
                picker.dispose();
            });
        }, false);
    });

    mui.ready(function() {
        var orderTypeNamePicker = new mui.PopPicker();
        orderTypeNamePicker.setData( [{
            value: '0',
            text: '绿化苗木'
        }, {
            value: '1',
            text: '园建水电'
        }, {
            value: '2',
            text: '机械租赁'
        }, {
            value: '3',
            text: '工程分包'
        }]);
        var orderTypeName = document.getElementById('typeName');
        var orderType = document.getElementById('type');
        orderTypeName.addEventListener('tap', function(event) {
            orderTypeNamePicker.show(function(items) {
                orderTypeName.value = items[0].text;
                orderType.value = items[0].value;
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);

        var suppliersJson = '${suppliers}';
        var suppliersPicker = new mui.PopPicker({
            layer: 1
        });
        suppliersPicker.setData(JSON.parse(suppliersJson));
        var supplierIdName = document.getElementById('supplierIdName');
        var supplierId = document.getElementById('supplierId');
        supplierIdName.addEventListener('tap', function(event) {
            suppliersPicker.show(function(items) {
                supplierIdName.value = items[0].text;
                supplierId.value = items[0].value;
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);

        var adminsJson = '${admins}';
        var userPicker = new mui.PopPicker();
        userPicker.setData(JSON.parse(adminsJson));

        var selectDepartUser = document.getElementById('selectDepartUser');
        var departUser = document.getElementById('departUser');
        selectDepartUser.addEventListener('tap', function(event) {
            userPicker.show(function(items) {
                selectDepartUser.value = items[0].text;
                departUser.value = items[0].value;
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);

        var selectCreateUser = document.getElementById('selectCreateUser');
        var createUser = document.getElementById('createUser');
        selectCreateUser.addEventListener('tap', function(event) {
            userPicker.show(function(items) {
                selectCreateUser.value = items[0].text;
                createUser.value = items[0].value;
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);



        var projectsJson = '${projects}';
        var projectsPicker = new mui.PopPicker({
            layer: 1
        });
        projectsPicker.setData(JSON.parse(projectsJson));
        var selectProjectName = document.getElementById('selectProjectName');
        var projectId = document.getElementById('projectId');
        selectProjectName.addEventListener('tap', function(event) {
            projectsPicker.show(function(items) {
                selectProjectName.value = items[0].text;
                projectId.value = items[0].value;
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);
    })
</script>
<!-- 合同订单 start -->
<script type="text/template" id="listTpl">
    {{#each data}}
    <div class="mui-card" style="margin: 0px; margin-top: 5px;">
        <div class="mui-card-header mui-card-media toDetails" value="{{id}}">
            <img src="${ctx}/images/icon/purchase_order.png">
            <div class="mui-media-body">
                <label>单号:{{purchaseNo}}</label>
                <p>
                    <label>开单人:{{admin.fullname}}</label>&nbsp;&nbsp;
                    <label>开单日期：{{createTime}}</label>
                    <%--<span class="mui-badge mui-badge-primary mui-pull-right">{{lastRole.roleName}} {{isApproval_Conversion isApproval}}</span>--%>
                </p>
            </div>
        </div>
        <div class="mui-card-content toDetails" value="{{id}}">
            <div class="mui-card-content-inner">
                <p>
                    <label>合同号：{{admin.fullname}}</label>
                    <label>供应商：{{supplier.name}}</label>
                </p>
                <p>
                    <label>所属项目：{{tpm.name}}</label>
                </p>
            </div>
        </div>
        <div class="mui-card-footer">
            <div class="mui-pull-left">
                <label>操作人:{{lastUser.fullname}}</label>
                <label>时间:{{lastReviewDate}}</label>
            </div>
            <span class="mui-badge mui-badge-primary mui-pull-right">{{lastRole.roleName}} {{isApproval_Conversion isApproval}}</span>
            <%--<div>--%>
                <%--{{#unless status}}--%>
                 <%--<button type="button" class="mui-btn mui-btn-primary toUpdate" value="{{id}}">修改</button>--%>
                <%--{{/unless}}--%>
                <%--&lt;%&ndash;<button type="button" class="mui-btn mui-btn-primary toDetails"  value="{{id}}">详情</button>&ndash;%&gt;--%>
            <%--</div>--%>
        </div>
    </div>
    {{/each}}
</script>
<!-- 合同订单 end -->
</body>
</html>