package offer;

import java.util.ArrayList;
import java.util.List;

/**判断数组是不是某二叉搜索树的后续遍历*/
public class VerifySequenceOfBST {
    //后续遍历的最后一个结点应该是根节点
    public static Boolean verify(int[] array,int start,int end){
        if(start >= end)
            return true;
        int root = array[end];
        int partition;
        //找到分割点
        for(partition = start; partition < end; partition++){
            if(array[partition] > root){
                break;
            }
        }
        //判断右边的是不是全部大于root
        for(int j = partition;j < end; j++){
            if(array[j] <= root){
                return false;
            }
        }
        if(verify(array,start,partition -1) && verify(array,partition,end - 1))
            return true;
        else
            return false;
    }
    public static void main(String[]args){
        //int[] array = new int[]{5,7,6,9,11,10,8};
        //int[] array = new int[]{7,4,6,5};
        //int[] array = new int[]{3,4,7,6,5,11,14,12,10};
        int[] array = new int[]{14,16,15,24,26,20,25};
        Boolean flag = VerifySequenceOfBST.verify(array,0,array.length - 1);
        System.out.println(flag);
    }
}
