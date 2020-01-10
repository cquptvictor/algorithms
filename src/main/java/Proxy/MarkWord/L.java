package Proxy.MarkWord;

public class L {
    final  int b = 12;
    final int c = 11;
    public void test() throws InterruptedException {
        final int a = 10;
        synchronized (this){
            System.out.println(a);
            Thread.sleep(10000);
        }
    }
    public void test1(){
        synchronized (this){
            System.out.println("test1被锁住了");
        }
    }
}
