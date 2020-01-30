package com.mapper;

import com.entity.dto.UserDetail;
import com.entity.po.FUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface FUserMapper {

    @Select("select * from fuser where uName = #{uName} ")
    FUser getUserByNamePwd(@Param("uName") String uName);


    @Select("select max(userId)+1 from fuser ")
    int getUserId();

    @Select("insert into fuser ( uName, uPwd, statue) values (#{uName},#{uPwd},#{statue}) ")
    void insert(UserDetail userDetail);

    @Update("update fuser set uPwd = #{uPwd} where uName = #{uName}")
    void updatePwd(@Param("uPwd") String uPwd, @Param("uName") String uName);

    @Update("update fuser set uName = #{uName} where userId = #{userId}")
    void updateUName(@Param("uName") String uName, @Param("userId") int userId);

    @Update("update fuser set uName = #{uName} , uPwd = #{uPwd} where userId = #{userid}")
    void updateUNameAll(UserDetail detail);

    @Delete("delete from fuser where userId = #{userid}")
    void deleteById(@Param("userid") int userid);


}
