<%@ page import="com.purchase.util.WebUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<%

    String requestHeader = request.getHeader("user-agent");
    boolean isMobile = WebUtils.isMobileDevice(requestHeader);

//    String path = request.getContextPath();
//    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    if(isMobile){
        response.sendRedirect("/sys/index");
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>登录--后台管理</title>
    <link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="${ctx }/css/login.css" media="all" />
    <script>  
        var ctx = "${ctx}";  
    </script>
    <script type="text/javascript">
        if(window !=top){
            top.location.href=location.href;
        }
    </script>
</head>
<body>


<div class="video_mask"></div>
<div class="login">
    <h1>管理员登录</h1>
    <form class="layui-form" id="form">
        <div class="layui-form-item">
            <input class="layui-input" name="username" placeholder="用户名" value="" lay-verify="required" type="text" autocomplete="off">
        </div>
        <div class="layui-form-item">
            <input class="layui-input" name="password" placeholder="密码" value=""  lay-verify="required" type="password" autocomplete="off">
        </div>
        <div class="layui-form-item form_code">
            <input class="layui-input" style="width: 140px;" name="vcode" placeholder="验证码" lay-verify="required" type="text" autocomplete="off" maxlength="4" value="1234">
            <div class="code"><img id="captcha" src="${ctx }/sys/vcode" width="100" height="36" onclick="refreshCode(this)"></div>
        </div>
        <%--<input name="vcode" type="hidden" value="1234">--%>
        <button class="layui-btn login_btn" lay-submit="" lay-filter="login" id="btn">登录</button>
    </form>
</div>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/login.js"></script>
</body>
</html>