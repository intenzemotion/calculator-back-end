package com.woodwing.calculator.service;

public interface CalculatorService {

    double add(double value1, String unit1, double value2, String unit2);

    double subtract(double value1, String unit1, double value2, String unit2);

    double multiply(double value1, String unit1, double value2, String unit2);

    double divide(double value1, String unit1, double value2, String unit2);
}
