package org.bongiorno.dto.typeadapters.java;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;


public class CalendarAdapter extends XmlAdapter<String, Calendar> {

    private SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");

    public CalendarAdapter() {
    }

    public CalendarAdapter(SimpleDateFormat format) {
        this.format = format;
    }

    @Override
    public String marshal(Calendar v) throws Exception {
        return format.format(v.getTime());
    }

    @Override
    public Calendar unmarshal(String v) throws Exception {
        Calendar result = Calendar.getInstance();
        result.setTime(format.parse(v));
        result.setTimeZone(TimeZone.getTimeZone("UTC"));

        return result;
    }
}
