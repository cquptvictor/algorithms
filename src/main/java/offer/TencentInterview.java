package offer;

import javax.swing.plaf.synth.SynthUI;
import java.util.ArrayList;
import java.util.List;

public class TencentInterview {
    private List<List<Integer>> list = new ArrayList();
    public List findTarget(int target, int[] array){
        boolean[] visited = new boolean[array.length];
        find(0,target,array,visited,0);
        return list;
    }
    public void find(int sum, int target, int[] array, boolean[] visited, int index){
        if(sum == target){
            List<Integer> tempList = new ArrayList();
            for(int i = 0; i < array.length; i++){
                if(visited[i])
                    tempList.add(array[i]);
            }
            list.add(tempList);
        }
        for(int i = index; i < array.length; i++){
            sum += array[i];
            visited[i] = true;
            find(sum,target,array,visited,i + 1);
            sum -= array[i];
            visited[i] = false;
        }
    }
    public void splitInteger(List<List<Integer>> list,int target,int[] visited){
        if(target == 0){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < visited.length; i++){
                for(int j = 0; j < visited[i]; j++) {
                    temp.add(i);
                }
            }
            list.add(temp);
        }
        for(int i = 1; i <= target; i++){
            visited[i] += 1;
            splitInteger(list,target - i,visited);
            visited[i] -= 1 ;
        }
    }

    public static void main(String[] args){
        /*int[] array = new int[]{1,2,3,4,5,6};
        TencentInterview tencentInterview = new TencentInterview();
        tencentInterview.findTarget(7,array);
        System.out.println(tencentInterview.list);*/
        //正整数的分解
        List<List<Integer>> list = new ArrayList<>();
        TencentInterview tencentInterview = new TencentInterview();
        System.out.println(list);
    }
}
