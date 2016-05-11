package Tree;
import java.util.ArrayList;
import java.util.List;

public class Path_Sum_II {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<String> list = new ArrayList<String>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        if (root == null) {
			return res;
		}
        
        if(root != null){
        	findPaths(root, String.valueOf(root.val));
        }
        
        for (String list2 : list) {
            if(isValid(list2,sum)){
                List<Integer> subList = new ArrayList<Integer>();
                String[] arr = list2.split(",");
                for (String str : arr) {
				    subList.add(Integer.valueOf(str));
		        }
		        res.add(subList);
            }
        }
        
        return res;
    }
    
    public void findPaths(TreeNode node, String path){

    	if (node.left == null && node.right == null) {
			list.add(path);
			return;
		}
    	else {
			if (node.left != null) {
				findPaths(node.left,path+","+node.left.val);
			}
			if (node.right != null) {
				findPaths(node.right,path+","+node.right.val);
			}
		}
    }
    
    public boolean isValid(String subList,int sum){
        String[] arr = subList.split(",");
        int n = 0;
        for (String str : arr) {
				n += Integer.valueOf(str);
		}
		if(n == sum)
		    return true;
		return false;
    }
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
