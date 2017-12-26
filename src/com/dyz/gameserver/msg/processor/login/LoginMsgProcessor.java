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
import com.easemob.lmc.model.TalkNode;
import com.easemob.lmc.service.TalkDataService;
import com.easemob.lmc.service.impl.TalkDataServiceImpl;

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
			account=new Account();
			account.setOpenid(loginVO.getOpenId());
			account.setUuid(AccountService.getInstance().selectMaxId()+100000);
			account.setHeadicon(loginVO.getHeadIcon());
			account.setNickname(loginVO.getNickName());
			account.setCity(loginVO.getCity());
			account.setSex(loginVO.getSex());
			account.setCreatetime(TjUtil.getCurrentDate());
			TalkDataService talkDataService=null;
			talkDataService=new TalkDataServiceImpl();
			try {
				talkDataService.userSave(account.getUuid()+"", "123456",loginVO.getNickName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
				//如果玩家是掉线的，则直接从缓存(GameServerContext)中取掉线玩家的信息
				//判断用户是否已经进行断线处理(如果前端断线时间过短，后台则可能还未来得及把用户信息放入到离线map里面，就已经登录了，所以取出来就会是空)
				Thread.sleep(500);
				Avatar avatar = GameServerContext.getAvatarFromOn(account.getUuid());
				if(avatar == null){
					avatar =  GameServerContext.getAvatarFromOff(account.getUuid());
				}
				if(avatar == null){
					GameSession gamesession = GameSessionManager.getInstance().getAvatarByUuid("uuid_"+account.getUuid());
					if(gamesession != null){
						avatar =  gamesession.getRole(Avatar.class);
					}
				}
				if (avatar!=null) {
					avatar.account=account;
					avatar.setSession(gameSession);
					//system.out.println("用户回来了，断线重连，中止计时器");
					//返回用户断线前的房间信息******
					gameSession.setLogin(true);
					gameSession.setRole(avatar);
					GameServerContext.add_onLine_Character(avatar);
					GameServerContext.remove_offLine_Character(avatar);
					gameSession.sendMsg(new LoginResponse(1,avatar.account));
					//把session放入到GameSessionManager
					GameSessionManager.getInstance().putGameSessionInHashMap(gameSession,avatar.getUuId());
				}else {
					avatar=new Avatar();
					avatar.account=account;
					loginAction(gameSession,avatar);
					GameSessionManager.getInstance().putGameSessionInHashMap(gameSession,avatar.getUuId());
				}
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
