package parsertests;

import humble.compiler.humbleLexer;
import humble.compiler.humbleParser;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author nickpeck
 */
public class CompoundExpressionsTest {

    @Test
    public void testOrderOfOperators() throws RecognitionException {
        String result;
        ANTLRStringStream char_stream = new ANTLRStringStream("(3+5/4)");
        humbleLexer lexer = new humbleLexer(char_stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        humbleParser parser = new humbleParser(tokens);
        result = parser.compound_expression();
        System.out.println(result);
        if (!result.toString().equals("(plus.call( new _Number(3), divide.call( new _Number(5),  new _Number(4))))")) {
            fail();
        }
    }

    @Test
    public void testOrderOfOperators2() throws RecognitionException {
        String result;
        ANTLRStringStream char_stream = new ANTLRStringStream("(3-5*4)");
        humbleLexer lexer = new humbleLexer(char_stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        humbleParser parser = new humbleParser(tokens);
        result = parser.compound_expression();
        System.out.println(result);
        if (!result.toString().equals("(minus.call( new _Number(3), multiply.call( new _Number(5),  new _Number(4))))")) {
            fail();
        }
    }

    @Test
    public void testOrderOfOperators3() throws RecognitionException {
        String result;
        ANTLRStringStream char_stream = new ANTLRStringStream("(3-5/4)");
        humbleLexer lexer = new humbleLexer(char_stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        humbleParser parser = new humbleParser(tokens);
        result = parser.compound_expression();
        System.out.println(result);
        if (!result.toString().equals("(minus.call( new _Number(3), divide.call( new _Number(5),  new _Number(4))))")) {
            fail();
        }
    }

    @Test
    public void testOrderOfOperators4() throws RecognitionException {
        String result;
        ANTLRStringStream char_stream = new ANTLRStringStream("(3+5/4)");
        humbleLexer lexer = new humbleLexer(char_stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        humbleParser parser = new humbleParser(tokens);
        result = parser.compound_expression();
        System.out.println(result);
        if (!result.toString().equals("(plus.call( new _Number(3), divide.call( new _Number(5),  new _Number(4))))")) {
            fail();
        }
    }
}
