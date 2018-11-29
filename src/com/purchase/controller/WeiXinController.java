package com.purchase.controller;

import com.google.gson.Gson;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.service.AdminService;
import com.purchase.shiro.MockToken;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.web.util.SavedRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 微信授权（获取用户openId）
 * Created by xuqiang
 * 2018/8/10.
 */
@Controller
@RequestMapping("sys/wx")
public class WeiXinController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private AdminService adminService;

    @RequestMapping("/auth")
    public void auth(HttpServletRequest request, HttpServletResponse response){
        String host = request.getHeader("host");
        String url = "http://"+host+"/sys/wx/auth/jump";
        try {
            String scope = "snsapi_userinfo";
            url = wxMpService.oauth2buildAuthorizationUrl(url, scope, "ceshi");
            response.sendRedirect(url);
        } catch (IOException e) {
            logger.error("gotoPreAuthUrl", e);
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/auth/jump")
    public String jump(HttpServletRequest req,Model model,@RequestParam("code") String code){
        Gson gson = new Gson();
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken;
        String openId = null;
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
            openId = wxMpOAuth2AccessToken.getOpenId();
            logger.info("openId:" + openId);
            WxMpUser user = wxMpService.getUserService().userInfo(openId);

            TbAdmin admin = adminService.wxLogin(user);
            if(admin == null){
                logger.info("没有绑定账号   openId：" + openId + ", nick:" + user.getNickname());
                model.addAttribute("msg","请找管理员绑定微信！");
                return "active";
            }else {
                Integer isOnjob = admin.getIsOnJob();
                if(isOnjob != 1){
                    logger.info("账号已失效：" + openId + ", nick:" + user.getNickname());
                    model.addAttribute("msg","账号已失效！");
                    return "active";
                }
            }

            login(admin);

            //登录成功跳转处理
            String json = gson.toJson(user);
            logger.info("user:" + json);

            SavedRequest request = (SavedRequest)req.getSession().getAttribute("shiroSavedRequest");
            if(request != null){
                String uri = request.getRequestURI();
                return "redirect:" + uri;
            }else {
                return "redirect:/mobile/purchase/list";
            }
            //return "redirect:/mobile/login";
        } catch (WxErrorException e) {
            logger.error("gotoPreAuthUrl", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 微信登录
     */
    private void login(TbAdmin user){
        //获取SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory();
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        MockToken token = new MockToken();
        token.setRememberMe(true);
        token.setUsername(user.getUsername());
        token.setPassword(user.getPassword().toCharArray());
        try{
            subject.login(token);
        }catch (AuthenticationException e){
            token.clear();
        }
    }

}
