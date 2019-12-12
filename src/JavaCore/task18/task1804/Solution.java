package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
//        File file = new File("C:/JavaRushTasks/Test1.txt");
        reader.close();
        FileInputStream inputStream = new FileInputStream(file);

        Map<Integer, Integer> byteMap = new HashMap<>();
        int minCount = 100;

        while (inputStream.available() > 0) {
            int readByte = inputStream.read();
            int value = 0;

            if (!byteMap.containsKey(readByte)) {
                value = 1;
                byteMap.put(readByte, value);
            } else {
                value = byteMap.get(readByte);
                value++;
                byteMap.put(readByte, value);
            }

            if (minCount > value) {
                minCount = value;
            }
        }

        inputStream.close();

        for (Map.Entry entry : byteMap.entrySet()) {
            if (entry.getValue().equals(minCount)) {
                System.out.print(entry.getKey() + " ");
            }
        }








    }
}
