package addall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class aaaaaa {
	public static void main(String... args) {
		String[] stuff = {"WAT", "R", "YOU", "DOING"};
		List<String> l1 = Arrays.asList(stuff);
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("goo");
		ar.add("sad");
		ar.add("hap");
		
		for(String x : ar) {
			System.out.printf("%s ", x);
		}
		
		Collections.addAll(ar, stuff);
		System.out.println();
		for(String x: ar) {
			System.out.printf("%s ", x);
		}
		
		System.out.println("\n" + "" +Collections.frequency(ar, "goo"));
		
		System.out.print(Collections.disjoint(ar, l1) + ", ");
		
		if(Collections.disjoint(ar, l1))
			System.out.println("nothing in common");
		else
			System.out.println("something in common");
	}
}
