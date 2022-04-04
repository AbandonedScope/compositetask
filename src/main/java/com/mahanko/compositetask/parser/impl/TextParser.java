package com.mahanko.compositetask.parser.impl;

import com.mahanko.compositetask.composite.TextComponent;
import com.mahanko.compositetask.composite.TextComposite;
import com.mahanko.compositetask.composite.TextCompositeLevel;
import com.mahanko.compositetask.parser.ParserChainLink;

import java.util.List;

public class TextParser implements ParserChainLink {
    private static final String PARAGRAPH_DELIMITER_REGEX = "\\t";
    private final ParserChainLink successor = new ParagraphParser();

    @Override
    public TextComponent parse(String dataString) {
        TextComposite text = new TextComposite(TextCompositeLevel.TEXT);
        List<String> paragraphStrings = List.of(dataString.split(PARAGRAPH_DELIMITER_REGEX));
        paragraphStrings.forEach(paragraph ->
        {
            if (!paragraph.isEmpty()) {
                text.addChild(successor.parse(paragraph));
            }
        });
        return text;
    }
}
