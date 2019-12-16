
import javax.swing.tree.TreeNode;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main main=new Main();
        int[] ints={3,3,3,3,3,1,3};
        System.out.println(main.groupThePeople(ints));
    }

    //对输入的元素进行分类，并使每一种都能在一个对应的分类里面。
    public List<List<Integer>> groupThePeople(int[] groupSizes){
        int len=groupSizes.length;
        List<List<Integer>> res=new ArrayList<>();
        //特判
        if (len==0){
            return res;
        }

        PriorityQueue<int[]> minHeap=new PriorityQueue<>(len, Comparator.comparingInt(o->o[0]));
        for (int i=0;i<len;i++){
            minHeap.add(new int[]{groupSizes[i],i});
        }

        while (!minHeap.isEmpty()){
            //获取队首元素，二叉树列
            int curSize=minHeap.peek()[0];
            List<Integer> current=new ArrayList<>();
            for (int i=0;i<curSize;i++){
                //poll()获取并删除队首元素
                current.add(Objects.requireNonNull(minHeap.poll())[1]);
            }
            res.add(current);
        }
        return res;
    }

   /*
   给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：

    二叉树的根是数组中的最大元素。
    左子树是通过数组中最大值左边部分构造出的最大二叉树。
    右子树是通过数组中最大值右边部分构造出的最大二叉树。
    通过给定的数组构建最大二叉树，并且输出这个树的根节点。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/maximum-binary-tree
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   public TreeNode constructMaximumBinaryTree(int[] nums){
       if (nums==null||nums.length==0){
           return null;
       }
       TreeNode root=construct(nums,0,nums.length-1);
       return root;
   }

    private TreeNode construct(int[] nums, int left, int right) {
        if(left>right) {
            return null;
        }
        //返回参数：0最大值，1返回索引
        int[] result = maxValue(nums, left, right);
        TreeNode root = new TreeNode(result[0]);
        root.left = construct(nums, left, result[1]-1);
        root.right = construct(nums,result[1]+1, right);
        return root;
    }


    public int[] maxValue(int[] nums, int left, int right) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return new int[] { max, index };
    }
    */
   /*
   在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：

    行数 m 应当等于给定二叉树的高度。
    列数 n 应当总是奇数。
    根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
    每个未使用的空间应包含一个空的字符串""。
    使用相同的规则输出子树。
   public List<List<String>> printTree(TreeNode root){
       //1.求出root的高度
       int maxDepth=getDepth(root);
       //2.求出输出List的高度
       int width=0,count=maxDepth;
       while (count-- > 0){
           width=width*2+1;
       }
       //对结果集初始化
       List<List<String>> res=new ArrayList<>(maxDepth);
       for (int i=0;i<maxDepth;i++){
           List<String> list=new ArrayList<>();
           for (int j=0;j<width;j++){
               list.add("");
           }
           res.add(list);
       }
       //3.前序遍历，首先在结果集中填充左子树，然后填充右子树
       helper(root,1,0,width,res);
       return res;
   }
   private void helper(TreeNode root,int depth,int start,int end,List<List<String>> res){
       if (root==null||start>end) return;
       //获取当前节点需要插入List的位置
       int insert=start+(end-start)/2;
       //根据当前的层数获取对应的List
       //插入根节点
       for (int i=start;i<=end;i++){
           if (i==insert){
               res.get(depth-1).set(i,root.val+"");
           }
       }
       //递归打印左子树
       helper(root.left, depth + 1, start, insert - 1, res);
       helper(root.right, depth + 1, insert + 1, end, res);
   }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
    */
}
