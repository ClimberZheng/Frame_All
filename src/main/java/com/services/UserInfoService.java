package com.services;

import com.entity.dto.UserDetail;
import com.entity.po.UserInfo;
import com.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    public UserInfo findUserInfoByUserId(int userId) {
        return userInfoMapper.selectByuserId(userId);
    }

    public void saveUuserInfo(UserDetail userDetail) {
        userInfoMapper.insert(userDetail);
    }

    public void modifyUserInfo(UserDetail userDetail) {
        userInfoMapper.updateUserInfo(userDetail);
    }

    public void modifyUserInfoAll(UserDetail userDetail) {
        userInfoMapper.updateUserInfoAll(userDetail);
    }



    public List<UserDetail> findByStatue(String statue) {
        return userInfoMapper.selectUserDetailByStatue(statue);
    }

    public List<UserDetail> findByStatue(String statue, String  keyW) {
        return userInfoMapper.selectUserDetailByStatue_keyW(statue,"%"+keyW+"%");
    }

 public void removeUser(int userId) {
        userInfoMapper.deletebyUserid(userId);
    }




}
