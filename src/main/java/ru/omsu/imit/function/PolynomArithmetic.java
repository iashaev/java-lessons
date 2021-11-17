package ru.omsu.imit.function;

public class PolynomArithmetic {
    public static Polynom sum(Polynom f, Polynom g) {   // (1 + 2x + 3x^2) + (3 - 4x)
        Polynom minDegreePolynom = f;
        Polynom maxDegreePolynom = g;
        if (f.getDegree() > g.getDegree()) {
            minDegreePolynom = g;
            maxDegreePolynom = f;
        }
        double[] sumCoeff = new double[minDegreePolynom.getDegree()];

        for (int i = 0; i <= minDegreePolynom.getDegree(); i++) {
            sumCoeff[i] = minDegreePolynom.getCoeff(i) + maxDegreePolynom.getCoeff(i);
        }
        for (int i = minDegreePolynom.getDegree() + 1; i <= maxDegreePolynom.getDegree(); i++) {
            sumCoeff[i] = maxDegreePolynom.getCoeff(i);
        }

        return new Polynom(sumCoeff);
    }

    public static Polynom subtract(Polynom f, Polynom g) {
        return sum(f, multiplyByNumber(g, -1.0));
    }

    public static Polynom multiply(Polynom f, Polynom g) {
        return null; // TODO: need to implement
    }

    public static Polynom multiplyByNumber(Polynom f, double num) {
        double[] productCoeffs = new double[f.getDegree() + 1];
        for (int i = 0; i <= f.getDegree(); i++) {
            productCoeffs[i] = num * f.getCoeff(i);
        }
        return new Polynom(productCoeffs);
    }
}
