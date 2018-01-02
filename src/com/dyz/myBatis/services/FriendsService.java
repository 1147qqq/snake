package com.dyz.myBatis.services;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dyz.gameserver.pojo.Account;
import com.dyz.gameserver.pojo.FindUser;
import com.dyz.gameserver.pojo.PageModel;
import com.dyz.myBatis.dao.AccountMapper;
import com.dyz.myBatis.dao.FriendsMapper;
import com.dyz.myBatis.daoImp.AccountDaoImp;
import com.dyz.myBatis.daoImp.FindUserDaoImp;

/**
 * Created by kevin on 2016/6/21.
 */
public class FriendsService {
    private FriendsMapper friendMap;

    private static FriendsService accountService = new FriendsService();

    public static FriendsService getInstance(){
        return accountService;
    }

    public void initSetSession(SqlSessionFactory sqlSessionFactory){
    	friendMap = new FindUserDaoImp(sqlSessionFactory);
    }
    
    public FindUser selectFindUserByBefolloweruuid(FindUser finduser){
        return friendMap.selectFindUserByBefolloweruuid(finduser);
    }

    /**
     * 创建新数据
     * @param FindUser
     * @return 
     * @throws SQLException
     */
    public void createFindUser(FindUser finduser) throws SQLException{
        friendMap.insertFriends(finduser);
    }
    
    
   /**
    * 查询对应人的好友
    * @param pageModel
    * @return
    */
    public  List<Account> selectGetUser(PageModel pageModel){
    	return friendMap.selectGetUser(pageModel);
    }
    
    
    /**
     * 查询对应人的好友数量
     * @param pageModel
     * @return
     */
     public  int selectGetUserNum(PageModel pageModel){
     	return friendMap.selectGetUserNum(pageModel);
     }
    
}
