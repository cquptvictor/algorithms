package offer;
/*寻找二叉树中合为某一路径的值*/


import java.util.*;

public class BinaryTree {
    int count;
    Stack<Integer> stack = new Stack();
    List list = new ArrayList();
    public int value;
    public BinaryTree left;
    public BinaryTree right;
    public BinaryTree(){

    }
    public BinaryTree(int value){
        this.value = value;
    }

    //层序遍历构造
    public static BinaryTree build(int[] array,int index){
        if(index > array.length - 1)
            return null;
        BinaryTree root = new BinaryTree(array[index]);
        root.left = build(array,2 * index + 1);
        root.right = build(array,2 * index + 2);
        return root;
    }

    public static void preOrder(BinaryTree tree){
        if(tree == null)
            return;
        System.out.println(tree.value);
        preOrder(tree.left);
        preOrder(tree.right);
    }
    /**非递归中序遍历二叉树*/
    public static void middleOrder(BinaryTree tree){
        Stack<BinaryTree> stack = new Stack<>();
        while(tree != null || !stack.empty()){
            while (tree != null){
                stack.push(tree);
                tree = tree.left;
            }
            if(!stack.empty()){
                tree = stack.pop();
                System.out.print(tree.value);
                tree = tree.right;
            }
        }
    }
    public static void levelOrder(BinaryTree root){
        Queue<BinaryTree> queue = new LinkedList();
        queue.offer(root);
        while(queue.peek() != null){
            BinaryTree node = queue.poll();
            System.out.println(node.value);
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
    }
    /*二叉搜索树转换为双向链表*/
    public static BinaryTree Convert(BinaryTree root){
        if(root == null) return null;
        BinaryTree left = Convert(root.left);
        if(left != null){
            while(left.right != null){
                left = left.right;
            }
            root.left = left;
            left.right = root;
        }
        BinaryTree right = Convert(root.right);
        if(right != null){
            while(right.left != null){
                right = right.left;
            }
            root.right = right;
            right.left = root;
        }
        while(root.right != null){
            root = root.right;
        }
        return root;
    }
    void findPath(BinaryTree root,int target){
        if(root == null){
            return;
        }else{
            stack.push(root.value);
            count += root.value;
            if(target == count){
                add();
                count -= root.value;
                stack.pop();
                return;
            }else if(target > count){
                findPath(root.left,target);
                findPath(root.right,target);
                stack.pop();
                count -= root.value;
                return;
            }else{
                stack.pop();
                count -= root.value;
                return;
            }
        }
    }
    void add(){
        ArrayList temp = new ArrayList();
        for(int each :stack){
            temp.add(each);
        }
        list.add(temp);
    }
    //求树的最大深度
    static int findMaxDeepth(BinaryTree root){
        if(root == null || root.value == -1)
            return 0;
        return Math.max(findMaxDeepth(root.left) + 1,findMaxDeepth(root.right) + 1);
    }
    public static void main(String[] args){
      /*  int[] array = new int[]{10,6,14,4,8,12,16};
        BinaryTree binaryTree = BinaryTree.build(array,0);
        BinaryTree.preOrder(binaryTree);
        Stack stack = new Stack();
        boolean a = BinaryTree.findPath(binaryTree,stack,40,0);
        if(a)
            System.out.println(stack);
        else
            System.out.println("找不到这样一条路径");*/
    int[] array = new int[]{10,5,12,4,7};
    BinaryTree binaryTree = BinaryTree.build(array,0);
    binaryTree.levelOrder(binaryTree);
    //binaryTree = BinaryTree.Convert(binaryTree);
    //binaryTree.findPath(binaryTree,15);
    //System.out.print(binaryTree.list);
    /*  while (binaryTree.left != null){
        System.out.println(binaryTree.value);
        binaryTree = binaryTree.left;
    }
        System.out.println(binaryTree.value);
        while(binaryTree != null){
        System.out.println(binaryTree.value);
        binaryTree = binaryTree.right;
    }*/
  /*  int[] array = new int[]{1,2,3,4,5,6,7,-1,6,-1,-1};
    BinaryTree binaryTree = BinaryTree.build(array,0);
    BinaryTree.preOrder(binaryTree);
    System.out.print(BinaryTree.findMaxDeepth(binaryTree));*/
    }
}
