package com.mahanko.compositetask;

import com.mahanko.compositetask.converter.FromInfixToPostfixConverter;
import com.mahanko.compositetask.exception.CustomCompositeException;
import com.mahanko.compositetask.interpreter.Context;
import com.mahanko.compositetask.interpreter.MathematicalExpression;
import com.mahanko.compositetask.interpreter.PolishNotationOperator;

import java.util.List;

public class Main {
    public static void main(String[] args) throws CustomCompositeException {
//        CustomFileReader reader = new CustomFileReaderImpl();
//        String tet = reader.read("D:\\Epam Java\\compositetask\\src\\main\\resources\\dataFile.txt");
//        ParserChainLink parser = new TextParser();
//        Composite text = (Composite) parser.parse(tet);
//        System.out.println(text.toString());
        String exp = "(-3*(5+5))";
        FromInfixToPostfixConverter converter = new FromInfixToPostfixConverter();
        List<String> r = converter.convert(exp);
        Context context = new Context();
        PolishNotationOperator operator = new PolishNotationOperator();
        List<MathematicalExpression> expressions = operator.defineSequence(r);
        expressions.forEach(expression -> expression.interpret(context));
        System.out.print(context.pop() +"\n");
        for (String str: r
             ) {
            System.out.print(str + " ");
        }
    }
}
