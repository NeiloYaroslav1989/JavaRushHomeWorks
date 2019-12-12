package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

        IncomeData data = new IncomeData() {
            public String getCountryCode() { return "UA"; }
            public String getCompany() { return "JavaRush Ltd."; }
            public String getContactFirstName() { return "Ivan"; }
            public String getContactLastName() { return "Ivanov"; }
            public int getCountryPhoneCode() { return 38; }
            public int getPhoneNumber() { return 501234567; }
        };
//
//        IncomeDataAdapter a = new IncomeDataAdapter(data);
//
//        System.out.println(a.getCompanyName());
//        System.out.println(a.getCountryName());
//        System.out.println(a.getName());
//        System.out.println(a.getPhoneNumber());

        Customer customer = new IncomeDataAdapter(data);
        Contact contact = new IncomeDataAdapter(data);

        System.out.println(customer.getCompanyName());
        System.out.println(customer.getCountryName());

        System.out.println(contact.getName());
        System.out.println(contact.getPhoneNumber());

    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;
        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }
        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            String country = "";
            for (Map.Entry entry : countries.entrySet()) {
                if (entry.getKey().equals(data.getCountryCode())) {
                    country = entry.getValue().toString();
                }
            }
            return country;
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String number10Symbols = String.format("%010d", data.getPhoneNumber());

            String phoneFormat = String.format("+%d(%s)%s-%s-%s",
                    data.getCountryPhoneCode(),
                    number10Symbols.substring(0, 3),
                    number10Symbols.substring(3, 6),
                    number10Symbols.substring(6, 8),
                    number10Symbols.substring(8, 10));
            return phoneFormat;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}