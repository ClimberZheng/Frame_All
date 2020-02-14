package com.mapper;


import com.entity.dto.UserDetail;
import com.entity.po.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserInfoMapper {

    @Select("select * from user_info where userId = #{userId}")
    UserInfo selectByuserId(@Param("userId") Integer userid);

    // 用于 OrderMapper 中的数据关联
    @Select("select f.userId, i.userInfoId , f.uName, f.uPwd, f.statue, i.realName, i.sex, i.age, i.address, i.telNo, i.idCardNo\n" +
            "FROM fuser f , user_info i\n" +
            "WHERE f.userId = i.userId and f.userId = #{userId}")
    UserDetail selectUserDetailByUserId(@Param("f.userId") Integer userid);

    @Select("select f.userId, i.userInfoId , f.uName, f.uPwd, f.statue, i.realName, i.sex, i.age, i.address, i.telNo, i.idCardNo\n" +
            "FROM fuser f , user_info i\n" +
            "WHERE f.userId = i.userId and f.statue =  #{statue}")
    List<UserDetail> selectUserDetailByStatue(String statue);

    @Select("select f.userId, i.userInfoId , f.uName, f.uPwd, f.statue, i.realName, i.sex, i.age, i.address, i.telNo, i.idCardNo\n" +
            "FROM fuser f , user_info i\n" +
            "WHERE f.userId = i.userId and f.statue =  #{statue} and f.uName like #{uName} ")
    List<UserDetail> selectUserDetailByStatue_keyW(@Param("statue") String statue, @Param("uName") String uName);



    @Insert("insert into user_info (userId,realName, sex, age, address, telNo, idCardNo) values (#{userid},#{realname},#{sex},#{age},#{address},#{telno},#{idcardno})")
    void insert(UserDetail userDetail);

    @Update("update user_info set sex = #{sex} , age = #{age}, address = #{address}, telNo = #{telno}, idCardNo = #{idcardno} where userId = #{userid} ")
    void updateUserInfo(UserDetail userDetail);

    @Update("update user_info set realName= #{realname} , sex = #{sex} , age = #{age}, address = #{address}, telNo = #{telno}, idCardNo = #{idcardno} where userId = #{userid} ")
    void updateUserInfoAll(UserDetail userDetail);

    @Delete("delete from user_info where userId = #{userid} ")
    void deletebyUserid(@Param("userid") int userid);





//    int deleteByPrimaryKey(Integer userinfoid);
//
//
//    int insertSelective(UserInfo record);
//
//    int updateByPrimaryKeySelective(UserInfo record);
//
//    int updateByPrimaryKey(UserInfo record);
}