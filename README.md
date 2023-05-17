# Android-SerialPort-Tool RS232

This is a demo project that showcases how to read/write  Serialport/UART  over Android.

![serialport](https://github.com/droid-app-dev/Android-SerialPort-Tool/assets/41099218/ed3a2714-7edc-4eb7-9538-1cce9fd74eb4)

# important

su path

In order to read/write to a serial port in Android you'll need su binary installed on device (this can be done by rooting the device). Usually Android devices that has the ability to communicate with serial ports have su installed on the default path "/system/bin/su". To change this use:

# Installation & Usage

```java
 
 /**
     * serial port
     *
     * @param device Serial device file
     * @param baudrate baud rate
     * @param dataBits Data bits; default 8, optional value is 5~8
     * @param parity Parity; 0: no parity (NONE, default); 1: odd parity (ODD); 2: even parity (EVEN)
     * @param stopBits Stop bit; default 1; 1: 1 stop bit; 2: 2 stop bit
     * @param flags Default 0
     * @throws SecurityException
     * @throws IOException
     */
    public SerialPort(@NonNull File device, int baudrate, int dataBits, int parity, int stopBits,
        int flags) throws SecurityException, IOException {

        this.device = device;
        this.baudrate = baudrate;
        this.dataBits = dataBits;
        this.parity = parity;
        this.stopBits = stopBits;
        this.flags = flags;

        /* Check access permission */
        if (!device.canRead() || !device.canWrite()) {
            try {
                /* Missing read/write permission, trying to chmod the file */
                Process su;
                su = Runtime.getRuntime().exec(sSuPath);
                String cmd = "chmod 666 " + device.getAbsolutePath() + "\n" + "exit\n";
                su.getOutputStream().write(cmd.getBytes());
                if ((su.waitFor() != 0) || !device.canRead() || !device.canWrite()) {
                    throw new SecurityException();
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new SecurityException();
            }
        }

        mFd = open(device.getAbsolutePath(), baudrate, dataBits, parity, stopBits, flags);
        if (mFd == null) {
            Log.e(TAG, "native open returns null");
            throw new IOException();
        }
        mFileInputStream = new FileInputStream(mFd);
        mFileOutputStream = new FileOutputStream(mFd);
    }   
 ```
