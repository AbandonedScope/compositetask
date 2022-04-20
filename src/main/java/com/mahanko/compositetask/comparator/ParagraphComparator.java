package com.mahanko.compositetask.comparator;

import com.mahanko.compositetask.composite.TextComponent;

import java.util.Comparator;

public class ParagraphComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        int result;
        if (o1.equals(o2)) {
            result = 0;
        } else if (o1.size() > o2.size()) {
            result = 1;
        } else {
            result = -1;
        }

        return result;
    }
}
