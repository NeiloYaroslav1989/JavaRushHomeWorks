package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName; // C:/JavaRushTasks/Test1.txt
    public static String secondFileName; // C:/JavaRushTasks/Test2.txt

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
//            firstFileName = "C:/JavaRushTasks/Test1.txt";
//            secondFileName = "C:/JavaRushTasks/Test2.txt";
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);

    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileContent = "";
        private String content = "";

        @Override
        public void run() {
            content = fileContent;
            this.getFileContent();
        }

        @Override
        public void setFileName(String fullFileName) {
            try {
                BufferedReader readerFile = new BufferedReader(new InputStreamReader(new FileInputStream(fullFileName)));
                String str;
                while ((str = readerFile.readLine()) != null) {
                    fileContent += str + " ";
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String getFileContent() {
            return content;
        }



    }
}
