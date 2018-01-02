package com.dyz.gameserver.msg.response.wordradio;

import java.io.IOException;

import com.context.ConnectAPI;
import com.dyz.gameserver.commons.message.ServerResponse;
import com.dyz.gameserver.pojo.Message;
import com.dyz.persist.util.JsonUtilTool;

import net.sf.json.JSONObject;

public class WordRadioResponseOther extends ServerResponse{
	
	public WordRadioResponseOther(int status, Message msg) {
		super(status,ConnectAPI.WORDRADIO_RESPONSE);
		try {
			//output.writeBoolean(isSuccess);
			if(status > 0) {
				//System.out.println("avatarVO   =  "+JsonUtilTool.toJson(avatarVO));
				output.writeUTF(JsonUtilTool.toJson(msg));
			}
			//entireMsg();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
       	 output.close();
		}
	}
	
}
