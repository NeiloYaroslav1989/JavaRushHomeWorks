package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);
        stream.println();
        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();

        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString();
        String[] resultArray = result.trim().split(" ");
        int firstNumber = Integer.parseInt(resultArray[0]);
        int secondNumber = Integer.parseInt(resultArray[2]);
        switch (resultArray[1]) {
            case "+":
                result = firstNumber + " + " + secondNumber + " = " + (firstNumber + secondNumber);
                break;
            case "-":
                result = firstNumber + " - " + secondNumber + " = " + (firstNumber - secondNumber);
                break;
            case "*":
                result = firstNumber + " * " + secondNumber + " = " + (firstNumber * secondNumber);
                break;
        }


        //Возвращаем все как было
        System.setOut(consoleStream);

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

