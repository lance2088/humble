package humble.libs;

import static humble.libs.Yield.attempt;
import humble.runtime.Callable;
import humble.runtime.HumbleRuntimeException;
import humble.runtime.Lambda;
import humble.runtime.Module;

/**
 * Module for IO-related functions. All IO-related actions break out of lazy
 * evaluation
 *
 * @author nickpeck
 */
public abstract class IO extends Yield {

    public static final Callable print_out = new Callable() {
        @Override
        public Callable call(final Callable... args) {
            /*Callable result = args[0];
             try {
             result = yield(args[0]);//must yield the hidden result
             System.out.println(result.toString());
             } catch (HumbleRuntimeException ex) {
             System.out.println(ex.toString());
             System.exit(1);
             }
             return result;*/
            Callable result = args[0];
            result = attempt.call(result);//must yield the hidden result
            System.out.println(result.toString());
            return result;
        }

        /**
         * This is provided for semantic purposes only.
         */
        @Override
        public Callable bindTo(Callable a) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
    public static final Callable print_err = new Callable() {
        @Override
        public Callable call(final Callable... args) {
            /*Callable result = args[0].call();//TODO need to call yield here
             System.err.println(result.toString());
             return args[0];*/
            Callable result = args[0];
            result = attempt.call(result);//must yield the hidden result
            System.out.println(result.toString());
            return result;
        }

        /**
         * This is provided for semantic purposes only.
         */
        @Override
        public Callable bindTo(Callable a) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
}
