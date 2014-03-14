/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegrationTests;

import humble.libs.IO;
import static humble.libs.IO.print_out;
import humble.libs.Yield;
import static humble.libs.Yield.attempt;
import humble.primitives._Number;
import humble.primitives._String;
import humble.runtime.Callable;
import humble.runtime.HumbleRuntimeException;
import humble.runtime.Lambda;
import humble.runtime.StdLib;
import org.junit.Test;

/**
 *
 * @author nickpeck
 */
public class YieldTest extends StdLib {

    @Test
    public void testYield() {

        new Yield() {
            @Override
            public Callable call(Callable... args) {

                return attempt.call(plus.call(new _Number(2), new _Number(2)));
            }//we make no attempt to catch the error
        }.bindTo(new Lambda() {
            //the bound callable happens in a new thread - so it doesn't actually
            //get passed back up:
            @Override
            protected Callable evaluate(Callable... args) throws Exception {
                return new Yield() {
                    @Override
                    public Callable call(Callable... args) {
                        return new IO() {
                            @Override
                            public Callable call(Callable... args) {
                                return print_out.call(args[0]);
                            }
                        };
                    }
                }.call();

            }
        }).call();

    }

    @Test(expected = HumbleRuntimeException.class)
    public void testYieldThrowsUncaughtException() {

        new Yield() {
            @Override
            public Callable call(Callable... args) {
                //stupid expression - can't add a string and a number
                return attempt.call(plus.call(new _String("not a number!"), new _Number(2)));
            }//we make no attempt to catch the error
        }.bindTo(new Lambda() {
            //the bound callable happens in a new thread - so it doesn't actually
            //get passed back up:
            @Override
            protected Callable evaluate(Callable... args) throws Exception {

                return new Yield() {
                    @Override
                    public Callable call(Callable... args) {
                        return new IO() {
                            @Override
                            public Callable call(Callable... args) {
                                return print_out.call(args[0]);
                            }
                        };
                    }
                }.call();
            }
        }).call();
    }
}
