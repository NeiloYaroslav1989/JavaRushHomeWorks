package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileSrc = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileSrc);

        int minByteFromFile = 10000;

        while (inputStream.available() > 0) {
            int minByte = inputStream.read();
            if (minByteFromFile > minByte) {
                minByteFromFile = minByte;
            }
        }

        inputStream.close();

        System.out.println(minByteFromFile);

    }
}
