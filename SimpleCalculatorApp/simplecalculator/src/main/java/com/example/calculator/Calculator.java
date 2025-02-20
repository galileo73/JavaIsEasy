// Calculator.java
package com.example.calculator;

import java.util.logging.Logger;

public class Calculator {
    private static final Logger logger = Logger.getLogger(Calculator.class.getName());
    private double n1;
    private double n2;
    private char op;

    public Calculator() {
    }

    public Calculator(double n1, double n2, char op) {
        this.n1 = n1;
        this.n2 = n2;
        this.op = op;
    }

    public char getOp() {
        return op;
    }

    public void setOp(char op) {
        this.op = op;
    }

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    @Override
    public String toString() {
        return "Calculator [n1=" + n1 + ", n2=" + n2 + "]";
    }

    /**
     * Performs a calculation based on the provided numbers and operator.
     *
     * @param num1     First operand
     * @param num2     Second operand
     * @param operator Arithmetic operator (+, -, *, /)
     * @return Result of the calculation or NaN for invalid operations
     */
    public double calculate(double num1, double num2, char operator) {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> {
                if (num2 == 0) {
                    logger.warning("Division by zero attempted.");
                    yield Double.NaN;
                } else {
                    yield num1 / num2;
                }
            }
            default -> {
                logger.warning("Invalid operator: " + operator);
                yield Double.NaN;
            }
        };
    }
}