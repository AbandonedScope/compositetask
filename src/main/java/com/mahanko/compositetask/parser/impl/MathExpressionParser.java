package com.mahanko.compositetask.parser.impl;

import com.mahanko.compositetask.composite.TextComponent;
import com.mahanko.compositetask.composite.TextComposite;
import com.mahanko.compositetask.composite.TextCompositeLevel;
import com.mahanko.compositetask.converter.FromInfixToPostfixConverter;
import com.mahanko.compositetask.interpreter.Context;
import com.mahanko.compositetask.interpreter.MathematicalExpression;
import com.mahanko.compositetask.interpreter.PolishNotationOperator;
import com.mahanko.compositetask.parser.ParserChainLink;

import java.util.List;

public class MathExpressionParser implements ParserChainLink {
    private final ParserChainLink successor = new SymbolParser();

    @Override
    public TextComponent parse(String dataString) {
        TextComposite mathExpression = new TextComposite(TextCompositeLevel.MATH_EXPRESSION);
        List<String> polishFormTokens = FromInfixToPostfixConverter.convert(dataString);
        List<MathematicalExpression> expressions = PolishNotationOperator.defineSequence(polishFormTokens);
        Context context = new Context();
        expressions.forEach(expression -> expression.interpret(context));
        dataString = context.pop().toString();
        dataString.chars().forEach(symbol -> mathExpression.addChild(successor.parse(Character.toString(symbol))));
        return mathExpression;
    }
}
