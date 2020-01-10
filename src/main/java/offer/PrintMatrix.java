package offer;
/*打印矩阵*/
public class PrintMatrix {
    public static void print(int[][] matrix){
        int start = 0;
        int columns = matrix[0].length;
        int rows = matrix.length;
        int endColumns = columns - 1 - start;
        int endRows = rows - 1 - start;
        //start start没有过半就能继续打印
        while (2 * start <= endRows || 2 * start <= endColumns){
            for(int i = start; i <= endColumns; i++){
                System.out.print(matrix[start][i]+" ");
            }
            /*至少要有两行才能执行第二步*/
            if(endRows > start){
                for(int j = start + 1; j <= endRows; j++){
                    System.out.print(matrix[j][endColumns]+" ");
                }
            }
            /*至少两行两列才会执行第三部*/
            if(endRows > start && endColumns > start){
                for(int k = endColumns - 1; k >= start; --k){
                    System.out.print(matrix[endRows][k]+" ");
                }
            }
            /*至少三行两列才会执行第四部*/
            if(endRows > start + 1 && endColumns > start){
                for(int l = endRows - 1; l > start; --l){
                    System.out.print(matrix[l][start] + " ");
                }
            }
            endColumns --;
            endRows--;
            start++;
        }
    }
    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        PrintMatrix.print(matrix);
    }
}
