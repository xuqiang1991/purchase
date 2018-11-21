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
        .layui-form-pane .layui-form-label{width: 180px;}
        .layui-form-pane .layui-input-block {
            margin-left: 180px;
        }
        .css-required:after {
            content: ' *';
            color: red;
            font-size: 150%;
        }
    </style>
</head>
<body class="childrenBody">
    <form class="layui-form layui-form-pane" style="width: 80%;">
        <input type="hidden" name="id" value="${supplier.id }"/>
        <input type="hidden" name="flag" value="${flag }"/>
        <div class="layui-form-item">
            <label class="layui-form-label css-required">供应商名称</label>
            <div class="layui-input-block">
                <input type="text" id="name" class="layui-input" lay-verify="required"  maxlength="80" placeholder="请输入供应商名称" name="name" value="${supplier.name}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label css-required">简称</label>
            <div class="layui-input-block">
                <input type="text" id="nick" class="layui-input nick" lay-verify="required"  maxlength="50" placeholder="请输入供应商名称" name="nick" value="${supplier.nick }">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label css-required">供应商类别</label>
            <div class="layui-input-block">
                <select name="type" class="" id="type" lay-filter="required|aihao">
                    <option value="">请选择供应商类别</option>
                    <option value="0" <c:if test="${supplier.type == 0}">selected</c:if> >材料供应商</option>
                    <option value="1" <c:if test="${supplier.type == 1}">selected</c:if> >工程分包商</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label css-required">地区</label>
            <div class="layui-input-block">
                <input type="text" id="areaName" class="layui-input" lay-verify="required" placeholder="请选择地区" name="areaName" value="${!empty area ? area.name : ''}">
                <input type="hidden" id="areaId" name="areaId" value="${supplier.areaId }">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">负责人</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input principalName" name="principalName" id="principalName" maxlength="50"
                       placeholder="请填负责人" name="icon" value="${supplier.principalName}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">负责人电话</label>
            <div class="layui-input-block">
                <input type="text" name="principalPhone" class="layui-input principalPhone" lay-verify="phone" maxlength="50"
                       placeholder="请输入负责人电话" value="${supplier.principalPhone }">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">联系人</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input contact" name="contactName" id="contactName" maxlength="50"
                       placeholder="请填联系人" name="icon" value="${supplier.contactName}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">联系人电话</label>
            <div class="layui-input-block">
                <input type="text" name="contactPhone" class="layui-input contactPhone" lay-verify="phone" maxlength="50"
                       placeholder="请输入联系人电话" value="${supplier.contactPhone }">
            </div>
        </div>
        <div class="layui-form-item" pane>
            <label class="layui-form-label css-required">是否有效</label>
            <div class="layui-input-block">
                <input type="radio" name="valid" value="1" title="有效" <c:if test="${supplier.valid}">checked</c:if>>
                <input type="radio" name="valid" value="0" title="无效" <c:if test="${!supplier.valid}">checked</c:if>>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">地址</label>
            <div class="layui-input-block">
                <input type="text" name="address" class="layui-input address"  placeholder="请输入地址" value="${supplier.address }" maxlength="128">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <textarea name="remark" placeholder="请输入备注" class="layui-textarea" maxlength="500">${supplier.remark}</textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="addSupplier">保存</button>
            </div>
        </div>
    </form>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/supplier/supplierForm.js"></script>
<script type="text/javascript" src="${ctx }/js/admin/areaSelect.js"></script>
</body>
</html>