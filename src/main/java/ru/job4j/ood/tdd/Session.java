package ru.job4j.ood.tdd;

import java.util.ArrayList;
import java.util.List;

public interface Session {

    List<Ticket> SOLD_TICKEETS = new ArrayList<>();

    void add(Ticket ticket);
}