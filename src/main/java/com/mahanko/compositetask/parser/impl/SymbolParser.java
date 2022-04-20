package com.mahanko.compositetask.parser.impl;

import com.mahanko.compositetask.composite.*;
import com.mahanko.compositetask.parser.ParserChainLink;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolParser implements ParserChainLink {
    private static final String VOWEL_LETTER_REGEX = "[AaEeIiOoUu]";


    @Override
    public TextComponent parse(String dataString) {
        char symbol = dataString.charAt(0);
        SymbolType symbolType;
        if (Character.isDigit(symbol)) {
            symbolType = SymbolType.DIGIT;
        } else if (Character.isLetter(symbol)) {
            Pattern isVowel = Pattern.compile(VOWEL_LETTER_REGEX);
            Matcher matcher = isVowel.matcher(Character.toString(symbol));
            if (matcher.matches()) {
                symbolType = SymbolType.VOWEL;
            } else {
                symbolType = SymbolType.CONSONANT;
            }
        } else {
            symbolType = SymbolType.PUNCTUATION;
        }

        return new Symbol(symbol, symbolType);
    }
}
