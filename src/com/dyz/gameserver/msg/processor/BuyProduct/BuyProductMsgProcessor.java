package com.dyz.gameserver.msg.processor.BuyProduct;

import com.dyz.gameserver.Avatar;
import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.msg.processor.common.INotAuthProcessor;
import com.dyz.gameserver.msg.processor.common.MsgProcessor;
import com.dyz.gameserver.msg.response.BuyProduct.BuyProductResponse;
import com.dyz.gameserver.pojo.BackpackEntity;
import com.dyz.gameserver.pojo.BackpackVo;
import com.dyz.gameserver.pojo.Productflow;
import com.dyz.myBatis.services.BackpackService;
import com.dyz.myBatis.services.ProductflowService;
import com.dyz.persist.util.JsonUtilTool;
import com.dyz.persist.util.TjUtil;

public class BuyProductMsgProcessor extends MsgProcessor implements INotAuthProcessor{

	@Override
	public void process(GameSession gameSession, ClientRequest request) throws Exception {
		
		int uuid=gameSession.getRole(Avatar.class).getUuId();
		
		String message = request.getString();
		
		System.out.println(message);
		
		BackpackVo backpackvo = JsonUtilTool.fromJson(message,BackpackVo.class);//VO类 方便
		
		BackpackEntity backpackEntity = new BackpackEntity();//仅背包数据的实体类
		backpackEntity.setUuid(uuid);
		backpackEntity.setNum(backpackvo.getNum());
		backpackEntity.setProductid(backpackvo.getProductid());
		
		int insertBackpack = BackpackService.getInstance().insertBackpack(backpackEntity);
		
		Productflow productflow = new Productflow();//商品流水表
		productflow.setUuid(uuid);
		productflow.setCreateTime(TjUtil.getCurrentDate());
		productflow.setMoney(backpackvo.getMoney());
		productflow.setBean(backpackvo.getBean());
		productflow.setNickname(backpackvo.getNickname());
		productflow.setProductid(backpackvo.getProductid());
		
		int insertProduct = ProductflowService.getInstance().insertProductflow(productflow);
		
		if(insertBackpack>0&&insertProduct>0) {
			gameSession.sendMsg(new BuyProductResponse(1,0));
		}
		
	}
	
}
