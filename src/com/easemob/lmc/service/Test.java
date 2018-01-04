package com.easemob.lmc.service;

import com.easemob.lmc.model.TalkNode;
import com.easemob.lmc.service.impl.TalkDataServiceImpl;

public class Test {
	public static void main(String[] args) {
		TalkDataService talkDataService=null;
		talkDataService=new TalkDataServiceImpl();
		TalkNode tak=new TalkNode();
		try {
			tak=talkDataService.userMessageCount("100023");
			System.out.println("32132132131321");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
