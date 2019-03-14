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
                <label class="layui-form-label">用户/登录名</label>
                <div class="layui-input-inline">
                    <input type="text" id="keyWord" name="keyWord" value="" placeholder="请输入用户/登录名" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">所属部门</label>
                <div class="layui-input-inline">
                    <select id="deptId" name="deptId" lay-search>
                        <option value="">请选择所属部门</option>
                        <c:if test="${fn:length(deptList) > 0}">
                            <c:forEach var="dept" items="${deptList}">
                                <option value="${dept.id}">${dept.name}</option>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">供应商</label>
                <div class="layui-input-inline">
                    <select id="supplierId" name="supplierId" lay-search>
                        <option value="">请选择供应商</option>
                        <c:if test="${fn:length(supplierList) > 0}">
                            <c:forEach var="supplier" items="${supplierList}">
                                <option value="${supplier.id}">${supplier.name}</option>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">用户状态</label>
                <div class="layui-input-inline">
                    <select id="isOnJob" name="isOnJob" lay-search>
                        <option value="">请选择用户状态</option>
                        <option value="1">有效</option>
                        <option value="0">失效</option>
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
<div><table class="layui-hidden" id="adminTable" lay-filter="adminTable"></table></div>
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
        var url = ctx+'/sys/getAdminList';
        table.render({
            id:'adminTable'
            ,elem: '#adminTable'
            ,url:url
            ,cellMinWidth: 100
            //,toolbar: '#toolbarDemo'
            ,limit:10//每页默认数
            ,limits:[10,20,30,40]
            ,cols: [[
                /*{type:'radio', width: 50,templet:"#radioTpl"}
                ,*/
                {field:'id', title: '序号', width: 60, templet: '#layIndex',event: 'setSign'}
                ,{field:'fullname', width: 120, title: '用户名',templet: '#hiddenIdTpl',event: 'setSign'}
                ,{field:'username', width: 120, title: '登录名',event: 'setSign'}
                ,{field:'userType', width: 100, title: '用户类型',templet: '#userTypeTpl',event: 'setSign'}
                ,{field:'deptName', width: 100, title: '所属部门',event: 'setSign'}
                ,{field:'supplierName', width: 120, title: '所属供应商',event: 'setSign'}
            ]]
            ,page:true
        });
        $(".query_btn").click(function() {
            search();
        })

        function search() {
            var keyWord = $('#keyWord'),
                deptId = $('#deptId option:selected'),
                supplierId = $('#supplierId option:selected'),
                isOnJob = $('#isOnJob option:selected');
            //执行重载
            //alert(url);
            table.reload('adminTable',
                {
                    page : {curr : 1 },//重新从第 1 页开始
                    where : {
                        keyWord : keyWord.val(),
                        deptId : deptId.val(),
                        supplierId : supplierId.val(),
                        isOnJob : isOnJob.val()
                    }
                });
        }
    })
</script>
<script type="text/html" id="layIndex">
    {{d.LAY_INDEX}}
</script>
<script type="text/html" id="hiddenIdTpl">
    {{d.fullname}}<input type="hidden" name="id" value="{{d.id}}" />
</script>
<script type="text/html" id="userTypeTpl">
    {{#  if(d.userType == 1){ }}
    外部用户
    {{#  } else{ }}
    内部用户
    {{#  } }}
</script>
</body>
</html>