package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.purchase.mapper.admin.*;
import com.purchase.pojo.admin.*;
import com.purchase.pojo.admin.TbAdminExample.Criteria;
import com.purchase.service.AdminService;
import com.purchase.util.ResultUtil;
import com.purchase.vo.admin.ChoseAdminVO;
import com.purchase.vo.admin.Menu;
import com.purchase.vo.admin.XtreeData;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private TbAdminMapper adminMapper;

	@Autowired
	private TbRolesMapper tbRolesMapper;

	@Autowired
	private TbAdminMapper tbAdminMapper;

	@Autowired
	private TbRolesMenusMapper tbRolesMenusMapper;

	@Autowired
	private AdminMenusMapper adminMenusMapper;

	@Autowired
	private TbMenusMapper tbMenusMapper;

	@Autowired
	private TbDepartmentMapper tbDepartmentMapper;


	@Autowired
	private TbAreaMapper tbAreaMapper;

	@Autowired
    private TbSupplierMapper supplierMapper;

	/**
	 * 管理员登陆
	 */
	@Override
	public TbAdmin login(String username, String password) {
		//对密码加密
		password=DigestUtils.md5DigestAsHex(password.getBytes());
		TbAdminExample example = new TbAdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPasswordEqualTo(password);
		List<TbAdmin> admin = adminMapper.selectByExample(example);
		if (admin != null && admin.size() > 0) {
			return admin.get(0);
		}
		return null;
	}

	@Override
	public ResultUtil selRoles(Integer page, Integer limit) {
		PageHelper.startPage(page, limit);
		TbRolesExample example = new TbRolesExample();
		List<TbRoles> list = tbRolesMapper.selectByExample(example);
		PageInfo<TbRoles> pageInfo = new PageInfo<TbRoles>(list);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCode(0);
		resultUtil.setCount(pageInfo.getTotal());
		resultUtil.setData(pageInfo.getList());
		return resultUtil;
	}

	@Override
	public ResultUtil selAdmins(Integer page, Integer limit) {
		PageHelper.startPage(page, limit);
		TbAdminExample example = new TbAdminExample();
		List<TbAdmin> list = tbAdminMapper.selectByExample(example);
		// 将roleName写进TbAdmin
        List<TbRoles> roles = selRoles();
		for (TbAdmin tbAdmin : list) {
			for (TbRoles tbRole : roles) {
				if (tbRole.getRoleId() == tbAdmin.getRoleId()) {
					tbAdmin.setRoleName(tbRole.getRoleName());
				}
			}
			//部门写入
            if(!StringUtils.isEmpty(tbAdmin.getDeptId())){
               TbDepartment dept = tbDepartmentMapper.selectByPrimaryKey(Long.parseLong(tbAdmin.getDeptId()));
               if(dept != null){
                   tbAdmin.setDeptName(dept.getName());
               }
            }
            //供应商写入
            if(!StringUtils.isEmpty(tbAdmin.getSupplierId())){
                TbSupplier supplier = supplierMapper.selectByPrimaryKey(tbAdmin.getSupplierId());
                if(supplier != null){
                    tbAdmin.setSupplierName(supplier.getName());
                }
            }
		}
		PageInfo<TbAdmin> pageInfo = new PageInfo<TbAdmin>(list);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCode(0);
		resultUtil.setCount(pageInfo.getTotal());
		resultUtil.setData(pageInfo.getList());
		return resultUtil;
	}

	@Override
	public List<TbRoles> selRoles() {
		TbRolesExample example = new TbRolesExample();
		List<TbRoles> list = tbRolesMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<Menu> selMenus(TbAdmin admin) {
		List<Menu> results = new ArrayList<>();
		Long roleId = admin.getRoleId();
		TbRolesMenusExample example = new TbRolesMenusExample();
		com.purchase.pojo.admin.TbRolesMenusExample.Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		List<TbRolesMenusKey> list = tbRolesMenusMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			List<TbMenus> menus = adminMenusMapper.getMenus(roleId);
			for (int i = 0; i < menus.size(); i++) {
				if (menus.get(i).getParentId() == 0) {
					Menu menu = new Menu();
					menu.setTitle(menus.get(i).getTitle());
					menu.setIcon(menus.get(i).getIcon());
					menu.setHref(menus.get(i).getHref());
					menu.setSpread(menus.get(i).getSpread());
					List<Menu> menus2 = new ArrayList<>();
					for (int j = 0; j < menus.size(); j++) {
						if (menus.get(j).getParentId() == menus.get(i).getMenuId()) {
							Menu menu2 = new Menu();
							menu2.setTitle(menus.get(j).getTitle());
							menu2.setIcon(menus.get(j).getIcon());
							menu2.setHref(menus.get(j).getHref());
							menu2.setSpread(menus.get(j).getSpread());
							menus2.add(menu2);
						}
					}
					menu.setChildren(menus2);
					results.add(menu);
				}
			}
		}
		return results;
	}

	@Override
	public List<XtreeData> selXtreeData(TbAdmin admin) {
		List<XtreeData> list = new ArrayList<>();
		// 获取所有的权限菜单
		TbMenusExample example = new TbMenusExample();
		List<TbMenus> allMenus = tbMenusMapper.selectByExample(example);
		// 获取指定角色的菜单
		List<TbMenus> menus = adminMenusMapper.getMenus(admin.getRoleId());
		for (TbMenus m : allMenus) {
			if (m.getParentId() == 0) {
				XtreeData x = new XtreeData();
				x.setTitle(m.getTitle());
				x.setValue(m.getMenuId() + "");
				List<XtreeData> list2 = new ArrayList<>();
				for (TbMenus m1 : allMenus) {
					if (m1.getParentId() == m.getMenuId()) {
						XtreeData x1 = new XtreeData();
						x1.setTitle(m1.getTitle());
						x1.setValue(m1.getMenuId() + "");
						// 是否拥有权限
						x1.setChecked(false);
						for (TbMenus mh : menus) {
							if (mh.getMenuId() == m1.getMenuId()) {
								x1.setChecked(true);
								break;
							}
						}
						// 使数据data不为null
						List<XtreeData> l = new ArrayList<>();
						x1.setData(l);
						list2.add(x1);
					}
				}
				x.setData(list2);
				list.add(x);
			}
		}

		// 拥有没有子节点的节点，设置选中
		for (XtreeData xd : list) {
			if (xd.getData() == null || xd.getData().size() == 0) {
				for (TbMenus tbMenus : menus) {
					if (tbMenus.getMenuId() == Long.parseLong(xd.getValue())) {
						xd.setChecked(true);
						break;
					}
				}
			}
		}
		//默认拥有首页菜单权限
		list.get(0).setDisabled(true);
		list.get(0).setChecked(true);
		return list;
	}
	@Override
	public List<XtreeData> selXtreeData1(TbAdmin admin) {
		List<XtreeData> list = new ArrayList<>();
		// 获取所有的权限菜单
		TbMenusExample example = new TbMenusExample();
		List<TbMenus> allMenus = tbMenusMapper.selectByExample(example);
		// 获取指定角色的菜单
		List<TbMenus> menus = adminMenusMapper.getMenus(admin.getRoleId());
		for (TbMenus m : allMenus) {
			if (m.getParentId() == 0) {
				XtreeData x = new XtreeData();
				x.setTitle(m.getTitle());
				x.setValue(m.getMenuId() + "");
				//一级菜单选中
				for (TbMenus mh : menus) {
					if (mh.getMenuId() == m.getMenuId()) {
						x.setChecked(true);
						break;
					}
				}
				List<XtreeData> list2 = new ArrayList<>();
				for (TbMenus m1 : allMenus) {
					if (m1.getParentId() == m.getMenuId()) {
						XtreeData x1 = new XtreeData();
						x1.setTitle(m1.getTitle());
						x1.setValue(m1.getMenuId() + "");
						List<XtreeData> list3 = new ArrayList<>();
						//二级菜单选中
						for (TbMenus mh : menus) {
							if (mh.getMenuId() == m1.getMenuId()) {
								x1.setChecked(true);
								break;
							}
						}
						for (TbMenus m2 : allMenus) {
							if (m2.getParentId() == m1.getMenuId()) {
								XtreeData x2 = new XtreeData();
								x2.setTitle(m2.getTitle());
								x2.setValue(m2.getMenuId() + "");
								//三级菜单选中
								for (TbMenus mh1 : menus) {
									if (mh1.getMenuId() == m2.getMenuId()) {
										x2.setChecked(true);
										break;
									}
								}
								// 使数据data不为null
								List<XtreeData> l = new ArrayList<>();
								x2.setData(l);
								list3.add(x2);
							}
						}
						
						x1.setData(list3);
						list2.add(x1);
					}
				}
				x.setData(list2);
				list.add(x);
			}
		}
		
		// 拥有没有子节点的节点，设置选中
		for (XtreeData xd : list) {
			if (xd.getData() == null || xd.getData().size() == 0) {
				for (TbMenus tbMenus : menus) {
					if (tbMenus.getMenuId() == Long.parseLong(xd.getValue())) {
						xd.setChecked(true);
					}
				}
			}
		}
		//默认拥有首页菜单权限
		list.get(0).setDisabled(true);
		list.get(0).setChecked(true);
		return list;
	}

	@Override
	public void updRole(TbRoles role, String m) {
		// 更新角色信息
		tbRolesMapper.updateByPrimaryKey(role);
		// 先删除角色所有权限
		TbRolesMenusExample example = new TbRolesMenusExample();
		com.purchase.pojo.admin.TbRolesMenusExample.Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(role.getRoleId());
		tbRolesMenusMapper.deleteByExample(example);
		// 更新权限信息
		if (m != null && m.length() != 0) {
			String[] array = m.split(",");  
			List<String> result = new ArrayList<>();  
			boolean flag;  
			for(int i=0;i<array.length;i++){  
			    flag = false;  
			    for(int j=0;j<result.size();j++){  
			        if(array[i].equals(result.get(j))){  
			            flag = true;  
			            break;  
			        }  
			    }  
			    if(!flag){  
			        result.add(array[i]);  
			    }  
			}  
			// 重新赋予权限
			if (result != null && result.size() > 0) {
				for (int i = 0; i < result.size(); i++) {
					TbRolesMenusKey record = new TbRolesMenusKey();
					record.setMenuId(Long.parseLong(result.get(i)));
					record.setRoleId(role.getRoleId());
					// 维护角色—菜单表
					tbRolesMenusMapper.insert(record);
				}
			}
		}
	}

	@Override
	public void delRole(Long roleId) {
		tbRolesMapper.deleteByPrimaryKey(roleId);
	}

	@Override
	public void delRoles(String rolesId) {
		String[] rids = rolesId.split(",");
		for (String id : rids) {
			tbRolesMapper.deleteByPrimaryKey(Long.parseLong(id));
		}
	}

	@Override
	public TbRoles selRoleByRoleName(String roleName) {
		TbRolesExample example = new TbRolesExample();
		com.purchase.pojo.admin.TbRolesExample.Criteria criteria = example.createCriteria();
		criteria.andRoleNameEqualTo(roleName);
		List<TbRoles> roles = tbRolesMapper.selectByExample(example);
		if (roles != null && roles.size() > 0) {
			return roles.get(0);
		}
		return null;
	}

	@Override
	public void insRole(TbRoles role, String m) {
		//维护角色表
		tbRolesMapper.insert(role);
		// 维护角色-菜单表
		if (m != null && m.length() != 0) {
			String[] array = m.split(",");  
			List<String> result = new ArrayList<>();  
			boolean flag;  
			for(int i=0;i<array.length;i++){  
			    flag = false;  
			    for(int j=0;j<result.size();j++){  
			        if(array[i].equals(result.get(j))){  
			            flag = true;  
			            break;  
			        }  
			    }  
			    if(!flag){  
			        result.add(array[i]);  
			    }  
			}  
			// 重新赋予权限
			if (result != null && result.size() > 0) {
				for (int i = 0; i < result.size(); i++) {
					TbRolesMenusKey record = new TbRolesMenusKey();
					record.setMenuId(Long.parseLong(result.get(i)));
					record.setRoleId(role.getRoleId());
					// 维护角色—菜单表
					tbRolesMenusMapper.insert(record);
				}
			}
		}
	}

	@Override
	public void delAdminById(Long id) {
		tbAdminMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void delAdmins(String adminStr) {
		String[] strs = adminStr.split(",");
		if(strs!=null&&strs.length>0){
			for (String str : strs) {
				tbAdminMapper.deleteByPrimaryKey(Long.parseLong(str));
			}
		}
	}

	@Override
	public TbAdmin selAdminByUserName(String username) {
		TbAdminExample example = new TbAdminExample();
		com.purchase.pojo.admin.TbAdminExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<TbAdmin> admins = tbAdminMapper.selectByExample(example);
		if (admins != null && admins.size() > 0) {
			return admins.get(0);
		}
		return null;
	}

	@Override
	public void insAdmin(TbAdmin admin) {
		//对密码md5加密
		admin.setPassword(DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()));
		tbAdminMapper.insert(admin);
	}

	@Override
	public TbAdmin selAdminById(Long id) {
		TbAdmin admin=tbAdminMapper.selectByPrimaryKey(id);
		if(!StringUtils.isEmpty(admin.getDeptId())){
		    TbDepartment dept = tbDepartmentMapper.selectByPrimaryKey(Long.parseLong(admin.getDeptId()));
		    admin.setDeptName(dept.getName());
        }
        if(admin.getSupplierId() != null){
           TbSupplier supplier = supplierMapper.selectByPrimaryKey(admin.getSupplierId());
            admin.setDeptName(supplier.getName());
        }
		//为了安全，密码置空
		admin.setPassword("");
		return admin;
	}

	@Override
	public TbAdmin selAdminByEmail(String eMail,String username) {
		TbAdminExample example = new TbAdminExample();
		com.purchase.pojo.admin.TbAdminExample.Criteria criteria = example.createCriteria();
		criteria.andEMailEqualTo(eMail);
		if(username!=null&&!"".equals(username)){
			criteria.andUsernameNotEqualTo(username);
		}
		List<TbAdmin> admins = tbAdminMapper.selectByExample(example);
		if (admins != null && admins.size() > 0) {
			return admins.get(0);
		}
		return null;
	}

	@Override
	public void updAdmin(TbAdmin admin) {
		TbAdmin a = tbAdminMapper.selectByPrimaryKey(admin.getId());
		admin.setPassword(a.getPassword());
		tbAdminMapper.updateByPrimaryKey(admin);
	}

	@Override
	public void updAdmin1(TbAdmin admin) {
		admin.setPassword(DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()));
		tbAdminMapper.updateByPrimaryKey(admin);
	}

	@Override
	public List<TbMenus> selMenusByParentId() {
		TbMenusExample example=new TbMenusExample();
		List<TbMenus> data = tbMenusMapper.selectByExample(example);
		return data;
	}

	@Override
	public TbMenus selMenuById(Long menuId) {
		TbMenus menu = tbMenusMapper.selectByPrimaryKey(menuId);
		return menu;
	}

	@Override
	public void insMenu(TbMenus menus) {
		tbMenusMapper.insert(menus);
	}

	@Override
	public void updMenu(TbMenus menus) {
		tbMenusMapper.updateByPrimaryKey(menus);
	}

	@Override
	public TbMenus selMenuByTitle(String title, Long menuId) {
		TbMenusExample example=new TbMenusExample();
		com.purchase.pojo.admin.TbMenusExample.Criteria criteria = example.createCriteria();
		criteria.andTitleEqualTo(title);

		TbMenus menus = tbMenusMapper.selectByPrimaryKey(menuId);
		Long parentId = menus.getParentId();
		if(parentId != null && parentId > 0){
			criteria.andParentIdEqualTo(parentId);
		}
		criteria.andMenuIdNotEqualTo(menuId);

		List<TbMenus> data = tbMenusMapper.selectByExample(example);
		if(data!=null&&data.size()>0){
			return data.get(0);
		}
		return null;
	}

	@Override
	public TbMenus selMenusById(Long menuId) {
		TbMenusExample example=new TbMenusExample();
		com.purchase.pojo.admin.TbMenusExample.Criteria criteria = example.createCriteria();
		criteria.andMenuIdEqualTo(menuId);
		List<TbMenus> data = tbMenusMapper.selectByExample(example);
		if(data!=null&&data.size()>0){
			return data.get(0);
		}
		return null;
	}

	@Override
	public void delMenuById(Long menuId) {
		tbMenusMapper.deleteByPrimaryKey(menuId);
	}

	@Override
	public List<TbMenus> selMenusById1(Long menuId) {
		TbMenusExample example=new TbMenusExample();
		com.purchase.pojo.admin.TbMenusExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(menuId);
		List<TbMenus> data = tbMenusMapper.selectByExample(example);
		return data;
	}

	@Override
	public List<TbDepartment> selDepartmentByParentId(Long parentId) {
		TbDepartmentExample example=new TbDepartmentExample();
		if(parentId != null){
			example.createCriteria().andParentIdEqualTo(parentId);
		}
		List<TbDepartment> data = tbDepartmentMapper.selectByExample(example);
		return data;
	}

	@Override
	public void insDepartment(TbDepartment department) {
		tbDepartmentMapper.insert(department);
	}

	@Override
	public int updDepartment(TbDepartment department) {
		return tbDepartmentMapper.updateByPrimaryKey(department);
	}

	@Override
	public TbDepartment selDepartmentById(Long id) {
		return tbDepartmentMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delDepartmentById(Long id) {
		tbDepartmentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<TbArea> selAreaByParentId(Long parentId) {
		TbAreaExample example=new TbAreaExample();
		if(parentId != null){
			example.createCriteria().andParentIdEqualTo(parentId);
		}
		List<TbArea> data = tbAreaMapper.selectByExample(example);
		return data;
	}

	@Override
	public void updArea(TbArea area) {
		tbAreaMapper.updateByPrimaryKey(area);
	}

	@Override
	public void insArea(TbArea area) {
		tbAreaMapper.insert(area);
	}

	@Override
	public TbArea selAreaById(Long id) {
		return tbAreaMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delAreaById(Long id) {
		tbAreaMapper.deleteByPrimaryKey(id);
	}

	@Override
	public TbAdmin wxLogin(WxMpUser user) {
		String nick = user.getNickname();
		String openId = user.getOpenId();
		TbAdmin admin = tbAdminMapper.selAdminByOpenId(openId);
		if(admin == null){
			admin = tbAdminMapper.selAdminByWxNick(nick);
			if(admin != null){
				TbAdmin tmp = new TbAdmin();
				tmp.setId(admin.getId());
				tmp.setOpenId(openId);
				tbAdminMapper.updateByPrimaryKeySelective(tmp);
			}
		}
		return admin;

	}

    @Override
    public List<TbAdmin> getAdmins(Integer isOnJob) {
        return tbAdminMapper.getAdmins(isOnJob);
    }

    @Override
    public List<ChoseAdminVO> selectAdmin(){
        List<TbAdmin> admis = tbAdminMapper.getAdmins(1);
        List<ChoseAdminVO> item = new ArrayList();
        if(!CollectionUtils.isEmpty(admis)){
            for (TbAdmin a: admis) {
                item.add(new ChoseAdminVO(a.getId().toString(),a.getFullname()));
            }
        }
        return item;
    }
}
