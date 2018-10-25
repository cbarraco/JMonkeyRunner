package com.android.monkeyrunner;

import com.android.chimpchat.core.*;
import com.android.chimpchat.hierarchyviewer.HierarchyViewer;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Logger;

public class MonkeyDevice {

    public static final String DOWN = TouchPressType.DOWN.getIdentifier();
    public static final String UP = TouchPressType.UP.getIdentifier();
    public static final String DOWN_AND_UP = TouchPressType.DOWN_AND_UP.getIdentifier();
    private static final Logger LOG = Logger.getLogger(MonkeyDevice.class.getName());
    private IChimpDevice chimpDevice;

    public MonkeyDevice(IChimpDevice chimpDevice) {
        this.chimpDevice = chimpDevice;
    }

    /**
     * Gets the ChimpDevice interface for this MonkeyDevice
     *
     * @return The ChimpDevice interface
     */
    public IChimpDevice getChimpDevice() {
        return chimpDevice;
    }

    /**
     * Broadcasts an Intent to this device, as if the Intent were coming from an application. See Intent for more information about the arguments.
     */
    public void broadcastIntent() {
        broadcastIntent(null, null, null, null, null, null, null, 0);
    }

    /**
     * Broadcasts an Intent to this device, as if the Intent were coming from an application. See Intent for more information about the arguments.
     *
     * @param uri The URI for the Intent.
     */
    public void broadcastIntent(String uri) {
        broadcastIntent(uri, null, null, null, null, null, null, 0);
    }

    /**
     * Broadcasts an Intent to this device, as if the Intent were coming from an application. See Intent for more information about the arguments.
     *
     * @param uri    The URI for the Intent.
     * @param action The action for this Intent.
     */
    public void broadcastIntent(String uri, String action) {
        broadcastIntent(uri, action, null, null, null, null, null, 0);
    }

    /**
     * Broadcasts an Intent to this device, as if the Intent were coming from an application. See Intent for more information about the arguments.
     *
     * @param uri    The URI for the Intent.
     * @param action The action for this Intent.
     * @param data   The data URI for this Intent.
     */
    public void broadcastIntent(String uri, String action, String data) {
        broadcastIntent(uri, action, data, null, null, null, null, 0);
    }

    /**
     * Broadcasts an Intent to this device, as if the Intent were coming from an application. See Intent for more information about the arguments.
     *
     * @param uri    The URI for the Intent.
     * @param action The action for this Intent.
     * @param data   The data URI for this Intent.
     */
    public void broadcastIntent(String uri, String action, String data, String mimetype) {
        broadcastIntent(uri, action, data, mimetype, null, null, null, 0);
    }

    /**
     * Broadcasts an Intent to this device, as if the Intent were coming from an application. See Intent for more information about the arguments.
     *
     * @param uri        The URI for the Intent.
     * @param action     The action for this Intent.
     * @param data       The data URI for this Intent.
     * @param mimeType   The MIME type for the Intent.
     * @param categories An iterable data structure containing strings that define categories for this Intent.
     */
    public void broadcastIntent(String uri, String action, String data, String mimeType, Collection<String> categories) {
        broadcastIntent(uri, action, data, mimeType, categories, null, null, 0);
    }

    /**
     * Broadcasts an Intent to this device, as if the Intent were coming from an application. See Intent for more information about the arguments.
     *
     * @param uri        The URI for the Intent.
     * @param action     The action for this Intent.
     * @param data       The data URI for this Intent.
     * @param mimeType   The MIME type for the Intent.
     * @param categories An iterable data structure containing strings that define categories for this Intent.
     * @param extras     A dictionary of extra data for this Intent. The key for each dictionary item should be a string. The item's value can be any simple or structured data type.
     */
    public void broadcastIntent(String uri, String action, String data, String mimeType, Collection<String> categories, Map<String, Object> extras) {
        broadcastIntent(uri, action, data, mimeType, categories, extras, null, 0);
    }

    /**
     * Broadcasts an Intent to this device, as if the Intent were coming from an application. See Intent for more information about the arguments.
     *
     * @param uri        The URI for the Intent.
     * @param action     The action for this Intent.
     * @param data       The data URI for this Intent.
     * @param mimeType   The MIME type for the Intent.
     * @param categories An iterable data structure containing strings that define categories for this Intent.
     * @param extras     A dictionary of extra data for this Intent. The key for each dictionary item should be a string. The item's value can be any simple or structured data type.
     * @param component  The component for this Intent. Using this argument will direct the Intent to a specific class within a specific Android package.
     */
    public void broadcastIntent(String uri, String action, String data, String mimeType, Collection<String> categories, Map<String, Object> extras, String component) {
        broadcastIntent(uri, action, data, mimeType, categories, extras, component, 0);
    }

    /**
     * Broadcasts an Intent to this device, as if the Intent were coming from an application. See Intent for more information about the arguments.
     *
     * @param uri        The URI for the Intent.
     * @param action     The action for this Intent.
     * @param data       The data URI for this Intent.
     * @param mimeType   The MIME type for the Intent.
     * @param categories An iterable data structure containing strings that define categories for this Intent.
     * @param extras     A dictionary of extra data for this Intent. The key for each dictionary item should be a string. The item's value can be any simple or structured data type.
     * @param component  The component for this Intent. Using this argument will direct the Intent to a specific class within a specific Android package.
     * @param flags      An iterable data structure containing flags that control how the Intent is handled
     */
    public void broadcastIntent(String uri, String action, String data, String mimeType, Collection<String> categories, Map<String, Object> extras, String component, int flags) {
        this.chimpDevice.broadcastIntent(uri, action, data, mimeType, categories, extras, component, flags);
    }

    /**
     * Simulates a drag gesture (touch, hold, and move) on this device's screen.
     *
     * @param start The starting point of the drag gesture, in the form of an array {x,y} where x and y are integers.
     * @param end   The end point of the drag gesture, in the form of an array {x,y} where x and y are integers.
     */
    public void drag(int[] start, int[] end) {
        drag(start, end, 1.0D, 10);
    }

    /**
     * Simulates a drag gesture (touch, hold, and move) on this device's screen.
     *
     * @param start The starting point of the drag gesture
     * @param end   The end point of the drag gesture
     */
    public void drag(Point start, Point end) {
        drag(new int[]{start.x, start.y}, new int[]{end.x, end.y});
    }

    /**
     * Simulates a drag gesture (touch, hold, and move) on this device's screen.
     *
     * @param start    The starting point of the drag gesture, in the form of an array {x,y} where x and y are integers.
     * @param end      The end point of the drag gesture, in the form of an array {x,y} where x and y are integers.
     * @param duration The duration of the drag gesture in seconds.
     */
    public void drag(int[] start, int[] end, double duration) {
        drag(start, end, duration, 10);
    }

    /**
     * Simulates a drag gesture (touch, hold, and move) on this device's screen.
     *
     * @param start    The starting point of the drag gesture.
     * @param end      The end point of the drag gesture.
     * @param duration The duration of the drag gesture in seconds.
     */
    public void drag(Point start, Point end, double duration) {
        drag(new int[]{start.x, start.y}, new int[]{end.x, end.y}, duration);
    }

    /**
     * Simulates a drag gesture (touch, hold, and move) on this device's screen.
     *
     * @param start    The starting point of the drag gesture, in the form of an array {x,y} where x and y are integers.
     * @param end      The end point of the drag gesture, in the form of a tuple (x,y) where x and y are integers.
     * @param duration The duration of the drag gesture in seconds.
     * @param steps    The number of steps to take when interpolating points.
     */
    public void drag(int[] start, int[] end, double duration, int steps) {
        long durationLong = (long) (duration * 1000.0D);
        this.chimpDevice.drag(start[0], start[1], end[0], end[1], steps, durationLong);
    }

    /**
     * Simulates a drag gesture (touch, hold, and move) on this device's screen.
     *
     * @param start    The starting point of the drag gesture, in the form of an array {x,y} where x and y are integers.
     * @param end      The end point of the drag gesture, in the form of a tuple (x,y) where x and y are integers.
     * @param duration The duration of the drag gesture in seconds.
     * @param steps    The number of steps to take when interpolating points.
     */
    public void drag(Point start, Point end, double duration, int steps) {
        drag(new int[]{start.x, start.y}, new int[]{end.x, end.y}, duration, steps);
    }

    public HierarchyViewer getHierarchyViewer() {
        return this.chimpDevice.getHierarchyViewer();
    }

    /**
     * Given the name of a system environment variable, returns its value for this device.
     *
     * @param key The name of the system environment variable. The available variable names are listed in Table 1. Property variable names at the end of this topic.
     * @return The value of the variable. The data format varies according to the variable requested.
     */
    public String getProperty(String key) {
        return this.chimpDevice.getProperty(key);
    }

    /**
     * Returns a list of all available system environment variables
     *
     * @return A list of all available system environment variables
     */
    public ArrayList<String> getPropertyList() {
        Collection<String> localCollection = this.chimpDevice.getPropertyList();
        return new ArrayList<String>(localCollection);
    }

    public MonkeyView getRootView() {
        return new MonkeyView(this.chimpDevice.getRootView());
    }

    /**
     * Synonym for getProperty().
     *
     * @param key The name of the system environment variable. The available variable names are listed in Table 1. Property Variable Names.
     * @return The value of the variable. The data format varies according to the variable requested.
     */
    public String getSystemProperty(String key) {
        return this.chimpDevice.getSystemProperty(key);
    }

    public MonkeyView getViewByAccessibilityIds(Integer i, Integer j) {
        IChimpView chimpView = this.chimpDevice.getView(By.accessibilityIds(i, j));
        return new MonkeyView(chimpView);
    }

    public MonkeyView getViewById(String viewId) {
        IChimpView chimpView = this.chimpDevice.getView(By.id(viewId));
        return new MonkeyView(chimpView);
    }

    public ArrayList<MonkeyView> getViewsByText(String str) {
        Collection<IChimpView> chimpViews = this.chimpDevice.getViews(By.text(str));
        ArrayList<MonkeyView> monkeyViews = new ArrayList<MonkeyView>();
        for (IChimpView chimpView : chimpViews) {
            monkeyViews.add(new MonkeyView(chimpView));
        }
        return monkeyViews;
    }

    public ArrayList<String> getViewIdList() {
        Collection<String> idList = this.chimpDevice.getViewIdList();
        return new ArrayList<String>(idList);
    }

    /**
     * Installs the Android application or test package contained in packageFile onto this device. If the application or test package is already installed, it is replaced.
     *
     * @param path The fully-qualified path and filename of the .apk file to install.
     * @return True if successful, false otherwise
     */
    public boolean installPackage(String path) {
        return this.chimpDevice.installPackage(path);
    }

    /**
     * Runs the specified component with Android instrumentation, and returns the results in a dictionary whose exact format is dictated by the component being run. The component must already be present on this device.
     * <p/>
     * Use this method to start a test case that uses one of Android's test case classes. See Testing Fundamentals to learn more about unit testing with the Android testing framework.
     *
     * @param className The name of an Android component that is already installed on this device, in the standard form packagename/classname, where packagename is the Android package name of a .apk file on this device, and classname is the class name of an Android component (Activity, ContentProvider, Service, or BroadcastReceiver) in that file. Both packagename and classname must be fully qualified. See ComponentName for more details.
     * @param args      A dictionary containing flags and their values. These are passed to the component as it is started. If the flag does not take a value, set its dictionary value to an empty string.
     * @return A dictionary containing the component's output. The contents of the dictionary are defined by the component itself.
     *         <p/>
     *         If you use InstrumentationTestRunner as the class name in the componentName argument, then the result dictionary contains the single key "stream". The value of "stream" is a string containing the test output, as if InstrumentationTestRunner was run from the command line. The format of this output is described in Testing in Other IDEs.
     */
    public Map<String, Object> instrument(String className, Map<String, Object> args) {
        if (args == null) {
            args = Collections.emptyMap();
        }
        return this.chimpDevice.instrument(className, args);
    }

    /**
     * Sends the key event specified by type to the key specified by keycode.
     *
     * @param name The name of the keycode to send. See KeyEvent for a list of keycode names. Use the keycode name, not its integer value.
     */
    public void press(String name) {
        TouchPressType localTouchPressType = TouchPressType.fromIdentifier("downAndUp");
        this.chimpDevice.press(name, localTouchPressType);
    }

    /**
     * Sends the key event specified by type to the key specified by keycode.
     *
     * @param name The name of the keycode to send. See KeyEvent for a list of keycode names. Use the keycode name, not its integer value.
     * @param type The type of key event to send. The allowed values are DOWN, UP, and DOWN_AND_UP.
     */
    public void press(String name, String type) {
        if (type.equals("DOWN_AND_UP")) {
            type = "downAndUp";
        }
        TouchPressType localTouchPressType = TouchPressType.fromIdentifier(type);

        this.chimpDevice.press(name, localTouchPressType);
    }

    /**
     * Reboots this device into the bootloader specified by bootloadType.
     *
     * @param bootloadType The type of bootloader to reboot into. The allowed values are "bootloader", "recovery", or "None".
     */
    public void reboot(String bootloadType) {
        this.chimpDevice.reboot(bootloadType);
    }

    /**
     * Reboots this device.
     */
    public void reboot() {
        this.chimpDevice.reboot(null);
    }

    /**
     * Deletes the specified package from this device, including its data and cache.
     *
     * @param packageName The Android package name an app on this device.
     * @return True if successful, false otherwise.
     */
    public boolean removePackage(String packageName) {
        return this.chimpDevice.removePackage(packageName);
    }

    /**
     * Executes an adb shell command and returns the result, if any.
     *
     * @param cmd The command to execute in the adb shell. The form of these commands is described in the topic Android Debug Bridge.
     * @return The results of the command, if any. The format of the results is determined by the command.
     */
    public String shell(String cmd) {
        return this.chimpDevice.shell(cmd);
    }

    /**
     * Starts an Activity on this device by sending an Intent constructed from the supplied arguments.
     */
    public void startActivity() {
        startActivity(null, null, null, null, null, null, null, 0);
    }

    /**
     * Starts an Activity on this device by sending an Intent constructed from the supplied arguments.
     *
     * @param uri The URI for the Intent.
     */
    public void startActivity(String uri) {
        startActivity(uri, null, null, null, null, null, null, 0);
    }

    /**
     * Starts an Activity on this device by sending an Intent constructed from the supplied arguments.
     *
     * @param uri    The URI for the Intent.
     * @param action The action for the Intent.
     */
    public void startActivity(String uri, String action) {
        startActivity(uri, action, null, null, null, null, null, 0);
    }

    /**
     * Starts an Activity on this device by sending an Intent constructed from the supplied arguments.
     *
     * @param uri    The URI for the Intent.
     * @param action The action for the Intent.
     * @param data   The data URI for the Intent.
     */
    public void startActivity(String uri, String action, String data) {
        startActivity(uri, action, data, null, null, null, null, 0);
    }

    /**
     * Starts an Activity on this device by sending an Intent constructed from the supplied arguments.
     *
     * @param uri      The URI for the Intent.
     * @param action   The action for the Intent.
     * @param data     The data URI for the Intent.
     * @param mimeType The MIME type for the Intent.
     */
    public void startActivity(String uri, String action, String data, String mimeType) {
        startActivity(uri, action, data, mimeType, null, null, null, 0);
    }

    /**
     * Starts an Activity on this device by sending an Intent constructed from the supplied arguments.
     *
     * @param uri        The URI for the Intent.
     * @param action     The action for the Intent.
     * @param data       The data URI for the Intent.
     * @param mimeType   The MIME type for the Intent.
     * @param categories An iterable data structure containing strings that define categories for the Intent.
     */
    public void startActivity(String uri, String action, String data, String mimeType, Collection<String> categories) {
        startActivity(uri, action, data, mimeType, categories, null, null, 0);
    }

    /**
     * Starts an Activity on this device by sending an Intent constructed from the supplied arguments.
     *
     * @param uri        The URI for the Intent.
     * @param action     The action for the Intent.
     * @param data       The data URI for the Intent.
     * @param mimeType   The MIME type for the Intent.
     * @param categories An iterable data structure containing strings that define categories for the Intent.
     * @param extras     A dictionary of extra data for the Intent (see Intent.putExtra() for an example).
     *                   The key for each dictionary item should be a string. The item's value can be any simple or structured data type.
     */
    public void startActivity(String uri, String action, String data, String mimeType, Collection<String> categories, Map<String, Object> extras) {
        startActivity(uri, action, data, mimeType, categories, extras, null, 0);
    }

    /**
     * Starts an Activity on this device by sending an Intent constructed from the supplied arguments.
     *
     * @param uri        The URI for the Intent.
     * @param action     The action for the Intent.
     * @param data       The data URI for the Intent.
     * @param mimeType   The MIME type for the Intent.
     * @param categories An iterable data structure containing strings that define categories for the Intent.
     * @param extras     A dictionary of extra data for the Intent (see Intent.putExtra() for an example).
     *                   The key for each dictionary item should be a string. The item's value can be any simple or structured data type.
     * @param component  The component for the Intent (see ComponentName). Using this argument will direct the Intent to a specific class within a specific Android package.
     */
    public void startActivity(String uri, String action, String data, String mimeType, Collection<String> categories, Map<String, Object> extras, String component) {
        startActivity(uri, action, data, mimeType, categories, extras, component, 0);
    }

    /**
     * Starts an Activity on this device by sending an Intent constructed from the supplied arguments.
     *
     * @param uri        The URI for the Intent.
     * @param action     The action for the Intent.
     * @param data       The data URI for the Intent.
     * @param mimeType   The MIME type for the Intent.
     * @param categories An iterable data structure containing strings that define categories for the Intent.
     * @param extras     A dictionary of extra data for the Intent (see Intent.putExtra() for an example).
     *                   The key for each dictionary item should be a string. The item's value can be any simple or structured data type.
     * @param component  The component for the Intent (see ComponentName). Using this argument will direct the Intent to a specific class within a specific Android package.
     * @param flags      An iterable data structure containing flags that control how the Intent is handled.
     */
    public void startActivity(String uri, String action, String data, String mimeType, Collection<String> categories, Map<String, Object> extras, String component, int flags) {
        this.chimpDevice.startActivity(uri, action, data, mimeType, categories, extras, component, flags);
    }

    /**
     * Captures the entire screen buffer of this device, yielding a screen capture of the current display.
     *
     * @return A MonkeyImage object containing the image of the current display.
     */
    public MonkeyImage takeSnapshot() {
        IChimpImage localIChimpImage = this.chimpDevice.takeSnapshot();
        return new MonkeyImage(localIChimpImage);
    }

    /**
     * Sends a touch event specified by type to the screen location specified by x and y
     *
     * @param x    The horizontal position of the touch in actual device pixels, starting from the left of the screen in its current orientation
     * @param y    The vertical position of the touch in actual device pixels, starting from the top of the screen in its current orientation
     * @param type The type of key event to send. The allowed values are {@link #DOWN}, {@link #UP}, and {@link #DOWN_AND_UP}
     */
    public void touch(int x, int y, String type) {
        TouchPressType touchPressType = TouchPressType.fromIdentifier(type);
        if (touchPressType == null) {
            LOG.warning(String.format("Invalid TouchPressType specified (%s) default used instead", type));
            touchPressType = TouchPressType.DOWN_AND_UP;
        }
        this.chimpDevice.touch(x, y, touchPressType);
    }

    /**
     * Sends a touch event specified by type to the screen location specified by x and y
     * @param touchPoint
     * @param type The type of key event to send. The allowed values are {@link #DOWN}, {@link #UP}, and {@link #DOWN_AND_UP}
     */
    public void touch(Point touchPoint, String type) {
        TouchPressType touchPressType = TouchPressType.fromIdentifier(type);
        if (touchPressType == null) {
            LOG.warning(String.format("Invalid TouchPressType specified (%s) default used instead", type));
            touchPressType = TouchPressType.DOWN_AND_UP;
        }
        this.chimpDevice.touch(touchPoint.x, touchPoint.y, touchPressType);
    }

    /**
     * Sends a touch event specified by type to the screen location specified by x and y
     *
     * @param x The horizontal position of the touch in actual device pixels, starting from the left of the screen in its current orientation
     * @param y The vertical position of the touch in actual device pixels, starting from the top of the screen in its current orientation
     */
    public void touch(int x, int y) {
        touch(x, y, DOWN_AND_UP);
    }

    /**
     * Sends a touch event specified by type to the screen location specified by x and y
     *
     * @param touchPoint The Point on the screen to touch
     */
    public void touch(Point touchPoint) {
        touch(touchPoint.x, touchPoint.y);
    }

    /**
     * Sends the characters contained in message to this device, as if they had been typed on the device's keyboard. This is equivalent to calling press() for each keycode in message using the key event type DOWN_AND_UP.
     *
     * @param message A string containing the characters to send.
     */
    public void type(String message) {
        this.chimpDevice.type(message);
    }

    /**
     * Wakes the screen of this device.
     */
    public void wake() {
        this.chimpDevice.wake();
    }

}