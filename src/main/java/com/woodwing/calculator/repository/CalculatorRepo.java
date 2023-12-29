package com.woodwing.calculator.repository;

import com.woodwing.calculator.model.Calculator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculatorRepo extends JpaRepository<Calculator, Long> {
    // TODO: for now there is no CRUD involved
}
