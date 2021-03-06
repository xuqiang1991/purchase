package com.purchase.controller;

import com.purchase.annotation.SysLog;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbCustomers;
import com.purchase.pojo.admin.TbProjectManger;
import com.purchase.pojo.biz.BizInstructOrder;
import com.purchase.service.AdminService;
import com.purchase.service.CustomersService;
import com.purchase.service.ProjectMangerService;
import com.purchase.service.biz.InstructOrderService;
import com.purchase.util.ResultUtil;
import com.purchase.vo.admin.ProjectMangerSearch;
import com.purchase.vo.Search.InstructOrderSearch;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("projectManger")
public class ProjectMangerController {
	
	private static Logger logger = LoggerFactory.getLogger(ProjectMangerController.class);
	
	@Autowired
	private ProjectMangerService projectMangerService;

	@Autowired
	private AdminService adminServiceImpl;

	@Autowired
    private CustomersService customersService;

	@Autowired
    private InstructOrderService instructOrderService;

	@RequestMapping(value="/projectMangerList")
	@RequiresPermissions("sys:projectManger:list")
	public String list(HttpServletRequest req) {
		logger.info("进入项目管理列表页面");
        List<TbAdmin> admins = adminServiceImpl.getAdmins(1);
        req.setAttribute("admins",admins);
        List<TbCustomers> customersList = customersService.getCustomersList();
        req.setAttribute("customersList",customersList);
		return "page/projectManger/projectMangerList";
	}
	
	/**
	 * 项目列表数据
	 * @return
	 */
	@RequestMapping("/getProjectMangerList")
	@RequiresPermissions("sys:projectManger:list")
	@ResponseBody
	public ResultUtil getProjectMangerList(Integer page, Integer limit, ProjectMangerSearch search) {
		logger.info("请求项目数据");
        ResultUtil result = new ResultUtil();
        try {
            result = projectMangerService.selProjectManger(page,limit,search);
        }catch (Exception e){
           e.printStackTrace();
        }
		return result;
	}

	@RequestMapping(value = "/configProjectManger")
	@RequiresPermissions("sys:projectManger:save")
	public String configProjectManger(HttpServletRequest req){
	    TbProjectManger projectManger = new TbProjectManger();
	    try {
            String id = req.getParameter("id");
            if(!StringUtils.isEmpty(id)){
                projectManger = projectMangerService.findById(id);
            }
            req.setAttribute("projectManger",projectManger);
            List<TbAdmin> admins = adminServiceImpl.getAdmins(1);
            req.setAttribute("admins",admins);
            List<TbCustomers> customersList = customersService.getCustomersList();
            req.setAttribute("customersList",customersList);
          /*  List<TbArea> areas = adminServiceImpl.selAreaByParentId(null);
            req.setAttribute("areas",areas);*/
        }catch (Exception e){
	        e.printStackTrace();
        }
		return "page/projectManger/configProjectManger";
	}


    @SysLog(value="添加项目")
    @RequestMapping("/saveProjectManger")
    @RequiresPermissions("sys:projectManger:save")
    @ResponseBody
    public ResultUtil saveProjectManger(TbProjectManger projectManger) {
        //防止浏览器提交
        boolean flag = projectMangerService.checkProjectMangerName(projectManger);
        if(flag){
            return new ResultUtil(500,"项目名已存在！");
        }
        projectMangerService.editProjectManger(projectManger);
        return ResultUtil.ok();
    }


    /**
     * 项目列表数据,不需要权限
     * @return
     */
    @RequestMapping("/findProjectMangerList")
    @ResponseBody
    public ResultUtil findProjectMangerList(Integer page, Integer limit, ProjectMangerSearch search) {
        logger.info("请求项目数据");
        ResultUtil result = new ResultUtil();
        try {
            List<Integer> statusList = new ArrayList<>();
            statusList.add(0);//未开工
            statusList.add(1);//在建中
            statusList.add(2);//已验收
            search.setStatusList(statusList);
            result = projectMangerService.selProjectManger(page,limit,search);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 删除项目
     * @return
     */
    @RequestMapping("/delProject/{id}")
    @ResponseBody
    public ResultUtil delProject(@PathVariable("id")String id) {
        logger.info("请求项目数据");
        ResultUtil result = new ResultUtil();
        try {
            result = projectMangerService.checkProject(id);
            if(result.getCode() == 0){
                projectMangerService.delProject(id);
                result.setCode(0);
                result.setMsg("此项目删除成功");
            }else{
                result.setCode(-1);
                result.setMsg("此项目已经被引用不能删除");
            }
        }catch (Exception e){
            result.setCode(500);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 检查项目是否被引用
     * @return
     */
   /* @RequestMapping("/checkProject/{id}")
    @ResponseBody
    public ResultUtil checkProject(@PathVariable("id")String id) {
        logger.info("检查项目是否被引用，id:{}",id);
        ResultUtil result = new ResultUtil();
        try {
            projectMangerService.delProject(id);
            result.setCode(0);
        }catch (Exception e){
            result.setCode(500);
            e.printStackTrace();
        }
        return result;
    }*/

    /**
     * 项目指令数据列表
     * @return
     */
    @SysLog(value="项目指令数据列表")
    @RequestMapping("/getInstructList")
    @ResponseBody
    public ResultUtil getInstructList(Integer page, Integer limit, InstructOrderSearch search) {
        logger.info("请求项目指令数据");
        ResultUtil result = new ResultUtil();
        try {
            result = instructOrderService.getList(page,limit,search);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping(value = "/configInstruct")
    @RequiresPermissions("sys:projectManger:save")
    public String configInstruct(HttpServletRequest req){
        BizInstructOrder instructOrder = new BizInstructOrder();
        try {
            String id = req.getParameter("id");
            String pmId = req.getParameter("pmId");
            if(!StringUtils.isEmpty(id)){
                instructOrder = instructOrderService.findById(id);
            }
            instructOrder.setPmId(pmId);
            req.setAttribute("instructOrder",instructOrder);
            List<TbAdmin> admins = adminServiceImpl.getAdmins(1);
            req.setAttribute("admins",admins);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "page/projectManger/configInstruct";
    }

    @SysLog(value="添加指令")
    @RequestMapping("/saveInstruct")
    @ResponseBody
    public ResultUtil saveInstruct(BizInstructOrder instructOrder) {
        //防止浏览器提交
        boolean flag = instructOrderService.checkInstructNo(instructOrder);
        if(flag){
            return new ResultUtil(500,"指令单已存在！");
        }
        return instructOrderService.save(instructOrder);
    }

    @SysLog(value="删除指令")
    @RequestMapping("/delInstruct")
    @ResponseBody
    public ResultUtil delInstruct(String id) {
        return instructOrderService.del(id);
    }

    @RequestMapping("/selectProjectManger")
    public String selectProjectManger() {
        return "page/projectManger/selectProjectManger";
    }

}
