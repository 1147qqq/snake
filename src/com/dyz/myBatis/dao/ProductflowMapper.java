package com.dyz.myBatis.dao;

import com.dyz.gameserver.pojo.Productflow;

public interface ProductflowMapper {
	
	/**
	 * 添加一个新的商品数据
	 * @param record
	 * @return
	 */
	int insertProductflow(Productflow record);

}
