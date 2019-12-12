package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            File file = new File(reader.readLine());
    //        File file = new File("C:/JavaRushTasks/Test1.txt");
            FileInputStream inputStream = new FileInputStream(file);
            if (inputStream.available() < 1000) {
                throw new DownloadException();
            }
            inputStream.close();
        }

    }

    public static class DownloadException extends Exception {

    }
}
