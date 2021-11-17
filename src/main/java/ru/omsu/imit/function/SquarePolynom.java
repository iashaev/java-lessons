package ru.omsu.imit.function;

// Написать произволдный класс "Квадратный трехчлен". Методы:
// -- конструктор по трем коэффициентам a, b, c
// -- конструктор по строке, считая, что в классе Polynom такой уже есть,
// -- вычисление дискриминанта,
// -- вычисление корней,
// -- разложение на множители.

public class SquarePolynom extends Polynom {
    // ax^2 + bx + c
    public double getA() { return getCoeff(2); }
    public double getB() { return getCoeff(1); }
    public double getC() { return getCoeff(0); }

    public SquarePolynom(double a, double b, double c) {
        super(c, b, a);
        if (Math.abs(a) < Polynom.ACCURACY) {
            throw new IllegalArgumentException("The first coeff must be non-zero");
        }
    }

    public SquarePolynom(String str) {
        super(str);
        if (getDegree() != 2) {
            throw new IllegalArgumentException("Wrong polynom degree");
        }
    }

    public double discriminant() {
        return getB() * getB() - 4 * getA() * getC();
    }

    public double[] getRoots() {
        double discr = discriminant();
        if (discr < 0) {
            return new double[0];
        }
        if (Math.abs(discr) < ACCURACY) {
            return new double[] { -getB() / (2 * getA()) };
        }
        return new double[] {
                (-getB() - Math.sqrt(discr)) / (2 * getA()),
                (-getB() + Math.sqrt(discr)) / (2 * getA())
        };
    }

    // ax^2 + bx + c = a(x - x1)(x - x2)
    public PolynomSplitting split() {
        double[] roots = getRoots();
        if (roots.length == 0) {
            throw new IllegalArgumentException("Cannot split the polynom: no roots");
        }
        if (roots.length == 1) {
            return new PolynomSplitting(
                    getA(),
                    new Polynom[] { new Polynom(-roots[0], 1), new Polynom(-roots[0], 1) }
            );
        }
        return new PolynomSplitting(
                getA(),
                new Polynom[] { new Polynom(-roots[0], 1), new Polynom(-roots[1], 1) }
        );
    }
}
