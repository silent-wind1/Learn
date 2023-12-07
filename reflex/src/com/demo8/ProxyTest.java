package com.demo8;


import com.sun.deploy.net.proxy.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;

interface Human {
    String getBelief();
    void eat(String food);
}

// 被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("最喜欢的食物" + food);
    }
}

// 代理类
class ProxyFactory {
    // 调用此方法，返回一个代理类的对象，解决问题一
    public static Object getProxy(Object obj) { // obj:被代理类的对象
        MyProxyHandler handler = new MyProxyHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyProxyHandler implements InvocationHandler {
    private Object obj;

    public void bind(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // methods: 即为代理类对象调用的方法，此方法也就作为被代理对象要调用的方法
        // obj：被代理类的对象
        return method.invoke(obj, args);
    }
}
public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
//        proxyInstance: 代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxy(superMan);
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("肯德基");
    }
}
