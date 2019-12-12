package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
////        File file = null;
////        FileInputStream inputStream = null;
//        while (true) {
//            String file = reader.readLine();
//            try (FileInputStream inputStream = new FileInputStream(file)) {
//                reader.close();
//            } catch (FileNotFoundException e){
//                System.out.println(file);
//                break;
//            }
//
//        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String fileNames = br.readLine();
            try (FileInputStream inputStream = new FileInputStream(fileNames)) {
                inputStream.close();
            } catch (FileNotFoundException e) {
                System.out.println(fileNames);
                break;
            }
        }
    }
}
