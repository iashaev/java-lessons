package ru.omsu.imit.function;

import java.util.Arrays;
import java.util.Objects;

public class PolynomSplitting {
    private double coeff;
    private Polynom[] factors;

    public PolynomSplitting(double coeff, Polynom[] factors) {
        this.coeff = coeff;
        this.factors = factors;
    }

    public double getCoeff() {
        return coeff;
    }

    public Polynom[] getFactors() {
        return factors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolynomSplitting that = (PolynomSplitting) o;
        return Double.compare(that.coeff, coeff) == 0 && Arrays.equals(factors, that.factors);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(coeff);
        result = 31 * result + Arrays.hashCode(factors);
        return result;
    }
}
