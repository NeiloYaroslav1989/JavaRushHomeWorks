package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
//        String fileName1 = "C:/JavaRushTasks/Test1.txt";
//        String fileName2 = "C:/JavaRushTasks/Test2.txt";
        reader.close();

        BufferedReader fileBufferReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileBufferWriter = new BufferedWriter(new FileWriter(fileName2));
        while (fileBufferReader.ready()) {
            String readLine = fileBufferReader.readLine();
            String[] splitReadLine = readLine.split(" ");

            StringBuilder stringBuilder = new StringBuilder();

            for (String number : splitReadLine) {
                if (number.matches("\\d+")) {
                    stringBuilder.append(number + " ");
                }
            }

            String onlyNumber = stringBuilder.toString();
            fileBufferWriter.write(onlyNumber);


        }
        fileBufferReader.close();
        fileBufferWriter.close();
    }
}
