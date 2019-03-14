<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form class="layui-form" style="margin: 10px 10px;">
    <div class="layui-form-item">
        <label class="layui-form-label">审批角色</label>
        <div class="layui-input-block">
            <select name="role" lay-verify="required" lay-search>
                <option value="请选择审批角色"></option>
                <c:if test="${fn:length(roleList) > 0}">
                    <c:forEach var="role" items="${roleList}">
                        <option value="${role.roleId}">${role.roleName}</option>
                    </c:forEach>
                </c:if>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">审批人</label>
        <div class="layui-input-block">
            <input type="text" id="selectReviewUserName" readonly lay-verify="required" class="layui-input" placeholder="请选择审批人" value="">
            <input type="hidden" id="selectReviewUser" name="reviewUser" value="">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">审核意见</label>
        <div class="layui-input-block">
            <textarea id="auditOpinion" name="auditOpinion" value="" placeholder="请输入审核意见" class="layui-textarea" rows="" cols=""></textarea>
        </div>
    </div>
</form>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/admin/adminSelect.js"></script>
<script type="text/javascript">
    layui.use(['layer','jquery','form'],function(){
        var layer = parent.layer === undefined ? layui.layer : parent.layer,$ = layui.jquery,form = layui.form;;
        $("#selectReviewUserName").click(function(){
            adminSelect('selectReviewUserName','reviewUser','selectReviewUserName');
        });
    })

</script>
</body>
</html>