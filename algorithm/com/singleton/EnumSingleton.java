

package com.singleton;

public enum EnumSingleton {
    INSTANCE(new Object());

    EnumSingleton(Object object){
    }
}
