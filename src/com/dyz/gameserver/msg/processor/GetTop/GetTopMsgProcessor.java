package com.dyz.gameserver.msg.processor.GetTop;



import java.util.List;

import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.msg.processor.common.INotAuthProcessor;
import com.dyz.gameserver.msg.processor.common.MsgProcessor;
import com.dyz.gameserver.msg.response.GetTop.GetTopResponse;
import com.dyz.gameserver.pojo.Account;
import com.dyz.myBatis.services.AccountService;

import net.sf.json.JSONObject;

public class GetTopMsgProcessor extends MsgProcessor implements INotAuthProcessor{

	@Override
	public  void process(GameSession gameSession, ClientRequest request)
			throws Exception {
		List<Account> yestadayChramnun=AccountService.getInstance().selectYesterdayCharmnumTopAccounts();
		List<Account> todayChramnun=AccountService.getInstance().selectToDayCharmnumTopAccounts();
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("ToDayCharmnumTopAccounts", todayChramnun);
		jsonObject.put("YesterdayCharmnumTopAccounts", yestadayChramnun);
		gameSession.sendMsg(new GetTopResponse(1, jsonObject.toString()));
	}

}
