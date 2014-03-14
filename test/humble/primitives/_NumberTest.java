/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package humble.primitives;

import humble.runtime.Callable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nickpeck
 */
public class _NumberTest {

    @Test
    public void testConstructorInteger() {
        _Number n = new _Number(999);
        if (!(n.unwrap() == 999)) {
            fail("_Number(int) did not unwrap expected int value");
        }
        _Number n2 = new _Number(new Integer(999));
        if (!(n2.unwrap() == 999)) {
            fail("_Number(Integer) did not unwrap expected int value");
        }
    }

    @Test
    public void testConstructorFloat() {
        _Number n = new _Number(999F);
        if (!(n.unwrap() == 999F)) {
            fail("_Number(float) did not unwrap expected float value");
        }
        _Number n2 = new _Number(new Float(999));
        if (!(n2.unwrap() == 999F)) {
            fail("_Number(Float) did not unwrap expected float value");
        }
    }

    @Test
    public void testConstructorDouble() {
        _Number n = new _Number(999.0);
        if (!(n.unwrap() == 999.0)) {
            fail("_Number(double) did not unwrap expected double value");
        }
        _Number n2 = new _Number(new Double(999));
        if (!(n2.unwrap() == 999.0)) {
            fail("_Number(Double) did not unwrap expected double value");
        }
    }

    @Test
    public void testConstructorLong() {
        _Number n = new _Number(999L);
        if (!(n.unwrap() == 999L)) {
            fail("_Number(long) did not unwrap expected long value");
        }
        _Number n2 = new _Number(new Long(999));
        if (!(n2.unwrap() == 999L)) {
            fail("_Number(Long) did not unwrap expected long value");
        }
    }

    @Test
    public void testNumberBindReturnsNumber() {
        _Number n = new _Number(999);
        Callable c = new _Number(9999).bindTo(n);
        if (!(c instanceof _Number)) {
            fail("_Number.bind() did not return a _Number");
        }
        if (!(n.unwrap() == 999)){
            fail("_Number.bind() did not return expected Number value");
        }
    }
}