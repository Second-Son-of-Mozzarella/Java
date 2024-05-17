package edu.wctc;

import java.time.LocalDate;

public interface DataFormatter {

    String formatDate(LocalDate date);
    String getDateFormat();
}
