package offer;
/**DCL
 *1.私有化构造函数
 * 2.静态方法，需要类锁
 * 3.双重检查保证不重复生成
 * */
public class Singleton {
    private volatile static Singleton singleton;
    private Singleton(){

    }
    public static Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
