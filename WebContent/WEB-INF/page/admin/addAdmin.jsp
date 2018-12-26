<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>添加管理员</title>
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
.css-required:after {
    content: ' *';
    color: red;
    font-size: 150%;
}
</style>
</head>
<body class="childrenBody">
	<form class="layui-form layui-form-pane" style="width: 80%;" id="aaf">
		<div class="layui-form-item">
			<label class="layui-form-label css-required">登录名</label>
			<div class="layui-input-block">
				<input type="text" id="username" class="layui-input userName" lay-verify="required" placeholder="请输入登陆名" name="username" value="">
			</div>
		</div>
        <div class="layui-form-item">
            <label class="layui-form-label css-required">用户名</label>
            <div class="layui-input-block">
                <input type="text" name="fullname" class="layui-input userName" lay-verify="required" placeholder="请输入姓名" value="">
            </div>
        </div>
		<div class="layui-form-item">
			<label class="layui-form-label css-required">密码</label>
			<div class="layui-input-block">
				<input type="password" id="password" class="layui-input userName" lay-verify="pass" placeholder="请输入密码" name="password" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label css-required">确认密码</label>
			<div class="layui-input-block">
				<input type="password" class="layui-input userName" lay-verify="repass" placeholder="请输入确认密码" value="">
			</div>
		</div>
        <div class="layui-form-item" pane>
            <label class="layui-form-label css-required">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="1" title="男" checked>
                <input type="radio" name="sex" value="0" title="女">
                <input type="radio" name="sex" value="2" title="保密">
            </div>
        </div>
        <div class="layui-form-item" pane>
            <label class="layui-form-label css-required">用户类型</label>
            <div class="layui-input-block">
                <input type="radio" lay-filter="userType" name="userType" value="0" title="内部用户" checked>
                <input type="radio" lay-filter="userType" name="userType" value="1" title="外部用户">
            </div>
        </div>
        <div class="layui-form-item" id="userDeptsDiv">
            <label class="layui-form-label css-required">部门</label>
            <div class="layui-input-block">
                <select name="deptId"  lay-verify="deptId">
                    <option value="">请选择</option>
                    <c:forEach items="${depts }" var="d">
                        <option value="${d.id }">${d.name }</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item" id="userSuppliersDiv">
            <label class="layui-form-label css-required">供应商</label>
            <div class="layui-input-block">
                <select name="supplierId"  lay-verify="supplierId">
                    <option value="">请选择</option>
                    <c:forEach items="${suppliers }" var="s">
                        <option value="${s.id }">${s.name }</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item" pane>
            <label class="layui-form-label css-required">金额是否可见</label>
            <div class="layui-input-block">
                <input type="radio" lay-filter="isAmountVisible" name="isAmountVisible" value="0" title="可见" checked>
                <input type="radio" lay-filter="isAmountVisible" name="isAmountVisible" value="1" title="不可见">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label css-required">联系电话</label>
            <div class="layui-input-block">
                <input type="text" id="phone" name="phone" class="layui-input userName" lay-verify="enphone" placeholder="请输入手机号" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label css-required">电子邮箱</label>
            <div class="layui-input-block">
                <input type="text" id="eMail" name="eMail" class="layui-input userName" lay-verify="email" placeholder="请输入邮箱" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label css-required">入职日期</label>
            <div class="layui-input-block">
                <input type="text" id="entryDate" name="entryDate" class="layui-input userName" lay-verify="required" readonly placeholder="请输入选择日期" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label css-required">微信昵称</label>
            <div class="layui-input-block">
                <input type="text" name="wxNick" class="layui-input userName" placeholder="请输入微信昵称" value="">
            </div>
        </div>
		<div class="layui-form-item" pane>
			<label class="layui-form-label css-required">用户状态</label>
			<div class="layui-input-block">
				<input type="radio" name="isOnJob" value="1" title="有效" checked>
				<input type="radio" name="isOnJob" value="0" title="失效">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label css-required">分配角色</label>
			<div class="layui-input-block">
				<select name="roleId" lay-verify="required" multiple>
					<option value="">请选择</option>
					<c:forEach items="${roles }" var="r">
						<option value="${r.roleId }">${r.roleName }</option>
					</c:forEach>
				</select>
			</div>
		</div>
        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <textarea type="text" name="remark" class="layui-textarea" placeholder="请输入备注"></textarea>
            </div>
        </div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="addAdmin">保存</button>
                <%--<button class="layui-btn layui-btn-danger" lay-filter="closeAdmin">取消</button>--%>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/js/admin/addAdmin.js"></script>
</body>
</html>