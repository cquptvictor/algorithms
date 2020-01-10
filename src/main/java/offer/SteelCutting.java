package offer;

import java.util.Arrays;

public class SteelCutting {
    public int[] price;
    public SteelCutting(int[] price){
        this.price = price;
    }
    //递归实现
    public int cut(int length){
        if(length == 0){
            return 0;
        }
        int q = Integer.MIN_VALUE;
        for(int i = 1; i <= length; i++){
            q = Math.max(q,price[i - 1] + cut(length - i));
        }
        return q;
    }
    //备忘录实现
    public int cut(int[] max,int length){
        int q = Integer.MIN_VALUE;
        if(max[length] > 0){
            return max[length];
        }
        if(length == 0){
            max[length] = 0;
            return 0;
        }else {
            for (int i = 1; i <= length; i++) {
                q = Math.max(q, price[i - 1] + cut(max,length - i));
            }
        }
        max[length] = q;
        return q;
    }
    //自底向上
    public int[] cutFromButton(int length){
        int[] max = new int[length + 1];
        max[0] = 0;
        int q;
        for(int i = 1; i <= length; i++){
            q = -1;
            for(int j = 1; j <= i; j++){
                q = Math.max(q, price[j - 1] + max[i - j]);
            }
            max[i] = q;
        }
        return max;
    }
    public static void main(String[] args){
        int[] array = new int[]{1,5,8,9,10,17,17,20,24,30};
        SteelCutting steelCutting = new SteelCutting(array);
        int[] max = new int[]{-1,-1,-1,-1,-1};
        //steelCutting.cut(max,4);
        int[] arrays = steelCutting.cutFromButton(4);
        System.out.println(Arrays.toString(arrays));
    }
}
