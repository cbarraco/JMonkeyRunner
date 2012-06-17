import com.android.monkeyrunner.MonkeyDevice;
import com.android.monkeyrunner.MonkeyRunner;

/**
 * Created by IntelliJ IDEA.
 * User: Carlo
 * Date: 16/04/12
 * Time: 11:34 PM
 */
public class Main {
    public static void main(String[] args) {
        MonkeyRunner monkeyRunner = new MonkeyRunner();
        MonkeyDevice device = monkeyRunner.waitForConnection();
        device.touch(100, 100);
        for (String s : device.getPropertyList())
            System.out.println(device.getProperty(s));
        System.exit(1);
    }
}
