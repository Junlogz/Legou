package com.zjl.legou.item.service;

import com.zjl.legou.core.service.ICrudService;
import com.zjl.legou.item.po.SpecGroup;

import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/3/15 16:12
 */
public interface ISpecGroupService extends ICrudService<SpecGroup> {

    /**
     * 根据前台传递的规格参数列表，保存规格参数
     * @param cid
     * @param groups
     */
    public void saveGroup(Long cid, List<SpecGroup> groups);
}
