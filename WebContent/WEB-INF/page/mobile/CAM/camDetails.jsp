<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title></title>
    <link href="${ctx }/mui/css/mui.min.css" rel="stylesheet"/>
    <link href="${ctx }/mui/css/iconfont.css" rel="stylesheet"/>
    <link href="${ctx }/mui/css/mui.picker.min.css" rel="stylesheet" />
    <link href="${ctx }/mui/css/feedback-page.css" rel="stylesheet" />
    <link href="${ctx }/mui/css/mui-page.css" rel="stylesheet" />
    <style>
        /*.table {
            border: 1px solid #cad9ea;
            color: #666;
            width: 96%;
            margin-left: 15px;
            margin-right: 1%;
        }

        .table th {
            background-repeat: repeat-x;
            height: 30px;
        }

        .table td,
        .table th {
            border: 1px solid #cad9ea;
            padding: 0 1em 0;
        }

        .table tr.alter {
            background-color: #f5fafe;
        }
        .table tbody {
            text-align: center;
        }*/
    </style>
</head>
<body class="mui-fullscreen">

<%--<header class="mui-bar mui-bar-nav">
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
    <h1 class="mui-title">合同内请款单</h1>
</header>--%>
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
        <h1 class="mui-center mui-title">合同内请款单</h1>
    </div>

    <div class="mui-content-padded mui-card" style="margin: 5px;">
        <form class="mui-input-group">
            <div class="mui-input-row">
                <label>单号</label>
                <input type="text" readonly="readonly" class="mui-input-clear" placeholder="PC20180817001">
            </div>
            <div class="mui-input-row">
                <label>请款人</label>
                <input type="text" id="selectApplyUser" class="mui-input-clear" placeholder="请选择开单人" value="${admin.fullname}">
                <input type="hidden" id="applyUser" name="applyUser" value="${admin.id}">
            </div>

            <div class="mui-input-row">
                <label>来源订单</label>
                <a href="#selectSourceOrder">
                    <label id="selectSourceOrderText" style="width: 65%;padding-left: 0px;">请选择来源订单</label>
                    <input type="hidden" id="selectSourceOrderHidden" name="sourceOrderId" value="">
                </a>
            </div>
            <div class="mui-input-row">
                <label>所属项目</label>
                <input type="text" id="projectName" readonly class="mui-input-clear" value="">
                <input type="hidden" id="projectId" name="projectId" value="">
            </div>
            <div class="mui-input-row">
                <label>供应商</label>
                <input type="text" id="supplierName" readonly class="mui-input-clear" value="${admin.supplierName}">
                <input type="hidden" id="supplierId" name="supplierId" value="${admin.supplierId}">
            </div>
            <div class="mui-input-row">
                <label>单据类型</label>
                <input type="text" id="orderTypeName" readonly class="mui-input-clear" value="111111111111111" >
                <input type="hidden" id="orderTypeId" name="orderType" value="0" >
            </div>
            <div class="mui-input-row">
                <label>单据状态</label>
                <input type="text" id="statusName" readonly class="mui-input-clear" placeholder="请选择单据状态"  value="">
                <input type="hidden" id="statusId" name="status" value="0">
            </div>
            <div class="mui-input-row">
                <label>请款金额合计(元)</label>
                <input type="number" class="mui-input-clear" style="color: red;" name="applyPrice" placeholder="请输入请款金额合计">
            </div>
            <div class="mui-control-content mui-active">
                <h5 style="margin-left: 15px; padding-top: 5px;">自定义详情块</h5>
                <table class="table">
                    <thead>
                    <tr>
                        <th width="16%">施工部位</th>
                        <th width="16.6%">材料/项目内容</th>
                        <th width="16.6%">规格型号</th>
                        <th width="16.6%">单位</th>
                        <th width="16.6%">总价</th>
                        <th width="16.6%">
                            <span class="mui-icon mui-icon-plusempty icon-color-F0AD4E"></span>
                            <!--<button type="button" data-loading-icon="mui-spinner mui-icon-plusempt" class="mui-btn"></button> -->
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td><input placeholder="内容" style="width: 100%;"/></td>
                        <td><input placeholder="内容" style="width: 100%;"/></td>
                        <td><input placeholder="内容" style="width: 100%;"/></td>
                        <td><input placeholder="内容" style="width: 100%;"/></td>
                        <td><span class="mui-icon mui-icon-closeempty icon-color-F0AD4E"></span></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <%--<div class="mui-control-content mui-active">
                <h5 style="margin-left: 15px; padding-top: 5px;">自定义详情块</h5>
                <table class="table">
                    <thead>
                        <tr>
                            <th width="16%">序号</th>
                            <th width="16.6%">内容</th>
                            <th width="16.6%">数量</th>
                            <th width="16.6%">单价</th>
                            <th width="16.6%">总价</th>
                            <th width="16.6%">
                                <span class="mui-icon mui-icon-plusempty icon-color-F0AD4E"></span>
                                <!--<button type="button" data-loading-icon="mui-spinner mui-icon-plusempt" class="mui-btn"></button> -->
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td><input placeholder="内容" style="width: 100%;"/></td>
                        <td><input placeholder="内容" style="width: 100%;"/></td>
                        <td><input placeholder="内容" style="width: 100%;"/></td>
                        <td><input placeholder="内容" style="width: 100%;"/></td>
                        <td><span class="mui-icon mui-icon-closeempty icon-color-F0AD4E"></span></td>
                    </tr>
                    </tbody>
                </table>
            </div>--%>
            <div>
                <textarea id="textarea" rows="5" class="mui-input-clear" placeholder="摘要"></textarea>
            </div>

            <%--<div class="mui-input-row">
                <label>数量</label>
                <input type="number" class="mui-input-clear" placeholder="请输入数字">
            </div>
            <div class="mui-input-row">
                <label>单价(元)</label>
                <input type="number" class="mui-input-clear" style="color: red;" placeholder="请输入金额">
            </div>
            <div class="mui-input-row">
                <label>下拉框</label>
                <select>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                </select>
            </div>
            <div class="mui-input-row">
                <label>下拉框</label>
                <input type="text" id="selectChose" class="mui-input-clear" placeholder="请选择">
                <input type="hidden" id="selectValue">
            </div>
            <div class="mui-input-row">
                <label>日期</label>
                <input id="dateText" type="text" data-options='{"type":"date","beginYear":2014,"endYear":2016}' placeholder="请选择日期">
            </div>
            <div class="mui-input-row">
                <label>时间</label>
                <input id="dateTimeText" type="text" data-options='{"type":"time"}' placeholder="请选择时间">
            </div>
            <div class="mui-input-row mui-input-range">
                <label>滑块</label>
                <input type="range" min="0" max="100">
            </div>

            <div class="mui-input-row mui-input-range">
                <label>开关切换</label>
                <div class="mui-switch mui-active" style="float: left;">
                    <div class="mui-switch-handle"></div>
                </div>
            </div>
            <div class="mui-input-row mui-input-range">
                <label>页面回选</label>
                <a href="#account">
                    <label id="accountText" style="width: 65%;">请选择</label>
                    <input type="hidden" id="accountHidden" value="">
                </a>
            </div>--%>

        </form>
        <div class="mui-button-row" style="padding-bottom: 20px;">
            <button type="button" class="mui-btn mui-btn-primary" onclick="camSave();">保存</button>&nbsp;&nbsp;
            <button type="button" class="mui-btn mui-btn-danger" onclick="return false;">取消</button>
        </div>
        <%--<div class="mui-button-row" style="padding-bottom: 20px;">
            <button type="button" class="mui-btn mui-btn-primary" onclick="return false;">同意</button>&nbsp;&nbsp;
            <button type="button" class="mui-btn mui-btn-danger" onclick="return false;">驳回</button>
        </div>--%>
    </div>

</div>



<div id="selectSourceOrder" class="mui-page">
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <button type="button" class="mui-left mui-action-back mui-btn  mui-btn-link mui-btn-nav mui-pull-left">
            <span class="mui-icon mui-icon-left-nav"></span>返回
        </button>
        <h1 class="mui-center mui-title">选择来源订单</h1>
    </div>
    <div class="mui-page-content">
        <div class="mui-scroll-wrapper">
            <div class="mui-input-row mui-search">
                <input type="search" class="mui-input-clear" placeholder="请输入搜索条件" style="width: 100%;">
            </div>
            <div class="mui-scroll">
                <ul id="selectSourceOrderUl" class="mui-table-view mui-table-view-radio">
                    <li class="mui-table-view-cell" data-id="1" data-text="Item 1">
                        <a class="mui-navigate-right">Item 1</a>
                    </li>
                    <li class="mui-table-view-cell" data-id="2" data-text="手机号 1">
                        <a class="mui-navigate-right">手机号 1</a>
                    </li>
                    <li class="mui-table-view-cell" data-id="3" data-text="邮箱地址 1">
                        <a class="mui-navigate-right">邮箱地址 1</a>
                    </li>

                </ul>
                <div class="mui-button-row" style="padding-bottom: 20px;">
                    <button type="button" class="mui-btn mui-btn-primary account-cancel" onclick="accountCancel();">取消</button>&nbsp;&nbsp;
                    <button type="button" class="mui-btn mui-btn-danger account-ensure" onclick="accountEnsure('selectSourceOrder','selectSourceOrderText','selectSourceOrderHidden');">确定</button>
                </div>
            </div>
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
    var btns =  mui('#dateText');
    btns.each(function(i, btn) {
        btn.addEventListener('tap', function() {
            var optionsJson = this.getAttribute('data-options') || '{}';
            var options = JSON.parse(optionsJson);
            var id = this.getAttribute('id');
            var picker = new mui.DtPicker(options);
            picker.show(function(rs) {
                dateText.value = rs.text;
                picker.dispose();
            });
        }, false);
    });

    var btns1 =  mui('#dateTimeText');
    btns1.each(function(i, btn) {
        btn.addEventListener('tap', function() {
            var optionsJson = this.getAttribute('data-options') || '{}';
            var options = JSON.parse(optionsJson);
            var id = this.getAttribute('id');
            var picker = new mui.DtPicker(options);
            picker.show(function(rs) {
                dateTimeText.value = rs.text;
                picker.dispose();
            });
        }, false);
    });

    mui.ready(function() {
        var adminsJson = '${admins}';
        console.log(adminsJson);
        var userPicker = new mui.PopPicker();
        userPicker.setData(JSON.parse(adminsJson));
        var selectApplyUser = document.getElementById('selectApplyUser');
        var applyUser = document.getElementById('applyUser');
        selectApplyUser.addEventListener('tap', function(event) {
            userPicker.show(function(items) {
                selectApplyUser.value = items[0].text;
                applyUser.value = items[0].value;
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);

        var statusNamePicker = new mui.PopPicker();
        statusNamePicker.setData( [{
            value: '0',
            text: '未提交'
        }, {
            value: '1',
            text: '已提交'
        }, {
            value: '2',
            text: '成本部已审核'
        }, {
            value: '3',
            text: '工程部已审核'
        },{
            value: '4',
            text: '总经理已审核'
        }]);
        var statusName = document.getElementById('statusName');
        var statusId = document.getElementById('statusId');
        statusName.addEventListener('tap', function(event) {
            statusNamePicker.show(function(items) {
                statusName.value = items[0].text;
                statusId.value = items[0].value;
                //返回 false 可以阻止选择框的关闭
                //return false;
            });
        }, false);






        var poItem = '${poItem}';
        buiderSourceOrder(poItem);

    });

    //处理view的后退与webview后退
    var oldBack = mui.back;
    mui.back = function() {
        if (viewApi.canBack()) { //如果view可以后退，则执行view的后退
            viewApi.back();
        } else { //执行webview后退
            oldBack();
        }
    };
    view.addEventListener('pageBack', function(e) {
        console.log(e.detail.page.id + ' back');
    });

    function buiderSourceOrder(obj){
        var selectSourceOrderUl = $("#selectSourceOrderUl");
        var items = JSON.parse(obj);
        if(items.length > 0){
            var html = "";
            for(var i = 0; i < items.length; i++){
                console.log(items[i]);
                var id = items[i].id;
                var text = items[i].purchaseNo + "-" + items[i].supplierId;
                html += "<li class='mui-table-view-cell' data-id='" + id + "' data-text='" + text + "'><a class='mui-navigate-right'>" + text + "</a></li>";
            }
            $(selectSourceOrderUl).html(html);
        }
    }


    function accountCancel(){
        if (viewApi.canBack()) { //如果view可以后退，则执行view的后退
            viewApi.back();
        } else { //执行webview后退
            oldBack();
        }
    }
    function accountEnsure(flag,callText,callValue){
        var accountSelected = $("#" + flag).find("li").hasClass("mui-selected");
        if(accountSelected){
            var li = $("#" + flag).find("li.mui-selected");
            var value = $(li).attr("data-id");
            var text = $(li).attr("data-text");
            console.log(value + "/n" +text);
            $("#" + callText).text(text);
            $("#" + callValue).val(value);
            accountCancel();
        }else{
            mui.toast('您尚未选择，请选择后确定',{ duration:'long', type:'div' })
        }
    }
    function camSave(){

    }
</script>
</body>
</html>