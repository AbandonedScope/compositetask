package com.mahanko.compositetask.service.impl;

import com.mahanko.compositetask.composite.TextComponent;
import com.mahanko.compositetask.composite.TextComposite;
import com.mahanko.compositetask.composite.TextCompositeLevel;
import com.mahanko.compositetask.service.ParagraphSortService;

import java.util.Comparator;

public class ParagraphSortServiceImpl implements ParagraphSortService {
    @Override
    public void sort(TextComposite text, Comparator<TextComponent> comparator) {
        if (text.getLevel() == TextCompositeLevel.TEXT) {
            text.getTextComponents().sort(comparator);
        }
    }
}
