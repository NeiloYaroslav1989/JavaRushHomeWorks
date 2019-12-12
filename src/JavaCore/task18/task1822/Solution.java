package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String file = reader.readLine();
////        String file = "C:/JavaRushTasks/Test1.txt";
//        reader.close();
//        int id = Integer.parseInt(args[0]);
//
//        FileInputStream inputStream = new FileInputStream(file);
////        byte[] buffer = new byte[10];
//        List<String> dataProducts = new ArrayList<>();
//        StringBuilder stringBuilder = new StringBuilder();
//
//        while (inputStream.available() > 0) {
//            int dataByte = inputStream.read();
//            if (dataByte != 10) {
//                stringBuilder.append((char)dataByte);
//            } else {
//                dataProducts.add(stringBuilder.toString());
//                stringBuilder.delete(0, stringBuilder.length());
//            }
//        }
//
//        inputStream.close();
//
////        for (String line : dataProducts) {
////            System.out.println("New line: " + line);
////
////        }
//
////        for (String lineData : dataProducts) {
////            String[] strings = lineData.split(" ");
////            if (args[0].equals(strings[0])) {
////                System.out.println(lineData);
////            }
////        }
//        for (String lineData : dataProducts) {
//            if (lineData.startsWith(args[0] + " ")) {
//                System.out.println(lineData);
//            }
//        }

        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String filemame = reader.readLine();
        int id = Integer.parseInt(args[0]);
        BufferedReader fread = new BufferedReader(new FileReader(filemame));
        String s =null;
        while ((s= fread.readLine())!=null){
            String[] str = s.split(" ");
            if(str[0].equals(String.valueOf(id))){
                System.out.println(s);
            }
        }
        fread.close();




    }
}
