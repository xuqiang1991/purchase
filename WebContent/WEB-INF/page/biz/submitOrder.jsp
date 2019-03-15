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
    <input id="id" name="id" type="hidden" value="${id}">
    <c:if test="${type == 1}">
        <div class="layui-form-item">
            <label class="layui-form-label">审核结果</label>
            <div class="layui-input-block">
                <input type="checkbox" checked="" id="auditResults" name="auditResults" name="auditResults" lay-skin="switch" lay-filter="auditResults" lay-text="驳回|通过">
            </div>
        </div>
    </c:if>
    <div class="layui-form-item" id="roleIdDiv">
        <label class="layui-form-label">审批角色</label>
        <div class="layui-input-block">
            <select id="roleId" name="roleId" lay-verify="required" lay-search>
                <option value="">请选择审批角色</option>
                <c:if test="${fn:length(roleList) > 0}">
                    <c:forEach var="role" items="${roleList}">
                        <option value="${role.roleId}">${role.roleName}</option>
                    </c:forEach>
                </c:if>
            </select>
        </div>
    </div>
    <div class="layui-form-item" id="userIdDiv">
        <label class="layui-form-label">审批人</label>
        <div class="layui-input-block">
            <%--<input type="text" id="selectReviewUserName" readonly lay-verify="required" class="layui-input" placeholder="请选择审批人" value="">
            <input type="hidden" id="selectReviewUser" name="reviewUser" value="">--%>
            <select id="userId" name="userId" lay-verify="required" lay-search>
                <option value="">请选择审批人</option>
            </select>
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
<script type="text/javascript">
    layui.use(['layer','jquery','form'],function(){
        var layer = parent.layer === undefined ? layui.layer : parent.layer,$ = layui.jquery,form = layui.form;
        /*$("#selectReviewUserName").click(function(){
            adminSelect('selectReviewUserName','reviewUser','selectReviewUserName');
        });*/
        form.on('select(reviewUser)', function(data){
            console.log(data.elem); //得到select原始DOM对象
            console.log(data.value); //得到被选中的值
            console.log(data.othis); //得到美化后的DOM对象
        });
        form.on('switch(auditResults)', function(data){
            console.log(data.elem); //得到checkbox原始DOM对象
            console.log(data.elem.checked); //开关是否开启，true或者false
            console.log(data.value); //开关value值，也可以通过data.elem.value得到
            console.log(data.othis); //得到美化后的DOM对象
            if(data.elem.checked){//通过
                $("#userIdDiv").show();
                $("#roleIdDiv").show();
            }else{
                $("#userIdDiv").hide();
                $("#roleIdDiv").hide();
            }
        });
    })

</script>
</body>
</html>