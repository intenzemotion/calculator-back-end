package com.woodwing.calculator.exception;

public class UnitNotSupportedException extends RuntimeException {

    // currently we don't have units other than yards and meters, so if user
    // somehow managed to use e.g. inches, it won't be supported
    public UnitNotSupportedException(String unit) {
        super("Unit not supported: " + unit);
    }
}
