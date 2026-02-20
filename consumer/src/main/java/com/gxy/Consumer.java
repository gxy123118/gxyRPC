package com.gxy;

import com.gxy.client.HttpClient;
import com.gxy.common.Invocation;
import service.HelloService;

import java.io.IOException;

public class Consumer {
    public static void main(String[] args) throws IOException {
        //wtf
//main-a
        //todo
//        HelloService helloService = null;
//        String re = helloService.sayHello("gxy");
//        System.out.println(re);
        Invocation invocation = new Invocation(HelloService.class.getName(), "sayHello",
                new Class[]{String.class}, new Object[]{"gxy"});
        String s = HttpClient.get("localhost", "8181", invocation);
        System.out.println(s);


    }
}
