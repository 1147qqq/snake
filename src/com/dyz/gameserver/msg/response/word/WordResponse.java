package com.dyz.gameserver.msg.response.word;

import java.io.IOException;

import com.context.ConnectAPI;
import com.dyz.gameserver.commons.message.ServerResponse;

import net.sf.json.JSONObject;

public class WordResponse extends ServerResponse{
	
	public WordResponse(int status, String msg) {
		super(status,ConnectAPI.MyWorldChat_RESPONSE);
		try {
			//output.writeBoolean(isSuccess);
			if(status > 0) {
				//System.out.println("avatarVO   =  "+JsonUtilTool.toJson(avatarVO));
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
