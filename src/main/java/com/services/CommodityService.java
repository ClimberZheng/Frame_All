package com.services;

import com.entity.po.Commodity;
import com.mapper.CommodityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityService {

    @Autowired
    CommodityMapper commodityMapper;


    public List<Commodity> findAll(){
        return commodityMapper.getAll();
    }

    public List<Commodity> findByCname(String cname){
        return commodityMapper.getCommditybyCname("%"+cname+"%");
    }

    public Commodity findBycomId(int comId){
        return commodityMapper.getCommditybyId(comId);
    }




    public void saveOne(Commodity commodity){
        commodityMapper.inserOne(commodity);
    }

    public void modifyById(Commodity commodity){
        commodityMapper.updateAllById(commodity);
    }

    public void modifyById(int comid,String pic){
        commodityMapper.updateById(comid,pic);
    }



    public void removeById(int comId){
        commodityMapper.deleteById(comId);
    }





}
