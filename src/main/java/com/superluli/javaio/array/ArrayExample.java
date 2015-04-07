package com.superluli.javaio.array;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ArrayExample {

    public static void main(String[] args) throws Exception{
        
        byte[] arr = {1,2,3,4,5};
        readBytes(arr);
        System.out.println(Arrays.toString(writeBytes("XXX")));
        
        char[] carr = {'1', '2', '3', '4', '5'};
        readChars(carr);
        System.out.println(Arrays.toString(writeChars("XXX")));
    }

    public static void readBytes(byte[] arr) throws IOException {
        try (InputStream in = new ByteArrayInputStream(arr)) {
            int next = -1;
            while ((next = in.read()) != -1) {
                System.out.print(next);
            }
            System.out.println();
        }
    }

    public static byte[] writeBytes(String s) throws IOException {
        try(ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            out.write(s.getBytes("UTF-8"));
            return out.toByteArray();
        }
    }
    
    public static void readChars(char[] arr) throws IOException {
        char[] cbuf = new char[1];
        try (CharArrayReader cr = new CharArrayReader(arr);) {
            while (cr.read(cbuf) != -1) {
                System.out.print(cbuf);
            }
        }
    }

    public static char[] writeChars(String s) throws IOException {

        try (CharArrayWriter cw = new CharArrayWriter();) {
            cw.write(s);
            return cw.toCharArray();
        }
    }
}
