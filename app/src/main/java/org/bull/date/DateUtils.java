package org.bull.date;

import java.util.Calendar;
import java.util.Date;

/**
 * Utilities for working with dates
 * <p>
 * Created by amit on 07/01/16.
 */
public class DateUtils {

    /* --- Static methods --- */

    /**
     * Method to add a certain amount of days to a date object
     * @param date - The date object
     * @param days - The amount of days to add
     * @return Date object
     */
    public static Date addDays(Date date, int days) {
        Calendar cal = dateToCalendar(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    /**
     * Method to turn a date instance into a calendar instance
     * @param date - The date instance to transform
     * @return Calendar instance
     */
    public static Calendar dateToCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

}
