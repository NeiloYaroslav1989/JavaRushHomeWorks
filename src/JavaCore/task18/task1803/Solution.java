package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileSrc = reader.readLine();
//        String fileSrc = "C:/JavaRushTasks/Test1.txt";

        FileInputStream inputStream = new FileInputStream(fileSrc);

        List<Integer> readByteList = new ArrayList<>();
        Map<Integer, Integer> byteMap = new HashMap<>();
        int maxCount = 0;

        while (inputStream.available() > 0) {
            int readByte = inputStream.read();
            if (!byteMap.containsKey(readByte)) {
                byteMap.put(readByte, 1);
            } else {
                int value = byteMap.get(readByte);
                value++;
                byteMap.put(readByte, value);
                if (maxCount < value) {
                    maxCount = value;
                }
            }
        }

        inputStream.close();

        for (Map.Entry entry : byteMap.entrySet()) {
            if (entry.getValue().equals(maxCount)) {
                System.out.print(entry.getKey() + " ");
            }
        }



    }
}
