package com.mapper;


import com.entity.dto.OrderDetail;
import com.entity.po.Order;
import com.sun.deploy.panel.IProperty;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface OrderMapper {



    @Select("select * from `order` where userId = #{userId}  ")
    @Results({
            @Result(id=true ,column = "orderId",property = "orderid"),
            @Result(column = "oNo" , property = "ono"),
            @Result(column = "comId" , property = "commodity" ,one = @One(select = "com.mapper.CommodityMapper.getCommditybyId",fetchType = FetchType.EAGER)),
            @Result(column = "cNum" , property = "cnum" ),
            @Result(column = "pay" , property = "pay" ),
            @Result(column = "userId" , property = "userDetail" , one = @One(select = "com.mapper.UserInfoMapper.selectUserDetailByUserId")),
            @Result(column = "createTime" , property = "createtime" ),
            @Result(column = "reciveAdre" , property = "reciveadre" ),
            @Result(column = "reviceName" , property = "revicename" ),
            @Result(column = "reciveTel" , property = "recivetel" ),
    })
    List<OrderDetail> getDetailByUserId(@Param("userId") int userId);





    @Insert("insert into `order` ( oNo, comId, cNum, pay, userId, createTime, reciveAdre, reviceName, reciveTel) " +
            "value ( #{ono},#{comid},#{cnum},#{pay},#{userid},sysdate(),#{reciveadre},#{revicename},#{recivetel})")
    void insert(Order record);


    // 订单查询 全部
    @Select("select * from `order`")
    @Results({
            @Result(id=true ,column = "orderId",property = "orderid"),
            @Result(column = "oNo" , property = "ono"),
            @Result(column = "comId" , property = "commodity" ,one = @One(select = "com.mapper.CommodityMapper.getCommditybyId",fetchType = FetchType.EAGER)),
            @Result(column = "cNum" , property = "cnum" ),
            @Result(column = "pay" , property = "pay" ),
            @Result(column = "userId" , property = "userDetail" , one = @One(select = "com.mapper.UserInfoMapper.selectUserDetailByUserId")),
            @Result(column = "createTime" , property = "createtime" ),
            @Result(column = "reciveAdre" , property = "reciveadre" ),
            @Result(column = "reviceName" , property = "revicename" ),
            @Result(column = "reciveTel" , property = "recivetel" ),
    })
    List<OrderDetail> getAll();



    // 订单条件查询 参数 订单号
    @Select("select * from `order` where oNo like #{ono} ")
    @Results({
            @Result(id=true ,column = "orderId",property = "orderid"),
            @Result(column = "oNo" , property = "ono"),
            @Result(column = "comId" , property = "commodity" ,one = @One(select = "com.mapper.CommodityMapper.getCommditybyId",fetchType = FetchType.EAGER)),
            @Result(column = "cNum" , property = "cnum" ),
            @Result(column = "pay" , property = "pay" ),
            @Result(column = "userId" , property = "userDetail" , one = @One(select = "com.mapper.UserInfoMapper.selectUserDetailByUserId")),
            @Result(column = "createTime" , property = "createtime" ),
            @Result(column = "reciveAdre" , property = "reciveadre" ),
            @Result(column = "reviceName" , property = "revicename" ),
            @Result(column = "reciveTel" , property = "recivetel" ),
    })
    List<OrderDetail> getByOno(@Param("ono") String ono);

    /**订单更新 更新内容
     *  数量-》cnum
     * 实付金额-》pay
     * 收货人
     * 收货人联系方式
     * 收货地址
     */
    @Update("update `order` set cNum = #{cnum} , pay = #{pay} , reviceName = #{revicename} , reciveTel = #{recivetel} , reciveAdre = #{reciveadre} where orderId = #{orderid}")
    void updateOrder(OrderDetail orderDetail);




    // 订单删除 参数 订单 Id
    @Delete("delete from `order` where orderId = #{orderid}")
    void deleteOrder(@Param("orderid") int orderid);



}