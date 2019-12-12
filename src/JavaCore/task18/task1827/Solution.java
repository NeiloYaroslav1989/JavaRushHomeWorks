package com.javarush.task.task18.task1827;

/* 
Прайсы
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

        BufferedReader readerFile = new BufferedReader(new FileReader(fileName));
        List<String> dataFromFile = new ArrayList<>();
        List<Integer> idFromFile = new ArrayList<>();
        String readLine;

        while ((readLine = readerFile.readLine()) != null) {
            dataFromFile.add(readLine);
            idFromFile.add(Integer.parseInt(readLine.substring(0, 8).trim()));
        }

        readerFile.close();

        int maxId = 0;

        for (int i = 0; i < idFromFile.size(); i++) {
            if (idFromFile.get(i) > maxId) {
                maxId = idFromFile.get(i);
            }
        }

        if ((args.length == 4) && args[0].equals("-c")) {
            String id = String.format("%-8d", ++maxId);
            String productName = String.format("%-30.30s", args[1]);
            String price = String.format("%-8.2f", Double.parseDouble(args[2]));
            String quantity = String.format("%-4d", Integer.parseInt(args[3]));

            String newProduct = id + productName + price + quantity + "\n";
            System.out.println(newProduct);

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
            bufferedWriter.newLine();
            bufferedWriter.write(newProduct);
            bufferedWriter.close();
        }







    }
}
