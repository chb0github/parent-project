package org.bongiorno.dto.typeadapters.java;

import java.lang.String;

public class LocalDateAsDateAdapter extends DefaultDateAdapter {


    public LocalDateAsDateAdapter(){
        super("yyyyMMdd");
    }

    public LocalDateAsDateAdapter(String format) {
        super(format);
    }

}
