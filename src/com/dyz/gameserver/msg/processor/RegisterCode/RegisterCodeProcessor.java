package com.dyz.gameserver.msg.processor.RegisterCode;

import com.dyz.gameserver.Avatar;
import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.msg.processor.common.INotAuthProcessor;
import com.dyz.gameserver.msg.processor.common.MsgProcessor;
import com.dyz.gameserver.msg.response.RegisterCode.RegisterCodeResponse;
import com.dyz.gameserver.pojo.Account;
import com.dyz.gameserver.pojo.Manager;
import com.dyz.myBatis.services.AccountService;
import com.dyz.myBatis.services.ManagerService;

public class RegisterCodeProcessor extends MsgProcessor implements INotAuthProcessor{

	public void process(GameSession gameSession, ClientRequest request) throws Exception {
		
		int uuid=gameSession.getRole(Avatar.class).getUuId();//uuid
		
		String registerCode =request.getString();//传来的邀请码
		
		Manager manager = ManagerService.getInstance().selectByInviteCode(registerCode);
		
		int i = 1;
		if(manager!=null&&manager.getId()!=0) {
			Account account = new Account();
			account.setUuid(uuid);
			account.setInviteCode(registerCode);
			int updateA	= AccountService.getInstance().updateInviteCode(account);
			if(updateA>0) {
				i= 2;
		}
	}
		
		gameSession.sendMsg(new RegisterCodeResponse(1, i));
		
		
	}

}
