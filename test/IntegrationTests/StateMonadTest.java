package IntegrationTests;


import humble.primitives._Number;
import humble.primitives._String;
import humble.runtime.Callable;
import humble.runtime.HumbleRuntimeException;
import humble.runtime.Lambda;
import humble.runtime.Module;
import humble.runtime.StdLib;
import humble.runtime.monads.State;
import static humble.runtime.monads.State.call;
import static humble.runtime.monads.State.raise;
import static humble.runtime.monads.State.rollback;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author nickpeck
 */
public class StateMonadTest extends Module {

    public final static Lambda square_root = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable x = args[0];
            return multiply.call(x, x);
        }
    };
    
    @Test
    public void testStateMonad() throws HumbleRuntimeException{
        Callable result = yield(new State() {
            @Override
            public Callable call(final Callable... args) {
                return (new Lambda() {
                    @Override
                    protected final Callable evaluate(Callable... args) {
                        return raise.call(new _Number(10));
                    }
                }.bindTo(new Lambda() {
                    @Override
                    protected final Callable evaluate(Callable... args) {
                        final Callable x = args[0];
                        return call.call(x, square_root);
                    }
                }).bindTo(new Lambda() {
                    @Override
                    protected final Callable evaluate(Callable... args) {
                        final Callable x = args[0];
                        return call.call(x, new Lambda() {
                            @Override
                            protected final Callable evaluate(Callable... args) {
                                final Callable x = args[0];
                                return plus.call(x, new _Number(1));
                            }
                        });
                    }
                }).bindTo(new Lambda() {
                    @Override
                    protected final Callable evaluate(Callable... args) {
                        final Callable x = args[0];
                        return call.call(x, square_root);
                    }
                }).bindTo(new Lambda() {
                    @Override
                    protected final Callable evaluate(Callable... args) {
                        return rollback.call(args);
                    }
                })).call(args);
            }
        }.bindTo(new Lambda() {
            @Override
            protected final Callable evaluate(Callable... args) {
                final Callable x = args[0];
                return listToStr.call(x, new _String(""));
            }
        }));

        //expected result [101.0,[100.0,10.0]]
        //System.out.println(result.toString());
        if (!(result.toString().equals("[101.0,[100.0,10.0]]"))) {
            fail("testStateMonad returned incorrect value");
        }
    }

    @Override
    public Callable call(Callable... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
