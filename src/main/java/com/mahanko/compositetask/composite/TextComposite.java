package com.mahanko.compositetask.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TextComposite implements TextComponent {
    private final TextCompositeLevel level;
    private final List<TextComponent> textComponents;

    public TextComposite(TextCompositeLevel level) {
        this.level = level;
        textComponents = new ArrayList<>();
    }

    public int size() {
        return textComponents.size();
    }

    public TextCompositeLevel getLevel() {
        return level;
    }

    public List<TextComponent> getTextComponents() {
        return textComponents;
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
    public TextComponent getChild(int i) {
        return textComponents.get(i);
    }

    @Override
    public String toString() {
        String result = level.getValue();
        for (TextComponent textComponent : textComponents) {
            result = result.concat(textComponent.toString());
        }

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        TextComposite composite = (TextComposite) obj;
        return this.level.equals(composite.level) && Objects.equals(this.textComponents, composite.textComponents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, textComponents);
    }
}
