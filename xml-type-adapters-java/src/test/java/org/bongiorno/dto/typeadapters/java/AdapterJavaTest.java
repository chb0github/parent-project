package org.bongiorno.dto.typeadapters.java;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * @author chribong
 */
public class AdapterJavaTest {

    @Test
    public void testLocalTime() throws Exception {


        LocalTimeAsDateAdapter adapter = new LocalTimeAsDateAdapter();

        String expectedString = "1300";
        Date expectedDate = new GregorianCalendar(1976, 8, 10, 13, 0, 0).getTime();

        String resultString = adapter.marshal(expectedDate);
        assertEquals(expectedString,resultString);

        Date resultDate = adapter.unmarshal(expectedString);
        // loses the year. We need to come up with the number of missing millis
        long adjustment = TimeUnit.DAYS.toMillis((365 * 6) + 10) + TimeUnit.DAYS.toMillis(8 * 30 + 4) - TimeUnit.HOURS.toMillis(1);
        resultDate = new Date(resultDate.getTime() + adjustment);
        assertEquals(expectedDate,resultDate);
    }

    @Test
    public void testLocalDate() throws Exception {
        LocalDateAsDateAdapter adapter = new LocalDateAsDateAdapter();

        String expectedString = "19760910";
        Date expectedDate = new GregorianCalendar(1976, 8, 10, 0, 0, 0).getTime();

        String resultString = adapter.marshal(expectedDate);
        assertEquals(expectedString,resultString);

        Date resultDate = adapter.unmarshal(expectedString);
        assertEquals(expectedDate,resultDate);
    }

    @Test
    public void testCalendar() throws Exception {
        String expectedString = "201311290000";

        CalendarAdapter adapter = new CalendarAdapter();

        Calendar expected = Calendar.getInstance();
        expected.setTime(new Date(113,10,29,0,0,0));
        expected.setTimeZone(TimeZone.getTimeZone("UTC"));

        Calendar result = adapter.unmarshal(expectedString);
        assertEquals(expected,result);

        String resultString = adapter.marshal(expected);
        assertEquals(expectedString,resultString);

    }

}
