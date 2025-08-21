package com.gxy.protocol;

import com.gxy.common.Invocation;
import com.gxy.register.LocalRegister;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.concurrent.Callable;

public class HttpServerHandler {
    public void handle(HttpServletRequest req, HttpServletResponse resp) {
        try {
            //获取请求流
            ServletInputStream inputStream = req.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Object obj = objectInputStream.readObject();
            Invocation invocation = (Invocation) obj;
            //获取接口名
            String interfaceName = invocation.getInterfaceName();
            String methodName = invocation.getMethodName();
            Class<?>[] parameterTypes = invocation.getParameterTypes();
            Object[] arguments = invocation.getArguments();
            Class implClass = LocalRegister.get(interfaceName.getClass());
            Method method = implClass.getMethod(methodName, parameterTypes);
            Object invoke = method.invoke(implClass, arguments);

            resp.getWriter().write(invoke.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }
}
