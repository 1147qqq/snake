package com.dyz.gameserver.pojo;

public class Products {
		private int id        	  ;
		private String  pname    	  ;//商品名称
		private int  pTypeid  	  ;//商品类型id
		private String name;//商品类型名称
		private int  num      	  ;//商品数量
		private int  money    	  ;//商品出售金币价格
		private int  bean     	  ;//商品出售虚拟都价格
		private int  needGrade	  ;//根据等级可以免费获取
		private int  sold     	  ;//上下架 1上架 2下架
		private String   imgurl   ;//商城图片地址
		private String head;//商品（只有皮肤有）头部图片地址
		private String  body;//商品（只有皮肤有）身子图片地址
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
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
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
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
		public int getNeedGrade() {
			return needGrade;
		}
		public void setNeedGrade(int needGrade) {
			this.needGrade = needGrade;
		}
		public int getSold() {
			return sold;
		}
		public void setSold(int sold) {
			this.sold = sold;
		}
		public String getImgurl() {
			return imgurl;
		}
		public void setImgurl(String imgurl) {
			this.imgurl = imgurl;
		}
		public String getHead() {
			return head;
		}
		public void setHead(String head) {
			this.head = head;
		}
		public String getBody() {
			return body;
		}
		public void setBody(String body) {
			this.body = body;
		}
		
}
