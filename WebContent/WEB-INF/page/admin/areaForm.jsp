<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>添加地区</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport"
		  content="width=device-width, initial-scale=1, maximum-scale=1">
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
	<input type="hidden" name="id" value="${area.id }"/>
	<input type="hidden" name="parentId" value="${area.parentId }"/>
	<input type="hidden" name="flag" value="${flag }"/>
	<div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label css-required">地区名称</label>
            <div class="layui-input-inline">
                <input type="text" id="name" class="layui-input name"  maxlength="50" lay-verify="required" placeholder="请输入地区名称" name="name" value="${area.name }">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label css-required">是否有效</label>
            <div class="layui-input-inline">
                <input type="radio" name="valid" value="1" title="有效" <c:if test="${area.valid}">checked</c:if>>
                <input type="radio" name="valid" value="0" title="无效" <c:if test="${!area.valid}">checked</c:if>>
            </div>
        </div>
    </div>
	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn" lay-submit="" lay-filter="areaForm">保存</button>
		</div>
	</div>
</form>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/admin/areaForm.js"></script>
</body>
</html>