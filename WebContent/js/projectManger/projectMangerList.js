layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage','table'],function(){
	var form = layui.form,table = layui.table;
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
		
		//数据表格
		table.render({
			id:'projectMangerList',
		    elem: '#projectMangerList'
		    ,url: ctx+'/projectManger/getProjectMangerList' //数据接口
		    ,cellMinWidth: 80
		    ,limit:20//每页默认数
		    ,limits:[10,20,30,40]
		    ,cols: [[ //表头
              {type:'radio', width: 70,templet:"#radioTpl"}
              ,{field:'id', title: 'ID', width: 50, sort: true,templet:"#layIndex"}
             /* ,{field:'projectNo', title: '项目编号'}*/
              ,{field:'shortName', title: '项目简称'}
              ,{field:'projectManagerName', title: '项目经理'}
              ,{field:'budgetLeaderName', title: '预算负责人'}
              ,{field:'developerName', title: '发展商'}
              ,{field:'consignorName', title: '委托商'}
              ,{field:'source', title: '项目来源',templet: '#sourceType'}
              ,{field:'nature', title: '项目性质',templet: '#natureType'}
              ,{field:'progressPlan', title: '工程进度方案',templet: '#progressPlanType'}
              ,{field:'status', title: '项目状态',templet: '#statusType'}
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
    $(".projectMangerQuery_btn").click(function() {
        search()
    })

    function search() {
        var name = $('#name'), projectManager = $('#projectManager option:selected'),developer = $('#developer option:selected'), consignor = $('#consignor option:selected'), status = $('#status option:selected');
        //执行重载
        table.reload('projectMangerList',
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

	//添加角色
	$(".projectMangerAdd_btn").click(function(){
		var index = layui.layer.open({
			title : "添加项目",
			type : 2,
			content : "configProjectManger",
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


    $(".projectMangerUpdate_btn").click(function(){
        var id = $(":radio[name='projectMangerId']:checked").val();
        if(id==undefined || id == null || id == ''){
            layer.msg("请选择要操作的项目！",{icon: 5});
            return;
        }

        var index = layui.layer.open({
            title : "编辑客户",
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
	
	//删除角色
	$(".projectMangerDel_btn").click(function(){
		var checkStatus = table.checkStatus('roleList')
	      ,data = checkStatus.data,roleStr='',flag=false;
//	      layer.alert(JSON.stringify(data));
		
		if(data.length>0){
			$.each(data, function (n, value) {
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
