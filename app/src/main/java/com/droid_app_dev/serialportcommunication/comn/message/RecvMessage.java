package com.droid_app_dev.serialportcommunication.comn.message;


import com.droid_app_dev.serialportcommunication.util.TimeUtil;

/**
 *
 */

public class RecvMessage implements IMessage {
    
    private String command;
    private String message;
    private int size;

    public RecvMessage(String command, int size) {
        this.command = command;
        this.size=size;
        this.message = TimeUtil.currentTime() + ":-" + command;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public boolean isToSend() {
        return false;
    }
}
