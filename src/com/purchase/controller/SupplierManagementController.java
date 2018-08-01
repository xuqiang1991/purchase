package com.purchase.controller;

import com.purchase.annotation.SysLog;
import com.purchase.pojo.admin.TbSupplier;
import com.purchase.service.SupplierService;
import com.purchase.util.ResultUtil;
import com.purchase.vo.admin.SupplierSearch;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 供应商管理
 * Created by xuqiang
 * 2018/8/1.
 */
@Controller
@RequestMapping("supplier")
public class SupplierManagementController {

    @Autowired
    private SupplierService supplierService;


    @RequestMapping("supplierList")
    @RequiresPermissions("user:supplier:list")
    public String supplierList(){
        return "page/user/supplierList";
    }


    @RequestMapping("getSupplierList")
    @RequiresPermissions("user:supplier:list")
    @ResponseBody
    public ResultUtil getSupplierList(Integer page, Integer limit, SupplierSearch search){
        return supplierService.selSuppliers(page,limit,search);
    }


    @RequestMapping("/toSaveSupplier/{id}")
    @RequiresPermissions("sys:supplier:save")
    public String toSaveSupplier(@PathVariable("id") Long id, Model model){
        if(id!=null){
            TbSupplier supplier=new TbSupplier();
            supplier.setId(id);
            supplier.setValid(true);
            model.addAttribute("supplier",supplier);
            model.addAttribute("flag","1");
            return "page/admin/supplierForm";
        }else{
            model.addAttribute("msg","不允许操作！");
            return "page/active";
        }
    }

    @SysLog("维护供应商信息")
    @RequestMapping("/supplierForm")
    @RequiresPermissions(value={"sys:supplier:save","sys:supplier:update"})
    @ResponseBody
    public ResultUtil supplierForm(TbSupplier supplier,String flag){
        if(StringUtils.isBlank(flag)){
            supplierService.updSupplier(supplier);
            return ResultUtil.ok("修改成功！");
        }else {
            supplier.setId(null);
            supplierService.insSupplier(supplier);
            return ResultUtil.ok("添加成功！");
        }
    }

    @RequestMapping("/toEditSupplier/{id}")
    @RequiresPermissions("sys:supplier:update")
    public String toEditSupplier(@PathVariable("id") Long id,Model model){
        if(id!=null){
            TbSupplier supplier=supplierService.selSupplierById(id);
            model.addAttribute("supplier",supplier);
            return "page/admin/supplierForm";
        }else{
            model.addAttribute("msg","不允许操作！");
            return "page/active";
        }
    }

    /**
     * 通过id删除供应商
     * @param id
     * @return
     */
    @SysLog(value="删除指定地区")
    @RequestMapping("/delSupplierById/{id}")
    @RequiresPermissions("sys:supplier:delete")
    @ResponseBody
    public ResultUtil delSupplierById(@PathVariable("id")Long id) {
        try {
            supplierService.delSupplierById(id);
            return ResultUtil.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("系统错误！");
        }
    }



}
