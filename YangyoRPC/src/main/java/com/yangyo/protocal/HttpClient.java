package com.yangyo.protocal;

import com.yangyo.common.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpClient {
    //client 端發送請求
    public String send(String hostname, Integer port, Invocation invocation){
        try {
            URL url = new URL("http", hostname, port, "/");
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                // 配置
                OutputStream outputStream = httpURLConnection.getOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(outputStream);

                oos.writeObject(invocation);
                oos.flush();
                oos.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                String result = IOUtils.toString(inputStream);

                return result;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
