package ru.job4j.ood.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

        //Нуженые тесты. 1) Место занято. 2) не верное место 3) сеанс не найден 4) сеанс уже добавлен

@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
public class Cinema3DTest {
    @Test
    public void whenBuyThenGetTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        Session3D session3D = new Session3D();
        Ticket ticket = new Ticket3D(account, 1, 1, date);
        assertThat(ticket).isEqualTo(cinema.buy(session3D, account, 1, 1, date));
    }

    @Test
    public void whenAddSessionThenItExistsBetweenAllSessions() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        List<Session> sessions = cinema.find(ses -> true);
        assertThat(sessions).contains(session);
    }

    @Test
    public void whenBuyOnInvalidRowThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        Session session = new Session3D();
        assertThatThrownBy(() -> cinema.buy(session, account, -1, 1, date)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenBuyOnInvalidColumThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        Session session = new Session3D();
        assertThatThrownBy(() -> cinema.buy(session, account, 1, -1, date)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenBuySoldTicket() {
        Account account1 = new AccountCinema();
        Account account2 = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar data = Calendar.getInstance();
        Session session = new Session3D();
        cinema.buy(session, account1, 1, 1, data);
        assertThatThrownBy(() -> cinema.buy(session, account2, 1, 1, data)).hasMessage("Место занято");
    }

    @Test
    public void whenNotFoundSession() {
        Cinema cinema = new Cinema3D();
        assertThatThrownBy(() -> cinema.find(session1 -> false)).hasMessage("Сеанс не найден");
    }

    @Test
    public void whenSessionAlreadyAdded() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        assertThatThrownBy(() -> cinema.add(session)).hasMessage("Сеанс уже добавлен");
    }
}