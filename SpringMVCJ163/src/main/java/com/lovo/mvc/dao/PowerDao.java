package com.lovo.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import com.lovo.mvc.entity.PowerEntity;
@Repository(value="powerDao")
public class PowerDao extends BasicDao<PowerEntity>{
	/**
	 * 查询出用户的所有权限集合
	 * @param userName
	 * @return
	 */
	public List<PowerEntity> getListPowerByuserName(String sql,String[] args){
		Session s=super.getCurrentSession();
		NativeQuery query=	s.createNativeQuery(sql).addEntity(PowerEntity.class);
		//组装参数
		for (int i=1;i<=args.length;i++) {
			query.setParameter(i, args[i-1]);
		}
		return query.list();
	}
}
