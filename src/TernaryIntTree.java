public class TernaryIntTree {
	private IntTreeNode root;
	
	public void removeMin() {
		
	}
	
	private static class IntTreeNode {
		public IntTreeNode left;
		public IntTreeNode mid;
		public IntTreeNode right;
		public String data;
		public IntTreeNode(String data, IntTreeNode left, 
				IntTreeNode mid, IntTreeNode right) {
			this.data = data;
			this.left = left;
			this.mid = mid;
			this.right = right;
		}
		
		public IntTreeNode(String data) {
			this(data, null, null, null);
		}
	}
}