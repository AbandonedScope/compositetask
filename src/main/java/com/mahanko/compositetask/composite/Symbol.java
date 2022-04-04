package com.mahanko.compositetask.composite;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Symbol implements TextComponent {
    private static final Logger logger = LogManager.getLogger();

    private SymbolType type;
    private char symbol;

    public Symbol(char symbol, SymbolType type) {
        this.symbol = symbol;
        this.type = type;
    }

    @Override
    public boolean addChild(TextComponent child) {
        logger.log(Level.ERROR, "Unsupported operation. You can not put any component into the symbol component.");
        throw new UnsupportedOperationException("Unsupported operation. You can not put any component into the symbol component.");
    }

    @Override
    public boolean removeChild(TextComponent child) {
        logger.log(Level.ERROR, "Unsupported operation. You can not remove any component from the symbol component.");
        throw new UnsupportedOperationException("Unsupported operation. You can not remove any component from the symbol component.");
    }

    @Override
    public String toString() {
        return Character.toString(symbol);
    }
}
