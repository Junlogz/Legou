package com.zjl.legou.item.service;

import com.zjl.legou.core.service.ICrudService;
import com.zjl.legou.item.po.Spu;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/3/16 18:22
 */
public interface ISpuService extends ICrudService<Spu> {

    /**
     * 保存spu，包括如下表的数据
     * spu
     * spuDetail
     * skus
     * @param spu
     */
    public void saveSpu(Spu spu);
}
