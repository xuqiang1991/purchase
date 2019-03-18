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
        var idx = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
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
                params.auditResults = auditResults;
                params.roleId = roleId;
                params.userId = userId;
                params.auditOpinion = auditOpinion;
                if(type == 0){//提交
                    layer.msg('提交', {time: 5000, icon:6});
                    $.ajax({
                        type: "post",
                        url: url,
                        async:false,
                        data:params,
                        dataType:"json",
                        success:function(data){
                            if(data.code==0){
                                msg="提交成功！";
                                flag=true;
                                //$("#auf")[0].reset();
                            }else{
                                msg=data.msg;
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
