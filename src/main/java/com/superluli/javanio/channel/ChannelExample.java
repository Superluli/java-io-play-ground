package com.superluli.javanio.channel;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelExample {
	
	public static void main(String[] args) throws Exception{
		
		RandomAccessFile file = new RandomAccessFile("nio.data", "rw");
		ByteBuffer bb = ByteBuffer.allocate(1024);
		FileChannel channel = file.getChannel();
		int bytesRead = 0;
		while((bytesRead = channel.read(bb)) != -1){
			bb.flip();
			while (bb.hasRemaining()) {
				System.out.println((char)bb.get());
			}
			bb.clear();
		}
	}
}
