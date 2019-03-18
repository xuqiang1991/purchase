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
        var title = type == 0 ? "提交订单" : "审核订单";
        var msg,flag=false;
        layer.open({
            type: 2,
            title:title,
            btn: btnArray,
            area: ['500px', '400px'],
            content:ctx+"/biz/order/toSubmit?id=" + id + "&type=" + type,
            yes: function(index, layero){
                var body = layer.getChildFrame('body', index);
                var auditResults = body.find("#auditResults").val();
                var roleId = body.find("#roleId >option:selected").val();
                var userId = body.find("#userId >option:selected").val();
                var auditOpinion = $(layero).find("iframe").contents().find("#auditOpinion").val();
                console.log("auditResults:" + auditResults + "   roleId:" + roleId + "    userId:"+ userId + "   auditOpinion:" + auditOpinion);
                var params = {};
                params.id = id;
                params.auditResults = auditResults;
                params.roleId = roleId;
                params.userId = userId;
                params.auditOpinion = auditOpinion;
                if(type == 0){//提交
                    $.ajax({ type: "post", url: url, async:false, data:params, dataType:"json",
                        success:function(data){
                            if(data.code==0){
                                msg="提交成功！";
                                flag=true;
                            }else{
                                msg=data.msg;
                            }
                            layer.msg(msg,{icon: 1});
                        }
                    });
                }else{//审核
                    layer.msg('审核', {time: 5000, icon:6});
                }
                layer.close(index); //如果设定了yes回调，需进行手工关闭
            }
        })
    })
}

function submint(url,params){
    $.ajax({
        type: "post",
        url: url,
        async:false,
        data:params,
        dataType:"json",
        success:function(data){
            if(data.code==0){
                msg="保存成功！";
                flag=true;
                //$("#auf")[0].reset();
            }else{
                msg=d.msg;
            }
        }
    });
}
