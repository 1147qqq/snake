package com.dyz.gameserver.msg.response.Concern;

import java.io.IOException;

import com.context.ConnectAPI;
import com.dyz.gameserver.commons.message.ServerResponse;
import com.dyz.gameserver.pojo.Account;
import com.dyz.persist.util.JsonUtilTool;


public class ConcernResponse extends ServerResponse{
	
	public ConcernResponse(int status, Account account) {
		super(status,ConnectAPI.Concern_RESPONSE);
		try {
			//output.writeBoolean(isSuccess);
			if(status > 0) {
				System.out.println("关注回掉");
				//System.out.println("avatarVO   =  "+JsonUtilTool.toJson(avatarVO));
				output.writeUTF(JsonUtilTool.toJson(account));
			}
			//entireMsg();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
       	 output.close();
		}
	}
	
}
