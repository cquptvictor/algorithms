package offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//中文数字转换为阿拉伯数字
public class ConvertToNumbers {
    Map<Character,Integer> map;
    char[] unitMap;
    char[] numMap;
    public ConvertToNumbers() {
        this.map = new HashMap<>();
        map.put('零',0);
        map.put('一',1);
        map.put('二',2);
        map.put('三',3);
        map.put('四',4);
        map.put('五',5);
        map.put('六',6);
        map.put('七',7);
        map.put('八',8);
        map.put('九',9);
        map.put('十',10);
        map.put('百',100);
        map.put('千',1000);
        map.put('万',10000);
        map.put('亿',100000000);
        unitMap = new char[]{'个','十','百','千','万','个','十','百','千','亿','个','十','百','千','万'};
        numMap = new char[]{'零','一','二','三','四','五','六','七','八','九'};
    }
    //个十百千与万、亿是两种类型的单位
    public void Convert(String numerics){
        System.out.println(Arrays.toString(numerics.toCharArray()));
        char[] arrays = numerics.toCharArray();
        int partition1 = numerics.lastIndexOf("万");
        int partition2 = numerics.lastIndexOf("亿");
        long target = 0;
        int end;
        int begin = arrays.length - 1;
        if(partition1 == -1 && partition2 == -1){
            end = 0;
        }else{
            end = partition1 != -1 ? partition1 + 1: partition2 + 1;
        }
        target = computeLessMillion(target,begin,end,arrays);
        if(partition1 != -1) {
            begin = end - 1;
            end = partition2 != -1 ? partition2 + 1 : 0;
            target = computeMillion(target, begin, end, arrays);
        }
        if(partition2 != -1) {
            begin = end - 1 ;
            target = computeBillion(target, begin, 0, arrays);
        }
        System.out.println(target);
    }
    long computeLessMillion(long target, int index,int end,char[] arrays){
        long unit = 1;
        for(int i = index; i >= end; i--){
            long temp = map.get(arrays[i]);
            //小于10说明是数字，大于等于10，说明是单位
            if (temp < 10) {
                target += temp * unit;
                unit *= 10;
            } else {
                unit = temp;
            }
        }
        return target;
    }
    long computeMillion(long target, int index,int end,char[] arrays){
        long unit = 1;
        for(int i = index; i >= end; i--){
            long temp = map.get(arrays[i]);
            //小于10说明是数字，大于等于10，说明是单位
            if (temp < 10) {
                target += temp * unit*10000;
                unit *= 10;
            } else if(temp < 10000){
                unit = temp;
            }
        }
        return target;
    }
    long computeBillion(long target, int index,int end,char[] arrays){
        long unit = 1;
        for(int i = index; i >= end; i--){
            long temp = map.get(arrays[i]);
            //小于10说明是数字，大于等于10，说明是单位
            if (temp < 10) {
                target += temp * unit*100000000;
                unit *= 10;
            } else if(temp <= 10000){
                unit = temp;
            }
        }
        return target;
    }
    public void rConvert(long numerics){
        //转化为int数组
        char[] arraysChar = (numerics+"").toCharArray();
        int[] arrays = new int[arraysChar.length];
        for(int i = 0; i < arrays.length; i++){
            arrays[i] = arraysChar[i] - '0';
        }
        String target = "";
        char unit ='个';
        boolean flag = true;//控制两个零不相邻
        for(int j = arrays.length - 1; j >= 0; j--){
            unit = unitMap[arrays.length - j - 1];
            if(unit == '个' && numMap[arrays[j]] != '零' ){
                target = numMap[arrays[j]] + target;
                flag = true;
            }else if(numMap[arrays[j]] == '零' && unitMap[arrays.length - j] == '个' && unitMap[arrays.length - j] == '百' && unitMap[arrays.length - j] == '十' ){
                if(!flag){
                    continue;
                }
                target = String.valueOf(numMap[arrays[j]]) + target;
                flag = false;
            } else{
                target =String.valueOf(numMap[arrays[j]]) + String.valueOf(unit) + target;
                flag = true;
            }
        }
        System.out.println(target);
    }
    public static void main(String[] args){
        ConvertToNumbers convertToNumbers = new ConvertToNumbers();
        convertToNumbers.Convert("一十二亿五千六百万九千五百零五");
        convertToNumbers.rConvert(1256009505);
    }

}
