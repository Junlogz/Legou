package com.zjl.legou.item.service;

import com.zjl.legou.core.service.ICrudService;
import com.zjl.legou.item.po.Category;

import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/3/14 21:19
 */
public interface ICategoryService extends ICrudService<Category> {

    /**
     * 根据ids查分类名称
     * @param ids
     * @return
     */
    public List<String> selectNamesByIds(List<Long> ids);

}
