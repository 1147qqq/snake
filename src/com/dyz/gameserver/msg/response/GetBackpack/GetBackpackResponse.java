package com.dyz.gameserver.msg.response.GetBackpack;

import java.io.IOException;
import java.util.List;

import com.context.ConnectAPI;
import com.dyz.gameserver.commons.message.ServerResponse;
import com.dyz.gameserver.pojo.AllBackpack;
import com.dyz.gameserver.pojo.Backpack;
import com.dyz.persist.util.JsonUtilTool;

public class GetBackpackResponse  extends ServerResponse{

	public GetBackpackResponse(int status, AllBackpack backpacks) {
		super(status, ConnectAPI.GetByUserBackpack_RESPONSE);
		try {
			if(status > 0) {
				output.writeUTF(JsonUtilTool.toJson(backpacks));
			}
			//entireMsg();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
       	 output.close();
		}
	}

}
