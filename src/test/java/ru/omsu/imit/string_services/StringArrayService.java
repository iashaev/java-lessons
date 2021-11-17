package ru.omsu.imit.string_services;

public class StringArrayService {
    // Найти количество строк в массиве строк, которые начинаются на заданный символ
    public static int getCountWordsByFirstChar(String[] array, char ch) {
        int count = 0;
        for (String s: array) {
            if (s == null || s.isEmpty()) { continue; }
            if (s.charAt(0) == ch) {
                count++;
            }
        }
        return count;
    }

    // По массиву строк построить новый массив, в котором в начале каждой строки стоит ее номер
    public static String[] addLineNumbers(String[] array) {
        String[] resultArray = new String[array.length];
        int numLine = 1;
        for (String s: array) {
            resultArray[numLine - 1] = String.format("%d. %s", numLine++, s);
        }
        return resultArray;
    }
}
