package playground;

public class Test {
	public static void main(String[] args) {
		Pairs<String, Integer> op = new OrderedPairs<String, Integer>("hi", 1);
		System.out.println(op.getKey()+", "+op.getValue() );

	}
}
