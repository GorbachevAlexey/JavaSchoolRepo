package com.sbt.lesson6;

public class Month {
    private int weekNumber;
    public String nameMonth;

    public Month() {
        weekNumber = 1;
        nameMonth = "March";
    }

    public Month(int weekNumber, String nameMonth) {
        this.weekNumber = weekNumber;
        this.nameMonth = nameMonth;
    }

    private int getWeekNumber() {
        return weekNumber;
    }

    public void printSomething(String str) {
        System.out.println(str);
    }
}
