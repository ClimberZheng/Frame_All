package com.services;

import com.entity.dto.SimpleUser;
import com.entity.dto.UserDetail;
import com.entity.po.FUser;
import com.mapper.FUserMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.SimpleBeanInfo;
import java.util.List;

@Service
public class FUserService {

    private Log logger= LogFactory.getLog(FUserService.class);

    @Autowired
    FUserMapper fUserMapper;

    public FUser findUser(String userName){

        FUser fUser=this.fUserMapper.getUserByNamePwd(userName);
        return fUser;
    }

    public int getUserIdForadd(){
        return fUserMapper.getUserId();
    }

    public void saveFUser(UserDetail userDetail){
        fUserMapper.insert(userDetail);
    }

    public void resetUName(String newUserName,  int userId){
        fUserMapper.updateUName(newUserName,userId);
    }

    public void resetPwd(String pwd, String userName){
        fUserMapper.updatePwd(pwd,userName);
    }

    public void modiffyAll(UserDetail userDetail){
        fUserMapper.updateUNameAll(userDetail);
    }

    public void removeUser(int userId){
        fUserMapper.deleteById(userId);
    }




}
