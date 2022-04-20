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

    public SymbolType getType() {
        return type;
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
    public TextComponent getChild(int i) {
        logger.log(Level.ERROR, "Unsupported operation. You can not get any component from the symbol component.");
        throw new UnsupportedOperationException("Unsupported operation. You can not get any component from the symbol component.");
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public String toString() {
        return Character.toString(symbol);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Symbol symbol = (Symbol) o;
        return  this.symbol == symbol.symbol && type == symbol.type;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + (int) symbol;
        return result;
    }
}
