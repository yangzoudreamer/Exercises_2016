package Tree;

public class ProductTree{
	//通过一个数组，生成一个二叉排序树,返回一个树的root
	
	private Node root;
	
	public Node getRoot() {
		return root;
	}


	public void setRoot(Node root) {
		this.root = root;
	}


	public ProductTree(){
	 	root = null;
	 }


	public static Node initTree() {
		ProductTree tTree = new ProductTree();
		int[] test = new int[]{7,6,3,1,5,13,15,12};
		tTree.buildTree(test);
		return tTree.getRoot();
	}
	
	
	public void buildTree(int[] nodes){
		int len = nodes.length;
		for (int i = 0; i < len; i++) {
			insert(nodes[i]);
		}
	}  

	public void insert(int data){
		Node newNode = new Node(data);
		if (root == null) {
			root = newNode;
		}
		else{
			Node current = root;
			Node parent;
			while(true){
				parent = current;
				if (data < current.data) {
					current = current.left;
					if (current == null) {
						parent.left = newNode;
						return;
					}
				}
				else{
					current = current.right;
					if (current == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}

}