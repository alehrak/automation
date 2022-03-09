package com.gmail.rak.aleh;

import com.gmail.rak.aleh.service.CalculationService;
import com.gmail.rak.aleh.service.impl.CalculationServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

class CalculationServiceTest {
    private final CalculationService service = new CalculationServiceImpl();

    @Test
    public void testSummation() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(8, service.calculation(3, 5, "+")),
                () -> Assertions.assertEquals(5, service.calculation(10, -5, "+")),
                () -> Assertions.assertEquals(15.42, service.calculation(10.2, 5.22, "+")),
                () -> Assertions.assertEquals(-13, service.calculation(-10, -3, "+")),
                () -> Assertions.assertEquals(9.223372036854776E16, service.calculation(1e100, 2e100, "+"))
        );
    }

    @Test
    public void testSubtraction() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(5, service.calculation(10, 5, "-")),
                () -> Assertions.assertEquals(15, service.calculation(10, -5, "-")),
                () -> Assertions.assertEquals(11.98, service.calculation(23.2, 11.22, "-")),
                () -> Assertions.assertEquals(-8.4, service.calculation(-3, 5.4, "-")),
                () -> Assertions.assertEquals(-1.9999999997E10, service.calculation(3, 2e10, "-"))
        );
    }

    public static List<Object[]> dataForTestMultiplication() {
        List<Object[]> params = new ArrayList<>();
        params.add(new Object[]{15, 5, 3, "*"});
        params.add(new Object[]{17.5, 7, 2.5, "*"});
        params.add(new Object[]{-30, 10, -3, "*"});
        params.add(new Object[]{15, -5, -3, "*"});
        return params;
    }

    @MethodSource("dataForTestMultiplication")
    @ParameterizedTest
    public void testMultiplication(double result, double firstOperand, double secondOperand, String operator) {
        Assertions.assertEquals(result, service.calculation(firstOperand, secondOperand, operator));
    }

    @Test
    public void testDivision() {
        Assertions.assertEquals(2, service.calculation(10, 5, "/"));
    }

    @Test
    public void testNotValidOperator() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.calculation(10, 5, "&"));
    }
}