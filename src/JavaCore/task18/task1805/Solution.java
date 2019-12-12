package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
//        File file = new File("C:/JavaRushTasks/Test1.txt");
        FileInputStream inputStream = new FileInputStream(file);

        TreeSet<Integer> byteSet = new TreeSet<>();

        while (inputStream.available() > 0) {
            int readByte = inputStream.read();
            byteSet.add(readByte);
        }

        inputStream.close();

        for (int number : byteSet) {
            System.out.print(number + " ");
        }




    }
}
