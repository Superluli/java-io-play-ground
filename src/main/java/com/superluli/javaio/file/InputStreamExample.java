package com.superluli.javaio.file;

import java.io.BufferedReader;
import java.io.FileReader;

public class InputStreamExample {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader reader = new BufferedReader(new FileReader("test"));
		System.out.println(reader.readLine());
		System.out.println(reader.readLine());
	}
}
