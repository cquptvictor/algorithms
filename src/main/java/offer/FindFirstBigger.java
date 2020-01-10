package offer;

import java.util.Arrays;

/*寻找右边第一个大的数*/
public class FindFirstBigger {

    public static void main(String[] args){
        int[] array = new int[]{1,3,2,5,6,4,7,10};
        int[] stack = new int[array.length];
        int[] result = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            result[i] = -1;
        }
        int top = -1;
        for(int i = 0; i < array.length; i++){
            if(top == -1){
                stack[++top] = i;
            }else{
                while (top != -1 && array[stack[top]] <array[i]){
                    result[stack[top]] = i;
                    top--;
                }
                stack[++top] = i;
            }
        }
        System.out.print(Arrays.toString(result));

    }
}
