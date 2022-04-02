package com.mahanko.compositetask.parser.impl;

import com.mahanko.compositetask.composite.Component;
import com.mahanko.compositetask.composite.Composite;
import com.mahanko.compositetask.composite.CompositeLevel;
import com.mahanko.compositetask.parser.ParserChainLink;

public class MathExpressionParser implements ParserChainLink {
    private final ParserChainLink symbolParser = new SymbolParser();

    @Override
    public Component parse(String dataString) {
        Composite mathExpression = new Composite(CompositeLevel.MATH_EXPRESSION);
        dataString.chars().forEach(symbol -> mathExpression.addChild(symbolParser.parse(Character.toString(symbol))));
        return mathExpression;
    }
}
