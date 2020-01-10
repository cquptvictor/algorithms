package Proxy.MarkWord;

import org.openjdk.jol.info.ClassLayout;

public class Main {
    static L l = new L();
    public static void main(String[] args){
    /*    Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    l.test();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                l.test1();
            }
        });
        thread.start();
        thread1.start();*/
    System.out.println(ClassLayout.parseInstance(l).toPrintable());
    //System.out.println(ClassLayout.parseClass(l.getClass()).toPrintable());
    }

}
