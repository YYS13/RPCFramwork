package com.yangyo.rigister;

import java.util.HashMap;
import java.util.Map;

public class LocalRigister {
    public static Map<String, Class> interfaces = new HashMap<>();

    public static void regist(String interfaceName, Class methodClass){
        interfaces.put(interfaceName, methodClass);
    }

    public static Class getMehodClass(String interfaceName){
        return interfaces.get(interfaceName);
    }
}
