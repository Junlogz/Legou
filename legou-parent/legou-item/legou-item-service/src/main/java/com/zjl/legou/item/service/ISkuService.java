package com.zjl.legou.item.service;

import com.zjl.legou.core.service.ICrudService;
import com.zjl.legou.item.po.Sku;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/3/16 18:14
 */
public interface ISkuService extends ICrudService<Sku> {

    /**
     * 减库存
     * @param num
     * @param skuId
     */
    public void decrCount(Integer num, Long skuId);
}
