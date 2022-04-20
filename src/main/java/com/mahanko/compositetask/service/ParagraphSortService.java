package com.mahanko.compositetask.service;

import com.mahanko.compositetask.composite.TextComponent;
import com.mahanko.compositetask.composite.TextComposite;

import java.util.Comparator;

public interface ParagraphSortService {
    void sort(TextComposite text,  Comparator<TextComponent> comparator);
}
