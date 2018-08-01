<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>添加部门</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport"
		  content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
	<script>
        <%--JS gloable varilible--%>
        var ctx = "${ctx}";
	</script>
	<style type="text/css">
		.layui-form-item .layui-inline {
			width: 33.333%;
			float: left;
			margin-right: 0;
		}

		@media ( max-width :1240px) {
			.layui-form-item .layui-inline {
				width: 100%;
				float: none;
			}
		}
	</style>
</head>
<body class="childrenBody">
<form class="layui-form" style="width: 80%;">
	<input type="hidden" name="id" value="${department.id }"/>
	<input type="hidden" name="parentId" value="${department.parentId }"/>
	<input type="hidden" name="flag" value="${flag }"/>
	<div class="layui-form-item">
		<label class="layui-form-label">部门名称</label>
		<div class="layui-input-block">
			<input type="text" id="name" class="layui-input name"
				   lay-verify="required" placeholder="请输入部门名称" name="name" value="${department.name }">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">负责人</label>
		<div class="layui-input-block">
			<input type="text" class="layui-input principal" name="principal" id="principal"
				   placeholder="请填负责人" name="icon" value="${department.principal}">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">负责人电话</label>
		<div class="layui-input-block">
			<input type="text" name="phone" class="layui-input userName"
				   placeholder="请输入负责人电话" value="${department.phone }">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">是否有效</label>
		<div class="layui-input-block">
			<div class="layui-input-block">
				<input type="radio" name="valid" value="1" title="有效" <c:if test="${department.valid}">checked</c:if>>
				<input type="radio" name="valid" value="0" title="无效" <c:if test="${!department.valid}">checked</c:if>>
			</div>
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn" lay-submit="" lay-filter="departmentForm">立即提交</button>
		</div>
	</div>
</form>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/admin/departmentForm.js"></script>
</body>
</html>