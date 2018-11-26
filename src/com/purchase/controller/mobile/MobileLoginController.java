package com.purchase.controller.mobile;

import com.purchase.pojo.admin.TbAdmin;
import com.purchase.service.AdminService;
import com.purchase.util.ResultUtil;
import com.purchase.util.ShiroUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * mobile端入口
 */
@Controller
@RequestMapping("mobile")
public class MobileLoginController {


    @Autowired
    private AdminService adminService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest req) {
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        req.setAttribute("admin",admin);
        return "page/mobile/index";
    }

    @RequestMapping(value = "/list")
    public String list() {
        return "page/mobile/list";
    }

    @RequestMapping(value = "/details")
    public String details() {
        return "page/mobile/details";
    }

    @RequestMapping(value = "/mobileLogin",method = RequestMethod.GET)
    public String mobileLogin(HttpServletRequest req) {
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        req.setAttribute("admin",admin);
        return "page/mobile/user/mobile_login";
    }

    @RequestMapping(value = "/mobileLogin",method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil mobileLoginPost(HttpServletRequest req, String username, String password) {
        if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            return ResultUtil.error("参数不能为空");
        }

        try{
            Subject subject = ShiroUtils.getSubject();
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

        SavedRequest request = (SavedRequest)req.getSession().getAttribute("shiroSavedRequest");
        if(request == null){
            return ResultUtil.error("系统错误");
        }
        String uri = request.getRequestURI();

        return ResultUtil.ok(uri);
    }

    @RequestMapping(value = "/forgetPassword",method = RequestMethod.GET)
    public String forgetPassword(HttpServletRequest req) {
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        req.setAttribute("admin",admin);
        return "page/mobile/user/forget_password";
    }

    @RequestMapping(value = "/forgetPassword",method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil forgetPasswordPost(String oldPassword,String newPassword) {
        TbAdmin user = (TbAdmin)SecurityUtils.getSubject().getPrincipal();
        if(user!=null){
            TbAdmin admin = adminService.login(user.getUsername(), oldPassword);
            if(admin!=null){
                admin.setPassword(newPassword);
                adminService.updAdmin1(admin);
                //修改密码后移除作用域，重新登陆
                SecurityUtils.getSubject().logout();
                return ResultUtil.ok();
            }else{
                return new ResultUtil(501,"旧密码错误，请重新填写！");
            }
        }
        return new ResultUtil(500,"请求错误！");
    }

}
