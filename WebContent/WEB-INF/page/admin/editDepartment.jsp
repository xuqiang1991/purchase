<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>编辑部门</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
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
		<!-- 管理员id -->
		<input type="hidden" name="id" value="${ad.id }"/>
		<div class="layui-form-item">
			<label class="layui-form-label">组织名称</label>
			<div class="layui-input-block">
				<input type="text" id="name" class="layui-input name"
					lay-verify="required" readonly="readonly" name="name" value="${ad.name }">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">上级组织</label>
			<div class="layui-input-block">
				<input type="text" name="parentName" class="layui-input parentName"
					lay-verify="required" placeholder="请输入上级组织" value="${ad.parentName }">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">负责人</label>
			<div class="layui-input-block">
				<input type="text" name="principal" id="principal" class="layui-input principal" placeholder="请输入负责人" value="${ad.principal }">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">负责人电话</label>
			<div class="layui-input-block">
				<input type="text" name="principal" id="phone" class="layui-input phone"
					   lay-verify="phone"  placeholder="请输入负责人电话" value="${ad.phone }">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="updDepartment">立即保存</button>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/js/admin/editdepartment.js"></script>
</body>
</html>