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
                /*������ʵ��Ϊ�����ߣ���һ�����µõĽ�������ʱ�������ĩβ����Ϊ��һ�εݹ�����
                �ڶ�����������ʱ�����ĩβ���ĵݹ麯����
                �������������ĩβ�������н�֮�󣬽������ʱ��������ų������ݵ���һ�����������ٵݹ飩��������һ��ͬ���ڵ�ļ���*/
            	list.add(array[i]);
                backTracking(list,i+1,target - array[i]);
                list.remove(new Integer(array[i]));
            }
        }
    }
}
