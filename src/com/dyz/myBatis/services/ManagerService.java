package com.dyz.myBatis.services;

import org.apache.ibatis.session.SqlSessionFactory;

import com.dyz.gameserver.pojo.Manager;
import com.dyz.myBatis.dao.ManagerMapper;
import com.dyz.myBatis.daoImp.ManagerDaoImpl;

public class ManagerService {
	
	private ManagerMapper managerMapper;
	
	private static ManagerService managerService = new ManagerService();
	
	 public static ManagerService getInstance(){
	        return managerService;
	    }

	 public void initSetSession(SqlSessionFactory sqlSessionFactory){
		 managerMapper = new ManagerDaoImpl(sqlSessionFactory);
	    }

	 /**
		 * 通过传来的码来验证是否存在
		 * @param inviteCode
		 * @return
		 */
	public	Manager selectByInviteCode(String inviteCode) {
		
		return managerMapper.selectByInviteCode(inviteCode);
	}
	

}
