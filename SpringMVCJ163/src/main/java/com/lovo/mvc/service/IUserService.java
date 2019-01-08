package com.lovo.mvc.service;

import java.util.List;

import com.lovo.mvc.entity.UserEntity;
import com.lovo.mvc.entity.UserInfoEntity;

public interface IUserService {
    /**
     * 获取所用用户
     * @return
     */
	public List<UserEntity> getListUser();
	/**
	 * 根据用户ID获取用户详细信息
	 * @param userId
	 * @return
	 */
	public List<UserInfoEntity> getListUserInfoByUserId(String userId);
	/**
	 * 根据角色ID查询该角色拥有的用户集合
	 * @param roleId
	 * @return
	 */
	public List<UserEntity> getListUserByRoleId(String roleId);
	/**
	 * 获取角色不拥有的用户
	 * @param listAll
	 * @param listRoleUser
	 * @return
	 */
	public List<UserEntity> getUNListUserByRole(List<UserEntity> listAll,List<UserEntity> listRoleUser);
	/**
	 * 登录，
	 * @param userName
	 * @param password
	 * @return 用户对象
	 */
	public UserEntity login(String userName,String password);
	
	 public void regist(String userName, String password) ;
	 
	 public void delUserById(String id);
	 
	 public void  updateUserById(String id);
	public UserEntity findUserById(String userId);
	
}
