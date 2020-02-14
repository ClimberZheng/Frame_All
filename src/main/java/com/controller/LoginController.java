package com.controller;

import com.entity.dto.SimpleUser;
import com.services.FUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author: StevenClise
 * @Date : 2019/12/20
 **/
@RestController
@RequestMapping("/loginController")
public class LoginController {
    private Log logger = LogFactory.getLog(LoginController.class);

    @Autowired
    FUserService fUserService;


    @RequestMapping("login")
    public String login(@RequestBody SimpleUser loginUser, HttpSession session) {
        logger.debug(loginUser.toString());

        if (null != loginUser) {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(loginUser.getUsername(), loginUser.getPwd());
            try {

                subject.login(token);

                session.setAttribute("loginUser",fUserService.findUser(loginUser.getUsername()));
                return "pass";
            } catch (UnknownAccountException e) {
                return "未知账户！";
            } catch (DisabledAccountException e){
                return "账户不可用，请联系管理员！";
            } catch (AuthenticationException e){
                return "密码错误!";
            }
        }
        return "系统数据获取异常，请联系管理员";
    }


}
