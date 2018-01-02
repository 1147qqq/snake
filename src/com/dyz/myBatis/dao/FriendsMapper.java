package com.dyz.myBatis.dao;


import java.util.List;

import com.dyz.gameserver.pojo.Account;
import com.dyz.gameserver.pojo.FindUser;
import com.dyz.gameserver.pojo.PageModel;

public interface FriendsMapper {
	//关注好友 插入数据库数据
    int insertFriends(FindUser finduser);
    //通过uuid 查询此人是否被自己关注过
    FindUser selectFindUserByBefolloweruuid(FindUser finduser);
    
    //查询对应uuid人的关注好友
    List<Account> selectGetUser(PageModel pageModel);
    //查询对应uuid人的关注好友数量
    int selectGetUserNum(PageModel pageModel);
}