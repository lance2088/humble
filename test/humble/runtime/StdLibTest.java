package humble.runtime;

import humble.primitives._List;
import humble.primitives._Number;
import humble.primitives._String;
import static humble.runtime.StdLib.filter;
import static humble.runtime.StdLib.glue;
import static humble.runtime.StdLib.map;
import static humble.runtime.StdLib.range;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nickpeck
 */
public class StdLibTest extends Module {

    @Test
    public void testPlus() throws HumbleRuntimeException{
        _Number result = (_Number) yield(StdLib.plus.call(new _Number(2), new _Number(2)));
        if (result.unwrap() != 4) {
            fail("testPlus");
        }
    }

    @Test
    public void testMinus() throws HumbleRuntimeException{
        _Number result = (_Number) yield(StdLib.minus.call(new _Number(4), new _Number(2)));
        if (result.unwrap() != 2) {
            fail("testMinus");
        }
    }

    @Test
    public void testDivide() throws HumbleRuntimeException{
        _Number result = (_Number) yield(StdLib.divide.call(new _Number(4), new _Number(2)));
        if (result.unwrap() != 2) {
            fail("testDivide");
        }
    }

    @Test
    public void testMultiply() throws HumbleRuntimeException{
        _Number result = (_Number) yield(StdLib.multiply.call(new _Number(4), new _Number(2)));
        if (result.unwrap() != 8) {
            fail("testDivide");
        }
    }

    @Test
    public void testFilter() throws HumbleRuntimeException{
        Callable result = yield(filter.call(new Lambda() {
            @Override
            protected final Callable evaluate(Callable... args) {
                final Callable a = args[0];
                return equals.call(a, new _Number(2));
            }
        }, new _List(new _Number(1), new _Number(2), new _Number(3), new _Number(4), new _Number(2), new _Number(6))));


        if (!(result instanceof _List)) {
            fail("testFilter did not return a _List");
        }
        if (((_List) result).size() != 2) {
            fail("testFilter result set was the wrong size ");
        }
        if (!((_List) result).toString().equals("[2.0,2.0]")) {
            fail("testFilter returned incorect result set");
        }
    }

    @Test
    public void testMap1() throws HumbleRuntimeException{
        Callable result = yield(map.call(new Lambda() {
            @Override
            protected final Callable evaluate(Callable... args) throws HumbleRuntimeException{
                final Callable a = args[0];
                return yield(plus.call(a, new _Number(1)));
            }
        }, new _List(new _Number(1), new _Number(2), new _Number(3), new _Number(4), new _Number(5), new _Number(6))));

        if (!(result instanceof _List)) {
            fail("testMap did not return a _List");
        }
        if (((_List) result).size() != 6) {
            fail("testMap result set was the wrong size");
        }
        if(!(((_List) result).get(0) instanceof FuturePromise)){
            fail("testMap did not evaluate in a lazy manner");
        }
        //nb, the computation is LAZY, therefore, we have to force yield on each list member
        if (!yield(((_List) result).get(0)).toString().equals("2.0")) {
            fail("testMap returned incorect result set");
        }
        if (!yield(((_List) result).get(1)).toString().equals("3.0")) {
            fail("testMap returned incorect result set");
        }
        if (!yield(((_List) result).get(2)).toString().equals("4.0")) {
            fail("testMap returned incorect result set");
        }
        if (!yield(((_List) result).get(5)).toString().equals("7.0")) {
            fail("testMap returned incorect result set");
        }

    }

    @Test
    public void testRange() throws HumbleRuntimeException{
        Callable result = yield(range.call(new _Number(0), new _Number(10)));
        if (!(result instanceof _List)) {
            fail("testRange did not return a _List");
        }
        if (((_List) result).size() != 11) {
            fail("testRange result set was the wrong size");
        }
        if (!((_List) result).toString().equals("[0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0]")) {
            fail("testRange returned incorect result set");
        }
    }

    @Test
    public void testGlue() throws HumbleRuntimeException{
        Callable result = yield(glue.call(new _String(" "), new _List(new _String("I"),
                new _String("like"), new _String("2"), new _String("boogie"))));
        if (!(result instanceof _String)) {
            fail("testGlue did not return a _String");
        }
        if (!result.toString().equals("I like 2 boogie")) {
            fail("testGlue result unexpected");
        }
    }

    @Override
    public Callable call(Callable... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}