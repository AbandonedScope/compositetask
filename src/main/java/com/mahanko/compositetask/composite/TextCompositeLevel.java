package com.mahanko.compositetask.composite;

public enum TextCompositeLevel {
    TEXT(""),
    PARAGRAPH("\t\n"),
    SENTENCE(""),
    LEXEME("\u0020"),
    MATH_EXPRESSION(""),
    WORD("");
    private final String value;

    TextCompositeLevel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
