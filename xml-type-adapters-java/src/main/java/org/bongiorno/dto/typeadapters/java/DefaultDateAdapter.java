package org.bongiorno.dto.typeadapters.java;


import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.lang.IllegalArgumentException;import java.lang.Override;import java.lang.String;import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chribong
 */
public class DefaultDateAdapter extends XmlAdapter<String, Date>  {
    private DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmm");

    public DefaultDateAdapter(String format) {
        this.formatter = new SimpleDateFormat(format);
    }

    public Date unmarshal(String v) {
        return transform(v);
    }

    public Date transform(String s) {
        try {
            return formatter.parse(s);
        }
        catch (ParseException e) {
            throw new IllegalArgumentException(e.getMessage() + "; valid format example: '" + formatter.format(new Date()) +"'", e);
        }
    }

    @Override
    public String marshal(Date d) {
        return formatter.format(d);
    }

}
