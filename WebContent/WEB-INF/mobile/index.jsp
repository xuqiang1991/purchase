<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	<title></title>
	<link href="../../mui/css/mui.css" rel="stylesheet"/>
</head>
<body>
<header class="mui-bar mui-bar-nav">
	<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
	<h1 class="mui-title">标题</h1>
</header>
<nav class="mui-bar mui-bar-tab">
	<a class="mui-tab-item mui-active">
		<span class="mui-icon mui-icon-home"></span>
		<span class="mui-tab-label">首页</span>
	</a>
	<a class="mui-tab-item">
		<span class="mui-icon mui-icon-phone"></span>
		<span class="mui-tab-label">电话</span>
	</a>
	<a class="mui-tab-item">
		<span class="mui-icon mui-icon-email"></span>
		<span class="mui-tab-label">邮件</span>
	</a>
	<a class="mui-tab-item">
		<span class="mui-icon mui-icon-gear"></span>
		<span class="mui-tab-label">设置</span>
	</a>
</nav>
<script src="../../mui/js/mui.min.js"></script>
<script type="text/javascript" charset="utf-8">
    //选项卡点击事件
    mui('.mui-bar-tab').on('tap', 'a', function(e) {
        //获取目标子页的id
        var targetTab = this.getAttribute('href');
        if (targetTab == activeTab) {
            return;
        }

        //更换标题
        title.innerHTML = this.querySelector('.mui-tab-label').innerHTML;
        //显示目标选项卡
        plus.webview.show(targetTab);
        //隐藏当前选项卡
        plus.webview.hide(activeTab);
        //更改当前活跃的选项卡
        activeTab = targetTab;
    });
</script>
</body>
</html>