/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegrationTests;

import humble.primitives._Boolean;
import humble.primitives._Number;
import humble.runtime.Callable;
import humble.runtime.Conditional;
import humble.runtime.HumbleRuntimeException;
import humble.runtime.Lambda;
import humble.runtime.Module;
import humble.runtime.StdLib;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nickpeck
 */
public class FactorialTest extends Module {

    public final static Lambda _factorial = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable n = args[0];
            final Callable accumulator = args[1];
            return new Conditional() {
                @Override
                public final _Boolean condition() throws HumbleRuntimeException{
                    return (_Boolean) yield(equals.call(n, new _Number(0)));
                }

                @Override
                public final Callable onIf() {
                    return accumulator;
                }

                @Override
                public final Callable onElse() {
                    return _factorial.call(minus.call(n, new _Number(1)), multiply.call(n, accumulator));
                }
            }.call();
        }
    };
    public final static Lambda factorial = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable n = args[0];
            return _factorial.call(n, new _Number(1));
        }
    };

    @Test(timeout = 1000)
    public void TestFactorial0() throws HumbleRuntimeException{
        Callable result = yield(factorial.call(new _Number(0)));
        if (!(result instanceof _Number)) {
            fail("TestFactorial0 did not return a number");
        }
        if (((_Number) result).unwrap() != 1.0) {
            fail("TestFactorial0 returned incorrect value");
        }
    }

    @Test(timeout = 1000)
    public void TestFactorial100() throws HumbleRuntimeException{
        Callable result = yield(factorial.call(new _Number(100)));
        if (!(result instanceof _Number)) {
            fail("TestFactorial10 did not return a number");
        }
        if (((_Number) result).unwrap() != 9.332621544394418E157) {
            fail("TestFactorial10 returned incorrect value");
        }
    }

    @Override
    public Callable call(Callable... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
