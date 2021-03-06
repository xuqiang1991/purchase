<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>供应商列表</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
<meta http-equiv="expires" content="Wed, 26 Feb 1997 08:21:57 GMT">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="${ctx }/css/font_eolqem241z66flxr.css"
	media="all" />
<link rel="stylesheet" href="${ctx }/css/list.css" media="all" />
<script>
	var ctx = "${ctx}";
</script>
</head>
<body class="childrenBody">
	<blockquote class="layui-elem-quote news_search">
        <form class="layui-form">
            <!-- 查询条件块 start -->
            <div>
                <div class="layui-input-inline">
                    <input type="text" id="name" value="" placeholder="请输入名称" class="layui-input search_input">
                </div>
                <div class="layui-input-inline layui-form">
                    <select name="type" class="" id="type">
                        <option value="">请选择供应商类别</option>
                        <option value="0">材料供应商</option>
                        <option value="1">工程分包商</option>
                    </select>
                </div>
                <div class="layui-input-inline layui-form">
                    <input type="text" id="areaName" class="layui-input" placeholder="请选择地区" name="areaName" readonly>
                    <input type="hidden" id="areaId" name="areaId" value="${supplier.areaId }">
                </div>
                <div class="layui-input-inline layui-form">
                    <select name="valid" class="" id="valid">
                        <option value="">请选择是否有效</option>
                        <option value="1">有效</option>
                        <option value="0">无效</option>
                    </select>
                </div>
            </div>
            <!-- 查询条件块 end -->

            <!-- 功能按钮块 start -->
            <div style="padding-top: 1%;">
                <shiro:hasPermission name="sys:supplier:list">
                    <div class="layui-inline">
                        <a class="layui-btn search_btn" lay-submit="" data-type="search" lay-filter="search"><i class="layui-icon">&#xe615;</i>查询</a>
                    </div>
                </shiro:hasPermission>
                <shiro:hasPermission name="sys:supplier:save">
                    <div class="layui-inline">
                        <a class="layui-btn" id="addSupplier"><i class="layui-icon">&#xe608;</i>添加</a>
                    </div>
                </shiro:hasPermission>
                <shiro:hasPermission name="sys:supplier:update">
                    <div class="layui-inline">
                        <a class="layui-btn" id="editSupplier"><i class="layui-icon">&#xe642;</i>编辑</a>
                    </div>
                </shiro:hasPermission>
                <shiro:hasPermission name="sys:supplier:delete">
                    <div class="layui-inline">
                        <a class="layui-btn layui-btn-danger" id="delSupplier"><i class="layui-icon">&#xe640;</i>删除</a>
                    </div>
                </shiro:hasPermission>
            </div>
            <!-- 功能按钮块 end -->
        </form>
	</blockquote>
	<div class="layui-form">
		<table id="supplierList" lay-filter="supplierList"></table>
	</div>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/js/supplier/supplierList.js"></script>
	<script type="text/javascript" src="${ctx }/js/admin/areaSelect.js"></script>
	<script type="text/html" id="barEdit">
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
	<script type="text/html" id="typeTpl">
		{{#  if(d.type === 0){ }}
		材料供应商
		{{#  } else if(d.type === 1){ }}
		工程分包商
		{{#  } }}
	</script>
	<script type="text/html" id="validTpl">
 		 {{#  if(d.valid){ }}
   		 <span style="color: #FFB800;">有效</span>
  		{{#  } else if(!d.valid){ }}
			<span style="color: #01AAED;">无效</span>
		 {{#  } }}
	</script>
    <script type="text/html" id="radioTpl">
        <input type="radio" name="id" value="{{d.id}}" title=" " lay-filter="radiodemo">
    </script>
</body>
</html>