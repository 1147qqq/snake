package com.dyz.gameserver.msg.response.Ranking;

import java.io.IOException;

import com.context.ConnectAPI;
import com.dyz.gameserver.commons.message.ServerResponse;
import com.dyz.gameserver.pojo.PageModel;
import com.dyz.persist.util.JsonUtilTool;

import net.sf.json.JSONObject;

public class RankingResponse extends ServerResponse{
	
	public RankingResponse(int status, PageModel pageModel) {
		super(status,ConnectAPI.GetPaiHang_RESPONSE);
		try {
			if(status > 0) {
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
