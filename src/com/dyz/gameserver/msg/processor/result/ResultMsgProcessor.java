package com.dyz.gameserver.msg.processor.result;


import org.apache.mina.core.buffer.IoBuffer;

import com.dyz.gameserver.Avatar;
import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.commons.message.ResponseMsg;
import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.msg.processor.common.INotAuthProcessor;
import com.dyz.gameserver.msg.processor.common.MsgProcessor;
import com.dyz.gameserver.msg.response.result.ResultResponse;
import com.dyz.gameserver.pojo.Account;
import com.dyz.myBatis.services.AccountService;

public class ResultMsgProcessor extends MsgProcessor implements INotAuthProcessor{

	@Override
	public  void process(GameSession gameSession, ClientRequest request)
			throws Exception {
		Avatar avatar=gameSession.getRole(Avatar.class);
		int OldMaxachievement=avatar.account.getMaxachievement();
		int result=Integer.valueOf(request.getString());
		System.out.println("成绩接受成功"+result);
		if (result>OldMaxachievement) {
			System.out.println("成绩是最佳成绩");
			avatar.account.setMaxachievement(result);
			AccountService.getInstance().updateByPrimaryKeySelective(avatar.account);
			gameSession.sendMsg(new ResultResponse(1,"成绩是最佳成绩"));
		} else {
			gameSession.sendMsg(new ResultResponse(1,"成绩不是最佳成绩不需要修改"));
			System.out.println("成绩不是最佳成绩不需要修改");
		}
	}

}
