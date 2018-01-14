package com.dyz.gameserver.pojo;

public class Account {
		private int id;
		//用户id
		private int 	 uuid         ;
		//唯一标识
		private String    openid         ;
		//昵称
		private String    nickname       ;
		//头像地址
		private String    headicon       ;
		//性别
		private int    sex            ;
		//城市
		private String    city           ;
		//创建时间
		private String    createtime     ;
		//用户账号
		private String    username       ;
		//用户密码
		private String    password       ;
		//年龄
		private int    age            ;
		//魅力值
		private int    charmnum       ;
		//最佳分数
		private int    maxachievement ;
		//虚拟币数量
		private int    money          ;
		//等级
		private int    grade          ;
		//虚拟豆
		private int    head           ;
		//是否是机器人
		private int    type           ;
		//昨日人气
		private int YesterdayCharmnum;
		//今天日期
		private int ToDayCharmnum;
		
		private boolean isfirend=false;
		//邀请码
		private String inviteCode;
		
		
		public String getInviteCode() {
			return inviteCode;
		}
		public void setInviteCode(String inviteCode) {
			this.inviteCode = inviteCode;
		}
		public int getUuid() {
			return uuid;
		}
		public void setUuid(int uuid) {
			this.uuid = uuid;
		}
		public String getOpenid() {
			return openid;
		}
		public void setOpenid(String openid) {
			this.openid = openid;
		}
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public String getHeadicon() {
			return headicon;
		}
		public void setHeadicon(String headicon) {
			this.headicon = headicon;
		}
		public int getSex() {
			return sex;
		}
		public void setSex(int sex) {
			this.sex = sex;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getCreatetime() {
			return createtime;
		}
		public void setCreatetime(String createtime) {
			this.createtime = createtime;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public int getCharmnum() {
			return charmnum;
		}
		public void setCharmnum(int charmnum) {
			this.charmnum = charmnum;
		}
		public int getMaxachievement() {
			return maxachievement;
		}
		public void setMaxachievement(int maxachievement) {
			this.maxachievement = maxachievement;
		}
		public int getMoney() {
			return money;
		}
		public void setMoney(int money) {
			this.money = money;
		}
		public int getGrade() {
			return grade;
		}
		public void setGrade(int grade) {
			this.grade = grade;
		}
		public int getHead() {
			return head;
		}
		public void setHead(int head) {
			this.head = head;
		}
		public int getType() {
			return type;
		}
		public void setType(int type) {
			this.type = type;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public boolean isIsfirend() {
			return isfirend;
		}
		public void setIsfirend(boolean isfirend) {
			this.isfirend = isfirend;
		}
		public int getYesterdayCharmnum() {
			return YesterdayCharmnum;
		}
		public void setYesterdayCharmnum(int yesterdayCharmnum) {
			YesterdayCharmnum = yesterdayCharmnum;
		}
		public int getToDayCharmnum() {
			return ToDayCharmnum;
		}
		public void setToDayCharmnum(int toDayCharmnum) {
			ToDayCharmnum = toDayCharmnum;
		}
		
		
		
		
}
