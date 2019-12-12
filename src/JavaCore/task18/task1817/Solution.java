package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        File fileSrc = new File(args[0]);
        FileInputStream inputStream = new FileInputStream(fileSrc);

        double spaceCount = 0;
        int symbolCount = inputStream.available();

        while (inputStream.available() > 0) {
            int readByte = inputStream.read();
            if (readByte == 32) {
                spaceCount++;
            }
        }
        inputStream.close();

        DecimalFormat DecFormat = new DecimalFormat("0.00");

        double relationshipSpaceToSymbol = (spaceCount / symbolCount) * 100;

        System.out.println(DecFormat.format(relationshipSpaceToSymbol));

    }
}
