package com.purchase.controller;

import com.purchase.annotation.SysLog;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbCustomers;
import com.purchase.pojo.admin.TbProjectManger;
import com.purchase.service.AdminService;
import com.purchase.service.CustomersService;
import com.purchase.service.ProjectMangerService;
import com.purchase.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

	@RequestMapping(value="/projectMangerList")
	@RequiresPermissions("sys:projectManger:list")
	public String list() {
		logger.info("进入项目管理列表页面");
		return "page/projectManger/projectMangerList";
	}
	
	/**
	 * 项目列表数据
	 * @return
	 */
	@RequestMapping("/getProjectMangerList")
	@RequiresPermissions("sys:projectManger:list")
	@ResponseBody
	public ResultUtil getProjectMangerList(Integer page,Integer limit) {
		logger.info("请求项目数据");
        ResultUtil result = new ResultUtil();
           try {
                result = projectMangerService.selProjectManger(page,limit);
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

}
