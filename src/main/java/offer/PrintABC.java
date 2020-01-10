package offer;


public class PrintABC {
    int flag = -1;
    Object lock = new Object();
    class PrintA implements Runnable{
        @Override
        public void run() {
            synchronized (lock) {
                while (true) {
                    if (flag == -1) {
                        System.out.println(Thread.currentThread().getName() + "--" + "A");
                        flag = 0;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    class PrintB implements Runnable{
        @Override
        public void run() {
            synchronized (lock) {
                while (true) {
                    if (flag == 0) {
                        System.out.println(Thread.currentThread().getName() + "--" + "B");
                        flag = 1;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    class PrintC implements Runnable{
        @Override
        public void run() {
            synchronized (lock) {
                while (true) {
                    if (flag == 1) {
                        System.out.println(Thread.currentThread().getName() + "--" + "C");
                        flag = -1;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        PrintABC printABC = new PrintABC();
        Thread thread1 = new Thread(printABC.new PrintA());
        Thread thread2 = new Thread(printABC.new PrintB());
        Thread thread3 = new Thread(printABC.new PrintC());
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
