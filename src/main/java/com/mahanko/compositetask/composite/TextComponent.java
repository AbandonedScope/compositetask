package com.mahanko.compositetask.composite;

public interface TextComponent {
    boolean addChild(TextComponent child);

    boolean removeChild(TextComponent child);

    TextComponent getChild(int i);

    int size();

    @Override
    String toString();

    @Override
    boolean equals(Object obj);

    @Override
    int hashCode();
}
