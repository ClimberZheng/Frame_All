package com.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {

    private Log logger = LogFactory.getLog(ShiroConfig.class);

    /**
     *anon 无需认证
     * authc 必须认证
     * user 如果使用了remenberMe ，可以直接访问
     * perms 该资源必须得到资源权限才能访问
     * role 该资源必须得到角色权限才可以访问
     *
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        logger.info("========= 开始授权 ===========");
        System.out.printf("111");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);



        // filterChainDefinitions拦截器map必须用：LinkedHashMap，因为它必须保证有序
        Map<String ,String > filterMap=new LinkedHashMap<>();

        filterMap.put("/LFitness/","anon");
        filterMap.put("/LFitness/regist","anon");
        filterMap.put("/LFitness/user/register","anon");

        filterMap.put("/LFitness/loginController/login","anon");
        filterMap.put("/LFitness/logout","anon");
        filterMap.put("/LFitness/index","anon");
        filterMap.put("/LFitness/commodity/getAll","authc");
        // /LFitness/commodity/getAll
        filterMap.put("/LFitness/js/**","anon");
        filterMap.put("/LFitness/css/**","anon");
        filterMap.put("/LFitness/img/**","anon");
        filterMap.put("/LFitness/pic/**","anon");
        filterMap.put("/LFitness/layui/**","anon");
        filterMap.put("/LFitness/util/**","anon");
//        filterMap.put("/LFitness/commodity/getAll","authc");
        filterMap.put("/LFitness/**","authc");

        // 登录请求
        shiroFilterFactoryBean.setLoginUrl("/LFitness/");
        shiroFilterFactoryBean.setSuccessUrl("/LFitness/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/LFitness/");



        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    /**
     * create securityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userealm") UserRealm userRealm) {
        logger.info("=========getDefaultWebSecurityManager===========");
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * create Realm
     *
     * @return
     */
    @Bean(name = "userealm")
    public UserRealm getRealm() {
        logger.info("=========getRealm===========");
        return new UserRealm();
    }

}
