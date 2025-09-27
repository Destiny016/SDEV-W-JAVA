// Destiny Harris
// Date: 09-17-2025
// Assignment: Exercise 13.9

import java.math.BigInteger;

public class BigRational extends Number implements Comparable<BigRational> {
    private BigInteger numerator;
    private BigInteger denominator;

    public BigRational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    public BigRational(BigInteger numerator, BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Denominator cannot be zero.");
        }

        // Normalize sign so denominator is always positive
        if (denominator.signum() < 0) {
            numerator = numerator.negate();
            denominator = denominator.negate();
        }

        BigInteger gcd = numerator.gcd(denominator);
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);
    }

    public BigInteger getNumerator() {
        return numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    public BigRational add(BigRational other) {
        BigInteger n = this.numerator.multiply(other.denominator)
                         .add(this.denominator.multiply(other.numerator));
        BigInteger d = this.denominator.multiply(other.denominator);
        return new BigRational(n, d);
    }

    public BigRational subtract(BigRational other) {
        BigInteger n = this.numerator.multiply(other.denominator)
                         .subtract(this.denominator.multiply(other.numerator));
        BigInteger d = this.denominator.multiply(other.denominator);
        return new BigRational(n, d);
    }

    public BigRational multiply(BigRational other) {
        BigInteger n = this.numerator.multiply(other.numerator);
        BigInteger d = this.denominator.multiply(other.denominator);
        return new BigRational(n, d);
    }

    public BigRational divide(BigRational other) {
        if (other.numerator.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Cannot divide by zero.");
        }

        BigInteger n = this.numerator.multiply(other.denominator);
        BigInteger d = this.denominator.multiply(other.numerator);
        return new BigRational(n, d);
    }

    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE)) {
            return numerator.toString();
        } else {
            return numerator + "/" + denominator;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BigRational) {
            BigRational other = (BigRational) obj;
            return this.numerator.equals(other.numerator) &&
                   this.denominator.equals(other.denominator);
        }
        return false;
    }

    @Override
    public int compareTo(BigRational other) {
        BigRational diff = this.subtract(other);
        return diff.getNumerator().signum();
    }

    @Override
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public int intValue() {
        return numerator.divide(denominator).intValue();
    }

    @Override
    public long longValue() {
        return numerator.divide(denominator).longValue();
    }
}
