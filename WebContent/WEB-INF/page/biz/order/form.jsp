<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title></title>
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

.layui-form-item{
    margin-bottom: 0px;
}
.layui-form-item .layui-inline{
    width: 25%;
}
.layui-textarea{
    min-height: 60px;
}
.layui-elem-quote{
    padding:5px 5px;
    border-left: 5px;
}
.layui-form-label{
    padding: 5px 5px;
}
.layui-input, .layui-textarea, .layui-select{
    height: 30px;
}
.layui-input-block{
    margin-left: 90px;
}
.layui-table-cell{
    height: 25px;
    line-height: 25px;
    padding: 0px 0px;
}
.layui-table[lay-size="sm"] th, .layui-table[lay-size="sm"] td{
    padding-bottom: 0px;
}
.layui-table[lay-size="sm"] th:first-child, .layui-table[lay-size="sm"] td:first-child{
    width: 30px;
}
.layui-table[lay-size="sm"] th:last-child, .layui-table[lay-size="sm"] td:last-child{
    width: 50px;
}
</style>
</head>
<body class="childrenBody">
	<form class="layui-form" style="" id="layuiForm">
        <blockquote class="layui-elem-quote">
            <button class="layui-btn layui-btn-sm" lay-submit="" lay-filter="save">保存</button>
            <button class="layui-btn layui-btn-sm" type="button" onclick="submitOrder()">提交</button>
            <button class="layui-btn layui-btn-sm" type="button" onclick="reviewOrder()">审核</button>
            <button class="layui-btn layui-btn-sm layui-btn-danger" type="button" onclick="invalidOrder()">作废</button>
        </blockquote>
        <input type="hidden" id="orderId" name="id" value="${orderVo.id}">
		<div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">单号</label>
                <div class="layui-input-inline">
                    <input type="text" id="orderNo" name="orderNo" value="${orderVo.orderNo}" disabled readonly placeholder="系统自动生成" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label css-required">订单类型</label>
                <div class="layui-input-inline">
                    <select id="type" name="type" lay-verify="required" lay-search>
                        <option value="">请选择订单类型</option>
                        <option value="0" <c:if test="${orderVo.type == 0}">selected</c:if>>绿化苗木</option>
                        <option value="1" <c:if test="${orderVo.type == 1}">selected</c:if>>园建水电</option>
                        <option value="2" <c:if test="${orderVo.type == 2}">selected</c:if>>机械租赁</option>
                        <option value="3" <c:if test="${orderVo.type == 3}">selected</c:if>>工程分包</option>
                    </select>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label css-required">所属项目</label>
                <div class="layui-input-inline">
                    <input type="text" id="selectProjectId" readonly lay-verify="required"  class="layui-input" placeholder="请选择所属项目" value="${orderVo.tpm.name}">
                    <input type="hidden" id="projectId" name="projectId" value="${orderVo.projectId}">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label css-required">供应商</label>
                <div class="layui-input-inline">
                    <input type="text" id="selectSupplierId" readonly lay-verify="required" class="layui-input" placeholder="请选择所属项目" value="${orderVo.supplier.name}">
                    <input type="hidden" id="supplierId" name="supplierId" value="${orderVo.supplier.id}">
                </div>
            </div>
        </div>
		<div class="layui-form-item">

            <div class="layui-inline">
                <label class="layui-form-label css-required">申请人</label>
                <div class="layui-input-inline">
                    <c:choose>
                        <c:when test="${orderVo.id == null}">
                            <input type="text" id="selectApplyUserEdit" readonly lay-verify="required" class="layui-input" placeholder="请选择申请人" value="${admin.fullname}">
                            <input type="hidden" id="applyUserEdit" name="applyUser" value="${admin.id}">
                        </c:when>
                        <c:otherwise>
                            <input type="text" id="selectApplyUserEdit" readonly lay-verify="required" class="layui-input" placeholder="请选择申请人" value="${orderVo.admin.fullname}">
                            <input type="hidden" id="applyUserEdit" name="applyUser" value="${orderVo.admin.id}">
                        </c:otherwise>
                    </c:choose>
                </div>
		    </div>
            <div class="layui-inline">
                <label class="layui-form-label css-required">申请日期</label>
                <div class="layui-input-inline">
                    <input type="text" id="applyDate" name="applyDate" class="layui-input" lay-verify="required" placeholder="请选择申请日期" value="<fmt:formatDate value="${orderVo.applyDate}" pattern="yyyy-MM-dd"/>">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">合同号</label>
                <div class="layui-input-inline">
                    <input type="text" name="contractNo" class="layui-input" maxlength="50" placeholder="请输入合同号" value="${orderVo.contractNo}">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">签订时间</label>
                <div class="layui-input-inline">
                    <input type="text" id="contractSignDate" name="contractSignDate" class="layui-input" placeholder="请选择签订时间" value="<fmt:formatDate value="${orderVo.contractSignDate}" pattern="yyyy-MM-dd"/>">
                </div>
            </div>
        </div>
		<div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label css-require">合同总金额</label>
                <div class="layui-input-inline">
                    <input type="text" id="contractMoney" class="layui-input " name="contractMoney" lay-verify="price" maxlength="20" placeholder="请输入合同总金额" value="${orderVo.contractMoney}">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label css-required">已付款总额</label>
                <div class="layui-input-inline">
                    <input type="text" name="paymentAmount" class="layui-input" readonly placeholder="系统回写" value="${orderVo.paymentAmount}">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label css-required">付款比例</label>
                <div class="layui-input-inline">
                    <input type="text" name="paymentRatio" class="layui-input" lay-verify="required" placeholder="请输入付款比例" value="${orderVo.paymentRatio}">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">退订金额</label>
                <div class="layui-input-inline">
                    <input type="text" id="unsubscribedAmount" class="layui-input " name="unsubscribedAmount" readonly placeholder="系统回写" value="${orderVo.unsubscribedAmount}">
                </div>
            </div>
        </div>
		<%--<div class="layui-form-item">

		</div>--%>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label css-required">已请款总额</label>
                <div class="layui-input-inline">
                    <input type="text" name="requestAmount" class="layui-input" readonly placeholder="系统回写" value="${orderVo.requestAmount}">
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">质保期(月)</label>
                <div class="layui-input-inline">
                    <input type="text" id="warrantyDate" name="warrantyDate" class="layui-input" maxlength="10" placeholder="请输入质保期(月)" value="${orderVo.warrantyDate}">
                </div>
            </div>
        </div>
		<div class="layui-form-item">
			<label class="layui-form-label">摘要</label>
			<div class="layui-input-block">
				<textarea type="text" name="summary" class="layui-textarea" maxlength="100" placeholder="请输入摘要">${orderVo.summary}</textarea>
			</div>
		</div>
    </form>

    <%--<hr class="layui-bg-gray">--%>
    <%--<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
        <legend>订单明细及审核流程</legend>
    </fieldset>--%>


    <div class="layui-tab layui-tab-brief">
        <ul class="layui-tab-title">
            <li class="layui-this">订单明细</li>
            <li>审核流程</li>
        </ul>
        <div class="layui-tab-content" style="padding: 0px;">
            <div class="layui-tab-item layui-show">
                <div class="layui-table-header">
                    <blockquote class="layui-elem-quote" style="margin-bottom: 0px;">
                        <a class="layui-btn layui-btn-sm add_btn_item" onclick="add()"><i class="layui-icon"></i>增加</a>
                        <a class="layui-btn layui-btn-sm save_btn_item" onclick="saveItem()"><i class="layui-icon"></i>保存</a>
                    </blockquote>
                    <table id="orderItemThead" cellspacing="0" cellpadding="0" border="0" class="layui-table" lay-size="sm" style="margin: 0px 0px">
                        <thead>
                            <tr>
                                <th>序号</th>
                                <th data-field="content">材料/项目内容</th>
                                <th data-field="model">规格型号</th>
                                <th data-field="unit">单位</th>
                                <th data-field="price">单价</th>
                                <th data-field="amount">数量</th>
                                <th data-field="totalPrice">金额</th>
                                <th data-field="remark">备注</th>
                                <th class="layui-table-col-special">操作</th>
                            </tr>
                        </thead>
                    </table>
                </div>

                <div class="layui-table-body layui-table-main" style="height: 320px; margin-top: -11px">
                    <table id="orderItem" class="layui-table" lay-size="sm">
                        <tbody>
                            <tr>
                                <td><div class="layui-table-cell">001</div></td>
                                <td><input class="layui-input layui-table-edit" name="content" lay-verify="required" onkeyup="checkContent(this);" /></td>
                                <td><input class="layui-input layui-table-edit" name="model" onkeyup="checkModel(this);" /></td>
                                <td><input class="layui-input layui-table-edit" name="unit" lay-verify="required" onkeyup="checkUnit(this);" /></td>
                                <td><input class="layui-input layui-table-edit" name="price" lay-verify="required" onblur="checkPrice(this);" onkeyup="reckon(this);" /></td>
                                <td><input class="layui-input layui-table-edit" name="amount" lay-verify="required" onblur="checkAmount(this);" onkeyup="reckon(this);" /></td>
                                <td><input class="layui-input layui-table-edit" readonly name="totalPrice" /></td>
                                <td><input class="layui-input layui-table-edit" name="remark" lay-verify="required" onkeyup="checkRemark(this);" /></td>
                                <td align="center" class="layui-table-col-special"><div class="layui-table-cell"><a class="layui-btn layui-btn-danger layui-btn-xs" onclick="del(this)" title="删除"><i class="layui-icon"></i></a></div></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="layui-tab-item">
               <ul class="layui-timeline" style="padding: 20px 50px;">
                   <c:set value="${orderVo.historyList}" var="historyList"/>
                   <%@ include file="/WEB-INF/page/biz/reviewHistory.jsp"%>
               </ul>
            </div>
        </div>
    </div>

	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
    <script type="text/javascript" src="${ctx }/js/RegExpUtil.js?v=123"></script>
	<script type="text/javascript" src="${ctx }/js/biz/orderForm.js?v=123"></script>
    <script type="text/javascript" src="${ctx }/js/admin/adminSelect.js"></script>
    <script type="text/javascript" src="${ctx }/js/projectManger/projectMangerSelect.js"></script>
    <script type="text/javascript" src="${ctx }/js/supplier/supplierSelect.js"></script>
    <script type="text/javascript" src="${ctx }/js/biz/submitOrder.js?v=123"></script>

</body>
</html>