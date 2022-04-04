package com.mahanko.compositetask.interpreter;

import java.util.ArrayList;
import java.util.List;

public class PolishNotationOperator {
    private PolishNotationOperator() {
    }

    public static List<MathematicalExpression> defineSequence(List<String> polishNotationTokens) {
        List<MathematicalExpression> expressions = new ArrayList<>();
        polishNotationTokens.forEach(token -> {
            switch (token) {
                case "+":
                    expressions.add(context -> context.push(context.pop() + context.pop()));
                    break;
                case "-":
                    expressions.add(context -> {
                        Double subtrahend = context.pop();
                        Double minuend = context.pop();
                        context.push(minuend - subtrahend);
                    });
                    break;
                case "*":
                    expressions.add(context -> context.push(context.pop() * context.pop()));
                    break;
                case "/":
                    expressions.add(context -> {
                        Double divisor = context.pop();
                        Double dividend = context.pop();
                        context.push(dividend / divisor);
                    });
                    break;
                default:
                    expressions.add(context -> context.push(Double.parseDouble(token)));
                    break;
            }
        });

        return expressions;
    }
}
