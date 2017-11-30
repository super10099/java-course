import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class apples {
	public static void main(String[] args) {
		Character[] C = {'a', 'b', 'c'};
		List<Character> l1 = Arrays.asList(C);
		System.out.println("List 1 : ");
		output(l1);
		
		// reverse
		Collections.reverse(l1);
		System.out.println("After reverse: ");
		output(l1);
		
		//copy to naother list
		List<Character> l2 = Arrays.asList(new Character[3]);
		Collections.copy(l2, l1);
		System.out.println("Copied list : ");
		output(l2);
		
		//fill
		Collections.fill(l1, 'X');
		System.out.println("After Collections_Fill : ");
		output(l1);
	}
	
	public static void output(List<Character> list) {
		for(Character x:list) {
			System.out.printf("%s ", x);
		}
		System.out.println();
	}
}
