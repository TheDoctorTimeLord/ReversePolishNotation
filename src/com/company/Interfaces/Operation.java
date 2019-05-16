package com.company.Interfaces;

import com.company.Exceptions.OperationException;

public interface Operation {
    double calculate(double left, double right) throws OperationException;
}
