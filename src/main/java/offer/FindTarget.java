package offer;

public class FindTarget {
    int target;
    int[][] arrays;
    public boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0){
            return false;
        }
        this.target = target;
        this.arrays = array;
        return dfs(0,0);
    }
    boolean dfs(int x, int y){
        if(x >= arrays.length || y >= arrays[0].length)
            return false;
        if(arrays[x][y] == target){
            return true;
        }
        boolean a = dfs(x, y+1);
        boolean b = dfs(x + 1, y);
        return  a || b;
    }
    public static void main(String[] args){
        int[][] arryas = new int[][]{{1,2,8,9},{4,7,10,13}};
        FindTarget findTarget = new FindTarget();
        System.out.println(findTarget.Find(11,arryas));
    }
}
