package ru.omsu.imit.function;


// Задача.
// 1. Написать интерфейс IFunction (функция от одно переменной). Методы:
// -- вычислить значение,
// -- проверка того, что аргумент x принадлежит области определения.
// 2. Написать производный интерфейс IDerivable с методом
// derive (вычислить производную).
// 3. Поправить класс Polynom так, чтобы он реализовывал оба этих интерфейса.
// 4. Написать класс "Рациональная функция от одной перемнной", реализующий оба интерфейса.
// 5. Написать класс "Сервис функций" с методом getValues, который получает на вход массив объектов, реализующих
// интерфейс IFunction и число x, и возвращает массив значений этих функций на x.

import ru.omsu.imit.function.exceptions.RationalFunctionException;

public interface IFunction {
    double ACCURACY = 0.0001;
    double getValue(double x) throws RationalFunctionException;
    default boolean inDomain(double x) {
        return true;
    }
}


