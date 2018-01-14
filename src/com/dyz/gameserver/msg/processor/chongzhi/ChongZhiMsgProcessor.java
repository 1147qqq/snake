package com.dyz.gameserver.msg.processor.chongzhi;

import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.manager.GameSessionManager;
import com.dyz.gameserver.msg.processor.common.INotAuthProcessor;
import com.dyz.gameserver.msg.processor.common.MsgProcessor;
import com.dyz.gameserver.msg.response.chongzhi.ChongZhiResponse;

public class ChongZhiMsgProcessor extends MsgProcessor implements INotAuthProcessor{

	@Override
	public void process(GameSession gameSession, ClientRequest request) throws Exception {
		String msg=request.getString();
		String []msgs=msg.split(":");
		int uuid=Integer.valueOf(msgs[0]);
		System.out.println(msgs[1]+"充值");
		/*GameSession gameSession2=GameSessionManager.getInstance().getAvatarByUuid(uuid+"");*/
		gameSession.sendMsg(new ChongZhiResponse(1, msgs[1]));
	}
	
}
