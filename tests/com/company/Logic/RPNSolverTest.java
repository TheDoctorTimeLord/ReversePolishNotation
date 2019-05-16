package com.company.Logic;

import com.company.Exceptions.OperationException;
import com.company.Exceptions.StackSizeException;
import com.company.Logic.RPNSolver;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class RPNSolverTest {
    RPNSolver solver = new RPNSolver();

    @Test
    public void testAddOperation() throws StackSizeException, OperationException {
        Iterable<String> expression = Arrays.asList("1", "2", "+");
        double answer = 3.0;

        double result = solver.solve(expression);

        assertEquals(answer, result);
    }

    @Test
    public void testSubtractionOperation() throws StackSizeException, OperationException {
        Iterable<String> expression = Arrays.asList("1", "2", "-");
        double answer = 1.0;

        double result = solver.solve(expression);

        assertEquals(answer, result);
    }

    @Test
    public void testMultiplicationOperation() throws StackSizeException, OperationException {
        Iterable<String> expression = Arrays.asList("1", "2", "*");
        double answer = 2.0;

        double result = solver.solve(expression);

        assertEquals(answer, result);
    }

    @Test
    public void testDivisionOperation() throws StackSizeException, OperationException {
        Iterable<String> expression = Arrays.asList("1", "2", "/");
        double answer = 2.0;

        double result = solver.solve(expression);

        assertEquals(answer, result);
    }

    @Test
    public void testSeveralOperations() throws StackSizeException, OperationException {
        Iterable<String> expression = Arrays.asList("15", "7", "1", "1", "+", "-", "/", "3", "*", "2", "1", "1", "+", "+", "-");
        double answer = 5.0;

        double result = solver.solve(expression);

        assertEquals(answer, result);
    }

    @Test
    public void testOtherFormRPN() throws StackSizeException, OperationException {
        Iterable<String> expression = Arrays.asList("3", "5", "4", "+", "/");
        double answer = 3.0;

        double result = solver.solve(expression);

        assertEquals(answer, result);
    }

    @Test
    public void testFloatResult() throws StackSizeException, OperationException {
        Iterable<String> expression = Arrays.asList("2", "9", "/");
        double answer = 4.5;

        double result = solver.solve(expression);

        assertEquals(answer, result);
    }

    @Test(expected = OperationException.class)
    public void testDivisionByZero() throws StackSizeException, OperationException {
        Iterable<String> expression = Arrays.asList("0", "9", "/");

        solver.solve(expression);
    }

    @Test(expected = OperationException.class)
    public void testIncorrectNumber() throws StackSizeException, OperationException {
        Iterable<String> expression = Arrays.asList("2,1", "9", "/");

        solver.solve(expression);
    }

    @Test(expected = OperationException.class)
    public void testIncorrectOperation() throws StackSizeException, OperationException {
        Iterable<String> expression = Arrays.asList("2", "1", "=");

        solver.solve(expression);
    }

    @Test(expected = StackSizeException.class)
    public void testInsufficientOperands() throws StackSizeException, OperationException {
        Iterable<String> expression = Arrays.asList("2", "-");

        solver.solve(expression);
    }

    @Test(expected = StackSizeException.class)
    public void testMoreOperandThenNeed() throws StackSizeException, OperationException {
        Iterable<String> expression = Arrays.asList("2", "2", "+", "2");

        solver.solve(expression);
    }

    @Test(expected = StackSizeException.class)
    public void testIncorrectOrderOfParts() throws StackSizeException, OperationException {
        Iterable<String> expression = Arrays.asList("-", "2", "2");

        solver.solve(expression);
    }

    @Test(expected = StackSizeException.class)
    public void testEmptyExpression() throws StackSizeException, OperationException {
        Iterable<String> expression = new ArrayList<>();

        solver.solve(expression);
    }
}
