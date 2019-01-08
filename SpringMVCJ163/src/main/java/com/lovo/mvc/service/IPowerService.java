package com.lovo.mvc.service;

import java.util.List;

import com.lovo.mvc.entity.PowerEntity;

/**
 * 角色权限接口
 * @author Administrator
 *
 */
public interface IPowerService {
     /**
      *根据角色ID获取该角色拥有的权限
      * @param roleId
      * @return
      */
	public List<PowerEntity> getListPowerByRoleId(String roleId);
	/**
	 * 获取所有权限
	 * @return
	 */
	public List<PowerEntity> getListPower();
	/**
	 * 获取角色不拥有的权限
	 * @param allList
	 * @param rolePowerList
	 * @return
	 */
	public List<PowerEntity> getUNListPowerByRoleId(List<PowerEntity> allList,List<PowerEntity> rolePowerList);
	/**
	 * 修改角色权限
	 * @param roleId 角色ID
	 * @param delPowerIdList 删除的权限ID字符串
	 * @param addPowerIdList  添加的权限ID字符串
	 */
	public void updateRolePower(String roleId,String delPowerIdList,String addPowerIdList);
	/**
	 * 查询出用户的所有权限集合
	 * @param userName
	 * @return
	 */
	public List<PowerEntity> getListPowerByuserName(String userName);
	/**
	 * 查询出不同级别的权限集合
	 * @param userName
	 * @param powerTag
	 * @return
	 */
	public List<PowerEntity> getListPowerByuserName(String userName,String powerTag);
}
