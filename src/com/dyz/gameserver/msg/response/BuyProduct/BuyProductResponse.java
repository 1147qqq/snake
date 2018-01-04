package com.dyz.gameserver.msg.response.BuyProduct;

import java.io.IOException;

import com.dyz.gameserver.commons.message.ServerResponse;

public class BuyProductResponse  extends ServerResponse{

	public BuyProductResponse(int status, int msgCode) {
		super(status, msgCode);
		try {
			if(status > 0) {
				output.writeUTF("1");
			}
			//entireMsg();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
       	 output.close();
		}
	}

	

}
