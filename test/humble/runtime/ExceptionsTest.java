package humble.runtime;

import humble.primitives._Boolean;
import humble.primitives._Number;
import humble.primitives._String;
import org.junit.Test;

/**
 *
 * @author nickpeck
 */
public class ExceptionsTest extends Module {

    @Test(expected = HumbleRuntimeException.class)
    public void testTypeErrorThrown() throws HumbleRuntimeException {
        yield(plus.call(new _String("Not a number..."), new _Number(5)));
    }
    
    @Test(expected = HumbleRuntimeException.class)
    public void testConditionalFailsWNonBooleanClause() throws HumbleRuntimeException{
        
        final Lambda bogusCondition = new Lambda(){

            @Override
            protected Callable evaluate(Callable... args) throws Exception {
                return new _String("This is not a _Boolean, so it should fail");
            }
        };
        
        Callable c = new Conditional(){

            @Override
            protected _Boolean condition() throws HumbleRuntimeException {
                //this may fool the java compiler, but it should trigger and exception
                return (_Boolean) yield(bogusCondition.call());
            }

            @Override
            protected Callable onIf() {
                return new _String("If was called - should not get here");
            }

            @Override
            protected Callable onElse() {
                return new _String("Else was called - should not get here");
            }
        }.call();
        
        yield(c.call());
    }

    @Override
    public Callable call(Callable... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
