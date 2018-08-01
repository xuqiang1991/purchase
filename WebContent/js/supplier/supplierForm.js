var $;
var $form;
var form;
layui.config({
	base : "js/"
}).use(['form','layer','jquery','laydate'],function(){
	var layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,laydate = layui.laydate;
		$ = layui.jquery;
		form = layui.form;
		laydate.render({
			elem: '#birthday' //指定元素
			,max: 'new Date()'
		});
		
 	form.on("submit(addSupplier)",function(data){
 		//弹出loading
 		var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
 		var msg,flag=false;
 		$.ajax({
    		type: "post",
            url: ctx+"/user/insSupplier",
            async:false,
            data:data.field,
			dataType:"json",
			success:function(d){
				if(d.code==0){
		        	msg="供应商添加成功！";
		        	flag=true;
		        	$("#auf")[0].reset();
				}else{
		        	msg=d.msg;
				}
			}
        });
 		setTimeout(function(){
 			top.layer.close(index);
 			if(flag){
 				top.layer.msg(msg,{icon: 1});
 			}else{
 				top.layer.msg(msg,{icon: 5});
 			}
        },2000);
 		return false;
 	})
	
})