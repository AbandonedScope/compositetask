package com.mahanko.compositetask.parser.impl;

import com.mahanko.compositetask.composite.Component;
import com.mahanko.compositetask.composite.Composite;
import com.mahanko.compositetask.composite.CompositeLevel;
import com.mahanko.compositetask.parser.ParserChainLink;

import java.util.List;

public class TextParser implements ParserChainLink {
    private static final String PARAGRAPH_DELIMITER_REGEX = "\\t";
    private final ParserChainLink paragraphParser = new ParagraphParser();

    @Override
    public Component parse(String dataString) {
        Composite text = new Composite(CompositeLevel.TEXT);
        List<String> paragraphStrings = List.of(dataString.split(PARAGRAPH_DELIMITER_REGEX));
        paragraphStrings.forEach(paragraph ->
        {
            if (!paragraph.isEmpty()) {
                text.addChild(paragraphParser.parse(paragraph));
            }
        });
        return text;
    }
}
