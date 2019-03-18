package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.purchase.mapper.admin.*;
import com.purchase.pojo.admin.*;
import com.purchase.pojo.admin.TbAdminExample.Criteria;
import com.purchase.service.AdminService;
import com.purchase.util.ResultUtil;
import com.purchase.vo.admin.*;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private TbAdminRoleMapper tbAdminRoleMapper;

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
		List<TbAdmin> admin = adminMapper.selectByExampleExt(example);
		if (admin != null && admin.size() > 0) {
			return admin.get(0);
		}
		return null;
	}

	@Override
	public ResultUtil selRoles(Integer page, Integer limit) {
		PageHelper.startPage(page, limit);
		TbRolesExample example = new TbRolesExample();
        example.setOrderByClause(" role_id asc");
		List<TbRoles> list = tbRolesMapper.selectByExample(example);
		PageInfo<TbRoles> pageInfo = new PageInfo<TbRoles>(list);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCode(0);
		resultUtil.setCount(pageInfo.getTotal());
		resultUtil.setData(pageInfo.getList());
		return resultUtil;
	}

	@Override
	public ResultUtil selAdmins(Integer page, Integer limit, AdminSearch search) {
		PageHelper.startPage(page, limit);
		TbAdminExample example = new TbAdminExample();
        example.setOrderByClause(" a.id asc");
		TbAdminExample.Criteria criteria = example.createCriteria();

		if(!StringUtils.isEmpty(search.getKeyWord())){
            if(StringUtils.isEmpty(search.getUsername())){
                search.setUsername(search.getKeyWord());
            }
            if(StringUtils.isEmpty(search.getFullname())){
                search.setFullname(search.getKeyWord());
            }
        }
		if(!StringUtils.isEmpty(search.getUsername())){
            TbAdminExample.Criteria criteria1 = example.createCriteria();
			criteria1.andUsernameLike("%"+search.getUsername()+"%");
			example.or(criteria1);
		}
		if(!StringUtils.isEmpty(search.getFullname())){
            TbAdminExample.Criteria criteria2 = example.createCriteria();
			criteria2.andFullnameLike("%"+search.getFullname()+"%");
            example.or(criteria2);
		}
		if(search.getIsOnJob() != null){
			criteria.andIsOnJobEqualTo(search.getIsOnJob());
		}

        if(search.getDeptId() != null){
            criteria.andDeptIdEqualTo(search.getDeptId().intValue());
        }

        if(search.getSupplierId() != null){
            criteria.andSupplierIdEqualTo(search.getSupplierId().intValue());
        }

		List<TbAdmin> list = tbAdminMapper.selectByExampleExt(example);
		Long count = tbAdminMapper.selectByExampleExt_COUNT(example);
		// 将roleName写进TbAdmin
        List<TbRoles> roles = selRoles();
		for (TbAdmin tbAdmin : list) {
			for (TbRoles tbRole : roles) {
				if(!CollectionUtils.isEmpty(tbAdmin.getRoleId())){
					if (tbAdmin.getRoleId().contains(tbRole.getRoleId())) {
						String roleName = tbAdmin.getRoleName();
						if(roleName == null){
							tbAdmin.setRoleName(tbRole.getRoleName());
						}else {
							tbAdmin.setRoleName(roleName + "," + tbRole.getRoleName());
						}
					}
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
		resultUtil.setCount(count);
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
		List<Long> roleId = admin.getRoleId();
		TbRolesMenusExample example = new TbRolesMenusExample();
		com.purchase.pojo.admin.TbRolesMenusExample.Criteria criteria = example.createCriteria();
		criteria.andRoleIdIn(roleId);
		List<TbRolesMenusKey> list = tbRolesMenusMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			List<TbMenus> menus = adminMenusMapper.getMenus(roleId);
			for (int i = 0; i < menus.size(); i++) {
				if (menus.get(i).getParentId().longValue() == 0l) {
					Menu menu = new Menu();
					menu.setTitle(menus.get(i).getTitle());
					menu.setIcon(menus.get(i).getIcon());
					menu.setHref(menus.get(i).getHref());
					menu.setSpread(menus.get(i).getSpread());
					List<Menu> menus2 = new ArrayList<>();
					for (int j = 0; j < menus.size(); j++) {
						if (menus.get(j).getParentId().longValue() == menus.get(i).getMenuId().longValue()) {
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
					if (mh.getMenuId().equals(m.getMenuId())) {
						x.setChecked(true);
						break;
					}
				}
				List<XtreeData> list2 = new ArrayList<>();
				for (TbMenus m1 : allMenus) {
					if (m1.getParentId().equals(m.getMenuId())) {
						XtreeData x1 = new XtreeData();
						x1.setTitle(m1.getTitle());
						x1.setValue(m1.getMenuId() + "");
						List<XtreeData> list3 = new ArrayList<>();
						//二级菜单选中
						for (TbMenus mh : menus) {
							if (mh.getMenuId().equals(m1.getMenuId())) {
								x1.setChecked(true);
								break;
							}
						}
						for (TbMenus m2 : allMenus) {
							if (m2.getParentId().equals(m1.getMenuId())) {
								XtreeData x2 = new XtreeData();
								x2.setTitle(m2.getTitle());
								x2.setValue(m2.getMenuId() + "");
								//三级菜单选中
								for (TbMenus mh1 : menus) {
									if (mh1.getMenuId().equals(m2.getMenuId())) {
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
		List<TbAdmin> admins = tbAdminMapper.selectByExampleExt(example);
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

		List<Long> roleIds = admin.getRoleId();
		if(!CollectionUtils.isEmpty(roleIds)){
			for (Long roleId : roleIds){
				TbAdminRole tbAdminRole = new TbAdminRole();
				tbAdminRole.setUserId(admin.getId());
				tbAdminRole.setRoleId(roleId);
				tbAdminRoleMapper.insert(tbAdminRole);
			}
		}
	}

	@Override
	public TbAdmin selAdminById(Long id) {
		TbAdmin admin=tbAdminMapper.selectByPrimaryKey(id);
		if(!StringUtils.isEmpty(admin.getDeptId())){
		    TbDepartment dept = tbDepartmentMapper.selectByPrimaryKey(Long.parseLong(admin.getDeptId()));
		    if(dept != null){
                admin.setDeptName(dept.getName());
            }
        }
        if(admin.getSupplierId() != null){
           TbSupplier supplier = supplierMapper.selectByPrimaryKey(admin.getSupplierId());
           if(supplier != null){
               admin.setSupplierName(supplier.getName());
           }
        }
		TbAdminRoleExample example = new TbAdminRoleExample();
		TbAdminRoleExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(id);
		List<TbAdminRole> roles = tbAdminRoleMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(roles)){
			List<Long> rolesIds = new ArrayList<>();
			for (TbAdminRole role : roles){
				rolesIds.add(role.getRoleId());
			}
			admin.setRoleId(rolesIds);
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
		List<TbAdmin> admins = tbAdminMapper.selectByExampleExt(example);
		if (admins != null && admins.size() > 0) {
			return admins.get(0);
		}
		return null;
	}

	@Override
	public void updAdmin(TbAdmin admin) {
		TbAdmin a = tbAdminMapper.selectByPrimaryKey(admin.getId());
		//如果昵称改变则清空openId
		if(!StringUtils.isEmpty(a.getWxNick()) && !a.getWxNick().equalsIgnoreCase(admin.getWxNick().trim())){
			admin.setOpenId("");
		}

		admin.setPassword(a.getPassword());
		tbAdminMapper.updateByPrimaryKey(admin);

		//删除角色后新增
		TbAdminRoleExample example = new TbAdminRoleExample();
		TbAdminRoleExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(admin.getId());
		tbAdminRoleMapper.deleteByExample(example);
		List<Long> roleIds = admin.getRoleId();
		if(!CollectionUtils.isEmpty(roleIds)){
			for (Long roleId : roleIds){
				TbAdminRole tbAdminRole = new TbAdminRole();
				tbAdminRole.setUserId(admin.getId());
				tbAdminRole.setRoleId(roleId);
				tbAdminRoleMapper.insert(tbAdminRole);
			}
		}
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
		example.setOrderByClause("id DESC");
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
		example.setOrderByClause("id DESC");
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

	@Override
	public List<ChoseAdminVO> selectAdminBySupplierId(Long supplierId) {
		List<TbAdmin> admis = tbAdminMapper.selectAdminBySupplierId(1,supplierId);
		List<ChoseAdminVO> item = new ArrayList();
		if(!CollectionUtils.isEmpty(admis)){
			for (TbAdmin a: admis) {
				item.add(new ChoseAdminVO(a.getId().toString(),a.getFullname()));
			}
		}
		return item;
	}

	@Override
	public List<ChoseSupplierVO> selectAdminSupplierIdNotNull() {
		//List<TbAdmin> admis = tbAdminMapper.selectAdminSupplierIdNotNull(1);
		List<TbAdmin> admis = tbAdminMapper.getAdminSupplierIdNotNullExt();
		List<ChoseSupplierVO> item = new ArrayList();
		if(!CollectionUtils.isEmpty(admis)){
			List<TbSupplier> suppliers = supplierMapper.selectByExample(new TbSupplierExample());
			for (TbSupplier s : suppliers) {
				Long value = s.getId();
				List<ChoseAdminVO> adminItem = new ArrayList();
				//System.out.println("value:" + value);
				for (TbAdmin a: admis) {
					//System.out.println("a.getSupplierId():" + a.getSupplierId());
					if(value.equals(a.getSupplierId())){
						adminItem.add(new ChoseAdminVO(a.getId().toString(),a.getFullname()));
					}
				}
				if(!CollectionUtils.isEmpty(adminItem)){
					item.add(new ChoseSupplierVO(value.toString(),s.getName(),adminItem));
				}
			}
		}
		return item;
	}

	@Override
	public List<ChoseDeptVO> selectDeptAdmin() {
		List<ChoseDeptVO> item = new ArrayList<>();
		TbDepartmentExample example=new TbDepartmentExample();
		example.setOrderByClause("id DESC");
		example.createCriteria().andParentIdIsNull();
		//查询没有上级菜单的部门
		List<TbDepartment> depts = tbDepartmentMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(depts)){
			for (TbDepartment d: depts) {
				ChoseDeptVO dept = new ChoseDeptVO(d.getId().toString(),d.getName());
				List<TbAdmin> admins = tbAdminMapper.getAdminsByDeptId(d.getId().toString());
				List<ChoseAdminVO> adminItem = new ArrayList();
				if(!CollectionUtils.isEmpty(admins)){
					for (TbAdmin a: admins) {
						adminItem.add(new ChoseAdminVO(a.getId().toString(),a.getFullname()));
					}
					dept.setChildren(adminItem);
				}
				item.add(dept);
				//item.add(new ChoseDeptVO(d.getId().toString(),d.getName(),adminMap.get(d.getId())));
			}
		}
		return item;
	}

	@Override
	public List<ChoseAreaVO> selectArea() {
		List<ChoseAreaVO> item = new ArrayList<>();
        TbAreaExample example=new TbAreaExample();
		example.setOrderByClause("id DESC");
        example.createCriteria().andParentIdIsNull().andValidEqualTo(Boolean.TRUE);
		List<TbArea> areas = tbAreaMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(areas)){
            Map<String,Object> retMap = fristArea(areas);
            for (TbArea s: areas) {
                TbAreaExample exampleParant = new TbAreaExample();
                exampleParant.createCriteria().andParentIdEqualTo(s.getId()).andValidEqualTo(Boolean.TRUE);
                List<TbArea> areasParant = tbAreaMapper.selectByExample(exampleParant);
                if(!CollectionUtils.isEmpty(areasParant)){
                    List<ChoseAreaVO> itemParant = new ArrayList<>();
                    for (TbArea sp: areasParant){
                        itemParant.add(new ChoseAreaVO(sp.getId().toString(),sp.getName()));
                    }
                    item.add(new ChoseAreaVO(s.getId().toString(),s.getName(),itemParant));
                }else{
                    item.add(new ChoseAreaVO(s.getId().toString(),s.getName()));
                }
            }
           /* List<ChoseAreaVO> fristArea = (List<ChoseAreaVO>) retMap.get("fristArea");
            if(!CollectionUtils.isEmpty(fristArea)){
                Map<Long,Object> areaMap = (Map<Long, Object>) retMap.get("otherArea");
                for (ChoseAreaVO s: fristArea) {
                    if(areaMap.containsKey(s.getValue())){

                    }

                    item.add(new ChoseAreaVO(s.getId().toString(),s.getName()));

                }
            }*/
		}

		return item;
	}


	private Map<String,Object> fristArea(List<TbArea> areas){
        Map<String,Object> retMap = new HashMap<>();
        List<ChoseAreaVO> fristArea = new ArrayList<>();
        if(!CollectionUtils.isEmpty(areas)){
            Map<Long,Object> areaMap = new HashMap<>();
            for (TbArea s: areas) {
                if(s.getParentId() == null){
                    fristArea.add(new ChoseAreaVO(s.getId().toString(),s.getName()));
                }else{
                    areaMap.put(s.getParentId(),s);
                }
            }
            retMap.put("fristArea",fristArea);
            retMap.put("otherArea",areaMap);
        }
        return retMap;
    }


	@Override
	public List<ChoseAdminForRoleVO> selectRoleAdmin() {
		List<ChoseAdminForRoleVO> item = new ArrayList<>();
		TbRolesExample example = new TbRolesExample();
		example.setOrderByClause("role_id DESC");
		example.createCriteria().andRoleIdNotEqualTo(1L);
		//查询非管理员角色
		List<TbRoles> rolesList = tbRolesMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(rolesList)){
			for (TbRoles r: rolesList) {
				ChoseAdminForRoleVO afrVos = new ChoseAdminForRoleVO(r.getRoleId().toString(),r.getRoleName());
				List<TbAdmin> admins = tbAdminMapper.selectByRolesId(r.getRoleId());
				List<ChoseAdminVO> adminItem = new ArrayList();
				if(!CollectionUtils.isEmpty(admins)){
					for (TbAdmin a: admins) {
						adminItem.add(new ChoseAdminVO(a.getId().toString(),a.getFullname()));
					}
					afrVos.setChildren(adminItem);
				}
				item.add(afrVos);
				//item.add(new ChoseDeptVO(d.getId().toString(),d.getName(),adminMap.get(d.getId())));
			}
		}
		return item;
	}

	@Override
	public List<TbRoles> selRolesById(List<Long> roleIds) {
		TbRolesExample example = new TbRolesExample();
		example.setOrderByClause(" role_id asc");
		com.purchase.pojo.admin.TbRolesExample.Criteria criteria = example.createCriteria();
		criteria.andRoleIdIn(roleIds);
		List<TbRoles> list = tbRolesMapper.selectByExample(example);
		return list;
	}

	@Override
	public long seladminByDepartment(Long id) {
		return adminMapper.seladminByDepartment(id);
	}

	@Override
	public long selsupplierByArea(Long id) {
		return adminMapper.selsupplierByArea(id);
	}

	@Override
	public long selcustomersByArea(Long id) {
		return adminMapper.selcustomersByArea(id);
	}

	@Override
	public long seladminBySupplier(Long id) {
		return adminMapper.seladminBySupplier(id);
	}

	@Override
	public TbRoles getRoleList(Long roleId) {
		return tbRolesMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public boolean checkRoleIsOverRole(Long roleId) {
		if(roleId == null){
			return false;
		}
		TbRoles role = tbRolesMapper.selectByPrimaryKey(roleId);
		if(role != null && role.getIsOverRole() == 1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public TbAdmin selectByPrimaryKey(Long id) {
		TbAdmin admin=tbAdminMapper.selectByPrimaryKey(id);
		return admin;
	}

    @Override
    public List<TbAdmin> selectAdminByRoleId(Long roleId) {
        return tbAdminMapper.selectByRolesId(roleId);
    }

    ;
}
