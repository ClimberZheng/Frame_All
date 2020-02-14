package com.security;

import com.entity.po.FUser;
import com.services.FUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    private Log logger= LogFactory.getLog(AuthorizingRealm.class);

    @Autowired
    FUserService fUserService;


    /**
     * 试行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("。。。。正在授权。。。。");

        return null;
    }

    /**
     * 执行认证逻辑
     * 如果认证成功将用户信息封装成SimpleAuthenticationInfo
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("。。。。。。。。正在认证。。。。。。。。。");
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        String userName=token.getUsername();
        FUser fuser = fUserService.findUser(userName);
        if(null==fuser){
            return null;//此时前端将出现 UnknownAccountException 的异常
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo= new SimpleAuthenticationInfo(fuser.getuName(),fuser.getuPwd(),"");
        return simpleAuthenticationInfo;
    }
}
