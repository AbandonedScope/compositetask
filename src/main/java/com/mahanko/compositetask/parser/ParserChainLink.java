package com.mahanko.compositetask.parser;

import com.mahanko.compositetask.composite.TextComponent;

public interface ParserChainLink {
    TextComponent parse(String dataString);
}
