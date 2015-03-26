package com.superluli.javaio.pipe;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeExample {
    
    public static void main(String[] args) throws Exception{
        
        final PipedOutputStream out = new PipedOutputStream();
        final PipedInputStream in = new PipedInputStream(out);
        final String s = "123";
        new Thread(()->{
            try {
                out.write(1);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                System.out.println(in.read());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();
    }
}
