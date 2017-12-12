package com.dyz.gameserver.msg.processor.login;


import com.dyz.gameserver.Avatar;
import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.context.GameServerContext;
import com.dyz.gameserver.manager.GameSessionManager;
import com.dyz.gameserver.msg.processor.common.INotAuthProcessor;
import com.dyz.gameserver.msg.processor.common.MsgProcessor;
import com.dyz.gameserver.msg.response.login.LoginResponse;
import com.dyz.gameserver.pojo.Account;
import com.dyz.gameserver.pojo.LoginVO;
import com.dyz.myBatis.services.AccountService;
import com.dyz.persist.util.JsonUtilTool;
import com.dyz.persist.util.TimeUitl;
import com.dyz.persist.util.TjUtil;

public class LoginMsgProcessor extends MsgProcessor implements INotAuthProcessor{

	@Override
	public  void process(GameSession gameSession, ClientRequest request)
			throws Exception {
		Account account=new Account();
		String message = request.getString();
		System.out.println(message);
		LoginVO loginVO = JsonUtilTool.fromJson(message,LoginVO.class);
		account = AccountService.getInstance().selectAccount(loginVO.getOpenId());
		if(account==null){
			//创建新用户并登录
			account.setOpenid(loginVO.getOpenId());
			account.setUuid(AccountService.getInstance().selectMaxId()+100000);
			account.setHeadIcon(loginVO.getHeadIcon());
			account.setNickname(loginVO.getNickName());
			account.setCity(loginVO.getCity());
			account.setSex(loginVO.getSex());
			account.setCreatetime(TjUtil.getCurrentDateTime());
			if(AccountService.getInstance().createAccount(account) == 0){
				gameSession.sendMsg(new LoginResponse(0,null));
				TimeUitl.delayDestroy(gameSession,1000);
			}else{
				Avatar tempAva = new Avatar();
				tempAva.account=account;
				loginAction(gameSession,tempAva);
				//把session放入到GameSessionManager
				GameSessionManager.getInstance().putGameSessionInHashMap(gameSession,tempAva.getUuId());
			}
		}else{
			Avatar tempAva=gameSession.getRole(Avatar.class);
			loginAction(gameSession,tempAva);
			System.out.println(account.getUuid()+"  :登录游戏");
		}
	}

	/**
	 * 登录操作
	 * @param gameSession
	 * @param avatar
     */
	public void loginAction(GameSession gameSession,Avatar avatar){
		gameSession.setRole(avatar);
		gameSession.setLogin(true);
		avatar.setSession(gameSession);
		GameServerContext.add_onLine_Character(avatar);
		gameSession.sendMsg(new LoginResponse(1,avatar.account));
		//gameSession.sendMsg(new HostNoitceResponse(1, NoticeTableService.getInstance().selectRecentlyObject().getContent()));
	}
}
