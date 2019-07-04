package github.dinosu.mock.dog.util;

import android.os.SystemClock;

public abstract class Wait {
    public abstract Boolean apply();

    public static int TIMEOUT = 8000;
    public static Boolean until(Wait condition) {
        long startTime = SystemClock.uptimeMillis();

        Boolean result = condition.apply();
        for (long elapsedTime = 0; result == null || result.equals(false);
             elapsedTime = SystemClock.uptimeMillis() - startTime) {

            if (elapsedTime >= TIMEOUT) {
                break;
            }

            SystemClock.sleep(500);
            result = condition.apply();
        }
        return result;
    }
}
