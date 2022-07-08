package com.zjl.legou.security.controller;

import com.zjl.legou.core.controller.BaseController;
import com.zjl.legou.security.po.Role;
import com.zjl.legou.security.po.User;
import com.zjl.legou.security.service.IRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController<IRoleService, Role> {

	@Override
	public void afterEdit(Role entity) {
		//生成用户列表, 如：1,3,4
		List<User> users = service.selectUserByRole(entity.getId());
		Long[] ids = new Long[users.size()];
		for (int i=0; i< users.size(); i++) {
			ids[i] = users.get(i).getId();
		}
		entity.setUserIds(ids);
	}

}
