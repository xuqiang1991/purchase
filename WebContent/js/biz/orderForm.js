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
})
var regExpUtil = new RegExpUtil();
/**
 * 中文、英文、数字但不包括下划线等符号 必填
 */
function checkContent(event){
    var value = event.value;
    if (!regExpUtil.checkStr(value) || value.length > 20) {
        $(event).focus();
        $(event).val(value.substring(0,value.length - 1));
        layer.msg("材料/项目内容格式错误",{icon: 0});
    }
}

//增加一行
function add(){
    var tbody = $("#orderItem").find("tbody");
    var tr = $(tbody).find("tr:first-child").clone();
    $(tbody).append("<tr>" + tr.html() + "</tr>>");
    sort();
}

function del(event){
    if($(event).parent().parent().parent().length > 1){
        $(event).parent().parent().parent().remove()
    }else{
        layer.msg("不能删除，请至少保留一条明细数据",{icon: 0});
    }
    sort();
}

//排序
function sort(){
    var tr = $("#orderItem").find("tbody >tr");
    if(tr.length > 0){
        tr.each(function(idx,item){
            var idxText = "001";
            if(idx < 9){
                idxText = "00" + (idx + 1);
            }else{
                idxText = "0" + (idx + 1);
            }
            $(item).find("td:first").find("div").text(idxText);
        });
    }
}
//金额计算
function reckon(event){
    var tr = $(event).parent().parent();
    var price = 0, amount = 0, totalPrice = 0.00;
    price = $(tr).find("input[name='price']").val();
    amount = $(tr).find("input[name='amount']").val();
    totalPrice = price * amount;
    $(tr).find("input[name='totalPrice']").val(totalPrice);
}



