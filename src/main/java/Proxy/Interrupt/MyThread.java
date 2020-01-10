package Proxy.Interrupt;

public class MyThread extends Thread {
    private SynchronizedObject synchronizedObject;
    public MyThread(SynchronizedObject synchronizedObject){
        this.synchronizedObject = synchronizedObject;
    }
    @Override
    public void run() {
        synchronizedObject.printString("name","password");
    }
}
