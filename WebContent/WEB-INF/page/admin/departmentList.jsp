<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>layout Layui</title>
	<link rel="stylesheet" href="${ctx }/layui/css/layui.css">
	<style type="text/css">
		/* 数据表格复选框正常显示 */
		.layui-table-cell .layui-form-checkbox[lay-skin="primary"]{
			top: 50%;
			transform: translateY(-50%);
		}
	</style>
	<script src="${ctx }/layui/layui.js"></script>
	<script>
        var ctx = "${ctx}";
	</script>
</head>
<body class="childrenBody">
	<blockquote class="layui-elem-quote list_search">
		<shiro:hasPermission name="sys:area:save">
			<div class="layui-inline">
				<a class="layui-btn" id="addDepartment"><i class="layui-icon">&#xe608;</i>添加</a>
			</div>
		</shiro:hasPermission>
		<shiro:hasPermission name="sys:area:update">
			<div class="layui-inline">
				<a class="layui-btn" id="editDepartment"><i class="layui-icon">&#xe642;</i>编辑</a>
			</div>
		</shiro:hasPermission>
		<shiro:hasPermission name="sys:area:delete">
			<div class="layui-inline">
				<a class="layui-btn layui-btn-danger" id="delDepartment"><i class="layui-icon">&#xe640;</i>删除</a>
			</div>
		</shiro:hasPermission>
        <button class="layui-btn layui-btn-primary">（不选中为添加顶级部门，选中添加子部门）</button>
	</blockquote>
	<%--<br />
	<div class="layui-btn-group TableTools" style="margin-left: 10px">
		<shiro:hasPermission name="sys:department:save">
			<button class="layui-btn" id="addDepartment"><i class="layui-icon">&#xe608;</i>添加</button>
		</shiro:hasPermission>
		<shiro:hasPermission name="sys:department:update">
			<button class="layui-btn" id="editDepartment"><i class="layui-icon">&#xe642;</i>编辑</button>
		</shiro:hasPermission>
		<shiro:hasPermission name="sys:department:delete">
			<button class="layui-btn layui-btn-danger" id="delDepartment"><i class="layui-icon">&#xe640;</i>删除</button>
		</shiro:hasPermission>
		<button class="layui-btn layui-btn-primary">（不选中为添加顶级部门，选中添加子部门）</button>
	</div>--%>
	<!-- 数据表格 -->
	<div><table class="layui-hidden" id="treeTable" lay-filter="treeTable"></table></div>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/js/admin/departmentList.js"></script>
	<script type="text/html" id="radioTpl">
		<input type="radio" name="id" value="{{d.id}}" title=" " lay-filter="radiodemo">
	</script>
	<script type="text/html" id="validTpl">
		{{#  if(d.valid === true){ }}
		是
		{{#  } else{ }}
		否
		{{#  } }}
	</script>
</body>
</html>