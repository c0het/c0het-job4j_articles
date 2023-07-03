package ru.job4j.srp;

import java.util.List;

public interface SortBooks<T> {

    List<T> sortBooksOnTheSelf(int booksOnTheShelf);

    List<Books> lostBooks(List<Books> list);
}
