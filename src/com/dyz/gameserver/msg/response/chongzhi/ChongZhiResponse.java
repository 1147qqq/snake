package com.dyz.gameserver.msg.response.chongzhi;

import java.io.IOException;

import com.context.ConnectAPI;
import com.dyz.gameserver.commons.message.ServerResponse;

public class ChongZhiResponse  extends ServerResponse{

	public ChongZhiResponse(int status, String msg) {
		super(status, ConnectAPI.CHONGZHI_RESPONSE);
		try {
			if(status > 0) {
				output.writeUTF(msg);
			}
			//entireMsg();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
       	 output.close();
		}
	}

	

}
