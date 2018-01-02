package com.dyz.gameserver.msg.processor.messageBox;

import com.dyz.gameserver.Avatar;
import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.manager.GameSessionManager;
import com.dyz.gameserver.msg.processor.common.INotAuthProcessor;
import com.dyz.gameserver.msg.processor.common.MsgProcessor;
import com.dyz.gameserver.msg.response.messageBox.MessageResponse;
import com.dyz.gameserver.msg.response.messageBox.MessageResponseforMyself;
import com.dyz.gameserver.pojo.Account;
import com.dyz.gameserver.pojo.LoginVO;
import com.dyz.gameserver.pojo.Message;
import com.dyz.persist.util.JsonUtilTool;


/**
 * Created by kevin on 2016/8/2.
 */
public class MessageBoxMsgProcessor extends MsgProcessor implements INotAuthProcessor {
    @Override
    public void process(GameSession gameSession, ClientRequest request) throws Exception { 
    }
}
