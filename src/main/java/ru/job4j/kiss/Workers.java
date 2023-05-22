package ru.job4j.kiss;

import java.util.Objects;

public class Workers {

    private final int experience;
    private final String name;

    public Workers(int experience, String name) {
        this.experience = experience;
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Workers{" +
                "experience=" + experience +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workers workers = (Workers) o;
        return experience == workers.experience && name.equals(workers.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(experience, name);
    }
}
