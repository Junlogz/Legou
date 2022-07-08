package com.zjl.legou.item.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zjl.legou.core.service.impl.CrudServiceImpl;
import com.zjl.legou.item.po.Sku;
import com.zjl.legou.item.po.Spu;
import com.zjl.legou.item.service.ISkuService;
import com.zjl.legou.item.service.ISpuDetailService;
import com.zjl.legou.item.service.ISpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/3/16 18:22
 */
@Service
public class SpuServiceImpl extends CrudServiceImpl<Spu> implements ISpuService {

    @Autowired
    private ISpuDetailService spuDetailService;
    @Autowired
    private ISkuService skuService;


    @Override
    @Transactional
    public void saveSpu(Spu spu) {
        // 保存Spu
        this.saveOrUpdate(spu);
        // 保存SpuDetail
        if (null == spu.getSpuDetail().getId()) { // 如果为空就是添加 需要先设置id
            // 拿的是spu的id 因为是1 1 对应的 不是自增的
            spu.getSpuDetail().setId(spu.getId());
            spuDetailService.save(spu.getSpuDetail());
        } else {
            // 如果是修改就直接用mbplus内置修改方法 因为有id不需要设置 直接根据id修改
            spuDetailService.updateById(spu.getSpuDetail());
        }

        // 保存sku
        // 先删除所有spu的sku
        skuService.remove(Wrappers.<Sku>query().eq("spu_id_", spu.getId()));
        // 添加新的sku
        for (Sku skus : spu.getSkus()) {
            skus.setSpuId(spu.getId());
            skuService.save(skus);
        }
    }
}
