package Tree;

//�������������ڵ�֮����󳤶ȣ��ݹ鱣�����������������и�����һ������ֵ

public class MaxLength_TwoNode {

	private int maxLength;
	
	public static void main(String[] args) {
		
		MaxLength_TwoNode len = new MaxLength_TwoNode();
		len.maxLengthTree(ProductTree.initTree());
		System.out.println(len.maxLength);
	}
	
	public void maxLengthTree(Node root){
		if (root == null) {
			return;
		}
		if (root.left == null) {
			root.leftMaxLength = 0;
		}
		if (root.right == null) {
			root.rightMaxlength = 0;
		}
		//�ݹ�
		if (root.left != null) {
			maxLengthTree(root.left);
		}
		if (root.right != null) {
			maxLengthTree(root.right);
		}
		//�����������ҳ��ȣ���ȡ�����������ֵ
		if (root.left != null) {
			root.leftMaxLength = maxLeng(root.left.leftMaxLength,root.left.rightMaxlength) + 1;
		}
		if (root.right != null) {
			root.rightMaxlength = maxLeng(root.right.leftMaxLength, root.right.rightMaxlength) + 1;
		}
		
		if (maxLength < root.leftMaxLength + root.rightMaxlength) {
			maxLength = root.leftMaxLength + root.rightMaxlength;
		}
		
	}
	
	public int maxLeng(int a, int b){
		return a > b ? a:b;
	}
	
}
