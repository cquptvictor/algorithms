package Proxy;


import java.lang.reflect.Proxy;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RealSubject realSubject1 = new RealSubject();
        DynamicProxy dynamicProxy = new DynamicProxy(realSubject1);
        Subject proxy =(Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),new Class[]{Subject.class},dynamicProxy);
        System.out.println(proxy == realSubject1);

        RealSubject realSubject = (RealSubject) Enhant.getEnhancer(RealSubject.class,new CglibInterceptor());
        realSubject.audit();

        realSubject.only();

    }

}
