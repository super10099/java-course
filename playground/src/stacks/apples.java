package stacks;

import java.util.Stack;

public class apples {
	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		s.push("first");
		printStack(s);
		s.push("second");
		printStack(s);
		s.push("third");
		printStack(s);
		
		s.pop();
		printStack(s);
		s.pop();
		printStack(s);
		s.pop();
		printStack(s);
	}
	
	private static void printStack(Stack s) {
		if(s.isEmpty())
			System.out.println("EMPTY STACk");
		else
			System.out.printf("%s /TOP\n", s);
	}
}
