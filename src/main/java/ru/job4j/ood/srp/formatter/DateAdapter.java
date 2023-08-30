package ru.job4j.ood.srp.formatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Calendar;

public class DateAdapter extends XmlAdapter<String, Calendar> {

    @Override
    public Calendar unmarshal(String s) throws Exception {
        return null;
    }

    @Override
    public String marshal(Calendar c) throws Exception {
        return new ReportDateTimeParser().parse(c);
    }
}
