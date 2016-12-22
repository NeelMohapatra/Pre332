// A sorted ArrayList
public class ArrayStringList {
	private String[] allData;
	private int size;
	public static final int DEFAULT_CAPACITY = 10;
	
	public ArrayStringList(int initialCapacity) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Initial Capacity must be >= 0");
		this.allData = new String[initialCapacity];
		this.size = 0;
	}
	
	public ArrayStringList() {
		this(DEFAULT_CAPACITY);
	}
	
	public int size() {
		return this.size;
	}
	
	private void doubleSize() {
		String[] temp = new String[2 * this.allData.length];
		for (int i = 0; i < this.allData.length; i++) {
			temp[i] = this.allData[i];
		}
		this.allData = temp;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	private void checkIndex(int index) {
		if (index < 0 || index > this.size)
			throw new IllegalArgumentException("Index must be in the "
					+ "range of [0, size)");
	}
	
	public void add(String object) {
		int index = 0;
		// Finding this can be done in O(log n) but no use
		// since shifting is O(n)
		while (this.allData[index] != null && 
				object.compareTo(this.allData[index]) >= 0)
			index++;
		for (int i = size; i > index; i--)
			this.allData[i] = this.allData[i - 1];
		
		this.allData[index] = object;
		this.size++;
		if (size == this.allData.length)  
			doubleSize();
	}
	
	public String get(int index) {
		this.checkIndex(index);
		return this.allData[index];
	}
	
	public boolean remove(String object) {
		int location = find(object);
		if (location == -1) 
			return false;
		for (int i = location; i < size - 1; i++)
			this.allData[i] = this.allData[i + 1];
		this.size--;
		return true;
	}
	
	public int find(String object) {
		int start = 0;
		int end = size - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			String element = this.allData[mid];
			if (object.equals(element))
				return mid;
			else if (object.compareTo(element) > 0)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}
	
	public String toString() {
		if (this.isEmpty())
			return "[]";
		StringBuilder res = new StringBuilder("[");
		
		for (int i = 0; i < size - 1; i++)
			res.append(allData[i] + ", ");
		
		res.append(this.allData[size - 1] + "]");
		return res.toString();
	}
}
