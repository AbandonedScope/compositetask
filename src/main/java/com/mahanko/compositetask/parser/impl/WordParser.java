package com.mahanko.compositetask.parser.impl;

import com.mahanko.compositetask.composite.*;
import com.mahanko.compositetask.parser.ParserChainLink;

public class WordParser implements ParserChainLink {
    private final ParserChainLink successor = new SymbolParser();

    @Override
    public TextComponent parse(String dataString) {
        TextComposite word = new TextComposite(TextCompositeLevel.WORD);
        dataString.chars().forEach(symbol -> word.addChild(successor.parse(Character.toString(symbol))));
        return word;
    }
}
