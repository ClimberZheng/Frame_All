package com.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.entity.dto.OrderDetail;
import com.entity.po.Commodity;
import com.entity.po.FUser;
import com.entity.po.Order;
import com.services.CommodityService;
import com.services.OrderService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    private Log logger = LogFactory.getLog(OrderController.class);


    @Autowired
    OrderService orderService;

    @RequestMapping("saveOrder")
    public @ResponseBody
    String saveOrder(@RequestBody Order order, HttpSession session) {
        logger.info("ready to save one order ");
        FUser fUser = (FUser) session.getAttribute("loginUser");
        if (null == fUser) {
            return "添加失败,请先登录";
        }
        String ono = DateUtil.now() + RandomUtil.randomString(2);
        ono = ono.replace("-", "");
        ono = ono.replace(" ", "");
        ono = ono.replace(":", "");


        order.setOno(ono);
        order.setCnum("1");
        order.setUserid(fUser.getUserId());
        orderService.saveOrder(order);
        return "添加成功";
    }

    @RequestMapping("getPersonalOrder")
    public @ResponseBody
    Map<String, Object> getOrderByUserId(HttpSession session) {
        FUser fUser = (FUser) session.getAttribute("loginUser");
        Map<String, Object> orderTableMap = new HashMap<>();
        if (null == fUser) {
            orderTableMap.put("msg", "未登录");
            return orderTableMap;
        }
        List<OrderDetail> orderList = orderService.getOrderByUserId(fUser.getUserId());

        orderTableMap.put("code", 0);
        orderTableMap.put("msg", "ok");
        if (null != orderList) {
            orderTableMap.put("count", orderTableMap.size());
            orderTableMap.put("data", orderList);
        }
        return orderTableMap;
    }

    // 订单查询 全部
    @RequestMapping("getAllOrder")
    public @ResponseBody
    Map<String, Object> getAllOrder(HttpSession session) {
        FUser fUser = (FUser) session.getAttribute("loginUser");
        Map<String, Object> orderTableMap = new HashMap<>();
        if (null == fUser) {
            orderTableMap.put("msg", "未登录");
            return orderTableMap;
        }
        List<OrderDetail> orderList = orderService.getAllOrder();

        orderTableMap.put("code", 0);
        orderTableMap.put("msg", "ok");
        if (null != orderList) {
            orderTableMap.put("count", orderTableMap.size());
            orderTableMap.put("data", orderList);
        }
        return orderTableMap;
    }

    // 订单条件查询 参数 订单号
    // 订单查询 全部
    @RequestMapping("getOrder/{ono}")
    public @ResponseBody
    Map<String, Object> getOrderByOno(@PathVariable(value = "ono" ) String ono,HttpSession session) {
        FUser fUser = (FUser) session.getAttribute("loginUser");
        Map<String, Object> orderTableMap = new HashMap<>();
        if (null == fUser) {
            orderTableMap.put("msg", "未登录");
            return orderTableMap;
        }
        List<OrderDetail> orderList = orderService.getOrderByOno(ono);

        orderTableMap.put("code", 0);
        orderTableMap.put("msg", "ok");
        if (null != orderList) {
            orderTableMap.put("count", orderList.size());
            orderTableMap.put("data", orderList);
        }
        return orderTableMap;
    }

    /**订单更新 更新内容
     *  数量-》cnum
     * 实付金额-》pay
     * 收货人
     * 收货人联系方式
     * 收货地址
     */

    @RequestMapping("modifyOrder")
    public @ResponseBody
    String modifyOrder( @RequestBody OrderDetail orderDetail,HttpSession session) {
        FUser fUser = (FUser) session.getAttribute("loginUser");
        Map<String, Object> orderTableMap = new HashMap<>();
        if (null == fUser) {
            return "未登录";
        }
        orderService.modifyOrder(orderDetail);

        return "修改成功";
    }

    // 订单删除 参数 订单 Id
    @RequestMapping("removeOrder/{orderid}")
    public @ResponseBody
    String removeOrder(@PathVariable(value = "orderid" ) int orderid,HttpSession session) {
        FUser fUser = (FUser) session.getAttribute("loginUser");
        if (null == fUser) {
            return "未登录";
        }
        orderService.removeOrderByOrderId(orderid);

        return "删除成功";
    }


}
