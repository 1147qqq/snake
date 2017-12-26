package com.dyz.persist.util;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;

import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.manager.GameSessionManager;
import com.dyz.gameserver.msg.response.HeadResponse;
import com.dyz.gameserver.sprite.tool.AsyncTaskQueue;
import com.dyz.myBatis.services.AccountService;

/**
 * Created by kevin on 2016/8/15.
 * 每天固定时间执行任务的定时器
 */
public class TaskTimer {
    static int count = 0;
    AsyncTaskQueue asyncTaskQueue = new AsyncTaskQueue();
    public static void headBag(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                List<GameSession> gameSessionList = GameSessionManager.getInstance().getAllSession();
                if(gameSessionList != null){
                    for(int i=0;i<gameSessionList.size();i++){
                        gameSessionList.get(i).addTime(1);
                        if(gameSessionList.get(i).getTime() >=4){
//                            gameSessionList.get(i).destroyObj();
//                            gameSessionList.get(i).sendMsg(new HeadResponse(1,"1"));
                        }
                        else{
                        	try {
                        		gameSessionList.get(i).sendMsg(new HeadResponse(1,"0"));
                        	}catch (Exception e){
                        		System.out.println(e.getMessage());
                        	}
                        }
                    }
                }
            }
        };
        //设置执行时间
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);//每天
        //定制每天的21:09:00执行，
        calendar.set(year, month, day, 0, 0, 1);
        Date date = calendar.getTime();
        Timer timer = new Timer();
        System.out.println(date);
        //20秒一次心跳包
        timer.schedule(task, date,2000);
    }
}
