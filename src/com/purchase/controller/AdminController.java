package com.purchase.controller;

import com.google.code.kaptcha.Producer;
import com.purchase.annotation.SysLog;
import com.purchase.pojo.admin.*;
import com.purchase.service.AdminService;
import com.purchase.util.RRException;
import com.purchase.util.ResultUtil;
import com.purchase.util.ShiroUtils;
import com.purchase.util.WebUtils;
import com.purchase.vo.admin.Menu;
import com.purchase.vo.admin.XtreeData;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("sys")
public class AdminController {

	@Autowired
	private AdminService adminServiceImpl;
	@Autowired  
    private Producer captchaProducer = null;
	
	@RequestMapping("/main")
	public String main() {
		return "page/main";
	}
	@RequestMapping("/index")
	public String index(HttpServletRequest req) {
		TbAdmin admin = (TbAdmin)SecurityUtils.getSubject().getPrincipal();
		req.setAttribute("admin", admin);
		String requestHeader = req.getHeader("user-agent");
		boolean isMobile = WebUtils.isMobileDevice(requestHeader);

		if(isMobile){
			if(requestHeader.indexOf("MicroMessenger")>-1){
				if(admin == null){
					return "redirect:/sys/wx/auth";
				}else {
					return "redirect:/mobile/login";
				}
			}else {
				return "mobile/index";
			}
		}else {
			return "redirect:/index.jsp";
		}
	}
	@RequestMapping("/refuse")
	public String refuse() {
		return "refuse";
	}

	/**
	 * 管理员登陆
	 * 
	 * @param req
	 * @param username
	 * @param password
	 * @param vcode
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public ResultUtil login(HttpServletRequest req, String username, String password, String vcode) {
		if(StringUtils.isEmpty(vcode)||StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
			throw new RRException("参数不能为空");
		}
		String kaptcha = ShiroUtils.getKaptcha("kaptcha").toLowerCase();
		if(!vcode.toLowerCase().equals(kaptcha)){
			return ResultUtil.error("验证码不正确");
		}
		
		try{
			Subject subject = ShiroUtils.getSubject();
			//md5加密
			//password=DigestUtils.md5DigestAsHex(password.getBytes());
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			subject.login(token);
		}catch (UnknownAccountException e) {
			return ResultUtil.error(e.getMessage());
		}catch (IncorrectCredentialsException e) {
			return ResultUtil.error(e.getMessage());
		}catch (LockedAccountException e) {
			return ResultUtil.error(e.getMessage());
		}catch (AuthenticationException e) {
			return ResultUtil.error("账户验证失败");
		}
		return ResultUtil.ok();
		/*String vCode = req.getSession().getAttribute("vcode").toString().toLowerCase();
		if (vcode.toLowerCase().equals(vCode)) {
			TbAdmin admin = adminServiceImpl.login(username, password);
			if (admin != null) {
				// 登陆成功
				// 将密码置空
				admin.setPassword("");
				// 设置用户信息到Session作用域
				req.getSession().setAttribute("admin", admin);
				return new ResultUtil(0);
			}
			return new ResultUtil(502, "用户名或密码错误！");
		}
		return new ResultUtil(501, "验证码错误！");*/
	}

	/**
	 * 登出
	 * @return
	 */
	@RequestMapping(value="/loginOut")
	public String loginOut(){
		ShiroUtils.logout();
		return "redirect:/login.jsp";
	}
	
	/**
	 * 验证码
	 * 
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping("/vcode")
	public void vcode(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//		VerifyCode vc = new VerifyCode();
//		BufferedImage image = vc.getImage();// 获取一次性验证码图片
		String text = captchaProducer.createText();
		BufferedImage image = captchaProducer.createImage(text);
		// 该方法必须在getImage()方法之后来调用
		// System.out.println("验证码图片上的文本:"+vc.getText());//获取图片上的文本
		// 把文本保存到session中，为验证做准备
		//req.getSession().setAttribute("vcode", vc.getText());
		//保存到shiro session
        ShiroUtils.setSessionAttribute("kaptcha", text);
		//VerifyCode.output(image, resp.getOutputStream());// 把图片写到指定流中
		ImageIO.write(image, "JPEG", resp.getOutputStream());
	}

	/**
	 * 获取用户菜单
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/getMenus", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	@ResponseBody
	public List<Menu> getMenus(HttpServletRequest req, HttpServletResponse resp) {
	//TbAdmin admin = (TbAdmin) req.getSession().getAttribute("admin");
		TbAdmin admin = (TbAdmin)SecurityUtils.getSubject().getPrincipal();
		List<Menu> menus = null;
		if (admin != null) {
			// 得到用户菜单
			menus = adminServiceImpl.selMenus(admin);

			//过滤mobile类型的菜单
			if(!CollectionUtils.isEmpty(menus)){
				int size = menus.size() - 1;
				for (int i = size; i >= 0; i--){
					Menu menu = menus.get(i);
					String href = menu.getHref();
					//过滤mobile开头的菜单
					if(StringUtils.isNotBlank(href) && "mobile/".startsWith(menu.getHref())){
						menus.remove(i);
					}
				}
			}
		}
		return menus;
	}
	
	@RequestMapping("/adminList")
	public String adminList() {
		return "page/admin/adminList";
	}
	
	@RequestMapping("/menuList")
	public String menuList() {
		return "page/admin/menuList";
	}
	
	@RequestMapping("/personalData")
	public String personalData(HttpServletRequest req) {
//		TbAdmin admin=(TbAdmin) req.getSession().getAttribute("admin");
		TbAdmin admin = (TbAdmin)SecurityUtils.getSubject().getPrincipal();
		TbAdmin ad = adminServiceImpl.selAdminById(admin.getId());
		List<TbRoles> roles = adminServiceImpl.selRoles();
		req.setAttribute("ad",ad);
		req.setAttribute("roles", roles);
		return "page/admin/personalData";
	}
	
	/**
	 * 管理员列表
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/getAdminList")
	@RequiresPermissions("sys:admin:list")
	@ResponseBody
	public ResultUtil getAdminList(Integer page,Integer limit) {
		ResultUtil admins = adminServiceImpl.selAdmins(page, limit);
		return admins;
	}
	
	@RequestMapping("/roleList")
	@RequiresPermissions("sys:role:list")
	public String roleList() {
		return "page/admin/roleList";
	}

	/**
	 * 管理员列表
	 * @return
	 */
	@RequestMapping("/getRoleList")
	@RequiresPermissions("sys:role:list")
	@ResponseBody
	public ResultUtil getRoleList(Integer page,Integer limit) {
		return adminServiceImpl.selRoles(page, limit);
	}

	/**
	 * 跳转编辑角色页面
	 * @param roleId
	 * @param roleName
	 * @param roleRemark
	 * @param req
	 * @return
	 */
	@RequestMapping("/editRole")
	@RequiresPermissions("sys:role:update")
	public String editRole(String roleId,String roleName,String roleRemark,HttpServletRequest req) {
		TbRoles role=new TbRoles();
		role.setRoleId(Long.parseLong(roleId));
		role.setRoleName(roleName);
		role.setRoleRemark(roleRemark);
		req.setAttribute("role", role);
		return "page/admin/editRole";
	}
	
	/**
	 * 得到指定角色权限树
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/xtreedata")
	@ResponseBody
	public List<XtreeData> xtreeData(@RequestParam(value="roleId", defaultValue="-1") Long roleId) {
		TbAdmin admin=new TbAdmin();
		admin.setRoleId(roleId);
		return adminServiceImpl.selXtreeData1(admin);
	}
	
	/**
	 * 更新角色信息
	 * @param role 角色信息
	 * @param m 权限字符串
	 */
	@SysLog(value="更新角色信息")
	@RequestMapping("/updRole")
	@RequiresPermissions("sys:role:update")
	@ResponseBody
	public void updRole(TbRoles role,String m) {
		//角色信息保存
		adminServiceImpl.updRole(role, m);
	}
	
	/**
	 * 添加新角色
	 * @param role
	 * @param m
	 */
	@SysLog(value="添加角色信息")
	@RequestMapping("/insRole")
	@RequiresPermissions("sys:role:save")
	@ResponseBody
	public ResultUtil insRole(TbRoles role,String m) {
		TbRoles r = adminServiceImpl.selRoleByRoleName(role.getRoleName());
		if(r!=null){
			return new ResultUtil(500, "角色名已存在,请重试！");
		}
		//角色信息保存
		adminServiceImpl.insRole(role, m);
		return ResultUtil.ok();
	}
	
	/**
	 * 删除指定角色信息
	 * @param roleId
	 * @return
	 */
	@SysLog(value="删除指定角色信息")
	@RequestMapping("/delRole/{roleId}")
	@RequiresPermissions("sys:role:delete")
	@ResponseBody
	public ResultUtil delRole(@PathVariable("roleId")Long roleId) {
		ResultUtil resultUtil=new ResultUtil();
		try {
			adminServiceImpl.delRole(roleId);
			resultUtil.setCode(0);
		} catch (Exception e) {
			resultUtil.setCode(500);
			e.printStackTrace();
		}
		return resultUtil;
	}
	
	/**
	 * 批量删除指定角色信息
	 * @param rolesId
	 * @return
	 */
	@SysLog(value="批量删除指定角色信息")
	@RequestMapping("/delRoles/{rolesId}")
	@RequiresPermissions("sys:role:delete")
	@ResponseBody
	public ResultUtil delRoles(@PathVariable("rolesId")String rolesId) {
		ResultUtil resultUtil=new ResultUtil();
		try {
			adminServiceImpl.delRoles(rolesId);
			resultUtil.setCode(0);
		} catch (Exception e) {
			resultUtil.setCode(500);
			e.printStackTrace();
		}
		return resultUtil;
	}
	
	@RequestMapping("/addRole")
	@RequiresPermissions("sys:role:save")
	public String addRole() {
		return "page/admin/addRole";
	}
	
	/**
	 * 角色名唯一性检查
	 * @param roleName
	 * @return
	 */
	@RequestMapping("/checkRoleName/{roleName}")
	@ResponseBody
	public ResultUtil checkRoleName(Long roleId, @PathVariable("roleName")String roleName) {
		TbRoles role = adminServiceImpl.selRoleByRoleName(roleName);
		if(role==null){
			return new ResultUtil(0);
		}else if(role.getRoleId()==roleId){
			return new ResultUtil(0);
		}else{
			return new ResultUtil(500,"角色名已存在！");
		}
	}
	
	/**
	 * 通过id删除管理员
	 * @param id
	 * @return
	 */
	@SysLog(value="删除指定管理员")
	@RequestMapping("/delAdminById/{id}")
	@RequiresPermissions("sys:admin:delete")
	@ResponseBody
	public ResultUtil delAdminById(@PathVariable("id")Long id) {
		if(id==1){
			return ResultUtil.error();
		}
		try {
			adminServiceImpl.delAdminById(id);
			return ResultUtil.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error();
		}
	}
	
	/**
	 * 批量删除指定管理员
	 * @param adminStr
	 * @return
	 */
	@SysLog(value="批量删除指定管理员")
	@RequestMapping("/delAdmins/{adminStr}")
	@RequiresPermissions("sys:admin:delete")
	@ResponseBody
	public ResultUtil delAdmins(HttpServletRequest req,@PathVariable("adminStr")String adminStr) {
		String[] strs = adminStr.split(",");
		for (String str : strs) {
			TbAdmin admin = (TbAdmin)SecurityUtils.getSubject().getPrincipal();
			if((admin.getId()==Long.parseLong(str))){
				return ResultUtil.error();
			}
			if("1".equals(str)){
				return ResultUtil.error();
			}
		}
		try {
			adminServiceImpl.delAdmins(adminStr);
			return ResultUtil.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error();
		}
	}
	
	@RequestMapping("/addAdmin")
	@RequiresPermissions("sys:admin:save")
	public String addAdmin(HttpServletRequest req){
		List<TbRoles> roles = adminServiceImpl.selRoles();
		List<TbDepartment> depts = adminServiceImpl.selDepartmentByParentId(null);
		req.setAttribute("roles", roles);
		req.setAttribute("depts", depts);
		return "page/admin/addAdmin";
	}
	
	/**
	 * 管理员用户名唯一性检查
	 * @param username
	 * @return
	 */
	@RequestMapping("/checkAdminName/{username}")
	@ResponseBody
	public ResultUtil checkAdminName(@PathVariable("username")String username) {
		TbAdmin admin = adminServiceImpl.selAdminByUserName(username);
		if(admin!=null){
			return new ResultUtil(500,"管理员已存在！");
		}
		return new ResultUtil(0);
	}
	
	/**
	 * 菜单名唯一性校验
	 * @param title
	 * @return
	 */
	@RequestMapping("/checkMenuTitle/{title}")
	@ResponseBody
	public ResultUtil checkMenuTitle(@PathVariable("title")String title, @RequestParam(value="menuId", defaultValue="-1") Long menuId) {
		TbMenus menu = adminServiceImpl.selMenuByTitle(title, menuId);
		if(menu!=null){
			return new ResultUtil(500,"菜单已存在！");
		}
		return new ResultUtil(0);
	}
	
	/**
	 * 增加管理員
	 * 日期类型会导致数据填充失败，请求没反应
	 * @param admin
	 * @return
	 */
	@SysLog(value="添加管理员")
	@RequestMapping("/insAdmin")
	@RequiresPermissions("sys:admin:save")
	@ResponseBody
	public ResultUtil insAdmin(TbAdmin admin) {
		//防止浏览器提交
		TbAdmin a = adminServiceImpl.selAdminByUserName(admin.getUsername());
		if(a!=null){
			return new ResultUtil(500, "用户名已存在,请重试！");
		}
		adminServiceImpl.insAdmin(admin);
		return ResultUtil.ok();
	}
	
	@RequestMapping("/editAdmin/{id}")
	@RequiresPermissions("sys:admin:update")
	public String editAdmin(HttpServletRequest req,@PathVariable("id")Long id) {
		TbAdmin ad = adminServiceImpl.selAdminById(id);
		List<TbRoles> roles = adminServiceImpl.selRoles();
		List<TbDepartment> depts = adminServiceImpl.selDepartmentByParentId(null);
		req.setAttribute("ad",ad);
		req.setAttribute("roles", roles);
		req.setAttribute("depts", depts);
		return "page/admin/editAdmin";
	}
	
	@RequestMapping("/checkAdminByEmail")
	@ResponseBody
	public ResultUtil checkAdminByEmail(String eMail,String username) {
		TbAdmin admin=adminServiceImpl.selAdminByEmail(eMail,username);
		if(admin!=null){
			return new ResultUtil(500,"邮箱已被占用！");
		}
		return new ResultUtil(0);
	}
	
	/**
	 * 更新管理员信息
	 * @param admin
	 */
	@SysLog(value="更新管理员信息")
	@RequestMapping("/updAdmin")
	@RequiresPermissions("sys:admin:update")
	@ResponseBody
	public ResultUtil updAdmin(TbAdmin admin) {
		if(admin!=null&&admin.getId()==1){
			return ResultUtil.error("不允许修改!");
		}
		try {
			adminServiceImpl.updAdmin(admin);
			return ResultUtil.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error();
		}
	}
	
	@RequestMapping("/changePwd")
	public String changePwd() {
		return "page/admin/changePwd";
	}
	
	/**
	 * 修改密码
	 * @param req
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	@SysLog(value="修改密码")
	@RequestMapping("/updPwd")
	@ResponseBody
	public ResultUtil updPwd(HttpServletRequest req,String oldPwd,String newPwd) {
		TbAdmin user = (TbAdmin)SecurityUtils.getSubject().getPrincipal();
		if(user!=null){
			//测试账号不支持修改密码
			if("test".equals(user.getUsername())){
				return ResultUtil.error();
			}
			TbAdmin admin = adminServiceImpl.login(user.getUsername(), oldPwd);
			if(admin!=null){
				admin.setPassword(newPwd);
				adminServiceImpl.updAdmin1(admin);
				//修改密码后移除作用域，重新登陆
				SecurityUtils.getSubject().logout();
				return ResultUtil.ok();
			}else{
				return new ResultUtil(501,"旧密码错误，请重新填写！");
			}
		}
		return new ResultUtil(500,"请求错误！");
	}
	
	@RequestMapping("/druid")
	@RequiresPermissions("sys:druid:list")
	public String druid(){
		return "redirect:/druid/index.html";
	}
	
	/**
	 * 获取菜单信息
	 * @return
	 */
	@RequestMapping("/menuData")
	@RequiresPermissions("sys:menu:list")
	@ResponseBody
	public ResultUtil menuData(){
		List<TbMenus> list=adminServiceImpl.selMenusByParentId();
		return ResultUtil.ok(list);
	}
	
	@RequestMapping("/toSaveMenu/{menuId}")
	@RequiresPermissions("sys:menu:save")
	public String toSaveMenu(@PathVariable("menuId") Long menuId,Model model){
		if(menuId!=null&&menuId!=1){
			TbMenus menus=new TbMenus();
			menus.setMenuId(menuId);
			model.addAttribute("menu",menus);
			model.addAttribute("flag","1");
			return "page/admin/menuForm";
		}else{
			model.addAttribute("msg","不允许操作！");
			return "page/active";
		}
	}
	@RequestMapping("/toEditMenu/{menuId}")
	@RequiresPermissions("sys:menu:update")
	public String toEditMenu(@PathVariable("menuId") Long menuId,Model model){
		if(menuId!=null&&menuId!=1){
			TbMenus menus=adminServiceImpl.selMenuById(menuId);
			model.addAttribute("menu",menus);
			return "page/admin/menuForm";
		}else if(menuId==1){
			model.addAttribute("msg","不允许操作此菜单！");
			return "page/active";
		}else{
			model.addAttribute("msg","不允许操作！");
			return "page/active";
		}
	}
	
	@SysLog("维护菜单信息")
	@RequestMapping("/menuForm")
	@RequiresPermissions(value={"sys:menu:save","sys:menu:update"})
	@ResponseBody
	public ResultUtil menuForm(TbMenus menus,String flag){
		if(StringUtils.isBlank(flag)){
			menus.setSpread("false");
			adminServiceImpl.updMenu(menus);
			return ResultUtil.ok("修改成功！");
		}else if(menus.getMenuId()!=1){
			menus.setParentId(menus.getMenuId());
			
			//规定只能3级菜单
			TbMenus m=adminServiceImpl.selMenusById(menus.getMenuId());
			if(m!=null&&m.getParentId()!=0){
				TbMenus m1=adminServiceImpl.selMenusById(m.getParentId());
				if(m1!=null&&m1.getParentId()!=0){
					return ResultUtil.error("此菜单不允许添加子菜单！");
				}
			}
			
			menus.setMenuId(null);
			menus.setSpread("false");
			adminServiceImpl.insMenu(menus);
			return ResultUtil.ok("添加成功！");
		}else{
			return ResultUtil.error("此菜单不允许操作！");
		}
	}
	
	//delMenuById
	@SysLog(value="删除菜单信息")
	@RequestMapping("/delMenuById/{menuId}")
	@RequiresPermissions("sys:menu:delete")
	@ResponseBody
	public ResultUtil delMenuById(@PathVariable("menuId")Long menuId) {
		try {
			if(menuId==1){
				return ResultUtil.error("此菜单不允许删除！");
			}
			//查询是否有子菜单，不允许删除
			List<TbMenus> data=adminServiceImpl.selMenusById1(menuId);
			if(data!=null&&data.size()>0){
				return ResultUtil.error("包含子菜单，不允许删除！");
			}
			adminServiceImpl.delMenuById(menuId);
			return ResultUtil.ok("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error("系统错误！");
		}
	}

	/**部门管理
	 * 部门管理
	 * @return
	 */
	@RequestMapping("/departmentList")
	@RequiresPermissions("sys:role:department")
	public String departmentList() {
		return "page/admin/departmentList";
	}

	/**
	 * 部门管理
	 * @return
	 */
	@RequestMapping("/getDepartmentList")
	@RequiresPermissions("sys:department:list")
	@ResponseBody
	public ResultUtil getDepartmentList() {
		List<TbDepartment> list = adminServiceImpl.selDepartmentByParentId(null);
		return ResultUtil.ok(list);
	}

	@RequestMapping("/toSaveDepartment/{id}")
	@RequiresPermissions("sys:department:save")
	public String toSaveDepartment(@PathVariable("id") Long id,Model model){
		if(id!=null){
			TbDepartment department=new TbDepartment();
			department.setId(id);
			department.setValid(true);
			model.addAttribute("department",department);
			model.addAttribute("flag","1");
			return "page/admin/departmentForm";
		}else{
			model.addAttribute("msg","不允许操作！");
			return "page/active";
		}
	}

	@SysLog("维护部门信息")
	@RequestMapping("/departmentForm")
	@RequiresPermissions(value={"sys:department:save","sys:department:update"})
	@ResponseBody
	public ResultUtil departmentForm(TbDepartment department,String flag){
		if(StringUtils.isBlank(flag)){
			adminServiceImpl.updDepartment(department);
			return ResultUtil.ok("修改成功！");
		}else {
			department.setParentId(department.getId() == 0 ? null : department.getId());
			department.setId(null);
			department.setCreateTime(new Date());
			adminServiceImpl.insDepartment(department);
			return ResultUtil.ok("添加成功！");
		}
	}

	@RequestMapping("/toEditDepartment/{id}")
	@RequiresPermissions("sys:department:update")
	public String toEditDepartment(@PathVariable("id") Long id,Model model){
		if(id!=null){
			TbDepartment department=adminServiceImpl.selDepartmentById(id);
			model.addAttribute("department",department);
			return "page/admin/departmentForm";
		}else{
			model.addAttribute("msg","不允许操作！");
			return "page/active";
		}
	}

	/**
	 * 通过id删除部门
	 * @param id
	 * @return
	 */
	@SysLog(value="删除指定部门")
	@RequestMapping("/delDepartmentById/{id}")
	@RequiresPermissions("sys:department:delete")
	@ResponseBody
	public ResultUtil delDepartmentById(@PathVariable("id")Long id) {
		try {
			//查询是否有子菜单，不允许删除
			List<TbDepartment> data=adminServiceImpl.selDepartmentByParentId(id);
			if(data!=null&&data.size()>0){
				return ResultUtil.error("包含子部门，不允许删除！");
			}
			adminServiceImpl.delDepartmentById(id);
			return ResultUtil.ok("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error("系统错误！");
		}
	}



	/**
	 * 地区管理
	 * @return
	 */
	@RequestMapping("/areaList")
	@RequiresPermissions("sys:role:area")
	public String areaList() {
		return "page/admin/areaList";
	}



	/**
	 * 地区管理
	 * @return
	 */
	@RequestMapping("/getAreaList")
		@RequiresPermissions("sys:area:list")
	@ResponseBody
	public ResultUtil getAreaList() {
		List<TbArea> list = adminServiceImpl.selAreaByParentId(null);
		return ResultUtil.ok(list);
	}

	@RequestMapping("/toSaveArea/{id}")
	@RequiresPermissions("sys:area:save")
	public String toSaveArea(@PathVariable("id") Long id,Model model){
		if(id!=null){
			TbArea area=new TbArea();
			area.setId(id);
			area.setValid(true);
			model.addAttribute("area",area);
			model.addAttribute("flag","1");
			return "page/admin/areaForm";
		}else{
			model.addAttribute("msg","不允许操作！");
			return "page/active";
		}
	}

	@SysLog("维护地区信息")
	@RequestMapping("/areaForm")
	@RequiresPermissions(value={"sys:area:save","sys:area:update"})
	@ResponseBody
	public ResultUtil areaForm(TbArea area,String flag){
		if(StringUtils.isBlank(flag)){
			adminServiceImpl.updArea(area);
			return ResultUtil.ok("修改成功！");
		}else {
			area.setParentId(area.getId() == 0 ? null : area.getId());
			area.setId(null);
			area.setCreateTime(new Date());
			adminServiceImpl.insArea(area);
			return ResultUtil.ok("添加成功！");
		}
	}

	@RequestMapping("/toEditArea/{id}")
	@RequiresPermissions("sys:area:update")
	public String toEditArea(@PathVariable("id") Long id,Model model){
		if(id!=null){
			TbArea area=adminServiceImpl.selAreaById(id);
			model.addAttribute("area",area);
			return "page/admin/areaForm";
		}else{
			model.addAttribute("msg","不允许操作！");
			return "page/active";
		}
	}

	/**
	 * 通过id删除地区
	 * @param id
	 * @return
	 */
	@SysLog(value="删除指定地区")
	@RequestMapping("/delAreaById/{id}")
	@RequiresPermissions("sys:area:delete")
	@ResponseBody
	public ResultUtil delAreaById(@PathVariable("id")Long id) {
		try {
			//查询是否有子地区，不允许删除
			List<TbArea> data=adminServiceImpl.selAreaByParentId(id);
			if(data!=null&&data.size()>0){
				return ResultUtil.error("包含下级地区，不允许删除！");
			}
			adminServiceImpl.delAreaById(id);
			return ResultUtil.ok("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error("系统错误！");
		}
	}


	/** select 选项，不需要权限		**/

	/**
	 * 地区
	 * @return
	 */
	@RequestMapping("/selectArea")
	public String selectArea() {
		return "page/admin/selectArea";
	}

	@RequestMapping("/getSelectArea")
	@ResponseBody
	public ResultUtil getSelectArea() {
		List<TbArea> list = adminServiceImpl.selAreaByParentId(null);
		return ResultUtil.ok(list);
	}


	/**
	 * 部门
	 * @return
	 */
	@RequestMapping("/selectDepartment")
	public String selectDepartment() {
		return "page/admin/selectDepartment";
	}

	@RequestMapping("/getSelectDepartment")
	@ResponseBody
	public ResultUtil getSelectDepartment() {
		List<TbDepartment> list = adminServiceImpl.selDepartmentByParentId(null);
		return ResultUtil.ok(list);
	}

	/** select 选项，不需要权限		**/
}
