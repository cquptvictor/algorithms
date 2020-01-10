package Proxy;

import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        DynamicProxy proxy = new DynamicProxy(realSubject);
        ClassLoader classLoader = realSubject.getClass().getClassLoader();
        Subject subject = (Subject) Proxy.newProxyInstance(classLoader, new  Class[]{Subject.class}, proxy);
        subject.visit();
        subject.audit();
        subject.equals(subject);
    }
}