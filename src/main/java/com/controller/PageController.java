package com.controller;

import cn.hutool.db.Page;
import com.entity.po.Commodity;
import com.entity.po.FUser;
import com.mapper.CommodityMapper;
import com.services.CommodityService;
import com.services.UserInfoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: StevenClise
 * @Date : 2019/11/25
 **/
@Controller
public class PageController {
    private Log log= LogFactory.getLog(PageController.class);

//    @Autowired
//    CommodityMapper commodityMapper;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    CommodityService commodityService;

    @RequestMapping("/")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("index")
    public String indexPage() {
        return "index";
    }

    @RequestMapping("regist")
    public String registPage() {
        return "regist";
    }

    @RequestMapping("manage")
    public String managePage() {
        return "manage";
    }

    @RequestMapping("logout")
    public String logoutPage(HttpSession session) {
        session.removeAttribute("loginUser");
        return "login";
    }

    @RequestMapping("personalMes")
    public ModelAndView welcomePage(HttpSession session) {
        ModelAndView modelAndView=new ModelAndView("personalMes");
        FUser fUser=(FUser) session.getAttribute("loginUser");
        if (null!=fUser){
            modelAndView.addObject("userInfo", userInfoService.findUserInfoByUserId(fUser.getUserId()));
            modelAndView.addObject("fUser", fUser);

        }
        return modelAndView;
    }



    @RequestMapping(method = RequestMethod.GET,value = "details/{comid}")
    public ModelAndView detailsPage(@PathVariable(value = "comid") Integer comid) {
        ModelAndView modelAndView=new ModelAndView("details");
        Commodity commodity=commodityService.findBycomId(comid);
        if (null==commodity){
            modelAndView.addObject("error","未能获取相关商品信息");
        }else {
            modelAndView.addObject("commodity",commodity);
        }
        return modelAndView;
    }

    @RequestMapping("changeComPic/{comId}")
    public ModelAndView getComById(@PathVariable(value ="comId" )Integer comId , HttpSession session) {
        ModelAndView modelAndView=new ModelAndView("changeCommPic");
        FUser fUser = (FUser) session.getAttribute("loginUser");
        String msg="";
        if(null==fUser){
            msg = "未登录";
        }
        if(null==comId){
            msg = "未获取到信息";
        }
        Commodity commodity=commodityService.findBycomId(comId);
        if(null==commodity){
            msg = "未获取到信息";
        }else {
            modelAndView.addObject("data",commodity);

        }
        modelAndView.addObject("msg",msg);
        return modelAndView;

    }






}





