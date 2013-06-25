package com.android.monkeyrunner;

import com.android.chimpchat.ChimpChat;
import com.android.chimpchat.core.ChimpImageBase;
import com.android.chimpchat.core.IChimpDevice;
import com.android.chimpchat.core.IChimpImage;

import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MonkeyRunner {

    private static final Logger LOG = Logger.getLogger(MonkeyRunner.class.getCanonicalName());
    private static ChimpChat chimpchat;

    public MonkeyRunner() {
        MonkeyRunnerOptions localMonkeyRunnerOptions = MonkeyRunnerOptions.processOptions(new String[]{});
        TreeMap<String, String> localTreeMap = new TreeMap<>();
        localTreeMap.put("backend", localMonkeyRunnerOptions.getBackendName());
        chimpchat = ChimpChat.getInstance(localTreeMap);
    }

    public ChimpChat getChimpChat() {
        return chimpchat;
    }

    public MonkeyDevice waitForConnection() {
        long l = 9223372036854775807L;
        IChimpDevice localIChimpDevice = chimpchat.waitForConnection(l, ".*");
        return new MonkeyDevice(localIChimpDevice);
    }

    public MonkeyDevice waitForConnection(double timeout) {
        long l;
        try {
            l = (long) (timeout * 1000.0D);
        } catch (Exception localPyException) {
            l = 9223372036854775807L;
        }
        IChimpDevice localIChimpDevice = chimpchat.waitForConnection(l, ".*");
        return new MonkeyDevice(localIChimpDevice);
    }

    public MonkeyDevice waitForConnection(double timeout, String deviceId) {
        long l;
        try {
            l = (long) (timeout * 1000.0D);
        } catch (Exception localPyException) {
            l = 9223372036854775807L;
        }
        IChimpDevice localIChimpDevice = chimpchat.waitForConnection(l, deviceId);
        return new MonkeyDevice(localIChimpDevice);
    }

    /**
     * Pauses the current program for the specified number of seconds
     *
     * @param seconds The number of seconds to pause
     */
    public void sleep(double seconds) {
        long l = (long) (seconds * 1000.0D);
        try {
            Thread.sleep(l);
        } catch (InterruptedException localInterruptedException) {
            LOG.log(Level.SEVERE, "Error sleeping", localInterruptedException);
        }
    }

    public static MonkeyImage loadImageFromFile(String filePath) {
        IChimpImage localIChimpImage = ChimpImageBase.loadImageFromFile(filePath);
        return new MonkeyImage(localIChimpImage);
    }

}