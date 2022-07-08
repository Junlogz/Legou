package com.zjl.legou.security.dao;

import com.zjl.legou.core.dao.ICrudDao;
import com.zjl.legou.security.po.Role;
import com.zjl.legou.security.po.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

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
public interface UserDao extends ICrudDao<User> {

	/**
	 * 删除用户角色关联
	 * @param id
	 * @return
	 */
	public int deleteRoleByUser(Long id);

	/**
	 * 关联用户角色
	 * @param roleId
	 * @param userId
	 * @return
	 */
	public int insertRoleAndUser(@Param("roleId") Long roleId, @Param("userId") Long userId);

	/**
	 * 查询用户的角色
	 * @param id
	 * @return
	 */
	public List<Role> selectRoleByUser(Long id);


	/**
	 * 增加积分
	 * @param point
	 * @param userName
	 * @return
	 */
	@Update(value="update user_ set point_ = point_ + #{point} where user_name_ =#{userName}")
	public int addPoint(@Param(value="point") Long point,@Param(value="userName") String userName);
}
