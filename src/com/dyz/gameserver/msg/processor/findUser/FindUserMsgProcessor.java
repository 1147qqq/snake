package com.dyz.gameserver.msg.processor.findUser;



import com.dyz.gameserver.Avatar;
import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.msg.processor.common.INotAuthProcessor;
import com.dyz.gameserver.msg.processor.common.MsgProcessor;
import com.dyz.gameserver.msg.response.FindUser.FindUserResponse;
import com.dyz.gameserver.pojo.Account;
import com.dyz.gameserver.pojo.FindUser;
import com.dyz.myBatis.services.AccountService;
import com.dyz.myBatis.services.FriendsService;

public class FindUserMsgProcessor extends MsgProcessor implements INotAuthProcessor{

	@Override
	public  void process(GameSession gameSession, ClientRequest request)
			throws Exception {
		int followeruuid=gameSession.getRole(Avatar.class).getUuId();
		int uuid=Integer.valueOf(request.getString());
		Account account=AccountService.getInstance().selectByPrimaryKey(uuid);
		FindUser finduser=new FindUser();
		finduser.setBefolloweruuid(uuid);
		finduser.setFolloweruuid(followeruuid);
		FindUser findUser=FriendsService.getInstance().selectFindUserByBefolloweruuid(finduser);
		if (findUser!=null&&account!=null) {
			account.setIsfirend(true);
		}
		gameSession.sendMsg(new FindUserResponse(1, account));
	}

}
