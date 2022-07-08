package com.zjl.legou.order.service;

import com.legou.order.po.Order;
import com.zjl.legou.core.service.ICrudService;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/5/21 16:42
 */
public interface IOrderService extends ICrudService<Order> {

    /**
     * 增加订单
     * @param order
     */
    public void add(Order order);

    /**
     * 修改订单已支付状态
     * @param outTradeNo
     * @param tradeNo
     */
    public void updatePayStatus(String outTradeNo, String tradeNo);

}
