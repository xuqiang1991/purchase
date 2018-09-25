/*
    采购订单
 */
ucamOrder = {
    //状态转换
    statusConversion : function (helper) {
        helper.registerHelper("ucamOrder_statusConversion",function(obj){
            var statusStr;
            switch (obj){
                case 0:
                    statusStr = '未提交'
                    break;
                case 1:
                    statusStr = '已提交'
                    break;
                case 2:
                    statusStr = '成本部已审核'
                    break;
                case 3:
                    statusStr = '工程部已审核'
                    break;
                case 4:
                    statusStr = '总经理已审核'
                    break;
            }
            return statusStr;
        });
    },
    //获取最后状态的人
    departUser:function (helper) {
        helper.registerHelper("ucamOrder_departUser",function(){
            var str,obj = this.status;
            switch (obj){
                case 0:
                    str = '创建人：' +  this.admin.fullname
                    break;
                case 1:
                    str = '提交人：' +  this.admin.fullname
                    break;
                case 2:
                    str = '审核人：' +  this.costAdmin.fullname
                    break;
                case 3:
                    str = '审核人：' +  this.projectAdmin.fullname
                    break;
                case 4:
                    str = '审核人：' +  this.managerAdmin.fullname
                    break;
            }
            return str;
        });
    },
    //获取最后状态的时间
    departDate:function (helper) {
        helper.registerHelper("ucamOrder_departDate",function(){
            var str,obj = this.status;
            switch (obj){
                case 0:
                    str = '创建日期：' +  this.createTime
                    break;
                case 1:
                    str = '提交日期：' +  this.updateDate
                    break;
                case 2:
                    str = '审核日期：' +  this.costDepartDate
                    break;
                case 3:
                    str = '审核日期：' +  this.projectDepartDate
                    break;
                case 4:
                    str = '审核日期：' +  this.managerDepartDate
                    break;
            }
            return str;
        });
    },
    //获取最后状态的时间
    instructOrder:function (helper) {
        helper.registerHelper("ucamOrder_instructOrder",function(){
            var str,obj = this.instructOrderFlag;
           /* if(obj == "0"){
                str = '<label>开单人:' + this.admin.fullname + '</label>';
            }else{
                str = '<label style="color: red;">开单人:' + this.admin.fullname + '</label>';
            }*/
            if(obj == "0"){
                str = '指令单未到';
            }
            return str;
        });
    }
}
