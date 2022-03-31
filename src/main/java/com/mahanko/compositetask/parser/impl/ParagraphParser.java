package com.mahanko.compositetask.parser.impl;

import com.mahanko.compositetask.composite.Component;
import com.mahanko.compositetask.composite.Composite;
import com.mahanko.compositetask.composite.CompositeLevel;
import com.mahanko.compositetask.parser.ParserChainLink;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements ParserChainLink {
    private static final String SENTENCE_DELIMITER_REGEX = ".+?[!?.…]$";
    private final ParserChainLink sentenceParser = new SentenceParser();

    @Override
    public Component parse(String dataString) {
        Composite paragraph = new Composite(CompositeLevel.PARAGRAPH);
        Pattern sentencePattern = Pattern.compile(SENTENCE_DELIMITER_REGEX);
        Matcher matcher = sentencePattern.matcher(dataString);
        while (matcher.find()) {
            paragraph.addChild(sentenceParser.parse(matcher.group()));
        }
        return paragraph;
    }
}
