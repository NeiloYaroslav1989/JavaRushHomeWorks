package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        DateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        DateFormat formatterOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        String parameter = args[0];
        int id = 0;
        String name = null;
        String sex = null;
        Date birthDay = null;

        try {
            if (args[0].equals("-u")) {
                id = Integer.parseInt(args[1]);
                name = args[2];
                sex = args[3];
                birthDay = formatterIn.parse(args[4]);
            } else if (args[0].equals("-c")) {
                name = args[1];
                sex = args[2];
                birthDay = formatterIn.parse(args[3]);
            } else if (args[0].equals("-d")) {
                id = Integer.parseInt(args[1]);
            } else if (args[0].equals("-i")) {
                id = Integer.parseInt(args[1]);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


        switch (args[0]) {
            case "-c": {
                if (sex.equals("м")) {
                    Person createPerson = Person.createMale(name, birthDay);
                    allPeople.add(createPerson);
                    System.out.println(allPeople.indexOf(createPerson));
                } else if (sex.equals("ж")) {
                    Person createPerson = Person.createFemale(name, birthDay);
                    allPeople.add(createPerson);
                    System.out.println(allPeople.indexOf(createPerson));
                }
                break;
            }

            case "-u": {
                if (sex.equals("м")) {
                    allPeople.set(id, Person.createMale(name, birthDay));
                } else if (sex.equals("ж")) {
                    allPeople.set(id, Person.createFemale(name, birthDay));
                }
                break;
            }

            case "-d": {
//                System.out.println(allPeople.get(id));
                allPeople.get(id).setName(null);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setBirthDate(null);
//                System.out.println(allPeople.size());
                break;

//                Person p = allPeople.get(id);
//                p.setSex(null);
//                p.setName(null);
//                p.setBirthDate(null);

//                System.out.println(allPeople.get(id));
//                allPeople.set(id, null);
            }

            case "-i": {
                String sexName;
                if (allPeople.get(id).getSex() == Sex.MALE) {
                    sexName = "м";
                } else {
                    sexName = "ж";
                }
                System.out.println(allPeople.get(id).getName() + " " + sexName + " " + formatterOut.format(allPeople.get(id).getBirthDate()));
                break;
            }

        }

    }
}
