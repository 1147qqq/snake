package com.dyz.gameserver.msg.processor.Concern;
import com.dyz.gameserver.Avatar;
import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.msg.processor.common.INotAuthProcessor;
import com.dyz.gameserver.msg.processor.common.MsgProcessor;
import com.dyz.gameserver.msg.response.Concern.ConcernResponse;
import com.dyz.gameserver.pojo.Account;
import com.dyz.gameserver.pojo.FindUser;
import com.dyz.myBatis.services.AccountService;
import com.dyz.myBatis.services.FriendsService;
import com.dyz.persist.util.TjUtil;

public class ConcernMsgProcessor extends MsgProcessor implements INotAuthProcessor{

	@Override
	public  void process(GameSession gameSession, ClientRequest request)
			throws Exception {
		Avatar avatar=gameSession.getRole(Avatar.class);
		int followeruuid=avatar.getUuId();
		int Befolloweruuid=Integer.valueOf(request.getString());
		FindUser finduser=new FindUser();
		finduser.setFolloweruuid(followeruuid);
		finduser.setBefolloweruuid(Befolloweruuid);
		finduser.setCreatetime(TjUtil.getCurrentDate());
		FindUser findUser=FriendsService.getInstance().selectFindUserByBefolloweruuid(finduser);
		if (findUser==null) {
		FriendsService.getInstance().createFindUser(finduser);
		}
		Account account=AccountService.getInstance().selectByPrimaryKey(Befolloweruuid);
		gameSession.sendMsg(new ConcernResponse(1, account));
	}

}
