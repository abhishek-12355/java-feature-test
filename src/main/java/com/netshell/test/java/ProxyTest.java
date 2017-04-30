package com.netshell.test.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ashekha on 10/28/2016.
 */
public class ProxyTest implements Test {
    @Override
    public void execute() throws Exception {
        final Class<Test> proxyClass = (Class<Test>) Proxy.getProxyClass(this.getClass().getClassLoader(), Test.class);
        final Test test = proxyClass.getDeclaredConstructor(InvocationHandler.class).newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("Invocation Handler Invoked");
                return null;
            }
        });
        test.execute();;
    }
}
