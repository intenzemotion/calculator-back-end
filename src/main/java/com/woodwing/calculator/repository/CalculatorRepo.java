package com.woodwing.calculator.repository;

import com.woodwing.calculator.model.CalculationResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculatorRepo extends JpaRepository<CalculationResult, Long> {
    // TODO
}
