package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
//        String fileName = "C:/JavaRushTasks/Test1.txt";
        reader.close();

        if ((args.length == 5) && args[0].equals("-u")) {
            String id = String.format("%-8d", Integer.parseInt(args[1]));
            String productName = String.format("%-30.30s", args[2]);
            String price = String.format("%-8.2f", Double.parseDouble(args[3]));
            String quantity = String.format("%-4d", Integer.parseInt(args[4]));

            String newProduct = id + productName + price + quantity;

            BufferedReader readerFile = new BufferedReader(new FileReader(fileName));

            List<String> dataFromFile = new ArrayList<>();
            String readLine;
            int parameterID = Integer.parseInt(args[1]);

            while ((readLine = readerFile.readLine()) != null) {
                int searchID = Integer.parseInt(readLine.substring(0, 8).trim());

                if (parameterID != searchID) {
                    dataFromFile.add(readLine);
                } else if (parameterID == searchID) {
                    dataFromFile.add(newProduct);
                }
            }
            readerFile.close();

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

            for (String productDescription : dataFromFile) {
                bufferedWriter.write(productDescription);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        } else if ((args.length == 2) && args[0].equals("-d")) {
            BufferedReader readerFile = new BufferedReader(new FileReader(fileName));

            List<String> dataFromFile = new ArrayList<>();
            String readLine;
            int parameterID = Integer.parseInt(args[1]);

            while ((readLine = readerFile.readLine()) != null) {
                int searchID = Integer.parseInt(readLine.substring(0, 8).trim());
                if (parameterID != searchID) {
                    dataFromFile.add(readLine);
                }
            }
            readerFile.close();

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

            for (String productDescription : dataFromFile) {
                bufferedWriter.write(productDescription);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

        }







    }
}
