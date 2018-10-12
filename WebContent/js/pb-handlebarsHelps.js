/*
    采购订单
 */
prorammeAcceptanceOrder = {
    //状态转换
    statusConversion : function (helper) {
        helper.registerHelper("prorammeAcceptanceOrder_statusConversion",function(obj){
            var statusStr;
            switch (obj){
                case 0:
                    statusStr = '未提交'
                    break;
                case 1:
                    statusStr = '已提交'
                    break;
                case 2:
                    statusStr = '工程部已审核'
                    break;
                case 3:
                    statusStr = '成本部已审核'
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
    }
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