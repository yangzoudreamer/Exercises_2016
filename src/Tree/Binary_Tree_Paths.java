package Tree;
import java.util.ArrayList;
import java.util.List;



public class Binary_Tree_Paths {
	

    List<String> list = new ArrayList<String>();
	
    public List<String> binaryTreePaths(TreeNode root) {
        
        if (root == null) {
			return list;
		}
        
        if(root != null){
        	findPaths(root, String.valueOf(root.val));
        }
        
        return list;
    }
    
    public  void findPaths(TreeNode node, String path){
//    	if (node == null) {
//			return;
//		}
    	if (node.left == null && node.right == null) {
			list.add(path);
			return;
		}
    	else {
			if (node.left != null) {
				findPaths(node.left,path+"->"+node.left.val);
			}
			if (node.right != null) {
				findPaths(node.right,path+"->"+node.right.val);
			}
		}
    	
    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
}