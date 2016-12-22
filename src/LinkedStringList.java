public class LinkedStringList {
	private StringListNode head;
	private int size;
	
	public LinkedStringList() {
		this.head = null;
		this.size = 0;
	}
	
	public void add(String data) {
		this.add(this.size, data);
	}
	
	public void add(int index, String data) {
		this.checkIndex(index);
		if (index > 0) {
			StringListNode curr = this.head;
			for (int i = 0; i < index - 1; i++) {
				curr = curr.next;
			}
			curr.next = new StringListNode(curr.next, data);
		} else {
			this.head = new StringListNode(this.head, data);
		}
		this.size++;
	}
	
	public String get(int index) {
		StringListNode curr = this.head;
		for (int i = 0; i < index; i++) {
			curr = curr.next;
		}
		return curr.data;
	}
	
	public int find(String data) {
		StringListNode curr = this.head;
		for (int i = 0; i < this.size; i++) {
			if (curr.data.equals(data))
				return i;
			curr = curr.next;
		}
		return -1;
	}
	
	public boolean remove(int index) {
		if (size >= index) {
			if (index == 0) {
				head = head.next;
			} else {
				StringListNode curr = head;
				for (int i = 0; i < index - 1; i++) {
					curr = curr.next;
				}
				curr.next = curr.next.next;
			}
			this.size--;
		}
		return size >= index;
	}
	
	private void checkIndex(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException();
		}
	}
	
	public String toString() {
		if (size == 0) {
			return "[]";
		}
		StringBuilder res = new StringBuilder("[");
		StringListNode curr = head;
		while (curr != null && curr.next != null) {
			res.append(curr.data + ", ");
			curr = curr.next;
		}
		res.append(curr.data + "]");
		return res.toString();
	}
	
	private static class StringListNode {
		public StringListNode next;
		public final String data;
		
		public StringListNode(StringListNode next, String data) {
			this.next = next;
			this.data = data;
		}
	}
}
