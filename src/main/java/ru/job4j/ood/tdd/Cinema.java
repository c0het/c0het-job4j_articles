package ru.job4j.ood.tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public interface Cinema {

    List<Session> find(Predicate<Session> filter);

    Ticket buy(Session session, Account account, int row, int column, Calendar date);

    void add(Session session);
}