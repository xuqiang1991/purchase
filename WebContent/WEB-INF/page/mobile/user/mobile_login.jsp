<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>登录</title>
    <link href="${ctx }/mui/css/mui.min.css" rel="stylesheet"/>
    <style>
        .area {
            margin: 20px auto 0px auto;
        }

        .mui-input-group {
            margin-top: 10px;
        }

        .mui-input-group:first-child {
            margin-top: 20px;
        }

        .mui-input-group label {
            width: 22%;
        }

        .mui-input-row label~input,
        .mui-input-row label~select,
        .mui-input-row label~textarea {
            width: 78%;
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

        .link-area {
            display: block;
            margin-top: 25px;
            text-align: center;
        }

        .spliter {
            color: #bbb;
            padding: 0px 8px;
        }

        .oauth-area {
            position: absolute;
            bottom: 20px;
            left: 0px;
            text-align: center;
            width: 100%;
            padding: 0px;
            margin: 0px;
        }

        .oauth-area .oauth-btn {
            display: inline-block;
            width: 50px;
            height: 50px;
            background-size: 30px 30px;
            background-position: center center;
            background-repeat: no-repeat;
            margin: 0px 20px;
            /*-webkit-filter: grayscale(100%); */
            border: solid 1px #ddd;
            border-radius: 25px;
        }

        .oauth-area .oauth-btn:active {
            border: solid 1px #aaa;
        }

        .oauth-area .oauth-btn.disabled {
            background-color: #ddd;
        }
    </style>
    <script src="${ctx }/js/jquery-1.11.1.js"></script>
    <script src="${ctx}/mui/js/mui.min.js"></script>
</head>
<body>
<header class="mui-bar mui-bar-nav">
    <h1 class="mui-title">登录</h1>
</header>

<div class="mui-content">
    <form id='login-form' class="mui-input-group">
        <div class="mui-input-row">
            <label>账号</label>
            <input id='username' name="username" type="text" class="mui-input-clear mui-input" placeholder="请输入账号">
        </div>
        <div class="mui-input-row">
            <label>密码</label>
            <input id='password'  name="password" type="password" class="mui-input-clear mui-input" placeholder="请输入密码">
        </div>
    </form>
    <div class="mui-content-padded">
        <button id='login' type="button" class="mui-btn mui-btn-block mui-btn-primary">登录</button>
        <%--<div class="link-area"><a id='forgetPassword' href="${ctx }/mobile/forgetPassword">忘记密码</a>--%>
        <%--</div>--%>
    </div>
    <div class="mui-content-padded oauth-area">

    </div>
</div>


<script type="text/javascript" charset="utf-8">
    /** start 选择所属项目 **/
    mui(document.body).on('tap', '#login', function(e) {

        var account = $('username').val()
        var password = $('password').val()
        if(account == ""){
            mui.alert("请输入账号");
            return false;
        }
        if(password == ""){
            mui.alert("请输入密码");
            return false;
        }

        $.ajax({
            type: "POST",
            url: "${ctx}/mobile/mobileLogin",
            data:$("#login-form").serialize(),
            success: function (result) {
                if (result.code == 0) {//登录成功
                    var url = result.msg
                    parent.location.href = "${ctx}" + url;
                } else{
                    mui.alert(result.msg);
                }
            }
        });
    });



</script>

</body>
</html>