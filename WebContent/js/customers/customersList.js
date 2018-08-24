layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage','table'],function(){
	var form = layui.form,table = layui.table;
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
		
		//数据表格
		table.render({
			id:'customersList',
		    elem: '#customersList'
		    ,url: ctx+'/customers/getCustomersList' //数据接口
		    ,cellMinWidth: 80
		    ,limit:10//每页默认数
		    ,limits:[10,20,30,40]
		    ,cols: [[ //表头
              {type:'radio', width: 70,templet:"#radioTpl"}
              ,{field:'id', title: 'ID', width: 50, sort: true}
              ,{field:'fullName', title: '客户名称'}
              ,{field:'shortName', title: '客户简称'}
                ,{field:'areaName', title: '地区'}
              /*,{field:'type', title: '客户类别',templet: '#customersType'}*/
              ,{field:'chargeName', title: '负责人'}
              /*,{field:'chargePhone', title: '负责人电话'}*/
              ,{field:'linkName', title: '联系人'}
              /*,{field:'linkPhone', title: '联系人电话'}*/
             /* ,{field:'addDate', title: '新增时间',templet: '<div>{{ formatTime(d.addDate,"yyyy-MM-dd")}}</div>'}*/
              /*,{field:'address', title: '地址'}*/
              ,{field:'isForce', title: '是否生效',templet:"#customersIsForce"}
                /*名称、简称、地区、负责人、联系人、联系人电话、是否有效*/
             // ,{field:'remark', title: '备注'}
             // ,{title: '操作',toolbar: '#barEdit'}
		    ]]
				,page: true //开启分页
				,where: {timestamp: (new Date()).valueOf()}
		  });

    //查询
    $(".customersQuery_btn").click(function() {
        search()
    })

    function search() {
        var name = $('#name'), areaId = $('#areaId'),isForce = $('#isForce option:selected');
        //执行重载
        table.reload('customersList',
            {
                page : {
                    curr : 1 //重新从第 1 页开始
                },
                where : {
                    name : name .val(),
                    areaId : areaId.val(),
                    isForce : isForce.val()
                }
            });
    }

		  
	//添加角色
	$(".customersAdd_btn").click(function(){
		var index = layui.layer.open({
			title : "添加客户",
			type : 2,
			content : "configCustomers",
			success : function(layero, index){
				layui.layer.tips('点击此处返回角色列表', '.layui-layer-setwin .layui-layer-close', {
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


    $(".customersUpdate_btn").click(function(){
        var id = $(":radio[name='customersId']:checked").val();
        if(id==undefined || id == null || id == ''){
            layer.msg("请选择要操作的客户！",{icon: 5});
            return;
        }

        var index = layui.layer.open({
            title : "编辑客户",
            type : 2,
            content:ctx+"/customers/configCustomers?id="+id,
            success : function(layero, index){
                layui.layer.tips('点击此处返回客户列表', '.layui-layer-setwin .layui-layer-close', {
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
	
	//删除角色
	$(".customersDel_btn").click(function(){
		var checkStatus = table.checkStatus('roleList')
	      ,data = checkStatus.data,roleStr='',flag=false;
//	      layer.alert(JSON.stringify(data));
		
		if(data.length>0){
			$.each(data, function (n, value) {
				  //避免选择不允许操作角色
	              if(value.roleName=='超级管理员'){
	            	  flag=true;
	            	  layer.msg('"超级管理员"不允许删除！',{icon: 5});
	            	  return;
	              }
	              roleStr+=value.roleId+',';
	          });
			//包含不允许操作角色，结束方法
			  if(flag){
				  return;
			  }
			  roleStr=roleStr.substring(0,roleStr.length-1);
			  layer.confirm('真的要删除<strong>'+data.length+'</strong>条数据吗？', function(index){
				//调用删除接口
				  $.ajax({
			    		  url:ctx+'/sys/delRoles/'+roleStr,//接口地址
			    		  type : "get",
			    		  success : function(d){
			    			  if(d.code==0){
			    				  //删除成功，刷新父页面
			    				  parent.location.reload();
			    			  }else{
			    				  layer.msg("权限不足，联系超管！",{icon: 5});
			    			  }
			    		  }
			    	  })
			  });
		}else{
			layer.msg("请选择要操作的数据！");
		}
		
	})
	
})
