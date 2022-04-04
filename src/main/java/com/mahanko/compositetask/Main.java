package com.mahanko.compositetask;

import com.mahanko.compositetask.composite.TextComposite;
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
        TextComposite text = (TextComposite) parser.parse(tet);
        System.out.println(text.toString());
//        String exp = "(-3*(5+5))";
//        FromInfixToPostfixConverter converter = new FromInfixToPostfixConverter();
//        List<String> r = converter.convert(exp);
//        Context context = new Context();
//        PolishNotationOperator operator = new PolishNotationOperator();
//        List<MathematicalExpression> expressions = operator.defineSequence(r);
//        expressions.forEach(expression -> expression.interpret(context));
//        System.out.print(context.pop() +"\n");
//        for (String str: r
//             ) {
//            System.out.print(str + " ");
//        }
    }
}
