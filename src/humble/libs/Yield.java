package humble.libs;

import humble.primitives._Boolean;
import humble.primitives._Class;
import humble.runtime.Callable;
import humble.runtime.FuturePromise;
import humble.runtime.HumbleRuntimeException;
import humble.runtime.Lambda;
import humble.runtime.Module;
import humble.runtime._Exception;

/**
 * Yield is a special module that enables us to break out of lazy evaluation.
 * The behaviour is somewhat different from standard modules. An example, in
 * pseudo-code, is: Yield( yield(some expression...) -> {catch any error
 * here...} ) -> callback
 *
 * The function callback is executed ASYCHRONOUSLY. The return type of 'Yield'
 * is itself.
 *
 * Runtime exceptions only manifest themselves when attempt is called.
 *
 * If the result of attempt is an Exception and you do not catch this in the
 * error handling code, the callback will NOT be executed and the exception will
 * be thrown, terminating that thread.
 *
 * @author nickpeck
 */
public abstract class Yield extends Module {

    /**
     * Function that immediately evaluates and expression to its most finite
     * value.
     */
    public static final Callable attempt = new Callable() {
        @Override
        public Callable call(Callable... args) {
            Callable result = args[0];
            while (result instanceof FuturePromise) {
                result = result.call();
            }
            return result;
        }

        @Override
        public Callable bindTo(final Callable a) {

            final Callable parent = this;
            return new Callable() {
                @Override
                public Callable call(Callable... args) {
                    Callable result = parent.call(args);
                    return a.call(result);
                }

                @Override
                public Callable bindTo(Callable a) {
                    throw new UnsupportedOperationException("Not supported yet.");
                }

            };
        }
    };
    /**
     * grab(<error_type>, callable, callback) - if callable is an error of type
     * error_type, execute the callback and return the result otherwise, just
     * return callable. This allows grab to be chained.
     */
    public static final Callable grab = new Callable() {
        @Override
        public Callable call(Callable... args) {
            _Class t = (_Class) args[0];
            Callable obj = args[1];
            Callable callback = args[2];
            if (obj.getClass().equals(t.unwrap())) {
                return callback.call(args);
            }
            return obj;
        }

        @Override
        public Callable bindTo(final Callable a) {

            final Callable parent = this;
            return new Callable() {
                @Override
                public Callable call(Callable... args) {
                    Callable result = parent.call(args);
                    return a.call(result);
                }

                @Override
                public Callable bindTo(Callable a) {
                    throw new UnsupportedOperationException("Not supported yet.");
                }
            };
        }
    };

    /**
     * Enforce that anything bound to Yield should happen as an asynchronous
     * callback. In addition, if the value being passed out of Yield results in
     * an HumbleRuntimeException, it will be thrown and the program will
     * terminate.
     *
     * @param a
     * @return
     */
    @Override
    public Callable bindTo(final Callable a) {

        final Callable parent = this;
        new Thread(new Runnable() {
            @Override
            public void run() {

                new Lambda() {
                    @Override
                    protected Callable evaluate(Callable... args) throws HumbleRuntimeException {

                        Callable result = parent.call(args).call();

                        if (result instanceof _Exception) {
                            ((_Exception) result).unwrap().printStackTrace();
                            System.exit(1);
                            throw new HumbleRuntimeException(((_Exception) result).unwrap());
                        }

                        return a.call(result);
                    }
                }.call().call();
            }
        }).start();

        return this;//it actually just returns itself.
    }
}
