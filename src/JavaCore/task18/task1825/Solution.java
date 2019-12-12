package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> partsName = new TreeSet<>();
        boolean isend=false;
        while (!isend){
            String s = reader.readLine();
            if (s.equals("end")){isend=true; break;}
            partsName.add(s);
        }

        String ss = partsName.toArray()[0].toString();
        String [] w = ss.split("\\.");
        String filename = w[0]+"."+w[1];
        FileOutputStream fos = new FileOutputStream(filename);

        for (String p : partsName){
            FileInputStream pf = new FileInputStream(p);
            byte [] buffer = new byte[pf.available()];
            pf.read(buffer);
            fos.write(buffer);
            pf.close();
        }
        fos.close();
    }
//    public static void main(String[] args) throws IOException{
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        TreeSet<String> fileNameList = new TreeSet<>();
//        while (true) {
//            String fileName = reader.readLine();
//            if (!fileName.equals("end")) {
//                fileNameList.add(fileName);
//            } else {
//                break;
//            }
//        }
//
//        List<Integer> fileList = new ArrayList<>();
//
//        for (String fileName : fileNameList) {
//            FileInputStream inputStream = new FileInputStream(fileName);
//            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
//            while (inputStream.available() > 0) {
//                fileList.add(bufferedInputStream.read());
//            }
//            inputStream.close();
//        }
//
//        String outputFile = fileNameList.first().split(".part\\d")[0];
//        FileOutputStream outputStream = new FileOutputStream(outputFile, true);
//        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
//
//        for (Integer num : fileList) {
//            byte[] buffer;
//
//            fileList.toArray(buffer);
//            bufferedOutputStream.write(num);
//        }
//        outputStream.close();
//
//
//
//    }
}
