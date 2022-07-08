package com.zjl.legou.seckill.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/7/2 20:12
 */
@Data
@TableName("seckill_order_")
public class SeckillOrder {

    @TableField("seckill_id_")
    private Long seckillId;//秒杀商品ID

    @TableField("money_")
    private String money;//⽀付⾦额

    @TableField("user_id_")
    private String userId;//⽤户

    @TableField("seller_id_")
    private String sellerId;

    @TableField("create_time_")
    private Date createTime;//创建时间

    @TableField("pay_time_")
    private Date payTime;//⽀付时间

    @TableField("status_")
    private String status;//状态，0未⽀付，1已⽀付

    @TableField("receiver_address_")
    private String receiverAddress;//收货⼈地址

    @TableField("receiver_mobile_")
    private String receiverMobile;//收货⼈电话

    @TableField("receiver_")
    private String receiver;//收货⼈

    @TableField("transaction_id_")
    private String transactionId;//交易流⽔
}
