package com.zjl.legou.item.dao;

import com.zjl.legou.core.dao.ICrudDao;
import com.zjl.legou.item.po.Brand;
import com.zjl.legou.item.po.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/3/12 18:31
 */
public interface BrandDao extends ICrudDao<Brand> {

    /**
     * 删除商品和分类关联
     * @param id
     * @return
     */
    public int deleteCategoryByBrand(Long id);

    /**
     * 关联商品和分类
     * @param categoryId
     * @param brandId
     * @return
     */
    public int insertCategoryAndBrand(@Param("categoryId") Long categoryId,
                                      @Param("brandId") Long brandId);

    /**
     * 查询商品的分类
     * @param id
     * @return
     */
    public List<Category> selectCategoryByBrand(Long id);
}
