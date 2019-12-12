package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        while (!fileName.equals("exit")) {
            ReadThread readThread = new ReadThread(fileName);
            readThread.start();
            readThread.join();
            fileName = reader.readLine();
        }
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) throws IOException {
            this.fileName = fileName;
            FileInputStream inputStream = new FileInputStream(fileName);
            while (inputStream.available() > 0) list.add(inputStream.read());
            inputStream.close();
        }

        private String fileName = null;
        ArrayList<Integer> list = new ArrayList<>();

        @Override
        public void run() {
            int element = list.get(0);
            for (Integer x : list) if (Collections.frequency(list, x) > Collections.frequency(list, element)) element = x;
            resultMap.put(fileName, element);
        }
    }



//    public static void main(String[] args) throws IOException {
////        ReadThread.getFileName();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = null;
//        while (true) {
//            String readLine = reader.readLine();
//
//            if (readLine.equals("exit")) {
//                reader.close();
//                fileName = "exit";
//                break;
//            } else {
//                fileName = readLine;
//                new ReadThread(fileName).start();
//            }
//        }
//        reader.close();
//    }
//
//    public static class ReadThread extends Thread {
//        volatile String fileName;
//        public ReadThread(String fileName) {
//            this.fileName = fileName;
//        }
//
//        @Override
//        public void run() {
//            List<Integer> listByteFromFile = null;
//            try {
//                FileInputStream inputStream = new FileInputStream(fileName);
//                listByteFromFile = new ArrayList<>();
//
//                while (inputStream.available() > 0) {
//                    listByteFromFile.add(inputStream.read());
//                }
//
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            Integer frenquentByte = 0;
//            int count = 0;
//            int maxCount = 0;
//
//            for (Integer number : listByteFromFile) {
//                for (int i = 0; i < listByteFromFile.size(); i++) {
//                    if (number.equals(listByteFromFile.get(i))) {
//                        count++;
//                    }
//                    if (maxCount < count) {
//                        maxCount = count;
//                        frenquentByte = number;
//                    }
//                }
//
//            }
//
//            synchronized (resultMap) {
//                resultMap.put(fileName, frenquentByte);
//            }
//
//            System.out.println(resultMap);
//        }
//
////        public static void getFileName() throws IOException {
////            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
////            String fileName = null;
////            while (true) {
////                String readLine = reader.readLine();
////
////                if (readLine.equals("exit")) {
////                    reader.close();
////                    fileName = "exit";
////                    break;
////                } else {
////                    fileName = readLine;
////                    new ReadThread(fileName).start();
////                }
////            }
////            reader.close();
////        }
//    }
}
