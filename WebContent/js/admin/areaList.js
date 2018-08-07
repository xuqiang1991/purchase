layui.use(['element', 'layer', 'form', 'upload', 'treeGrid','jquery'], function () {
    var treeGrid = layui.treeGrid, form = layui.form,//很重要
        $ = layui.jquery,table = layui.table;
		var treeTable =treeGrid.render({
			id:'treeTable'
			,elem: '#treeTable'
			,url:ctx+'/sys/getAreaList'
			,cellMinWidth: 100
			,treeId:'id'//树形id字段名称
			,treeUpId:'parentId'//树形父id字段名称
			,treeShowName:'name'//以树形式显示的字段
			,cols: [[
				{field: 'id',title: 'ID', width: 70,templet:"#radioTpl",unresize:true}
				,{field:'name', title: '名称'}
				,{field:'valid',title: '是否生效',templet:"#validTpl",unresize:true}
			]]
			,page:false
		});

    $("#addArea").click(function(){
        var a = $("input[name='id']:checked").val();
            if(a==undefined){
                a=0;
            }
        var index = layer.open({
                type: 2,
                title:"添加地区",
                area: ['470px', '360px'],
                content:ctx+"/sys/toSaveArea/"+a //这里content是一个普通的String
            })
        //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
        $(window).resize(function(){
            layui.layer.full(index);
        })
        layui.layer.full(index);
    })

    $("#editArea").click(function(){
        var a = $("input[name='id']:checked").val();
        if(a==undefined){
            layer.msg("请选择要操作的地区！",{icon: 5});
            return;
        }
       var index = layer.open({
            type: 2,
            title:"编辑地区",
            area: ['470px', '360px'],
            content:ctx+"/sys/toEditArea/"+a
        })
        //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
        $(window).resize(function(){
            layui.layer.full(index);
        })
        layui.layer.full(index);

    })

    $("#delArea").click(function(){
        var a = $("input[name='id']:checked").val();
        if(a==undefined){
            layer.msg("请选择要操作的地区！",{icon: 5});
            return;
        }
        layer.confirm('真的删除行么', function(index){
            $.ajax({
                url:ctx+'/sys/delAreaById/'+a,
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
})
