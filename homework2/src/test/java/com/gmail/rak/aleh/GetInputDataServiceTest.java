package com.gmail.rak.aleh;

import com.gmail.rak.aleh.service.GetInputDataService;
import com.gmail.rak.aleh.service.impl.GetInputDataServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetInputDataServiceTest {
    GetInputDataService service = new GetInputDataServiceImpl();

    @Test
    public void testCheckConversionStringToDouble() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(3, service.checkFormatInputNumber("3")),
                () -> Assertions.assertEquals(3.2345, service.checkFormatInputNumber("3.2345")),
                () -> Assertions.assertEquals(-1.2, service.checkFormatInputNumber("-1.2"))
        );
    }

    @Test
    public void testCheckValidityOperator() {
        Assertions.assertAll(
                () -> Assertions.assertEquals("+", service.getMathematicalOperator("+")),
                () -> Assertions.assertEquals("-", service.getMathematicalOperator("-")),
                () -> Assertions.assertEquals("*", service.getMathematicalOperator("*")),
                () -> Assertions.assertEquals("/", service.getMathematicalOperator("/"))
        );
    }
}