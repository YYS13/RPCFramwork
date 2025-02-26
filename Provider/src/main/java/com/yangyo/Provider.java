package com.yangyo;

import com.yangyo.protocal.HttpServer;
import com.yangyo.rigister.LocalRigister;

public class Provider {

    public static void main(String[] args){
        LocalRigister.regist(HelloService.class.getName(), HelloServiceImpl.class);

        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost", 8080);
    }
}
