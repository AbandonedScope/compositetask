package com.mahanko.compositetask.parser.impl;

import com.mahanko.compositetask.composite.*;
import com.mahanko.compositetask.parser.ParserChainLink;

public class WordParser implements ParserChainLink {
    private final ParserChainLink symbolParser = new SymbolParser();

    @Override
    public Component parse(String dataString) {
        Composite word = new Composite(CompositeLevel.WORD);
        dataString.chars().forEach(symbol -> word.addChild(symbolParser.parse(Character.toString(symbol))));
        return word;
    }
}
