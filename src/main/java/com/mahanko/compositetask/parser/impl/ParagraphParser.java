package com.mahanko.compositetask.parser.impl;

import com.mahanko.compositetask.composite.TextComponent;
import com.mahanko.compositetask.composite.TextComposite;
import com.mahanko.compositetask.composite.TextCompositeLevel;
import com.mahanko.compositetask.parser.ParserChainLink;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements ParserChainLink {
    private static final String SENTENCE_DELIMITER_REGEX = ".+?[!?.…]";
    private final ParserChainLink successor = new SentenceParser();

    @Override
    public TextComponent parse(String dataString) {
        TextComposite paragraph = new TextComposite(TextCompositeLevel.PARAGRAPH);
        Pattern sentencePattern = Pattern.compile(SENTENCE_DELIMITER_REGEX);
        Matcher matcher = sentencePattern.matcher(dataString);
        while (matcher.find()) {
            paragraph.addChild(successor.parse(matcher.group()));
        }
        return paragraph;
    }
}
