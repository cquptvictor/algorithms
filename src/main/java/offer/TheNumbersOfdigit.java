package offer;

public class TheNumbersOfdigit {
    public static int NumberOf1(int n) {
        int count = 0;
        int k = 0;
        while(n != 0 && k < 32){
            int temp = n >> 1;
            if(n != temp << 1){
                count++;
            }
            n = temp;
            k++;
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(NumberOf1(-2147483648));
        System.out.println(-10);
    }
}