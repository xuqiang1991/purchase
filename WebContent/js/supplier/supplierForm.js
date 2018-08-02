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
            url: ctx+"/supplier/supplierForm",
            async:false,
            data:data.field,
			dataType:"json",
			success:function(d){
                msg=d.msg;
                layer.msg(msg,{icon: 1});
                setTimeout(function(){
                    top.layer.close(index);
                    layer.closeAll("iframe");
                    parent.location.reload();
                },1000);
			}
        });
 		return false;
 	})
	
})