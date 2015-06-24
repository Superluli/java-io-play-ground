package com.superluli.javanio.scatterandgather;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class ScatterandgatherExample {

	public static void main(String[] args) throws Exception {

		RandomAccessFile file = new RandomAccessFile("sng.data", "rw");
		FileChannel fc = file.getChannel();

		gatherTest(fc);
		scatterTest(fc);
		fc.close();
		file.close();
	}

	private static void gatherTest(FileChannel fc) throws Exception {

		ByteBuffer b1 = ByteBuffer.allocate(1);
		ByteBuffer b2 = ByteBuffer.allocate(2);
		ByteBuffer b3 = ByteBuffer.allocate(3);

		b1.put(new byte[] { 'a' });
		b2.put(new byte[] { 'b', 'c' });
		b3.put(new byte[] { 'd', 'e', 'f' });

		b1.flip();
		b2.flip();
		b3.flip();

		System.out.println(fc.write(new ByteBuffer[] { b1, b2, b3 }));
	}

	private static void scatterTest(FileChannel fc) throws Exception {

		fc.position(0);
		
		ByteBuffer b1 = ByteBuffer.allocate(1);
		ByteBuffer b2 = ByteBuffer.allocate(2);
		ByteBuffer b3 = ByteBuffer.allocate(3);

		fc.read(new ByteBuffer[] { b1, b2, b3 });

		System.out.println(Arrays.toString(b1.array()));
		System.out.println(Arrays.toString(b2.array()));
		System.out.println(Arrays.toString(b3.array()));
		
		System.out.println(fc.position());
	}
}
