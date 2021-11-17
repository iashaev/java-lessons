package ru.omsu.imit.function;

import ru.omsu.imit.function.exceptions.RationalFunctionException;

public class RationalFunction implements IDerivable {
    private final Polynom enumerator, denominator;

    public RationalFunction(Polynom enumerator, Polynom denominator) throws RationalFunctionException {
        if (denominator.getDegree() == 0 && Math.abs(denominator.getCoeff(0)) < Polynom.ACCURACY) {
            throw new RationalFunctionException("Denominator must be not zero");
        }
        this.enumerator = enumerator;
        this.denominator = denominator;
    }

    public Polynom getEnumerator() {
        return enumerator;
    }

    public Polynom getDenominator() {
        return denominator;
    }

    // (f(x)/g(x))' = (f'(x)g(x) - f(x)g'(x)) / g^2(x)
    @Override
    public IFunction derive() {
        try {
            return new RationalFunction(
                    PolynomArithmetic.subtract(
                            PolynomArithmetic.multiply((Polynom) enumerator.derive(), denominator),
                            PolynomArithmetic.multiply(enumerator, (Polynom) denominator.derive())
                    ),
                    PolynomArithmetic.multiply(denominator, denominator)
            );
        } catch (RationalFunctionException e) {
            // suspend the exception
        }
        return null;
    }

    @Override
    public double getValue(double x) throws RationalFunctionException {
        if (!inDomain(x)) {
            throw new RationalFunctionException("Value of denominator bust be non zero");
        }
        return enumerator.getValue(x) / denominator.getValue(x);
    }

    @Override
    public boolean inDomain(double x) {
        return Math.abs(denominator.getValue(x)) >= Polynom.ACCURACY;
    }
}
