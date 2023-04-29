package algorithm.offer;

public class Power {
    public double power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }

        long exponentLong = exponent;

        long absExponent = exponentLong < 0 ? -exponentLong : exponentLong;

        double result = power2(base, absExponent);
        if (exponent < 0) {
            return 1 / result;
        } else {
            return result;
        }

    }

    public double power2(double base, long exponent) {

        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        double result = power2(base, exponent >> 1);
        result = result * result;

        if ((exponent & 1) == 1) {
            result *= base;
        }
        return result;

    }

    public static void main(String[] args) {
        new Power().power(1, -2147483648);
    }
}
