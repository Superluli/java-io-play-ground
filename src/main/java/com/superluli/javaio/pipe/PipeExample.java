package com.superluli.javaio.pipe;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeExample {
    
    public static void main(String[] args) throws Exception{
        
        final PipedOutputStream out = new PipedOutputStream();
        final PipedInputStream in = new PipedInputStream(out);
        new Thread(()->{
            try {
                out.write(1);
                out.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                System.out.println(in.read());
                in.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();
    }
}
