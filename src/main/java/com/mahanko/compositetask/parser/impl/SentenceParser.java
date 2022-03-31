package com.mahanko.compositetask.parser.impl;

import com.mahanko.compositetask.composite.Component;
import com.mahanko.compositetask.composite.Composite;
import com.mahanko.compositetask.composite.CompositeLevel;
import com.mahanko.compositetask.parser.ParserChainLink;

import java.util.List;

public class SentenceParser implements ParserChainLink {
    private static final String LEXEME_DELIMITER_REGEX = "\\s+";
    private final ParserChainLink lexemeParser = new LexemeParser();

    @Override
    public Component parse(String dataString) {
        Composite sentence = new Composite(CompositeLevel.SENTENCE);
        List<String> lexemeStrings = List.of(dataString.split(LEXEME_DELIMITER_REGEX));
        lexemeStrings.forEach(lexeme -> sentence.addChild(lexemeParser.parse(lexeme)));
        return sentence;
    }
}
