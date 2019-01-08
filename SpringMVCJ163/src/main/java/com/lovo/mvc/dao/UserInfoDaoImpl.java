package com.lovo.mvc.dao;

import org.springframework.stereotype.Repository;

import com.lovo.mvc.entity.UserInfoEntity;
@Repository(value="userInfoDao")
public class UserInfoDaoImpl extends BasicDao<UserInfoEntity>{

}
