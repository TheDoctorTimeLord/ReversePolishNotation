package com.company.Logic;

import com.company.Exceptions.OperationException;
import com.company.Exceptions.StackSizeException;
import com.company.Interfaces.Operation;
import com.company.Resources.StringConstants;

import java.util.EmptyStackException;
import java.util.Stack;

public class RPNSolver {
    public double solve(Iterable<String> expression) throws OperationException, StackSizeException {
        Stack<Double> stack = new Stack<>();
        Operations allOperations = new Operations();

        for(String part : expression) {
            try {
                double result = Float.parseFloat(part);
                stack.push(result);

            } catch (NumberFormatException passed) {

                Operation operation = allOperations.getOperationByString(part);

                try {
                    double left = stack.pop();
                    double right = stack.pop();
                    double result = operation.calculate(left, right);

                    stack.push(result);

                } catch (EmptyStackException ex) {
                    throw new StackSizeException(ex.getMessage(), ex);
                }
            }
        }

        if (stack.size() != 1)
            throw new StackSizeException(StringConstants.incorrectCountOperation);

        return stack.pop();
    }
}
