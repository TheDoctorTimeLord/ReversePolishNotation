package com.company.Logic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ParserTest {
    Parser parser = new Parser();

    @Test
    public void testParseCorrectLine() {
        String input = "2 3 + 1 -";
        List<String> answer = Arrays.asList("2", "3", "+", "1", "-");

        List<String> result = parser.parse(input);
        assertEquals(answer, result);
    }

    @Test
    public void testStringWithExtraSpaces() {
        String input = "  2  3    + 1 - ";
        List<String> answer = Arrays.asList("2", "3", "+", "1", "-");

        List<String> result = parser.parse(input);
        assertEquals(answer, result);
    }

    @Test
    public void testEmptyString() {
        String input = "";
        List<String> answer = new ArrayList<>();

        List<String> result = parser.parse(input);
        assertEquals(answer, result);
    }

    @Test
    public void testStringWithOtherSymbols() {
        String input = "56a asf #$% 1";
        List<String> answer = Arrays.asList("56a", "asf", "#$%", "1");

        List<String> result = parser.parse(input);
        assertEquals(answer, result);
    }

    @Test
    public void testDifferentSpaceSymbols() {
        String input = "2 3\t+\t1 -";
        List<String> answer = Arrays.asList("2", "3", "+", "1", "-");

        List<String> result = parser.parse(input);
        assertEquals(answer, result);
    }
}