var $;
var $form;
var form;
layui.config({
	base : "js/"
}).use(['form','layer','jquery'],function(){
	var layer = parent.layer === undefined ? layui.layer : parent.layer,
		$ = layui.jquery;
		form = layui.form;


		/*$("#fullName").blur(function(){
		    var datas = $("#customersForm").serialize();
		    console.log(JSON.stringify(datas));
			$.ajax({
	            type: "post",
	            url: ctx+"/customers/checkCustomersFullName/",
                data:datas,
                dataType:"json",
	            success:function(data){
	            	if(data.code!=0){
	            		top.layer.msg(data.msg);
	            		$("#fullName").val("");
	            		$("#fullName").focus();
	            	}
	            }
	        });
		});*/
		

 	form.on("submit(coustomersAdd)",function(data){
 		//弹出loading
 		var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
 		var msg;
 		$.ajax({
    		type: "post",
            url: ctx+"/customers/editCustomers",
            data:data.field,
			dataType:"json",
			success:function(d){
				if(d.code==0){
		        	msg="添加成功！";
				}else{
		        	msg=d.msg;
				}
			}
        });
 		setTimeout(function(){
 			top.layer.close(index);
 			top.layer.msg(msg);
 			layer.closeAll("iframe");
 			//刷新父页面
	 		parent.location.reload();
        },2000);
 		return false;
 	})
	
})