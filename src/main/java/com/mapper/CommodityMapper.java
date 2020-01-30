package com.mapper;

import com.entity.po.Commodity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CommodityMapper {

    @Select("select * from commodity")
    List<Commodity> getAll();

    @Select("select  * from commodity where comId = #{comId}")
    Commodity getCommditybyId(@Param("comId") int comId);


    @Select("select  * from commodity where cname like #{cName}")
    List<Commodity> getCommditybyCname(@Param("cName") String cName);

    // 增加一个商品
    @Insert("insert into commodity ( cname, description, price, pic) values ( #{cName}, #{description}, #{price}, #{pic})")
    void inserOne(Commodity commodity);

    // 修改商品信息商品
    @Update("update commodity set cname = #{cName}, description = #{description},  price = #{price} where comId = #{comid}")
    void updateAllById(Commodity commodity);

    // 修改商品信息商品
    @Update("update commodity  set pic =  #{pic} where comId = #{comid}")
    void updateById(@Param("comid") int comid,@Param("pic")String pic);



    // 商品下架
    @Delete("delete from commodity where comId = #{comid}")
    void deleteById(@Param(value = "comid")int comid);






}
