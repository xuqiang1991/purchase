layui.use(['layer','jquery'],function(){
    var layer = parent.layer === undefined ? layui.layer : parent.layer,
    $ = layui.jquery;
    $("#areaName").click(function(){
        var obj = this;
        layer.open({
            type: 2,
            title:"地区选择",
            btn: ['确认','取消'],
            area: ['400px', '400px'],
            content:ctx+"/sys/selectArea",
            yes: function(index, layero){

                var selectArea = $(layero).find("iframe").contents().find("input[name='id']:checked");
                if(selectArea.length == 1){
                    var id = selectArea.val();
                    var name = selectArea.attr('m')
                    $(obj).val(name);
                    $('#areaId').val(id)
                    layer.close(index); //如果设定了yes回调，需进行手工关闭
                }else {
                    layer.msg('请选择地区', {time: 5000, icon:6});
                }
            }
        })
    })

})
