package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(reader.readLine());
        File file2 = new File(reader.readLine());
        File file3 = new File(reader.readLine());

//        File file1 = new File("C:/JavaRushTasks/Test1.txt");
//        File file2 = new File("C:/JavaRushTasks/Test2.txt");
//        File file3 = new File("C:/JavaRushTasks/Test3.txt");
        reader.close();

        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream2 = new FileOutputStream(file2);
        FileOutputStream outputStream3 = new FileOutputStream(file3);

        byte[] buffer = new byte[inputStream.available()];

        int secondPart = inputStream.available()/2;
        int firstPart = inputStream.available() - secondPart;

        inputStream.read(buffer);

        outputStream2.write(buffer, 0, firstPart);
        outputStream3.write(buffer, firstPart, secondPart);


        inputStream.close();
        outputStream2.close();
        outputStream3.close();

    }
}
