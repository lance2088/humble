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
public class ListSliceTest {
        @Test
    public void testListSliceTestRecognised() throws RecognitionException {
        LinkedList<String> result;
        ANTLRStringStream char_stream = new ANTLRStringStream("a as [b:c]");
        humbleLexer lexer = new humbleLexer(char_stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        humbleParser parser = new humbleParser(tokens);
        result = parser.list_slice();
        System.out.println(result.size());
        if (result.size() != 3) {
            fail();
        }
    }
}
