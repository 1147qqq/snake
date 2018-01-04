package com.dyz.myBatis.services;

import org.apache.ibatis.session.SqlSessionFactory;

import com.dyz.gameserver.pojo.Productflow;
import com.dyz.myBatis.dao.ProductflowMapper;
import com.dyz.myBatis.daoImp.ProductflowDaoImpl;

public class ProductflowService {
	
	private ProductflowMapper productflowMapper;
	
	private static ProductflowService productflowService = new ProductflowService();

	public static ProductflowService getInstance() {
		return productflowService;
	}
	
	 public void initSetSession(SqlSessionFactory sqlSessionFactory){
		 productflowMapper = new ProductflowDaoImpl(sqlSessionFactory);
	    }
	 
	 
	public int insertProductflow(Productflow record) {
		return productflowMapper.insertProductflow(record);
	}

}
