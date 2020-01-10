package offer;


import java.util.Arrays;

public class Graph {
    private int[][] matrix;
    private int length;
    private String[] node;
    private boolean[] visited;
    public Graph(int[][] matrix){
        this.matrix = matrix;
        this.length = matrix.length;
        node = new String[length];
        visited = new boolean[length];
        for(int i = 0; i < length; i++){
            node[i] = "v"+i;
            visited[i] = false;
        }
    }
    public void dfs(int index){
        boolean[] v = new boolean[length];
        System.arraycopy(visited,0,v,0,length);
        dfs(index,v);
    }
    private void dfs(int index,boolean[] visited){
        System.out.println(node[index]);
        visited[index] = true;
        for(int i = 0; i < length; i++){
            if(matrix[index][i] != -1 && !visited[i]){
                dfs(i,visited);
            }
        }
    }
    public void bfs(int index){
        boolean[] v = new boolean[length];
        System.arraycopy(visited,0,v,0,length);
        bfs(index,v);
    }
    private void bfs(int index,boolean[] visited){
        int[] queue = new int[length];
        int front = 0;
        int tail = 0;
        //front == tail 空 (tail + 1) % length == front  满
        tail = ++tail % length;
        queue[tail] = index;
        visited[index] = true;
        while(front != tail){
            front = ++front % length;
            int n = queue[front];
            System.out.println(node[n]);
            for(int i = 0; i < length; i ++){
                if(matrix[n][i] != -1 && !visited[i]){
                    visited[i] = true;
                    tail = ++tail % length;
                    queue[tail] = i;
                }
            }
        }
    }
    public int[] dijkstra(int index){
        int[] distance = new int[length];
        //初始化距离表
        for(int i = 0; i < length; i++){
            distance[i] = matrix[index][i];
        }
        int num = 1;
        int k = 0;
        boolean[] v = new boolean[length];
        System.arraycopy(visited,0,v,0,length);
        v[index] = true;
        while(num < length){
            k = 0;
            //必须要找最短的 m
            for(int i = 0; i < length; i++){
                if(distance[i] != -1 && distance[i] != 0 && !v[i] && (distance[k] > distance[i] || v[k]))
                {
                    k = i;
                }
            }
            for (int i = 0; i < length; i++){
                if((distance[i] == -1 || distance[i] > distance[k] + matrix[k][i])&& matrix[k][i] != -1){
                    distance[i] = distance[k] + matrix[k][i];
                }
            }
            num++;
            v[k] = true;
        }
        return distance;
    }
    //1.删除一个没有前驱的结点
    //2.更新邻接矩阵
    //3.重复步骤1、2
    public boolean AOV(){
        int nums = 0;
        int count = 0;
        boolean flag = true;
        while(count < matrix.length && flag){
            flag = false;
            for(int i = 0; i < matrix.length; i++){
                nums = 0;
                for(int j = 0; j < matrix.length; j++){
                    if(matrix[j][i] == -1){
                        nums++;
                    }
                }
                if(nums == matrix.length - 1){
                    System.out.println(node[i]);
                    for(int k = 0; k < matrix.length; k++){
                        matrix[i][k] = -1;
                    }
                    flag = true;
                    count++;
                    break;
                }
            }
        }
        return count == matrix.length;
    }
    public static void main(String[] args){
        //int[][] array = new int[][]{{0,1,-1,-1,-1,1,-1,-1,},{-1,0,1,1,-1,-1,-1,-1},{-1,-1,0,-1,1,-1,-1,-1},{-1,-1,-1,0,1,-1,1,-1 },{-1,-1,-1,-1,0,-1,-1,1},{-1,-1,-1,-1,-1,0,1,-1},{-1,-1,-1,-1,-1,-1,0,1},{-1,-1,-1,1,-1,-1,-1,0}};
        //int[][] array =  new int[][]{{0,10,-1,30,100},{-1,0,50,-1,-1},{-1,-1,0,-1,10},{-1,-1,20,0,60},{-1,-1,-1,-1,0}};
        int[][] array =  new int[][]{{0,1,-1,-1,-1},{-1,0,1,-1,-1},{-1,-1,0,1,-1},{-1,-1,-1,0,1},{-1,-1,-1,-1,0}};
        Graph graph = new Graph(array);
        System.out.println("--------深度遍历---------");
        graph.dfs(0);
        System.out.println("--------广度遍历---------");
        graph.bfs(0);
        System.out.println("------dijkstra---------");
        System.out.println(Arrays.toString(graph.dijkstra(0)));
        System.out.println("---------AOV---------");
        System.out.println(graph.AOV());
    }
}
