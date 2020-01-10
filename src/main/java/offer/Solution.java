package offer;

import java.util.*;
import offer.T;
    public class Solution {
        public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
            ArrayList<ArrayList<Integer>> list = new ArrayList();
            //奇数 整数 偶数 xx.5
            for(int i = 2; i < sum; i++){
                if(i % 2 == 1){
                    double temp = sum / (i + 0.0);
                    if(temp % 1 == 0){
                        int temp2 = (int)temp;
                        ArrayList<Integer> arrayList = new ArrayList();
                        for(int j = temp2 - i / 2; j <= temp2 + i / 2; j++){
                            arrayList.add(j);
                        }
                        list.add(arrayList);
                    }
                }else{
                    double temp = sum / (i+0.0);
                    if(temp % 1 == 0.5){
                        int temp2 = (int)temp;
                        ArrayList<Integer> arrayList = new ArrayList();
                        for(int j =temp2 - i / 2 + 1; j <= temp2 + i / 2; j++){
                            arrayList.add(j);
                        }
                        list.add(arrayList);
                    }
                }
            }
            return list;
        }
        public static void main(String[] args){
          //  Solution solution = new Solution();
            //solution.FindContinuousSequence(3);
            String str1 = "nihao";
            String str2 = new String("nihao");
            System.out.println(str2 == str2.intern());
            String str4 = new String("ja") + new String("va");
            String str3 = "java";
            System.out.println(str4 == str4.intern());
            String str6 = new StringBuilder("hello").append("world").toString();
            System.out.println(str6.intern() == "helloworld");
            //String s = "计算机网络";
            //System.out.println(t.test);
            String str7 = new StringBuilder("计算机").append("网络").toString();
            System.out.println(str7.intern() == str7);
            String str8 = new String("你好") + new String("重邮");
            System.out.println(str8.intern() == "你好重邮");
            T t = new T();
            System.out.println(str7.intern() == t.test);
            String str9 = "nihao" + "zyx";
            String str10 = "nihao";
            String str11 = "wnm";
            String str12 = str10 + str11;
            String str13 = str12;
        }
}
