package com.context;

public class ConnectAPI {

	public ConnectAPI() {
		// TODO Auto-generated constructor stubaa
	}

	public static int LOGIN_REQUEST = 0x000001;
	public static int LOGIN_RESPONSE = 0x000002;
	
	// 心跳协议
	public static int head = 0x000030;
	public static int headRESPONSE = 0x000031;
	
	// 游戏错误码返回
	public static int ERROR_RESPONSE = 0xffff09;
	// 游戏关闭返回
	public static int CLOSE_RESPONSE = 0x000000;
}
