<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout Layui</title>
    <link rel="stylesheet" href="${ctx }/layui/css/layui.css">
    <style type="text/css">
    /* 数据表格复选框正常显示 */
	.layui-table-cell .layui-form-checkbox[lay-skin="primary"]{
	     top: 50%;
	     transform: translateY(-50%);
	}
    </style>
    <script src="${ctx }/layui/layui.js"></script>
    <script>  
        var ctx = "${ctx}";  
    </script> 
    
</head>
<body class="childrenBody">
<blockquote class="layui-elem-quote list_search">
    <shiro:hasPermission name="sys:menu:save">
        <div class="layui-inline">
            <a class="layui-btn" id="addMenu"><i class="layui-icon">&#xe608;</i>添加</a>
        </div>
    </shiro:hasPermission>
    <shiro:hasPermission name="sys:menu:update">
        <div class="layui-inline">
            <a class="layui-btn" id="editMenu"><i class="layui-icon">&#xe642;</i>编辑</a>
        </div>
    </shiro:hasPermission>
    <shiro:hasPermission name="sys:menu:delete">
        <div class="layui-inline">
            <a class="layui-btn layui-btn-danger" id="delMenu"><i class="layui-icon">&#xe640;</i>删除</a>
        </div>
    </shiro:hasPermission>
    <button class="layui-btn layui-btn-primary">（不选中为添加顶级菜单，选中添加子菜单）</button>
</blockquote>
<%--<div class="layui-btn-group TableTools" style="margin-left: 10px">
    <shiro:hasPermission name="sys:menu:save">
		<button class="layui-btn" id="addMenu">添加菜单</button>
    </shiro:hasPermission> 
    <shiro:hasPermission name="sys:menu:update">
		<button class="layui-btn" id="editMenu">编辑菜单</button>
    </shiro:hasPermission>   
    <shiro:hasPermission name="sys:menu:delete"> 
		<button class="layui-btn layui-btn-danger" id="delMenu">删除菜单</button>
	</shiro:hasPermission>  
<button class="layui-btn layui-btn-primary">（不选中为添加顶级菜单，选中添加子菜单）</button>
</div>--%>
<div><table class="layui-hidden" id="treeTable" lay-filter="treeTable"></table></div>
<script>
    layui.use(['element', 'layer', 'form', 'upload', 'treeGrid','jquery'], function () {
        var treeGrid = layui.treeGrid, form = layui.form,//很重要
        $ = layui.jquery,table = layui.table;
        var treeTable =treeGrid.render({
        	id:'treeTable'
            ,elem: '#treeTable'
            ,url:ctx+'/sys/menuData'
            ,cellMinWidth: 100
            ,treeId:'menuId'//树形id字段名称
            ,treeUpId:'parentId'//树形父id字段名称
            ,treeShowName:'title'//以树形式显示的字段
            ,cols: [[
                {field: 'menuId',title: '选择', width: 70,templet:"#radioTpl",unresize:true}
                ,{field:'title', title: '菜单名'}
                ,{field:'icon', width: 70, title: '图标',templet: '#iconTpl'}
                ,{field:'href',title: '链接'}
                ,{field:'perms',title: '权限标识'}/* 
                ,{ width: 220, align: 'center', toolbar: '#barTools' } */
            ]]
            ,page:false
        });
        
        $("#addMenu").click(function(){
        	var a = $("input[name='menuId']:checked").val();
        	if(a==undefined||a!=1){
        		if(a==undefined){
        			a=0;
        		}
        		/*//添加顶级菜单
        		layer.open({
		    	  type: 2,
		    	  title:"添加菜单",
		    	  area: ['500px', '400px'],
		    	  content:ctx+"/sys/toSaveMenu/"+a //这里content是一个普通的String
		      })*/
                var index =   layer.open({
                    type: 2,
                    title:"添加菜单",
                    content:ctx+"/sys/toSaveMenu/"+a //这里content是一个普通的String
                })
                //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
                $(window).resize(function(){
                    layui.layer.full(index);
                })
                layui.layer.full(index);
        	}else{
        		layer.msg("此菜单不允许操作！",{icon: 5});
        		return;
        	}
        	
        })
        
        $("#editMenu").click(function(){
        	var a = $("input[name='menuId']:checked").val();
        	if(a==undefined){
        		layer.msg("请选择要操作的菜单！",{icon: 5});
        		return;
        	}
        	if(a==1){
        		layer.msg("不允许操作的菜单！",{icon: 5});
        		return;
        	}
        		//添加顶级菜单
            var index = layer.open({
		    	  type: 2,
		    	  title:"编辑菜单",
		    	  content:ctx+"/sys/toEditMenu/"+a //这里content是一个普通的String
		      })
            //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
            $(window).resize(function(){
                layui.layer.full(index);
            })
            layui.layer.full(index);
        	
        })
        
        $("#delMenu").click(function(){
        	var a = $("input[name='menuId']:checked").val();
        	if(a==undefined){
        		layer.msg("请选择要操作的菜单！",{icon: 5});
        		return;
        	}
        	if(a==1){
        		layer.msg("不允许删除！",{icon: 5});
        		return;
        	}
        	layer.confirm('真的删除行么', function(index){
		    	  $.ajax({
		    		  url:ctx+'/sys/delMenuById/'+a,
		    		  type : "post",
		    		  success : function(d){
		    			  if(d.code==0){
		    				  layer.msg("删除成功！",{icon: 1});
		    				  setTimeout(function(){
		    				  		parent.location.reload();
		    			        },500);
		    			  }else{
		    				  layer.msg(d.msg,{icon: 5});
		    			  }
		    		  }
		    	  })
		        layer.close(index);
		      });
        	
        })
        
        //radio选中监听
        /* form.on("radio(radiodemo)",function(obj) {
		    layer.tips(this.value+" "+this.name+":"+obj.elem.checked,obj.othis);
		  }); */
        
      //监听工具条
		  /* table.on('tool(treeTable)', function(obj){
		    if(obj.event === 'del'){
		    	if(data.roleName=='超级管理员'){
		    		layer.msg("不允许操作此角色！",{icon: 5});
		    		return;
		    	}
		    	if(data.id==adminId){
		    		layer.msg("不允许删除自己！",{icon: 5});
		    		return;
		    	}
		      layer.confirm('真的删除行么', function(index){
		    	  $.ajax({
		    		  url:ctx+'/sys/delAdminById/'+data.id,
		    		  type : "get",
		    		  success : function(d){
		    			  if(d.code==0){
		    				  //obj.del();
		    				  table.reload('adminList', {})
		    			  }else{
		    				  layer.msg("权限不足，联系超管！",{icon: 5});
		    			  }
		    		  }
		    	  })
		        layer.close(index);
		      });
		    } else if(obj.event === 'edit'){
		    	if(data.menuId==1){
		    		layer.msg("不允许操作此数据！",{icon: 5});
		    		return;
		    	}
		      layer.open({
		    	  type: 2,
		    	  title:"编辑角色",
		    	  area: ['380px', '560px'],
		    	  content:ctx+"/sys/toEditMenu/"+data.menuId //这里content是一个普通的String
		      })
		    }
		  }); */
    });
</script>

<script type="text/html" id="barTools">
<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/html" id="iconTpl">
 		 {{#  if(d.icon === null){ }}
   			
		{{#  } else{ }}
			<i class="layui-icon">{{ d.icon }}</i>  
  		{{#  } }}
	</script>
	<script type="text/html" id="radioTpl">
  <input type="radio" name="menuId" value="{{d.menuId}}" title=" " lay-filter="radiodemo">
</script>
</body>
</html>