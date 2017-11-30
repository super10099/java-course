package genericmethods;

public class apples {
	public static void main(String[] args) {
		Integer[] iray = {1, 2, 3, 4, 5};
		Character[] cray = {'T', 'h', 'i', 'n', 'h'};
		
		printMe(iray);
		printMe(cray);
	}
	
	public static <T> void printMe(T[] t) {
		for(T x:t)
			System.out.printf("%s ", x);
		System.out.println();
	}
}
