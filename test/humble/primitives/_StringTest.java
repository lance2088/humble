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
public class _StringTest {

    @Test
    public void testConstructorString() {
        _String b = new _String("Hello, world");
        if (!b.unwrap().equals("Hello, world")) {
            fail("_String did not unwrap expected String value");
        }
    }

    @Test
    public void testConstructorWBoolean() {
        _String b = new _String(new _Boolean(true));
        if (!b.unwrap().equals("true")) {
            fail("_String(new _Boolean(true)) did not unwrap expected String value");
        }
    }

    @Test
    public void testConstructorWNumber() {
        _String b = new _String(new _Number(999));
        if (!b.unwrap().equals("999.0")) {
            fail("_String(new _Number(999)) did not unwrap expected String value");
        }
    }

    @Test
    public void testBooleanBindReturnsBoolean() {
        _String b = new _String("Hello, world");
        Callable c = new _String("").bindTo(b);
        if (!(c instanceof _String)) {
            fail("_String.bind() did not return a _String");
        }
        if (!(((_String) c).unwrap().equals("Hello, world"))) {
            fail("_String(true).bind() did not return expected String value");
        }
    }
}