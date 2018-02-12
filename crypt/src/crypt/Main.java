package crypt;

import java.awt.image.BufferedImage;

public class Main {
	
	public static void main(String[] args) {
		
	}
	
	
	/**
	 * converts integer into an array of bytes (32 bits or 4 bytes)
	 * @param i integer for how many bits in a message
	 * @return a byte array of the integer
	 */
	public byte[] bitConversion(int i) {
		byte byte3 = (byte) ((i & 0xFF000000) >>> 24);
		byte byte2 = (byte) ((i & 0x00FF0000) >>> 16);
		byte byte1 = (byte) ((i & 0x0000FF00) >>> 8);
		byte byte0 = (byte) ((i & 0x000000FF));
		
		return (new byte[] {byte3, byte2, byte1, byte0});
	}
	
	/**
	 * 
	 * @param image byte[] of a buffered image userspace
	 * @param addition the bytes of the message that will replace the last bit for each byte of the image byte[]
	 * @param offset the part of the image that will contain which is index of [32], from 0-31 is the first 32 bits of the message length
	 * @return the image with the the message encoded into it, in terms of array of bytes
	 */
	public byte[] encode_text(byte[] image, byte[] addition, int offset) {
		
		// check for file size
		if (addition.length + offset > image.length) {
			throw new IllegalArgumentException("File not long enough!");
		}
		
		//loop through each byte in addition 
		for (int i=0; i<addition.length; i++) {
			// for each byte, loop through to get each bit
			int
			add = addition[i]; // current byte
			for (int bit=7; bit>=0; bit--, offset++) {
				int b = ((add >>> bit) & 1);// current bit 0(00000000) or 1(00000001)
				image[offset] = (byte) ((image[offset] & 0xFE) | b);
			}
		}
		
		return image;
	}
}
