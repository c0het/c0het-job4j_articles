package ru.job4j.srp;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public interface SortBooks<T> {

    List<T> sortBooks(Predicate<T> predicate);

    List<T> lostBooks(Calendar data, List<T> books);
}
