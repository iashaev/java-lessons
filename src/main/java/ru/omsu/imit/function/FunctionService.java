package ru.omsu.imit.function;


// Задача. Добавить класс FunctionService с методом, который получает на вход массив функций и число x
// и возвращает массив значений этих функций на x.

import ru.omsu.imit.function.exceptions.FunctionException;

public class FunctionService {
    public static double[] getValues(double x, IFunction ... functions) throws FunctionException {
        double[] values = new double[functions.length];
        for (int i = 0; i < functions.length; i++) {
            if (!functions[i].inDomain(x)) {
                throw new FunctionException("Function with index " + i + " cannot be calculated on argument " + x);
            }
            values[i] = functions[i].getValue(x);
        }
        return values;
    }
}
