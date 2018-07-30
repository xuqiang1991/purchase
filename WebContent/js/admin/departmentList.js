layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage','table','laytpl'],function(){
	var form = layui.form,table = layui.table;
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
		//数据表格
		table.render({
			id:'departmentList',
		    elem: '#departmentList'
		    ,url: ctx+'/sys/getDepartmentList' //数据接口
		    ,cellMinWidth: 80
		    ,limit:10//每页默认数
		    ,limits:[10,20,30,40]
		    ,cols: [[ //表头
              {type:'checkbox'}
              ,{field:'id', title: 'ID', sort: true}
              ,{field:'name', title: '组织名称'}
              ,{field:'parentName', title: '上级组织'}
              ,{field:'principal', title: '负责人'}
              ,{field:'phone', title: '负责人电话'}
              ,{field:'valid', title: '是否生效'}
              ,{title: '操作',toolbar: '#barEdit'}
		    ]]
				,page: true //开启分页
				,where: {timestamp: (new Date()).valueOf()}
		  });
		//监听工具条
		  table.on('tool(test)', function(obj){
		    var data = obj.data,adminId=$("#adminId").val();
		    if(obj.event === 'del'){
		    	if(data.id==adminId){
		    		layer.msg("不允许删除自己！",{icon: 5});
		    		return;
		    	}
		      layer.confirm('真的删除行么', function(index){
		    	  $.ajax({
		    		  url:ctx+'/sys/delDepartmentById/'+data.id,
		    		  type : "get",
		    		  success : function(d){
		    			  if(d.code==0){
		    				  //obj.del();
		    				  table.reload('departmentList', {})
		    			  }else{
		    				  layer.msg("权限不足，联系超管！",{icon: 5});
		    			  }
		    		  }
		    	  })
		        layer.close(index);
		      });
		    } else if(obj.event === 'edit'){
		      layer.open({
		    	  type: 2,
		    	  title:"编辑部门",
		    	  area: ['380px', '560px'],
		    	  content:ctx+"/sys/editDepartment/"+data.id //这里content是一个普通的String
		      })
		    }
		  });
		  

	//添加部门
	$(".departmentAdd_btn").click(function(){
		var index = layui.layer.open({
			title : "添加部门",
			type : 2,
			content : ctx+"/sys/addDepartment",
			success : function(layero, index){
				layui.layer.tips('点击此处返回部门列表', '.layui-layer-setwin .layui-layer-close', {
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
	
	//批量删除部门
	$(".batchDel").click(function(){
		var checkStatus = table.checkStatus('departmentList')
	      ,data = checkStatus.data,adminStr='',flag=false,adminId=$("#id").val();
		if(data.length>0){
			$.each(data, function (n, value) {
	              adminStr+=value.id+',';
	          });
			//包含不允许操作角色，结束方法
			  if(flag){
				  return;
			  }
			  adminStr=adminStr.substring(0,adminStr.length-1);
			  layer.confirm('真的要删除<strong>'+data.length+'</strong>条数据吗？', function(index){
				//调用删除接口
				  $.ajax({
			    		  url:ctx+'/sys/delDepartments/'+adminStr,//接口地址
			    		  type : "get",
			    		  success : function(d){
			    			  if(d.code==0){
			    				  //删除成功，刷新父页面
			    				  parent.location.reload();
			    			  }else{
			    				  layer.msg("删除错误，稍后再试！",{icon: 5});
			    			  }
			    		  }
			    	  })
			  });
		}else{
			layer.msg("请选择要操作的数据！");
		}
		
	})
	
})
