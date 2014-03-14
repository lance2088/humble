/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegrationTests;

import humble.primitives._Number;
import humble.primitives._String;
import humble.runtime.Callable;
import humble.runtime.HumbleRuntimeException;
import humble.runtime.Lambda;
import humble.runtime.Module;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author nickpeck
 */
public class CurriedApplicationTest extends Module {

    public final static Lambda curry = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable x = args[0];
            return new Lambda() {
                @Override
                protected final Callable evaluate(Callable... args) {
                    final Callable y = args[0];
                    return new Lambda() {
                        @Override
                        protected final Callable evaluate(Callable... args) {
                            final Callable z = args[0];
                            return str_cat.call(x, y, z);
                        }
                    };
                }
            };
        }
    };

    public final static Lambda curry3 = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable x = args[0];
            return new Lambda() {
                @Override
                protected final Callable evaluate(Callable... args) {
                    final Callable y = args[0];
                    return plus.call(y, new _Number(2));
                }
            }.bindTo(new Lambda() {
                @Override
                protected final Callable evaluate(Callable... args) {
                    return (new Lambda() {
                        @Override
                        protected final Callable evaluate(Callable... args) {
                            final Callable e = args[0];
                            return plus.call(e, x);
                        }
                    }).call(args);
                }
            });
        }
    };

    /**
     @curry(x) ::
        \(y) ::
          \(z) ::
            str_cat(x,y,z)
       ;
     */
    @Test
    public void testCurry1() throws HumbleRuntimeException{
        Callable result = yield(curry.call(new _String("hello")).call(new _String("-")).call(new _String("world")));
        if (!(result instanceof _String)) {
            fail("testCurry1 did not return a _String");
        }
        if (!result.toString().equals("hello-world")) {
            fail("testCurry1 returned incorrect value");
        }
    }

    /**
     * @curry3(x) ::  \(y) :: y + 2 -> (\(e) :: e + x);
     */
    @Test
    public void testCurry2() throws HumbleRuntimeException{
        Callable result = yield(curry3.call(new _Number(1)).call(new _Number(2)));
        if (!(result instanceof _Number)) {
            fail("testCurry2 did not return a _Number");
        }
        if (((_Number) result).unwrap() != 5) {
            fail("testCurry2 returned incorrect value");
        }
    }

    @Override
    public Callable call(Callable... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
