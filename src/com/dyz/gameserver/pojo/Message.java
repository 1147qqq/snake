package com.dyz.gameserver.pojo;

public class Message {
	//发送的内容
	private String chatMsg;
	//谁发的
	private Account chatFrom;
	
	public Account getChatFrom() {
		return chatFrom;
	}
	public void setChatFrom(Account chatFrom) {
		this.chatFrom = chatFrom;
	}
	public String getChatMsg() {
		return chatMsg;
	}
	public void setChatMsg(String chatMsg) {
		this.chatMsg = chatMsg;
	}
	
}
