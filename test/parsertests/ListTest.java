/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsertests;

import humble.compiler.humbleLexer;
import humble.compiler.humbleParser;
import java.util.LinkedList;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author nickpeck
 */
public class ListTest {

    @Test
    public void testDerefernceRecognised() throws RecognitionException {
        StringBuilder result;
        ANTLRStringStream char_stream = new ANTLRStringStream("[a,3]");
        humbleLexer lexer = new humbleLexer(char_stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        humbleParser parser = new humbleParser(tokens);
        result = parser.list();
        System.out.println(result);
        if (!result.toString().equals(" new _List(a,  new _Number(3))")) {
            fail();
        }
    }

    @Test
    public void testDerefernceRecognised2() throws RecognitionException {
        StringBuilder result;
        ANTLRStringStream char_stream = new ANTLRStringStream("[a]");
        humbleLexer lexer = new humbleLexer(char_stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        humbleParser parser = new humbleParser(tokens);
        result = parser.list();
        System.out.println(result);
        if (!result.toString().equals(" new _List(a)")) {
            fail();
        }
    }

    @Test
    public void testDerefernceRecognised3() throws RecognitionException {
        StringBuilder result;
        ANTLRStringStream char_stream = new ANTLRStringStream("[]");
        humbleLexer lexer = new humbleLexer(char_stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        humbleParser parser = new humbleParser(tokens);
        result = parser.list();
        System.out.println(result);
        if (!result.toString().equals(" new _List()")) {
            fail();
        }
    }
}
