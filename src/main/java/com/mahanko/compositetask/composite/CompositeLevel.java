package com.mahanko.compositetask.composite;

public enum CompositeLevel {
    TEXT(""),
    PARAGRAPH("\t\n"),
    SENTENCE(""),
    LEXEME("\u0020"),
    WORD("");
    private final String value;
    CompositeLevel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
