package org.bongiorno.dto.typeadapters.java8;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.util.function.Function;

/**
 * @author chribong
 */
public abstract class AbstractJava8Adapter<T extends TemporalAccessor> extends XmlAdapter<String,T> implements Function<T,String> {

    protected DateTimeFormatter formatter;

    protected abstract T parse(String time);

    @Override
    public T unmarshal(String v) throws Exception {
        T result = null;
        try {
            result = parse(v);
        } catch (DateTimeParseException e) {
            String message = e.getMessage() + "; valid format example: '" + formatter.format(LocalDate.now()) + "'";
            throw new DateTimeParseException(message, e.getParsedString(),e.getErrorIndex(), e);
        }
        return result;
    }

    @Override
    public String marshal(T v) throws Exception {
        return formatter.format(v);
    }

    @Override
    public String apply(T t) {
        try {
            return marshal(t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
