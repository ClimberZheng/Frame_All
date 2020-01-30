package com.controller;

import com.entity.dto.UserDetail;
import com.entity.po.FUser;
import com.services.FUserService;
import com.services.UserInfoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    FUserService fUserService;


    private Log logger = LogFactory.getLog(UserController.class);

    @RequestMapping("register")
    public @ResponseBody
    String userRegist(@RequestBody UserDetail userDetail) {
        String msg = "";
        if (null != userDetail && null == fUserService.findUser(userDetail.getuName())) {
            userDetail.setUserid(fUserService.getUserIdForadd());
            fUserService.saveFUser(userDetail);
            userInfoService.saveUuserInfo(userDetail);
            msg = "注册成功";
        } else {
            msg = "注册失败";
        }
        return msg;
    }

    @RequestMapping("userNameCheck")
    public @ResponseBody
    String userNameCheck(@RequestBody String uName) {
        FUser fUser = fUserService.findUser(uName);
        String smg = null == fUser ? " " : "该用户名已经被使用";
        return smg;
    }

    @RequestMapping("updateUser")
    public @ResponseBody
    String updateUser(@RequestBody UserDetail userDetail, HttpSession session) {
        FUser fUser = (FUser) session.getAttribute("loginUser");
        if (null == fUser) {
            return "未登录";
        }
        userDetail.setUserid(fUser.getUserId());
        fUserService.resetUName(userDetail.getuName(), fUser.getUserId());
        userInfoService.modifyUserInfo(userDetail);
        return "修改成功";
    }


    @RequestMapping("resetPw+d")
    public @ResponseBody
    String pwdReset(@RequestBody String ensurePwd, HttpSession session) {
        FUser fUser = (FUser) session.getAttribute("loginUser");
        if (null == fUser) {
            return "未登录";
        }
        fUserService.resetPwd(ensurePwd, fUser.getuName());
        return "修改成功";
    }

    @RequestMapping("userManager/{statue}")
    public @ResponseBody
    Map<String, Object> systemUserMange(@PathVariable(value = "statue") String statue, HttpSession session) {
        FUser fUser = (FUser) session.getAttribute("loginUser");
        Map<String, Object> resMap = new HashMap<>();
        if (null == fUser) {
            resMap.put("msg", "未登录");
            return resMap;
        }
        if (!"M".equals(fUser.getStatue())) {
            resMap.put("msg", "当前不是管理员账户");
            return resMap;
        }
        List<UserDetail> userDetailList = userInfoService.findByStatue(statue);
        int count = 0;
        if (null != userDetailList) {
            count = userDetailList.size();
        }
        resMap.put("count", count);
        resMap.put("code",0);
        resMap.put("data", userDetailList);
        return resMap;
    }

    @RequestMapping("updateUser/sys")
    public @ResponseBody
    String updateUserSys(@RequestBody UserDetail userDetail, HttpSession session) {
        FUser fUser = (FUser) session.getAttribute("loginUser");
        if (null == fUser) {
            return "未登录";
        }
        if (!"M".equals(fUser.getStatue())) {
            return "当前不是管理员账户";
        }
        fUserService.modiffyAll(userDetail);
        userInfoService.modifyUserInfoAll(userDetail);
        return "修改成功";
    }

    @RequestMapping("userManager/{statue}/{keywords}")
    public @ResponseBody
    Map<String, Object> systemUserMangeDataFilter(@PathVariable(value = "statue") String statue,@PathVariable(value = "keywords") String keywords, HttpSession session) {
        FUser fUser = (FUser) session.getAttribute("loginUser");
        Map<String, Object> resMap = new HashMap<>();
        if (null == fUser) {
            resMap.put("msg", "未登录");
            return resMap;
        }
        if (!"M".equals(fUser.getStatue())) {
            resMap.put("msg", "当前不是管理员账户");
            return resMap;
        }
        List<UserDetail> userDetailList = userInfoService.findByStatue(statue, keywords);
        int count = 0;
        if (null != userDetailList) {
            count = userDetailList.size();
        }
        resMap.put("count", count);
        resMap.put("code",0);
        resMap.put("data", userDetailList);
        return resMap;
    }

    @RequestMapping("removeUser/{userId}")
    public @ResponseBody
    String systemUserMangeDataFilter(@PathVariable(value = "userId") int userId,HttpSession session) {
        FUser fUser = (FUser) session.getAttribute("loginUser");
        if ((null == fUser)||(!"M".equals(fUser.getStatue()))) {
            return "操作的用户权限不足";
        }
        fUserService.removeUser(userId);
        userInfoService.removeUser(userId);
        return "删除成功";
    }







}
