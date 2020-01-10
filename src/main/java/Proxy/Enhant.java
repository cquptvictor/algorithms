package Proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class Enhant {

    public static Object getEnhancer(Class superClass, MethodInterceptor callback){
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(callback);
        enhancer.setSuperclass(superClass);

        return enhancer.create();
    }
}
