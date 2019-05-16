package com.company.Logic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public List<String> parse(String line) {
        return Arrays.stream(line
                    .trim()
                    .split("\\s"))
                .filter(str -> !str.isEmpty())
                .collect(Collectors.toList());
    }
}
