package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Solution solution = new Solution();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileSrc1 = reader.readLine();
//            String fileSrc1 = "C:/JavaRushTasks/Test1.txt";
            File file1 = new File(fileSrc1);
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file1));

            String fileSrc2 = reader.readLine();
//            String fileSrc2 = "C:/JavaRushTasks/Test2.txt";
            File file2 = new File(fileSrc2);
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));

            String fileLine;

            while ((fileLine = bufferedReader1.readLine()) != null) {
                allLines.add(fileLine);
            }

            while ((fileLine = bufferedReader2.readLine()) != null) {
                forRemoveLines.add(fileLine);
            }

            bufferedReader1.close();
            bufferedReader2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
//            System.out.println(allLines);
//            System.out.println(forRemoveLines);
            throw new CorruptedDataException();
        }

    }
}
