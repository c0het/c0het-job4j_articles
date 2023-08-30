package ru.job4j.ocp;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.report.Report;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class ReportJSONTest {

    @Test
    public void jsonReport() throws Exception {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        store.add(worker1);
        Report engine = new ReportJSON(store, parser);
        String expect = "[\n"
                + "  {\n"
                + "    \"name\": \"" + worker.getName() + "\",\n"
                + "    \"hired\": \"" + parser.parse(worker.getHired()) + "\",\n"
                + "    \"fired\": \"" + parser.parse(worker.getFired()) + "\",\n"
                + "    \"salary\": " + worker.getSalary() + "\n"
                + "  },\n"
                + "  {\n"
                + "    \"name\": \"" + worker1.getName() + "\",\n"
                + "    \"hired\": \"" + parser.parse(worker1.getHired()) + "\",\n"
                + "    \"fired\": \"" + parser.parse(worker1.getFired()) + "\",\n"
                + "    \"salary\": " + worker1.getSalary() + "\n"
                + "  }\n"
                + "]";
        assertThat(engine.generate(em -> true)).isEqualTo(expect);
    }
}