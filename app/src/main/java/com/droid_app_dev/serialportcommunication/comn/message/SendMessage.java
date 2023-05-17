package com.droid_app_dev.serialportcommunication.comn.message;

import com.droid_app_dev.serialportcommunication.comn.message.IMessage;
import com.droid_app_dev.serialportcommunication.util.TimeUtil;

/**
 *
 */

public class SendMessage implements IMessage {

    private String command;
    private String message;

    public SendMessage(String command) {
        this.command = command;
        this.message = TimeUtil.currentTime() +""+ command;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isToSend() {
        return true;
    }
}
