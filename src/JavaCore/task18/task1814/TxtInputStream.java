package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
    private String fileName;
    public TxtInputStream(String fileName) throws FileNotFoundException, UnsupportedFileNameException, IOException {
        super(fileName);

        if (!fileName.endsWith(".txt")) {
            super.close();
            throw new UnsupportedFileNameException();
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }







    public static void main(String[] args) {

    }
}

