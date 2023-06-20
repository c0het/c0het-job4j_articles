package ru.job4j.ood.tdd;

public class Session3D implements Session {

    @Override
    public void add(Ticket ticket) {
        SOLD_TICKEETS.add(ticket);
    }
}
