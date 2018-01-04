package com.dyz.gameserver.pojo;

public class Backpack {
	
	private int id;
	private int uuid;
	private String pname      ;
	private int pTypeid    ;
	private int num        ;
	private int money      ;
	private int bean       ;
	private String imgurl     ;
	private String body;
	private String head;
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUuid() {
		return uuid;
	}


	public void setUuid(int uuid) {
		this.uuid = uuid;
	}



	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public int getpTypeid() {
		return pTypeid;
	}


	public void setpTypeid(int pTypeid) {
		this.pTypeid = pTypeid;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


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


	public String getImgurl() {
		return imgurl;
	}


	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public String getHead() {
		return head;
	}


	public void setHead(String head) {
		this.head = head;
	}


	public Backpack() {
		
	}
}
