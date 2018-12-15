<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>

<li class="mui-table-view-cell mui-collapse">
    <a class="mui-navigate-right" href="#">审核状态</a>
    <c:choose>
        <c:when test="${fn:length(historyList) > 0}">
            <c:forEach items="${historyList}" var="history" varStatus="status">
                <div class="mui-collapse-content">
                    <p>
                        <strong>${ fn:length(historyList) - (status.index )}.
                            <c:choose>
                                <c:when test="${status.index == fn:length(historyList)}">创建</c:when>
                                <c:when test="${status.index == fn:length(historyList) - 1}">提交</c:when>
                                <c:otherwise>
                                    <c:choose>
                                        <c:when test="${history.approval == true}">审核通过</c:when>
                                        <c:otherwise>审核未通过</c:otherwise>
                                    </c:choose>
                                </c:otherwise>
                            </c:choose>
                        </strong>
                        <label>操作人:${history.approvalUserName}</label>
                        <label>操作时间:<fmt:formatDate value="${history.approvalDate}" pattern="yyyy-MM-dd"/></label>
                    </p>
                    <p>
                        <label>意见:
                            <c:choose>
                                <c:when test="${history.opinion == ''}">无</c:when>
                                <c:otherwise>${history.opinion}</c:otherwise>
                            </c:choose>
                        </label>
                    </p>
                </div>
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

</li>