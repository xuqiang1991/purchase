<%@ page language="java" import="com.purchase.util.WebUtils" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <%
	  String requestHeader = request.getHeader("user-agent");
	  boolean isMobile = WebUtils.isMobileDevice(requestHeader);
	  if(isMobile){
  %>
		  <meta charset="utf-8">
		  <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		  <title></title>
		  <link href="${ctx }/mui/css/mui.min.css" rel="stylesheet"/>
		  <link href="${ctx }/mui/css/iconfont.css" rel="stylesheet"/>
		  <link href="${ctx }/mui/css/mui.picker.min.css" rel="stylesheet" />
		  <link href="${ctx }/mui/css/feedback-page.css" rel="stylesheet" />
		  <link href="${ctx }/mui/css/mui-page.css" rel="stylesheet" />
		  <style type="text/css">
			  div{
				  text-align:center;

			  }
			  p{
				  margin:100px auto;
				  vertical-align: middle;
				  color: red;
			  }
		  </style>
		  <script src="${ctx }/mui/js/mui.min.js"></script>

		  <body>
		  <!-- 代码 开始 -->
		  <section style="height: 100%;">
			  <div style="height: 100%;">
				  <p style="font-size: x-large;">您无权访问此位置！</p>
			  </div>
		  </section>
		  <!-- 代码 结束 -->
		  </body>
  <%
	  }else{

  %>
	  <head>
		  <title>My JSP 'index.jsp' starting page</title>
		  <meta http-equiv="pragma" content="no-cache">
		  <meta http-equiv="cache-control" content="no-cache">
		  <meta http-equiv="expires" content="0">
		  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		  <meta http-equiv="description" content="This is my page">
		  <link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
	  </head>
	  <body>
	  <!-- 代码 开始 -->
	  <div >
		  <blockquote class="layui-elem-quote"><i class="layui-icon" style="font-size: 30px; color: red;">&#xe69c;</i>  您无权访问此位置！</blockquote>
	  </div>
	  <!-- 代码 结束 -->
	  </body>
  <%

	  }
  %>
</html>
