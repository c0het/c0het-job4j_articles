package ru.job4j.kiss;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxMinTest {

    @Test
    public void max()  {
        MaxMin maxMin = new MaxMin();
        KissComparator comparator = new KissComparator();
        List<Workers> workers = new ArrayList<>(Arrays.asList((new Workers(10, "Nikolai")),
                new Workers(9, "Egor"), new Workers(6, "Dmitrii"),
                new Workers(15, "Stanislav")));
        Assert.assertEquals(maxMin.max(workers, comparator), new Workers(15, "Stanislav"));
    }

    @Test
    public void maxEqualExperience() {
        MaxMin maxMin = new MaxMin();
        KissComparator comparator = new KissComparator();
        List<Workers> workers = new ArrayList<>(Arrays.asList((new Workers(10, "Nikolai")),
                new Workers(15, "Egor"), new Workers(6, "Dmitrii"),
                new Workers(15, "Stanislav")));
        Assert.assertEquals(maxMin.max(workers, comparator), new Workers(15, "Stanislav"));
    }

    @Test
    public void minEqualExperience() {
        MaxMin maxMin = new MaxMin();
        KissComparator comparator = new KissComparator();
        List<Workers> workers = new ArrayList<>(Arrays.asList((new Workers(10, "Nikolai")),
                new Workers(6, "Egor"), new Workers(6, "Dmitrii"),
                new Workers(15, "Stanislav")));
        Assert.assertEquals(maxMin.min(workers, comparator), new Workers(6, "Dmitrii"));
    }

    @Test
    public void min() {
        MaxMin maxMin = new MaxMin();
        KissComparator comparator = new KissComparator();
        List<Workers> workers = new ArrayList<>(Arrays.asList((new Workers(10, "Nikolai")),
                new Workers(9, "Egor"), new Workers(6, "Dmitrii"),
                new Workers(15, "Stanislav")));
        Assert.assertEquals(maxMin.min(workers, comparator), new Workers(6, "Dmitrii"));
    }
}

