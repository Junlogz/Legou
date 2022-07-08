package com.zjl.legou.item.service;

import com.zjl.legou.core.service.ICrudService;
import com.zjl.legou.item.po.Brand;
import com.zjl.legou.item.po.Category;

import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/3/12 18:49
 */
public interface IBrandService extends ICrudService<Brand> {

    /**
     * 根据商品id查询分类
     * @param id
     * @return
     */
    public List<Category> selectCategoryByBrand(Long id);

    /**
     * 根据品牌ID集集合 得到品牌集合
     * @param ids
     * @return
     */
    public List<Brand> selectBrandByIds(List<Long> ids);
}
