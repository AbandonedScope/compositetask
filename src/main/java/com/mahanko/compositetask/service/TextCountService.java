package com.mahanko.compositetask.service;

import com.mahanko.compositetask.composite.SymbolType;
import com.mahanko.compositetask.composite.TextComponent;
import com.mahanko.compositetask.composite.TextComposite;
import java.util.Map;

public interface TextCountService {
    Map<String, Integer> countWords(TextComposite text);
    Map<SymbolType, Integer> countLetters(TextComposite sentence);
}
