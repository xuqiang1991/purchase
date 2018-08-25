/*
    采购订单
 */
purchaseOrder = {
    //状态转换
    statusConversion : function (helper) {
        helper.registerHelper("statusConversion",function(obj){
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
                case 5:
                    statusStr = '已合同编号'
                    break;
            }
            return statusStr;
        });
    }
}
