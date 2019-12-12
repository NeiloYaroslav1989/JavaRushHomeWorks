package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File fileSrc = new File(args[0]);
        FileInputStream inputStream = new FileInputStream(fileSrc);
        int summByteFromFile = 0;
        while (inputStream.available() > 0) {
            int readByte = inputStream.read();
            if (readByte >= 65 && readByte <= 122) {
                summByteFromFile++;
            }
        }
        System.out.println(summByteFromFile);

        inputStream.close();





    }
}
