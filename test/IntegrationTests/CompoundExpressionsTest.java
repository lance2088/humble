package IntegrationTests;

import humble.primitives._Boolean;
import humble.primitives._List;
import humble.primitives._Number;
import humble.runtime.Callable;
import humble.runtime.HumbleRuntimeException;
import humble.runtime.Module;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nickpeck
 */
public class CompoundExpressionsTest extends Module {

    private static _List result;

    /**
     * [
     * 5 + 6 * 4, 7 * 8 + (3*3), 9 + 16 - 15, 12 / 6 + 10, 6 + (9/3), (2*2*2) *
     * (3+7), true & true, true & false, false & false, true | true, true |
     * false, false | false, !true, !false ]
     *
     * expected results = [29, 65, 10, 12, 9, 80, true, true, false, true, true,
     * false, false, true]
     */
    @BeforeClass
    public static void setup() {
        result = new _List(
                plus.call(new _Number(5), multiply.call(new _Number(6), new _Number(4))),
                plus.call(multiply.call(new _Number(7), new _Number(8)), (multiply.call(new _Number(3), new _Number(3)))),
                minus.call(plus.call(new _Number(9), new _Number(16)), new _Number(15)),
                plus.call(divide.call(new _Number(12), new _Number(6)), new _Number(10)),
                plus.call(new _Number(6), (divide.call(new _Number(9), new _Number(3)))),
                multiply.call((multiply.call(multiply.call(new _Number(2), new _Number(2)), new _Number(2))), (plus.call(new _Number(3), new _Number(7)))),
                and.call(new _Boolean(true), new _Boolean(true)),
                and.call(new _Boolean(true), new _Boolean(false)),
                and.call(new _Boolean(false), new _Boolean(false)),
                or.call(new _Boolean(true), new _Boolean(true)),
                or.call(new _Boolean(true), new _Boolean(false)),
                or.call(new _Boolean(false), new _Boolean(false)),
                not.call(new _Boolean(true)),
                not.call(new _Boolean(false)));
    }

    @Test
    public void plusMultiply() throws HumbleRuntimeException{
        if (((_Number) yield(result.get(0))).unwrap() != 29.0) {
            fail("plusMultipy");
        }
    }

    @Test
    public void plusMultiply2() throws HumbleRuntimeException{
        if (((_Number) yield(result.get(1))).unwrap() != 65.0) {
            fail("plusMultipy2");
        }
    }

    @Test
    public void plusMinus() throws HumbleRuntimeException{
        if (((_Number) yield(result.get(2))).unwrap() != 10.0) {
            fail("plusMinus");
        }
    }

    @Test
    public void divPlus() throws HumbleRuntimeException{
        if (((_Number) yield(result.get(3))).unwrap() != 12.0) {
            fail("divPlus");
        }
    }

    @Test
    public void compoundExprplusDiv() throws HumbleRuntimeException{
        if (((_Number) yield(result.get(4))).unwrap() != 9.0) {
            fail("compoundExprplusDiv");
        }
    }

    @Test
    public void compoundExprMult() throws HumbleRuntimeException{
        if (((_Number) yield(result.get(5))).unwrap() != 80.0) {
            fail("compoundExprMult");
        }
    }

    @Test
    public void trueAndTrue() throws HumbleRuntimeException{
        if (((_Boolean) yield(result.get(6))).unwrap() != true) {
            fail("trueAndTrue");
        }
    }

    @Test
    public void trueAndFalse() throws HumbleRuntimeException{
        if (((_Boolean) yield(result.get(7))).unwrap() != false) {
            fail("trueAndFalse");
        }
    }

    @Test
    public void falseAndFalse() throws HumbleRuntimeException{
        if (((_Boolean) yield(result.get(8))).unwrap() != false) {
            fail("falseAndFalse");
        }
    }

    @Test
    public void trueOrTrue() throws HumbleRuntimeException{
        if (((_Boolean) yield(result.get(9))).unwrap() != true) {
            fail("trueOrTrue");
        }
    }

    @Test
    public void trueOrFalse() throws HumbleRuntimeException{
        if (((_Boolean) yield(result.get(10))).unwrap() != true) {
            fail("trueOrFalse");
        }
    }

    @Test
    public void falseOrFalse() throws HumbleRuntimeException{
        if (((_Boolean) yield(result.get(11))).unwrap() != false) {
            fail("falseOrFalse");
        }
    }

    @Test
    public void notTrue() throws HumbleRuntimeException{
        if (((_Boolean) yield(result.get(12))).unwrap() != false) {
            fail("notTrue");
        }
    }

    @Test
    public void notFalse() throws HumbleRuntimeException{
        if (((_Boolean) yield(result.get(13))).unwrap() != true) {
            fail("notFalse");
        }
    }

    @Override
    public Callable call(Callable... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
