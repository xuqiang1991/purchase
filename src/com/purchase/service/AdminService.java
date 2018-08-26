package com.purchase.service;


import com.purchase.pojo.admin.*;
import com.purchase.util.ResultUtil;
import com.purchase.vo.admin.ChoseAdminVO;
import com.purchase.vo.admin.Menu;
import com.purchase.vo.admin.XtreeData;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import java.util.List;

public interface AdminService {
	// 登陆
	public TbAdmin login(String username, String password);
	
	//获取所有角色
	public ResultUtil selRoles(Integer page,Integer limit);
	
	//获取所有角色
	public List<TbRoles> selRoles();
	
	//获取所有管理员
	public ResultUtil selAdmins(Integer page,Integer limit);
	
	//获取角色菜单
	public List<Menu> selMenus(TbAdmin admin);
	
	//获取指定角色权限树
	public List<XtreeData> selXtreeData(TbAdmin admin);
	//获取指定角色权限树
	public List<XtreeData> selXtreeData1(TbAdmin admin);
	
	//更新角色信息
	public void updRole(TbRoles role,String m);
	
	//删除指定角色
	public void delRole(Long roleId);

	//批量删除指定角色
	public void delRoles(String rolesId);
	
	//根据角色名查询角色
	public TbRoles selRoleByRoleName(String roleName);

	//添加新角色
	public void insRole(TbRoles role, String m);

	//删除指定管理员
	public void delAdminById(Long id);

	//批量删除指定管理员
	public void delAdmins(String adminStr);

	//管理员用户名唯一性校验
	public TbAdmin selAdminByUserName(String username);

	//新增管理员
	public void insAdmin(TbAdmin admin);

	//根据id得到管理员
	public TbAdmin selAdminById(Long id);

	//根据email得到管理员
	public TbAdmin selAdminByEmail(String eMail,String username);

	//更新管理员信息
	public void updAdmin(TbAdmin admin);

	public void updAdmin1(TbAdmin admin);

	public List<TbMenus> selMenusByParentId();

	public TbMenus selMenuById(Long menuId);

	public void insMenu(TbMenus menus);

	public void updMenu(TbMenus menus);

	public TbMenus selMenuByTitle(String title, Long menuId);

	public TbMenus selMenusById(Long menuId);

	public void delMenuById(Long menuId);

	public List<TbMenus> selMenusById1(Long menuId);

	List<TbDepartment> selDepartmentByParentId(Long parentId);

	void insDepartment(TbDepartment department);

	int updDepartment(TbDepartment department);

	TbDepartment selDepartmentById(Long id);

	void delDepartmentById(Long id);

    List<TbArea> selAreaByParentId(Long id);

	void updArea(TbArea area);

	void insArea(TbArea area);

	TbArea selAreaById(Long id);

	void delAreaById(Long id);

	TbAdmin wxLogin(WxMpUser user);

    /**
     * 根据在职状态获取用户
     * @param isOnJob
     * @return
     */
    List<TbAdmin> getAdmins(Integer isOnJob);

    /**
     * 构建用户下拉框数据
     * @return
     */
    List<ChoseAdminVO> selectAdmin();
}
