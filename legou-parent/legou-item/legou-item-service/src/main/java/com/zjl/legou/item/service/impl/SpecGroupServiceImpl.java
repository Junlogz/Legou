package com.zjl.legou.item.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zjl.legou.core.service.impl.CrudServiceImpl;
import com.zjl.legou.item.dao.SpecGroupDao;
import com.zjl.legou.item.dao.SpecParamDao;
import com.zjl.legou.item.po.SpecGroup;
import com.zjl.legou.item.po.SpecParam;
import com.zjl.legou.item.service.ISpecGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/3/15 17:03
 */
@Service
public class SpecGroupServiceImpl extends CrudServiceImpl<SpecGroup> implements ISpecGroupService {

    @Autowired
    private SpecParamDao specParamDao;

    @Override
    public List<SpecGroup> list(SpecGroup entity) {
        return ((SpecGroupDao) getBaseMapper()).selectList(entity);
    }

    @Override
    @Transactional
    public void saveGroup(Long cid, List<SpecGroup> groups) {
        // 根据cid删除所有规格参数的分组
        getBaseMapper().delete(Wrappers.<SpecGroup>query().eq("cid_", cid));
        // 删除分组里面的规格参数
        specParamDao.delete(Wrappers.<SpecParam>query().eq("cid_", cid));

        // 逐个添加规格参数分组和分组里面的规格参数
        for (SpecGroup group : groups) {
            getBaseMapper().insert(group);
            for (SpecParam specParam : group.getParams()) {
                // 新增加的项有可能组为空 设置一下groupID
                specParam.setGroupId(group.getId());
                specParamDao.insert(specParam);
            }
        }
    }
}
