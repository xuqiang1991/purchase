package com.purchase.vo.order;

import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbProjectManger;
import com.purchase.pojo.admin.TbSupplier;
import com.purchase.pojo.order.BizPaymentOrder;

/**
 * Created by xuqiang
 * 2018/9/07.
 */
public class BizPaymentOrderVo extends BizPaymentOrder {

    private TbSupplier supplier;
    private TbAdmin admin;
    private TbAdmin applyAdmin;
    private TbAdmin managerAdmin;
    private TbProjectManger projectManger;

    private Long reviewUserId;

    public Long getReviewUserId() {
        return reviewUserId;
    }

    public void setReviewUserId(Long reviewUserId) {
        this.reviewUserId = reviewUserId;
    }

    public TbSupplier getSupplier() {
        return supplier;
    }

    public void setSupplier(TbSupplier supplier) {
        this.supplier = supplier;
    }

    public TbAdmin getAdmin() {
        return admin;
    }

    public void setAdmin(TbAdmin admin) {
        this.admin = admin;
    }

    public TbAdmin getApplyAdmin() {
        return applyAdmin;
    }

    public void setApplyAdmin(TbAdmin applyAdmin) {
        this.applyAdmin = applyAdmin;
    }

    public TbAdmin getManagerAdmin() {
        return managerAdmin;
    }

    public void setManagerAdmin(TbAdmin managerAdmin) {
        this.managerAdmin = managerAdmin;
    }

    public TbProjectManger getProjectManger() {
        return projectManger;
    }

    public void setProjectManger(TbProjectManger projectManger) {
        this.projectManger = projectManger;
    }


    public String getApplyTypeName() {
        String str = null;
        Integer applyType = getApplyType();
        if(applyType != null){
            if(applyType == 0){
                str = "合同内请款";
            }else if(applyType == 1){
                str = "合同外请款";
            }
        }
        return str;
    }

    public String getApplyNatureName() {
        String str = null;
        Integer applyNature = getApplyNature();
        if(applyNature != null){
            if(applyNature == 0){
                str = "材料采购";
            }else if(applyNature == 1){
                str = "工程分包";
            }
        }
        return str;
    }

    public String getPaymentTypeName() {
        String str = null;
        Integer paymentType = getPaymentType();
        if(paymentType != null){
            if(paymentType == 0){
                str = "汇款";
            }else if(paymentType == 1){
                str = "支票";
            }else if(paymentType == 2){
                str = "现金";
            }else if(paymentType == 3){
                str = "商票";
            }else if(paymentType == 4){
                str = "保理";
            }
        }
        return str;
    }

    public String getQualityGradeName() {
        String str = null;
        Integer qualityGrade = getQualityGrade();
        if(qualityGrade != null){
            if(qualityGrade == 0){
                str = "优";
            }else if(qualityGrade == 1){
                str = "良";
            }else if(qualityGrade == 2){
                str = "中";
            }else if(qualityGrade == 3){
                str = "差";
            }
        }
        return str;
    }


    public String getStatusName() {
        String str = null;
        Integer status = getStatus();
        if(status != null){
            if(status == 0){
                str = "未审批";
            }else if(status == 1){
                str = "已审批";
            }else if(status == 2){
                str = "已付款";
            }
        }else {
            str = "未提交";
        }
        return str;
    }

    public String getFinancePaymentName() {
        String str = null;
        Integer financePayment = getFinancePayment();
        if(financePayment != null){
            if(financePayment == 0){
                str = "已付";
            }else if(financePayment == 1){
                str = "不同意";
            }
        }
        return str;
    }

}
