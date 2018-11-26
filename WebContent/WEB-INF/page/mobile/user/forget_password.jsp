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
    <form class="mui-input-group" id="forget-form">
        <div class="mui-input-row">
            <label>原密码</label>
            <input id='oldPassword' name='oldPassword' type="password" class="mui-input-clear mui-input" placeholder="请输入原密码">
        </div>
        <div class="mui-input-row">
            <label>新密码</label>
            <input id='newPassword' name='newPassword' type="password" class="mui-input-clear mui-input" placeholder="请输入新密码">
        </div>
        <div class="mui-input-row">
            <label>确认密码</label>
            <input id='confirmPassword' name='confirmPassword' type="password" class="mui-input-clear mui-input" placeholder="请输入确认密码">
        </div>
    </form>
    <div class="mui-content-padded">
        <button id='sendMail' class="mui-btn mui-btn-block mui-btn-primary">确认修改</button>
    </div>
</div>

<script type="text/javascript" charset="utf-8">
    /** start 选择所属项目 **/
    mui(document.body).on('tap', '#sendMail', function(e) {
        var oldPassword = $('oldPassword').val()
        var newPassword = $('newPassword').val()
        var confirmPassword = $('confirmPassword').val()

        if(oldPassword == ""){
            mui.alert("请输入原密码");
            return false;
        }
        if(newPassword == ""){
            mui.alert("请输入新密码");
            return false;
        }
        if(confirmPassword == ""){
            mui.alert("请输入确认密码");
            return false;
        }

        if(newPassword != confirmPassword){
            mui.alert("新密码和确认密码不一致");
            return false;
        }

        $.ajax({
            type: "POST",
            url: "${ctx}/mobile/forgetPassword",
            data:$("#forget-form").serialize(),
            success: function (result) {
                if (result.code == 0) {//登录成功
                    var url = result.msg
                    var btnArray = ['确认'];
                    mui.confirm('密码修改成功，请重新登录。', btnArray, function(e) {
                        parent.location.href = "${ctx}" + url;
                    })
                } else{
                    mui.alert(result.msg);
                }
            }
        });
    });
</script>

</body>
</html>