package offer;

import Proxy.Subject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        int[][] arrays = new int[][]{{1,3},{2,6},{8,10},{15,18},{17,27},{25,45}};
        Main main = new Main();
        List list = main.merge(arrays);
        for(int i = 0; i < list.size(); i++){
            int[] array =(int[]) list.get(i);
            System.out.println(Arrays.toString(array));
            }
        }
    public List<Integer[]> merge(int[][] arrays){
            /*if(arrays == null || arrays.length <= 1){
                return new ArrayList(Arrays.asList(arrays));
            }*/
        List list = new ArrayList();
        for(int i = 1; i < arrays.length; i++){
            if(arrays[i - 1][1] > arrays[i][0] && arrays[i - 1][1] <= arrays[i][1]){
                int[] temp = new int[]{arrays[i - 1][0],arrays[i][1]};
                arrays[i][0] = temp[0];
                arrays[i][1] = temp[1];
            }else{
                list.add(arrays[i - 1]);
            }
        }
        list.add(arrays[arrays.length - 1]);
        return list;
    }
}
