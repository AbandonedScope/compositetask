package com.mahanko.compositetask.composite;

public interface TextComponent {
    boolean addChild(TextComponent child);

    boolean removeChild(TextComponent child);

    @Override
    String toString();
}
