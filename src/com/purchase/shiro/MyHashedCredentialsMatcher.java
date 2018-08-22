package com.purchase.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

/**
 * Created by xuqiang
 * 2018/8/22.
 */
public class MyHashedCredentialsMatcher extends HashedCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

        //微信登录,不需要判断
        if(token instanceof MockToken){
            return true;
        }

        Object tokenHashedCredentials = this.hashProvidedCredentials(token, info);
        Object accountCredentials = this.getCredentials(info);
        return this.equals(tokenHashedCredentials, accountCredentials);
    }
}
