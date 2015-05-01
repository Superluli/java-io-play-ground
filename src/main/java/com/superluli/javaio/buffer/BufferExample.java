package com.superluli.javaio.buffer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import com.superluli.javaio.util.Stopwatch;

public class BufferExample {

	public static void main(String[] args) throws Exception {

		testFlush();
	}

	public static void testBuffer() throws Exception {

		/*
		 * This takes years to finish
		 */
		Stopwatch.start();
		// readWithoutBuffer(new FileInputStream("bigdata"));
		Stopwatch.stop();

		/*
		 * When read a single byte(or small piece of data), BufferedInputStream
		 * improve performance significantly
		 */
		Stopwatch.start();
		readWithBuffer(new FileInputStream("bigdata"));
		Stopwatch.stop();

		/*
		 * When read a chunk at a time, BufferedInputStream won't help
		 */
		Stopwatch.start();
		readWithBuffer2(new FileInputStream("bigdata"));
		Stopwatch.stop();
	}

	public static void testFlush() throws Exception {

		Stopwatch.start();
		writeSingle(10000000);
		Stopwatch.stop();

		/*
		 * Flush invokes system IO
		 */
		Stopwatch.start();
		writeBufferWithFlush(10000000);
		Stopwatch.stop();

		Stopwatch.start();
		writeBufferWithOutFlush(10000000);
		Stopwatch.stop();
	}

	public static void readWithoutBuffer(InputStream in) throws Exception {

		int total = 0;
		while (in.read() != -1) {
			total++;
		}
		System.out.println(total);
	}

	public static void readWithBuffer(InputStream in) throws Exception {

		int total = 0;
		BufferedInputStream bin = new BufferedInputStream(in, 8 * 1024);
		while (bin.read() != -1) {
			total += 1;
		}
		System.out.println(total);
	}

	public static void readWithBuffer2(InputStream in) throws Exception {

		int total = 0;
		int lengthRead = 0;
		byte[] buf = new byte[8 * 1024];
		while ((lengthRead = in.read(buf)) != -1) {
			total += lengthRead;
		}
		System.out.println(total);
	}

	public static void writeSingle(int n) throws Exception {

		FileOutputStream out = new FileOutputStream("buffer1.data");
		OutputStreamWriter writer = new OutputStreamWriter(out);
		for (int i = 0; i < n; i++) {
			writer.write('x');
		}
		/*
		 * close will invoke a flush internally
		 */
		writer.close();
		out.close();
	}

	public static void writeBufferWithFlush(int n) throws Exception {

		FileOutputStream out = new FileOutputStream("buffer2.data");
		OutputStreamWriter writer = new OutputStreamWriter(out);
		for (int i = 0; i < n; i++) {
			writer.write('x');
			writer.flush();
		}
		writer.close();
		out.close();
	}

	public static void writeBufferWithOutFlush(int n) throws Exception {

		int chunkSize = 8 * 1024;

		int numOfChunks = n / chunkSize;
		int numLeft = n % chunkSize;

		FileOutputStream out = new FileOutputStream("buffer3.data");
		OutputStreamWriter writer = new OutputStreamWriter(out);
		char[] arr = new char[chunkSize];
		Arrays.fill(arr, 'x');
		for (int i = 0; i < numOfChunks; i++) {
			writer.write(arr);
		}
		writer.write(arr, 0, numLeft);
		writer.close();
		out.close();
	}
}
