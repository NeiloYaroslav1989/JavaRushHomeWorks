package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileSrc1;
        String fileSrc2;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileSrc1 = reader.readLine();
            fileSrc2 = reader.readLine();
//            fileSrc1 = "C:/JavaRushTasks/Test1.txt";
//            fileSrc2 = "C:/JavaRushTasks/Test2.txt";
        }

        try (BufferedReader fileBuffReader = new BufferedReader(new FileReader(fileSrc1))) {

            while (fileBuffReader.ready()) {
                String readLine = fileBuffReader.readLine();
                String replaceDot = readLine.replaceAll("\\.", "!");

                try (BufferedWriter fileBuffWriter = new BufferedWriter(new FileWriter(fileSrc2))) {
                    fileBuffWriter.write(replaceDot);
                }
            }
        }
    }
}
