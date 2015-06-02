package org.bongiorno.dto.typeadapters.java8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author chribong
 */
public class LocalDateAdapter extends AbstractJava8Adapter<LocalDate> {

    public LocalDateAdapter() {
        super.formatter = DateTimeFormatter.ISO_LOCAL_DATE;
    }

    public LocalDateAdapter(String format) {
        super.formatter = DateTimeFormatter.ofPattern(format);
    }
    protected LocalDate parse(String time) {
        return LocalDate.parse(time, formatter);
    }

}
