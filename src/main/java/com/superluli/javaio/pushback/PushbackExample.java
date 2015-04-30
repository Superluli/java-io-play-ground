package com.superluli.javaio.pushback;

import java.io.FileInputStream;
import java.io.PushbackInputStream;

public class PushbackExample {

	public static void main(String[] args) throws Exception{
		
		int size = 8;
		PushbackInputStream pushbackInputStream = new PushbackInputStream(new FileInputStream("test"), size);
		byte[] arr = new byte[2];
		pushbackInputStream.read(arr);
		System.out.println(new String(arr));
		pushbackInputStream.unread("YY".getBytes());
		pushbackInputStream.read(arr);
		System.out.println(new String(arr));
		pushbackInputStream.close();
	}
}
