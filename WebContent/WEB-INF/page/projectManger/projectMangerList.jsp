<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>项目列表</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
<meta http-equiv="expires" content="Wed, 26 Feb 1997 08:21:57 GMT">
<link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="${ctx }/css/font_eolqem241z66flxr.css" media="all" />
<link rel="stylesheet" href="${ctx }/css/list.css" media="all" />
<script>
	var ctx = "${ctx}";
</script>
</head>
<body class="childrenBody">
	<blockquote class="layui-elem-quote list_search">
        <form class="layui-form">
            <!-- 查询条件块 start -->
            <div>
                <div class="layui-input-inline">
                    <input type="text" id="name" value="" placeholder="请输入项目名称" class="layui-input search_input">
                </div>
                <div class="layui-input-inline layui-form">
                    <select id="projectManager" name="projectManager" >
                        <option value="">请选择项目经理</option>
                        <c:forEach items="${admins }" var="ad">
                            <option value="${ad.id }">${ad.fullname }</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="layui-input-inline layui-form">
                    <select id="developer" name="developer">
                        <option value="">请选择发展商</option>
                        <c:forEach items="${customersList }" var="customers">
                            <%--<option value="${customers.id }">${customers.fullName } - ${customers.chargeName } - ${customers.chargePhone }</option>--%>
                            <option value="${customers.id }">${customers.fullName }</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="layui-input-inline layui-form">
                    <select id="consignor" name="consignor">
                        <option value="">请选择委托商</option>
                        <c:forEach items="${customersList }" var="customers">
                            <option value="${customers.id }">${customers.fullName }</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="layui-input-inline layui-form">
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
            <!-- 查询条件块 end -->
           <shiro:hasPermission name="sys:projectManger:query">
               <div class="layui-inline">
                   <a class="layui-btn projectMangerQuery_btn"><i class="layui-icon">&#xe615;</i>查询</a>
               </div>
            </shiro:hasPermission>
            <shiro:hasPermission name="sys:projectManger:save">
                <div class="layui-inline">
                    <a class="layui-btn projectMangerAdd_btn"><i class="layui-icon">&#xe608;</i>添加</a>
                </div>
            </shiro:hasPermission>
            <shiro:hasPermission name="sys:projectManger:update">
                <div class="layui-inline">
                    <a class="layui-btn projectMangerUpdate_btn"><i class="layui-icon">&#xe642;</i>编辑</a>
                </div>
            </shiro:hasPermission>
            <shiro:hasPermission name="sys:projectManger:delete">
                <div class="layui-inline">
                    <a class="layui-btn layui-btn-danger projectMangerDel_btn" data-type="delCheckData"><i class="layui-icon">&#xe640;</i>删除</a>
                </div>
            </shiro:hasPermission>
        </form>
	</blockquote>
	<!-- 数据表格 -->
	<table id="projectMangerList" class="projectMangerList" lay-filter="projectMangerList"></table>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/js/projectManger/projectMangerList.js"></script>
	<script type="text/html" id="barEdit">
	  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
	  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>


    <script type="text/html" id="layIndex">
        {{d.LAY_INDEX}}
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
    <script type="text/html" id="radioTpl">
        <input type="radio" name="projectMangerId" value="{{d.id}}" title=" " lay-filter="radiodemo">
    </script>
</body>
</html>