package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/


import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    public static void main(String[] args) {

    }

    private FileWriter fileWriter;

    // создаем 5 конструкторов как в классе FileWriter и инициализируем переменную нашего класса
    public FileConsoleWriter(String name) throws IOException {
        this.fileWriter = new FileWriter(name);
    }
    public FileConsoleWriter(String name, boolean bool) throws IOException {
        this.fileWriter = new FileWriter(name, bool);
    }
    public FileConsoleWriter(File name) throws IOException {
        this.fileWriter = new FileWriter(name);
    }
    public FileConsoleWriter(File name, boolean bool) throws IOException {
        this.fileWriter = new FileWriter(name, bool);
    }
    public FileConsoleWriter(FileDescriptor descriptor) throws IOException {
        this.fileWriter = new FileWriter(descriptor);
    }



    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        System.out.println(String.valueOf(cbuf).substring(off, off+len));
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println(c);
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        System.out.println(str.substring(off, off+len));
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        System.out.println(cbuf);
    }

    public void close() throws IOException {
        fileWriter.close();
    }




}
