layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage','table','laydate'],function(){
	var form = layui.form,table = layui.table;laydate = layui.laydate;
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
        laydate.render({
            elem: '#startCreateTime' //指定元素
        });
        laydate.render({
            elem: '#endCreateTime' //指定元素
        });
		
		//数据表格
		table.render({
			id:'orderList',
		    elem: '#orderList'
		    ,url: ctx+'/biz/order/getList' //数据接口
		    ,cellMinWidth: 80
		    ,limit:20//每页默认数
		    ,limits:[10,20,30,40]
		    ,cols: [[ //表头
              {type:'radio', width: 70,templet:"#radioTpl"}
              ,{field:'id', title: 'ID', width: 50, sort: true,templet:"#layIndex"}
              ,{field:'orderNo', title: '单号'}
              ,{field:'type', title: '订单类型'}
              ,{field:'supplierId', title: '供应商'}
              ,{field:'projectId', title: '所属项目'}
              ,{field:'contractNo', title: '合同号'}
              ,{field:'createUser', title: '开单人'}
              ,{field:'createTime', title: '开单日期',templet: '#sourceType'}
              ,{field:'lastReviewUser', title: '审核人',templet: '#natureType'}
              ,{field:'lastReviewDate', title: '审核日期',templet: '#progressPlanType'}
              ,{field:'status', title: '单号状态',templet: '#statusType'}
		    ]]
				,page: true //开启分页
				,where: {timestamp: (new Date()).valueOf()}
		  });

		//监听单元格编辑
		  /*table.on('edit(test)', function(obj){
		    var value = obj.value //得到修改后的值
		    ,data = obj.data //得到所在行所有键值
		    ,field = obj.field; //得到字段
		    setTimeout(function(){
	        	$.ajax({
	                type: "POST",
	                url: "saveRole",
	                data:{'roleId':data.roleId,'roleName':value},
	            });
	        },1000);
		    layer.msg('角色名更改为：'+ value,{icon: 1});
		  });*/


    //查询
    $(".query_btn").click(function() {
        search()
    })

    function search() {
        var name = $('#name'), projectManager = $('#projectManager option:selected'),developer = $('#developer option:selected'), consignor = $('#consignor option:selected'), status = $('#status option:selected');
        //执行重载
        table.reload('orderList',
            {
                page : {
                    curr : 1 //重新从第 1 页开始
                },
                where : {
                    name : name .val(),
                    projectManager : projectManager.val(),
                    developer : developer.val(),
                    consignor : consignor.val(),
                    status : status.val()
                }
            });
    }

	//添加
	$(".add_btn").click(function(){
	    var url = ctx+"/biz/order/toEdit";
		var index = layui.layer.open({title : "添加订单",type : 2,content : url});
		//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
		$(window).resize(function(){layui.layer.full(index);});
		layui.layer.full(index);
	})


    //编辑
    $(".update_btn").click(function(){
        var id = $(":radio[name='id']:checked").val();
        if(id==undefined || id == null || id == ''){
            layer.msg("请选择要操作的订单！",{icon: 5});
            return;
        }

        var index = layui.layer.open({
            title : "编辑订单",
            type : 2,
            content:ctx+"/projectManger/configProjectManger?id="+id,
            success : function(layero, index){
                layui.layer.tips('点击此处返回项目列表', '.layui-layer-setwin .layui-layer-close', {
                    tips: 3
                });
            }
        })
        //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
        $(window).resize(function(){
            layui.layer.full(index);
        })
        layui.layer.full(index);
    })
	
	//删除
	$(".del_btn").click(function(){
        var id = $(":radio[name='projectMangerId']:checked").val();
        if(id==undefined || id == null || id == ''){
            layer.msg("请选择要操作的数据！",{icon: 5});
            return;
        }

		  layer.confirm('是否确定删除？', function(index){
			//调用删除接口
			  $.ajax({
					  url:ctx+'/projectManger/delProject/'+id,//接口地址
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

	})
	
})
