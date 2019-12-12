package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(reader.readLine());
        File file2 = new File(reader.readLine());
//        File file1 = new File("C:/JavaRushTasks/Test1.txt");
//        File file2 = new File("C:/JavaRushTasks/Test2.txt");

        reader.close();

        FileInputStream inputStream1 = new FileInputStream(file1);
        byte[] bufferForFile1 = new byte[inputStream1.available()];
        inputStream1.read(bufferForFile1);
        inputStream1.close();

        FileInputStream inputStream2 = new FileInputStream(file2);
        FileOutputStream outputStream1 = new FileOutputStream(file1);

        byte[] bufferForFile2 = new byte[inputStream2.available()];
        inputStream2.read(bufferForFile2);
        outputStream1.write(bufferForFile2);

        outputStream1.write(bufferForFile1);

        inputStream1.close();
        inputStream2.close();
        outputStream1.close();

    }
}
