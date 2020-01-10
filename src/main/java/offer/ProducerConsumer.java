package offer;


public class ProducerConsumer {
    int count;
    Object lock = "lock";

    class Producer implements Runnable{
        @Override
        public void run() {
            synchronized (lock) {
                while (true) {

                    if (count == 1000000000) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        count++;
                        System.out.println("生产者"+Thread.currentThread().getName()+"生产了一个后，还剩"+count);
                        lock.notifyAll();
                    }
                }
            }
        }
    }
    class Consumer implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                while (true){

                    if(count == 0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        count--;
                        System.out.println("消费者"+Thread.currentThread().getName()+"消费了一个后，还剩"+count);
                        lock.notifyAll();
                    }
                }

            }
        }
    }
    public static void main(String[] args){
        ProducerConsumer producerConsumer =new ProducerConsumer();
        Thread thread = new Thread(producerConsumer.new Producer());
        Thread thread2 = new Thread(producerConsumer.new Producer());
        Thread thread3 = new Thread(producerConsumer.new Producer());
        Thread thread1 = new Thread(producerConsumer.new Consumer());
        Thread thread4 = new Thread(producerConsumer.new Consumer());
        Thread thread5 = new Thread(producerConsumer.new Consumer());
        thread.setPriority(5);
        thread1.setPriority(5);
        thread2.setPriority(5);
        thread3.setPriority(5);
        thread4.setPriority(5);
        thread5.setPriority(5);

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
