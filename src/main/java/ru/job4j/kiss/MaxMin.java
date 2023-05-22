package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin  {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findBy(value, predicate -> predicate <= 0, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findBy(value, predicate -> predicate >= 0, comparator);
    }

    public <T> T findBy(List<T> value, Predicate<Integer> predicate, Comparator<T> comparator) {
        T rsl = null;
        if (value.size() > 0) {
            rsl = value.get(0);
            for (int i = 1; i < value.size(); i++) {
                if (predicate.test(comparator.compare(rsl, value.get(i)))) {
                    rsl = value.get(i);
                }
            }
        }
        return rsl;
    }
}
