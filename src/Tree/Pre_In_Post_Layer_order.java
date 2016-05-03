package Tree;

import java.util.LinkedList;
import java.util.Queue;

// 树的先中后序和层序遍历，递归

public class Pre_In_Post_Layer_order{
	
//	public static void main(String[] args) {
//		
//		Node rootNode = ProductTree.initTree();
//		
//		Pre_In_Post_Layer_order tree = new Pre_In_Post_Layer_order();
//		tree.preOrder(rootNode);;
//		System.out.println();
//		tree.inOrder(rootNode);
//		System.out.println();
//		tree.postOrder(rootNode);
//		System.out.println();
//		tree.layerOrder(rootNode);
//	}
	
	public void postOrder(Node rootNode){
		if (rootNode == null) {
			return;
		}
		if (rootNode!= null) {
			postOrder(rootNode.left);
			postOrder(rootNode.right);
			System.out.print(rootNode.data + " ");
		}
	}
	
	public void preOrder(Node rootNode){
		if (rootNode == null) {
			return;
		}
		if (rootNode!= null) {
			System.out.print(rootNode.data + " ");
			preOrder(rootNode.left);
			preOrder(rootNode.right);
		}
	}
	
	public void inOrder(Node rootNode){
		if (rootNode == null) {
			return;
		}
		if (rootNode!= null) {
			inOrder(rootNode.left);
			System.out.print(rootNode.data + " " );
			inOrder(rootNode.right);
		}
	}
	
	public void layerOrder(Node rootNode){
		if (rootNode == null) {
			return;
		}
		//用队列记录遍历结点，有子孙就将子孙插入到队尾
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(rootNode);
		while(!queue.isEmpty()){
			Node tmpNode = queue.poll();
			System.out.print(tmpNode.data + " ");
			if (tmpNode.left != null) {
				queue.add(tmpNode.left);
			}
			if (tmpNode.right != null) {
				queue.add(tmpNode.right);
			}
		}
	}
	
}