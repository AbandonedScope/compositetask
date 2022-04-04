package com.mahanko.compositetask.composite;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent { // TODO: 04.04.2022 hashCode, equals
    private final TextCompositeLevel level;
    private final List<TextComponent> textComponents;

    public TextComposite(TextCompositeLevel level) {
        this.level = level;
        textComponents = new ArrayList<>();
    }

    @Override
    public boolean addChild(TextComponent child) {
        return textComponents.add(child);
    }

    @Override
    public boolean removeChild(TextComponent child) {
        return textComponents.remove(child);
    }

    @Override
    public String toString() {
        String result = level.getValue();
        for (TextComponent textComponent : textComponents) {
            result = result.concat(textComponent.toString());
        }

        return result;
    }

}
