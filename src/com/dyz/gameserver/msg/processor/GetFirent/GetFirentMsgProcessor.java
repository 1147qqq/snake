package com.dyz.gameserver.msg.processor.GetFirent;



import java.util.List;

import com.dyz.gameserver.Avatar;
import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.msg.processor.common.INotAuthProcessor;
import com.dyz.gameserver.msg.processor.common.MsgProcessor;
import com.dyz.gameserver.msg.response.FindUser.FindUserResponse;
import com.dyz.gameserver.msg.response.GetFirent.GetFirentrResponse;
import com.dyz.gameserver.pojo.Account;
import com.dyz.gameserver.pojo.FindUser;
import com.dyz.gameserver.pojo.LoginVO;
import com.dyz.gameserver.pojo.PageModel;
import com.dyz.myBatis.services.AccountService;
import com.dyz.myBatis.services.FriendsService;
import com.dyz.persist.util.JsonUtilTool;

public class GetFirentMsgProcessor extends MsgProcessor implements INotAuthProcessor{

	@Override
	public  void process(GameSession gameSession, ClientRequest request)
			throws Exception {
		int  pageNo=Integer.valueOf(request.getString());
		String keywords=gameSession.getRole(Avatar.class).getUuId()+"";
		System.out.println("查询好友"+keywords+"的，第"+pageNo+"页的好友");
		PageModel pageModel = new PageModel();
		pageModel.setKeywords(keywords);
		pageModel.setPageNo(pageNo);
		List<Account> accounts=FriendsService.getInstance().selectGetUser(pageModel);
		int usercount=FriendsService.getInstance().selectGetUserNum(pageModel);
		pageModel.setDataCount(usercount);
		pageModel.setCurrentPageDatas(accounts);
		gameSession.sendMsg(new GetFirentrResponse(1, pageModel));
	}

}
