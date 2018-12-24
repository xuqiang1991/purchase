package com.purchase.util;

import com.purchase.pojo.admin.TbAdmin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

import java.util.Collection;


/**
 * 
 * @Desc: Shiro工具类
 * @author Mr Du
 * @createTime 2018年2月25日
 * @version: v1.0
 */
public class ShiroUtils {

	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	public static TbAdmin getUserEntity() {
		return (TbAdmin)SecurityUtils.getSubject().getPrincipal();
	}

	public static Long getUserId() {
		return getUserEntity().getId();
	}
	public static String getUserName() {
		return getUserEntity().getUsername();
	}

	public static void setSessionAttribute(Object key, Object value) {
		getSession().setAttribute(key, value);
	}

	public static Object getSessionAttribute(Object key) {
		return getSession().getAttribute(key);
	}

	public static boolean isLogin() {
		return SecurityUtils.getSubject().getPrincipal() != null;
	}

	public static void logout() {
		SecurityUtils.getSubject().logout();
	}
	
	public static String getKaptcha(String key) {
		String kaptcha = getSessionAttribute(key).toString();
		getSession().removeAttribute(key);
		return kaptcha;
	}

	/**
	 * 踢出用户
	 * @param userName
	 */
	public static void logout(String userName) {
		//处理session
		DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
		DefaultWebSessionManager sessionManager = (DefaultWebSessionManager)securityManager.getSessionManager();
		Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();//获取当前已登录的用户session列表
		for(Session session:sessions){
			//清除该用户以前登录时保存的session
			SimplePrincipalCollection simplePrincipal = (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
			if(simplePrincipal != null) {
			    TbAdmin admin = (TbAdmin) simplePrincipal.getPrimaryPrincipal();
			    if(userName.equals(admin.getUsername())){
					sessionManager.getSessionDAO().delete(session);
				}
			}
		}
	}


}
