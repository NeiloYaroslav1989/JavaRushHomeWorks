package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileSrc = reader.readLine();
//        String fileSrc = "C:/JavaRushTasks/Test1.txt";

        FileInputStream inputStream = new FileInputStream(fileSrc);
        int maxByteInFile = 0;

        while (inputStream.available() > 0) {
            int byteFromFile = inputStream.read();
            if (maxByteInFile < byteFromFile) {
                maxByteInFile = byteFromFile;
            }
        }
        inputStream.close();

        System.out.println(maxByteInFile);

    }
}
