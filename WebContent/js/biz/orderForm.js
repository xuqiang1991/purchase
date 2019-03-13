var $;
var $form;
var form;
layui.config({
    base : "js/"
}).use(['form','layer','jquery','laydate','table','element'],function(){
    var layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,laydate = layui.laydate,table = layui.table,element = layui.element;
    $ = layui.jquery;
    form = layui.form;
    laydate.render({elem: '#applyDate',max: 'new Date()'});
    laydate.render({elem: '#contractSignDate',max: 'new Date()'});

    //选人控件
    $("#selectApplyUserEdit").click(function(){
        adminSelect('selectApplyUserEdit','applyUserEdit','selectApplyUserEdit');
    });

    //选项目控件
    $("#selectProjectId").click(function(){
        projectMangerSelect('selectProjectId','projectId','selectProjectId');
    });

    //选供应商
    $("#selectSupplierId").click(function(){
        supplierSelect('selectSupplierId','supplierId','selectSupplierId');
    });

    //加载明细
    loadDetail();
    //保存订单
    form.on("submit(save)",function(data){
        //弹出loading
        console.log(JSON.stringify(data.field));
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        var msg,flag=false;
        $.ajax({
            type: "post",
            url: ctx+"/biz/order/save",
            async:false,
            data:data.field,
            dataType:"json",
            success:function(d){
                if(d.code==0){
                    msg="保存成功！";
                    flag=true;
                    //$("#auf")[0].reset();
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
})

var regExpUtil = new RegExpUtil();
/**
 * 材料/项目内容 验证
 */
function checkContent(event){
    var value = event.value;
    if (!regExpUtil.checkStr(value) || value.length > 20) {
        $(event).focus();
        $(event).val(value.substring(0,value.length - 1));
        layer.msg("材料/项目内容格式错误",{icon: 0});
    }
}

/**
 * 规格型号 验证
 * @param event
 */
function checkModel(event){
    var value = event.value;
    if (!regExpUtil.checkStr(value) || value.length > 20) {
        $(event).focus();
        $(event).val(value.substring(0,value.length - 1));
        layer.msg("规格型号格式错误",{icon: 0});
    }
}
/**
 * 单位 验证
 * @param event
 */
function checkUnit(event){
    var value = event.value;
    if (!regExpUtil.checkStr(value) || value.length > 20) {
        $(event).focus();
        $(event).val(value.substring(0,value.length - 1));
        layer.msg("单位格式错误",{icon: 0});
    }
}

/**
 * 单价 验证
 * @param event
 */
function checkPrice(event){
    var value = event.value;
    if (!regExpUtil.checkPrice(value)) {
        $(event).focus();
        $(event).val("");
        layer.msg("单价格式错误",{icon: 0});
    }
}

/**
 * 数量 验证
 * @param event
 */
function checkAmount(event){
    var value = event.value;
    if (!regExpUtil.checkPrice(value)) {
        $(event).focus();
        $(event).val("");
        layer.msg("数量格式错误",{icon: 0});
    }
}

/**
 * 单位 验证
 * @param event
 */
function checkUnit(event){
    var value = event.value;
    if (!regExpUtil.checkStr(value) || value.length > 20) {
        $(event).focus();
        $(event).val(value.substring(0,value.length - 1));
        layer.msg("单位格式错误",{icon: 0});
    }
}

/**
 * 备注 验证
 * @param event
 */
function checkRemark(event){
    var value = event.value;
    if (!regExpUtil.checkStr(value) || value.length > 50) {
        $(event).focus();
        $(event).val(value.substring(0,value.length - 1));
        layer.msg("备注格式错误",{icon: 0});
    }
}

//增加一行
function add(){
    var tbody = $("#orderItem").find("tbody");
    var tr = $(tbody).find("tr:first-child").clone();
    $(tbody).append("<tr>" + tr.html() + "</tr>>");
    sort();
}
//删除
function del(event){
    var tr = $("#orderItem").find("tbody >tr");
    if(tr.length > 1){
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
    if(regExpUtil.checkPrice(price) && regExpUtil.checkPrice(amount)){
        totalPrice = (price * amount).toFixed(2);
    }
    $(tr).find("input[name='totalPrice']").val(totalPrice);
}

//加载订单明细
function loadDetail(){
    var orderId = $("#orderId").val();
    var loadDetailUrl = ctx+"/biz/order/getItemList";
    var data = {orderId:orderId};
    $.getJSON(loadDetailUrl, data, function(json){
        console.log(JSON.stringify(json.data));
        if(json.code == 0){
            var result = json.data;
            console.log(result.length);
            var html = "";
            for(var i = 0; i < result.length; i++){
                html += '<tr><td><div class="layui-table-cell">' + i + '</div></td>' +
                    '<td><input class="layui-input layui-table-edit" name="content" value="'+ result[i].content +'" lay-verify="required" onkeyup="checkContent(this);" /></td>' +
                    '<td><input class="layui-input layui-table-edit" name="model" value="'+ result[i].model +'" onkeyup="checkModel(this);" /></td>' +
                    '<td><input class="layui-input layui-table-edit" name="unit" value="'+ result[i].unit +'" lay-verify="required" onkeyup="checkUnit(this);" /></td>' +
                    '<td><input class="layui-input layui-table-edit" name="price" value="'+ result[i].price +'" lay-verify="required" onblur="checkPrice(this);" onkeyup="reckon(this);" /></td>' +
                    '<td><input class="layui-input layui-table-edit" name="amount" value="'+ result[i].amount + '" lay-verify="required" onblur="checkAmount(this);" onkeyup="reckon(this);" /></td>' +
                    '<td><input class="layui-input layui-table-edit" readonly name="totalPrice" value="'+ result[i].totalPrice + '" /></td>' +
                    '<td><input class="layui-input layui-table-edit" name="remark" value="'+ result[i].remark +'" lay-verify="required" onkeyup="checkRemark(this);" /></td>' +
                    '<td align="center" class="layui-table-col-special"><div class="layui-table-cell"><a class="layui-btn layui-btn-danger layui-btn-xs" onclick="del(this)" title="删除"><i class="layui-icon"></i></a></div></td></tr>';

            }
            $("#orderItem >tbody").html(html);
            sort();
        }
    });
}

//保存明细集合
function saveItem(){
    var orderId = $("#orderId").val();
    if(orderId != null && orderId != ''){
        var checkFlag = true;
        var itemTr = $("#orderItem >tbody >tr");
        var arrayTr = [];
        itemTr.each(function(idx,item){
            var inputItem = $(item).find("input");
            var str = '';
            inputItem.each(function(){
                var verify = $(this).attr("lay-verify");
                var name = $(this).attr("name");
                var value = $(this).val();
                if(verify != null && verify == 'required' && (value.trim() == '' || value.trim() == null)){
                    checkFlag = false;
                    return false;
                }else{
                    str += '"'+ name +'":"'+value+'",';
                }
            });
            if(str != null && str != ''){
                str = '{' + str.substring(0,str.length - 1);
                str = str + '}';
                console.log(str);
                arrayTr.push(JSON.parse(str));
            }
        });
        console.log(checkFlag);
        console.log(JSON.stringify(arrayTr));
        var requestParams = {};
        if(checkFlag){
            requestParams.orderId = orderId;
            requestParams.list = arrayTr;
            //console.log(JSON.stringify(requestParams));
            var url = ctx + '/biz/order/saveItemList';
            var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
            var msg,flag=false;
            $.ajax({
                url: url,
                /*dataType: 'json',
                headers: {'Content-type': 'application/json;charset=UTF-8'},*/
                dataType: 'text',
                contentType:'application/json;charset=UTF-8',
                type: 'post',
                data: JSON.stringify(requestParams),
                timeout: 10000,
                success: function(data) {
                    var result = JSON.parse(data);
                    if(result.code != 0){
                        top.layer.close(index);
                        layer.msg(result.msg);
                    }else {
                        flag = true;
                        top.layer.close(index);
                        layer.msg("保存成功",{icon: 0});
                        window.location.reload();
                    }
                }
            });
           /* setTimeout(function(){
                top.layer.close(index);
                if(flag){
                    top.layer.msg(msg,{icon: 1});
                }else{
                    top.layer.msg(msg,{icon: 5});
                }
                //layer.closeAll("iframe");
                //刷新父页面
                //parent.location.reload();
            },2000);*/

        }else{
            layer.msg("明细有必填项未填，请检查",{icon: 0});
        }
    }else{
        layer.msg("请先添加订单",{icon: 0});
    }

}

/**
 * 提交订单
 */
function submitOrder(){
    var orderId = $("#orderId").val();
    if(orderId != null && orderId != ''){
        toSubmit(1,1,1);
        //adminSelect('selectApplyUserEdit','applyUserEdit','selectApplyUserEdit');






        /*var msg,flag=false;
        var url = ctx + '/biz/order/submit?id='+orderId+'&userId=' + userId + '&roleId=' + roleId;
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        $.ajax({
            type: "post",
            url: url,
            dataType:"json",
            contentType : "application/x-www-form-urlencoded",
            success:function(d){
                if(d.code==0){
                    msg="保存成功！";
                    flag=true;
                    //$("#auf")[0].reset();
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
        return false;*/
    }else{
        layer.msg("请先添加订单",{icon: 0});
    }
}

/**
 * 审核订单
 */
function reviewOrder(){

}

/**
 * 作废订单
 */
function invalidOrder(){

}


