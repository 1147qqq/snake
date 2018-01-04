package com.dyz.gameserver.pojo;

public class BackpackVo {
	private int money;//消费的金币数
	private int bean;//消费的虚拟豆数
	private int num;//购买的商品数量
	private int uuid;//uuid
	private String nickname;//用户昵称
	private int productid;//商品id
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getBean() {
		return bean;
	}
	public void setBean(int bean) {
		this.bean = bean;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	
	public BackpackVo() {
		
	}

}
