import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	TreeNode<String> root;
	
	//Constructor 
	public MorseCodeTree()
	{
		buildTree();
	}

	@Override
	public TreeNode getRoot()
	{
		return root;
	}
	@Override
	public void setRoot(TreeNode newNode) 
	{
		this.root = newNode;
	}
	@Override
	public void insert(String code, String letter)
	{
		addNode(root, code, letter);
	}
	@Override
	public void addNode(TreeNode root, String code, String letter)
	{
		if(code.length() == 1) {
			if(code.equals("."))
				root.left = new TreeNode<>(letter);
			else if(code.equals("-"))
				root.right = new TreeNode<>(letter);
			return;
		}
		
		if(code.startsWith(".")) {
            if(root.left == null) 
                root.left = new TreeNode<>(null);
            addNode(root.left, code.substring(1), letter);
		}
		else if(code.startsWith("-")) {
			if(root.right == null)
				root.left = new TreeNode<>(null);	
			addNode(root.right, code.substring(1), letter);
		}
	}
	@Override
	public String fetch(String code) 
	{
		return fetchNode(this.root, code);
	}
	@Override
	public String fetchNode(TreeNode root, String code) 
	{
		if(root == null) 
			return null;
		if(code.isEmpty())
			return (String)root.getData();
		
		if(code.startsWith("."))
			return fetchNode(root.left, code.substring(1));
		else if(code.startsWith("-"))
			return fetchNode(root.right, code.substring(1));
		
		return null;
	}
	@Override
	public LinkedConverterTreeInterface delete(String data) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public LinkedConverterTreeInterface update() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void buildTree() 
	{
		//Root node with an empty string value.
		root = new TreeNode<>(""); 
		//Level one
		insert(".", "e");
		insert("-", "t");
		//Level two
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		//Level three
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		//Level four
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}	
	@Override
	public ArrayList toArrayList()
	{
		ArrayList<String> list = new ArrayList<>();
        LNRoutputTraversal(root, list);
        return list;
	}
	@Override
	public void LNRoutputTraversal(TreeNode root, ArrayList list) 
	{
		if (root != null) {
            LNRoutputTraversal(root.left, list);
            list.add(root.getData());
            LNRoutputTraversal(root.right, list);
        }
	}

}
