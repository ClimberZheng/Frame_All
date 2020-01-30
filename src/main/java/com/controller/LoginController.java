package com.controller;

import com.entity.dto.SimpleUser;
import com.entity.dto.UserDetail;
import com.entity.po.FUser;
import com.services.FUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
            FUser fUser = fUserService.findUser(loginUser.getUsername());
            if (null != fUser && loginUser.getPwd().equals(fUser.getuPwd())) {
                session.setAttribute("loginUser",fUser);
                return "pass";
            }
        }
        return "";
    }





}
