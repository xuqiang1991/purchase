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
                <label class="layui-form-label">项目名称</label>
                <div class="layui-input-inline">
                    <input type="text" id="name" name="name" value="" placeholder="请输入项目名称" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">项目经理</label>
                <div class="layui-input-inline">
                    <select id="projectManager" name="projectManager">
                        <option value="">请选择项目经理</option>
                        <option value="0">绿化苗木</option>
                        <option value="1">园建水电</option>
                        <option value="2">机械租赁</option>
                        <option value="3">工程分包</option>
                    </select>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">委托商</label>
                <div class="layui-input-inline">
                    <select id="developer" name="developer" >
                        <option value="">请选择委托商</option>
                    </select>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">项目状态</label>
                <div class="layui-input-inline">
                    <select id="status" name="status">
                        <option value="">请选择项目状态</option>
                        <option value="0">未开工</option>
                        <option value="1">在建中</option>
                        <option value="2">验收中</option>
                        <option value="3">已完工</option>
                        <option value="4">已停工</option>
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
<div><table class="layui-hidden" id="projectMangerTable" lay-filter="projectMangerTable"></table></div>
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
        var url = ctx+'/projectManger/getProjectMangerList';
        table.render({
            id:'projectMangerTable'
            ,elem: '#projectMangerTable'
            ,url:url
            ,cellMinWidth: 100
            //,toolbar: '#toolbarDemo'
            ,limit:10//每页默认数
            ,limits:[10,20,30,40]
            ,cols: [[
                /*{type:'radio', width: 50,templet:"#radioTpl"}
                ,*/
                {field:'id', title: '序号', width: 60, templet: '#layIndex',event: 'setSign'}
                ,{field:'shortName', title: '项目简称',templet: '#hiddenIdTpl',event: 'setSign'}
                ,{field:'projectManagerName', title: '项目经理',event: 'setSign'}
                ,{field:'budgetLeaderName', title: '预算负责人',event: 'setSign'}
                ,{field:'developerName', title: '发展商',event: 'setSign'}
                ,{field:'consignorName', title: '委托商',event: 'setSign'}
                ,{field:'source', title: '项目来源',templet: '#sourceType',event: 'setSign'}
                ,{field:'nature', title: '项目性质',templet: '#natureType',event: 'setSign'}
                ,{field:'progressPlan', title: '工程进度方案',templet: '#progressPlanType',event: 'setSign'}
                ,{field:'status', title: '项目状态',templet: '#statusType',event: 'setSign'}
            ]]
            ,page:true
        });
        $(".query_btn").click(function() {
            search();
        })

        function search() {
            var name = $('#name'),
                projectManager = $('#projectManager option:selected'),
                developer = $('#developer option:selected'),
                status = $('#status option:selected');
            //执行重载
            //alert(url);
            table.reload('projectMangerTable',
                {
                    page : {curr : 1 },//重新从第 1 页开始
                    where : {
                        name : name.val(),
                        projectManager : projectManager.val(),
                        developer : developer.val(),
                        status : status.val()
                    }
                });
        }
    })


</script>
<script type="text/html" id="hiddenIdTpl">
    {{d.shortName}}<input type="hidden" name="id" value="{{d.id}}" />
</script>
<script type="text/html" id="layIndex">
    {{d.LAY_INDEX}}
</script>
<script type="text/html" id="hiddenIdTpl">
    {{d.fullname}}<input type="hidden" name="id" value="{{d.id}}" />
</script>
<script type="text/html" id="sourceType">
    {{#  if(d.source == 0){ }}
    议标
    {{# }else if(d.source == 1){ }}
    投标
    {{#  } else{ }}
    年度战略
    {{#  } }}
</script>
<script type="text/html" id="natureType">
    {{#  if(d.nature == 0){ }}
    地产景观
    {{# }else if(d.nature == 1){ }}
    市政公用
    {{#  } else{ }}
    旅游度假
    {{#  } }}
</script>

<script type="text/html" id="progressPlanType">
    {{#  if(d.progressPlan == 0){ }}
    综合方案
    {{# }else if(d.progressPlan == 1){ }}
    园建方案
    {{# }else if(d.progressPlan == 2){ }}
    水电工程
    {{# }else if(d.progressPlan == 3){ }}
    (园建+水电)方案
    {{#  } else{ }}
    绿化方案
    {{#  } }}
</script>
<script type="text/html" id="statusType">
    {{#  if(d.status == 0){ }}
    未开工
    {{# }else if(d.status == 1){ }}
    在建中
    {{# }else if(d.status == 2){ }}
    验收中
    {{# }else if(d.status == 3){ }}
    已完工
    {{#  } else{ }}
    已停工
    {{#  } }}
</script>
<%--<script defer type="text/javascript">
    console.log(document.getElementsByClassName('laytable-cell-1-0').length);
    document.getElementsByClassName('laytable-cell-1-0').style.width = '50px;';
</script>--%>
</body>
</html>