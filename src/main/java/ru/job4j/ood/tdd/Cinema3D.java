package ru.job4j.ood.tdd;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Cinema3D implements Cinema {

    private final List<Session> allSessions = new ArrayList<>();

    @Override
    public List<Session> find(Predicate<Session> filter) {
        List<Session> rsl = allSessions.stream().filter(filter).collect(Collectors.toList());
        if (rsl.size() == 0) {
            throw new RuntimeException("Сеанс не найден");
        }
        return rsl;
    }

    @Override
    public Ticket buy(Session session, Account account, int row, int column, Calendar date) {
        if (row <= 0 || column <= 0) {
            throw new IllegalArgumentException();
        }
        Ticket3D ticket3D = new Ticket3D(account, row, column, date);
        if (session.SOLD_TICKEETS.contains(ticket3D)) {
            throw new RuntimeException("Место занято");
        }
        session.SOLD_TICKEETS.add(new Ticket3D(account, row, column, date));
        return new Ticket3D(account, row, column, date);
    }

    @Override
    public void add(Session session) {
        if (allSessions.contains(session)) {
            throw new RuntimeException("Сеанс уже добавлен");
        }
        allSessions.add(session);
    }
}
