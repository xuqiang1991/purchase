package com.purchase.vo.biz;

import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbProjectManger;
import com.purchase.pojo.biz.BizInstructOrder;

/**
 * @Title: InstructOrderService
 * @ProjectName purchase
 * @Description: 指令单查询
 * @author zhoujb
 * @date 2019-03-0411:37
 */
public class InstructOrderVo extends BizInstructOrder {


    private TbProjectManger projectManger;

    private TbAdmin createAdmin;

    private TbAdmin editAdmin;

    public TbProjectManger getProjectManger() {
        return projectManger;
    }

    public void setProjectManger(TbProjectManger projectManger) {
        this.projectManger = projectManger;
    }

    public TbAdmin getCreateAdmin() {
        return createAdmin;
    }

    public void setCreateAdmin(TbAdmin createAdmin) {
        this.createAdmin = createAdmin;
    }

    public TbAdmin getEditAdmin() {
        return editAdmin;
    }

    public void setEditAdmin(TbAdmin editAdmin) {
        this.editAdmin = editAdmin;
    }
}
