public class TreeNode<T> {
	private T data;
	TreeNode<T> left, right;

	//Constructors
	public TreeNode(T dataNode){
		data = dataNode;
		left = null;
		right = null;	
	}
	public TreeNode(TreeNode<T> node) {
		this.data = node.data;
		this.left = node.left;
		this.right = node.right;
	}
	
	public T getData() {
		return this.data;
	}
}
