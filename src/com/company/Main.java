package com.company;

import com.company.Exceptions.OperationException;
import com.company.Exceptions.StackSizeException;
import com.company.Logic.Parser;
import com.company.Logic.RPNSolver;
import com.company.Resources.StringConstants;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        RPNSolver solver = new RPNSolver();
        Parser parser = new Parser();
        boolean hasWorking = true;

        System.out.println(StringConstants.welcomeMessage);

        while (hasWorking) {
            System.out.println(StringConstants.nextCommand);
            System.out.print(StringConstants.enter);
            String command = input.nextLine();

            Command state = Command.parse(command);
            switch (state) {
                case Exit:
                    hasWorking = false;
                    break;

                case Help:
                    System.out.println(StringConstants.helpMessage);
                    break;

                case Expression:
                    System.out.println(StringConstants.enterExpression);
                    System.out.print(StringConstants.enter);
                    String line = input.nextLine();

                    List<String> expr = parser.parse(line);
                    try {
                        double result = solver.solve(expr);
                        System.out.print(StringConstants.result);
                        System.out.println(result);

                    } catch (OperationException | StackSizeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case Unknown:
                    System.out.println(StringConstants.unknownCommand);
                    break;
            }
        }
    }

    enum Command {
        Expression(StringConstants.expression),
        Help(StringConstants.help),
        Exit(StringConstants.exit),
        Unknown(StringConstants.empty);

        private String name;

        Command(String name) {
            this.name = name;
        }

        public static Command parse(String line) {
            for (Command command : Command.values()) {
                if (command.name.equals(line))
                    return command;
            }

            return Command.Unknown;
        }
    }
}
