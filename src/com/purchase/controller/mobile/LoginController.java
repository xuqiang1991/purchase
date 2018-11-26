package com.purchase.controller.mobile;

import com.purchase.pojo.admin.TbAdmin;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * mobile端入口
 */
@Controller
@RequestMapping("mobile")
public class LoginController {

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

    @RequestMapping(value = "/mobileLogin")
    public String mobileLogin(HttpServletRequest req) {
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        req.setAttribute("admin",admin);
        return "page/mobile/user/mobile_login";
    }

    @RequestMapping(value = "/forgetPassword")
    public String forgetPassword(HttpServletRequest req) {
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        req.setAttribute("admin",admin);
        return "page/mobile/user/forget_password";
    }

}
