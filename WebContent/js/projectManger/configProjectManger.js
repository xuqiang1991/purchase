var $;
var $form;
var form;
layui.config({
	base : "js/"
}).use(['form','layer','jquery','laydate','table'],function(){
	var layer = parent.layer === undefined ? layui.layer : parent.layer,
        laydate = layui.laydate;
		$ = layui.jquery;
		form = layui.form;table = layui.table;
        laydate.render({
            elem: '#contractSignDate,#startDate,#overDate,#acceptanceDate' //指定元素
            //,max: 'new Date()'
        });
    form.verify({
        price: [
            /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/
            ,'金额格式错误'
        ]
    });
    var pmId = $("#projectMangerId").val();
    table.render({
        id:'instructOrderList',
        elem: '#instructOrderList'
        ,url: ctx+'/projectManger/getInstructList?pmId=' + pmId //数据接口
        ,cellMinWidth: 80
        ,limit:20//每页默认数
        ,limits:[10,20,30,40]
        ,cols: [[ //表头
            {type:'radio', width: 70,templet:"#radioTpl"}
            ,{field:'id', title: 'ID', width: 50, sort: true,templet:"#layIndex"}
            ,{field:'instructNo', title: '指令单号'}
            ,{field:'instructType', title: '类型',templet: '#instructType'}
            ,{field:'instructCentext', title: '内容'}
            ,{field:'commandDate', title: '下达日期'}
            ,{field:'commandUserName', title: '下达人'}
            ,{field:'createDate', title: '记录日期'}
            ,{field:'createAdmin', title: '记录人',templet: '#createAdmin'}
            ,{field:'editDate', title: '修改时间'}
            ,{field:'editAdmin', title: '修改人',templet: '#editAdmin'}

        ]]
        ,page: true //开启分页
        ,where: {timestamp: (new Date()).valueOf()}
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

    //添加指令
    $(".instructOrderAdd_btn").click(function(){
        if(pmId != null && pmId != ''){
            var index = layui.layer.open({
                title : "添加指令单",
                type : 2,
                content : "configInstruct?pmId=" + pmId,
                area: ['750px', '600px'],
                success : function(layero, index){
                    /*layui.layer.tips('点击此处返回指令单列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });*/
                }
            })
        }else{
            layer.msg("请先添加项目！",{icon: 5});
        }
    })

    //编辑指令
    $(".instructOrderUpdate_btn").click(function(){
        if(pmId != null && pmId != ''){
            var id = $(":radio[name='instructOrderId']:checked").val();
            if(id){
                var index = layui.layer.open({
                    title : "编辑指令单",
                    type : 2,
                    content : "configInstruct?pmId=" + pmId + "&id=" + id,
                    area: ['750px', '600px'],
                    success : function(layero, index){
                        /*layui.layer.tips('点击此处返回指令单列表', '.layui-layer-setwin .layui-layer-close', {
                            tips: 3
                        });*/
                    }
                })
            }else{
                layer.msg("请选择要操作的指令单！",{icon: 5});
            }
        }else{
            layer.msg("请先添加项目！",{icon: 5});
        }
    })

    $(".instructOrderDel_btn").click(function(){
        var id = $(":radio[name='instructOrderId']:checked").val();
        if(id){
            layer.confirm('确定删除？', function(index){
                //调用删除接口
                $.ajax({
                    url:ctx+'delInstruct?id='+id,//接口地址
                    type : "get",
                    success : function(d){
                        if(d.code==0){
                            //删除成功，刷新父页面
                            parent.location.reload();
                        }else{
                            layer.msg(d.msg,{icon: 5});
                        }
                    }
                })
            });
        }else{
            layer.msg("请选择要操作的指令单！",{icon: 5});
        }
    })

})

