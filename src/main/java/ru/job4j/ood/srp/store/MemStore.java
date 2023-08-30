package ru.job4j.ood.srp.store;

import ru.job4j.ood.srp.model.Employee;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@XmlRootElement(name = "employees")
public class MemStore implements Store {

    @XmlElement(name = "employee")
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public void add(Employee em) {
        employees.add(em);
    }

    @Override
    public List<Employee> findBy(Predicate<Employee> filter) {
        return employees.stream().filter(filter).collect(Collectors.toList());
    }

    @Override
    public void sortBy(Comparator<Employee> comparator) {
        employees.sort(comparator);
    }
}