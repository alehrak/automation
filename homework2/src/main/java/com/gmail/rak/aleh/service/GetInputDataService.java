package com.gmail.rak.aleh.service;

public interface GetInputDataService {
    Double getFirstOperand();
    String getMathematicalOperator();
    Double getSecondOperand();
    Double updateDataForDeleteByZero(Double numberTwo);
    Double checkFormatInputNumber(String numberOneString);
    String getMathematicalOperator(String operator);
}
