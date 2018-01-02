package com.dyz.gameserver.msg.response.messageBox;

import java.io.IOException;

import com.context.ConnectAPI;
import com.dyz.gameserver.commons.message.ServerResponse;
public class MessageResponseforMyself extends ServerResponse{
	
	public MessageResponseforMyself(int status, String msg) {
		super(status,ConnectAPI.MessageBoxMy_RESPONSE);
		try {
			if(status > 0) {
				output.writeUTF(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
       	 output.close();
		}
	}
	
}
