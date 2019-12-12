package com.javarush.task.task16.task1616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем секунды
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        //create and run thread
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        //read a string
        reader.readLine();
        stopwatch.interrupt();
        //close streams
        reader.close();
        in.close();
    }

    public static class Stopwatch extends Thread {
        private int seconds = 0;
//        private int minutes = 0;

        public void run() {
            try {
                while (true) {
                    Thread.sleep(1000);
                    seconds++;
//                    if (seconds == 60) {
//                        seconds = 0;
//                        minutes++;
//                    }
                }
            } catch (InterruptedException e) {
                System.out.println(seconds);
            }
        }
    }
}
