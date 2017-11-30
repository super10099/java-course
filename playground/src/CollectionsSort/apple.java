package CollectionsSort;


import java.util.*;

public class apple {
	public static void main(String[] args) {
		String[] wat = {"Ad", "Tc", "Cs", "Rr"};
		List<String> l1 = Arrays.asList(wat);
		
		Collections.sort(l1);
		
		System.out.println(l1);
		
		Collections.sort(l1, Collections.reverseOrder());
		
		System.out.println(l1);
	}
}
