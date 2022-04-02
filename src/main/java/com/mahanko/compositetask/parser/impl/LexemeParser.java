package com.mahanko.compositetask.parser.impl;

import com.mahanko.compositetask.composite.Component;
import com.mahanko.compositetask.composite.Composite;
import com.mahanko.compositetask.composite.CompositeLevel;
import com.mahanko.compositetask.parser.ParserChainLink;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser implements ParserChainLink {
    private static final String PUNCTUATION_REGEX = "\\p{Punct}";
    private static final String WORD_REGEX = "[\\w&&\\D]+";
    private static final String MATH_EXPRESSION_REGEX = "[\\d[+\\-*/()]]{3,}";
    private final ParserChainLink wordParser = new WordParser();
    private final ParserChainLink symbolParser = new SymbolParser();
    private final ParserChainLink mathOperationParser = new MathExpressionParser();

    @Override
    public Component parse(String dataString) {
        Composite lexeme = new Composite(CompositeLevel.LEXEME);
        Pattern mathOperation = Pattern.compile(MATH_EXPRESSION_REGEX);
        Matcher mathMatcher = mathOperation.matcher(dataString);
        if (mathMatcher.matches()) {
            lexeme.addChild(mathOperationParser.parse(dataString));
        } else {
            Pattern wordPattern = Pattern.compile(WORD_REGEX);
            Pattern punctuationPattern = Pattern.compile(PUNCTUATION_REGEX);
            Matcher wordMatcher = wordPattern.matcher(dataString);
            Matcher punctuationMatcher = punctuationPattern.matcher(dataString);
            int i = 0;
            int j = 0;
            while (wordMatcher.find(i) && punctuationMatcher.find(j)) {
                if (wordMatcher.start() < punctuationMatcher.start()) {
                    lexeme.addChild(wordParser.parse(wordMatcher.group()));
                    i = wordMatcher.end();
                } else {
                    lexeme.addChild(symbolParser.parse(punctuationMatcher.group()));
                    j = punctuationMatcher.end();
                }
            }

            while (wordMatcher.find(i)) {
                lexeme.addChild(wordParser.parse(wordMatcher.group()));
                i = wordMatcher.end();
            }

            while (punctuationMatcher.find(j)) {
                lexeme.addChild(symbolParser.parse(punctuationMatcher.group()));
                j = punctuationMatcher.end();
            }
        }

        return lexeme;
    }
}
