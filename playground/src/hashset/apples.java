package hashset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class apples {
	public static void main(String[] args) {
		String[] ar = {"Bob", "Bib", "Bill", "Bob"};
		List<String> l1 = Arrays.asList(ar);
		System.out.printf("%s\n", l1);
		
		Set<String> hs = new HashSet<String>(l1);
		System.out.printf("%s\n", hs);
	}
}
