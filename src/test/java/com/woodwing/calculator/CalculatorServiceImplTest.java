package com.woodwing.calculator;

import com.woodwing.calculator.service.CalculatorServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {

    private final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

    @Test
    void add() {

        double value1 = 5.0;
        String unit1 = "meter";
        double value2 = 3.0;
        String unit2 = "yard";

        double result = calculatorService.add(value1, unit1, value2, unit2);

        assertEquals(7.74, result, 0.01);
    }

    @Test
    void subtract() {

        double value1 = 8.0;
        String unit1 = "meter";
        double value2 = 2.0;
        String unit2 = "yard";

        double result = calculatorService.subtract(value1, unit1, value2, unit2);

        assertEquals(6.17, result, 0.01);
    }

    @Test
    void multiply() {

        double value1 = 4.0;
        String unit1 = "meter";
        double value2 = 2.5;
        String unit2 = "yard";

        double result = calculatorService.multiply(value1, unit1, value2, unit2);

        assertEquals(9.16, result, 0.01);
    }

    @Test
    void divide() {

        double value1 = 9.0;
        String unit1 = "meter";
        double value2 = 3.0;
        String unit2 = "yard";

        double result = calculatorService.divide(value1, unit1, value2, unit2);

        assertEquals(3.28, result, 0.01);
    }
}
