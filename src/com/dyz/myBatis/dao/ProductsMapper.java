package com.dyz.myBatis.dao;

import java.util.List;
import com.dyz.gameserver.pojo.Products;

public interface ProductsMapper {
	 List<Products>  findAllproducts();
}