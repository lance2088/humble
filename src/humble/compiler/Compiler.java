package humble.compiler;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject.Kind;



/**
 * Compiler class to invoke the system JDK using intermediary java code generated
 * using the Humble parser.
 * @author nickpeck
 */
public class Compiler {

    /**
     * Create a Java Class file from a given file path/name and source code string
     * package name as defined in the source must match the folder structure relative
     * to the current working directory.
     * @param fileName filename including relative path
     * @param code String representing the source code
     * @return boolean representing the outcome of the compilation.
     * @throws IOException 
     */
    public static boolean compile(String fileName, String code) throws IOException {
        
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector();
        JavaFileObject file = new JavaSourceFromString(fileName.replace(".hb", ""), code);
        Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(file);
        final Iterable<String> options = Arrays.asList( new String[] { "-d", "."} );
        CompilationTask task = compiler.getTask(null, null, diagnostics, options, null, compilationUnits);

        boolean success = task.call();
        
        for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
            System.out.println(diagnostic.getCode());
            System.out.println(diagnostic.getKind());
            System.out.println(diagnostic.getPosition());
            System.out.println(diagnostic.getStartPosition());
            System.out.println(diagnostic.getEndPosition());
            System.out.println(diagnostic.getSource());
            System.out.println(diagnostic.getMessage(null));
        }
        
        return success;
    }
}
class JavaSourceFromString extends SimpleJavaFileObject {

    final String code;

    JavaSourceFromString(String name, String code) {
        super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
        this.code = code;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return code;
    }
}