package com.lovo.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovo.mvc.dao.PowerDao;
import com.lovo.mvc.dao.RolePowerDao;
import com.lovo.mvc.entity.PowerEntity;
import com.lovo.mvc.entity.RoleEntity;
import com.lovo.mvc.entity.RolePowerEntity;
import com.lovo.mvc.service.IPowerService;
@Service(value="powerService")
public class PowerServiceImpl  implements IPowerService {
    @Autowired
	private PowerDao powerDao;
    @Autowired
	private RolePowerDao rolePowerDao;
	public List<PowerEntity> getListPowerByRoleId(String roleId) {
		String hql="select p from RolePowerEntity rp left join rp.power p where rp.role.roleId=?";
		return	powerDao.findHQLList(hql,new String[]{roleId});
	}

	
	public List<PowerEntity> getListPower() {
		
		return powerDao.findHQLList();
	}

	
	public List<PowerEntity> getUNListPowerByRoleId(List<PowerEntity> allList, List<PowerEntity> rolePowerList) {
	  //角色拥有的权限为空就直接返回所有权限
		if(null==rolePowerList||rolePowerList.isEmpty()){
			return allList;
		}else{
			for(int i=0;i<rolePowerList.size();i++){
				//获取的角色拥有的权限ID
				String rolePowerId=rolePowerList.get(i).getPowerId();
				for(int j=0;j<allList.size();j++){
					String powerId=allList.get(j).getPowerId();
					//如果相同就删除
					if(rolePowerId.equals(powerId)){
						allList.remove(j);
						i--;
						break;
					}
				}
			}
		}
		return allList;
	}



	public void updateRolePower(String roleId, String delPowerIdList, String addPowerIdList) {
		//删除
		if(delPowerIdList.length()>1){
			String [] delPowerIdArray=delPowerIdList.substring(0,delPowerIdList.length()-1).split(",");
			String hql="delete RolePowerEntity rp where rp.role.roleId=? and rp.power.powerId=? ";
			//批量删除
			for (String powerId : delPowerIdArray) {
				rolePowerDao.updateHQL(hql, new Object[]{roleId,powerId});
			}
			
		}
		//添加
		if(addPowerIdList.length()>1){
			String [] addPowerIdArray=addPowerIdList.substring(0,addPowerIdList.length()-1).split(",");
			
			RoleEntity r=new RoleEntity();		
			r.setRoleId(roleId);
			
			for (String powerId : addPowerIdArray) {
				//维护对象的关系
				RolePowerEntity rp=new RolePowerEntity();
				rp.setRole(r);
				PowerEntity p=new PowerEntity();
				p.setPowerId(powerId);
				rp.setPower(p);
				
				rolePowerDao.savaObject(rp);
			}
			
		}
	}


	@Override
	public List<PowerEntity> getListPowerByuserName(String userName) {
		StringBuffer sbf=new StringBuffer();
		sbf.append("select p.* from sys_user u LEFT JOIN sys_user_role ur on ur.user_id=u.user_id ");
		sbf.append(" LEFT JOIN  sys_role r on ur.role_id=r.role_id ");
		sbf.append(" LEFT JOIN sys_role_power rp on rp.role_id=r.role_id ");
		sbf.append(" LEFT JOIN sys_power p on p.power_id=rp.power_id ");
		sbf.append(" where u.user_name=? ");
		
		return powerDao.getListPowerByuserName(sbf.toString(), new String[]{userName});
	}


	@Override
	public List<PowerEntity> getListPowerByuserName(String userName, String powerTag) {
		StringBuffer sbf=new StringBuffer();
		sbf.append("select p.* from sys_user u LEFT JOIN sys_user_role ur on ur.user_id=u.user_id ");
		sbf.append(" LEFT JOIN  sys_role r on ur.role_id=r.role_id ");
		sbf.append(" LEFT JOIN sys_role_power rp on rp.role_id=r.role_id ");
		sbf.append(" LEFT JOIN sys_power p on p.power_id=rp.power_id ");
		sbf.append(" where u.user_name=? and p.power_tag=? ");
		return powerDao.getListPowerByuserName(sbf.toString(), new String[]{userName,powerTag});
	}

}
