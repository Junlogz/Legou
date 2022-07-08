package com.zjl.legou.order.listener;

import com.legou.order.po.Order;
import com.legou.order.po.OrderItem;
import com.zjl.legou.order.client.SkuClient;
import com.zjl.legou.order.dao.OrderItemDao;
import com.zjl.legou.order.service.IOrderService;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/6/29 21:41
 */
@Component
@RabbitListener(queues = "${mq.order.queue.dlx}")
public class OrderLazyListener {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private OrderItemDao orderItemDao;

//    @Autowired
//    private SkuClient skuClient;

    @RabbitHandler
    public void handlerData(String msg) {
        if (StringUtils.isNotEmpty(msg)) {
            Long id = Long.parseLong(msg);
            Order order = orderService.getById(id);
            order.setOrderStatus("3");
            orderService.updateById(order); //修改订单装填

            List<OrderItem> orderItems = orderItemDao.findByOrderId(id);

            //回滚库存
//            skuClient.decrCount(order.getTotalNum(),or);
        }
    }

}
