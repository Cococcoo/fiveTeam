package com.lovo.mvc.dao;

import org.springframework.stereotype.Repository;

import com.lovo.mvc.entity.UserRoleEntity;
@Repository(value="roleUserDao")
public class RoleUserDao extends BasicDao<UserRoleEntity>{
   /**
    * 根据角色ID删除所有角色用户
    * @param roleId
    */
	public void delRoleUserByRoleId(String roleId){
		String hql="delete from UserRoleEntity ur where ur.role.roleId=?";
		super.getCurrentSession().createQuery(hql)
		.setParameter(0, roleId).executeUpdate();
	}
	/**
	 * 根据角色ID和用户ID删除角色用户
	 * @param roleId
	 * @param userId
	 */
   public void delRoleUserByRoleId(String roleId,String userId){
	   String hql="delete from UserRoleEntity ur where ur.role.roleId=? and ur.user.userId=?";
	   super.getCurrentSession().createQuery(hql)
		.setParameter(0, roleId)
		.setParameter(1, userId)
		.executeUpdate();
	}
   
   
   
}
