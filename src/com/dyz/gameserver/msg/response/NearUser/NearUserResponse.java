package com.dyz.gameserver.msg.response.NearUser;

import java.io.IOException;

import com.context.ConnectAPI;
import com.dyz.gameserver.commons.message.ServerResponse;
import com.dyz.gameserver.pojo.AllProducts;
import com.dyz.persist.util.JsonUtilTool;

import net.sf.json.JSONObject;

public class NearUserResponse extends ServerResponse{
	
	public NearUserResponse(int status, String msg) {
		super(status,ConnectAPI.NearUser_RESPONSE);
		try {
			//output.writeBoolean(isSuccess);
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
