function supplierSelect(event,hiddenId,textId){
    layui.use(['layer','jquery'],function(){
        var layer = parent.layer === undefined ? layui.layer : parent.layer,
            $ = layui.jquery;
        layer.open({
            type: 2,
            title:"选择供应商",
            btn: ['确认','取消'],
            area: ['800px', '635px'],
            content:ctx+"/supplier/selectSuppliers",
            yes: function(index, layero){
                var select = $(layero).find("iframe").contents().find(".layui-table-click");//find("input[name='id']:checked");
                if(select.length == 1){
                    var id = select.find("td:eq(1)").find(":hidden[name='id']").val();
                    var name = select.find("td:eq(1) >div").text();
                    console.log(id);
                    $('#' + hiddenId).val(id);
                    $('#' + textId).val(name);
                    layer.close(index); //如果设定了yes回调，需进行手工关闭
                }else {
                    layer.msg('请选择供应商', {time: 5000, icon:6});
                }
            }
        })
    })
}
