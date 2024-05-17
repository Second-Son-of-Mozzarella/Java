package edu.wctc;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        DataFormatter formatter = new DateFormatterFactory().getDateFormatter("European");

        System.out.println(formatter.formatDate(LocalDate.now()));
    }
}