package com.lovo.mvc.dao;

import org.springframework.stereotype.Repository;

import com.lovo.mvc.entity.UserEntity;
@Repository(value="userDao")
public class UserDaoImpl extends BasicDao<UserEntity>{

}
