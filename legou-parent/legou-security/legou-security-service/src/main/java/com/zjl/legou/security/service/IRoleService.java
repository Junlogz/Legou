package com.zjl.legou.security.service;

import com.zjl.legou.core.service.ICrudService;
import com.zjl.legou.security.po.Role;
import com.zjl.legou.security.po.User;

import java.util.List;

/**
 * @Title:
 * @Description: 
 *
 * @Copyright 2019 zjl - Powered By 雪松
 * @Author: zjl
 * @Date:  2019/10/9
 * @Version V1.0
 */
public interface IRoleService extends ICrudService<Role> {

    /**
     * 查询角色的用户
     * @param id
     * @return
     */
    public List<User> selectUserByRole(Long id);

}
