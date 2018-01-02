package com.dyz.myBatis.daoImp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dyz.gameserver.pojo.Account;
import com.dyz.gameserver.pojo.FindUser;
import com.dyz.gameserver.pojo.PageModel;
import com.dyz.myBatis.dao.AccountMapper;
import com.dyz.myBatis.dao.FriendsMapper;
/**
 * Created by kevin on 2016/6/21.
 */
public class FindUserDaoImp implements FriendsMapper {
    private SqlSessionFactory sqlSessionFactory;
    public FindUserDaoImp(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    @Override
    public int insertFriends(FindUser finduser) {
        int flag = 0;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        FriendsMapper mapper = null;
        try {
            mapper = sqlSession.getMapper(FriendsMapper.class);
            flag = mapper.insertFriends(finduser);
            sqlSession.commit();
        } catch (Exception e) {
        	 e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return flag;
    }
	@Override
	public FindUser selectFindUserByBefolloweruuid(FindUser finduser) {
		FindUser findUser = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        FriendsMapper mapper = null;
        try {
            mapper = sqlSession.getMapper(FriendsMapper.class);
            findUser = mapper.selectFindUserByBefolloweruuid(finduser);
            sqlSession.commit();
        } catch (Exception e) {
        	 e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return findUser;
    }
	@Override
	public List<Account> selectGetUser(PageModel pageModel) {

		List<Account> findUser = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        FriendsMapper mapper = null;
        try {
            mapper = sqlSession.getMapper(FriendsMapper.class);
            findUser = mapper.selectGetUser(pageModel);
            sqlSession.commit();
        } catch (Exception e) {
        	 e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return findUser;
    
	}
	@Override
	public int selectGetUserNum(PageModel pageModel) {

		int findUser = 0;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        FriendsMapper mapper = null;
        try {
            mapper = sqlSession.getMapper(FriendsMapper.class);
            findUser = mapper.selectGetUserNum(pageModel);
            sqlSession.commit();
        } catch (Exception e) {
        	 e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return findUser;
    
	}
}
