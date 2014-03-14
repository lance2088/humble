package humble.compiler;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.jar.Attributes;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import java.util.Arrays;
import java.util.jar.JarEntry;

/**
 * Main entry point for running the parser/compiler.
 *
 * @param args [filename] [flags] Enter no args to view help.
 * @author nickpeck
 */
public class Humble {

    private static Boolean debug = false;
    private static Boolean print = false;
    private static Boolean jar = false;
    private static String jarfilename = null;
    private static String mainclassname = null;

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                printUsage();
                System.exit(0);
            }

            if (Arrays.asList(args).contains("-debug") || Arrays.asList(args).contains("-d")) {
                debug = true;
            }
            if (Arrays.asList(args).contains("-print") || Arrays.asList(args).contains("-p")) {
                print = true;
            }
            if (Arrays.asList(args).contains("-j")) {
                int i = Arrays.asList(args).indexOf("-j");
                jarfilename = args[i + 1];
                jar = true;
            }
            if (Arrays.asList(args).contains("-m")) {
                int i = Arrays.asList(args).indexOf("-m");
                mainclassname = args[i + 1];
            }



            if (new File(args[0]).isFile()) {
                if (!compileSource(args[0])) {
                    System.err.println("[Humble] compile failed.");
                    System.exit(1);
                }
            } else if (new File(args[0]).isDirectory()) {

                for (File sourcefile : new File(args[0]).listFiles()) {
                    if (sourcefile.getName().endsWith(".hb")) {
                        if (!compileSource(sourcefile.getCanonicalPath())) {
                            System.err.println("[Humble] compile failed.");
                            System.exit(1);
                        }
                    }
                }

            } else {
                System.err.println(args[0] + " is not recognised as a source file or directory.");
                System.exit(1);
            }

            if (jar) {
                if (debug) {
                    System.out.println("[Humble] Packaging:");
                }

                Manifest manifest = new Manifest();
                manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
                if (mainclassname != null) {
                    manifest.getMainAttributes().put(Attributes.Name.MAIN_CLASS, mainclassname);
                }
                manifest.getMainAttributes().put(Attributes.Name.CLASS_PATH, "Humble.jar");
                JarOutputStream target = new JarOutputStream(new FileOutputStream(jarfilename), manifest);

                File[] listOfFiles = null;
                if (new File(args[0]).isFile()) {
                    listOfFiles = new File(new File(args[0]).getParent()).listFiles();
                } else if (new File(args[0]).isDirectory()) {
                    listOfFiles = new File(args[0]).listFiles();
                }
                for (File f : listOfFiles) {
                    if (debug) {
                        System.out.println("\t" + f);
                    }
                    addToJar(f, target);
                }

                target.close();
                System.out.println("[Humble] Created JAR");
            }
        } catch (IOException ex) {
            Logger.getLogger(Humble.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }

    private static Boolean compileSource(String filename) {

        if ((filename.endsWith(".class"))) {
            return false;
        }
        try {
            String javaCode = "";
            try {

                if (debug) {
                    System.out.println("-----------------------------------");
                    System.out.println("[Humble] Parsing file: " + filename);
                    javaCode = parse(filename);
                }

            } catch (IOException ex) {
                Logger.getLogger(Humble.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            } catch (RecognitionException ex) {
                Logger.getLogger(Humble.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }

            if (debug) {
                System.out.println("[Humble] Parsing complete");
            }
            File sourceFile = new File(filename);
            String moduleName = sourceFile.getPath().replace(System.getProperty("file.separator"), "/");

            if (debug) {
                System.out.println("[Humble] Compiling JVM code..." + moduleName);
            }

            if (print) {
                System.out.println("\n" + javaCode + "\n");
            }

            if (!Compiler.compile(moduleName, javaCode)) {
                System.out.println("[Humble] Compilation failed");
                return false;
            }

            System.out.println("[Humble] Compilation complete");

            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    private static void printUsage() {
        StringBuilder result = new StringBuilder();
        result.append("Humble compiler");
        result.append("\n usage:");
        result.append("\n     java -jar Humble.jar [sourcefile/folder] [options]");
        result.append("\n     OPTIONS:");
        result.append("\n");
        result.append("\n         -d / -debug   print debug info");
        result.append("\n         -p / -print   show generated code");
        result.append("\n         -j [JarFileName]     create jarfile");
        result.append("\n         -m [ClassName]     set main class (requires -j)");

        System.out.println(result.toString());
    }

    /**
     * Translate the source file into Java code.
     *
     * @param sourceFile path/name of the file containing source code to be
     * compiled
     * @return String containing Java Code or null if file not found, or parse
     * error.
     */
    private static String parse(String sourceFile)
            throws IOException, RecognitionException {
        String result;

        ANTLRFileStream char_stream = new ANTLRFileStream(sourceFile);
        humbleLexer lexer = new humbleLexer(char_stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        humbleParser parser = new humbleParser(tokens);
        parser.setModuleName(new File(sourceFile).getName().replace(".hb", ""));
        //System.out.println("NAME = " + new File(sourceFile).getName().replace(".hb", ""));
        result = parser.module().toString();

        return result;
    }

    private static void addToJar(File source, JarOutputStream target) throws IOException {
        BufferedInputStream in = null;
        try {
            if (source.isDirectory()) {
                String name = source.getPath().replace("\\", "/");
                if (!name.isEmpty()) {
                    if (!name.endsWith("/")) {
                        name += "/";
                    }
                    JarEntry entry = new JarEntry(name);
                    entry.setTime(source.lastModified());
                    target.putNextEntry(entry);
                    target.closeEntry();
                }
                for (File nestedFile : source.listFiles()) {
                    addToJar(nestedFile, target);
                }
                return;
            }

            JarEntry entry = new JarEntry(source.getPath().replace("\\", "/"));
            entry.setTime(source.lastModified());
            target.putNextEntry(entry);
            in = new BufferedInputStream(new FileInputStream(source));

            byte[] buffer = new byte[1024];
            while (true) {
                int count = in.read(buffer);
                if (count == -1) {
                    break;
                }
                target.write(buffer, 0, count);
            }
            target.closeEntry();
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
