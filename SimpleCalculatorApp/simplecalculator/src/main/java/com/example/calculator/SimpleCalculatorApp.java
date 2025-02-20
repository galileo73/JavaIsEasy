package com.example.calculator;

import java.util.Scanner;
import java.util.logging.Logger;

public class SimpleCalculatorApp {
    private static final Logger logger = Logger.getLogger(SimpleCalculatorApp.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            logger.info("Enter first number:");
            double num1 = scanner.nextDouble();

            logger.info("Enter second number:");
            double num2 = scanner.nextDouble();

            logger.info("Choose operation (+, -, *, /):");
            char operator = scanner.next().charAt(0);

            Calculator calculator = new Calculator();
            calculator.setN1(num1);
            calculator.setN2(num2);
            calculator.setOp(operator);

            double result = calculator.calculate(num1, num2, operator);

            if (Double.isNaN(result)) {
                logger.info("Invalid operation.");
            } else {
                logger.info(String.format("Result: %.2f", result));
                logger.info(String.format("Calculation performed: %f %c %f = %f", num1, operator, num2, result));

            }
        } catch (Exception e) {
            logger.info("Error: Invalid input. Please enter numeric values and valid operators.");
            logger.severe("Input error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
