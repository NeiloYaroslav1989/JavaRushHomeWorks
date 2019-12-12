package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(reader.readLine());
        File file2 = new File(reader.readLine());
//        File file1 = new File("C:/JavaRushTasks/Test1.txt");
//        File file2 = new File("C:/JavaRushTasks/Test2.txt");
        reader.close();

        FileInputStream inputStream = new FileInputStream(file1);
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);

        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : buffer) {
            stringBuilder.append((char) b);
        }
        String numberFromFile = stringBuilder.toString();

        inputStream.close();

        List<Double> arrayNumberFromFile = new ArrayList<>();
        for (String s : numberFromFile.split(" ")) {
            arrayNumberFromFile.add(Double.parseDouble(s));
        }

        StringBuilder builder = new StringBuilder();

        for (Double number : arrayNumberFromFile) {

            if (number > 0) {
                BigDecimal bigDecimal = new BigDecimal(number);
                BigDecimal roundedValues = bigDecimal.setScale(0, BigDecimal.ROUND_HALF_UP);
                builder.append(roundedValues);
                builder.append(" ");
            } else {
                BigDecimal bigDecimal = new BigDecimal(number);
                BigDecimal roundedValues = bigDecimal.setScale(0, BigDecimal.ROUND_HALF_DOWN);
                builder.append(roundedValues);
                builder.append(" ");
            }
        }

        String roundingNumber = builder.toString();
        byte[] outputByteArray = roundingNumber.getBytes();

        FileOutputStream outputStream = new FileOutputStream(file2);
        outputStream.write(outputByteArray);

        outputStream.close();

    }
}
