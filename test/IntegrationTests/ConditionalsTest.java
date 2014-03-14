/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegrationTests;

import humble.primitives._Boolean;
import humble.primitives._List;
import humble.primitives._Number;
import humble.primitives._String;
import humble.runtime.Callable;
import humble.runtime.Conditional;
import humble.runtime.HumbleRuntimeException;
import humble.runtime.Lambda;
import humble.runtime.Module;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author nickpeck
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({IntegrationTests.CurriedApplicationTest.class, IntegrationTests.CompoundExpressionsTest.class, IntegrationTests.IntegrationTestsSuite.class, IntegrationTests.StateMonadTest.class, IntegrationTests.FactorialTest.class, IntegrationTests.WriterMonadTest.class, IntegrationTests.BindTest.class, IntegrationTests.ItteratorTest.class})
public class ConditionalsTest extends Module {

    public final static Lambda validation_chain = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable n = args[0];
            final Callable filters = ((_List) args[1]);
            final Callable Head = list_head.call(((_List) args[1]));
            final Callable Tail = list_tail.call(((_List) args[1]));
            return new Conditional() {
                @Override
                public final _Boolean condition() throws HumbleRuntimeException{
                    return (_Boolean) yield(equals.call(length.call(filters), new _Number(0)));
                }

                @Override
                public final Callable onIf() {
                    return new _Boolean(true);
                }

                @Override
                public final Callable onElse() {
                    return new Conditional() {
                        @Override
                        public final _Boolean condition() throws HumbleRuntimeException{
                            return (_Boolean) yield(Head.call(n));
                        }

                        @Override
                        public final Callable onIf() {
                            return validation_chain.call(n, Tail);
                        }

                        @Override
                        public final Callable onElse() {
                            return new _Boolean(false);
                        }
                    }.call();
                }
            }.call();
        }
    };
    public final static Lambda test_upr_boundary = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable n = args[0];
            return less_than.call(n, new _Number(100));
        }
    };
    public final static Lambda test_lwr_boundary = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable n = args[0];
            return gtr_than.call(n, new _Number(20));
        }
    };
    public final static Lambda test_equ_50 = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            final Callable n = args[0];
            return equals.call(n, new _Number(50));
        }
    };
    public final static Lambda test1 = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            return new Conditional() {
                @Override
                public final _Boolean condition() throws HumbleRuntimeException{
                    return (_Boolean) yield(validation_chain.call(new _Number(50), new _List(test_upr_boundary, test_lwr_boundary, test_equ_50)));
                }

                @Override
                public final Callable onIf() {
                    return new _String("Validation OK");
                }

                @Override
                public final Callable onElse() {
                    return new _String("Validation Failed");
                }
            }.call();
        }
    };
    public final static Lambda test2 = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            return new Conditional() {
                @Override
                public final _Boolean condition() throws HumbleRuntimeException {
                    return (_Boolean) yield(validation_chain.call(new _Number(101), new _List(test_upr_boundary, test_lwr_boundary, test_equ_50)));
                }

                @Override
                public final Callable onIf() {
                    return new _String("Validation OK");
                }

                @Override
                public final Callable onElse() {
                    return new _String("Validation Failed");
                }
            }.call();
        }
    };
    public final static Lambda test3 = new Lambda() {
        @Override
        protected final Callable evaluate(Callable... args) {
            return new Conditional() {
                @Override
                public final _Boolean condition() throws HumbleRuntimeException{
                    return (_Boolean) yield(validation_chain.call(new _Number(19), new _List(test_upr_boundary, test_lwr_boundary, test_equ_50)));
                }

                @Override
                public final Callable onIf() {
                    return new _String("Validation OK");
                }

                @Override
                public final Callable onElse() {
                    return new _String("Validation Failed");
                }
            }.call();
        }
    };

    @Test
    public void TestConditionals1() throws HumbleRuntimeException{
        Callable result = yield(test1.call());
        if (!result.toString().equals("Validation OK")) {
            fail("TestConditionals1 unexpected result");
        }
    }

    @Test
    public void TestConditionals2() throws HumbleRuntimeException{
        Callable result = yield(test2.call());
        if (!result.toString().equals("Validation Failed")) {
            fail("TestConditionals2 unexpected result");
        }
    }

    @Test
    public void TestConditionals3() throws HumbleRuntimeException{
        Callable result = yield(test2.call());
        if (!result.toString().equals("Validation Failed")) {
            fail("TestConditionals3 unexpected result");
        }
    }

    @Override
    public Callable call(Callable... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}