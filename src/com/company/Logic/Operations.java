package com.company.Logic;

import com.company.Exceptions.OperationException;
import com.company.Interfaces.Operation;

import java.util.HashMap;
import java.util.Map;

public class Operations {
    private final Map<String, Operation> operations = new HashMap<>();

    public Operations() {
        operations.put("+", this::sum);
        operations.put("-", this::subtraction);
        operations.put("*", this::multiplication);
        operations.put("/", this::division);
    }

    public Operation getOperationByString(String operation) throws OperationException {
        if (operations.containsKey(operation))
            return operations.get(operation);
        throw new OperationException("Has not operation: " + operation);
    }

    private double sum(double left, double right) {
        return left + right;
    }

    private double subtraction(double left, double right) {
        return left - right;
    }

    private double multiplication(double left, double right) {
        return left * right;
    }

    private double division(double left, double right) throws OperationException {
        if (new Double(right).equals((double) 0))
            throw new OperationException("Division on zero (left operand:" + left + ", right operand: " + right + ")");
        return left / right;
    }
}
