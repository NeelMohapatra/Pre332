import java.util.ArrayList;
import java.util.List;

public class BinarySearchStringTree {
	private StringTreeNode root;
	
	public void add(String data) {
		this.root = add(data, this.root);
	}
	
	private StringTreeNode add(String data, StringTreeNode root) {
		if (root == null) {
			root = new StringTreeNode(data);
		} else if (root.data.compareTo(data) < 0) {
			root.left = add(data, root.left);
		} else {
			root.right = add(data, root.right);
		}
		return root;
	}
	
	public boolean find(String val) {
		return find(val, this.root);
	}
	
	private boolean find(String val, StringTreeNode root) {
		if (root == null) return false;
		if (root.data.equals(val)) return true;
		if (root.data.compareTo(val) < 0)
			return find(val, root.left);
		return find(val, root.right);
	}
	
	public List<String> inOrderTraversal() {
		return inOrderTraversal(this.root);
	}
	
	private List<String> inOrderTraversal(StringTreeNode root) {
		List<String> res = new ArrayList<String>();
		if (root != null) {
			res.addAll(inOrderTraversal(root.left));
			res.add(root.data);
			res.addAll(inOrderTraversal(root.right));
		}
		return res;
	}
	
	public List<String> preOrderTraversal() {
		return preOrderTraversal(this.root);
	}
	
	private List<String> preOrderTraversal(StringTreeNode root) {
		List<String> res = new ArrayList<String>();
		if (root != null) {
			res.add(root.data);
			res.addAll(preOrderTraversal(root.left));
			res.addAll(preOrderTraversal(root.right));
		}
		return res;
	}
	
	public List<String> postOrderTraversal() {
		return postOrderTraversal(this.root);
	}
	
	private List<String> postOrderTraversal(StringTreeNode root) {
		List<String> res = new ArrayList<String>();
		if (root != null) {
			res.addAll(postOrderTraversal(root.left));
			res.addAll(postOrderTraversal(root.right));
			res.add(root.data);
		}
		return res;
	}
	
	
	private static class StringTreeNode {
		// Not making this final for remove
		public String data;
		public StringTreeNode left;
		public StringTreeNode right;
		
		public StringTreeNode(String data) {
			this.data = data;
		}
	}
}
