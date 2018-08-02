<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
	<title>添加供应商</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
	<script>
        <%--JS gloable varilible--%>
        var ctx = "${ctx}";
	</script>
</head>
<body class="childrenBody">
<div class="layui-fluid">
	<div class="layui-card">
		<div class="layui-card-body" style="padding: 15px;">
			<form class="layui-form" style="width: 80%;">
				<input type="hidden" name="id" value="${supplier.id }"/>
				<input type="hidden" name="flag" value="${flag }"/>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">供应商名称</label>
						<div class="layui-input-block">
							<input type="text" id="name" class="layui-input" lay-verify="required" placeholder="请输入供应商名称" name="name" value="${supplier.name}">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">简称</label>
						<div class="layui-input-block">
							<input type="text" id="nick" class="layui-input nick"
								   lay-verify="required" placeholder="请输入供应商名称" name="nick" value="${supplier.nick }">
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">供应商类别</label>
						<div class="layui-input-block">
							<select name="type" class="" id="type" lay-filter="aihao">
								<option value="">请选择供应商类别</option>
								<option value="0" <c:if test="${supplier.type == 0}">selected</c:if> >材料供应商</option>
								<option value="1" <c:if test="${supplier.type == 1}">selected</c:if> >工程分包商</option>
							</select>
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">地区</label>
						<div class="layui-input-block">
							<select name="areaId" class="" id="areaId">
								<option value="">请选择地区</option>
								<option value="1">测试1</option>
								<option value="2">测试2</option>
							</select>
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">负责人</label>
						<div class="layui-input-block">
							<input type="text" class="layui-input principalName" name="principalName" id="principalName"
								   placeholder="请填负责人" name="icon" value="${supplier.principalName}">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">负责人电话</label>
						<div class="layui-input-block">
							<input type="text" name="principalPhone" class="layui-input principalPhone" lay-verify="phone"
								   placeholder="请输入负责人电话" value="${supplier.principalPhone }">
						</div>
					</div>

				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">联系人</label>
						<div class="layui-input-block">
							<input type="text" class="layui-input contact" name="contactName" id="contactName"
								   placeholder="请填联系人" name="icon" value="${supplier.contactName}">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">联系人电话</label>
						<div class="layui-input-block">
							<input type="text" name="contactPhone" class="layui-input contactPhone" lay-verify="phone"
								   placeholder="请输入联系人电话" value="${supplier.contactPhone }">
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">是否有效</label>
					<div class="layui-input-block">
						<div class="layui-input-block">
							<input type="radio" name="valid" value="1" title="有效" <c:if test="${supplier.valid}">checked</c:if>>
							<input type="radio" name="valid" value="0" title="无效" <c:if test="${!supplier.valid}">checked</c:if>>
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">地址</label>
					<div class="layui-input-block">
						<input type="text" name="address" class="layui-input address"  placeholder="请输入地址" value="${supplier.address }">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">备注</label>
					<div class="layui-input-block">
						<textarea name="remark" placeholder="请输入备注" class="layui-textarea">${supplier.remark}</textarea>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="addSupplier">立即提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/supplier/supplierForm.js"></script>
</body>
</html>