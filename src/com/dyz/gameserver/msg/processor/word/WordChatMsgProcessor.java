package com.dyz.gameserver.msg.processor.word;


import java.util.List;

import org.apache.mina.core.buffer.IoBuffer;

import com.dyz.gameserver.Avatar;
import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.commons.message.ResponseMsg;
import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.manager.GameSessionManager;
import com.dyz.gameserver.msg.processor.common.INotAuthProcessor;
import com.dyz.gameserver.msg.processor.common.MsgProcessor;
import com.dyz.gameserver.msg.response.HeadResponse;
import com.dyz.gameserver.msg.response.result.ResultResponse;
import com.dyz.gameserver.msg.response.word.WordResponse;
import com.dyz.gameserver.msg.response.word.WordResponseOther;
import com.dyz.gameserver.pojo.Account;
import com.dyz.gameserver.pojo.Message;
import com.dyz.myBatis.services.AccountService;

public class WordChatMsgProcessor extends MsgProcessor implements INotAuthProcessor{

	@Override
	public  void process(GameSession gameSession, ClientRequest request)
			throws Exception {
		String msg=request.getString();
		System.out.println("我收到新的世界消息："+msg);
		Message message=new Message();
		message.setChatMsg(msg);
		Avatar avatar=gameSession.getRole(Avatar.class);
		message.setChatFrom(avatar.account);
		gameSession.sendMsg(new WordResponse(1,"true"));
		   List<GameSession> gameSessionList = GameSessionManager.getInstance().getAllSession();
           if(gameSessionList != null){
               for(int i=0;i<gameSessionList.size();i++){
                   	try {
                   		gameSessionList.get(i).sendMsg(new WordResponseOther(1,message));
                   		System.out.println("我发给收到新的世界消息："+msg);
                   	}catch (Exception e){
                   		System.out.println(e.getMessage());
                   	}
               }
           }
	}

}
