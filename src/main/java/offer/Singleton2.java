package offer;
/**静态内部类实现单例模式
 * 1.static变量的初始化由JVM控制，保证只会初始化一次
 * 2.静态内部类只有在调用的时候才会进行类加载，所以属于懒汉模式*/
class Singleton2{
    public static Singleton2 singleton2;
    private Singleton2(){}
    private static class SingletonHolder{
        private static Singleton2 singleton2 = new Singleton2();
    }
    public static Singleton2 getInstance(){
        return SingletonHolder.singleton2;
    }
}
