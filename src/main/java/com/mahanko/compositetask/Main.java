package com.mahanko.compositetask;

import com.mahanko.compositetask.exception.CustomCompositeException;
import com.mahanko.compositetask.parser.ParserChainLink;
import com.mahanko.compositetask.parser.impl.TextParser;
import com.mahanko.compositetask.reader.CustomFileReader;
import com.mahanko.compositetask.reader.impl.CustomFileReaderImpl;


public class Main {
    public static void main(String[] args) throws CustomCompositeException {
        CustomFileReader reader = new CustomFileReaderImpl();
        String tet = reader.read("D:\\Epam Java\\compositetask\\src\\main\\resources\\dataFile.txt");
        ParserChainLink parser = new TextParser();
    }
}
