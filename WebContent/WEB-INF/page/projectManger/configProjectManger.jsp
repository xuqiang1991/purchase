<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>添加项目</title>
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
        .layui-form-label{width: 180px;}
        .layui-input-block {
            margin-left: 210px;
        }
    </style>
</head>
<body class="childrenBody">
<form class="layui-form" style="width: 80%;" id="projectMangerForm">
    <input type="hidden" name="id" value="${projectManger.id}">
    <div class="layui-form-item">
        <label class="layui-form-label">项目名称</label>
        <div class="layui-input-block">
            <input type="text" id="fullName" class="layui-input" lay-verify="required" placeholder="请输入客户名称" name="fullName" value="${projectManger.name}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">项目简称</label>
        <div class="layui-input-block">
            <input type="text" id="shortName" class="layui-input" lay-verify="required" placeholder="请输入客户简称" name="shortName" value="${projectManger.shortName}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">项目来源</label>
        <div class="layui-input-block">
            <select name="source" lay-verify="required">
                <option value="" selected>请选择</option>
                <option value="0">议标</option>
                <option value="1">投标</option>
                <option value="2">年度战略</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">项目性质</label>
        <div class="layui-input-block">
            <select name="nature" lay-verify="required">
                <option value="">请选择</option>
                <option value="0">地产景观</option>
                <option value="1">市政公用</option>
                <option value="2">旅游度假</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">工程进度方案</label>
        <div class="layui-input-block">
            <select name="progressPlan" lay-verify="required">
                <option value="">请选择</option>
                <option value="0">综合方案</option>
                <option value="1">园建方案</option>
                <option value="2">水电工程</option>
                <option value="3">(园建+水电)方案</option>
                <option value="4">绿化方案</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">项目经理</label>
        <div class="layui-input-block">
           <%-- <input type="text" id="projectManager" name="projectManager" class="layui-input" placeholder="请输入项目经理" value="${projectManger.projectManager}">--%>
            <select name="projectManager" lay-verify="required">
                <option value="">请选择项目经理</option>
                <c:forEach items="${admins }" var="ad">
                    <c:choose>
                        <c:when test="${projectManger.projectManager == ad.id }">
                            <option value="${ad.id }" selected>${ad.fullname }</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${ad.id }">${ad.fullname }</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">预算负责人</label>
        <div class="layui-input-block">
            <select name="budgetLeader" lay-verify="required">
                <option value="">请选择预算负责人</option>
                <c:forEach items="${admins }" var="ad">
                    <c:choose>
                        <c:when test="${projectManger.budgetLeader == ad.id }">
                            <option value="${ad.id }" selected>${ad.fullname }</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${ad.id }">${ad.fullname }</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">发展商</label>
        <div class="layui-input-block">
           <%-- <input type="text" id="developer" class="layui-input " name="developer" placeholder="请输入发展商" value="${projectManger.developer}">--%>
            <select name="budgetLeader" lay-verify="required">
                <option value="">请选择发展商</option>
                <c:forEach items="${customersList }" var="customers">
                    <c:choose>
                        <c:when test="${projectManger.budgetLeader == customers.id }">
                            <option value="${customers.id }" selected>${customers.fullName } - ${customers.chargeName } - ${customers.chargePhone }</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${customers.id }">${customers.fullName } - ${customers.chargeName } - ${customers.chargePhone }</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
    </div>
    <%--<div class="layui-form-item">
        <label class="layui-form-label">发展商项目负责人</label>
        <div class="layui-input-block">
            <input type="text" id="developerLeaderName" class="layui-input " name="developerLeaderName" placeholder="请输入发展商项目负责人" value="${projectManger.developerLeaderName}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">发展商项目负责人电话</label>
        <div class="layui-input-block">
            <input type="text" id="developerLeaderPhone" class="layui-input " name="developerLeaderPhone" lay-verify="phone" placeholder="请输入发展商项目负责人电话" value="${projectManger.developerLeaderPhone}">
        </div>
    </div>--%>
    <div class="layui-form-item">
        <label class="layui-form-label">委托商</label>
        <div class="layui-input-block">
          <%--  <input type="text" id="consignor" class="layui-input " name="consignor" placeholder="请输入委托商" value="${projectManger.consignor}">--%>
            <select name="consignor" lay-verify="required">
                <option value="">请选择委托商</option>
                <c:forEach items="${customersList }" var="customers">
                    <c:choose>
                        <c:when test="${projectManger.consignor == customers.id }">
                            <option value="${customers.id }" selected>${customers.fullName } - ${customers.chargeName } - ${customers.chargePhone }</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${customers.id }">${customers.fullName } - ${customers.chargeName } - ${customers.chargePhone }</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
    </div>
    <%--<div class="layui-form-item">
        <label class="layui-form-label">委托商项目负责人</label>
        <div class="layui-input-block">
            <input type="text" id="consignorLeaderName" class="layui-input " name="consignorLeaderName" placeholder="请输入委托商项目负责人" value="${projectManger.consignorLeaderName}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">发展商项目负责人电话</label>
        <div class="layui-input-block">
            <input type="text" id="consignorLeaderPhone" class="layui-input " name="consignorLeaderPhone" lay-verify="phone" placeholder="请输入委托商项目负责人电话" value="${projectManger.consignorLeaderPhone}">
        </div>
    </div>--%>
    <div class="layui-form-item">
        <label class="layui-form-label">项目合同编号</label>
        <div class="layui-input-block">
            <input type="text" id="projectNo" class="layui-input " name="projectNo" placeholder="请输入项目合同编号" value="${projectManger.projectNo}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">合同金额</label>
        <div class="layui-input-block">
            <input type="text" id="contractPrice" class="layui-input " name="contractPrice" lay-verify="price" placeholder="请输入项目合同编号" value="${projectManger.contractPrice}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">结算方式</label>
        <div class="layui-input-block">
            <select name="progressPlan" lay-verify="required">
                <option value="">请选择</option>
                <option value="0">总价包干</option>
                <option value="1">单价包干</option>
                <option value="2">综合单价包干</option>
                <option value="3">按实结算</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">合同签定日期</label>
        <div class="layui-input-block">
            <input type="text" id="contractSignDate" class="layui-input " name="contractSignDate" placeholder="请选择合同签定日期" value="${projectManger.contractSignDate}">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">项目开工日期</label>
        <div class="layui-input-block">
            <input type="text" id="startDate" class="layui-input " name="startDate" placeholder="请选择合同签定日期" value="${projectManger.startDate}">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">项目完工日期</label>
        <div class="layui-input-block">
            <input type="text" id="overDate" class="layui-input " name="overDate" placeholder="请选择合同签定日期" value="${projectManger.overDate}">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">项目验收日期</label>
        <div class="layui-input-block">
            <input type="text" id="acceptanceDate" class="layui-input " name="acceptanceDate" placeholder="请选择合同签定日期" value="${projectManger.acceptanceDate}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">项目状态</label>
        <div class="layui-input-block">
            <select name="status" lay-verify="required">
                <option value="">请选择</option>
                <option value="0">未开工</option>
                <option value="1">在建中</option>
                <option value="2">已完工</option>
                <option value="3">已验收</option>
                <option value="4">已停工</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="projectMangerAdd">立即提交</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/projectManger/configProjectManger.js?v=123"></script>
</body>
</html>