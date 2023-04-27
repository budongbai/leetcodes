

package com.budongbai.singleton;

public class DoubleCheckLockSingleton {
    private volatile static Object object;

    private DoubleCheckLockSingleton() {

    }

    public static Object getSingleton() {
        if (object == null) {
            synchronized (DoubleCheckLockSingleton.class) {
                if (object == null) {
                    object = new Object();
                }
            }
        }
        return object;
    }
}
