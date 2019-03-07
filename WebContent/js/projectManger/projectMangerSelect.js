function projectMangerSelect(event,hiddenId,textId){
    layui.use(['layer','jquery'],function(){
        var layer = parent.layer === undefined ? layui.layer : parent.layer,
            $ = layui.jquery;
        /*$("#" + event).click(function(){

        })*/
        //var obj = this;
        layer.open({
            type: 2,
            title:"选择项目",
            btn: ['确认','取消'],
            area: ['800px', '635px'],
            content:ctx+"/projectManger/selectProjectManger",
            yes: function(index, layero){
                var select = $(layero).find("iframe").contents().find(".layui-table-click");//find("input[name='id']:checked");
                console.log(select.find("td:eq(0) >div").text());
                if(select.length == 1){
                    var id = select.find("td:eq(0) >div").text();
                    var name = select.find("td:eq(1) >div").text();
                    console.log(id + "---" + name);
                    //$(obj).val(name);
                    $('#' + hiddenId).val(id);
                    $('#' + textId).val(name);
                    layer.close(index); //如果设定了yes回调，需进行手工关闭
                }else {
                    layer.msg('请选择项目', {time: 5000, icon:6});
                }
            }
        })
    })
}
