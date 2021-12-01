package ru.omsu.imit.function;

public class Sample<T> {
    private T field;
    public T process(T x) { return x; }
}

class Demo {
    public static void demo() {
        Sample<String> stringSample = new Sample<>();
        Sample<Integer> integerSample = new Sample<>();
    }
}
