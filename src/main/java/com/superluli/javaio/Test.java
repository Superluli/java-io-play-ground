package com.superluli.javaio;

import java.io.StringWriter;

public class Test {
    
    public static void main(String[] args){
        StringWriter sw = new StringWriter();
        sw.write("XXX");
        System.out.println(sw.toString());
    }
}
