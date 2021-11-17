package ru.omsu.imit.params;

import java.util.Objects;

public class Param {
    private String name;
    private int value;

    public Param(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Param param = (Param) o;
        return value == param.value && Objects.equals(name, param.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
}
