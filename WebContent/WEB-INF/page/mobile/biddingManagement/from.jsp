<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>
        <c:choose>
            <c:when test="${empty bmVo.id}">新建投标</c:when>
            <c:otherwise>修改投标</c:otherwise>
        </c:choose>
    </title>
    <link href="${ctx }/mui/css/mui.min.css" rel="stylesheet"/>
    <link href="${ctx }/mui/css/iconfont.css" rel="stylesheet"/>
    <link href="${ctx }/mui/css/mui.picker.min.css" rel="stylesheet" />
    <link href="${ctx }/mui/css/feedback-page.css" rel="stylesheet" />
    <link href="${ctx }/mui/css/mui-page.css" rel="stylesheet" />
</head>
<body class="mui-fullscreen">
<div id="app" class="mui-views">
    <div class="mui-view">
        <div class="mui-navbar"></div>
        <div class="mui-pages"></div>
    </div>
</div>

<div id="setting" class="mui-content mui-page">
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <button type="button" class="mui-left mui-action-back mui-btn  mui-btn-link mui-btn-nav mui-pull-left">
            <span class="mui-icon mui-icon-left-nav"></span>
        </button>
        <h1 class="mui-center mui-title">
            <c:choose>
                <c:when test="${empty bmVo.id}">新建投标</c:when>
                <c:otherwise>修改投标</c:otherwise>
            </c:choose>
        </h1>
    </div>

    <div class="mui-content-padded mui-card" style="margin: 5px;">
        <form class="mui-input-group" id="bmForm">
            <input type="hidden" id="id" name="id" value="${bmVo.id}" />
            <div class="mui-input-row">
                <label>投标人</label>
                <c:choose>
                    <c:when test="${bmVo.id == null}">
                        <input type="text" id="selectBidUser" readonly placeholder="请选择投标人" value="${admin.fullname}">
                        <input type="hidden" id="bidUser" name="bidUser" value="${admin.id}" mui-verify="required">
                    </c:when>
                    <c:otherwise>
                        <input type="text" id="selectBidUser" readonly placeholder="请选择开单人" value="${bmVo.bidAdmin.fullname}">
                        <input type="hidden" id="bidUser" name="bidUser" value="${bmVo.bidAdmin.id}" mui-verify="required">
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="mui-input-row">
                <label>城市</label>
                <c:choose>
                    <c:when test="${bmVo.id == null}">
                        <input type="text" id="areaName" readonly placeholder="请选择城市">
                        <input type="hidden" id="areaId" name="areaId" value="" mui-verify="required">
                    </c:when>
                    <c:otherwise>
                        <input type="text" id="areaName" readonly value="${bmVo.cityArea.name}">
                        <input type="hidden" id="areaId" name="areaId" value="${bmVo.cityArea.id}" mui-verify="required">
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="mui-input-row">
                <label>项目名称</label>
                <c:choose>
                    <c:when test="${bmVo.projectName == null}">
                        <input type="text" id="projectName" name="projectName" value="" placeholder="请输入项目名称" mui-verify="required">
                    </c:when>
                    <c:otherwise>
                        <input type="text" id="projectName" name="projectName" value="${bmVo.projectName}" mui-verify="required">
                    </c:otherwise>
                </c:choose>
            </div>

            <div class="mui-input-row">
                <label>发展商</label>
                <c:choose>
                    <c:when test="${bmVo.id == null}">
                        <input type="text" id="supplierName" readonly value="${admin.supplierName}">
                        <input type="hidden" id="customersId" name="customersId" value="${admin.supplierId}" mui-verify="required">
                    </c:when>
                    <c:otherwise>
                        <input type="text" id="supplierName" readonly value="${bmVo.supplier.name}">
                        <input type="hidden" id="customersId" name="customersId" value="${bmVo.supplier.id}" mui-verify="required">
                    </c:otherwise>
                </c:choose>
            </div>

            <div class="mui-input-row">
                <label>项目面积</label>
                <c:choose>
                    <c:when test="${bmVo.projectAcreage == null}">
                        <input type="number" id="projectAcreage" name="projectAcreage" value="" placeholder="请输入项目面积" mui-verify="required">
                    </c:when>
                    <c:otherwise>
                        <input type="number" id="projectAcreage" name="projectAcreage" value="${bmVo.projectAcreage}" mui-verify="required">
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="mui-input-row">
                <label>预算工程价款</label>
                <c:choose>
                    <c:when test="${bmVo.projectPriceBudge == null}">
                        <input type="number" id="projectPriceBudge" name="projectPriceBudge" value="" placeholder="请输入工程价款（预算）" mui-verify="required">
                    </c:when>
                    <c:otherwise>
                        <input type="number" id="projectPriceBudge" name="projectPriceBudge" value="${bmVo.projectPriceBudge}" mui-verify="required">
                    </c:otherwise>
                </c:choose>
            </div>

            <div class="mui-input-row">
                <label>最终投标价</label>
                <c:choose>
                    <c:when test="${bmVo.finalBid == null}">
                        <input type="number" id="finalBid" name="finalBid" value="" placeholder="请输入最终投标价" mui-verify="required">
                    </c:when>
                    <c:otherwise>
                        <input type="number" id="finalBid" name="finalBid" value="${bmVo.projectPriceBudge}" mui-verify="required">
                    </c:otherwise>
                </c:choose>
            </div>

            <div class="mui-input-row">
                <label>预估开工时间</label>
                <c:choose>
                    <c:when test="${bmVo.estimateStartTime == null}">
                        <input id="estimateStartTime" name="estimateStartTime" type="text" data-options='{"type":"date","beginYear":2018,"endYear":2028}' placeholder="请选择开工时间（预估）" mui-verify="required">
                    </c:when>
                    <c:otherwise>
                        <input id="estimateStartTime" name="estimateStartTime" value="<fmt:formatDate value="${bmVo.estimateStartTime}" pattern="yyyy-MM-dd"/>" type="text" data-options='{"type":"date","beginYear":2018,"endYear":2028}' mui-verify="required">
                    </c:otherwise>
                </c:choose>
            </div>

            <div class="mui-input-row">
                <label>交标时间</label>
                <c:choose>
                    <c:when test="${bmVo.bidMarkTime == null}">
                        <input id="bidMarkTime" name="bidMarkTime" type="text" data-options='{"type":"date","beginYear":2018,"endYear":2028}' placeholder="请选择交标时间" mui-verify="required">
                    </c:when>
                    <c:otherwise>
                        <input id="bidMarkTime" name="bidMarkTime" value="<fmt:formatDate value="${bmVo.bidMarkTime}" pattern="yyyy-MM-dd"/>" type="text" data-options='{"type":"date","beginYear":2018,"endYear":2028}' mui-verify="required">
                    </c:otherwise>
                </c:choose>
            </div>

            <div class="mui-input-row">
                <label>开标信息</label>
                <c:choose>
                    <c:when test="${bmVo.openBidInfo == null}">
                        <input type="text" id="openBidInfoName" readonly placeholder="请选择开标信息">
                        <input type="hidden" id="openBidInfo" name="openBidInfo" value="" mui-verify="required">
                    </c:when>
                    <c:otherwise>
                        <input type="text" id="openBidInfoName" readonly value="${bmVo.openBidInfo}">
                        <input type="hidden" id="openBidInfo" name="openBidInfo" value="${bmVo.openBidInfo}" mui-verify="required">
                    </c:otherwise>
                </c:choose>
            </div>

            <div class="mui-input-row">
                <label>投标原因</label>
                <c:choose>
                    <c:when test="${bmVo.bidCause == null}">
                        <input type="text" id="bidCauseName" readonly placeholder="请选择投标原因">
                        <input type="hidden" id="bidCause" name="bidCause" value="" mui-verify="required">
                    </c:when>
                    <c:otherwise>
                        <input type="text" id="bidCauseName" readonly value="${bmVo.bidCause}">
                        <input type="hidden" id="bidCause" name="bidCause" value="${bmVo.bidCause}" mui-verify="required">
                    </c:otherwise>
                </c:choose>
            </div>

            <div>
                <textarea id="textarea" name="remark" rows="5" class="mui-input-clear" placeholder="备注">${bmVo.remark}</textarea>
            </div>
        </form>
        <div class="mui-button-row" style="padding-bottom: 20px;">
            <button type="button" class="mui-btn mui-btn-primary" onclick="bmSave();">保存</button>
            <%--<button type="button" class="mui-btn mui-btn-danger" onclick="return false;">取消</button>--%>
        </div>
    </div>
</div>

<script src="${ctx }/mui/js/mui.min.js"></script>
<script src="${ctx }/js/jquery-1.11.1.js"></script>
<script src="${ctx }/mui/js/mui.picker.min.js"></script>
<script src="${ctx }/mui/js/mui.view.js"></script>
<script type="text/javascript" charset="utf-8">
    mui.init();
    //初始化单页view
    var viewApi = mui('#app').view({
        defaultPage: '#setting'
    });
    var view = viewApi.view;

    var btns_estimateStartTime =  mui('#estimateStartTime');
    btns_estimateStartTime.each(function(i, btn) {
        btn.addEventListener('tap', function() {
            var optionsJson = this.getAttribute('data-options') || '{}';
            var options = JSON.parse(optionsJson);
            var picker = new mui.DtPicker(options);
            picker.show(function(rs) {
                estimateStartTime.value = rs.text;
                picker.dispose();
            });
        }, false);
    });

    var btns_bidMarkTime =  mui('#bidMarkTime');
    btns_bidMarkTime.each(function(i, btn) {
        btn.addEventListener('tap', function() {
            var optionsJson = this.getAttribute('data-options') || '{}';
            var options = JSON.parse(optionsJson);
            var picker = new mui.DtPicker(options);
            picker.show(function(rs) {
                bidMarkTime.value = rs.text;
                picker.dispose();
            });
        }, false);
    });

    var openBidInfoJosn = '[{"text":"未定标","value":"0"},{"text":"未中标","value":"1"},{"text":"已中标","value":"2"}]';
    var bidCauseJson = '[{"value": "0", "text": "意向参投"}, {"value": "1", "text": "配合投标"}]';

    mui.ready(function() {
        var adminsJson = '${admins}';
        console.log(adminsJson);
        var adminPicker = new mui.PopPicker();
        adminPicker.setData(JSON.parse(adminsJson));
        var selectBidUser = document.getElementById('selectBidUser');
        var bidUser = document.getElementById('bidUser');
        selectBidUser.addEventListener('tap', function(event) {
            adminPicker.show(function(items) {
                selectBidUser.value = items[0].text;
                bidUser.value = items[0].value;
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);

        var suppliersJson = '${suppliers}';
        console.log(suppliersJson);
        var suppliersPicker = new mui.PopPicker();
        suppliersPicker.setData(JSON.parse(suppliersJson));
        var supplierName = document.getElementById('supplierName');
        var customersId = document.getElementById('customersId');
        supplierName.addEventListener('tap', function(event) {
            suppliersPicker.show(function(items) {
                supplierName.value = items[0].text;
                customersId.value = items[0].value;
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);

        var areasJson = '${areas}';
        console.log(areasJson);
        var areasPicker = new mui.PopPicker();
        areasPicker.setData(JSON.parse(areasJson));
        var areaName = document.getElementById('areaName');
        var areaId = document.getElementById('areaId');
        areaName.addEventListener('tap', function(event) {
            areasPicker.show(function(items) {
                areaName.value = items[0].text;
                areaId.value = items[0].value;
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);


        var openBidInfoPicker = new mui.PopPicker();
        openBidInfoPicker.setData(JSON.parse(openBidInfoJosn));
        var openBidInfoName = document.getElementById('openBidInfoName');
        var openBidInfo = document.getElementById('openBidInfo');
        openBidInfoName.addEventListener('tap', function(event) {
            openBidInfoPicker.show(function(items) {
                openBidInfoName.value = items[0].text;
                openBidInfo.value = items[0].value;
                console.log(items[0].value);
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);


        var bidCausePicker = new mui.PopPicker();
        bidCausePicker.setData(JSON.parse(bidCauseJson));
        var bidCauseName = document.getElementById('bidCauseName');
        var bidCause = document.getElementById('bidCause');
        bidCauseName.addEventListener('tap', function(event) {
            bidCausePicker.show(function(items) {
                bidCauseName.value = items[0].text;
                bidCause.value = items[0].value;
                console.log(items[0].value);
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);

        var openBidInfo = '${bmVo.openBidInfo}';
        if(openBidInfo != null){
            var ot = JSON.parse(openBidInfoJosn);
            for(var i = 0; i < ot.length; i++){
                if(ot[i].value == openBidInfo){
                    $("#openBidInfoName").val(ot[i].text);
                }
            }
        }

        var bidCause = '${bmVo.bidCause}';
        if(bidCause != null){
            var ot = JSON.parse(bidCauseJson);
            for(var i = 0; i < ot.length; i++){
                if(ot[i].value == bidCause){
                    $("#bidCauseName").val(ot[i].text);
                }
            }
        }

    });

    function bmSave(){
        var check = true;
        mui("input").each(function() {
            //若当前input为空，则alert提醒
            var verify = $(this).attr("mui-verify");
            if(verify == 'required'){
                if(!this.value || this.value.trim() == "") {
                    var label = this.previousElementSibling;
                    var titleMsg = label.innerText;
                    if(titleMsg == ''){
                        titleMsg = $(this).parent().find("label").html();
                    }
                    mui.alert(titleMsg + "不允许为空");
                    check = false;
                    return false;
                }
            }
        });
        if(check){
            var url = '${ctx}/mobile/biddingManagement/addBMOrder';
            if($('#bmForm').find('#id').val() != null){
                url = '${ctx}/mobile/biddingManagement/editBMOrder';
            }
            $.ajax({
                url: url,
                data: $('#bmForm').serialize(),
                dataType: 'json',
                contentType : "application/x-www-form-urlencoded",
                type: 'post',
                timeout: 10000,
                success: function(result) {
                    if(result.code!=0){
                        mui.alert(data.msg);
                    }else {
                        mui.alert("保存成功！");
                        document.location.href='${ctx }/mobile/biddingManagement/list';
                    }
                }
            });
        }

    }
</script>
</body>
</html>