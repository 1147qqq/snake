package com.dyz.myBatis.services;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import com.dyz.gameserver.pojo.Backpack;
import com.dyz.gameserver.pojo.BackpackEntity;
import com.dyz.myBatis.dao.BackpackMapper;
import com.dyz.myBatis.daoImp.BackpackDaoImpl;

public class BackpackService {
	
	private BackpackMapper backpackMapper;
	
	 private static BackpackService backpackService = new BackpackService();

	 public static BackpackService getInstance(){
	        return backpackService;
	    }

	 public void initSetSession(SqlSessionFactory sqlSessionFactory){
	    	backpackMapper = new BackpackDaoImpl(sqlSessionFactory);
	    }
	    
	 
	 public	List<Backpack> selectByUUid(int uuid){
		 try {
		return backpackMapper.selectByUUid(uuid);
		 	}catch (Exception e){
			 e.printStackTrace();
		 }
		 return null;
	}
	 
	 
	public int insertBackpack(BackpackEntity record) {
		return backpackMapper.insertBackpack(record);
		
	}
		
}
