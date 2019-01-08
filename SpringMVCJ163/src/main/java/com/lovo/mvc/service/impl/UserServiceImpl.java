package com.lovo.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovo.mvc.dao.UserDaoImpl;

import com.lovo.mvc.entity.UserEntity;
import com.lovo.mvc.entity.UserInfoEntity;
import com.lovo.mvc.service.IUserService;
@Service(value="userService")
public class UserServiceImpl implements IUserService {
	@Autowired
    private UserDaoImpl userDao;

	@Override
	public List<UserEntity> getListUser() {
	
		return userDao.findHQLList();
	}
    public void  updateUserById(String id) {
    	   UserEntity t=new UserEntity();
    	   t.setUserId(id);
    	userDao.updateObject(t);
    }
  public void delUserById(String id) {
	  userDao.delObject(id);
  }
   public void regist(String userName, String password) {
	   UserEntity t=new UserEntity();
	   t.setUserName(userName);
	   t.setUserPassword(password);
	   userDao.savaObject(t);
   }


@Override
public List<UserInfoEntity> getListUserInfoByUserId(String userId) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public List<UserEntity> getListUserByRoleId(String roleId) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public List<UserEntity> getUNListUserByRole(List<UserEntity> listAll, List<UserEntity> listRoleUser) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public UserEntity  findUserById(String userId) {
	String hql="from UserEntity where userId=?";
	UserEntity user = userDao.findHQLObject(hql, new String[] {userId});
	return user;
}
@Override
public UserEntity login(String userName, String password) {
	// TODO Auto-generated method stub
	return null;
}
	
}
