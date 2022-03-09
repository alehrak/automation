package com.gmail.rak.aleh.service.impl;

import com.gmail.rak.aleh.service.CalculationService;

public class CalculationServiceImpl implements CalculationService {

    @Override
    public double calculation(double numberOne, double numberTwo, String operand) {
        switch (operand) {
            case "+": {
                double result = numberOne + numberTwo;
                return Math.round(result * 100) / 100.0;
            }
            case "-": {
                double result = numberOne - numberTwo;
                return Math.round(result * 100) / 100.0;
            }
            case "*": {
                double result = numberOne * numberTwo;
                return Math.round(result * 100) / 100.0;
            }
            case "/": {
                double result = numberOne / numberTwo;
                return Math.round(result * 100) / 100.0;
            }
            default: {
                System.out.printf("there are no calculations for this operator - %s ", operand);
                throw new IllegalArgumentException();
            }
        }
    }
}
