/**
 * 提交订单选人
 * @param event
 * @param id 订单ID
 * @param type 操作类型 0：提交 1:审核
 * @param url 提交URL
 */
function toSubmit(id,type,url){
    layui.use(['layer','jquery'],function(){
        var layer = parent.layer === undefined ? layui.layer : parent.layer,$ = layui.jquery;
        var btnArray = type == 0 ? ['提交','取消'] : ['审核','取消'];
        var title = type == 0 ? "提交订单" : "审核订单"
        layer.open({
            type: 2,
            title:title,
            btn: btnArray,
            area: ['500px', '400px'],
            content:ctx+"/biz/order/toSubmit?id=" + id + "&type=" + type,
            yes: function(index, layero){
                var iframes = $(layero).find("iframe")[0].contentWindow;
                alert($(iframes).html());
                var select = $(layero).find("iframe").contents().find(".layui-form");//find("input[name='id']:checked");

                /*alert($(layero).find("iframe")[0].contentWindow.document.getElementById("auditResults"));
                var auditResults = $(layero).find("iframe").contents().find("#auditResults").val();
                var roleId = $(layero).find("iframe").contents().find("#roleId >option:selected").val();
                var userId = $(layero).find("iframe").contents().find("#userId >option:selected").val();
                var auditOpinion = $(layero).find("iframe").contents().find("#auditOpinion").val();
                console.log("auditResults:" + auditResults + "   roleId:" + roleId + "    userId:"+ userId + "   auditOpinion:" + auditOpinion);
                if(type == 0){//提交
                    layer.msg('提交', {time: 5000, icon:6});
                }else{//审核
                    layer.msg('审核', {time: 5000, icon:6});
                }
                layer.close(index); //如果设定了yes回调，需进行手工关闭*/
            }
        })
    })
}
