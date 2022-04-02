package com.mahanko.compositetask.composite;

import com.mahanko.compositetask.converter.FromInfixToPostfixConverter;
import com.mahanko.compositetask.interpreter.Context;
import com.mahanko.compositetask.interpreter.MathematicalExpression;
import com.mahanko.compositetask.interpreter.PolishNotationOperator;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private final CompositeLevel level;
    private final List<Component> components;

    public Composite(CompositeLevel level) {
        this.level = level;
        components = new ArrayList<>();
    }

    @Override
    public boolean addChild(Component child) {
        return components.add(child);
    }

    @Override
    public boolean removeChild(Component child) {
        return components.remove(child);
    }

    @Override
    public String toString() {
        String result = level.getValue();
        for (Component component : components) {
            result = result.concat(component.toString());
        }
        if(level == CompositeLevel.MATH_EXPRESSION) {
            FromInfixToPostfixConverter converter = new FromInfixToPostfixConverter();
            PolishNotationOperator operator = new PolishNotationOperator();
            List<String> polishFormTokens = converter.convert(result);
            List<MathematicalExpression> expressions = operator.defineSequence(polishFormTokens);
            Context context = new Context();
            expressions.forEach(expression -> expression.interpret(context));
            result  = context.pop().toString();
        }

        return result;
    }

}
