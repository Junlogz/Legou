package com.zjl.legou.order.controller;

import com.legou.order.po.Order;
import com.zjl.legou.core.controller.BaseController;
import com.zjl.legou.order.config.TokenDecode;
import com.zjl.legou.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/5/21 16:51
 */
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController<IOrderService, Order> {

    @Autowired
    private TokenDecode tokenDecode;
    /**
     * 添加订单
     * @param order
     * @return
     * @throws IOException
     */
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Order order) throws IOException {
        order.setUsername(tokenDecode.getUserInfo().get("user_name"));
        service.add(order);
        return ResponseEntity.ok("添加成功");
    }

}
