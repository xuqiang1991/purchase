package com.purchase.controller;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/auth")
    public void auth(HttpServletRequest request, HttpServletResponse response){
        String host = request.getHeader("host");
        String url = "http://"+host+"/sys/wx/auth/jump";
        try {
            String scope = "snsapi_base";
            url = wxMpService.oauth2buildAuthorizationUrl(url, scope, "ceshi");
            response.sendRedirect(url);
        } catch (IOException e) {
            logger.error("gotoPreAuthUrl", e);
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/auth/jump")
    @ResponseBody
    public String jump(@RequestParam("code") String code){
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken;
        String openId = null;
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
            openId = wxMpOAuth2AccessToken.getOpenId();
        } catch (WxErrorException e) {
            logger.error("gotoPreAuthUrl", e);
            throw new RuntimeException(e);
        }
        return null;
    }
}
