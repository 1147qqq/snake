package com.dyz.persist.util;

import java.util.List;

import com.dyz.gameserver.pojo.AllProducts;
import com.dyz.gameserver.pojo.Products;
import com.dyz.myBatis.services.ProductsService;
import com.easemob.lmc.model.TalkNode;
import com.easemob.lmc.service.TalkDataService;
import com.easemob.lmc.service.TalkHttpService;
import com.easemob.lmc.service.impl.TalkDataServiceImpl;
import com.easemob.lmc.service.impl.TalkHttpServiceImplApache;

public class Test {
public static void main(String[] args) { 
	List<Products> products = ProductsService.getInstance().findAllproducts();
	AllProducts allproeucts=new AllProducts();
	allproeucts.setProducts(products);
}
}
