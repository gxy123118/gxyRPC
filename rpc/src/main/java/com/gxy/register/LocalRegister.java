package com.gxy.register;

import java.util.HashMap;
import java.util.Map;

public class LocalRegister {

    private static  Map<Class, Class> REGISTER = new HashMap<>();

    public static void register(Class interfaceName, Class implClass) {
        REGISTER.put(interfaceName, implClass);
    }

    // 获取实现类
    public static Class get(Class interfaceName) {
        return REGISTER.get(interfaceName);
    }

    public static Map<Class, Class> getREGISTER() {
        return REGISTER;
    }
}
