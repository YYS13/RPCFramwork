package com.yangyo;

import com.yangyo.common.Invocation;
import com.yangyo.protocal.HttpClient;
import com.yangyo.proxy.ProxyFactory;

import java.lang.reflect.Proxy;

public class Consumer {

    public static void main(String[] args){
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String result = helloService.sayHello("yangyo123");
        System.out.println(result);

    }
}
