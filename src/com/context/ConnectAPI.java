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
	
	//广播
	public static int WORDRADIO_REQUEST = 0x000131;
	public static int WORDRADIO_RESPONSE = 0x000132;
	public static int MYWORDRADIO_RESPONSE = 0x000113; //发送世界信息返回码
	
	
	// 游戏错误码返回
	public static int ERROR_RESPONSE = 0xffff09;
	// 游戏关闭返回
	public static int CLOSE_RESPONSE = 0x000000;
	
    public static int GetAllShop_REQUEST = 0x000014;//获取商店信息请求码
    public static int GetAllShop_RESPONSE = 0x000015;//获取商店信息返回码
    
    public static int GetPaiHang_REQUEST = 0x001114;//获取排行请求
    public static int GetPaiHang_RESPONSE = 0x001115;//获取排行返回码
	
    public static int WorldChat_REQUEST = 0x00009;//发送世界信息请求码
    public static int WorldChat_RESPONSE = 0x000010; //接收世界信息返回码
    public static int MyWorldChat_RESPONSE = 0x000013; //发送世界信息返回码
    
    public static int NearUser_REQUEST = 0x000016;//附近的人请求码
    public static int NearUser_RESPONSE = 0x000017;//附近的人返回码
    
    
    public static int GetByUserBackpack_REQUEST = 0x000119;//获取用户的背包信息请求吗
    public static int GetByUserBackpack_RESPONSE = 0x000019;//获取用户的背包信息返回码
    
    public static int InsertByUserBackpack_REQUEST = 0x000120;//添加背包信息请求吗
    public static int InsertByUserBackpack_RESPONSE = 0x000121;//添加背包信息返回码
    
    public static int GetCharmRank_REQUEST = 0x00020;//获取人气排行版请求码
    public static int GetCharmRank_RESPONSE = 0x000021;//获取人气排行版返回码
    
    public static int CHONGZHI_REQUEST = 0x158888;//充值成功请求码
    public static int CHONGZHI_RESPONSE = 0x158889;//充值返回码
	
	
}
