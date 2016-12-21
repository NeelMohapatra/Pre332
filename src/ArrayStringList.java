import java.util.Arrays;

public class ArrayStringList {
	String[] arr;
	public ArrayStringList() {
		this.arr = new String[10];
	}
	
	private void doubleSize() {
		arr = Arrays.copyOf(arr, 2 * arr.length);
	}
	
	
}
