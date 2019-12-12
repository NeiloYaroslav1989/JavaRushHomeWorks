package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
//        String file1 = "C:/JavaRushTasks/Test1.txt";
//        String file2 = "C:/JavaRushTasks/Test2.txt";
        reader.close();

//        BufferedReader fileReader = new BufferedReader(new FileReader(file1));
        List<Character> fileReadLineList = new ArrayList<>();

        FileReader fileReader = new FileReader(file1);
        while (fileReader.ready()) {
            fileReadLineList.add((char)fileReader.read());
        }
        fileReader.close();

//        System.out.println(fileReadLineList);

//        List<Integer> fileOutList = new ArrayList<>();
//        for (int i = 0; i < fileReadLineList.size(); i++) {
//            if (i % 2 != 0) {
//                fileOutList.add(fileReadLineList.get(i));
//            }
//        }
//        System.out.println(fileOutList);

        FileWriter fileWriter = new FileWriter(file2);
        for (int i = 0; i < fileReadLineList.size(); i++) {
            if (i % 2 != 0) {
                fileWriter.append(fileReadLineList.get(i));
            }
        }
        fileWriter.close();



    }
}
