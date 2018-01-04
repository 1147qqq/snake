package com.dyz.myBatis.daoImp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dyz.gameserver.pojo.Backpack;
import com.dyz.gameserver.pojo.BackpackEntity;
import com.dyz.myBatis.dao.BackpackMapper;

public class BackpackDaoImpl implements BackpackMapper{
	
	 private SqlSessionFactory sqlSessionFactory;
	 
	  public BackpackDaoImpl(SqlSessionFactory sqlSessionFactory){
	        this.sqlSessionFactory = sqlSessionFactory;
	    }

	@Override
	public List<Backpack> selectByUUid(int uuid) {
		List<Backpack> result = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
        	BackpackMapper mapper = sqlSession.getMapper(BackpackMapper.class);
            result = mapper.selectByUUid(uuid);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
       return result;
	
}

	@Override
	public int insertBackpack(BackpackEntity record) {
		int flag = 0;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BackpackMapper mapper = null;
        try {
            mapper = sqlSession.getMapper(BackpackMapper.class);
            flag = mapper.insertBackpack(record);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return flag;
    }
	 
	 
}
