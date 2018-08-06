layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage','table'],function(){
	var form = layui.form,table = layui.table;
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
		
		//数据表格
		table.render({
			id:'supplierList',
		    elem: '#supplierList'
		    ,url: ctx+'/supplier/getSupplierList' //数据接口
		    ,cellMinWidth: 80
		    ,limit:10//每页默认数
		    ,limits:[10,20,30,40]
		    ,cols: [[ //表头
              {type:'checkbox'}
              ,{field:'id', title: 'ID', width: 50, sort: true}
              ,{field:'name', title: '名称'}
              ,{field:'nick', title: '简称'}
              ,{field:'type', title: '供应商类别',templet:"#typeTpl",unresize:true}
              ,{field:'areaName', title: '地区'}
		  	  ,{field:'principalName', title: '负责人'}
			  ,{field:'contactName', title: '联系人'}
			  ,{field:'contactPhone', title: '联系人电话'}
			  ,{field:'valid', title: '是否有效',templet:"#validTpl",unresize:true}
              //,{title: '操作',toolbar: '#barEdit'}
		    ]]
				,page: true //开启分页
				,where: {timestamp: (new Date()).valueOf()}
		  });

		//监听工具条
		  table.on('tool(supplierList)', function(obj){
                var data = obj.data;
                if(obj.event === 'del'){
                    delSupplier(data.id)
                } else if(obj.event === 'edit'){
                    editSupplier(data.id)
                }
		  });

    //查询
    $(".search_btn").click(function() {
        search()
    })

    function search() {
        var name = $('#name'), type = $('#type option:selected'),areaId = $('#areaId option:selected'), valid = $('#valid option:selected');
        //执行重载
        table.reload('supplierList',
                {
                    page : {
                        curr : 1 //重新从第 1 页开始
                    },
                    where : {
                        name : name .val(),
                        type : type.val(),
                        areaId : areaId.val(),
                        valid : valid.val()
                    }
                });
    }


	//添加供应商
    $("#addSupplier").click(function(){
        addSupplier();
    })
	
	function addSupplier() {
        var a = $("input[name='id']:checked").val();
        if(a==undefined){
            a=0;
        }
        //添加供应商
        layer.open({
            type: 2,
            title:"添加供应商",
            area: ['900px', '600px'],
            content:ctx+"/supplier/toSaveSupplier/"+a
        })
    }

    $("#editSupplier").click(function(){
        editSupplier()

    })

	function editSupplier(id) {
        var a = $("input[name='id']:checked").val();
        if(id != undefined){
            a = id;
        }
        if(a==undefined){
            layer.msg("请选择要操作的供应商！",{icon: 5});
            return;
        }
        layer.open({
            type: 2,
            title:"编辑供应商",
            area: ['900px', '600px'],
            content:ctx+"/supplier/toEditSupplier/"+a
        })
    }

    $("#delSupplier").click(function(){
        delSupplier()
    })

	function delSupplier(id) {
        var a = $("input[name='id']:checked").val();

    	if(id != undefined){
            a = id;
		}

        if(a==undefined){
            layer.msg("请选择要操作的部门！",{icon: 5});
            return;
        }
        layer.confirm('真的删除行么', function(index){
            $.ajax({
                url:ctx+'/supplier/delSupplierById/'+a,
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
    }

})
