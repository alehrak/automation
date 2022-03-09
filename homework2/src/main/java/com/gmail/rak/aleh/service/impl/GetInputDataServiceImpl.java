package com.gmail.rak.aleh.service.impl;

import com.gmail.rak.aleh.service.GetInputDataService;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetInputDataServiceImpl implements GetInputDataService {
    private final Scanner scanner = new Scanner(System.in);
    private static final String TEMPLATE_OPERATORS = "[+-/*]";

    @Override
    public Double getFirstOperand() {
        System.out.println("input first number: ");
        String numberOneString = scanner.nextLine();
        return checkFormatInputNumber(numberOneString);
    }

    @Override
    public Double getSecondOperand() {
        System.out.println("input second number: ");
        String numberOneString = scanner.nextLine();
        return checkFormatInputNumber(numberOneString);
    }

    @Override
    public String getMathematicalOperator() {
        System.out.println("input operand: ");
        String operator = scanner.nextLine();
        return getMathematicalOperator(operator);
    }

    @Override
    public String getMathematicalOperator(String operator) {
        Pattern pattern = Pattern.compile(TEMPLATE_OPERATORS);
        Matcher matcher = pattern.matcher(operator);
        boolean matches = matcher.matches();
        if (matches) {
            return operator;
        } else {
            System.out.printf("operator: %s is not available for input, enter one of %s, ", operator, TEMPLATE_OPERATORS);
            return getMathematicalOperator();
        }
    }

    @Override
    public Double updateDataForDeleteByZero(Double numberTwo) {
        Double newNumberTwo = numberTwo;
        while (newNumberTwo == 0) {
            System.out.println("you cannot divide by 0, enter a different value");
            newNumberTwo = getSecondOperand();
        }
        return newNumberTwo;
    }

    @Override
    public Double checkFormatInputNumber(String number) {
        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            System.out.println("the entered value does not match the format, try again");
            return getFirstOperand();
        }
    }
}
