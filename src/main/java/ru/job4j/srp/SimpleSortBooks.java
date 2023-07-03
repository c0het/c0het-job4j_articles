package ru.job4j.srp;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class SimpleSortBooks implements SortBooks<Books> {

    @Override
    public List<Books> sortBooks(Predicate<Books> predicate) {
        return null;
    }

    @Override
    public List<Books> lostBooks(Calendar data, List<Books> list) {
        return null;
    }
}
