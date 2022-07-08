package com.zjl.legou.item.dao;

import com.zjl.legou.core.dao.ICrudDao;
import com.zjl.legou.item.po.SpecGroup;

import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/3/15 15:17
 */
public interface SpecGroupDao extends ICrudDao<SpecGroup> {

    /**
     * 根据实体条件动态查询分组
     * @param specGroup
     * @return
     */
    public List<SpecGroup> selectList(SpecGroup specGroup);

}
