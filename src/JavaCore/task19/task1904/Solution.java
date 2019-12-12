package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
//        File file = new File("C:/JavaRushTasks/Test1.txt");
        PersonScannerAdapter psa = new PersonScannerAdapter(new Scanner(Paths.get("C:/JavaRushTasks/Test1.txt"), "Windows-1251"));
        System.out.println(psa.read());
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String line = fileScanner.nextLine();
            String[] personData = line.split(" ");
            String firstName = personData[1];
            String middleName = personData[2];
            String lastName = personData[0];
            DateFormat formatter = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            Date birthDate = null;
            try {
                birthDate = formatter.parse(personData[3] + " " + personData[4] + " " + personData[5]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Person person = new Person(firstName, middleName, lastName, birthDate);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
