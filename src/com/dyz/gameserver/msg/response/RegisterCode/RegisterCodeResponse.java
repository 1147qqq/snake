package com.dyz.gameserver.msg.response.RegisterCode;

import java.io.IOException;

import com.context.ConnectAPI;
import com.dyz.gameserver.commons.message.ServerResponse;

public class RegisterCodeResponse extends ServerResponse{

	public RegisterCodeResponse(int status, int  i) {
		super(status, ConnectAPI.RegisterCode_RESPONSE);
		try {
			if(status > 0) {
				output.writeUTF(String.valueOf(i));
			}
			//entireMsg();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
       	 output.close();
		}
	}
}
