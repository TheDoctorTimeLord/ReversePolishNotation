package com.company.Resources;

public class StringConstants {
    public static final String helpMessage = String.format("This is reverse polish notation solver. You can use these commands:\n- %s\n- %s\n- %s",
            StringConstants.expression,
            StringConstants.help,
            StringConstants.exit);

    public static final String nextCommand = "Please enter next command:";
    public static final String welcomeMessage = "Hello! This is reverse polish notation solver.\n" +
                                                StringConstants.helpMessage;
    public static final String enterExpression = "Please enter your expression:";
    public static final String result = "Your result: ";
    public static final String enter = ">>> ";

    public static final String expression = "Expression";
    public static final String help = "Help";
    public static final String exit = "Exit";

    public static final String incorrectCountOperation = "Incorrect count of operands";
    public static final String empty = "";

    public static final String unknownCommand = "Unknown command,\n" + StringConstants.helpMessage;
}
