import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	private static final char[] ALPHA = " !\"#$%&\\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\\\]^_`abcdefghijklmnopqrstuvwxyz{|}~".toCharArray();
	private static final int ALPHA_LENGTH = ALPHA.length;
	private static Scanner userInput;
	
	
	public static void main(String[] args) {
		
		ArrayList<Character> LAlpha = new ArrayList<Character>(ALPHA_LENGTH);
		HashMap<Character, Character> encoding = new HashMap<Character, Character>();
		HashMap<Character, Character> decoding = new HashMap<Character, Character>();
		
		// populate LAlpha
		for (int i=0; i<ALPHA_LENGTH; i++) {
			LAlpha.add(ALPHA[i]);
		}
		Collections.shuffle(LAlpha);
		
		//populate encoding and decoding
		for (int i=0; i<ALPHA_LENGTH; i++) {
			encoding.put(ALPHA[i], LAlpha.get(i));
			decoding.put(LAlpha.get(i), ALPHA[i]);
		}
		
		userInput = new Scanner(System.in);
		while (userInput.hasNext()) {
			String in = userInput.nextLine();
			String str = userInput.nextLine();
			String processed = "";
			if (in.equalsIgnoreCase("encode")) {
				for (char c:str.toCharArray()) {
					processed += encoding.get(c);
				}
			} else if (in.equalsIgnoreCase("decode")) {
				for (char c:str.toCharArray()) {
					processed += decoding.get(c);
				}
			}
			System.out.print(processed+"\n\n");
		}
	}
}
