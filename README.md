# Calculator of Unit Measurement

This is a simple calculator app that can perform addition, subtraction, multiplication, and division of values in meters and yards. For now, it will only output in meters.

## Project Structure

- **src/main/java/com.woodwing.calculator.model**:<br/>
The Entity (in the future, might add db functionality so it can save calculation result)
  
- **src/main/java/com.woodwing.calculator.dto**:<br/>
The DTO (A data transfer object, acts as middleman)

- **src/main/java/com.woodwing.calculator.enumeration**:<br/>
MeasurementUnitEnum.java is stored here. Currently only has METER and YARD.

- **src/main/java/com.woodwing.calculator.exception**:<br/>
UnitNotSupportedException is used to throw error in case user somehow manage to get out of unit scope (e.g. inches).

- **src/main/java/com.example.calculator.service**:<br/>
Defines the CalculatorService interface and its implementation.

- **src/main/java/com.example.calculator.resource**:<br/>
Implements the RESTful API.

- **src/test/java/com.example.calculator.service**:<br/>
JUnit tests for the CalculatorServiceImpl class.

## Test Coverage

### CalculatorServiceImplTest

- **add()**: Tests the addition operation.
- **subtract()**: Tests the subtraction operation.
- **multiply()**: Tests the multiplication operation.
- **divide()**: Tests the division operation.

## How to run

1. **Clone the Repository:**

    ```bash
    git clone https://github.com/intenzemotion/calculator-back-end.git
    ```

2. **Navigate to the project directory:**

    ```bash
    cd calculator-back-end
    ```

3. **Build the Project:**

    ```bash
    mvn clean install
    ```

4. **Run the Application:**

    ```bash
    mvn spring-boot:run
    ```

## How to Test Using Curl

Make sure the application is running before executing the following `curl` commands.

### 1. Add

```bash
curl -X POST -H "Content-Type: application/json" -d '{"value1": 5.0, "unit1": "meter", "value2": 3.0, "unit2": "yard"}' http://localhost:8080/api/calculator/add
```

### 2. Substract

```bash
curl -X POST -H "Content-Type: application/json" -d '{"value1": 8.0, "unit1": "meter", "value2": 2.0, "unit2": "yard"}' http://localhost:8080/api/calculator/subtract
```

### 3. Multiply
```bash
curl -X POST -H "Content-Type: application/json" -d '{"value1": 4.0, "unit1": "meter", "value2": 2.5, "unit2": "yard"}' http://localhost:8080/api/calculator/multiply
```

### 4. Divide
```bash
curl -X POST -H "Content-Type: application/json" -d '{"value1": 9.0, "unit1": "meter", "value2": 3.0, "unit2": "yard"}' http://localhost:8080/api/calculator/divide
```

## Potential Improvements

- **Enhanced Validation:** Improve input validation to handle edge cases and provide more informative error messages.

- **Unit Testing:** Expand unit test coverage for both service and controller layers to ensure robustness.

- **Logging:** Implement comprehensive logging to aid in debugging and monitoring.

## Additional Notes

This project may seem "big" for a small requirement, but in the future, we will be able to expand it to work not only with unit measurements of length but also weight, speed, and so on. It may evolve into a full-fledged website with a variety of useful tools! Also, we can enhance the user interface for a more visually appealing experience :-D

## Contribution

If you'd like to contribute, feel free to fork the repository and submit a pull request. Please follow the coding standards and include appropriate tests.

## Issues

If you encounter any issues or have suggestions, please open an issue on the GitHub repository.

## License

This project is licensed under the [MIT License](LICENSE).
