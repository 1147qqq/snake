package com.context;

public class ConnectAPI {

	public ConnectAPI() {
		// TODO Auto-generated constructor stubaa
	}

	 public static int FindUser_REQUEST = 0x00003; //查找用户请求码
     public static int FindUser_RESPONSE = 0x00004; //查找用户返回码
    
     public static int Concern_REQUEST = 0x00005; //关注用户请求码
     public static int Concern_RESPONSE = 0x00006; //关注用户返回码
	
     public static int GetFirent_REQUEST = 0x00007; //获取好友请求码
     public static int GetFirent_RESPONSE = 0x00008; //获取好友返回码
	
	public static int LOGIN_REQUEST = 0x000001;
	public static int LOGIN_RESPONSE = 0x000002;
	// 固定语音盒子协议
	public static int MessageBox_Request = 203;//发送信息
	public static int MessageBox_RESPONSE = 204;//接收信息
	public static int MessageBoxMy_RESPONSE = 205;//发送消息回掉
	//无尽模式成绩上传
	public static int Result_REQUEST = 0x000011;
	public static int Result_RESPONSE = 0x000012;
	
	// 心跳协议
	public static int head = 0x000030;
	public static int headRESPONSE = 0x000031;
	
	// 游戏错误码返回
	public static int ERROR_RESPONSE = 0xffff09;
	// 游戏关闭返回
	public static int CLOSE_RESPONSE = 0x000000;
	
    public static int WorldChat_REQUEST = 0x00009;//发送世界信息请求码
    public static int WorldChat_RESPONSE = 0x000010; //接收世界信息返回码
    public static int MyWorldChat_RESPONSE = 0x000013; //发送世界信息返回码
	
	
}
