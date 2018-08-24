var $;
var $form;
var form;
layui.config({
	base : "js/"
}).use(['form','layer','jquery','laydate'],function(){
	var layer = parent.layer === undefined ? layui.layer : parent.layer,
        laydate = layui.laydate;
		$ = layui.jquery;
		form = layui.form;
        laydate.render({
            elem: '#contractSignDate,#startDate,#overDate,#acceptanceDate' //指定元素
            ,max: 'new Date()'
        });
    form.verify({
        price: [
            /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/
            ,'金额格式错误'
        ]
    });

    form.on("submit(projectMangerAdd)",function(data){
 		//弹出loading
 		var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
 		/*var json = JSON.parse(data);*/

 		var msg;
 		$.ajax({
    		type: "post",
            url: ctx+"/projectManger/saveProjectManger",
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

