package com.zjl.legou.item.dao;

import com.zjl.legou.core.dao.ICrudDao;
import com.zjl.legou.item.po.SpecParam;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/3/15 15:40
 */
@Repository
public interface SpecParamDao extends ICrudDao<SpecParam> {

    @Select("select * from spec_param_ where group_id_ = #{groupId}")
    public List<SpecParam> findByGroupId(Integer groupId);
}
