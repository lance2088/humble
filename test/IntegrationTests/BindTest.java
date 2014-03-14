package IntegrationTests;

import humble.libs.IO;
import humble.primitives._Number;
import humble.runtime.Callable;
import humble.runtime.HumbleRuntimeException;
import humble.runtime.Lambda;
import humble.runtime.Module;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author nickpeck
 */
public class BindTest extends Module {

    public final static Lambda testbind = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable x = args[0];
            return plus.call(x, new _Number(2)).bindTo(new Lambda() {
                @Override
                protected final Callable evaluate(Callable... args) {
                    final Callable y = args[0];
                    return plus.call(y, new _Number(2));
                }
            }).bindTo(new Lambda() {
                @Override
                protected final Callable evaluate(Callable... args) {
                    final Callable z = args[0];
                    return plus.call(z, new _Number(2));
                }
            }).bindTo(new Lambda() {
                @Override
                protected final Callable evaluate(Callable... args) {
                    return new IO() {
                        @Override
                        public Callable call(final Callable... args) {
                            return (new Lambda() {
                                @Override
                                protected final Callable evaluate(Callable... args) {
                                    final Callable x = args[0];
                                    return print_out.call(x);
                                }
                            }).call(args);
                        }
                    }.call(args);
                }
            });
        }
    };

    /**
     @testbind(x)::
	x + 2 -> \(y) :: y + 2 -> \(z) :: z + 2
    ;
     */
    @Test
    public void testBind() throws HumbleRuntimeException{
        Callable result = yield(testbind.call(new _Number(1)));
        if (!(result instanceof _Number)) {
            fail("testbind did not return a _Number");
        }
        if (((_Number) result).unwrap() != 7) {
            fail("testbind returned incorrect value");
        }
    }

    @Override
    public Callable call(Callable... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
