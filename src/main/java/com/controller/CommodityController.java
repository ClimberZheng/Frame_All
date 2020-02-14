package com.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.configuration.EnviorData;
import com.entity.po.Commodity;
import com.entity.po.FUser;
import com.services.CommodityService;
import com.utils.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/commodity")
public class CommodityController {
    private Log logger = LogFactory.getLog(CommodityController.class);


    @Autowired
    CommodityService commodityService;

    @RequestMapping("getAll")
    public String allCommodity(HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        FUser fUser = (FUser) session.getAttribute("loginUser");
        map.put("loginuser", fUser);
        List<Commodity> commodityList = commodityService.findAll();
        map.put("commitys", commodityList);
        return JSON.toJSONString(map);
    }



    @RequestMapping("getAllInfo")
    public @ResponseBody
     Map<String, Object> allCommodityInfo(HttpSession session) {
         Map<String, Object> commmTableMap = new HashMap<>();
         FUser fUser = (FUser) session.getAttribute("loginUser");
         if (null == fUser) {
             commmTableMap.put("msg", "未登录");
             return commmTableMap;
         }
         List<Commodity> commodities = commodityService.findAll();

         commmTableMap.put("code", 0);
         commmTableMap.put("msg", "ok");
         if (null != commodities) {
             commmTableMap.put("count", commodities.size());
             commmTableMap.put("data", commodities);
         }
         return commmTableMap;

    }

@RequestMapping("getCommdity/{cName}")
    public @ResponseBody
     Map<String, Object> allCommodityInfo(@PathVariable(value = "cName") String cName, HttpSession session) {
         Map<String, Object> commmTableMap = new HashMap<>();
         FUser fUser = (FUser) session.getAttribute("loginUser");
         if (null == fUser) {
             commmTableMap.put("msg", "未登录");
             return commmTableMap;
         }
         List<Commodity> commodities = commodityService.findByCname(cName);

         commmTableMap.put("code", 0);
         commmTableMap.put("msg", "ok");
         if (null != commodities) {
             commmTableMap.put("count", commodities.size());
             commmTableMap.put("data", commodities);
         }
         return commmTableMap;

    }



    // 商品图片上传
    @RequestMapping("picUpload")
    public Map<String, Object> comPicUpload(@RequestParam(value = "file", required = false) MultipartFile multipartFile,@RequestParam(value = "comid", required = false) Integer comid, HttpSession session) throws IOException {
        FUser fUser = (FUser) session.getAttribute("loginUser");
        Map<String, Object> resMap = new HashMap<>();
        String msg = "";
        if (null == fUser || null == multipartFile) {
            msg = "图片上传失败";
        } else {
            String fileType = StringUtil.getFileType(multipartFile.getOriginalFilename());
            String picName = IdUtil.randomUUID() + "." + fileType;

            String savePath = EnviorData.projectPath + EnviorData.comPicSavePath + picName;
            multipartFile.transferTo(Paths.get(savePath));

            resMap.put("path", "pic/"+picName);
            if(null!=comid){
                // 此时接收到的请求为更换商品图片的
                commodityService.modifyById(comid,"pic/"+picName);
            }
        }
        resMap.put("msg", "图片上传成功");
        return resMap;
    }


    // 商品上架
    @RequestMapping("addCommdity")
    public String addCommdity(@RequestBody Commodity commodity, HttpSession session) {
        FUser fUser = (FUser) session.getAttribute("loginUser");
        if (fUser == null) {
            return "未登录";
        }
        commodityService.saveOne(commodity);
        return "上架成功";
    }

    // 商品信息更新
    @RequestMapping("updateCommdity")
    public String ModifyCommdity(@RequestBody Commodity commodity, HttpSession session) {
        FUser fUser = (FUser) session.getAttribute("loginUser");
        if (fUser == null) {
            return "未登录";
        }
        commodityService.modifyById(commodity);
        return "修改成功";
    }

    // 商品信息更新
    @RequestMapping("removeCommdity/{comid}")
    public String removebyId(@PathVariable("comid") int comid, HttpSession session) {
        FUser fUser = (FUser) session.getAttribute("loginUser");
        if (fUser == null) {
            return "未登录";
        }
        commodityService.removeById(comid);
        return "下架成功";
    }


}
