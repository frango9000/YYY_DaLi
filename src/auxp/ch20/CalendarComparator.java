package auxp.ch20;

import java.util.Comparator;
import java.util.GregorianCalendar;

public class CalendarComparator implements Comparator<GregorianCalendar> {

    @Override
    public int compare(GregorianCalendar o1, GregorianCalendar o2) {
        return Long.compare(o1.getTimeInMillis(), o2.getTimeInMillis());
    }
}
