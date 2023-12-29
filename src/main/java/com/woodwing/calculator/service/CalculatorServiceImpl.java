package com.woodwing.calculator.service;

import com.woodwing.calculator.enumeration.MeasurementUnitEnum;
import com.woodwing.calculator.exception.UnitNotSupportedException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public double add(double value1, String unit1, double value2, String unit2) {
        validateUnits(unit1, unit2);
        return convertToMeters(value1, unit1) + convertToMeters(value2, unit2);
    }

    @Override
    public double subtract(double value1, String unit1, double value2, String unit2) {
        validateUnits(unit1, unit2);
        return convertToMeters(value1, unit1) - convertToMeters(value2, unit2);
    }

    @Override
    public double multiply(double value1, String unit1, double value2, String unit2) {
        validateUnits(unit1, unit2);
        return convertToMeters(value1, unit1) * convertToMeters(value2, unit2);
    }

    @Override
    public double divide(double value1, String unit1, double value2, String unit2) {
        validateUnits(unit1, unit2);

        if (value2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }

        return convertToMeters(value1, unit1) / convertToMeters(value2, unit2);
    }

    // to check if units are either in yards or meter only, as stored in enum class
    private void validateUnits(String unit1, String unit2) {
        try {
            MeasurementUnitEnum.valueOf(unit1.toUpperCase());
            MeasurementUnitEnum.valueOf(unit2.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new UnitNotSupportedException("Unsupported unit detected. Supported units are: " + Arrays.toString(MeasurementUnitEnum.values()));
        }
    }

    // convert any combination of units into meter as our final result
    private double convertToMeters(double value, String unit) {
        BigDecimal result; // using BigDecimal is very accurate
        switch (MeasurementUnitEnum.valueOf(unit.toUpperCase())) {
            case METER:
                result = BigDecimal.valueOf(value);
                break;
            case YARD:
                result = BigDecimal.valueOf(value * 0.9144);
                break;
            default:
                throw new UnitNotSupportedException("Unsupported unit: " + unit);
        }
        // round to 2 decimal places, e.g. 7.74
        return result.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
