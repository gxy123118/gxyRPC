package com.gxy.client;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.gxy.common.Invocation;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class HttpClient {


    public static String get(String host, String port, Invocation invocation) throws IOException {
        // 将Invocation对象序列化为字节数组
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(invocation);
        byte[] serializedData = bos.toByteArray();

        HttpResponse execute = HttpUtil.createPost("http://" + host + ":" + port)
                .body(serializedData)
                .execute();


        return execute.body();
    }
}
