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

    $("#areaName").click(function(){
        var obj = this;
        layer.open({
            type: 2,
            title:"地区选择",
            btn: ['确认','取消'],
            area: ['400px', '400px'],
            content:ctx+"/sys/selectArea",
            yes: function(index, layero){

                var selectArea = $(layero).find("iframe").contents().find("input[name='id']:checked");
                if(selectArea.length == 1){
                    var id = selectArea.val();
                    var name = selectArea.attr('m')
                    $(obj).val(name);
                    $('#areaId').val(id)
                    layer.close(index); //如果设定了yes回调，需进行手工关闭
                }else {
                    layer.msg('请选择地区', {time: 5000, icon:6});
                }
            },
            cancel: function(){
                layer.msg('捕获就是从页面已经存在的元素上，包裹layer的结构', {time: 5000, icon:6});
            }

        })
    })

})