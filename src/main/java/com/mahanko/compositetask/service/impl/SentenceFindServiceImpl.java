package com.mahanko.compositetask.service.impl;

import com.mahanko.compositetask.composite.TextComponent;
import com.mahanko.compositetask.composite.TextComposite;
import com.mahanko.compositetask.composite.TextCompositeLevel;
import com.mahanko.compositetask.service.SentenceFindService;

public class SentenceFindServiceImpl implements SentenceFindService {

    @Override
    public TextComponent findWithLongestWord(TextComposite text) {
        TextComposite resultSentence = null;
        if (text.getLevel() == TextCompositeLevel.TEXT) {
            int wordLength = 0;
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
                                    if (lexemPartComposite.getLevel() == TextCompositeLevel.WORD
                                            && lexemPartComposite.size() > wordLength) {
                                        wordLength = lexemPartComposite.size();
                                        resultSentence = sentence;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return resultSentence;
    }
}
