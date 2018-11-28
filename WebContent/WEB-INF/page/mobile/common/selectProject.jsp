<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>


<%--<div id="projectApp" class="mui-views">
    <div class="mui-view">
        <div class="mui-navbar"></div>
        <div class="mui-pages"></div>
    </div>
</div>--%>

<div id="selectProject" class="mui-page">
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <button type="button" class="mui-left mui-action-back mui-btn  mui-btn-link mui-btn-nav mui-pull-left">
            <span class="mui-icon mui-icon-left-nav"></span>返回
        </button>
        <h1 class="mui-center mui-title">选择所属项目</h1>
    </div>
    <div class="mui-page-content">
        <div class="mui-scroll-wrapper">
            <div class="mui-input-row mui-search">
                <ul class="mui-table-view" style="margin: 5px 15px 10px;z-index: 100">
                    <li class="mui-table-view-cell mui-collapse" id="searchCollapse">
                        <a class="" href="#">
                            搜索 <span style="float: right;" class="mui-icon mui-icon mui-icon-search"></span>
                        </a>
                        <div class="mui-collapse-content">
                            <div class="mui-collapse-content">
                                <form class="mui-input-group" id="searchForm">
                                    <div class="mui-input-row">
                                        <label>名称</label>
                                        <input type="text" placeholder="项目名称" name="name">
                                    </div>
                                    <div class="mui-input-row">
                                        <label>项目简称</label>
                                        <input type="text" placeholder="项目简称" name="shortName">
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
            </div>
            <div class="mui-scroll"  style="height: 100%;">
                <!--下拉刷新容器-->
                <div id="projectRefreshContainer" class="mui-content mui-scroll-wrapper">
                    <div class="mui-scroll">
                        <!--数据列表-->
                        <ul id="selectProjectUl" class="mui-table-view mui-table-view-radio projectRefreshContainerData">

                        </ul>
                        <div class="mui-button-row" style="padding-bottom: 20px;">
                            <button type="button" class="mui-btn mui-btn-primary account-cancel" onclick="cancel();">取消</button>&nbsp;&nbsp;
                            <button type="button" class="mui-btn mui-btn-danger account-ensure" onclick="projectEnsure('selectProject','selectProjectText','selectProjectHidden');">确定</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<script type="text/javascript" charset="utf-8">
    if(mui == null){
        mui.init();
    }

    /*//初始化单页view
    var projectApp = mui('#projectApp').view({
        defaultPage: '#setting'
    });*/

    //选择项目
    var $project = {
        list : mui('#projectRefreshContainer'),
        page : 1, //当前页
        limit :  10, //每页显示条数
        enablePullUp : true, //是否加载
        projectList:function () {
            this.list.pullRefresh({
                down : {
                    style:'circle',//必选，下拉刷新样式，目前支持原生5+ ‘circle’ 样式
                    auto: true,//可选,默认false.首次加载自动上拉刷新一次
                    callback :this.billRefresh
                },
                up: {
                    auto:false,
                    contentrefresh: '正在加载...',
                    contentnomore:'',
                    callback: this.billLoad
                }
            })
        },
        billLoad : function() {
            if (!$project.enablePullUp) {
                $project.list.pullRefresh().endPullupToRefresh(false);
                mui.toast("没有更多数据了");
                return;
            }
            $project.page++;
            $project.getBill();
            $project.list.pullRefresh().endPullupToRefresh(false);
        },
        billRefresh : function() {
            $('.projectRefreshContainerData').empty();
            $project.enablePullUp = true;
            $project.page = 1;
            $project.getBill();

            $project.list.pullRefresh().endPulldownToRefresh();
        },
        getBill: function () {
            var url = '${ctx}/projectManger/findProjectMangerList?' + 'limit=' + $project.limit + '&page=' + $project.page;
            mui.toast("加载中...",1000);
            $.ajax({
                url: url,
                data: $('#searchForm').serialize(),
                dataType: 'json',
                contentType : "application/x-www-form-urlencoded",
                type: 'post',
                timeout: 10000,
                success: function(result) {
                    if(result.data != null && result.data.length != 0){
                        var data = result.data;
                        // 请求成功
                        var listTargt = $('.projectRefreshContainerData')

                        var tpl = $("#listTpl").html();
                        //预编译模板
                        var template = Handlebars.compile(tpl);

                        //匹配json内容
                        var html = template({data});//data
                        //输入模板
                        listTargt.append(html);

                        if (data.length < this.limit) {
                            $project.enablePullUp = false;
                        }
                    }
                },
                error: function () {
                    $project.list.pullRefresh().endPullupToRefresh(false); //参数为true代表没有更多数据了。
                    $project.list.pullRefresh().endPulldownToRefresh(); //refresh completed
                    $project.enablePullUp = false;
                }
            });
        }
    }

    function projectEnsure(flag,callText,callValue){
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
    var oldBack = mui.back;
    function cancel(){
        if (viewApi.canBack()) { //如果view可以后退，则执行view的后退
            viewApi.back();
        } else { //执行webview后退
            oldBack();
        }
    }
    (function($) {
        //处理view的后退与webview后退
        var oldBack = $.back;
        $.back = function() {
            if (viewApi.canBack()) { //如果view可以后退，则执行view的后退
                viewApi.back();
            } else { //执行webview后退
                oldBack();
            }
        };
    })(mui);


</script>
<script type="text/template" id="listTpl">
    {{#each data}}
    <li class="mui-table-view-cell" data-id="{{id}}" data-text="{{name}}">
        <a class="mui-navigate-right">{{name}}</a>
    </li>
    {{/each}}
</script>