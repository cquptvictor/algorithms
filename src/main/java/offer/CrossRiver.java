package offer;

public class CrossRiver {
    public int cross(int[] arrays){
        int[] opt = new int[arrays.length + 1];
        opt[0] = 0;
        opt[1] = arrays[0];
        opt[2] = arrays[1];
        for(int i = 3; i <= arrays.length; i++){
            opt[i] = Math.min(opt[i - 1] + arrays[i - 1] + arrays[0], opt[i - 2] + arrays[0] + arrays[i - 1]  + arrays[1]*2);
        }
        return opt[arrays.length];
    }
    public static void main(String args[]){
        int[] arrrays = new int[]{1,2,5,8};
        CrossRiver crossRiver = new CrossRiver();
        System.out.println(crossRiver.cross(arrrays));
    }

}
