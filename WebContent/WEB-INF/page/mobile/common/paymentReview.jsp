<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<style type="text/css">
    #div {
        width: 0px;
        height: 0px;
        background: red;
        position: fixed;
        top: 70%;
        left: 50%;
    }
    .mui-switch.mui-active:before{content: '通过';}
    .mui-switch:before{content: '驳回';}
</style>

<div id="div"></div>

<c:choose>
    <c:when test="${reviewStatus != 3}">
        <div id="popover" class="mui-popover" style="height: 270px;">
    </c:when>
    <c:otherwise>
        <div id="popover" class="mui-popover" style="height: 230px;">
    </c:otherwise>
</c:choose>
<div class="mui-popover-arrow"></div>
<div class="mui-scroll-wrapper">
    <div class="mui-scroll"  style="height: 100%;">
        <form class="mui-input-group" id="reviewPurchaseOrderForm">
            <div class="mui-input-row mui-input-range">
                <label style="width: 120px;">审核结果</label>
                <input type="hidden" id="auditResults" name="auditResults" value="1">
                <div id="mySwitch" class="mui-switch mui-active" style="float: left;">
                    <div class="mui-switch-handle"></div>
                </div>
            </div>
            <c:if test="${detailsVo.status == 0}">
                <div class="mui-input-row" id="applyUserReviewDiv">
                    <label style="width: 120px;">财务付款人</label>
                    <input type="text" id="selectApplyUser" readonly placeholder="请选择付款的财务人员" style="float: left;width: 150px;">
                    <input type="hidden" id="applyUser" name="applyUser">
                </div>
            </c:if>
            <div class="mui-input-row" style="height: auto">
                <textarea name="auditOpinion" id="auditOpinion" rows="5" class="mui-input-clear" placeholder="审核意见"></textarea>
            </div>
            <div class="mui-button-row" style="padding-bottom: 20px;">
                <button type="button" class="mui-btn mui-btn-primary" id="reviewPurchaseOrderButton">审核</button>&nbsp;&nbsp;
                <button class="mui-btn mui-btn-danger"  id="review-cancel-btn" type="button">关闭</button>
            </div>
        </form>
    </div>
</div>
</div>

<script type="text/javascript" charset="utf-8">

    /** 审核 **/
    mui(document.body).on('tap', '#reviewPurchaseOrder', function(e) {
        mui("#popover").popover('toggle', document.getElementById("div"));
    });

    mui(document.body).on('tap', '#review-cancel-btn', function(e) {
        mui('#popover').popover('hide',document.getElementById("div"));
    });

    mui(document.body).on('tap', '#selectApplyUser', function(e) {
        var adminsJson = '${detailsVo.departs}'
        var json =JSON.parse(adminsJson)
        var userPicker = new mui.PopPicker();
        userPicker.setData(json);
        var selectApplyUser = document.getElementById('selectApplyUser');
        var applyUser = document.getElementById('applyUser');
        userPicker.show(function (items) {
            selectApplyUser.value = items[0].text;
            applyUser.value = items[0].value;
        });
    });
    document.getElementById("mySwitch").addEventListener("toggle",function(event){
        if(event.detail.isActive){
            console.log("你启动了开关");
            document.getElementById('auditResults').value = 1;
            $("#applyUserReviewDiv").show();
            $("#popover").css("height","270px");
        }else{
            console.log("你关闭了开关");
            document.getElementById('auditResults').value = 0;
            $("#applyUserReviewDiv").hide();
            $("#popover").css("height","230px");
        }
    })

    mui(document.body).on('tap', '#reviewPurchaseOrderButton', function(e) {

        var auditResults = document.getElementById('auditResults').value;

        var applyUser = document.getElementById('applyUser');
        if(applyUser == null){
            applyUser = '0'
        }else {
            if(auditResults == "1"){
                if(!applyUser.value || applyUser.value.trim() == "") {
                    mui.alert("上级审核人不允许为空");
                    return false;
                }
            }
            applyUser = applyUser.value;
        }

        var auditOpinion = document.getElementById('auditOpinion');

        auditOpinion = auditOpinion.value;

        mui.alert('确定提交审核？' , function() {
            var url = '${reviewSaveUrl}';
            $.ajax({
                url: url,
                data:{'auditResults':auditResults,'applyUser':applyUser,'auditOpinion': auditOpinion},
                dataType: 'json',
                contentType : "application/x-www-form-urlencoded",
                type: 'post',
                timeout: 10000,
                success: function(result) {
                    if(result.code!=0){
                        mui.alert(result.msg);
                    }else {
                        mui.alert('审核成功！', function() {
                            if(auditResults == "1"){
                                document.location.href='${reviewRefreshUrl}';
                            }else{
                                history.go(-1);
                            }
                        });
                    }
                }
            });
        });
    });
</script>
