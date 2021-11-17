package ru.omsu.imit.function;

// Написать класс "Многочлен от одной переменной". Многочлен храним в виде массива коэффициентов.
//     0  1  2  3 ...
//     a0 a1 a2 a3 ...      a0 + a1x^1 + a2x^2 + ...
// Методы:
// ++ конструктор,
// ++ метод получения коээфициента по его номеру,
// ++ получение степени,
// ++ вычисление значения от заданного аргумента,
// -- дифференцирование,
// -- toString()

import java.util.Arrays;

public class Polynom implements IDerivable {
    private double[] coeffs;

    public Polynom(double ... coeffs) { // new Polynom(1, 2, 0)  1 + 2x + 0x^2 ?
        int lastNonZeroCoeffIndex = - 1;
        for (int i = coeffs.length - 1; i >= 0; i--) {
            if (Math.abs(coeffs[i]) > ACCURACY) {
                lastNonZeroCoeffIndex =  i;
                break;
            }
        }
        if (lastNonZeroCoeffIndex < 0) {
            this.coeffs = new double[] { 0 };
        }
        this.coeffs = new double[lastNonZeroCoeffIndex + 1];
        for (int i = 0; i <= lastNonZeroCoeffIndex; i++) {
            this.coeffs[i] = coeffs[i];
        }
    }

    public Polynom(String str) {
        this.coeffs = new double[] { 0 };   // это заглушка
    }

    public double getCoeff(int index) {
        return coeffs[index];
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    @Override
    public double getValue(double x) {
        // a0 + a1x^1 + a2x^2 + ...
        double value = 0.0;
        double powerX = 1;
        for (double coeff: coeffs) {
            value += (coeff * powerX);
            powerX *= x;
        }
        return value;
    }

    @Override
    public IFunction derive() {
        int derivationDegree = 0;
        if (getDegree() > 0) { derivationDegree = getDegree() - 1; }
        double[] derivationCoeffs = new double[derivationDegree + 1];
        for (int i = 1; i < coeffs.length; i++) {
            derivationCoeffs[i - 1] = coeffs[i] * i;
        }
        return new Polynom(derivationCoeffs);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polynom polynom = (Polynom) o;
        return Arrays.equals(coeffs, polynom.coeffs);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coeffs);
    }
}

