package offer;

/**寻找服务中的依赖*/
public class CheckCircularDependency {
    class Server{
        char from;
        char[] to;

        public Server(char from,char[] to) {
            this.from = from;
            this.to = to;
        }
    }
    public static void main(String[] args){
        char[][] arrays = new char[][]{{'A','B'},{'A','C'},{'B','D'},{'D','A'}};
        for(int i = 0; i < arrays.length; i++){
            char target = arrays[i][0];
            for(int j = i;  j <arrays.length; j++){

            }
        }
        }
     }
