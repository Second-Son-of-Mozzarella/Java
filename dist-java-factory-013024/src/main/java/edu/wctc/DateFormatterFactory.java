package edu.wctc;

public class DateFormatterFactory {
    public DataFormatter getDateFormatter(String format){
        if(format.equalsIgnoreCase("Military")){
            return new MilitaryDateFormater();
        }

        else if (format.equalsIgnoreCase("European")){
            return  new EuropeanDateFormatter();
        }

        return null;

    }
}
