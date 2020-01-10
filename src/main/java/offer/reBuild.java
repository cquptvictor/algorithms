package offer;

public class reBuild {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return build(pre, 0, pre.length - 1, in, 0,in.length - 1);
    }

    TreeNode build(int[] pre,int begin1,int end1, int[] in,int begin2,int end2){
        if(begin2 > end2){
            return null;
        }
        TreeNode root = new TreeNode(pre[begin1]);
        int index = begin2;
        for(int i = begin2; i <= end2; i++){
            if(pre[begin1] == in[i]){
                index = i;
                break;
            }
        }
        root.left = build(pre, begin1 + 1 ,  begin1 + index,  in, begin2, index - 1);
        root.right = build(pre,  index + 1,  pre.length - 1, in,index + 1,end2);
        return root;
    }
    public static void main(String[] args){
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        reBuild r = new reBuild();
        r.reConstructBinaryTree(pre,in);
    }
}
