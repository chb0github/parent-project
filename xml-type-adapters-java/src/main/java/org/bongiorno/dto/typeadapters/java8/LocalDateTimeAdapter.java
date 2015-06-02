package org.bongiorno.dto.typeadapters.java8;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author chribong
 */
public class LocalDateTimeAdapter extends AbstractJava8Adapter<LocalDateTime>{


    public LocalDateTimeAdapter() {
        super.formatter = DateTimeFormatter.ISO_DATE_TIME;
    }

    public LocalDateTimeAdapter(String format) {
        super.formatter = DateTimeFormatter.ofPattern(format);
    }

    @Override
    protected LocalDateTime parse(String time) {
        return LocalDateTime.parse(time,formatter);
    }
}
