<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>忘记密码</title>
    <link href="${ctx }/mui/css/mui.min.css" rel="stylesheet"/>
    <style>
        .area {
            margin: 20px auto 0px auto;
        }
        .mui-input-group:first-child {
            margin-top: 20px;
        }
        .mui-input-group label {
            width: 28%;
        }
        .mui-input-row label~input,
        .mui-input-row label~select,
        .mui-input-row label~textarea {
            width: 72%;
        }
        .mui-checkbox input[type=checkbox],
        .mui-radio input[type=radio] {
            top: 6px;
        }
        .mui-content-padded {
            margin-top: 25px;
        }
        .mui-btn {
            padding: 10px;
        }
        .mui-input-row label~input, .mui-input-row label~select, .mui-input-row label~textarea{
            margin-top: 1px;
        }
    </style>
    <script src="${ctx }/js/jquery-1.11.1.js"></script>
    <script src="${ctx}/mui/js/mui.min.js"></script>
</head>
<body>
<header class="mui-bar mui-bar-nav">
    <h1 class="mui-title">忘记密码</h1>
</header>

<div class="mui-content">
    <form class="mui-input-group">
        <div class="mui-input-row">
            <label>账号</label>
            <input id='account' type="text" class="mui-input-clear mui-input" placeholder="请输入账号">
        </div>
        <div class="mui-input-row">
            <label>原密码</label>
            <input id='oldPassword' type="password" class="mui-input-clear mui-input" placeholder="请输入原密码">
        </div>
        <div class="mui-input-row">
            <label>新密码</label>
            <input id='newPassword' type="password" class="mui-input-clear mui-input" placeholder="请输入新密码">
        </div>
        <div class="mui-input-row">
            <label>确认密码</label>
            <input id='confirmPassword' type="password" class="mui-input-clear mui-input" placeholder="请输入确认密码">
        </div>
    </form>
    <div class="mui-content-padded">
        <button id='sendMail' class="mui-btn mui-btn-block mui-btn-primary">确认修改</button>
    </div>
</div>

<script type="text/javascript" charset="utf-8">

</script>

</body>
</html>