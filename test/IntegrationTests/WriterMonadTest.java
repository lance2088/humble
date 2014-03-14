package IntegrationTests;


import humble.primitives._Number;
import humble.primitives._String;
import humble.runtime.Callable;
import humble.runtime.HumbleRuntimeException;
import humble.runtime.Lambda;
import humble.runtime.Module;
import humble.runtime.StdLib;
import humble.runtime.monads.Writer;
import static humble.runtime.monads.Writer.call;
import static humble.runtime.monads.Writer.raise;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author nickpeck
 */
public class WriterMonadTest extends Module {

    @Test
    public void testWriterMonad() throws HumbleRuntimeException{
        Callable result = yield(new Writer() {
            @Override
            public Callable call(final Callable... args) {
                return (new Lambda() {
                    @Override
                    protected final Callable evaluate(Callable... args) {
                        return call.call(raise.call(new _Number(10)), new Lambda() {
                            @Override
                            protected final Callable evaluate(Callable... args) {
                                final Callable x = args[0];
                                return plus.call(x, new _Number(1));
                            }
                        }, new _String(" added 1 "));
                    }
                }.bindTo(new Lambda() {
                    @Override
                    protected final Callable evaluate(Callable... args) {
                        final Callable result = args[0];
                        return call.call(result, new Lambda() {
                            @Override
                            protected final Callable evaluate(Callable... args) {
                                final Callable x = args[0];
                                return plus.call(x, new _Number(1));
                            }
                        }, new _String(" added 1 "));
                    }
                }).bindTo(new Lambda() {
                    @Override
                    protected final Callable evaluate(Callable... args) {
                        final Callable result = args[0];
                        return call.call(result, new Lambda() {
                            @Override
                            protected final Callable evaluate(Callable... args) {
                                final Callable x = args[0];
                                return multiply.call(x, x);
                            }
                        }, new _String(" square root "));
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

        
        if (!(result.toString().equals("[144.0,[ added 1 , added 1 , square root ]]"))) {
            fail("testStateMonad returned incorrect value");
        }
    }

    @Override
    public Callable call(Callable... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
