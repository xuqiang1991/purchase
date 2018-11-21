var $;
var $form;
var form;
//var areaData = address;
layui.config({
	base : "js/"
}).use(['form','layer','jquery','laydate'],function(){
	var layer = parent.layer === undefined ? layui.layer : parent.layer,
		laydate = layui.laydate;
		$ = layui.jquery;
		form = layui.form;
		//$form=$('form');
		//初始化省
		//loadProvince();
		
		laydate.render({
			elem: '#entryDate' //指定元素
			,max: 'new Date()'
		});

		laydate.render({
			elem: '#birthday' //指定元素
			,max: 'new Date()'
		});

		
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
		
		$("#eMail").blur(function(){
			$.ajax({
				type: "post",
				url: ctx+"/sys/checkAdminByEmail?eMail="+$("#eMail").val()+"&username="+$("#username").val(),
				success:function(data){
					if(data.code!=0){
						top.layer.msg(data.msg);
						$("#eMail").val("");
						$("#eMail").focus();
					}
				}
			});
		});
        form.on('radio(userType)', function(data){
            console.log(data.elem); //得到radio原始DOM对象
            console.log(data.value); //被点击的radio的value值
            if(data.value == 0){
                $("#userSuppliersDiv").hide();
                $("#userDeptsDiv").show();
            }else{
                $("#userSuppliersDiv").show();
                $("#userDeptsDiv").hide();
            }
        });
        console.log(userType);
        if(userType == 0){
            $("#userSuppliersDiv").hide();
            $("#userDeptsDiv").show();
        }else{
            $("#userSuppliersDiv").show();
            $("#userDeptsDiv").hide();
        }
 	form.on("submit(updAdmin)",function(data){
        var roleIds = $('select[name="roleId"]').val();
        var userType = $('input[name="userType"]:checked').val();
        console.log(userType);
        if(userType == 0){
            var deptId  = $('select[name="deptId"]').val();
            if(deptId == null || deptId == ''){
                layer.msg('请选择用户部门', {icon: 5});
                $('select[name="deptId"]').focus();
                return false;
            }
        }else{
            var supplierId  = $('select[name="supplierId"]').val();
            if(supplierId == null || supplierId == ''){
                layer.msg('请选择用户供应商', {icon: 5});
                $('select[name="supplierId"]').focus();
                return false;
            }
        }
        if(roleIds != null && roleIds != '' && roleIds.length > 0){
            var a = {};
            for (var i = 0; i < roleIds.length; i++){
                a[i] = roleIds[i];
            }
            data.field.roleId = a;
        }else{
            layer.msg('请选择用户角色', {icon: 5});
            $('select[name="roleId"]').focus();
            return false;
        }
 		//弹出loading
 		var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
 		var msg;
 		$.ajax({
    		type: "post",
            url: ctx+"/sys/updAdmin",
            data:data.field,
			dataType:"json",
			success:function(d){
				if(d.code==0){
		        	msg="添加成功！";
				}else{
		        	msg=d.msg;
				}
			}
        });
 		setTimeout(function(){
 			top.layer.close(index);
 			top.layer.msg(msg);
 			layer.closeAll("iframe");
 			//刷新父页面
	 		parent.location.reload();
        },2000);
 		return false;
 	})
	
})