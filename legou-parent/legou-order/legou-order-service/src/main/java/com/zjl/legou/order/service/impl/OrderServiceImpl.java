package com.zjl.legou.order.service.impl;

import com.legou.order.po.Order;
import com.legou.order.po.OrderItem;
import com.zjl.legou.common.utils.IdWorker;
import com.zjl.legou.core.service.impl.CrudServiceImpl;
import com.zjl.legou.order.client.SkuClient;
import com.zjl.legou.order.client.UserClient;
import com.zjl.legou.order.dao.OrderItemDao;
import com.zjl.legou.order.service.IOrderService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/5/21 16:44
 */
@Service
public class OrderServiceImpl extends CrudServiceImpl<Order> implements IOrderService {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private SkuClient skuClient;

    @Autowired
    private UserClient userClient;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Environment env;


    @Override
    public void add(Order order) {
        //添加订单表数据
        order.setId(idWorker.nextId());

        List<OrderItem> values = redisTemplate.boundHashOps("Cart_" + order.getUsername()).values();

        Long totalNum = 0l;//购买总数量
        Long totalMoney = 0l;//购买的总⾦额

        for (OrderItem orderItem : values) {
            totalNum += orderItem.getNum();//购买的数量
            totalMoney += orderItem.getPayMoney();//⾦额
            //2.添加订单选项表的数据
            orderItem.setId(idWorker.nextId());//订单选项的iD
            orderItem.setOrderId(order.getId());//订单的iD
            orderItem.setIsReturn("0");//未退货
            orderItemDao.insert(orderItem);
            //3. 减少库存 调⽤goods 微服务的 feign 减少库存
            skuClient.decrCount(orderItem.getNum(),orderItem.getSkuId());
        }

        order.setTotalNum(totalNum);//设置总数量
        order.setTotalMoney(totalMoney);//设置总⾦额
        order.setPayMoney(totalMoney);//设置实付⾦额
        order.setCreateTime(new Date());
        order.setUpdateTime(order.getCreateTime());
        order.setOrderStatus("0");//0:未完成
        order.setPayStatus("0");//未⽀付
        order.setConsignStatus("0");//未发货
        order.setIsDelete("0");//未删除

        getBaseMapper().insert(order);

        //4.增加积分 调⽤⽤户微服务的userfeign 增加积分
        userClient.addPoint(10l, order.getUsername());

        //5. 删除redis种的购物车数据
        redisTemplate.delete("Cart_" + order.getUsername());

        //6、发送延迟30分钟取消订单消息
        rabbitTemplate.convertAndSend(env.getProperty("mq.order.exchange.ttl"), env.getProperty("mq.order.routing.ttl"), order.getId().toString());
    }

    @Override
    public void updatePayStatus(String outTradeNo, String tradeNo) {
        //1.根据id 获取订单的数据
        Order order = getBaseMapper().selectById(Long.parseLong(outTradeNo));
        //2.更新
        order.setUpdateTime(new Date());
        // ⽀付的时间 从参数中获取
        order.setPayTime(new Date());
        order.setOrderStatus("1");
        order.setPayStatus("1");
        order.setTransactionId(tradeNo);
        //3.更新到数据库
        getBaseMapper().updateById(order);
    }
}
