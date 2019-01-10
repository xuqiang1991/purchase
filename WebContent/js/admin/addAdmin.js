var $;
var $form;
var form;
layui.config({
	base : "js/"
}).use(['form','layer','jquery','laydate'],function(){
	var layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,laydate = layui.laydate;
		$ = layui.jquery;
		form = layui.form;

		laydate.render({
			elem: '#birthday,#entryDate' //指定元素
			,max: 'new Date()'
		});
		
		//自定义验证规则
		form.verify({ 
			pass: [/(.+){6,20}$/, '密码必须6到20位']
			,repass: function(value){

				if(value == ''){
                    return '请输入确认密码！';
				}

				var repassvalue = $('#password').val();
				if(value != repassvalue){
					return '两次输入的密码不一致!';
				}
			}
            ,usernameCheck: function(){
                var usernameValue = $('#username').val();
                var regUsername = /^[a-zA-Z0-9_-]{4,16}$/;
                if (!regUsername.test(usernameValue)) {
                    return '登录名格式错误，请输入4到16位（字母，数字，下划线，减号）!';
                }
            }
			,enphone: function () {
                var phoneValue = $('#phone').val();
                var regPhone = /^1(2|3|4|5|6|7|8|9)\d{9}$/;
                if (!regPhone.test(phoneValue)) {
                    return '手机号码错误!';
                }
            }
            ,deptId: function (value) {
                var userType = $('input[name="userType"]:checked').val();
                if(userType == 0){
                    if (value == '') {
                        return '请选择部门!';
                    }
				}
            }
            ,supplierId: function (value) {
                var userType = $('input[name="userType"]:checked').val();
                if(userType != 0) {
                    if (value == '') {
                        return '请选择供应商!';
                    }
                }
            }
		});
		
		$("#username").blur(function(){
			$.ajax({
	            type: "get",
	            url: ctx+"/sys/checkAdminName/"+$("#username").val(),
	            success:function(data){
	            	if(data.code!=0){
	            		top.layer.msg(data.msg);
	            		$("#username").val("");
	            		$("#username").focus();
	            	}
	            }
	        });
		});
		
		$("#eMail").blur(function(){
			$.ajax({
				type: "post",
				url: ctx+"/sys/checkAdminByEmail/"+$("#eMail").val(),
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
    $("#userSuppliersDiv").hide();

    form.on("submit(addAdmin)",function(data){

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
            url: ctx+"/sys/insAdmin",
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

   /* form.on("submit(closeAdmin)",function(data){
        layer.close(layer.index);
    });*/
	
})