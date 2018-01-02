package com.dyz.gameserver.msg.processor.common;

import com.context.ConnectAPI;
import com.dyz.gameserver.msg.processor.Concern.ConcernMsgProcessor;
import com.dyz.gameserver.msg.processor.GetFirent.GetFirentMsgProcessor;
import com.dyz.gameserver.msg.processor.Ranking.RankingMsgProcessor;
import com.dyz.gameserver.msg.processor.findUser.FindUserMsgProcessor;
import com.dyz.gameserver.msg.processor.heartbeat.HeadMsgProcessor;
import com.dyz.gameserver.msg.processor.login.LoginMsgProcessor;
import com.dyz.gameserver.msg.processor.messageBox.MessageBoxMsgProcessor;
import com.dyz.gameserver.msg.processor.product.ProductsMsgProcessor;
import com.dyz.gameserver.msg.processor.result.ResultMsgProcessor;
import com.dyz.gameserver.msg.processor.word.WordChatMsgProcessor;

/**
 * 消息处理器注册类，所有的消息处理器，都在此注册实例化
 * 
 * @author dyz
 *
 */
public enum MsgProcessorRegister {
	/** 登陆处理器 */
	login(ConnectAPI.LOGIN_REQUEST, new LoginMsgProcessor()),
	/** 无尽模式成绩上传*/
	result(ConnectAPI.Result_REQUEST, new ResultMsgProcessor()),
	/** 查找用户*/
	findUser(ConnectAPI.FindUser_REQUEST, new FindUserMsgProcessor()),
	
	messageBox(ConnectAPI.MessageBox_Request,new MessageBoxMsgProcessor()),
	/** 商品获取*/
	products(ConnectAPI.GetAllShop_REQUEST,new ProductsMsgProcessor()),
	/** 关注 */
	comcern(ConnectAPI.Concern_REQUEST, new ConcernMsgProcessor()),
	/** 排行榜 */
	ranking(ConnectAPI.GetPaiHang_REQUEST, new RankingMsgProcessor()),
	
	getFirent(ConnectAPI.GetFirent_REQUEST, new GetFirentMsgProcessor()),
	/**发送世界消息 */
	word(ConnectAPI.WorldChat_REQUEST, new WordChatMsgProcessor()),
	/**世界广播*/
	wordradio(ConnectAPI.WORDRADIO_REQUEST, new WordChatMsgProcessor()),
	/** 心跳协议 */
	head(ConnectAPI.head, new HeadMsgProcessor());

	private int msgCode;
	private MsgProcessor processor;

	/**
	 * 不允许外部创建
	 * 
	 * @param msgCode
	 * @param processor
	 */
	private MsgProcessorRegister(int msgCode, MsgProcessor processor) {
		this.msgCode = msgCode;
		this.processor = processor;
	}

	/**
	 * 获取协议号
	 * 
	 * @return
	 */
	public int getMsgCode() {
		return this.msgCode;
	}

	/**
	 * 获取对应的协议解晰类对象
	 * 
	 * @return
	 */
	public MsgProcessor getMsgProcessor() {
		return this.processor;
	}
}
