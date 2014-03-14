/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package humble.runtime;

import humble.primitives._String;
import humble.primitives._Class;
import static humble.runtime.Module.yield;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author nickpeck
 */
//@RunWith(Suite.class)
//@Suite.SuiteClasses({humble.runtime.StdLibTest.class, humble.runtime.RuntimeTestSuite.class, humble.runtime.ExceptionsTest.class})
public class ClassTest extends StdLib {

    abstract class TestClass extends Module {

        private String a;
        private String b;

        public TestClass(String a, String b) {
            this.a = a;
            this.b = b;
        }

        public TestClass() {
            this.a = "Wrong ";
            this.b = " constructor";
        }

        public Callable foo() {
            return new _String("FOO!");
        }

        @Override
        public String toString() {
            return this.a + " " + this.b;
        }
    }

    @Test
    public void testTypeCall() throws HumbleRuntimeException {

        Callable result = yield(new _Class<TestClass>(TestClass.class).call(new _String("Hello"), new _String("world!")));
        System.out.println(result);
        if (!(result instanceof Primitive)) {
            fail("testTypeCall");
        }

    }

    @Test
    public void testTypeCall2() throws HumbleRuntimeException {

        Primitive result = (Primitive) yield(new _Class<TestClass>(TestClass.class).call(new _String("Hello"), new _String("world!")));
        Object res = result.unwrap();
        System.out.println(res);
        if (!res.toString().equals("Hello world!")) {
            fail("testTypeCall2");
        }

    }

    @Test
    public void testTypeCall3() throws HumbleRuntimeException {


        Primitive result = (Primitive) yield(
                new _Class<TestClass>(TestClass.class).call(
                new _String("Hello"), new _String("world!")).foo());
        Object res = result.unwrap();
        System.out.println(res);
        if (!res.toString().equals("FOO!")) {
            fail("testTypeCall3");
        }

    }
}