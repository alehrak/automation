package com.gmail.rak.aleh;

import com.gmail.rak.aleh.model.Calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        double result = calculator.calculate();
        System.out.println("answer = " + result);
    }
}
