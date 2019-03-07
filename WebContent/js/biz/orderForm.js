var $;
var $form;
var form;
layui.config({
    base : "js/"
}).use(['form','layer','jquery','laydate','table'],function(){
    var layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,laydate = layui.laydate,table = layui.table;
    $ = layui.jquery;
    form = layui.form;
    laydate.render({elem: '#applyDate',max: 'new Date()'});
    laydate.render({elem: '#contractSignDate',max: 'new Date()'});


    //自定义验证规则
    form.verify({
        pass: [/(.+){6,16}$/, '密码必须6到16位']
        ,repass: function(value){
            var repassvalue = $('#password').val();
            if(value != repassvalue){
                return '两次输入的密码不一致!';
            }
        }
    });

    //选人控件
    $("#selectApplyUserEdit").click(function(){
        adminSelect('selectApplyUserEdit','applyUserEdit','selectApplyUserEdit');
    });

    //选人项目控件
    $("#selectProjectId").click(function(){
        projectMangerSelect('selectProjectId','projectId','selectProjectId');
    });

    //选人项目控件
    $("#selectSupplierId").click(function(){
        supplierSelect('selectSupplierId','supplierId','selectSupplierId');
    });

    form.on("submit(add)",function(data){
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        var msg,flag=false;
        $.ajax({
            type: "post",
            url: ctx+"/user/insUser",
            async:false,
            data:data.field,
            dataType:"json",
            success:function(d){
                if(d.code==0){
                    msg="用户添加成功！";
                    flag=true;
                    $("#auf")[0].reset();
                }else{
                    msg=d.msg;
                }
            }
        });
        setTimeout(function(){
            top.layer.close(index);
            if(flag){
                top.layer.msg(msg,{icon: 1});
            }else{
                top.layer.msg(msg,{icon: 5});
            }
            //layer.closeAll("iframe");
            //刷新父页面
            //parent.location.reload();
        },2000);
        return false;
    })

    var orderId = $("#orderId").val();
    table.render({
        id:'orderItem',
        elem: '#orderItem'
        ,url: ctx+'/biz/order/getItemList?orderId=' + orderId //数据接口
        ,cellMinWidth: 80
        ,toolbar:'#bar'
        ,cols: [[ //表头
            {field:'id', title: '序号', width: 60, templet:"#layIndex"}
            ,{field:'content', title: '材料/项目内容'}
            ,{field:'model', title: '规格型号',templet: '#instructType'}
            ,{field:'unit', title: '单位'}
            ,{field:'price', title: '单价'}
            ,{field:'amount', title: '数量'}
            ,{field:'totalPrice', title: '金额'}
            ,{field:'remark', title: '备注'}
            ,{fixed:'right', title:'操作', align:'center', toolbar: '#barItem'}
        ]]
        ,where: {timestamp: (new Date()).valueOf()}
    });

})