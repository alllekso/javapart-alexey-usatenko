package com.telesens.academy.lesson11;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator implements ArithmeticOperations {
    private static final int SCALE = 5;

    @Override
    public BigDecimal div(BigDecimal x1, BigDecimal x2) throws DivisionByZero {
        if (x2.compareTo(BigDecimal.ZERO) == 0)
            throw new DivisionByZero();

        return x1.divide(x2, SCALE, RoundingMode.HALF_UP);
    }
}
