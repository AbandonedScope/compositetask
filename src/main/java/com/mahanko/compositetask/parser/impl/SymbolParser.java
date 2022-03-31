package com.mahanko.compositetask.parser.impl;

import com.mahanko.compositetask.composite.*;
import com.mahanko.compositetask.parser.ParserChainLink;

public class SymbolParser implements ParserChainLink {

    @Override
    public Component parse(String dataString) {
        char symbol = dataString.charAt(0);
        CompositeSymbolType symbolType;
        if (Character.isDigit(symbol)) {
            symbolType = CompositeSymbolType.DIGIT;
        } else if (Character.isLetter(symbol)) {
            symbolType = CompositeSymbolType.LETTER;
        } else {
            symbolType = CompositeSymbolType.PUNCTUATION;
        }

        return new Symbol(symbol, symbolType);
    }
}
