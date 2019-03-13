<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>提交订单</title>
	<link rel="stylesheet" href="${ctx }/layui/css/layui.css">
	<script src="${ctx }/layui/layui.js"></script>
	<script>
        var ctx = "${ctx}";
	</script>
</head>
<body class="layui-layout-body" style="overflow:auto">
<form class="layui-form" style="margin-bottom: 5px">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">角色名称</label>
            <div class="layui-input-block">
                <input type="text" id="selectApplyUserEdit" readonly lay-verify="required" class="layui-input" placeholder="请选择审批人" value="">
                <input type="hidden" id="applyUserEdit" name="applyUser" value="">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">审核意见</label>
            <div class="layui-input-block">
                <input type="text" id="auditOpinion" name="auditOpinion" value="" placeholder="请输入审核意见" class="layui-input">
            </div>
        </div>
    </div>
</form>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript">



</script>
</body>
</html>