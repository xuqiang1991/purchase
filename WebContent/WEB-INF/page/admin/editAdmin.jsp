<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>编辑管理员</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
<script>  
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
.css-required:before {
    content: '*';
    color: red;
    font-size: 150%;
    display:inline-block;
    vertical-align:-webkit-baseline-middle;
}
</style>
</head>
<body class="childrenBody">
	<form class="layui-form" style="width: 90%; padding: 20px 0px 0px 20px">
		<!-- 管理员id -->
		<input type="hidden" name="id" value="${ad.id }"/>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label css-required">登录名</label>
                <div class="layui-input-inline">
                    <input type="text" id="username" class="layui-input userName" readonly lay-verify="usernameCheck" placeholder="请输入登陆名" name="username" value="${ad.username }">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label css-required">密码</label>
                <div class="layui-input-inline">
                    <input type="password" id="password" class="layui-input userName" lay-verify="pass" disabled placeholder="请输入密码" value="*******************">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label css-required">确认密码</label>
                <div class="layui-input-inline">
                    <input type="password" class="layui-input userName" lay-verify="repass" readonly placeholder="请输入确认密码" value="*******************">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label css-required">用户名</label>
                <div class="layui-input-inline">
                    <input type="text" name="fullname" class="layui-input userName" lay-verify="required" placeholder="请输入姓名" value="${ad.fullname }">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label css-required">联系电话</label>
                <div class="layui-input-inline">
                    <input type="text" id="phone" name="phone" class="layui-input userName" lay-verify="enphone" placeholder="请输入手机号" value="${ad.phone }">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label css-required">电子邮箱</label>
                <div class="layui-input-inline">
                    <input type="text" id="eMail" name="eMail" class="layui-input userName" lay-verify="email" placeholder="请输入邮箱" value="${ad.eMail }">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label css-required">性别</label>
                <div class="layui-input-inline">
                    <c:if test="${ad.sex=='0' }">
                        <input type="radio" name="sex" value="1" title="男" >
                        <input type="radio" name="sex" value="0" title="女" checked>
                    </c:if>
                    <c:if test="${ad.sex=='1' }">
                        <input type="radio" name="sex" value="1" title="男" checked>
                        <input type="radio" name="sex" value="0" title="女" >
                    </c:if>
                   <%-- <c:if test="${ad.sex=='2' }">
                        <input type="radio" name="sex" value="1" title="男" >
                        <input type="radio" name="sex" value="0" title="女">
                        <input type="radio" name="sex" value="2" title="保密" checked>
                    </c:if>--%>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label css-required">金额权限</label>
                <div class="layui-input-block">
                    <c:if test="${ad.isAmountVisible == '0' }">
                        <input type="radio" lay-filter="isAmountVisible" name="isAmountVisible" value="0" title="开启" checked>
                        <input type="radio" lay-filter="isAmountVisible" name="isAmountVisible" value="1" title="关闭">
                    </c:if>
                    <c:if test="${ad.isAmountVisible == '1' }">
                        <input type="radio" lay-filter="isAmountVisible" name="isAmountVisible" value="0" title="开启" >
                        <input type="radio" lay-filter="isAmountVisible" name="isAmountVisible" value="1" title="关闭" checked>
                    </c:if>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label css-required">用户状态</label>
                <div class="layui-input-inline">
                    <c:choose>
                        <c:when test="${ad.id != null && ad.id != ''}">
                            <c:choose>
                                <c:when test="${ad.isOnJob == 0}">
                                    <input type="radio" name="isOnJob" value="1" title="有效" >
                                    <input type="radio" name="isOnJob" value="0" title="失效" checked>
                                </c:when>
                                <c:otherwise>
                                    <input type="radio" name="isOnJob" value="1" title="有效" checked>
                                    <input type="radio" name="isOnJob" value="0" title="失效">
                                </c:otherwise>
                            </c:choose>
                        </c:when>
                    </c:choose>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label css-required">用户类型</label>
                <div class="layui-input-inline">
                    <c:if test="${ad.userType == '0' }">
                        <input type="radio" lay-filter="userType" name="userType" value="0" title="内部" checked>
                        <input type="radio" lay-filter="userType" name="userType" value="1" title="外部">
                    </c:if>
                    <c:if test="${ad.userType == '1' }">
                        <input type="radio" lay-filter="userType" name="userType" value="0" title="内部" >
                        <input type="radio" lay-filter="userType" name="userType" value="1" title="外部" checked>
                    </c:if>
                </div>
            </div>
            <div class="layui-inline" id="userDeptsDiv">
                <label class="layui-form-label css-required">部门</label>
                <div class="layui-input-inline">
                    <select name="deptId"  lay-verify="deptId">
                        <option value="">请选择</option>
                        <c:forEach items="${depts }" var="d">
                            <c:if test="${ad.deptId==d.id }">
                                <option value="${d.id }" selected>${d.name }</option>
                            </c:if>
                            <c:if test="${ad.deptId!=d.id }">
                                <option value="${d.id }">${d.name }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="layui-inline" id="userSuppliersDiv">
                <label class="layui-form-label css-required">供应商</label>
                <div class="layui-input-inline">
                    <select name="supplierId"  lay-verify="supplierId">
                        <option value="">请选择</option>
                        <c:forEach items="${suppliers }" var="s">
                            <c:if test="${ad.supplierId==s.id }">
                                <option value="${s.id }" selected>${s.name }</option>
                            </c:if>
                            <c:if test="${ad.supplierId!=s.id }">
                                <option value="${s.id }">${s.name }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label css-required">入职日期</label>
                <div class="layui-input-inline">
                    <input type="text" id="entryDate" name="entryDate" class="layui-input userName" lay-verify="required" readonly placeholder="请输入选择日期" value="${fn:substring(ad.entryDate, 0, 10)}">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label css-required">微信昵称</label>
                <div class="layui-input-inline">
                    <input type="text" name="wxNick" class="layui-input userName" placeholder="请输入微信昵称" value="${ad.wxNick}">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label css-required">分配角色</label>
            <div class="layui-input-block">
                <select name="roleId" multiple>
                    <option value="">请选择</option>
                    <c:forEach items="${roles }" var="r">
                        <c:set var="i" value="0"></c:set>
                        <c:forEach items="${ad.roleId}" var="s">
                            <c:if test="${s==r.roleId }">
                                <option value="${r.roleId }" selected>${r.roleName }</option>
                                <c:set var="i" value="1"></c:set>
                            </c:if>
                        </c:forEach>
                        <c:if test="${i == 0}">
                            <option value="${r.roleId }">${r.roleName }</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <textarea type="text" name="remark" class="layui-textarea" placeholder="请输入备注">${ad.remark}</textarea>
            </div>
        </div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="updAdmin">保存</button>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/js/admin/editAdmin.js"></script>
    <script type="text/javascript">
        var userType = '${ad.userType}';
    </script>
</body>
</html>