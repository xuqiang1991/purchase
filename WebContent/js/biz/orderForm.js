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
        elem: '#orderItem'
        ,url: ctx+'/biz/order/getItemList?orderId=' + orderId //数据接口
        /*,cellMinWidth: 80*/
        ,toolbar:'#bar'
        ,totalRow: true
        ,cols: [[ //表头
            {field:'id', title:'ID',fixed: 'left',hide:'true', unresize: true, sort: true, totalRowText: '合计'}
            ,{title: '序号', width: 60,event: 'setSign', templet:"#layIndex"}
            ,{field:'content', edit: 'text',event: 'setSign', title: '材料/项目内容'}
            ,{field:'model', edit: 'text',event: 'setSign', title: '规格型号'}
            ,{field:'unit', edit: 'text',event: 'setSign', title: '单位'}
            ,{field:'price', edit: 'text',event: 'setSign', title: '单价'}
            ,{field:'amount', edit: 'text',event: 'setSign', title: '数量'}
            ,{field:'totalPrice', title: '金额',event: 'setSign', totalRow: true}
            ,{field:'remark', edit: 'text',event: 'setSign', title: '备注'}
            ,{fixed:'right', title:'操作',event: 'setSign', align:'center', toolbar: '#barItem'}
        ]]
        ,where: {timestamp: (new Date()).valueOf()}
    });
    table.on('edit(orderItem)', function(obj){ //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
        var totalPrice = 0.00;
        if(obj.field == 'price' || obj.field == 'amount'){
            if(obj.data.price != null && obj.data.amount != null){
                totalPrice = obj.data.price * obj.data.amount;
                totalPrice = totalPrice.toFixed(2);
            }
        }
        obj.update({totalPrice: totalPrice});
    });
    table.on('toolbar(orderItem)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        switch(obj.event){
            case 'add':
                //console.log(table.cache["orderItem"][0]);
                //console.log(table.cache["orderItem"].length);
                var oldData = table.cache["orderItem"];
                var data1 = JSON.stringify(table.cache["orderItem"][0]);
                var addData = JSON.parse(data1);
                addData.LAY_TABLE_INDEX = table.cache["orderItem"].length;
                //addData.id = uuid();
                //var addData = {"id":"68a7a689ced944f08cbd9e1a0dffb675","orderId":null,"content":null,"model":null,"unit":null,"price":null,"amount":null,"totalPrice":null,"settleAmout":null,"remark":null,"createTime":null,"updateDate":null,"LAY_TABLE_INDEX":1};

                /*console.log("添加数据:" + JSON.stringify(addData));
                console.log("添加前:" + JSON.stringify(oldData));*/
                oldData.push(addData);
                /*console.log("添加后:" + JSON.stringify(oldData));

                /!*table.reload('orderItem', {
                    data: oldData
                });*!/

                console.log("重新加载:" + JSON.stringify(table.cache["orderItem"]));*/

                table.render({
                    elem: '#orderItem'
                    ,cellMinWidth: 80
                    ,toolbar:'#bar'
                    ,totalRow: true
                    ,cols: [[ //表头
                        {field:'id', title:'ID',fixed: 'left',hide:'true', unresize: true, sort: true, totalRowText: '合计'}
                        ,{title: '序号', width: 60,event: 'setSign', templet:"#layIndex"}
                        ,{field:'content', edit: 'text',event: 'setSign', title: '材料/项目内容'}
                        ,{field:'model', edit: 'text',event: 'setSign', title: '规格型号'}
                        ,{field:'unit', edit: 'text',event: 'setSign', title: '单位'}
                        ,{field:'price', edit: 'text',event: 'setSign', title: '单价'}
                        ,{field:'amount', edit: 'text',event: 'setSign', title: '数量'}
                        ,{field:'totalPrice', title: '金额',event: 'setSign', totalRow: true}
                        ,{field:'remark', edit: 'text',event: 'setSign', title: '备注'}
                        ,{fixed:'right', title:'操作',event: 'setSign', align:'center', toolbar: '#barItem'}
                    ]]
                    ,data: oldData
                });
                break;
            case 'save':
                layer.msg('保存');
                break;
        };
    });
    table.on('tool(orderItem)', function(obj){
        var data = obj.data;
        console.log(table.cache.orderItem.length);
        switch(obj.event){
            case 'save':
                layer.msg('添加');
                break;
            case 'del':
                var cloneLength = $("div[lay-id='orderItem']").find(".layui-table-box").find(".layui-table-body >table").find("tr");
                console.log(cloneLength);
                if(table.cache.orderItem.length > 1){
                    layer.confirm('確定删除行么', function(index){
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(index);
                        //向服务端发送删除指令
                    });
                }else{
                    layer.msg("请至少保留一条明细数据！");
                }
                break;
        };
    });
    /*table.on('row(orderItem)', function(obj){
        var data = obj.data;
        alert("123");
        layer.alert(JSON.stringify(data), {
            title: '当前行数据：'
        });

        //标注选中样式
        obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
    });*/
})

function uuid() {
    var s = [];
    var hexDigits = "0123456789abcdef";
    for (var i = 0; i < 36; i++) {
        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
    }
    s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
    s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
    s[8] = s[13] = s[18] = s[23] = "-";

    var uuid = s.join("").replace("-","");
    return uuid;
}