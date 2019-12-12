package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String readLine;
//        while (!(readLine = reader.readLine()).equals("exit")) {
//            if (isNumber(readLine)) {
//                if(readLine.contains(".")){
//                    print(Double.parseDouble(readLine));
//                } else if (Short.parseShort(readLine) > 0 && Short.parseShort(readLine) < 128) {
//                    print(Short.parseShort(readLine));
//                } else if (Integer.parseInt(readLine) <= 0 || Integer.parseInt(readLine) >= 128) {
//                    print(Integer.parseInt(readLine));
//                }
//            } else {
//                print(readLine);
//            }
//        }
//
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String readLine;

        while (!(readLine = reader.readLine()).equals("exit")) {
            try {
                if(readLine.contains(".") && readLine.matches("-?\\d+(\\.\\d+)?")){
                    print(Double.parseDouble(readLine));
                } else if ((Integer.parseInt(readLine) <= 0 || Integer.parseInt(readLine) >= 128) && readLine.matches("-?\\d+")) {
                    print(Integer.parseInt(readLine));
                } else if (Short.parseShort(readLine) > 0 && Short.parseShort(readLine) < 128) {
                    print(Short.parseShort(readLine));
                }
            } catch (NumberFormatException e) {
                print(readLine);
            }
        }

        reader.close();

    }

//    private static boolean isNumber(String str) {
//        if (str == null || str.isEmpty()) {
//            return false;
//        }
//        int commaCount = 0;
//        for (int i = 0; i < str.length(); i++) {
//
//            if (str.charAt(i) == '.') {
//                commaCount++;
//            }
//            if ((!Character.isDigit(str.charAt(i)) && str.charAt(i) != '.' && str.charAt(i) != '-') || commaCount > 1) {
//                return false;
//            }
//        }
//
//        return true;
//    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
