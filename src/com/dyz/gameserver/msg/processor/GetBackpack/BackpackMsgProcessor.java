package com.dyz.gameserver.msg.processor.GetBackpack;

import java.util.List;

import com.dyz.gameserver.Avatar;
import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.msg.processor.common.INotAuthProcessor;
import com.dyz.gameserver.msg.processor.common.MsgProcessor;
import com.dyz.gameserver.msg.response.GetBackpack.GetBackpackResponse;
import com.dyz.gameserver.pojo.AllBackpack;
import com.dyz.gameserver.pojo.Backpack;
import com.dyz.myBatis.services.BackpackService;

public class BackpackMsgProcessor extends MsgProcessor implements INotAuthProcessor{

	@Override
	public  void process(GameSession gameSession, ClientRequest request)
			throws Exception {	
			int uuid=gameSession.getRole(Avatar.class).getUuId();
			System.out.println("请求背包的uuid是"+uuid);
			List<Backpack> backpacks = BackpackService.getInstance().selectByUUid(uuid);
			
			AllBackpack allBackpack = new AllBackpack();
			allBackpack.setBackpacks(backpacks);
			gameSession.sendMsg(new GetBackpackResponse(1, allBackpack));
			
	}

}
