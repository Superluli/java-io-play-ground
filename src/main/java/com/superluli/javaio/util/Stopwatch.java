package com.superluli.javaio.util;

public class Stopwatch {

	private static boolean STARTED = false;
	private static long STARTINGTIME;

	private Stopwatch() {

	}

	public static void start() {
		if (STARTED) {
			throw new RuntimeException("Already started");
		}
		STARTED = true;
		STARTINGTIME = System.currentTimeMillis();
	}

	public static void end() {
		if (!STARTED) {
			throw new RuntimeException("Haven't started");
		}
		STARTED = false;
		System.out.println("Takes : "
				+ String.valueOf(System.currentTimeMillis() - STARTINGTIME)
				+ " milliseconds");
	}
	
	public static void main(String[] args) throws Exception{
		Stopwatch.start();
		Thread.sleep(1000);
		Stopwatch.end();
		
		Stopwatch.start();
		Thread.sleep(1500);
		Stopwatch.end();
	}
}
