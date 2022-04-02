package com.mahanko.compositetask.interpreter;

@FunctionalInterface
public interface MathematicalExpression {
    void interpret(Context context);
}
