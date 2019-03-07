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
        .laytable-cell-1-0{
            width: 50px;
        }
		/* 数据表格复选框正常显示 */
		.layui-table-cell .layui-form-checkbox[lay-skin="primary"]{
			top: 50%;
			transform: translateY(-50%);
		}
        .layui-input{
            height: 30px;
        }
        .layui-elem-quote{
            margin-bottom: -10px;
            padding: 5px;
        }
        .layui-form-radio i{
            font-size: 16px;
        }
        .layui-table-cell{
            height: 20px;
            line-height: 20px;
        }
	</style>
	<script src="${ctx }/layui/layui.js"></script>
	<script>
        var ctx = "${ctx}";
	</script>
</head>
<body class="layui-layout-body" style="overflow:auto">
<blockquote class="layui-elem-quote">
    <form class="layui-form">
        <div class="layui-form-item" style="margin-bottom: 5px">
            <div class="layui-inline">
                <label class="layui-form-label">名称</label>
                <div class="layui-input-inline">
                    <input type="text" id="name" value="" placeholder="请输入名称" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">供应商类别</label>
                <div class="layui-input-inline">
                    <select name="type" id="type">
                        <option value="">请选择供应商类别</option>
                        <option value="0">材料供应商</option>
                        <option value="1">工程分包商</option>
                    </select>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">地区</label>
                <div class="layui-input-inline">
                    <input type="text" id="areaName" class="layui-input" placeholder="请选择地区" name="areaName" readonly>
                    <input type="hidden" id="areaId" name="areaId" value="">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">是否有效</label>
                <div class="layui-input-inline">
                    <select name="valid" id="valid">
                        <option value="">请选择是否有效</option>
                        <option value="1">有效</option>
                        <option value="0">无效</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-inline">
            <a class="layui-btn query_btn"><i class="layui-icon">&#xe615;</i>查询</a>
        </div>
    </form>
</blockquote>
<!-- 数据表格 -->
<div><table class="layui-hidden" id="supplierTable" lay-filter="supplierTable"></table></div>
<%--<style type="text/css">
    .laytable-cell-1-0{
        width: 60px;
    }
</style>--%>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript">
    var $ = null;
    layui.use(['element', 'layer', 'form', 'upload', 'table','jquery'], function () {
        var table = layui.table,$ = layui.jquery;
        var url = ctx+'/supplier/getSupplierList';
        table.render({
            id:'supplierTable'
            ,elem: '#supplierTable'
            ,url:url
            ,cellMinWidth: 100
            //,toolbar: '#toolbarDemo'
            ,limit:10//每页默认数
            ,limits:[10,20,30,40]
            ,cols: [[
                /*{type:'radio', width: 50,templet:"#radioTpl"}
                ,*/
                {field:'id', title: '序号', width: 60, templet: '#layIndex',event: 'setSign'}
                ,{field:'name', title: '名称',templet: '#hiddenIdTpl',event: 'setSign'}
                ,{field:'nick', title: '简称',event: 'setSign'}
                ,{field:'type', title: '供应商类别',templet:"#typeTpl",event: 'setSign'}
                ,{field:'areaName', title: '地区',event: 'setSign'}
                ,{field:'principalName', title: '负责人',event: 'setSign'}
                ,{field:'contactName', title: '联系人',event: 'setSign'}
                ,{field:'contactPhone', title: '联系人电话',event: 'setSign'}
                ,{field:'valid', title: '是否有效',templet:"#validTpl",event: 'setSign'}
            ]]
            ,page:true
        });
        $(".query_btn").click(function() {
            search();
        })

        function search() {
            var name = $('#name'),
                type = $('#type option:selected'),
                areaId = $('#areaId'),
                valid = $('#valid option:selected');
            //执行重载
            //alert(url);
            table.reload('supplierTable',
                {
                    page : {curr : 1 },//重新从第 1 页开始
                    where : {
                        name : name.val(),
                        type : type.val(),
                        areaId : areaId.val(),
                        valid : valid.val()
                    }
                });
        }
    })


</script>
<script type="text/html" id="hiddenIdTpl">
    {{d.name}}<input type="hidden" name="id" value="{{d.id}}" />
</script>
<script type="text/html" id="layIndex">
    {{d.LAY_INDEX}}
</script>
<script type="text/html" id="typeTpl">
    {{#  if(d.type === 0){ }}
    材料供应商
    {{#  } else if(d.type === 1){ }}
    工程分包商
    {{#  } }}
</script>
<script type="text/html" id="validTpl">
    {{#  if(d.valid){ }}
    <span style="color: #FFB800;">有效</span>
    {{#  } else if(!d.valid){ }}
    <span style="color: #01AAED;">无效</span>
    {{#  } }}
</script>
</body>
</html>