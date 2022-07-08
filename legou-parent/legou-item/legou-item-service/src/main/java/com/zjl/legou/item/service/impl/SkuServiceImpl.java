package com.zjl.legou.item.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zjl.legou.core.service.impl.CrudServiceImpl;
import com.zjl.legou.item.dao.SkuDao;
import com.zjl.legou.item.po.Sku;
import com.zjl.legou.item.service.ISkuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/3/16 18:17
 */
@Service
public class SkuServiceImpl extends CrudServiceImpl<Sku> implements ISkuService {

    @Override
    public List<Sku> list(Sku entity) {
        QueryWrapper<Sku> queryWrapper = Wrappers.<Sku>query();
        if (entity.getSpuId() != null) {
            queryWrapper.eq("spu_id_", entity.getSpuId());
        }
        return getBaseMapper().selectList(queryWrapper);
    }

    @Override
    public void decrCount(Integer num, Long skuId) {
        ((SkuDao) getBaseMapper()).decrCount(num, skuId);
    }
}
