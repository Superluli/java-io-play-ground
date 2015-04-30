package com.superluli.javaio.buffer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import com.superluli.javaio.util.Stopwatch;

public class BufferExample {
	
	public static void main(String[] args) throws Exception{
		
		Stopwatch.start();
		readWithoutBuffer(new FileInputStream("bigdata"));
		Stopwatch.end();
		
		Stopwatch.start();
		readWithBuffer(new FileInputStream("bigdata"));
		Stopwatch.end();
	}

	public static void readWithoutBuffer(InputStream in) throws Exception{
		while(in.read() != -1){
		}
	}

	public static void readWithBuffer(InputStream in) throws Exception{
		
		BufferedInputStream bin = new BufferedInputStream(in, 8*1024);
		while(bin.read() != -1){
		}
	}
}
