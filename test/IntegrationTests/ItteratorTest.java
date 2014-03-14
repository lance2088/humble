/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegrationTests;

import humble.primitives._Boolean;
import humble.primitives._Number;
import humble.runtime.Conditional;
import humble.runtime.Lambda;

import humble.runtime.Callable;
import humble.runtime.HumbleRuntimeException;
import humble.runtime.Module;
import humble.runtime.StdLib;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nickpeck
 */
public class ItteratorTest extends Module {

    public final static Lambda iterator = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable x = args[0];
            final Callable y = args[1];
            return new Conditional() {
                @Override
                public final _Boolean condition() throws HumbleRuntimeException{
                    return (_Boolean) yield(equals.call(x, y));
                }

                @Override
                public final Callable onIf() {
                    return x;
                }

                @Override
                public final Callable onElse() {
                    return iterator.call(plus.call(x, new _Number(1)), y);
                }
            }.call();
        }
    };

    @Test(timeout=1000)
    public void testCountTo200000() throws HumbleRuntimeException{
        Callable result = yield(iterator.call(new _Number(11), new _Number(200000)));
        if(!(result instanceof _Number)){
            fail("testCountTo200000 did not return a number");
        }
        if (((_Number)result).unwrap() != 200000) {
            fail("testCountTo200000 returned incorrect value");
        }
    }

    @Override
    public Callable call(Callable... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
