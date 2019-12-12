package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class SubSolution extends Solution{

    public SubSolution() {
    }

    protected SubSolution(String s) {
        super(s);
    }

    SubSolution(String s, int num) {
        super(s, num);
    }
}

