package edu.wctc;

import java.time.LocalDate;

public class MilitaryDateFormater implements DataFormatter{
    @Override
    public String formatDate(LocalDate date) {
        // DD MMM YY
        return String.format("%02d %s %d",
                date.getDayOfMonth(),
                date.getMonth().toString().substring(0, 3),
                date.getYear() % 100);
    }

    @Override
    public String getDateFormat() {
        return "Military";
    }
}
