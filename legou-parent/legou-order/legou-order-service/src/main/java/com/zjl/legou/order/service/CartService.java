package com.zjl.legou.order.service;

import com.legou.order.po.OrderItem;

import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/5/17 15:21
 */
public interface CartService {

    /**
     * 添加购物⻋
     * @param id sku的ID
     * @param num 购买的数量
     * @param username 购买的商品的⽤户名
     */
    void add(Long id, Integer num, String username);

    /**
     * 从redis中获取当前的⽤户的购物⻋的列表数据
     * @param username
     * @return
     */
    List<OrderItem> list(String username);

}
