package com.lovo.mvc.service;

import java.util.List;

import com.lovo.mvc.entity.RoleEntity;
import com.lovo.mvc.entity.UserEntity;

public interface IRoleService {
    /**
     * 查询所有角色
     * @return
     */
	public List<RoleEntity> getListRole();
	/**
	 * 更新角色用户
	 * @param roleListUser
	 * @param userListId
	 * @param roleId
	 */
	public void updateRoleUser(List<UserEntity> roleListUser,String userListId,String roleId);
}
