package com.dyz.gameserver.pojo;

public class FindUser {
	private int id                 ;
	private int   followeruuid     ;        
	private int   Befolloweruuid   ;         
	private String   createtime       ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFolloweruuid() {
		return followeruuid;
	}
	public void setFolloweruuid(int followeruuid) {
		this.followeruuid = followeruuid;
	}
	public int getBefolloweruuid() {
		return Befolloweruuid;
	}
	public void setBefolloweruuid(int befolloweruuid) {
		Befolloweruuid = befolloweruuid;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}       
	

}