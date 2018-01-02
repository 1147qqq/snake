package com.dyz.gameserver.msg.response.product;

import java.io.IOException;

import com.context.ConnectAPI;
import com.dyz.gameserver.commons.message.ServerResponse;
import com.dyz.gameserver.pojo.AllProducts;
import com.dyz.persist.util.JsonUtilTool;

import net.sf.json.JSONObject;

public class ProductsResponse extends ServerResponse{
	
	public ProductsResponse(int status, AllProducts pro) {
		super(status,ConnectAPI.GetAllShop_RESPONSE);
		try {
			//output.writeBoolean(isSuccess);
			if(status > 0) {
				System.out.println(JsonUtilTool.toJson(pro));
				output.writeUTF(JsonUtilTool.toJson(pro));
			}
			//entireMsg();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
       	 output.close();
		}
	}
	
}
