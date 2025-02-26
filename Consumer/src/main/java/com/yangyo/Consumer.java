package com.yangyo;

import com.yangyo.common.Invocation;
import com.yangyo.protocal.HttpClient;

public class Consumer {

    public static void main(String[] args){
        //創建發送 data
        Invocation invocation = new Invocation(HelloService.class.getName(), "sayHello", new Class[]{String.class}, new Object[]{"yangyo"});

        //發送
        HttpClient httpClient = new HttpClient();
        String result = httpClient.send("localhost", 8080, invocation);
        System.out.println(result);
    }
}
