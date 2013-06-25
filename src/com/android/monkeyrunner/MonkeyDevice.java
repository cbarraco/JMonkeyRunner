package com.android.monkeyrunner;

import com.android.chimpchat.core.*;
import com.android.chimpchat.hierarchyviewer.HierarchyViewer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Logger;

public class MonkeyDevice {
    private static final Logger LOG = Logger.getLogger(MonkeyDevice.class.getName());
    public static final String DOWN = TouchPressType.DOWN.getIdentifier();
    public static final String UP = TouchPressType.UP.getIdentifier();
    public static final String DOWN_AND_UP = TouchPressType.DOWN_AND_UP.getIdentifier();
    private IChimpDevice impl;

    public MonkeyDevice(IChimpDevice paramIChimpDevice) {
        this.impl = paramIChimpDevice;
    }

    public IChimpDevice getImpl() {
        return this.impl;
    }

    public HierarchyViewer getHierarchyViewer() {
        return this.impl.getHierarchyViewer();
    }

    public MonkeyImage takeSnapshot() {
        IChimpImage localIChimpImage = this.impl.takeSnapshot();
        return new MonkeyImage(localIChimpImage);
    }

    public String getProperty(String key) {
        return this.impl.getProperty(key);
    }

    public String getSystemProperty(String key) {
        return this.impl.getSystemProperty(key);
    }

    public void touch(int x, int y, String type) {
        TouchPressType localTouchPressType = TouchPressType.fromIdentifier(type);
        if (localTouchPressType == null) {
            LOG.warning(String.format("Invalid TouchPressType specified (%s) default used instead", type));

            localTouchPressType = TouchPressType.DOWN_AND_UP;
        }
        this.impl.touch(x, y, localTouchPressType);
    }

    public void touch(int x, int y) {
        TouchPressType localTouchPressType = TouchPressType.DOWN_AND_UP;
        this.impl.touch(x, y, localTouchPressType);
    }

    public void drag(int[] start, int[] end) {
        double d = 1.0D;
        long l = (long) (d * 1000.0D);
        int n = 10;
        this.impl.drag(start[0], start[1], end[0], end[1], n, l);
    }

    public void drag(int[] start, int[] end, double duration) {
        long l = (long) (duration * 1000.0D);
        int n = 10;
        this.impl.drag(start[0], start[1], end[0], end[1], n, l);
    }

    public void drag(int[] start, int[] end, double duration, int steps) {
        long l = (long) (duration * 1000.0D);
        this.impl.drag(start[0], start[1], end[0], end[1], steps, l);
    }

    public void press(String name) {
        TouchPressType localTouchPressType = TouchPressType.fromIdentifier("downAndUp");

        this.impl.press(name, localTouchPressType);
    }

    public void press(String name, String type) {
        if (type.equals("DOWN_AND_UP")) {
            type = "downAndUp";
        }
        TouchPressType localTouchPressType = TouchPressType.fromIdentifier(type);

        this.impl.press(name, localTouchPressType);
    }

    public void type(String message) {
        this.impl.type(message);
    }

    public String shell(String cmd) {
        return this.impl.shell(cmd);
    }

    public void reboot(String bootloadType) {
        this.impl.reboot(bootloadType);
    }

    public void reboot() {
        this.impl.reboot(null);
    }

    public boolean installPackage(String path) {
        return this.impl.installPackage(path);
    }

    public boolean removePackage(String packageName) {
        return this.impl.removePackage(packageName);
    }

    public void startActivity() {
        String uri = null;
        String action = null;
        String data = null;
        String mimetype = null;
        Collection<String> categories = null;
        Map<String, Object> extras = null;
        String component = null;
        int flags = 0;

        this.impl.startActivity(uri, action, data, mimetype, categories, extras, component, flags);
    }

    public void startActivity(String uri) {
        String action = null;
        String data = null;
        String mimetype = null;
        Collection<String> categories = null;
        Map<String, Object> extras = null;
        String component = null;
        int flags = 0;

        this.impl.startActivity(uri, action, data, mimetype, categories, extras, component, flags);
    }

    public void startActivity(String uri, String action) {
        String data = null;
        String mimetype = null;
        Collection<String> categories = null;
        Map<String, Object> extras = null;
        String component = null;
        int flags = 0;
        this.impl.startActivity(uri, action, data, mimetype, categories, extras, component, flags);
    }

    public void startActivity(String uri, String action, String data) {
        String mimetype = null;
        Collection<String> categories = null;
        Map<String, Object> extras = null;
        String component = null;
        int flags = 0;
        this.impl.startActivity(uri, action, data, mimetype, categories, extras, component, flags);
    }

    public void startActivity(String uri, String action, String data, String mimetype) {
        Collection<String> categories = null;
        Map<String, Object> extras = null;
        String component = null;
        int flags = 0;
        this.impl.startActivity(uri, action, data, mimetype, categories, extras, component, flags);
    }

    public void startActivity(String uri, String action, String data, String mimetype, Collection<String> categories) {
        Map<String, Object> extras = null;
        String component = null;
        int flags = 0;
        this.impl.startActivity(uri, action, data, mimetype, categories, extras, component, flags);
    }

    public void startActivity(String uri, String action, String data, String mimetype, Collection<String> categories, Map<String, Object> extras) {
        String component = null;
        int flags = 0;
        this.impl.startActivity(uri, action, data, mimetype, categories, extras, component, flags);
    }

    public void startActivity(String uri, String action, String data, String mimetype, Collection<String> categories, Map<String, Object> extras, String component) {
        int flags = 0;
        this.impl.startActivity(uri, action, data, mimetype, categories, extras, component, flags);
    }

    public void startActivity(String uri, String action, String data, String mimetype, Collection<String> categories, Map<String, Object> extras, String component, int flags) {
        this.impl.startActivity(uri, action, data, mimetype, categories, extras, component, flags);
    }

    public void broadcastIntent() {
        String uri = null;
        String action = null;
        String data = null;
        String mimetype = null;
        Collection<String> categories = null;
        Map<String, Object> extras = null;
        String component = null;
        int flags = 0;

        this.impl.broadcastIntent(uri, action, data, mimetype, categories, extras, component, flags);
    }

    public void broadcastIntent(String uri) {
        String action = null;
        String data = null;
        String mimetype = null;
        Collection<String> categories = null;
        Map<String, Object> extras = null;
        String component = null;
        int flags = 0;

        this.impl.broadcastIntent(uri, action, data, mimetype, categories, extras, component, flags);
    }

    public void broadcastIntent(String uri, String action) {
        String data = null;
        String mimetype = null;
        Collection<String> categories = null;
        Map<String, Object> extras = null;
        String component = null;
        int flags = 0;

        this.impl.broadcastIntent(uri, action, data, mimetype, categories, extras, component, flags);
    }

    public void broadcastIntent(String uri, String action, String data) {
        String mimetype = null;
        Collection<String> categories = null;
        Map<String, Object> extras = null;
        String component = null;
        int flags = 0;

        this.impl.broadcastIntent(uri, action, data, mimetype, categories, extras, component, flags);
    }

    public void broadcastIntent(String uri, String action, String data, String mimetype) {
        Collection<String> categories = null;
        Map<String, Object> extras = null;
        String component = null;
        int flags = 0;

        this.impl.broadcastIntent(uri, action, data, mimetype, categories, extras, component, flags);
    }

    public void broadcastIntent(String uri, String action, String data, String mimetype, Collection<String> categories) {
        Map<String, Object> extras = null;
        String component = null;
        int flags = 0;

        this.impl.broadcastIntent(uri, action, data, mimetype, categories, extras, component, flags);
    }

    public void broadcastIntent(String uri, String action, String data, String mimetype, Collection<String> categories, Map<String, Object> extras) {
        String component = null;
        int flags = 0;

        this.impl.broadcastIntent(uri, action, data, mimetype, categories, extras, component, flags);
    }

    public void broadcastIntent(String uri, String action, String data, String mimetype, Collection<String> categories, Map<String, Object> extras, String component) {
        int flags = 0;
        this.impl.broadcastIntent(uri, action, data, mimetype, categories, extras, component, flags);
    }

    public void broadcastIntent(String uri, String action, String data, String mimeType, Collection<String> categories, Map<String, Object> extras, String component, int flags) {
        this.impl.broadcastIntent(uri, action, data, mimeType, categories, extras, component, flags);
    }

    public Map<String, Object> instrument(String className, Map<String, Object> args) {
        if (args == null) {
            args = Collections.emptyMap();
        }
        return this.impl.instrument(className, args);
    }

    public void wake() {
        this.impl.wake();
    }

    public ArrayList<String> getPropertyList() {
        Collection<String> localCollection = this.impl.getPropertyList();
        return new ArrayList<>(localCollection);
    }

    public ArrayList<String> getViewIdList() {
        Collection<String> localCollection = this.impl.getViewIdList();
        return new ArrayList<>(localCollection);
    }

    public MonkeyView getViewById(String viewId) {
        IChimpView localIChimpView = this.impl.getView(By.id(viewId));
        return new MonkeyView(localIChimpView);
    }

    public MonkeyView getViewByAccessibilityIds(Integer i, Integer j) {
        IChimpView localIChimpView = this.impl.getView(By.accessibilityIds(i, j));
        return new MonkeyView(localIChimpView);
    }

    public MonkeyView getRootView() {
        return new MonkeyView(this.impl.getRootView());
    }

    public ArrayList<MonkeyView> getViewsByText(String str) {
        Collection<IChimpView> localCollection = this.impl.getViews(By.text(str));
        ArrayList<MonkeyView> localArrayList = new ArrayList<>();
        for (IChimpView localIChimpView : localCollection) {
            localArrayList.add(new MonkeyView(localIChimpView));
        }
        return localArrayList;
    }
}