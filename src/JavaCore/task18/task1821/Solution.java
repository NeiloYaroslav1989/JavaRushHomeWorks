package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        FileInputStream inputStream = new FileInputStream(file);
        List<Character> byteListFromFile = new ArrayList<>();
        while (inputStream.available() > 0) {
            byteListFromFile.add((char)inputStream.read());
        }
        inputStream.close();
        TreeMap<Character, Integer> mapByteValues = new TreeMap<>();

        for (Character number : byteListFromFile) {
            int count = 0;
            for (int i = 0; i < byteListFromFile.size(); i++) {
                if (number.equals(byteListFromFile.get(i))) {
                    count++;
                }
            }
            mapByteValues.put(number, count);
        }
        for (Map.Entry entry : mapByteValues.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
