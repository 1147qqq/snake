package com.dyz.gameserver.msg.response.messageBox;

import java.io.IOException;

import com.context.ConnectAPI;
import com.dyz.gameserver.commons.message.ServerResponse;
import com.dyz.gameserver.pojo.Message;
import com.dyz.persist.util.JsonUtilTool;
public class MessageResponse extends ServerResponse{
	
	public MessageResponse(int status, Message msg) {
		super(status,ConnectAPI.MessageBox_RESPONSE);
		try {
			if(status > 0) {
				output.writeUTF(JsonUtilTool.toJson(msg));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
       	 output.close();
		}
	}
	
}
