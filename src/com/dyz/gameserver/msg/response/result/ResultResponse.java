package com.dyz.gameserver.msg.response.result;

import java.io.IOException;

import com.context.ConnectAPI;
import com.dyz.gameserver.commons.message.ServerResponse;

import net.sf.json.JSONObject;

public class ResultResponse extends ServerResponse{
	
	public ResultResponse(int status, String msg) {
		super(status,ConnectAPI.Result_RESPONSE);
		try {
			//output.writeBoolean(isSuccess);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put(msg, msg);
			if(status > 0) {
				System.out.println("成绩回掉成功");
				//System.out.println("avatarVO   =  "+JsonUtilTool.toJson(avatarVO));
				output.writeUTF(jsonObject.toString());
			}
			//entireMsg();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
       	 output.close();
		}
	}
	
}
