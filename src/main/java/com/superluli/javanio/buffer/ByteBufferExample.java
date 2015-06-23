package com.superluli.javanio.buffer;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class ByteBufferExample {

	public static void main(String[] args) {

		ByteBuffer bb = ByteBuffer.allocate(5);
		showBuffer(bb);
		bb.put((byte)1);
		bb.put((byte)2);
		bb.put((byte)3);
		bb.put((byte)4);
		showBuffer(bb);
		bb.flip();
		showBuffer(bb);
		bb.get();
		showBuffer(bb);
		bb.compact();
		showBuffer(bb);
		bb.put((byte)5);
		showBuffer(bb);
	}

	public static void showBuffer(ByteBuffer bb) {

		System.out.println("POS : " + bb.position() + ", LIMIT : " + bb.limit()
				+ " Contents : " + Arrays.toString(bb.array()));
	}
}
