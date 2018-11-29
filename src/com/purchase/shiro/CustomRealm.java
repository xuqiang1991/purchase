package com.purchase.shiro;

import com.purchase.mapper.admin.AdminMenusMapper;
import com.purchase.mapper.admin.TbAdminMapper;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbAdminExample;
import com.purchase.pojo.admin.TbAdminExample.Criteria;
import com.purchase.pojo.admin.TbMenus;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * 
 * @Desc: 自定义Realm
 * @author Mr Du
 * @createTime 2018年2月25日
 * @version: v1.0
 */
public class CustomRealm extends AuthorizingRealm {
	@Autowired
	private TbAdminMapper tbAdminMapper;
	@Autowired
	private AdminMenusMapper adminMenusMapper;
	
	private static Logger logger=LoggerFactory.getLogger(CustomRealm.class);

	public CustomRealm() {
		logger.info("CustomRealm====================");
	}

	@Override
	public String getName() {
		return "CustomRealm";
	}

	/**
	 * realm授权方法 从输入参数principalCollection得到身份信息 根据身份信息到数据库查找权限信息 将权限信息添加给授权信息对象
	 * 返回 授权信息对象(判断用户访问url是否在权限信息中没有体现)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		TbAdmin admin = (TbAdmin) principalCollection.getPrimaryPrincipal();
		List<Long> roleId = admin.getRoleId();

		List<String> permsList = null;

		// 系统管理员，拥有最高权限
		List<TbMenus> menuList = adminMenusMapper.getMenus(roleId);
		permsList = new ArrayList<>(menuList.size());
		for (TbMenus menu : menuList) {
			if (menu.getPerms() != null && !"".equals(menu.getPerms())) {
				permsList.add(menu.getPerms());
			}
		}

		// 用户权限列表
		Set<String> permsSet = new HashSet<String>();
		for (String perms : permsList) {
			if (StringUtils.isBlank(perms)) {
				continue;
			}
			permsSet.addAll(Arrays.asList(perms.trim().split(",")));
		}

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(permsSet);
		return info;
	}

	/**
	 * 表单认证过滤器认证时会调用自定义Realm的认证方法进行认证，成功回到index.do，再跳转到index.jsp页面
	 *
	 * 前提：表单认证过滤器收集和组织用户名和密码信息封装为token对象传递给此方法
	 *
	 * token:封装了身份信息和凭证信息 2步骤：比对身份 信息；比对凭证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		//若为微信用户token
		if(token instanceof MockToken){
			String username = (String) token.getPrincipal();
			TbAdmin admin = selAdmin(username);
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(admin,token.getCredentials(),getName());
			return info;
		}


		String username = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());

		TbAdmin admin = selAdmin(username);
		password = new Md5Hash(password).toString();
		// 密码错误
		if (!password.equals(admin.getPassword())) {
			throw new IncorrectCredentialsException("账号或密码不正确!");
		}

		// 账号未分配角色
		if (CollectionUtils.isEmpty(admin.getRoleId())) {
			throw new UnknownAccountException("账号未分配角色!");
		}

		// 账号已失效
		if (admin.getIsOnJob() != 1) {
			throw new UnknownAccountException("账号已失效!");
		}

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(admin, password, getName());
		return info;
	}

	@Override
	public boolean supports(AuthenticationToken token) {

		return token instanceof UsernamePasswordToken || token instanceof MockToken;
	}


	/**
	 * 查询用户
	 * @param userName
	 * @return
	 */
	private TbAdmin selAdmin(String userName){
		// 查询用户信息
		TbAdminExample example = new TbAdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(userName);
		List<TbAdmin> admins = null;
		try {
			admins = tbAdminMapper.selectByExampleExt(example);
		} catch (Exception e) {
			logger.error("selAdmin",e);
		}

		if( CollectionUtils.isEmpty(admins)){
			throw new UnknownAccountException("账号不存在!");
		}

		return admins.get(0);
	}
}
