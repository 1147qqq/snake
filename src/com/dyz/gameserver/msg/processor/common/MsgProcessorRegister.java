package com.dyz.gameserver.msg.processor.common;

import com.context.ConnectAPI;
import com.dyz.gameserver.msg.processor.heartbeat.HeadMsgProcessor;
import com.dyz.gameserver.msg.processor.login.LoginMsgProcessor;

/**
 * 消息处理器注册类，所有的消息处理器，都在此注册实例化
 * 
 * @author dyz
 *
 */
public enum MsgProcessorRegister {
	/** 登陆处理器 */
	login(ConnectAPI.LOGIN_REQUEST, new LoginMsgProcessor()),
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
