package edu.wctc;

import java.time.LocalDate;

public class EuropeanDateFormatter implements DataFormatter{
    @Override
    public String formatDate(LocalDate date) {
        // DD MMM YY
        return String.format("%d %s %d",
                date.getDayOfMonth(),
                date.getMonth(),
                date.getYear());
    }

    @Override
    public String getDateFormat() {
        return "European";
    }
}
