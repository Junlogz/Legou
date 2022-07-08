package com.zjl.legou.order.service.impl;

import com.zjl.legou.order.client.SkuClient;
import com.zjl.legou.order.client.SpuClient;
import com.legou.order.po.OrderItem;
import com.zjl.legou.order.service.CartService;
import com.zjl.legou.item.po.Sku;
import com.zjl.legou.item.po.Spu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/5/17 15:29
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private SkuClient skuFeign;

    @Autowired
    private SpuClient spuFeign;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
        public void add(Long id, Integer num, String username) {

        if(num<=0){
            //删除掉原来的商品
            redisTemplate.boundHashOps("Cart_" + username).delete(id);
            return;
        }

        //1.根据商品的SKU的ID 获取sku的数据
        Sku data = skuFeign.edit(id);

        if (data != null) {
            //2.根据sku的数据对象 获取 该SKU对应的SPU的数据
            Long spuId = data.getSpuId();
            Spu spu = spuFeign.edit(spuId);

            //3.将数据存储到 购物⻋对象(order_item)中
            OrderItem orderItem = new OrderItem();
            orderItem.setCategoryId1(spu.getCid1());
            orderItem.setCategoryId2(spu.getCid2());
            orderItem.setCategoryId3(spu.getCid3());
            orderItem.setSpuId(spu.getId());
            orderItem.setSkuId(id);
            orderItem.setName(data.getTitle());//商品的名称 sku的名称
            orderItem.setPrice(data.getPrice());//sku的单价
            orderItem.setNum(num);//购买的数量
            orderItem.setPayMoney(orderItem.getNum() * orderItem.getPrice());//单价 * 数量
            orderItem.setImage(data.getImages());//商品的图⽚dizhi

            //4.数据添加到redis中 key:⽤户名 field:sku的ID value:购物⻋数据(order_item)
            redisTemplate.boundHashOps("Cart_" + username).put(id, orderItem);

        }
    }

    @Override
    public List<OrderItem> list(String username) {
        List<OrderItem> orderItemList = redisTemplate.boundHashOps("Cart_" + username).values();
        return orderItemList;
    }
}
