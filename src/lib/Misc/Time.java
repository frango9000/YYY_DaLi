package lib.Misc;

public abstract class Time {
    // Obtain the total milliseconds since midnight, Jan 1, 1970
    static long totalMilliseconds = System.currentTimeMillis();
    // Obtain the total seconds since midnight, Jan 1, 1970
    static long totalSeconds = totalMilliseconds / 1000;
    // Compute the current second in the minute in the hour
    static long currentSecond = totalSeconds % 60;
    // Obtain the total minutes
    static long totalMinutes = totalSeconds / 60;
    // Compute the current minute in the hour
    static long currentMinute = totalMinutes % 60;
    // Obtain the total hours
    static long totalHours = totalMinutes / 60;
    // Compute the current hour
    static long currentHour = totalHours % 24;

    public static String timeToString(){
        return("Current time is " + currentHour + ":"+ currentMinute + ":" + currentSecond + " GMT: ");
    }
    public static String timeToStringM(byte offset){
        long offsetHour=currentHour + offset;
        if (offsetHour>=24)offsetHour-=24;
        return("Current time is " + offsetHour + ":" + currentMinute + ":" + currentSecond + " GMT: " + offset);
    }
    public static String timeToString(byte offset){
        long offsetHour=currentHour + offset;
        String post="AM";
        if (offsetHour>=24)offsetHour-=24;
        if (offsetHour>12){
            offsetHour-=12;
            post = "PM";
        }
        return("Current time is " + offsetHour + ":" + currentMinute + ":" + currentSecond + " "+post+" GMT: " + offset);
    }
    public static String converMillis(long millis){
        long totalMilliseconds = millis;
        long totalSeconds = totalMilliseconds / 1000;
        long currentSecond = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;
        long totalHours = totalMinutes / 60;
        long currentHour = totalHours % 24;
        return totalHours + ":" + currentMinute + ":" + currentSecond;
    }

    public static float secondsToHours(float seconds) {
        return (seconds / 60) / 60;
    }

    public static float minutesToHours(float minutes) {
        return minutes / 60;
    }

    public static double minutesToYears(int minutes) {
        return minutes / 60f / 24f / 365f;
    }

    public static double yearsToDays(double years) {
        return years * 365;
    }

    public static String monthName(int monthNumber){
        String monthName="";
        switch (monthNumber){
            case  1:monthName="January";    break;
            case  2:monthName="Febuary";    break;
            case  3:monthName="March";      break;
            case  4:monthName="April";      break;
            case  5:monthName="May";        break;
            case  6:monthName="June";       break;
            case  7:monthName="July";       break;
            case  8:monthName="August";     break;
            case  9:monthName="September";  break;
            case 10:monthName="October";    break;
            case 11:monthName="November";   break;
            case 12:monthName="December";   break;
        }
        return monthName;
    }
    public static String dayName(int dayNumber){
        String dayName="";
        if(dayNumber>6)dayNumber=dayNumber%7;
        switch (dayNumber){
            case  0:dayName="Sunday";     break;
            case  1:dayName="Monday";     break;
            case  2:dayName="Tuesday";    break;
            case  3:dayName="Wednesday";  break;
            case  4:dayName="Thursday";   break;
            case  5:dayName="Friday";     break;
            case  6:dayName="Saturday";   break;
        }
        return dayName;
    }

    public static int daysInMonth(int month, int year){
        switch(month){
            case 1:         //January
            case 3:         //March
            case 5:         //May
            case 7:         //July
            case 8:         //August
            case 10:         //October
            case 12:        //December
                return 31;
            case 4:         //April
            case 6:         //June
            case 9:         //September
            case 11:        //November
                return 30;
            case 2:         //February
                return isLeapYear(year) ?  29 : 28 ;
        }
        return 0;
    }
    public static int daysInYear(int year){
        if(isLeapYear(year))return 366;
        else return 365;
    }
    public static boolean isLeapYear(int year){
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
    public static int dayOfWeek(int year, int month, int day){
        int m;
        if( month == 1 || month == 2){
            m = month+12;
            year-=1;
        }else m = month;
        int j = year / 100;
        int k = year % 100;
        int q = day;

        int dayOfWeek = ( q + ( ( 26* (m+1) ) / 10 ) + k + (k/4) + (j/4) + (5*j) ) % 7;

        return dayOfWeek<1 ? 6 : dayOfWeek-1; //this returns 0 for sat 1 for monday
    }

    public static String dayOfWeekString(int year, int month, int day){
        return dayName(dayOfWeek(year,month,day));
    }

    public static String consoleCalendar(int year, int month) {
        StringBuilder calendar = new StringBuilder(String.format("%20s %d\n", monthName(month), year));
        calendar.append("-------------------------------------\n");

        for (int i = 0; i < 7; i++)
            calendar.append(String.format("%5s", dayName(i).substring(0, 3)));
        calendar.append("\n");

        for (int index = 0, day = 1; day <= daysInMonth(month, year); index++) {
            if (index == dayOfWeek(year, month, day))
                calendar.append(String.format("%5d", day++));
            else calendar.append(String.format("%5s", " "));

            if (index > 5) {
                calendar.append("\n");
                index = -1;
            }
        }
        return calendar.toString()+"\n\n";
    }
}
