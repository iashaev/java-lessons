package ru.omsu.imit.string_services;

public class StringService {
    // 1) в строке удалить все вхождения заданного символа (результат – новая строка)
    public static String deleteChars(String str, char ch) {
        return String.join("", str.split(String.valueOf(ch)));
    }

    // 2) строка состоит из слов, разделенных пробелами, по строке найти количество слов в ней
    public static int getWordsCount(String str) {
        int countWords = 0;
        for (String word : str.split(" ")) {
            if (!"".equals(word)) { countWords++; }
        }
        return countWords;
    }

    // 3)	в строке поменять местами первое и последнее слова
    public static String swapFirstAndLastWords(String str) {
        String[] words = str.split (" ", -1);
        int i = 0, j = words.length - 1;
        while (i < words.length) {
            if (!words[i].isEmpty()) { break; }
            i++;
        }
        while (j >= 0) {
            if (!words[j].isEmpty()) { break; }
            j--;
        }
        if (i >= j) {
            return str;
        }
        String tmp = words[i];
        words[i] = words[j];
        words[j] = tmp;
        return String.join(" ", words);
    }

    // 5) по трем строкам (Фамилия, Имя, Отчество) построить новую строку вида: И.О. Фамилия.
    // При этом отчества может не быть.
    public static String getShortName(String lastName, String firstName, String middleName) {
        if (middleName.isEmpty()) {
            return String.format("%c. %s", firstName.charAt(0), lastName);
        }
        return String.format("%c.%c. %s", firstName.charAt(0), middleName.charAt(0), lastName);
    }
}
