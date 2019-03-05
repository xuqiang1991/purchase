<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>添加指令单</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
    <script>var ctx = "${ctx}";</script>
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
<form class="layui-form" style="width: 90%; padding: 20px 0px 0px 20px;" id="instructOrderForm">
    <input type="hidden" name="id" value="${instructOrder.id}">
    <input type="hidden" id="pmId" name="pmId" value="${instructOrder.pmId}">
    <div class="layui-form-item">
        <label class="layui-form-label css-required">指令单号</label>
        <div class="layui-input-inline">
            <input type="text" id="instructNo" class="layui-input" lay-verify="required" maxlength="50" placeholder="请输指令单号" name="instructNo" value="${instructOrder.instructNo}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label css-required">类型</label>
        <div class="layui-input-block">
            <c:choose>
                <c:when test="${instructOrder.id == null || instructOrder.id == ''}">
                    <input type="radio" name="instructType" value="0" title="发展商指令" checked>
                    <input type="radio" name="instructType" value="1" title="内部指令">
                </c:when>
                <c:otherwise>
                    <c:choose>
                        <c:when test="${instructOrder.instructType == 0}">
                            <input type="radio" name="instructType" value="0" title="发展商指令" checked>
                            <input type="radio" name="instructType" value="1" title="内部指令" >
                        </c:when>
                        <c:otherwise>
                            <input type="radio" name="instructType" value="0" title="发展商指令" >
                            <input type="radio" name="instructType" value="1" title="内部指令" checked>
                        </c:otherwise>
                    </c:choose>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label css-required">下达日期</label>
        <div class="layui-input-inline">
            <input type="text" id="commandDate" class="layui-input" lay-verify="required" readonly placeholder="请选择下达日期" name="commandDate" value="<fmt:formatDate value="${instructOrder.commandDate}" pattern="yyyy-MM-dd"/>">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">下达人</label>
        <div class="layui-input-inline">
            <input type="text" id="commandUserName" class="layui-input" lay-verify="required" maxlength="50" placeholder="请输入下达人" name="commandUserName" value="${instructOrder.commandUserName}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">内容</label>
        <div class="layui-input-block">
            <textarea type="text" name="instructCentext" class="layui-textarea" placeholder="请输入指令单内容">${instructOrder.instructCentext}</textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="instructOrderAdd">保存</button>
        </div>
    </div>




</form>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<%--<script type="text/javascript" src="${ctx }/js/projectManger/configProjectManger.js?v=123"></script>--%>
<script type="text/javascript">

    var $;
    var $form;
    var form;
    layui.config({
        base : "js/"
    }).use(['form','layer','jquery','laydate','table'],function(){
        var layer = parent.layer === undefined ? layui.layer : parent.layer,
            laydate = layui.laydate;
        $ = layui.jquery;
        form = layui.form;table = layui.table;
        laydate.render({
            elem: '#commandDate' //指定元素
            //,max: 'new Date()'
        });
        form.verify({
            price: [
                /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/
                ,'金额格式错误'
            ]
        });
        form.on("submit(instructOrderAdd)",function(data){
            var pmId = $("#pmId").val();
            if(pmId == null || pmId == ''){
                layer.msg("请先添加项目！",{icon: 5});
                return;
            }else{
                //弹出loading
                var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
                /*var json = JSON.parse(data);*/

                var msg;
                $.ajax({
                    type: "post",
                    url: ctx+"/projectManger/saveInstruct",
                    data:data.field,
                    dataType:"json",
                    success:function(d){
                        if(d.code==0){
                            msg="添加成功！";
                        }else{
                            msg=d.msg;
                        }
                    }
                });
                setTimeout(function(){
                    top.layer.close(index);
                    top.layer.msg(msg);
                    layer.closeAll("iframe");
                    //刷新父页面
                    parent.location.reload();
                },2000);
            }
            return false;
        })
    })




</script>
</body>
</html>