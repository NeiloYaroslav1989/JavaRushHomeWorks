package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        reset();
    }

    public static CanFly result;

    public static void reset() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String typeOfMachine = reader.readLine();
//            String typeOfMachine = "helicopter";
//            String typeOfMachine = "plane";

            if (typeOfMachine.equals("helicopter")) {
                result = new Helicopter();
            } else if (typeOfMachine.equals("plane")) {
                int numberOfPassengersCarried = Integer.parseInt(reader.readLine());
                result = new Plane(numberOfPassengersCarried);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
