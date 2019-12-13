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
}
