package offer;


/**求未覆盖区间
 * 1.把区间的起点排序
 * 2.前一个区间的终点和后一个区间的起点比较，差值就是未覆盖的*/

public class UnCoveredSection {
    public static void main(String[] args){
        int[][] sections = new int[][]{{10,15},{4,6},{25,30},{38,49}};
        sort(sections);
        //找到最低点
        int min = sections[0][0];
        int right = sections[0][1];
        //找能够连续的区间的最高点
        for(int i = 1; i < sections.length; i++)
        {
            //输出两个最接近的点的未覆盖
            if(sections[i][0] > right){
                for(int j = 1; right + j < sections[i][0]; j++)
                    System.out.print(right + j + " ");
            }
            if(sections[i][1] > right)
                {
                    right = sections[i][1];
                }
        }
        //输出两侧未覆盖的
        for(int i = 0; i < min; i++){
            System.out.print(i + " ");
        }
        int j = 0;
        while (j++ < 3){
            System.out.print(right + j +" ");
        }
        System.out.print("....N");
    }
   static void sort(int[][] sections){
        for(int i = 1; i < sections.length; i++){
            for(int j = i; j > 0 && sections[j][0] < sections[j - 1][0]; j--) {
                int[] temp = sections[j];
                sections[j] = sections[j - 1];
                sections[j - 1] = temp;
            }
        }
    }
}


