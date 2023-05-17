package com.droid_app_dev.serialportcommunication.comn.message;

/**
 *
 */

public interface IMessage {
    /**
     *
     *
     * @return
     */
    String getMessage();
    int getSize();

    /**
     *
     *
     * @return
     */
    boolean isToSend();
}
