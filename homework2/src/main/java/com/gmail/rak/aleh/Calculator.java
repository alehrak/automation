package com.gmail.rak.aleh;

import com.gmail.rak.aleh.impl.CalculationServiceImpl;
import com.gmail.rak.aleh.impl.GetInputDataServiceImpl;

public class Calculator {
    private final GetInputDataService dataService = new GetInputDataServiceImpl();
    private final CalculationService calculationService = new CalculationServiceImpl();

    public Calculator() {
    }

    public double calculate() {
        Double firstOperand = dataService.getFirstOperand();
        String mathematicalOperator = dataService.getMathematicalOperator();
        Double secondOperand = dataService.getSecondOperand();
        if (mathematicalOperator.equals("/") && secondOperand == 0) {
            Double newSecondOperand = dataService.updateDataForDeleteByZero(secondOperand);
            return calculationService.calculation(firstOperand, newSecondOperand, mathematicalOperator);
        } else {
            return calculationService.calculation(firstOperand, secondOperand, mathematicalOperator);
        }
    }
}
