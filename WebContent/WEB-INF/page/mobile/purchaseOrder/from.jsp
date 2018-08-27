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
<!-- 侧滑导航根容器 -->
<div id="offCanvasWrapper" class="mui-off-canvas-wrap mui-draggable">
    <!-- 菜单容器 -->
    <aside id="offCanvasSide" class="mui-off-canvas-right">
        <div id="offCanvasSideScroll" class="mui-scroll-wrapper">
            <div class="mui-scroll">
                <ul class="mui-table-view" style="margin: 35px 15px 10px;">
                    <li class="mui-table-view-cell mui-collapse" id="searchCollapse">
                        <a class="mui-navigate-right" href="#">搜索</a>
                        <div class="mui-collapse-content">
                            <div class="mui-collapse-content">
                                <form class="mui-input-group" id="searchForm">
                                    <div class="mui-input-row">
                                        <label>名称</label>
                                        <input type="text" placeholder="供应商名称" name="name">
                                    </div>
                                    <div class="mui-input-row">
                                        <label>类别</label>
                                        <select name="type">
                                            <option value="">全部</option>
                                            <option value="0">材料供应商</option>
                                            <option value="1">工程分包商</option>
                                        </select>
                                    </div>
                                    <div class="mui-button-row">
                                        <button class="mui-btn mui-btn-primary" id="search-btn" type="button">确认</button>&nbsp;&nbsp;
                                        <button class="mui-btn mui-btn-danger"  id="cancel-btn" type="button">取消</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </li>
                </ul>
                <!--下拉刷新容器-->
                <div id="supplierRefreshContainer" class="mui-content mui-scroll-wrapper" style="margin: 280px 15px 10px;">
                    <div class="mui-scroll">
                        <!--数据列表-->
                        <ul class="mui-table-view mui-table-view-chevron supplierRefreshContainerData">
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </aside>
    <div class="mui-inner-wrap">
        <!-- 主页面标题 -->
        <header class="mui-bar mui-bar-nav">
            <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
            <h1 class="mui-title">新建采购订单</h1>
        </header>
        <!-- 主页面内容容器 -->
        <div class="mui-content mui-scroll-wrapper">
            <div id="offCanvasContentScroll" class="mui-content mui-scroll-wrapper">
                <div class="mui-scroll">
                    <!-- 主界面具体展示内容 -->
                    <div class="mui-content-padded mui-card" style="margin: 5px;">
                        <form class="mui-input-group">
                            <div class="mui-input-row">
                                <label>合同编号</label>
                                <input type="text" name="contract_no" class="mui-input-clear">
                            </div>
                            <div class="mui-input-row">
                                <label>订单类型</label>
                                <select name="type">
                                    <option value="0">绿化苗木</option>
                                    <option value="1">园建水电</option>
                                    <option value="2">机械租赁</option>
                                    <option value="3">工程分包</option>
                                </select>
                            </div>
                            <div class="mui-input-row">
                                <label>供应商</label>
                                <input type="text" id="supplier_id" name="supplier_id" class="mui-input-clear" placeholder="请选择供应商">
                            </div>
                            <div class="mui-input-row">
                                <label>所属项目</label>
                                <input type="text" name="project_id" class="mui-input-clear" placeholder="请选择所属项目">
                            </div>
                            <div class="mui-input-row">
                                <label>合同总金额</label>
                                <input type="text" name="contract_money" class="mui-input-clear" readonly="readonly" placeholder="合同总金额">
                            </div>
                            <div class="mui-input-row mui-input-range">
                                <label>付款比例(%)</label>
                                <input name="payment_ratio" type="range" min="0" max="100" value="100">
                            </div>
                            <div>
                                <textarea name="summary" id="summary" rows="5" class="mui-input-clear" placeholder="摘要"></textarea>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/mui/js/mui.min.js"></script>
<script type="text/javascript" charset="utf-8">
    mui.init();
    //侧滑容器父节点
    var offCanvasWrapper = mui('#offCanvasWrapper');
    //菜单容器
    var offCanvasSide = document.getElementById("offCanvasSide");
    //主界面‘显示侧滑菜单’按钮的点击事件
    document.getElementById('supplier_id').addEventListener('tap', function() {
        offCanvasWrapper.offCanvas().show();
    });
    //主界面和侧滑菜单界面均支持区域滚动；
    mui('#offCanvasSideScroll').scroll();
    mui('#offCanvasContentScroll').scroll();


    mui(document.body).on('tap', '#search-btn', function(e) {
        $('#searchCollapse').removeClass('mui-active')
        supplier.billRefresh();
    });

    mui(document.body).on('tap', '#cancel-btn', function(e) {
        $('#searchCollapse').removeClass('mui-active')
    });

    var supplier = {
        supplierList:function () {
            var page = 1; //当前页
            var limit = 6; //每页显示条数
            var enablePullUp = true; //是否加载
            mui('#supplierRefreshContainer').pullRefresh({

            })
        },
        billLoad : function() {
            if (!enablePullUp) {
                mui('#supplierRefreshContainer').pullRefresh().endPullupToRefresh(false);
                mui.toast("没有更多数据了");
                return;
            }
            page++;
            getBill();
            mui('#supplierRefreshContainer').pullRefresh().endPullupToRefresh(false);
        },
        billRefresh : function() {
            $('.mui-table-view-chevron').empty();
            enablePullUp = true;
            page = 1;
            getBill();
            mui('#supplierRefreshContainer').pullRefresh().endPulldownToRefresh();
        },
        getBill: function () {
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
                    var refreshContainer = mui('#supplierRefreshContainer');
                    if(result.data != null && result.data.length != 0){
                        var data = result.data;
                        // 请求成功
                        var listTargt = $('.supplierRefreshContainerData')

                        var tpl = $("#listTpl").html();
                        //预编译模板
                        var template = Handlebars.compile(tpl);

                        //数据转换
                        purchaseOrder.statusConversion(Handlebars)
                        purchaseOrder.departUser(Handlebars)
                        purchaseOrder.departDate(Handlebars)

                        //匹配json内容
                        var html = template({data});//data
                        //输入模板
                        listTargt.append(html);

                        if (data.length < limit) {
                            enablePullUp = false;
                        }
                    }
                },
                error: function () {
                    mui('#supplierRefreshContainer').pullRefresh().endPullupToRefresh(false); //参数为true代表没有更多数据了。
                    mui('#supplierRefreshContainer').pullRefresh().endPulldownToRefresh(); //refresh completed
                    enablePullUp = false;
                }
              });
         }
    }
</script>
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
                <label>测试</label>
                <label>测试</label>
            </div>
            <div>
                <button type="button" class="mui-btn mui-btn-primary">详情</button>
                <button type="button" class="mui-btn mui-btn-primary">审核</button>
            </div>
        </div>
    </div>
    {{/each}}
</script>
</body>
</html>