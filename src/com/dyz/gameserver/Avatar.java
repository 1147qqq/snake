package com.dyz.gameserver;

import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.pojo.Account;
import com.dyz.gameserver.sprite.Character;
import com.dyz.gameserver.sprite.base.GameObj;
import com.dyz.gameserver.sprite.tool.AsyncTaskQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 所有用户信息
 */
public class Avatar implements GameObj {
	public Account account;
	/**
	 * session
	 */
	private GameSession session;
	/**
	 * 日志记录
	 */
	private static final Logger logger = LoggerFactory.getLogger(Character.class);
	/**
	 * 异步操作队列
	 */
	private AsyncTaskQueue asyncTaskQueue = new AsyncTaskQueue();

	public Avatar() {
	}

	/**
	 * 更新用户数据表信息
	 * 
	 * @param value
	 */
	public void updateRoomCard(int value) {
//		int number = avatarVO.getAccount().getRoomcard();
//		number += value;
//		avatarVO.getAccount().setRoomcard(number);
//		AccountService.getInstance().updateByPrimaryKeySelective(avatarVO.getAccount());
	}

	/**
	 * 获取玩家session
	 * 
	 * @return
	 */
	public GameSession getSession() {
		return session;
	}

	/**
	 * 获取玩家session
	 * 
	 * @return
	 */
	public void setSession(GameSession gameSession) {
		this.session = gameSession;
	}

	/**
	 * 添加异步任务，针对异步操作数据库
	 * 
	 * @param tasks
	 */
	public void addAsyncTask(Runnable... tasks) {
		asyncTaskQueue.addTask(tasks);
	}

	/**
	 * 获取用户uuid
	 * 
	 * @return
	 */
	public int getUuId() {
		return account.getUuid();
	}


	@Override
	public void destroyObj() {
		// 统计在线用户****
		//logger.info("Avatar用户{}断开服务器链接", avatarVO.getAccount().getNickname());
		if (session != null) {
			// session.clearAllInfo();
		}
	}
}
