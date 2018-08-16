package com.purchase.controller.mobile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * mobile端入口
 */
@Controller
@RequestMapping("mobile")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/login")
    public String login() {
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

}
