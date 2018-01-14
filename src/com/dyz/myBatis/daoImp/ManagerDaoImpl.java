package com.dyz.myBatis.daoImp;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dyz.gameserver.pojo.Manager;
import com.dyz.myBatis.dao.ManagerMapper;

public class ManagerDaoImpl implements ManagerMapper{
	
	 private SqlSessionFactory sqlSessionFactory;
	 public ManagerDaoImpl(SqlSessionFactory sqlSessionFactory){
	        this.sqlSessionFactory = sqlSessionFactory;
	    }

	@Override
	public Manager selectByInviteCode(String inviteCode) {
		Manager manager = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ManagerMapper mapper = null;
        try {
            mapper = sqlSession.getMapper(ManagerMapper.class);
            manager = mapper.selectByInviteCode(inviteCode);
            sqlSession.commit();
        } catch (Exception e) {
        	 e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return manager;
    }

}
