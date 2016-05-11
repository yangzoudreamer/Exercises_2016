import java.util.ArrayList;
import java.util.List;

import Tree.Binary_Tree_Paths.TreeNode;

/**
 * �������ɾ����㷨�༭�ṩ��û�а�Ȩ��ӭת����
 * - �����㷨�����ڰ��������й����ҵ��õĹ�������ʦ�ŶӾ����Թ�Ⱥ͹��ڵ�һ�ߴ�˾��ְ����ʦ��
 * - ���е�������ѵ�γ̰����������㷨�࣬ϵͳ��ư࣬BAT���ڰ�
 * - ������������ٷ���վ��http://www.jiuzhang.com/
 */

//Version 1: Traditional Method�� ����и��׽ڵ�
//
//public class Solution {
//    private ArrayList<TreeNode> getPath2Root(TreeNode node) {
//        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
//        while (node != null) {
//            list.add(node);
//            node = node.parent;
//        }
//        return list;
//    }
//    public TreeNode lowestCommonAncestor(TreeNode node1, TreeNode node2) {
//        ArrayList<TreeNode> list1 = getPath2Root(node1);
//        ArrayList<TreeNode> list2 = getPath2Root(node2);
//        
//        int i, j;
//        for (i = list1.size() - 1, j = list2.size() - 1; i >= 0 && j >= 0; i--, j--) {
//            if (list1.get(i) != list2.get(j)) {
//                return list1.get(i).parent;
//            }
//        }
//        return list1.get(i+1);
//    }
//}

//Version 2: Divide & Conquer

//public class Solution {
//    // ��rootΪ���Ķ���������A,B��LCA:
//    // ����ҵ��˾ͷ������LCA
//    // ���ֻ����A���ͷ���A
//    // ���ֻ����B���ͷ���B
//    // �����û�У��ͷ���null
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
//        if (root == null || root == node1 || root == node2) {
//            return root;
//        }
//        
//        // Divide
//        TreeNode left = lowestCommonAncestor(root.left, node1, node2);
//        TreeNode right = lowestCommonAncestor(root.right, node1, node2);
//        
//        // Conquer
//        if (left != null && right != null) {
//            return root;
//        } 
//        if (left != null) {
//            return left;
//        }
//        if (right != null) {
//            return right;
//        }
//        return null;
//    }
//}


class LCA_of_BST{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    List<TreeNode> pathp = new ArrayList<LCA_of_BST.TreeNode>();
    List<TreeNode> pathq = new ArrayList<LCA_of_BST.TreeNode>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root==null || p==null || q==null) return null;
        pathp.add(root);
        pathq.add(root);
        
        getPath(root, p, pathp);
        getPath(root, q, pathq);
        TreeNode resNode = new TreeNode(-1);
        
        for (int i = 0; i < pathp.size() && i < pathq.size(); i++) {
			if(pathp.get(i)==pathq.get(i)) resNode = pathp.get(i);
			break;
		}
        return resNode;
        
    }
    
    public boolean getPath(TreeNode root, TreeNode node, List<TreeNode> path){
    	if (root == node) {
			return true;
		}
    	else {
			if (root.left != null) {
				path.add(root.left);
				if(getPath(root.left, node, path))return true;
				path.remove(path.size()-1);
				
			}
			if (root.right != null) {
				path.add(root.right);
				if(getPath(root.right, node, path))return true;
				path.remove(path.size()-1);
				
			}
		}
    	return false;
    }
    
}




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//public class Solution {
//    //2, 1
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root==null || p==null || q==null) return null;
//        
//        List<TreeNode> pathp = new ArrayList<>();
//        List<TreeNode> pathq = new ArrayList<>();
//        pathp.add(root);
//        pathq.add(root);
//        
//        getPath(root, p, pathp);
//        getPath(root, q, pathq);
//        
//        TreeNode lca = null;
//        for(int i=0; i<pathp.size() && i<pathq.size(); i++) {
//            if(pathp.get(i) == pathq.get(i)) lca = pathp.get(i);
//            else break;
//        }
//        return lca;
//    }
//    
//    private boolean getPath(TreeNode root, TreeNode n, List<TreeNode> path) {
//        if(root==n) {
//            return true;
//        }
//        
//        if(root.left!=null) {
//            path.add(root.left);
//            if(getPath(root.left, n, path)) return true;
//            path.remove(path.size()-1);
//        }
//        
//        if(root.right!=null) {
//            path.add(root.right);
//            if(getPath(root.right, n, path)) return true;
//            path.remove(path.size()-1);
//        }
//        
//        return false;
//    }
//}