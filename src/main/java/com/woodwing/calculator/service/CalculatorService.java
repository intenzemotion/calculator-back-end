package com.woodwing.calculator.service;

import java.math.BigDecimal;

public interface CalculatorService {

    double add(String outputUnit, double value1, String unit1, double value2, String unit2);

    double subtract(String outputUnit, double value1, String unit1, double value2, String unit2);

    double multiply(String outputUnit, double value1, String unit1, double value2, String unit2);

    double divide(String outputUnit, double value1, String unit1, double value2, String unit2);
}
