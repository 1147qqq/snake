package com.dyz.gameserver.msg.response.FindUser;

import java.io.IOException;

import com.context.ConnectAPI;
import com.dyz.gameserver.commons.message.ServerResponse;
import com.dyz.gameserver.pojo.Account;
import com.dyz.persist.util.JsonUtilTool;


public class FindUserResponse extends ServerResponse{
	
	public FindUserResponse(int status, Account account) {
		super(status,ConnectAPI.FindUser_RESPONSE);
		try {
			//output.writeBoolean(isSuccess);
			if(status > 0) {
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
