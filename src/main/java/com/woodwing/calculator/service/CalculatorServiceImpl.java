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
    public double add(String outputUnit, double value1, String unit1, double value2, String unit2) {
        BigDecimal result = BigDecimal.ZERO;
        validateUnitsAndOutput(unit1, unit2, outputUnit);
        if (outputUnit.equalsIgnoreCase(MeasurementUnitEnum.METER.name())) {
            result = convertToMeters(value1, unit1).add(convertToMeters(value2, unit2));
        } else if (outputUnit.equalsIgnoreCase(MeasurementUnitEnum.YARD.name())) {
            result = convertToYards(value1, unit1).add(convertToYards(value2, unit2));
        }
        return result.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double subtract(String outputUnit, double value1, String unit1, double value2, String unit2) {
        BigDecimal result = BigDecimal.ZERO;
        validateUnitsAndOutput(unit1, unit2, outputUnit);
        if (outputUnit.equalsIgnoreCase(MeasurementUnitEnum.METER.name())) {
            result = convertToMeters(value1, unit1).subtract(convertToMeters(value2, unit2));
        } else if (outputUnit.equalsIgnoreCase(MeasurementUnitEnum.YARD.name())) {
            result = convertToYards(value1, unit1).subtract(convertToYards(value2, unit2));
        }
        return result.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double multiply(String outputUnit, double value1, String unit1, double value2, String unit2) {
        BigDecimal result = BigDecimal.ZERO;
        validateUnitsAndOutput(unit1, unit2, outputUnit);
        if (outputUnit.equalsIgnoreCase(MeasurementUnitEnum.METER.name())) {
            result = convertToMeters(value1, unit1).multiply(convertToMeters(value2, unit2));
        } else if (outputUnit.equalsIgnoreCase(MeasurementUnitEnum.YARD.name())) {
            result = convertToYards(value1, unit1).multiply(convertToYards(value2, unit2));
        }
        return result.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double divide(String outputUnit, double value1, String unit1, double value2, String unit2) {
        if (value2 == 0) { // must check first
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        BigDecimal result = BigDecimal.ZERO;
        validateUnitsAndOutput(unit1, unit2, outputUnit);
        if (outputUnit.equalsIgnoreCase(MeasurementUnitEnum.METER.name())) {
            result = convertToMeters(value1, unit1).divide(convertToMeters(value2, unit2), 2, RoundingMode.HALF_UP);
        } else if (outputUnit.equalsIgnoreCase(MeasurementUnitEnum.YARD.name())) {
            result = convertToYards(value1, unit1).divide(convertToYards(value2, unit2), 2, RoundingMode.HALF_UP);
        }
        // I rounded in divide() instead, because division result could have infinite decimals right at the calculation.
        // so we don't need to round here anymore.
        return result.doubleValue();
    }

    // to check if units are either in yards or meter only, as stored in enum class
    private void validateUnitsAndOutput(String unit1, String unit2, String outputUnit) {
        try {
            MeasurementUnitEnum.valueOf(unit1.toUpperCase());
            MeasurementUnitEnum.valueOf(unit2.toUpperCase());
            MeasurementUnitEnum.valueOf(outputUnit.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new UnitNotSupportedException("Unsupported unit detected. Supported units are: " + Arrays.toString(MeasurementUnitEnum.values()));
        }
    }

    private BigDecimal convertToMeters(double value, String unit) {
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
        return result;
    }

    public BigDecimal convertToYards(double value, String unit) {
        BigDecimal result;
        switch (MeasurementUnitEnum.valueOf(unit.toUpperCase())) {
            case METER:
                result = BigDecimal.valueOf(value * 1.09361);
                break;
            case YARD:
                result = BigDecimal.valueOf(value);
                break;
            default:
                throw new UnitNotSupportedException("Unsupported unit: " + unit);
        }
        return result;
    }
}
