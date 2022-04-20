package com.mahanko.compositetask.service;

import com.mahanko.compositetask.composite.TextComponent;
import com.mahanko.compositetask.composite.TextComposite;

public interface SentenceFindService {
    TextComponent findWithLongestWord(TextComposite text);

}
