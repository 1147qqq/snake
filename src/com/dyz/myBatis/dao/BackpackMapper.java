package com.dyz.myBatis.dao;

import java.util.List;

import com.dyz.gameserver.pojo.Backpack;
import com.dyz.gameserver.pojo.BackpackEntity;

public interface BackpackMapper {
	
	/**
	 * 通过uuid查询相关用户背包
	 * @param uuid
	 * @return
	 */
	List<Backpack> selectByUUid(int uuid);
	
	/**
	 * 给背包添加一个用户的数据
	 * @param record
	 * @return
	 */

	int insertBackpack(BackpackEntity record);
	 
	 
}
