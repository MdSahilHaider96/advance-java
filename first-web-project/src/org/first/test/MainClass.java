package org.first.test;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class MainClass {
    public static void main(String[] args) {
        String dobString = "05-11-1987";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(dobString, formatter);
        LocalDate currDate = LocalDate.now();
        Period period = Period.between(date, currDate);
        int year = period.getYears();
        System.out.println("year: " + year);
    }
}
