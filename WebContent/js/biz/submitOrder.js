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
                msg = type == 0?"提交成功！":"审核成功！";
                var auditResults = body.find("#auditResults");
                var isReq = true;//检查参数是否完善的提交标识
                if(type == 0 || (type == 1 && auditResults.is(':checked'))){//提交
                    var select = body.find("#submitOrReviewForm").find("select");
                    if(select.length > 0){
                        select.each(function(){
                            var event = $(this).find("option:selected");
                            if(!event.val()){
                                var text = $(this).parent().parent().find("label").text();
                                isReq = false;
                                layer.msg('请选择' + text,{icon: 5});
                                return false;
                            }
                        });
                    }
                }else{

                }
                if(isReq){
                    var roleId = body.find("#roleId >option:selected");
                    var userId = body.find("#userId >option:selected");
                    var auditOpinion = $(layero).find("iframe").contents().find("#auditOpinion");
                    console.log("auditResults:" + auditResults + "   roleId:" + roleId + "    userId:"+ userId + "   auditOpinion:" + auditOpinion);
                    var params = {};
                    params.id = id;
                    params.auditResults = auditResults.is(':checked');
                    params.roleId = roleId.val();
                    params.userId = userId.val();
                    params.auditOpinion = auditOpinion.val();

                    $.ajax({ type: "post", url: url, async:false, data:params, dataType:"json",
                        success:function(data){
                            if(data.code==0){
                                flag=true;
                            }else{
                                msg=data.msg;
                            }
                            layer.msg(msg,{icon: 1});
                        }
                    });
                    layer.close(index); //如果设定了yes回调，需进行手工关闭
                    parent.location.reload();
                }


            }
        })
    })
}
