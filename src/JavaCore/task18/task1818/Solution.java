package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File fileSrc1 = new File(reader.readLine());
        File fileSrc2 = new File(reader.readLine());
        File fileSrc3 = new File(reader.readLine());

//        File fileSrc1 = new File("C:/JavaRushTasks/Test1.txt");
//        File fileSrc2 = new File("C:/JavaRushTasks/Test2.txt");
//        File fileSrc3 = new File("C:/JavaRushTasks/Test3.txt");
        reader.close();

        FileOutputStream outputStream1 = new FileOutputStream(fileSrc1);
        FileInputStream inputStream2 = new FileInputStream(fileSrc2);
        FileInputStream inputStream3 = new FileInputStream(fileSrc3);

        byte[] buffer = new byte[1000];
        int countByteFromFile = inputStream2.available();

        while (inputStream2.available() > 0) {
            int count = inputStream2.read(buffer);
            outputStream1.write(buffer, 0, count);
        }
        inputStream2.close();

        while (inputStream3.available() > 0) {
            int count = inputStream3.read(buffer);
            outputStream1.write(buffer, 0, count);
        }

        inputStream3.close();
        outputStream1.close();



    }
}
