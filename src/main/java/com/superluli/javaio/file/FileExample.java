package com.superluli.javaio.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileExample {

    public static void main(String[] args) throws Exception {
         RandomAccessFile file = getRandomAccessFile("test", "rw");
    }

    public static File getFile(String path) throws IOException {

        return new File(path);
    }

    public static RandomAccessFile getRandomAccessFile(String path, String mode) throws IOException {
        return new RandomAccessFile(getFile(path), mode);
    }

    public static void createFile(File file) throws IOException {

        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public static void createDir(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static void write(File file, String content) throws IOException {

        try (FileWriter fw = new FileWriter(file);) {
            fw.write(content);
        }
    }

    public static void read(File file) throws IOException {

        char[] buffer = new char[1];
        try (FileReader fr = new FileReader(file);) {
            while (fr.read(buffer) != -1) {
                System.out.print(buffer);
            }
            System.out.println("");
        }
    }
}
