package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinKNumber {
        public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
            if(input.length == 0)
                return null;
            else if(input.length < k){
                return new ArrayList(Arrays.asList(input));
            }
            int begin = 0;
            int end = input.length - 1;
            int n = partition(input,begin,end);
            ArrayList<Integer> list = new ArrayList<>();
            while(true){
                if(n == k - 1){
                    for(int i = 0; i <= n; i++){
                        list.add(input[i]);
                    }
                    break;
                }else if(n < k - 1){//向右切分
                    begin = n + 1;
                    n = partition(input,begin,end);
                }else{//向左切分
                    end = n - 1;
                    n = partition(input,begin,end);
                }
            }
            return list;
        }
        //左闭右闭
        int partition(int[] arrays,int begin, int end){
            int base = arrays[begin];
            int lIndex = begin+ 1;
            int rIndex = end;
            while(rIndex > lIndex){
                while(arrays[rIndex] > base && rIndex > lIndex){
                    rIndex--;
                }
                while(arrays[lIndex] <= base && rIndex > lIndex){
                    lIndex++;
                }
                if(rIndex > lIndex){
                    exchange(arrays,lIndex,rIndex);
                }
            }
            exchange(arrays,begin,lIndex);
            return rIndex;
        }
        void exchange(int[] arrays, int a, int b){
            int temp = arrays[a];
            arrays[a] = arrays[b];
            arrays[b] = temp;
        }
        public static void main(String[] args){
            int[] arrays = new int[]{15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
            MinKNumber minKNumber = new MinKNumber();
            List list =minKNumber.GetLeastNumbers_Solution(arrays,7);
            System.out.print(list);
        }
}
