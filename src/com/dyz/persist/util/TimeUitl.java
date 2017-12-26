package com.dyz.persist.util;


import com.dyz.gameserver.Avatar;
import com.dyz.gameserver.context.GameServerContext;
import com.dyz.gameserver.manager.GameSessionManager;
import com.dyz.gameserver.sprite.base.GameObj;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by kevin on 2016/6/20.
 */
public class TimeUitl {

    static Map<GameObj,Timer> gameObjMap = new HashMap<GameObj,Timer>();

    /**
     *  延迟销毁对象
     * @param gobj
     * @param delayTime
     */
    public static  void delayDestroy(final GameObj gobj,final int delayTime){
    	//System.out.println(((Avatar) gobj).getUuId() + " 数据将在" + delayTime + "毫秒后删除");
        final Timer timer = new Timer();
        gameObjMap.put(gobj,timer);
        //getGameObjMapSize();
        TimerTask tt=new TimerTask() {
            @Override
            public void run() {
                gameObjMap.remove(gobj);
                timer.cancel();
                if(gobj instanceof Avatar){
                    System.out.println("用户掉线超时，删除用户数据 UserId "+ ((Avatar) gobj).getUuId() + " delayTime:" + delayTime);
                    GameServerContext.remove_offLine_Character((Avatar) gobj);
	                GameSessionManager.getInstance().removeGameSession((Avatar) gobj);   
                    
                }else{
                    System.out.println("到点啦！移除 gameSession");
                }
                //gobj.destroyObj();
            }
        };
        timer.schedule(tt, delayTime);
    }

    /**
     * 停止并销毁计时器
     * @param obj
     */
    public static void stopAndDestroyTimer(GameObj obj){
        Timer timer = getTimer(obj);
        if(timer != null){
            gameObjMap.remove(obj);
           // getGameObjMapSize();
            timer.cancel();
            timer = null;
        }
    }

    public static void getGameObjMapSize(){
       //System.out.println("计时器 gameObjMap.size() = "+gameObjMap.size());
    }

    /**
     * 获取计时器
     * @param obj
     * @return
     */
    public static Timer getTimer(GameObj obj){
        return gameObjMap.get(obj);
    }
}