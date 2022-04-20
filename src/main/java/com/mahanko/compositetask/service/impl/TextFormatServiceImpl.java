package com.mahanko.compositetask.service.impl;

import com.mahanko.compositetask.composite.TextComponent;
import com.mahanko.compositetask.composite.TextComposite;
import com.mahanko.compositetask.composite.TextCompositeLevel;
import com.mahanko.compositetask.service.TextFormatService;

public class TextFormatServiceImpl implements TextFormatService {

    @Override
    public void removeSentenceLessThan(TextComposite text, int wordAmount) {
        if (text.getLevel() == TextCompositeLevel.TEXT) {
            for (int i = 0; i < text.size(); i++) {
                TextComponent paragraphComponent = text.getChild(i);
                TextComposite paragraph = (TextComposite) paragraphComponent;
                for (int j = 0; j < paragraph.size(); j++) {
                    TextComposite sentence = (TextComposite) paragraph.getChild(j);
                    if (sentence.size() < wordAmount) {
                        paragraph.removeChild(sentence);
                        j--;
                    }
                }
            }
        }
    }
}
