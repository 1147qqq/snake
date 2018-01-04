package com.dyz.myBatis.services;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dyz.gameserver.pojo.Account;
import com.dyz.myBatis.dao.AccountMapper;
import com.dyz.myBatis.daoImp.AccountDaoImp;
import com.dyz.persist.util.UrlUtil;

/**
 * Created by kevin on 2016/6/21.
 */
public class AccountService {
    private AccountMapper accMap;

    private static AccountService accountService = new AccountService();

    public static AccountService getInstance(){
        return accountService;
    }

    public void initSetSession(SqlSessionFactory sqlSessionFactory){
        accMap = new AccountDaoImp(sqlSessionFactory);
    }

    /**
     * 
     * @param 通过openId查询用户
     * @return account
     */
    public Account selectAccount(String openId) {
        try {
            Account accounts = accMap.selectAccount(openId);
                return accounts;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    /**
     *
     * @param account
     * @throws SQLException
     */
    public int updateByPrimaryKeySelective(Account account){
    	   int index = 0;
        try{
            index = accMap.updateByPrimaryKeySelective(account);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
		return index;
    }
    /**
     * 创建新用户
     * @param account
     * @return 插入信息表中id
     * @throws SQLException
     */
    public int createAccount(Account account) throws SQLException{
        int index = accMap.insertSelective(account);
        //System.out.println("-account insert index->>" + index);
        return index;
    }
    /**
     * 创建新用户
     * @param
     * @return 插入信息表中id
     * @throws SQLException
     */
    public int selectMaxId() throws SQLException{
        int index = accMap.selectMaxId();
        System.out.println("-account selectMaxId index->>" + index);
        return index;
    }
    
    public Account selectByPrimaryKey(Integer id) throws SQLException{
    	  try {
              Account accounts = accMap.selectByPrimaryKey(id);
                  return accounts;
          }catch (Exception e){
              e.printStackTrace();
          }
          return null;
    }
    /**
     * 
     * @param 查看排行榜
     * @return account
     */
    public List<Account> selectTopAccounts() {
        try {
        	List<Account> accounts = accMap.selectTopAccounts();
                return accounts;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
