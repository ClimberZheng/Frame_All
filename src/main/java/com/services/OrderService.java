package com.services;

import com.entity.dto.OrderDetail;
import com.entity.po.Order;
import com.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderMapper orderDao;

    // 订单查询 全部
    public List<OrderDetail> getAllOrder(){
        return orderDao.getAll();
    }
    //订单条件查询
    public List<OrderDetail> getOrderByOno(String ono){
        return orderDao.getByOno("%"+ono+"%");
    }



    public List<OrderDetail> getOrderByUserId(int userId){
        return orderDao.getDetailByUserId(userId);
    }



    public void saveOrder(Order order){
        orderDao.insert(order);
    }

    /**订单更新 更新内容
     *  数量-》cnum
     * 实付金额-》pay
     * 收货人
     * 收货人联系方式
     * 收货地址
     */
    public void modifyOrder(OrderDetail orderDetail){
        orderDao.updateOrder(orderDetail);
    }

    //订单删除
    public void removeOrderByOrderId(int orderId){
        orderDao.deleteOrder(orderId);
    }








}
