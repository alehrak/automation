package com.gmail.rak.aleh.impl;

import com.gmail.rak.aleh.CalculationService;

public class CalculationServiceImpl implements CalculationService {

    @Override
    public double calculation(double numberOne, double numberTwo, String operand) {
        switch (operand) {
            case "+": {
                return numberOne + numberTwo;
            }
            case "-": {
                return numberOne - numberTwo;
            }
            case "*": {
                return numberOne * numberTwo;
            }
            case "/": {
                return numberOne / numberTwo;
            }
            default: {
                System.out.printf("there are no calculations for this operator - %s ", operand);
                return 0;
            }
        }
    }
}