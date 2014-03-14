/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package humble.javahumblebridge;

import humble.primitives._List;
import humble.primitives._Number;
import humble.primitives._String;
import humble.runtime.Callable;
import humble.runtime.Lambda;
import humble.runtime.monads.Writer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author nickpeck
 */
public class JavaHumbleBridgeTest {

    public interface IWriter {

        Callable raise(Callable value);

        Callable call(Callable writer, Lambda modifier, _String log_msg);

        _String get_log(Callable writer);

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
    public void testRun() {
        IWriter writer = bridgeFactory.getBridge();
        
        Callable w = writer.raise(new _Number(2));
        
       writer.call(w, new Lambda(){
            @Override
            protected Callable evaluate(Callable... args) throws Exception {
                _Number x = (_Number)args[0];
                return new _Number(x.unwrap() + 2);
            }
        }, new _String("Added 2"));
       
       System.out.println(writer.get_log(w));
       
       System.out.println(writer.get_value(w));
    }


}