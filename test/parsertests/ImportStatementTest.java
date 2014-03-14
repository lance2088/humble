package parsertests;

import humble.compiler.humbleLexer;
import humble.compiler.humbleParser;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.Assertion;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import static org.junit.Assert.*;

/**
 *
 * @author nickpeck
 */
public class ImportStatementTest {

    @Test
    public void importStatementRecognised() throws org.antlr.runtime.RecognitionException {
        String result;
        ANTLRStringStream char_stream = new ANTLRStringStream("import mypackage;");
        humbleLexer lexer = new humbleLexer(char_stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        humbleParser parser = new humbleParser(tokens);
        result = parser.import_statment().toString();
        if (!result.equals("import mypackage;")) {
            fail();
        }
    }
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void importStatementPackageImportFails() throws org.antlr.runtime.RecognitionException {
        String result;
        ANTLRStringStream char_stream = new ANTLRStringStream("import mypackage.*;");
        humbleLexer lexer = new humbleLexer(char_stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        humbleParser parser = new humbleParser(tokens);
        fail("Not implemented");
    }
}
