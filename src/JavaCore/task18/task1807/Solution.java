package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
//        File file = new File("C:/JavaRushTasks/Test1.txt");
        reader.close();

        FileInputStream inputStream = new FileInputStream(file);
        int count = 0;

        while (inputStream.available() > 0) {
            int readByte = inputStream.read();
            if (readByte == 44) {
                count++;
            }
        }

        inputStream.close();

        System.out.println(count);




    }
}
