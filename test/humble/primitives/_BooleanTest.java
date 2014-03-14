/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package humble.primitives;

import humble.runtime.Callable;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nickpeck
 */
public class _BooleanTest {

    @Test
    public void testConstructorTrue() {
        _Boolean b = new _Boolean(true);
        if (!b.unwrap()) {
            fail("_Boolean did not unwrap correct Boolean value");
        }
    }

    @Test
    public void testConstructorFalse() {
        _Boolean b = new _Boolean(false);
        if (b.unwrap()) {
            fail("_Boolean did not unwrap correct Boolean value");
        }
    }

    @Test
    public void testBooleanBindReturnsBoolean() {
        _Boolean b = new _Boolean(true);
        Callable c = new _Boolean(true).bindTo(b);
        if (!(c instanceof _Boolean)) {
            fail("_Boolean.bind() did not return a _Boolean");
        }
        if (!(((_Boolean)c).unwrap())) {
            fail("_Boolean(true).bind() did not return a _Boolean(true)");
        }
    }
}