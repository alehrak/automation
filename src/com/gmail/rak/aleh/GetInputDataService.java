package com.gmail.rak.aleh;

public interface GetInputDataService {
    Double getFirstOperand();
    String getMathematicalOperator();
    Double getSecondOperand();
    Double updateDataForDeleteByZero(Double numberTwo);
}
