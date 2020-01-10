package offer;

public class PrintOneTwo {
    int count = 0;
    boolean flag = false;

    class printOdd implements Runnable {
        private Object lock;

        public printOdd(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                while (count <= 100) {
                    if (flag) {
                        System.out.println(count);
                        flag = false;
                        count++;
                        lock.notify();
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
    class printEven implements Runnable {
        private Object lock;

        public printEven(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                while(count <= 100) {
                    if (!flag) {
                        System.out.println("----------" + count);
                        flag = true;
                        count++;
                        lock.notify();
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
        PrintOneTwo printOneTwo = new PrintOneTwo();
        Thread thread = new Thread(printOneTwo.new printOdd(printOneTwo));
        Thread thread2 = new Thread(printOneTwo.new printEven(printOneTwo));
        thread.start();
        thread2.start();
    }
}
