package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CombinationSum3 {

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    int[] array = {1,2,3,4,5,6,7,8,9};
    
        public List<List<Integer>> combinationSum3(int k, int n) {
        
        Arrays.sort(array);
        backTracking(new ArrayList(),0,n);

        
        for (Iterator<List<Integer>> iter = res.iterator(); iter.hasNext();) {  
            List<Integer> i = iter.next();  
            if (i.size() != k) {  
                iter.remove();  
            }
        }
        
        return res;
    }
    
    public void backTracking(List<Integer> list, int from,int target){
        if(target == 0){
            List<Integer> cur = new ArrayList<Integer>(list);
            if(res.contains(cur)){
                return;
            }
            res.add(cur);
        }
        else{
            for(int i = from; i < array.length && array[i]<=target;i++){
                /*以下其实分为三步走，第一步将新得的结点放入临时结果集的末尾，作为下一次递归的起点
                第二步，进行临时结果集末尾结点的递归函数中
                第三步，解出该末尾结点的所有解之后，将其从临时结果集中排除（回溯到上一层的其他结点再递归），便于下一次同级节点的计算*/
            	list.add(array[i]);
                backTracking(list,i+1,target - array[i]);
                list.remove(new Integer(array[i]));
            }
        }
    }
}
