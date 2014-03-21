/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package humble.javahumblebridge;

import humble.primitives._List;
import humble.primitives._Number;
import humble.primitives._String;
import humble.runtime.Callable;
import humble.runtime.HumbleRuntimeException;
import humble.runtime.Lambda;
import humble.runtime.Module;
import static humble.runtime.StdLib.yield;
import humble.runtime.monads.Writer;
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
public class JavaHumbleBridgeTest extends Module {

    @Override
    public Callable call(Callable... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public interface IWriter {

        Callable raise(Callable value);

        Callable call(Callable writer, Lambda modifier, _String log_msg);

        _List get_log(Callable writer);

        Callable get_value(Callable writer);
    }
    private JavaHumbleBridge<IWriter, Writer> bridgeFactory = new JavaHumbleBridge(IWriter.class, Writer.class);

    public JavaHumbleBridgeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testRun1() throws HumbleRuntimeException {
        IWriter writer = bridgeFactory.getBridge();

        Callable w = writer.raise(new _Number(2));

        Callable result = yield(writer.call(w, new Lambda() {
            @Override
            protected Callable evaluate(Callable... args) throws Exception {
                _Number x = (_Number) args[0];
                return new _Number(x.unwrap() + 2);
            }
        }, new _String("Added 2")));

        System.out.println(result);

        if (((_Number) writer.get_value(result)).unwrap() != 4.0) {
            fail("Writer monad returned wrong value, should have been 4.0");
        }
    }

    @Test
    public void testRun2() throws HumbleRuntimeException {
        IWriter writer = bridgeFactory.getBridge();

        Callable w = writer.raise(new _Number(2));

        Callable res = yield(writer.call(w, new Lambda() {
            @Override
            protected Callable evaluate(Callable... args) throws Exception {
                _Number x = (_Number) args[0];
                return new _Number(x.unwrap() + 2);
            }
        }, new _String("Added 2")));

        System.out.println(res);

        _List log = writer.get_log(res);

        _String result = (_String) log.get(0);

        if (!result.unwrap().equals("Added 2")) {
            fail("Writer monad returned wrong log value,"
                    + " should have been 'Added 2'");
        }
    }
}