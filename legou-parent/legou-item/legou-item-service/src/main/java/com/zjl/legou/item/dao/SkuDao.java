package com.zjl.legou.item.dao;

import com.zjl.legou.core.dao.ICrudDao;
import com.zjl.legou.item.po.Sku;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/3/16 17:43
 */
public interface SkuDao extends ICrudDao<Sku> {

    @Select("select * from sku_ where spu_id_ = #{skuId}")
    public List<Sku> findBySkuId(Integer skuId);

    @Update(value="update sku_ set stock_ = stock_ - #{num} where id_ =#{skuId} and stock_ >= #{num}")
    public int decrCount(@Param("num") Integer num, @Param("skuId") Long skuId);
}
