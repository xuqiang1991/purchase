<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title></title>
    <link href="${ctx }/mui/css/mui.min.css" rel="stylesheet"/>
</head>
<body>
<header class="mui-bar mui-bar-nav">
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
    <h1 class="mui-title">新建采购订单</h1>
</header>

<div class="mui-content">
    <div class="mui-content-padded" style="margin: 5px;">

        <div class="mui-content-padded mui-card" style="margin: 5px;">
            <form class="mui-input-group">
                <div class="mui-input-row">
                    <label>普通文本框</label>
                    <input type="text" readonly="readonly" class="mui-input-clear" placeholder="PC20180817001">
                </div>
                <div class="mui-input-row">
                    <label>内容</label>
                    <input type="text" class="mui-input-clear" placeholder="请输入">
                </div>
                <div class="mui-input-row">
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
                <div class="mui-control-content mui-active">
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
                </div>
                <div>
                    <textarea id="textarea" rows="5" class="mui-input-clear" placeholder="备注意见"></textarea>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/mui/js/mui.min.js"></script>
<script type="text/javascript" charset="utf-8">
    mui.init({
        swipeBack: true, //启用右滑关闭功能
    });
</script>
</body>
</html>