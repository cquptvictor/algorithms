package Proxy.Interrupt;

public class MainApp {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedObject synchronizedObject = new SynchronizedObject();
        MyThread thread = new MyThread(synchronizedObject);
        thread.start();
        thread.sleep(500);
        thread.interrupt();
        System.out.println(synchronizedObject.getName()+synchronizedObject.getPassword());
    }
}
