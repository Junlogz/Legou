package com.zjl.legou.order.dao;

import com.legou.order.po.OrderItem;
import com.zjl.legou.core.dao.ICrudDao;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/5/21 16:41
 */
public interface OrderItemDao extends ICrudDao<OrderItem> {

    @Select("select * from order_item_ where order_id_ = #{orderId}")
    public List<OrderItem> findByOrderId(Long orderId);
}
