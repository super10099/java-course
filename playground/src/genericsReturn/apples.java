package genericsReturn;

public class apples {
	public static void main(String[] args) {
		Integer a,b,c;
			a=2;
			b=1;
			c=3;
		System.out.println(getMax(a,b,c));
		
		String[] cray = {"Baa", "Ayy", "Wat"};
		System.out.println(getMax("Baa", "Ayy", "Wat"));
	}
	
	public static <T extends Comparable<T>> T getMax(T a, T b, T c) {
		T max = a;
		if(b.compareTo(max) > 0)
			max = b;
		if(c.compareTo(max) > 0)
			max = c;
		return max;
	}
}
