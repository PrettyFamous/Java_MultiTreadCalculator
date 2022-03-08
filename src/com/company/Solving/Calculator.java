package com.company.Solving;

public class Calculator {
    private long calcSubstr(String substr) {
        // Если выражение без знаков,
        // Сразу возвращаем полученное число
        int pos = substr.indexOf("-");
        if (pos == -1)
            return Long.parseLong(substr);

        // Если знак есть, делим строку на первое число и остаток
        long res = Long.parseLong(substr.substring(0, pos));
        substr = substr.substring(pos + 1);
        pos = substr.indexOf("-");

        // Делаем так до тех пор, пока всё
        // подвыражение не будет вычислено
        while (pos != -1) {
            res -= Long.parseLong(substr.substring(0, pos));
            substr = substr.substring(pos + 1);
            pos = substr.indexOf("-");
        }
        return res;
    }

    public long calculateString(String str) {
        long res = 0;

        // Дробим строку на слагаемые, результат которых будет складываться
        String[] plusValues = str.split("\\+");

        // Для каждог ослагаемог овызываем его вычисление и добавляем к результату
        for (String plusValue:
                plusValues) {
            res += calcSubstr(plusValue);
        }
        return res;
    }
}
