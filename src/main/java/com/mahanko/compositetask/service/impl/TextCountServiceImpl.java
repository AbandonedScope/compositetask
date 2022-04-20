package com.mahanko.compositetask.service.impl;

import com.mahanko.compositetask.composite.*;
import com.mahanko.compositetask.service.TextCountService;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class TextCountServiceImpl implements TextCountService {
    @Override
    public Map<String, Integer> countWords(TextComposite text) {
        Map<String, Integer> result = new HashMap<>();
        if (text.getLevel() == TextCompositeLevel.TEXT) {
            for (int i = 0; i < text.size(); i++) {
                TextComponent paragraphComponent = text.getChild(i);
                TextComposite paragraph = (TextComposite) paragraphComponent;
                for (int j = 0; j < paragraph.size(); j++) {
                    TextComposite sentence = (TextComposite) paragraph.getChild(j);
                    for (int k = 0; k < sentence.size(); k++) {
                        TextComponent lexema = sentence.getChild(k);
                        if (lexema.getClass() == TextComposite.class) {
                            TextComposite lexemComposite = (TextComposite) lexema;
                            for (int z = 0; z < lexemComposite.size(); z++) {
                                TextComponent lexemPart = lexemComposite.getChild(z);
                                if (lexemPart instanceof TextComposite) {
                                    TextComposite lexemPartComposite = (TextComposite) lexemPart;
                                    if (lexemPartComposite.getLevel() == TextCompositeLevel.WORD) {
                                        String word = lexemPartComposite.toString().toLowerCase(Locale.ROOT);
                                        result.computeIfPresent(word, (key, value) -> ++value);
                                        result.putIfAbsent(word, 1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    @Override
    public Map<SymbolType, Integer> countLetters(TextComposite sentence) {
        Map<SymbolType, Integer> result = new HashMap<>();
        result.put(SymbolType.CONSONANT, 0);
        result.put(SymbolType.VOWEL, 0);
        if (sentence.getLevel() == TextCompositeLevel.SENTENCE) {
            for (int k = 0; k < sentence.size(); k++) {
                TextComponent lexema = sentence.getChild(k);
                if (lexema.getClass() == TextComposite.class) {
                    TextComposite lexemComposite = (TextComposite) lexema;
                    for (int z = 0; z < lexemComposite.size(); z++) {
                        TextComponent lexemPart = lexemComposite.getChild(z);
                        if (lexemPart instanceof TextComposite) {
                            TextComposite lexemPartComposite = (TextComposite) lexemPart;
                            for (int i = 0; i < lexemPartComposite.size(); i++) {
                                if (lexemPartComposite.getChild(i).getClass() == Symbol.class) {
                                    Symbol symbol = (Symbol) lexemPartComposite.getChild(i);
                                    if (symbol.getType() == SymbolType.CONSONANT) {
                                        result.computeIfPresent(SymbolType.CONSONANT, (key, value) -> ++value);
                                    } else if (symbol.getType() == SymbolType.VOWEL) {
                                        result.computeIfPresent(SymbolType.VOWEL, (key, value) -> ++value);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}
