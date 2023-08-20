package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;
import ru.job4j.ood.srp.currency.Currency;

import java.util.Calendar;
import java.util.Scanner;
import java.util.function.Predicate;

public class ReportBookkeeping implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public ReportBookkeeping(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        InMemoryCurrencyConverter converter = new InMemoryCurrencyConverter();
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(" ")
                    .append(dateTimeParser.parse(employee.getHired())).append(" ")
                    .append(dateTimeParser.parse(employee.getFired())).append(" ")
                    .append(converter.convert(Currency.valueOf(scanner.nextLine()), employee.getSalary(), Currency.valueOf(scanner.nextLine())))
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
