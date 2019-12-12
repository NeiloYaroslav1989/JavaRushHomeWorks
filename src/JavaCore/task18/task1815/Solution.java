package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface {
        private TableInterface origin;

        public TableInterfaceWrapper(TableInterface origin) {
            this.origin = origin;
        }

        public void setModel(List rows){
            origin.setModel(rows);
            System.out.println(rows.size());

        }

        public String getHeaderText(){
           return origin.getHeaderText().toUpperCase();
        }

        public void setHeaderText(String newHeaderText){
            origin.setHeaderText(newHeaderText);
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}