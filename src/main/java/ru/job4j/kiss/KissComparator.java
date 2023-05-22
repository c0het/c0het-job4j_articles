package ru.job4j.kiss;

import java.util.Comparator;

public class KissComparator implements Comparator<Workers>  {

    @Override
    public int compare(Workers o1,  Workers o2) {
        return o1.getExperience() - o2.getExperience();
    }
}
