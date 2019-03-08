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
</style>
</head>
<body class="childrenBody">
	<form class="layui-form" style="width: 90%; padding: 20px 0px 0px 20px;" id="layuiForm">
        <input type="hidden" id="orderId" name="id" value="${orderVo.id}">
		<div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">单号</label>
                <div class="layui-input-inline">
                    <input type="text" id="orderNo" name="orderNo" value="" disabled readonly placeholder="系统自动生成" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label css-required">订单类型</label>
                <div class="layui-input-inline">
                    <select id="type" name="type">
                        <option value="">请选择订单类型</option>
                        <option value="0">绿化苗木</option>
                        <option value="1">园建水电</option>
                        <option value="2">机械租赁</option>
                        <option value="3">工程分包</option>
                    </select>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label css-required">所属项目</label>
                <div class="layui-input-inline">
                    <%--<select id="projectId" name="projectId" >
                        <option value="">请选择所属项目</option>
                        <c:forEach items="${projectMangerList }" var="pm">
                            <option value="${pm.id }">${pm.name }</option>
                        </c:forEach>
                    </select>--%>
                    <input type="text" id="selectProjectId" readonly  class="layui-input" placeholder="请选择所属项目" value="${orderVo.tpm.shortName}">
                    <input type="hidden" id="projectId" name="projectId" value="${orderVo.projectId}" mui-verify="required">
                </div>
            </div>
        </div>
		<div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label css-required">供应商</label>
                <div class="layui-input-inline">
                    <input type="text" id="selectSupplierId" readonly  class="layui-input" placeholder="请选择所属项目" value="${orderVo.supplier.name}">
                    <input type="hidden" id="supplierId" name="supplierId" value="${orderVo.supplier.id}" mui-verify="required">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label css-required">申请人</label>
                <div class="layui-input-inline">
                    <c:choose>
                        <c:when test="${orderVo.id == null}">
                            <input type="text" id="selectApplyUserEdit" readonly  class="layui-input" placeholder="请选择申请人" value="${admin.fullname}">
                            <input type="hidden" id="applyUserEdit" name="applyUser" value="${admin.id}" mui-verify="required">
                        </c:when>
                        <c:otherwise>
                            <input type="text" id="selectApplyUserEdit" readonly class="layui-input" placeholder="请选择申请人" value="${orderVo.admin.fullname}">
                            <input type="hidden" id="applyUserEdit" name="applyUser" value="${orderVo.admin.id}" mui-verify="required">
                        </c:otherwise>
                    </c:choose>
                </div>
		    </div>
            <div class="layui-inline">
                <label class="layui-form-label css-required">申请日期</label>
                <div class="layui-input-inline">
                    <input type="text" id="applyDate" name="applyDate" class="layui-input" lay-verify="required" maxlength="10" placeholder="请选择申请日期" value="${orderVo.applyDate}">
                </div>
            </div>
        </div>
		<div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label css-required">合同号</label>
                <div class="layui-input-inline">
                    <input type="text" name="contractNo" class="layui-input" lay-verify="required" maxlength="10" placeholder="请输入合同号" value="${orderVo.contractNo}">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label css-required">签订时间</label>
                <div class="layui-input-inline">
                    <input type="text" id="contractSignDate" name="contractSignDate" class="layui-input" lay-verify="required" maxlength="10" placeholder="请选择签订时间" value="${orderVo.contractSignDate}">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">合同总金额</label>
                <div class="layui-input-inline">
                    <input type="text" id="contractMoney" class="layui-input " name="contractMoney" lay-verify="phone" maxlength="20" placeholder="请输入合同总金额" value="${orderVo.contractMoney}">
                </div>
            </div>
        </div>
		<div class="layui-form-item">
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
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label css-required">已请款总额</label>
                <div class="layui-input-inline">
                    <input type="text" name="requestAmount" class="layui-input" readonly placeholder="系统回写" value="${orderVo.requestAmount}">
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label css-required">质保期(月)</label>
                <div class="layui-input-inline">
                    <input type="text" id="warrantyDate" name="warrantyDate" class="layui-input" lay-verify="required" maxlength="10" placeholder="请输入质保期(月)" value="${orderVo.warrantyDate}">
                </div>
            </div>
        </div>
		<div class="layui-form-item">
			<label class="layui-form-label">摘要</label>
			<div class="layui-input-block">
				<textarea type="text" name="summary" class="layui-textarea" maxlength="100" placeholder="请输入摘要">${orderVo.summary}</textarea>
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="add">保存</button>
			</div>
		</div>

        <div class="layui-tab">
            <ul class="layui-tab-title">
                <li class="layui-this">订单明细</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <table cellspacing="0" cellpadding="0" border="0" class="layui-table">
                        <div class="layui-form layui-border-box layui-table-view">
                            <div class="layui-table-tool">
                                <div class="layui-table-tool-temp">
                                    <a class="layui-btn layui-btn-sm add_btn_item" onclick="add()"><i class="layui-icon"></i>增加</a>
                                    <a class="layui-btn layui-btn-sm save_btn_item" onclick="save"><i class="layui-icon"></i>保存</a>
                                </div>
                            </div>
                            <div class="layui-table-box">
                                <div class="layui-table-body layui-table-main">
                                    <table  id="orderItem" cellspacing="0" cellpadding="0" border="0" class="layui-table">
                                        <thead>
                                            <tr>
                                                <th style="width: 50px;">
                                                    <div class="layui-table-cell"><span>序号</span></div>
                                                </th>
                                                <th data-field="content" class="">
                                                    <div class="layui-table-cell"><span>材料/项目内容</span></div>
                                                </th>
                                                <th data-field="model" class="">
                                                    <div class="layui-table-cell"><span>规格型号</span></div>
                                                </th>
                                                <th data-field="unit" class="">
                                                    <div class="layui-table-cell"><span>单位</span></div>
                                                </th>
                                                <th data-field="price" class="">
                                                    <div class="layui-table-cell"><span>单价</span></div>
                                                </th>
                                                <th data-field="amount" class="">
                                                    <div class="layui-table-cell"><span>数量</span></div>
                                                </th>
                                                <th data-field="totalPrice" class="">
                                                    <div class="layui-table-cell"><span>金额</span></div>
                                                </th>
                                                <th data-field="remark" class="">
                                                    <div class="layui-table-cell"><span>备注</span></div>
                                                </th>
                                                <th class="layui-table-col-special">
                                                    <div class="layui-table-cell" align="center"><span>操作</span></div>
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>
                                                    <div class="layui-table-cell">001</div>
                                                </td>
                                                <td>
                                                    <input class="layui-input layui-table-edit" name="content" onkeyup="checkContent(this);" />
                                                </td>
                                                <td>
                                                    <input class="layui-input layui-table-edit" name="model" />
                                                </td>
                                                <td>
                                                    <input class="layui-input layui-table-edit" name="unit" />
                                                </td>
                                                <td>
                                                    <input class="layui-input layui-table-edit" onkeyup="reckon(this);" name="price" />
                                                </td>
                                                <td>
                                                    <input class="layui-input layui-table-edit" onkeyup="reckon(this);" name="amount" />
                                                </td>
                                                <td>
                                                    <input class="layui-input layui-table-edit" readonly name="totalPrice" />
                                                </td>
                                                <td>
                                                    <input class="layui-input layui-table-edit" name="remark" />
                                                </td>
                                                <td align="center" class="layui-table-col-special">
                                                    <div class="layui-table-cell">
                                                        <a class="layui-btn layui-btn-danger layui-btn-xs" onclick="del(this)" title="删除"><i class="layui-icon"></i></a>
                                                    </div>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </table>
                    <style>
                        .layui-table, .layui-table-view{
                            margin: 0px 0;
                        }
                        .layui-table-tool{
                            padding: 5px 15px;
                            position: relative;
                            z-index: 890;
                            width: 100%;
                            min-height: 20px;
                            line-height: 20px;
                            border-width: 0px 0px 1px;
                        }
                        .layui-table td, .layui-table th {
                            position: relative;
                            padding: 5px 15px;
                            min-height: 20px;
                            line-height: 20px;
                            font-size: 14px;
                        }
                        .layui-table-cell {
                            height: 20px;
                            line-height: 20px;
                            padding: 0 15px;
                            position: relative;
                            box-sizing: border-box;
                        }
                    </style>
                </div>
            </div>
        </div>
	</form>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
    <script type="text/javascript" src="${ctx }/js/RegExpUtil.js?v=123"></script>
	<script type="text/javascript" src="${ctx }/js/biz/orderForm.js?v=123"></script>
    <script type="text/javascript" src="${ctx }/js/admin/adminSelect.js"></script>
    <script type="text/javascript" src="${ctx }/js/projectManger/projectMangerSelect.js"></script>
    <script type="text/javascript" src="${ctx }/js/supplier/supplierSelect.js"></script>
    <script type="text/html" id="bar">
        <a class="layui-btn layui-btn-sm add_btn_item" lay-event="add"><i class="layui-icon">&#xe608;</i>增加</a>
        <a class="layui-btn layui-btn-sm save_btn_item" lay-event="save"><i class="layui-icon">&#xe63c;</i>保存</a>
        <%--<a class="layui-btn layui-btn-danger layui-btn-sm del_btn_item" data-type="delCheckData"><i class="layui-icon">&#xe640;</i></a>--%>
    </script>
    <script type="text/html" id="barItem">
        <a class="layui-btn layui-btn-xs save_btn_item" lay-event="save" title="保存"><i class="layui-icon">&#xe63c;</i></a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" title="删除"><i class="layui-icon">&#xe640;</i></a>
    </script>
    <script type="text/html" id="layIndex">
        {{#  if(d.LAY_INDEX < 10){ }}
        00{{d.LAY_INDEX}}
        {{# }else if(d.LAY_INDEX == 1){ }}
        0{{d.LAY_INDEX}}
        {{#  } else{ }}
        {{d.LAY_INDEX}}
        {{#  } }}
    </script>

</body>
</html>