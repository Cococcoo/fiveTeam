package com.lovo.mvc.service.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovo.mvc.dao.RoleDao;
import com.lovo.mvc.dao.RoleUserDao;
import com.lovo.mvc.entity.RoleEntity;
import com.lovo.mvc.entity.UserEntity;
import com.lovo.mvc.entity.UserRoleEntity;
import com.lovo.mvc.service.IRoleService;
@Service(value="roleService")
public class RoleServiceImpl implements IRoleService {

   @Autowired
   private RoleDao roleDao;
   @Autowired
   private RoleUserDao roleUserDao;
   
	public List<RoleEntity> getListRole() {
		
		return roleDao.findHQLList();
	}


	
	public void updateRoleUser(List<UserEntity> roleListUser, String userListId,String roleId) {
	   
		//如果userListId长度0，把现在拥有的所有用户删除
		if(null==userListId||"".equals(userListId.trim())){
				roleUserDao.delRoleUserByRoleId(roleId);
				
		}else{
			//获得界面选中的用户集合
			userListId=userListId.substring(0, userListId.length()-1);
		   String []userArray=	userListId.split(",");
		   //把数组转换为集合
	       List<String> listUserId=new ArrayList<String>();
	       for(String uid:userArray){
	    	   listUserId.add(uid);
	       }
	       
			//如果角色用户为空。传过来的数据全部添加
			if(null==roleListUser||roleListUser.isEmpty()){
				 if(null!=listUserId&&!listUserId.isEmpty()){
				       //批量添加
				       for(String userId:listUserId){

				    	   UserRoleEntity ur=new UserRoleEntity();
							RoleEntity r=new RoleEntity();
							
							r.setRoleId(roleId);
						   UserEntity user=new UserEntity();
						   user.setUserId(userId);
						   
							ur.setRole(r);//添加角色
							ur.setUser(user);//添加用户
							roleUserDao.savaObject(ur);
				       }
				      }
				
				return;
			}
			
	       //删除相同部分
	       for(int  i=0;i<listUserId.size();i++){
	    	   for(int j=0;j<roleListUser.size();j++){
	    		   if(listUserId.get(i).equals(roleListUser.get(j).getUserId())){
	    			   //同时删除
	    			   listUserId.remove(i);
	    			   roleListUser.remove(j);
	    			   i--;
	    			   break;
	    		   }
	    	   }
	       }
	       if(null!=roleListUser&&!roleListUser.isEmpty()){
	       //批量删除
	       for (UserEntity user : roleListUser) {
	    	   roleUserDao.delRoleUserByRoleId(roleId, user.getUserId());
		   }
	      }
	       if(null!=listUserId&&!listUserId.isEmpty()){
	       //批量添加
	       for(String userId:listUserId){

	    	   UserRoleEntity ur=new UserRoleEntity();
				RoleEntity r=new RoleEntity();
				
				r.setRoleId(roleId);
			   UserEntity user=new UserEntity();
			   user.setUserId(userId);
			   
				ur.setRole(r);//添加角色
				ur.setUser(user);//添加用户
				roleUserDao.savaObject(ur);
	       }
	      }
		}
		
	}

}
