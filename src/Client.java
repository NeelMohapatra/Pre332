public class Client {
	public static void main(String[] args) {
		// Not exhaustive 
		ArrayStringList a = new ArrayStringList(100);
		for (int i = 0; i < 200; i++) {
			a.add(i + "");
		}
		System.out.println(a);
		for (int i = 202; i > 1; i--) {
			a.remove(i + "");
		}
		System.out.println(a);
		LinkedStringList l = new LinkedStringList();
		for (int i = 0; i < 10; i++) {
			l.add(i + "");
		}
		l.remove(0);
		l.remove(3);
		l.remove(7);
		System.out.println(l);
		
		BinarySearchStringTree b = new BinarySearchStringTree();
		for (int i = 0; i < 10; i++) {
			b.add(i + "");
		}
		b.remove("3");
		System.out.println(b.inOrderTraversal());
		System.out.println(b.preOrderTraversal());
		System.out.println(b.postOrderTraversal());
	}
}
