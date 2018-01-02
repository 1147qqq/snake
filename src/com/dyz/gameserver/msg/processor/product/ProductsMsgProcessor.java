package com.dyz.gameserver.msg.processor.product;

import java.util.List;

import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.msg.processor.common.INotAuthProcessor;
import com.dyz.gameserver.msg.processor.common.MsgProcessor;
import com.dyz.gameserver.msg.response.product.ProductsResponse;
import com.dyz.gameserver.pojo.AllProducts;
import com.dyz.gameserver.pojo.Products;
import com.dyz.myBatis.services.ProductsService;



/**
 * Created by kevin on 2016/8/2.
 */
public class ProductsMsgProcessor extends MsgProcessor implements INotAuthProcessor {
    @Override
    public void process(GameSession gameSession, ClientRequest request) throws Exception { 
    	List<Products> products = ProductsService.getInstance().findAllproducts();
    	AllProducts allproeucts=new AllProducts();
    	allproeucts.setProducts(products);
    	gameSession.sendMsg(new ProductsResponse(1, allproeucts));
    	
    }
}
