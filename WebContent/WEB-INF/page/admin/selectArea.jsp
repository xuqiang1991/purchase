<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>layout Layui</title>
	<link rel="stylesheet" href="${ctx }/layui/css/layui.css">
	<style type="text/css">
		/* 数据表格复选框正常显示 */
		.layui-table-cell .layui-form-checkbox[lay-skin="primary"]{
			top: 50%;
			transform: translateY(-50%);
		}
	</style>
	<script src="${ctx }/layui/layui.js"></script>
	<script>
        var ctx = "${ctx}";
	</script>
</head>
<body class="layui-layout-body" style="overflow:auto">
<!-- 数据表格 -->
<div><table class="layui-hidden" id="treeTable" lay-filter="treeTable"></table></div>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['element', 'layer', 'form', 'upload', 'treeGrid','jquery'], function () {
        var treeGrid = layui.treeGrid, //很重要
            $ = layui.jquery;
        var treeTable =treeGrid.render({
            id:'treeTable'
            ,elem: '#treeTable'
            ,url:ctx+'/sys/getSelectArea'
            ,cellMinWidth: 100
            ,treeId:'id'//树形id字段名称
            ,treeUpId:'parentId'//树形父id字段名称
            ,treeShowName:'name'//以树形式显示的字段
            ,cols: [[
                {field: 'id',title: 'ID',width:80, templet:"#radioTpl",unresize:true}
                ,{field:'name', title: '名称'}
            ]]
            ,page:false
        });
    })

</script>
<script type="text/html" id="radioTpl">
	<input type="radio" name="id" value="{{d.id}}" m="{{d.name}}" title=" " lay-filter="radiodemo">
</script>
</body>
</html>