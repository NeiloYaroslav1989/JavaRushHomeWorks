package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(reader.readLine());
        File file2 = new File(reader.readLine());
//        File file1 = new File("C:/JavaRushTasks/Test1.txt");
//        File file2 = new File("C:/JavaRushTasks/Test2.txt");

        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);

        byte[] buffer = new byte[inputStream.available()];

        inputStream.read(buffer);

        for (int i = buffer.length-1; i >= 0; i--) {
            outputStream.write(buffer[i]);
        }

        inputStream.close();
        outputStream.close();

    }
}
