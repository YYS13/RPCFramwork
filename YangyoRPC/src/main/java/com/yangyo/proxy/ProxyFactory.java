package com.yangyo.proxy;

import com.yangyo.common.Invocation;
import com.yangyo.protocal.HttpClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static <T> T getProxy(Class interfaceClass){
        // 用戶配置

        Object proxyInstance = Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                //創建發送 data
                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), method.getParameterTypes(), objects);

                //發送
                HttpClient httpClient = new HttpClient();
                String result = httpClient.send("localhost", 8080, invocation);

                return result;
            }
        });

        return (T)proxyInstance;
    }
}
