package com.woodwing.calculator.resource;

import com.woodwing.calculator.dto.CalculatorDTO;
import com.woodwing.calculator.model.Calculator;
import com.woodwing.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorResource {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorResource(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/add")
    public ResponseEntity<Calculator> add(@RequestBody CalculatorDTO requestDTO) {
        double result = calculatorService.add(requestDTO.getValue1(), requestDTO.getUnit1(), requestDTO.getValue2(), requestDTO.getUnit2());
        return ResponseEntity.ok(new Calculator(result, requestDTO.getValue1(), requestDTO.getUnit1(), requestDTO.getValue2(), requestDTO.getUnit2()));
    }

    @PostMapping("/subtract")
    public ResponseEntity<Calculator> subtract(@RequestBody CalculatorDTO requestDTO) {
        double result = calculatorService.subtract(requestDTO.getValue1(), requestDTO.getUnit1(), requestDTO.getValue2(), requestDTO.getUnit2());
        return ResponseEntity.ok(new Calculator(result, requestDTO.getValue1(), requestDTO.getUnit1(), requestDTO.getValue2(), requestDTO.getUnit2()));
    }

    @PostMapping("/multiply")
    public ResponseEntity<Calculator> multiply(@RequestBody CalculatorDTO requestDTO) {
        double result = calculatorService.multiply(requestDTO.getValue1(), requestDTO.getUnit1(), requestDTO.getValue2(), requestDTO.getUnit2());
        return ResponseEntity.ok(new Calculator(result, requestDTO.getValue1(), requestDTO.getUnit1(), requestDTO.getValue2(), requestDTO.getUnit2()));
    }

    @PostMapping("/divide")
    public ResponseEntity<Calculator> divide(@RequestBody CalculatorDTO requestDTO) {
        double result = calculatorService.divide(requestDTO.getValue1(), requestDTO.getUnit1(), requestDTO.getValue2(), requestDTO.getUnit2());
        return ResponseEntity.ok(new Calculator(result, requestDTO.getValue1(), requestDTO.getUnit1(), requestDTO.getValue2(), requestDTO.getUnit2()));
    }
}
