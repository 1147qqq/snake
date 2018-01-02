package com.dyz.gameserver.msg.response.GetFirent;

import java.io.IOException;

import com.context.ConnectAPI;
import com.dyz.gameserver.commons.message.ServerResponse;
import com.dyz.gameserver.pojo.Account;
import com.dyz.gameserver.pojo.PageModel;
import com.dyz.persist.util.JsonUtilTool;


public class GetFirentrResponse extends ServerResponse{
	
	public GetFirentrResponse(int status, PageModel pageModel) {
		super(status,ConnectAPI.GetFirent_RESPONSE);
		try {
			//output.writeBoolean(isSuccess);
			if(status > 0) {
				//System.out.println("avatarVO   =  "+JsonUtilTool.toJson(avatarVO));
				output.writeUTF(JsonUtilTool.toJson(pageModel));
			}
			//entireMsg();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
       	 output.close();
		}
	}
	
}
