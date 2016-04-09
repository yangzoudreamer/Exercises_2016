package Tree;

class Node{
	int data;
	Node left;
	Node right;
	int leftMaxLength;
	int rightMaxlength;
	public Node(int tdata){
		this.data = tdata;
		this.left = null;
		this.right = null;
	}
}