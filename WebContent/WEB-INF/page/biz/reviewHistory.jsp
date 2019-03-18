<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>

<c:choose>
    <c:when test="${fn:length(historyList) > 0}">
        <c:forEach items="${historyList}" var="history" varStatus="status">
            <li class="layui-timeline-item">
                <i class="layui-icon layui-timeline-axis"></i>
                <div class="layui-timeline-content layui-text">
                    <div class="layui-timeline-title">
                        <c:choose>
                            <c:when test="${status.index == fn:length(historyList)}">创建</c:when>
                            <c:when test="${status.index == fn:length(historyList) - 1}">提交</c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${history.isApproval == 1}">审核通过</c:when>
                                    <c:otherwise>审核未通过</c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                        操作人:${history.approvalUserName}  <b><fmt:formatDate value="${history.approvalDate}" pattern="yyyy-MM-dd"/></b></div>
                    <c:choose>
                        <c:when test="${history.opinion == ''}">无</c:when>
                        <c:otherwise><p>${history.opinion}</p></c:otherwise>
                    </c:choose>
                </div>
            </li>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <div class="mui-collapse-content">
            <div class="mui-input-row">
                <label>暂无审核状态</label>
            </div>
        </div>
    </c:otherwise>
</c:choose>
