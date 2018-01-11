package com.dyz.gameserver.msg.response.GetTop;

import java.io.IOException;

import com.context.ConnectAPI;
import com.dyz.gameserver.commons.message.ServerResponse;
import com.dyz.gameserver.pojo.Account;
import com.dyz.gameserver.pojo.PageModel;
import com.dyz.persist.util.JsonUtilTool;


public class GetTopResponse extends ServerResponse{
	
	public GetTopResponse(int status, String message) {
		super(status,ConnectAPI.GetCharmRank_RESPONSE);
		try {
			//output.writeBoolean(isSuccess);
			if(status > 0) {
				//System.out.println("avatarVO   =  "+JsonUtilTool.toJson(avatarVO));
				output.writeUTF(message);
			}
			//entireMsg();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
       	 output.close();
		}
	}
	
}
