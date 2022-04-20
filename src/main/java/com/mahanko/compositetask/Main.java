package com.mahanko.compositetask;

import com.mahanko.compositetask.composite.TextComposite;
import com.mahanko.compositetask.exception.CustomCompositeException;
import com.mahanko.compositetask.parser.ParserChainLink;
import com.mahanko.compositetask.parser.impl.TextParser;
import com.mahanko.compositetask.reader.CustomFileReader;
import com.mahanko.compositetask.reader.impl.CustomFileReaderImpl;
import com.mahanko.compositetask.service.SentenceFindService;
import com.mahanko.compositetask.service.impl.SentenceFindServiceImpl;

public class Main {
    public static void main(String[] args) throws CustomCompositeException {
        CustomFileReader reader = new CustomFileReaderImpl();
        String tet = reader.read("D:\\Epam Java\\compositetask\\src\\main\\resources\\dataFile.txt");
        ParserChainLink parser = new TextParser();
        TextComposite text = (TextComposite) parser.parse(tet);
        SentenceFindService find = new SentenceFindServiceImpl();
        System.out.println(find.findWithLongestWord(text).toString());
    }
}
