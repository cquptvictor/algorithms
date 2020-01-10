package offer;

import java.util.HashSet;
import java.util.Set;
/**利用滑动窗口加Set*/
public class FindMaxNotduplicateString {
    public static int lengthOfLongestSubstring(String s) {
        Set set = new HashSet();
        char[] arrays = s.toCharArray();
        int i = 0, j = 0, count = 0;
        for(int k = 0; k <arrays.length;){
            if(!set.contains(arrays[k])){//拿空间换时间
                j++;
                set.add(arrays[k]);
                count = Math.max(count,j - i);
                k++;
            }else{
                set.remove(arrays[i]);
                i++;
            }
        }
        return count;
     /*   char[] arrays = s.toCharArray();
        int[] result = new int[26];
        int count = 0;
        for(int i = 0 ; i < arrays.length; i++){
            for(int j = i; j <arrays.length; j++){
                if(result[arrays[j] - 'a'] == 0) {
                    result[arrays[j] - 'a'] = 1;
                    if(j - i + 1 > count)
                        count = j - i  +  1;
                }else{
                    int k;
                    for( k = i; k < j; k++){
                        result[arrays[k] - 'a'] = 0;
                        if(arrays[k] == arrays[j]){
                            i = i + k;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return count;*/
    }
    public static void main(String[] args){
        int count = FindMaxNotduplicateString.lengthOfLongestSubstring("abcdefg");
        System.out.print(count);
    }
}
