package com.mahanko.compositetask.parser.impl;

import com.mahanko.compositetask.composite.TextComponent;
import com.mahanko.compositetask.composite.TextComposite;
import com.mahanko.compositetask.composite.TextCompositeLevel;
import com.mahanko.compositetask.parser.ParserChainLink;

import java.util.List;

public class SentenceParser implements ParserChainLink {
    private static final String LEXEME_DELIMITER_REGEX = "\\s+";
    private final ParserChainLink successor = new LexemeParser();

    @Override
    public TextComponent parse(String dataString) {
        TextComposite sentence = new TextComposite(TextCompositeLevel.SENTENCE);
        List<String> lexemeStrings = List.of(dataString.split(LEXEME_DELIMITER_REGEX));
        lexemeStrings.forEach(lexeme -> sentence.addChild(successor.parse(lexeme)));
        return sentence;
    }
}
