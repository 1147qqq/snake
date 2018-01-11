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
    public static void charnum(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
            	AccountService.getInstance().updateCharmnun();
            }
        };
        //设置执行时间
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);//每天
        //定制每天的21:09:00执行，
        calendar.set(year, month, day, 1, 0, 0);
        Date date = calendar.getTime();
        Timer timer = new Timer();
        System.out.println(date);
        timer.schedule(task, date,24*60*60*1000);
    }
}
