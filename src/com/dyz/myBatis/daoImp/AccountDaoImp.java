package com.dyz.myBatis.daoImp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dyz.gameserver.pojo.Account;
import com.dyz.myBatis.dao.AccountMapper;
/**
 * Created by kevin on 2016/6/21.
 */
public class AccountDaoImp implements AccountMapper {
    private SqlSessionFactory sqlSessionFactory;
    public AccountDaoImp(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    @Override
    public int insert(Account record) {
        int flag = 0;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper mapper = null;
        try {
            mapper = sqlSession.getMapper(AccountMapper.class);
            flag = mapper.insert(record);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
             	record.setNickname(filterNickName(record.getNickname()));
             	flag = mapper.insert(record);
             	sqlSession.commit();
 			} catch (Exception e2) {
 			    e.printStackTrace();
 			    record.setNickname("???????");
 			    flag = mapper.insert(record);
             	sqlSession.commit();
 			}
        }finally {
            sqlSession.close();
        }
        return flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account
     *
     * @param record
     * @mbggenerated
     */
    @Override
    public int insertSelective(Account record) {
    	 int flag = 0;
         SqlSession sqlSession = sqlSessionFactory.openSession();
         AccountMapper mapper = null;
         try {
             mapper = sqlSession.getMapper(AccountMapper.class);
             flag = mapper.insertSelective(record);
             sqlSession.commit();
         } catch (Exception e) {
             e.printStackTrace();
             //昵称出问题
             try {
             	record.setNickname(filterNickName(record.getNickname()));
             	flag = mapper.insertSelective(record);
             	sqlSession.commit();
 			} catch (Exception e2) {
 			    e.printStackTrace();
 			    record.setNickname("???????");
 			    flag = mapper.insertSelective(record);
             	sqlSession.commit();
 			}
         }finally {
             sqlSession.close();
         }
         return flag;
    }

    @Override
    public Account selectAccount(String openid) {
    	 Account result = null;
         SqlSession sqlSession = sqlSessionFactory.openSession();
         try {
             AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
             result = mapper.selectAccount(openid);
             sqlSession.commit();
         } catch (Exception e) {
             e.printStackTrace();
         }finally {
             sqlSession.close();
         }
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account
     *
     * @param record
     * @param example
     * @mbggenerated
     */

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account
     *
     * @param record
     * @param example
     * @mbggenerated
     */

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account
     *
     * @param record
     * @mbggenerated
     */
    @Override
    public int updateByPrimaryKeySelective(Account record) {
        int flag = 0;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper mapper = null;
        try{
            mapper = sqlSession.getMapper(AccountMapper.class);
            flag = mapper.updateByPrimaryKeySelective(record);
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            //昵称出问题
            try {
            	record.setNickname(filterNickName(record.getNickname()));
            	flag = mapper.updateByPrimaryKeySelective(record);
            	sqlSession.commit();
			} catch (Exception e2) {
			    e.printStackTrace();
			    record.setNickname("???????");
			    flag = mapper.updateByPrimaryKeySelective(record);
            	sqlSession.commit();
			}
        }finally {
            sqlSession.close();
        }
        return flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account
     *
     * @param record
     * @mbggenerated
     */
    @Override
    public int updateByPrimaryKey(Account record) {
        int flag = 0;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper mapper = null;
        try {
            mapper = sqlSession.getMapper(AccountMapper.class);
            flag = mapper.updateByPrimaryKey(record);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
            	record.setNickname(filterNickName(record.getNickname()));
            	flag = mapper.updateByPrimaryKey(record);
            	sqlSession.commit();
			} catch (Exception e2) {
			    e.printStackTrace();
			    record.setNickname("???????");
			    flag = mapper.updateByPrimaryKey(record);
            	sqlSession.commit();
			}
        }finally {
            sqlSession.close();
        }
        return flag;
    }

	@Override
	public int selectMaxId() {
		 SqlSession sqlSession = sqlSessionFactory.openSession();
		 AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
		return mapper.selectMaxId();
	}

	@Override
	public List<Account> selectAllAccounts() {
		 SqlSession sqlSession = sqlSessionFactory.openSession();
		 AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
		return mapper.selectAllAccounts();
	}
	/**
	 * 
	 * @param nickname
	 * @return String
	 */
	public String filterNickName(String nickname){
		String reg = "[^\u4e00-\u9fa5]";
		nickname = nickname.replaceAll(reg, "?");
		return nickname;
	}
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Account selectByPrimaryKey(Integer id) {
   	 Account result = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
            result = mapper.selectByPrimaryKey(id);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
       return result;
	}
}