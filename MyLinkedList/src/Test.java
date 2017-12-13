
public class Test {
	
	public static void main(String[] args) {
		MyLinkedList l1 = new MyLinkedList();
		l1.append(1);
		l1.traverse();
		l1.append(1);
		l1.traverse();
		l1.prepend(3);
		l1.traverse();
		l1.append(4);
		l1.traverse();
	}
}
