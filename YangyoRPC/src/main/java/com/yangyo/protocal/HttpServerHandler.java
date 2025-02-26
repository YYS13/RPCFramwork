package com.yangyo.protocal;

import com.yangyo.common.Invocation;
import com.yangyo.rigister.LocalRigister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp){
        //處理發過來的訊息內容
        try {
            Invocation invocation = (Invocation)new ObjectInputStream(req.getInputStream()).readObject();
            String interfaceName = invocation.getInterfaceName();

            Class methodClass = LocalRigister.getMehodClass(interfaceName);

            if(methodClass != null){
                try {
                    Method method = methodClass.getMethod(invocation.getMethodName(), invocation.getParametersTypes());
                    try {
                        Object result = method.invoke(methodClass.newInstance(), invocation.getParameters());

                        //把結果寫回 response
                        IOUtils.write((String) result, resp.getOutputStream());
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    } catch (InstantiationException e) {
                        throw new RuntimeException(e);
                    }
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }

            }else{
                System.out.println("Can't find the service");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
