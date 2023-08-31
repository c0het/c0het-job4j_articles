package ru.job4j.ocp;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.report.Report;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class ReportXMLTest {
    @Test
    public void jsonReportWithOnlyOneEmployee() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Nick", now, now, 200);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        store.add(worker1);
        Report reportXML = new ReportXML(store, parser);
        String expect = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<employees>\n"
                + "    <employee>\n"
                + "        <name>" + worker.getName() + "</name>\n"
                + "        <hired>" + parser.parse(worker.getHired()) + "</hired>\n"
                + "        <fired>" + parser.parse(worker.getFired()) + "</fired>\n"
                + "        <salary>" + worker.getSalary() + "</salary>\n"
                + "    </employee>\n"
                + "    <employee>\n"
                + "        <name>" + worker1.getName() + "</name>\n"
                + "        <hired>" + parser.parse(worker1.getHired()) + "</hired>\n"
                + "        <fired>" + parser.parse(worker1.getFired()) + "</fired>\n"
                + "        <salary>" + worker1.getSalary() + "</salary>\n"
                + "    </employee>\n"
                + "</employees>\n";
        assertThat(reportXML.generate(employee -> true)).isEqualTo(expect);
    }

}