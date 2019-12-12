package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        String url = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";
//        String url = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        reader.close();

        int indexStart = url.indexOf("?");
        String partUrlWithParametrs = url.substring(++indexStart);
//        System.out.println(partUrlWithParametrs);

        for (String s : partUrlWithParametrs.split("\\&")) {
//            System.out.println(s);
            if (s.contains("=")) {
                System.out.print(s.substring(0, s.indexOf("=")) + " ");
            } else {
                System.out.print(s + " ");
            }
        }

        for (String s : partUrlWithParametrs.split("\\&")) {
            if (s.contains("obj")) {
                int beginIndex = s.indexOf("=");
                String valueOfParametrs = s.substring(++beginIndex);
                if(valueOfParametrs.matches("-?\\d+(\\.\\d+)?")) {
                    System.out.println();
                    alert(Double.parseDouble(valueOfParametrs));
                } else {
                    System.out.println();
                    alert(valueOfParametrs);
                }
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
