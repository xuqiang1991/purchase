<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>客户列表</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
<meta http-equiv="expires" content="Wed, 26 Feb 1997 08:21:57 GMT">
<link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="${ctx }/css/font_eolqem241z66flxr.css" media="all" />
<link rel="stylesheet" href="${ctx }/css/list.css" media="all" />
<script>
	var ctx = "${ctx}";
</script>
</head>
<body class="childrenBody">
	<blockquote class="layui-elem-quote list_search">
        <form class="layui-form">
            <!-- 查询条件块 start -->
            <div>
                <div class="layui-input-inline">
                    <input type="text" id="name" value="" placeholder="请输入客户名称" class="layui-input search_input">
                </div>
                <div class="layui-input-inline layui-form">
                    <input type="text" id="areaName" class="layui-input search_input" placeholder="请选择地区" name="areaName" >
                    <input type="hidden" id="areaId" name="areaId">
                    <%--<select id="areaId" name="areaId" >
                        <option value="1">请选择地区</option>
                    </select>--%>
                </div>
                <div class="layui-input-inline layui-form">
                    <select id="isForce" name="isForce">
                        <option value="">请选择状态</option>
                        <option value="1">有效</option>
                        <option value="0">失效</option>
                    </select>
                </div>
            </div>
            <!-- 查询条件块 end -->

            <div class="layui-inline">
                <a class="layui-btn customersQuery_btn"><i class="layui-icon">&#xe615;</i>查询</a>
            </div>
            <%-- <shiro:hasPermission name="sys:customers:query">
                 <div class="layui-inline">
                     <a class="layui-btn projectMangerQuery_btn"><i class="layui-icon">&#xe615;</i>查询</a>
                 </div>
             </shiro:hasPermission>--%>
            <shiro:hasPermission name="sys:customers:save">
                <div class="layui-inline">
                    <a class="layui-btn customersAdd_btn"><i class="layui-icon">&#xe608;</i>添加</a>
                </div>
            </shiro:hasPermission>
            <shiro:hasPermission name="sys:customers:update">
                <div class="layui-inline">
                    <a class="layui-btn customersUpdate_btn"><i class="layui-icon">&#xe642;</i>编辑</a>
                </div>
            </shiro:hasPermission>
            <shiro:hasPermission name="sys:customers:delete">
                <div class="layui-inline">
                    <a class="layui-btn layui-btn-danger customersDel_btn" data-type="delCheckData"><i class="layui-icon">&#xe640;</i>删除</a>
                </div>
            </shiro:hasPermission>
        </form>
	</blockquote>
	<!-- 数据表格 -->
	<table id="customersList" class="customersList" lay-filter="customersList"></table>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/js/customers/customersList.js"></script>
    <script type="text/javascript" src="${ctx }/js/admin/areaSelect.js"></script>
	<script type="text/html" id="customersType">
		{{#  if(d.type == 0){ }}
		发展商
		{{#  } else{ }}
		委托商
		{{#  } }}
	</script>
    <script type="text/html" id="customersIsForce">
        {{#  if(d.isForce == 1){ }}
        <span style="color: #FFB800;">有效</span>
        {{#  } else{ }}
        <span style="color: #01AAED;">失效</span>
        {{#  } }}
    </script>
    <script type="text/html" id="radioTpl">
        <input type="radio" name="customersId" value="{{d.id}}" title=" " lay-filter="radiodemo">
    </script>
</body>
</html>