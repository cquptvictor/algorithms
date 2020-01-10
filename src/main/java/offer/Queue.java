package offer;

public class Queue {
    private int[] queue;
    private int front;
    private int tail;
    private int length;
    public Queue(int n){
        queue = new int[n];
        front = 0;
        tail = 0;
        length = n;
    }
    public boolean in(int value){
        if((tail + 1)%length != front) {
            tail = ++tail % length;
            queue[tail] = value;
            return true;
        }else{
            return false;
        }
    }
    public int out(){
        if(front != tail){
            front = ++front % length;
            return queue[front];
        }else {
            return -1;
        }
    }
    public static void main(String[] args){
        Queue queue = new Queue(5);
        queue.in(1);
        queue.in(2);
        queue.in(3);
        queue.in(4);
        queue.in(5);
        System.out.println(queue.in(6));
        System.out.println(queue.out());
        System.out.println(queue.out());
        System.out.println(queue.out());
        System.out.println(queue.out());
        System.out.println(queue.out());
        queue.in(10);
        queue.in(20);
        System.out.println(queue.out());
        System.out.println(queue.out());
        System.out.println(queue.out());
        System.out.println(queue.out());

    }
}
