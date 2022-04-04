package com.mahanko.compositetask.parser.impl;

import com.mahanko.compositetask.composite.*;
import com.mahanko.compositetask.parser.ParserChainLink;

public class SymbolParser implements ParserChainLink {

    @Override
    public TextComponent parse(String dataString) {
        char symbol = dataString.charAt(0);
        SymbolType symbolType;
        if (Character.isDigit(symbol)) {
            symbolType = SymbolType.DIGIT;
        } else if (Character.isLetter(symbol)) {
            symbolType = SymbolType.LETTER;
        } else {
            symbolType = SymbolType.PUNCTUATION;
        }

        return new Symbol(symbol, symbolType);
    }
}
