package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
//        String fileName = "C:/JavaRushTasks/Test1.txt";
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String dataFromFile;
        int countWord = 0;

        while (fileReader.ready()) {
            dataFromFile = fileReader.readLine();
            String[] arrayWord = dataFromFile.split("[ .,:!?()\"-]");
            for (String word : arrayWord) {
                if (("world").equals(word)) {
                    countWord++;
                }
            }
        }
        fileReader.close();

        System.out.println(countWord);
    }
}
