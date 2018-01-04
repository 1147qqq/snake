package com.dyz.myBatis.daoImp;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dyz.gameserver.pojo.Productflow;
import com.dyz.myBatis.dao.ProductflowMapper;

public class ProductflowDaoImpl implements ProductflowMapper{
	

	 private SqlSessionFactory sqlSessionFactory;
	 
	  public ProductflowDaoImpl(SqlSessionFactory sqlSessionFactory){
	        this.sqlSessionFactory = sqlSessionFactory;
	    }

	@Override
	public int insertProductflow(Productflow record) {
			int flag = 0;
	        SqlSession sqlSession = sqlSessionFactory.openSession();
	        ProductflowMapper mapper = null;
	        try {
	            mapper = sqlSession.getMapper(ProductflowMapper.class);
	            flag = mapper.insertProductflow(record);
	            sqlSession.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	            sqlSession.close();
	        }
	        return flag;
	    }

}
