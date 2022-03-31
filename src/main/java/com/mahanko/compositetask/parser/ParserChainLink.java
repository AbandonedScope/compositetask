package com.mahanko.compositetask.parser;

import com.mahanko.compositetask.composite.Component;

public interface ParserChainLink {
    public Component parse(String dataString);
}
