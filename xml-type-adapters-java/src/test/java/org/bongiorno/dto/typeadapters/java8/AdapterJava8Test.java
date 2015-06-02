package org.bongiorno.dto.typeadapters.java8;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

/**
 * @author chribong
 */
public class AdapterJava8Test {

    @Test
    public void testDateTime() throws Exception {
        LocalDateTimeAdapter adapter = new LocalDateTimeAdapter();
        LocalDateTime expected = LocalDateTime.of(1976, 9, 10, 9, 0, 0);

        String expectedStr = "1976-09-10T09:00:00";
        LocalDateTime resultDt = adapter.parse(expectedStr);
        assertEquals(expected,resultDt);

        String resultStr = adapter.marshal(expected);
        assertEquals(expectedStr,resultStr);
    }

    @Test
    public void testDateTimeWFormat() throws Exception {
        LocalDateTimeAdapter adapter = new LocalDateTimeAdapter("yyyyMMdd-HHmmss");
        LocalDateTime expected = LocalDateTime.of(1976, 9, 10, 9, 0, 0);

        String expectedStr = "19760910-090000";
        LocalDateTime resultDt = adapter.parse(expectedStr);
        assertEquals(expected,resultDt);

        String resultStr = adapter.marshal(expected);
        assertEquals(expectedStr,resultStr);
    }

    @Test
    public void testLocalDate() throws Exception {
        LocalDateAdapter adapter = new LocalDateAdapter();
        LocalDate expected = LocalDate.of(1976,9,10);

        String expectedStr = "1976-09-10";
        LocalDate resultDt = adapter.parse(expectedStr);
        assertEquals(expected,resultDt);

        String resultStr = adapter.marshal(expected);
        assertEquals(expectedStr,resultStr);
    }

    @Test
    public void testLocalDateWithFormat() throws Exception {
        LocalDateAdapter adapter = new LocalDateAdapter("MMddyyyy");
        LocalDate expected = LocalDate.of(1976,9,10);

        String expectedStr = "09101976";
        LocalDate resultDt = adapter.parse(expectedStr);
        assertEquals(expected,resultDt);

        String resultStr = adapter.marshal(expected);
        assertEquals(expectedStr,resultStr);
    }

    @Test
         public void testLocalTime() throws Exception {
        LocalTimeAdapter adapter = new LocalTimeAdapter();
        LocalTime expected = LocalTime.of(9,0,0);

        String expectedStr = "09:00:00";
        LocalTime resultDt = adapter.parse(expectedStr);
        assertEquals(expected,resultDt);

        String resultStr = adapter.marshal(expected);
        assertEquals(expectedStr,resultStr);
    }

    @Test
    public void testLocalTimeWithFormat() throws Exception {
        LocalTimeAdapter adapter = new LocalTimeAdapter("HHmmss");
        LocalTime expected = LocalTime.of(9,0,0);

        String expectedStr = "090000";
        LocalTime resultDt = adapter.parse(expectedStr);
        assertEquals(expected,resultDt);

        String resultStr = adapter.marshal(expected);
        assertEquals(expectedStr,resultStr);
    }
}
