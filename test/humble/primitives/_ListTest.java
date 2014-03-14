package humble.primitives;

import humble.runtime.Callable;
import java.util.LinkedList;
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
public class _ListTest {

    @Test
    public void testConstructorVarArgs() {
        _List l = new _List(new _String("Hello world"), new _Number(100), new _Boolean(true));
        LinkedList<Callable> res = l.unwrap();
        if (!(res.get(0) instanceof _String)) {
            fail("Test of _List constructorVarArgs");
        }
        if (!(res.get(1) instanceof _Number)) {
            fail("Test of _List constructorVarArgs");
        }
        if (!(res.get(2) instanceof _Boolean)) {
            fail("Test of _List constructorVarArgs");
        }
    }

    @Test
    public void testConstructorList() {
        LinkedList<Callable> args = new LinkedList();
        args.add(new _String("Hello world"));
        args.add(new _Number(100));
        args.add(new _Boolean(true));
        _List l = new _List(args);
        LinkedList<Callable> res = l.unwrap();
        if (!(res.get(0) instanceof _String)) {
            fail("Test of _List constructorList");
        }
        if (!(res.get(1) instanceof _Number)) {
            fail("Test of _List constructorList");
        }
        if (!(res.get(2) instanceof _Boolean)) {
            fail("Test of _List constructorList");
        }
    }

    @Test
    public void testToString() {
        _List l = new _List(new _String("Hello world"), new _Number(100), new _Boolean(true));
        String res = l.toString();
        if(!res.equals("[Hello world,100.0,true]")) {
            fail("Test of _List testToString");
        }
    }
}