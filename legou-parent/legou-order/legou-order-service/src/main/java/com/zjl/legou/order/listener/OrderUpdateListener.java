package com.zjl.legou.order.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjl.legou.order.service.IOrderService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/6/29 21:41
 */
@Component
@RabbitListener(queues = "${mq.pay.queue.order}")
public class OrderUpdateListener {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitHandler
    public void handlerData(String msg) {
        //1.接收消息(有订单的ID 有transaction_id )
        Map<String, String> map = null;
        try {
            map = objectMapper.readValue(msg, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2.更新对营的订单的状态
        if (map != null) {
            if (map.get("trade_status").equals("TRADE_SUCCESS")) {
                orderService.updatePayStatus(map.get("out_trade_no"),
                        map.get("trade_no"));
            } else {
                //删除订单 ⽀付失败.....
                orderService.removeById(map.get("out_trade_no"));
            }
        }
    }

}
