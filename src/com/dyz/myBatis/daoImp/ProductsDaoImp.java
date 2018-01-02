package com.dyz.myBatis.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dyz.gameserver.pojo.Account;
import com.dyz.gameserver.pojo.FindUser;
import com.dyz.gameserver.pojo.PageModel;
import com.dyz.gameserver.pojo.Products;
import com.dyz.myBatis.dao.AccountMapper;
import com.dyz.myBatis.dao.FriendsMapper;
import com.dyz.myBatis.dao.ProductsMapper;
/**
 * Created by kevin on 2016/6/21.
 */
public class ProductsDaoImp implements ProductsMapper {
    private SqlSessionFactory sqlSessionFactory;
    public ProductsDaoImp(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
	@Override
	public List<Products> findAllproducts() {
		List<Products> products = new ArrayList<>();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductsMapper mapper = null;
        try {
            mapper = sqlSession.getMapper(ProductsMapper.class);
            products = mapper.findAllproducts();
            sqlSession.commit();
        } catch (Exception e) {
        	 e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return products;
	}
}
