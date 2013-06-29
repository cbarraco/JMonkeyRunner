package com.android.monkeyrunner;

import com.android.chimpchat.ChimpChat;
import com.android.chimpchat.core.ChimpImageBase;
import com.android.chimpchat.core.IChimpDevice;
import com.android.chimpchat.core.IChimpImage;

import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MonkeyRunner {

    public static final long DEFAULT_TIMEOUT = 9223372036854775807L;
    private static final Logger LOG = Logger.getLogger(MonkeyRunner.class.getCanonicalName());
    private static ChimpChat chimpchat;

    public MonkeyRunner() {
        MonkeyRunnerOptions localMonkeyRunnerOptions = MonkeyRunnerOptions.processOptions(new String[]{});
        TreeMap<String, String> localTreeMap = new TreeMap<String, String>();
        localTreeMap.put("backend", localMonkeyRunnerOptions.getBackendName());
        chimpchat = ChimpChat.getInstance(localTreeMap);
    }

    public static MonkeyImage loadImageFromFile(String filePath) {
        IChimpImage chimpImage = ChimpImageBase.loadImageFromFile(filePath);
        return new MonkeyImage(chimpImage);
    }

    public ChimpChat getChimpChat() {
        return chimpchat;
    }

    /**
     * Tries to make a connection between the monkeyrunner backend and the specified device or emulator.
     *
     * @return A MonkeyDevice instance for the device or emulator. Use this object to control and communicate with the device or emulator.
     */
    public MonkeyDevice waitForConnection() {
        long defaultTimeoutLong = DEFAULT_TIMEOUT;
        IChimpDevice chimpDevice = chimpchat.waitForConnection(defaultTimeoutLong, ".*");
        return new MonkeyDevice(chimpDevice);
    }

    /**
     * Tries to make a connection between the monkeyrunner backend and the specified device or emulator.
     *
     * @param timeout  The number of seconds to wait for a connection.
     * @return A MonkeyDevice instance for the device or emulator. Use this object to control and communicate with the device or emulator.
     */
    public MonkeyDevice waitForConnection(double timeout) {
        return waitForConnection(timeout, ".*");
    }

    /**
     * Tries to make a connection between the monkeyrunner backend and the specified device or emulator.
     *
     * @param timeout  The number of seconds to wait for a connection.
     * @param deviceId A regular expression that specifies the serial number of the device or emulator. See the topic Android Debug Bridge for a description of device and emulator serial numbers.
     * @return A MonkeyDevice instance for the device or emulator. Use this object to control and communicate with the device or emulator.
     */
    public MonkeyDevice waitForConnection(double timeout, String deviceId) {
        long timeoutLong;
        try {
            timeoutLong = (long) (timeout * 1000.0D);
        } catch (Exception e) {
            timeoutLong = DEFAULT_TIMEOUT;
        }
        IChimpDevice chimpDevice = chimpchat.waitForConnection(timeoutLong, deviceId);
        return new MonkeyDevice(chimpDevice);
    }

    /**
     * Pauses the current program for the specified number of seconds
     *
     * @param duration The number of seconds to pause
     */
    public void sleep(double duration) {
        long durationLong = (long) (duration * 1000.0D);
        try {
            Thread.sleep(durationLong);
        } catch (InterruptedException e) {
            LOG.log(Level.SEVERE, "Error sleeping", e);
        }
    }

}