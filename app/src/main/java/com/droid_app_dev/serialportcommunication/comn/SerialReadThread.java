package com.droid_app_dev.serialportcommunication.comn;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.droid_app_dev.serialportcommunication.comn.message.LogManager;
import com.droid_app_dev.serialportcommunication.comn.message.RecvMessage;
import com.licheedev.myutils.LogPlus;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 *
 */
public class SerialReadThread extends Thread {

    private static final String TAG = "SerialReadThread";

    private BufferedInputStream mInputStream;
    private byte[] mReadBuffer;

    public SerialReadThread(InputStream is) {
        mInputStream = new BufferedInputStream(is);
        mReadBuffer = new byte[4096];
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void run() {
        int size;
        while (!isInterrupted()) {
            try {

                size = mInputStream.read(mReadBuffer);
                Log.d("ttymxc0  Size:-", "" + size+" Thread State "+currentThread().getState());
                if (size > 0) {
                    byte[] readBytes = new byte[size];
                    System.arraycopy(mReadBuffer, 0, readBytes, 0, size);
                    onDataReceive(readBytes,size);
                }

            } catch (IOException e) {
                e.printStackTrace();
                return;
            } finally {

                // semaphore.release();
            }

        }
    }

    /**
     *
     *
     * @param received
     * @param size
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void onDataReceive(byte[] received, int size) {
        String hexStr2 = new String(received, StandardCharsets.ISO_8859_1);
        LogManager.instance().post(new RecvMessage(hexStr2,size));
    }

    /**
     *
     */
    public void close() {

        try {
            mInputStream.close();
        } catch (IOException e) {
            LogPlus.e("", e.getMessage());
        } finally {
            super.interrupt();
        }
    }
}
