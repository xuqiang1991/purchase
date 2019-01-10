/*
    工具类
 */
utilsOrder = {
    //状态转换
    approvalConversion : function (helper) {
        helper.registerHelper("isApproval_Conversion",function(){
            var str,approval = this.isApproval, isSaveSubmit = this.isSaveSubmit;
            switch (approval){
                case 0:
                    if(isSaveSubmit == 0){
                        str = '未提交';
                    }else if(isSaveSubmit == 1){
                        str = '未审核';
                    }else{
                        str = '驳回';
                    }
                    break;
                case 1:
                    if(isSaveSubmit == 0){
                        str = '未提交';
                    }else if(isSaveSubmit == 1){
                        str = '已审核';
                    }else{
                        str = '审核完结';
                    }
                    break;
                default:
                    str = '未提交';
            }
            return str;
        });
    },
    //获取最后状态的人
    departUser:function (helper) {
        helper.registerHelper("prorammeAcceptanceOrder_departUser",function(){
            var str,obj = this.status;
            switch (obj){
                case 0:
                    str = '创建人：' +  this.admin.fullname
                    break;
                case 1:
                    str = '提交人：' +  this.admin.fullname
                    break;
                case 2:
                    str = '审核人：' +  this.projectAdmin.fullname
                    break;
                case 3:
                    str = '审核人：' +  this.costAdmin.fullname
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
        helper.registerHelper("prorammeAcceptanceOrder_departDate",function(){
            var str,obj = this.status;
            switch (obj){
                case 0:
                    str = '创建日期：' +  this.createTime
                    break;
                case 1:
                    str = '提交日期：' +  this.updateDate
                    break;
                case 2:
                    str = '审核日期：' +  this.projectDepartDate
                    break;
                case 3:
                    str = '审核日期：' +  this.costDepartDate
                    break;
                case 4:
                    str = '审核日期：' +  this.managerDepartDate
                    break;
            }
            return str;
        });
    },
    //单据类型
    typeConversion : function (helper) {
        helper.registerHelper("purchaseOrder_typeConversion",function(data){
            var statusStr;
            var obj = parseInt(data);
            switch (obj){
                case 0:
                    statusStr = '绿化苗木'
                    break;
                case 1:
                    statusStr = '园建水电'
                    break;
                case 2:
                    statusStr = '机械租赁'
                    break;
                case 3:
                    statusStr = '工程分包'
                    break;
            }
            return statusStr;
        });
    },
}


Handlebars.registerHelper("compare", function (v1, v2, options) {
    if (v1 == v2) {
        //满足添加继续执行
        return options.fn(this);
    } /*else {
        //不满足条件执行{{else}}部分
        return options.inverse(this);
    }*/
});