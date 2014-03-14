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
public class DereferenceTest {

    @Test
    public void testDerefernceRecognised() throws RecognitionException {
        LinkedList<String> result;
        ANTLRStringStream char_stream = new ANTLRStringStream("a as [b,c,d]");
        humbleLexer lexer = new humbleLexer(char_stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        humbleParser parser = new humbleParser(tokens);
        result = parser.dereference();
        System.out.println(result.size());
        if (result.size() != 4) {
            fail();
        }
    }
}
