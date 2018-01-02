package com.dyz.myBatis.services;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import com.dyz.gameserver.pojo.Account;
import com.dyz.gameserver.pojo.FindUser;
import com.dyz.gameserver.pojo.PageModel;
import com.dyz.gameserver.pojo.Products;
import com.dyz.myBatis.dao.ProductsMapper;
import com.dyz.myBatis.daoImp.ProductsDaoImp;

/**
 * Created by kevin on 2016/6/21.
 */
public class ProductsService {
    private ProductsMapper productMap;

    private static ProductsService accountService = new ProductsService();

    public static ProductsService getInstance(){
        return accountService;
    }

    public void initSetSession(SqlSessionFactory sqlSessionFactory){
    	productMap = new ProductsDaoImp(sqlSessionFactory);
    }
    
    public List<Products> findAllproducts(){
        return productMap.findAllproducts();
    }
}
