package com.sbt.lesson6.cache;

public class CalculatorImpl implements Calculator {
    @Override
    public double eval(String expression) {
        String[] expr = expression.split(" ");
        if (expr.length != 2) throw new IllegalArgumentException("Неккоректное выражение, требуется два числа через пробел");
        double val1 = Double.parseDouble(expr[0]);
        double val2 = Double.parseDouble(expr[1]);
        double result = 0;
        result = val1 + val2;
        return result;
    }
}
