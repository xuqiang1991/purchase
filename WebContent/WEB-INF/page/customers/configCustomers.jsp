<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>添加客户</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
<script>var ctx = "${ctx}";</script>
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
	<form class="layui-form" style="width: 80%;" id="customersForm">
        <input type="hidden" name="id" value="${customers.id}">
		<div class="layui-form-item">
			<label class="layui-form-label">客户名称</label>
			<div class="layui-input-block">
				<input type="text" id="fullName" class="layui-input" lay-verify="required" placeholder="请输入客户名称" name="fullName" value="${customers.fullName}">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">客户简称</label>
			<div class="layui-input-block">
				<input type="text" id="shortName" class="layui-input" lay-verify="required" placeholder="请输入客户简称" name="shortName" value="${customers.shortName}">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">客户类型</label>
			<div class="layui-input-block">
				<c:if test="${customers.id != null }">
					<c:if test="${customers.type == 0 }">
						<input type="radio" name="type" value="0" title="发展商" checked>
						<input type="radio" name="type" value="1" title="委托商">
					</c:if>
					<c:if test="${customers.type == 1 }">
						<input type="radio" name="type" value="0" title="发展商" >
						<input type="radio" name="type" value="1" title="委托商" checked>
					</c:if>
				</c:if>
				<c:if test="${customers.id == null }">
					<input type="radio" name="type" value="0" title="发展商" checked>
					<input type="radio" name="type" value="1" title="委托商">
				</c:if>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">负责人姓名</label>
			<div class="layui-input-block">
				<input type="text" name="chargeName" class="layui-input" lay-verify="required" placeholder="请输入负责人姓名" value="${customers.chargeName}">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">负责人电话</label>
			<div class="layui-input-block">
				<input type="text" id="chargePhone" name="chargePhone" class="layui-input" lay-verify="phone" placeholder="请输入负责人电话" value="${customers.chargePhone}">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">联系人姓名</label>
			<div class="layui-input-block">
				<input type="text" name="linkName" class="layui-input" lay-verify="required" placeholder="请输入联系人姓名" value="${customers.linkName}">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">联系人电话</label>
			<div class="layui-input-block">
				<input type="text" id="linkPhone" class="layui-input " name="linkPhone" lay-verify="phone" placeholder="请输入联系人电话" value="${customers.linkPhone}">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">地区</label>
			<div class="layui-input-block">
				<input type="text" id="areaName" class="layui-input" lay-verify="required" placeholder="请选择地区" name="areaName" value="${!empty area ? area.name : ''}">
				<input type="hidden" id="areaId" name="area" value="${customers.area }">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">地址</label>
			<div class="layui-input-block">
				<input type="text" name="address" class="layui-input" lay-verify="required" placeholder="请输入地址" value="${customers.address}">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">备注</label>
			<div class="layui-input-block">
				<textarea type="text" name="remark" class="layui-textarea" placeholder="请输入备注">${customers.remark}</textarea>
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="coustomersAdd">立即提交</button>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/js/customers/configCustomers.js"></script>
	<script type="text/javascript" src="${ctx }/js/admin/areaSelect.js"></script>
</body>
</html>