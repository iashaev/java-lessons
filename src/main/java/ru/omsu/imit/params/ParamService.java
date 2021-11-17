package ru.omsu.imit.params;

public class ParamService {
    // имя1=значение1, имя2=значение2, …
    public static Param[] parse(String str) {
        if (str.trim().isEmpty()) {
            return new Param[0];
        }
        String[] pairs = str.split(", ");
        Param[] result = new Param[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            String[] nameAndValue = pairs[i].split("=");
            if (nameAndValue.length != 2 || nameAndValue[0].trim().isEmpty()) {
                throw new IllegalArgumentException("Wrong param format");
            }
            result[i] = new Param(nameAndValue[0], Integer.parseInt(nameAndValue[1]));
        }
        return result;
    }
}
